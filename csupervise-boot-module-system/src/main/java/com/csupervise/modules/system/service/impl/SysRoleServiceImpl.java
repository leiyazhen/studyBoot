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
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csupervise.common.util.oConvertUtils;
import com.csupervise.modules.system.entity.SysRole;
import com.csupervise.modules.system.entity.SysRolePermission;
import com.csupervise.modules.system.mapper.SysRoleMapper;
import com.csupervise.modules.system.mapper.SysRolePermissionMapper;
import com.csupervise.modules.system.service.ISysRoleService;
import com.csupervise.modules.system.vo.RolePermissionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @Author: leiyz
 * @since 2020-05-11
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired

    private SysRolePermissionMapper rolePermissionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateRole(RolePermissionView view) {
        SysRole role = new SysRole();
        role.setRoleName(view.getRoleName());
        role.setRoleCode(view.getRoleCode());
        role.setId(view.getRoleId());
        role.setDescription(view.getRoleDesc());
        if(oConvertUtils.isEmpty(role.getId()))
        {
            this.baseMapper.insert(role);
        }
        else {
            this.baseMapper.updateById(role);
        }
        LambdaQueryWrapper<SysRole> lambdaQueryWrapper =
                new LambdaQueryWrapper<>();
        LambdaQueryWrapper<SysRole> query =
                lambdaQueryWrapper.select(SysRole::getRoleCode).eq(SysRole::getRoleCode,
                        role.getRoleCode());
        SysRole item = this.baseMapper.selectOne(query);
        LambdaQueryWrapper<SysRolePermission> lambdaQuery =
                new LambdaQueryWrapper<>();
        if (item == null) {
            return false;
        } else {
            QueryWrapper<SysRolePermission> deleteWrapper = new QueryWrapper<SysRolePermission>();
            deleteWrapper.eq("role_id",item.getId());
            rolePermissionMapper.delete(deleteWrapper);
            for (String permissionId : view.getPermissionIds()
            ) {
                SysRolePermission exist = rolePermissionMapper.selectOne(lambdaQuery.select(SysRolePermission::getRoleId).eq(SysRolePermission::getRoleId,
                        item.getId()));
                if (exist == null) {
                    SysRolePermission rolePermission = new SysRolePermission();
                    rolePermission.setRoleId(item.getId());
                    rolePermission.setPermissionId(permissionId);
                    rolePermissionMapper.insert(rolePermission);
                }
            }
            return true;
        }
    }
}
