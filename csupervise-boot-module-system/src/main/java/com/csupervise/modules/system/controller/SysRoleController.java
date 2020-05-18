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
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csupervise.common.api.vo.Result;
import com.csupervise.modules.system.entity.SysRole;
import com.csupervise.modules.system.entity.SysUserRole;
import com.csupervise.modules.system.service.ISysPermissionService;
import com.csupervise.modules.system.service.ISysRoleService;
import com.csupervise.modules.system.service.ISysUserRoleService;
import com.csupervise.modules.system.util.TreeUtil;
import com.csupervise.modules.system.vo.PermissionView;
import com.csupervise.modules.system.vo.RolePermissionView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @Author: leiyz
 * @since 2020-05-11
 */
@Api(tags = "系统角色")
@Slf4j
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysPermissionService permissionService;
    @Autowired
    private ISysUserRoleService userRoleService;

    @ApiOperation("查看角色详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result<RolePermissionView> details(@PathVariable String id) {
        SysRole sysRole = roleService.getById(id);
        if (sysRole == null) {
            return Result.fail("找不到相关资源");
        }
        RolePermissionView rolePermission = new RolePermissionView(sysRole);
        List<String> roleIds = new ArrayList<>();
        roleIds.add(sysRole.getId());
        List<PermissionView> permissionTree = TreeUtil.bulid(permissionService.queryUserPermissions(roleIds).stream()
                .map(PermissionView::new).collect(Collectors.toList()), -1);
        rolePermission.setPermissionTree(permissionTree);
        return Result.success(rolePermission);
    }

    @ApiOperation("查询角色列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<IPage<SysRole>> queryPageList(
            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Result<IPage<SysRole>> result = new Result<IPage<SysRole>>();
        QueryWrapper<SysRole> queryWrapper =
                new QueryWrapper<>();
        Page<SysRole> page = new Page<SysRole>(pageNo, pageSize);
        IPage<SysRole> pageList = roleService.page(page, queryWrapper);
        return Result.success(pageList);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增角色")
    public Result<Boolean> add(@RequestBody RolePermissionView rolePermission) {
        boolean result = roleService.saveOrUpdateRole(rolePermission);
        if (result) {
            return Result.success("保存成功");
        } else {
            return Result.fail("保存失败");

        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation("编辑角色")
    public Result<Boolean> edit(@RequestBody RolePermissionView rolePermission) {
        boolean result = roleService.saveOrUpdateRole(rolePermission);
        if (result) {
            return Result.success("保存成功");
        } else {
            return Result.fail("保存失败");

        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation("删除角色")
    public Result<Boolean> edit(@PathVariable String id) {
        QueryWrapper<SysUserRole> queryUserRole = new QueryWrapper<>();
        queryUserRole.eq("role_id", id);
        int exists = userRoleService.count(queryUserRole);
        if (exists > 0) {
            return Result.fail("当前角色存在用户关联，无法删除");
        }
        boolean result = roleService.removeById(id);
        if(result)
        {
            return  Result.success("删除成功");
        }
        else {
            return Result.fail("删除失败");
        }
    }
}
