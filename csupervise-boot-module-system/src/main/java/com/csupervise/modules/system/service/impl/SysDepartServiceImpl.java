/*
 *
 *  *
 *  *      Copyright (c) 2020-2025, leiyz All rights reserved.
 *  *
 *  *  Redistribution and use in source and binary forms, with or without
 *  *  modification, are permitted provided that the following conditions are met:
 *  *
 *  * Redistributions of source code must retain the above copyright notice,
 *  *  this list of conditions and the following disclaimer.
 *  *  Redistributions in binary form must reproduce the above copyright
 *  *  notice, this list of conditions and the following disclaimer in the
 *  *  documentation and/or other materials provided with the distribution.
 *  *  Neither the name of leiyz developer nor the names of its
 *  *  contributors may be used to endorse or promote products derived from
 *  *  this software without specific prior written permission.
 *  *  Author: leiyz (lyz88119@126.com)
 *  *
 *
 *
 */
package com.csupervise.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csupervise.common.api.vo.Result;
import com.csupervise.modules.system.entity.SysDepart;
import com.csupervise.modules.system.entity.SysUserDepart;
import com.csupervise.modules.system.mapper.SysDepartMapper;
import com.csupervise.modules.system.mapper.SysUserDepartMapper;
import com.csupervise.modules.system.service.ISysDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 组织机构表 服务实现类
 * </p>
 *
 * @Author: leiyz
 * @since 2020-05-11
 */
@Service
public class SysDepartServiceImpl extends ServiceImpl<SysDepartMapper, SysDepart> implements ISysDepartService {
    @Autowired
    private SysUserDepartMapper userDepartMapper;

    /**
     * delete 方法调用
     *
     * @param id
     * @param idList
     */
    private void checkChildrenExists(String id, List<String> idList) {
        LambdaQueryWrapper<SysDepart> query = new LambdaQueryWrapper<SysDepart>();
        query.eq(SysDepart::getParentId, id);
        List<SysDepart> departList = this.list(query);
        if (departList != null && departList.size() > 0) {
            for (SysDepart depart : departList) {
                idList.add(depart.getId());
                this.checkChildrenExists(depart.getId(), idList);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Boolean> deleteDepartWithChild(String id) {
        List<String> idList = new ArrayList<>();
        idList.add(id);
        this.checkChildrenExists(id, idList);
        LambdaQueryWrapper<SysUserDepart> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(SysUserDepart::getDepId).in(SysUserDepart::getDepId
                , idList);
        List<SysUserDepart> userDeprt =
                userDepartMapper.selectList(lambdaQueryWrapper);
        if (userDeprt != null && userDeprt.size() > 0) {
            return Result.fail("已有用户关联当前部门，无法删除！");
        }
        //根据部门id删除用户与部门关系
        userDepartMapper.delete(new LambdaQueryWrapper<SysUserDepart>().in(SysUserDepart::getDepId, idList));
        this.baseMapper.deleteBatchIds(idList);
        return Result.success("删除成功");
    }
}
