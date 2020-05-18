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
package com.csupervise.modules.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csupervise.common.api.vo.Result;
import com.csupervise.modules.system.entity.SysPermission;
import com.csupervise.modules.system.entity.SysUser;
import com.csupervise.modules.system.entity.SysUserRole;
import com.csupervise.modules.system.service.ISysPermissionService;
import com.csupervise.modules.system.service.ISysUserRoleService;
import com.csupervise.modules.system.util.TreeUtil;
import com.csupervise.modules.system.vo.PermissionView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @Author: leiyz
 * @since 2020-05-11
 */
@Api(tags = "系统权限")
@RestController
@RequestMapping("/sysPermission")
public class SysPermissionController {
    @Autowired
    private ISysPermissionService permissionService;
    @Autowired
    private ISysUserRoleService userRoleService;

    @ApiOperation("查询用户菜单功能权限")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Result<List<PermissionView>> queryPermission() {
        SysUser
                currentUser =
                (SysUser) SecurityUtils.getSubject().getPrincipal();
        if (currentUser.getUsername().equals("admin")) {

            return Result.success(TreeUtil.bulid(
                    permissionService.list(new QueryWrapper<SysPermission>())
                            .stream().map(PermissionView::new)
                            .collect(Collectors.toList()), -1));
        }
        QueryWrapper<SysUserRole> roleQuery = new QueryWrapper<>();
        roleQuery.eq("user_id", currentUser.getId());
        List<SysUserRole> userRoles = userRoleService.list(roleQuery);
        return Result.success(TreeUtil.bulid(permissionService
                .queryUserPermissions(
                        userRoles.stream().map(SysUserRole::getRoleId)
                                .collect(Collectors.toList())).stream()
                .map(PermissionView::new).collect(Collectors.toList()), -1));
    }

    @ApiOperation("查询系统菜单功能权限")
    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public Result<List<PermissionView>> queryAllPermission() {
        return Result.success(TreeUtil.bulid(permissionService.list().stream()
                .map(PermissionView::new).collect(Collectors.toList()), -1));
    }
}
