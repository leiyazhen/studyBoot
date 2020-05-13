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

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csupervise.common.api.vo.Result;
import com.csupervise.common.util.UUIDGenerator;
import com.csupervise.common.util.oConvertUtils;
import com.csupervise.modules.system.entity.SysUser;
import com.csupervise.modules.system.entity.SysUserDepart;
import com.csupervise.modules.system.entity.SysUserRole;
import com.csupervise.modules.system.mapper.SysUserDepartMapper;
import com.csupervise.modules.system.mapper.SysUserMapper;
import com.csupervise.modules.system.mapper.SysUserRoleMapper;
import com.csupervise.modules.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @Author: leiyz
 * @since 2020-05-11
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Autowired
    private SysUserDepartMapper sysUserDepartMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public Set<String> queryUserRoles(String username) {
        List<String> roles = this.baseMapper.getRoleByUserName(username);
        return new HashSet<>(roles);
    }

    @Override
    public Set<String> queryUserPermissions(String username) {
        List<String> permissions = baseMapper.getPermissionsByUserName(username);
        return new HashSet<>(permissions);
    }

    @Override
    @Transactional
    public Result saveUser(SysUser user, String selectDeparts, String selectRoles) {
        this.save(user);
        if (oConvertUtils.isNotEmpty(selectRoles)) {
            String[] arr = selectRoles.split(",");
            for (String roleId : arr) {
                SysUserRole userRole = new SysUserRole(UUIDGenerator.generate(), user.getId(), roleId);
                sysUserRoleMapper.insert(userRole);
            }
        }
        if (oConvertUtils.isNotEmpty(selectDeparts)) {
            String[] arr = selectDeparts.split(",");
            for (String deaprtId : arr) {
                SysUserDepart userDeaprt = new SysUserDepart(UUIDGenerator.generate(), user.getId(), deaprtId);
                sysUserDepartMapper.insert(userDeaprt);
            }
        }
        return Result.success("添加用户成功");
    }
}
