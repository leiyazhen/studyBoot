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


import com.csupervise.common.api.vo.Result;
import com.csupervise.modules.system.entity.SysDepart;
import com.csupervise.modules.system.service.ISysDepartService;
import com.csupervise.modules.system.service.ISysUserDepartService;
import com.csupervise.modules.system.util.TreeUtil;
import com.csupervise.modules.system.vo.DepartTreeView;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 组织机构表 前端控制器
 * </p>
 *
 * @Author: leiyz
 * @since 2020-05-11
 */
@RestController
@RequestMapping("/sysDepart")
public class SysDepartController {
    @Autowired
    private ISysDepartService sysDepartService;
    @Autowired
    private ISysUserDepartService userDepartService;

    @ApiOperation("查询部门树")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Result<List<DepartTreeView>> queryDepartTree() {
        return Result.success(TreeUtil.bulid(sysDepartService.list().stream()
                .map(DepartTreeView::new).collect(Collectors.toList()), -1));
    }

    @ApiOperation("新增部门")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Boolean> addDepart(@RequestBody SysDepart depart) {

        boolean result = sysDepartService.save(depart);
        if (result == true) {
            return Result.success("添加成功");
        } else {
            return Result.fail("添加失败");
        }
    }

    @ApiOperation("编辑部门")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Result<Boolean> editDepart(@RequestBody SysDepart depart) {
        SysDepart sysdepart = sysDepartService.getById(depart.getId());
        if (sysdepart == null) {
            return Result.fail("找不到相关资源");
        }
        boolean result = sysDepartService.updateById(depart);
        if (result == true) {
            return Result.success("添加成功");
        } else {
            return Result.fail("添加失败");
        }
    }

    @ApiOperation("删除部门")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result<Boolean> deleteDepart(@PathVariable String id) {
        return sysDepartService.deleteDepartWithChild(id);
    }

    @ApiOperation("查看部门")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result<SysDepart> queryDepartDetails(@PathVariable String id) {
        return Result.success(sysDepartService.getById(id));
    }
}
