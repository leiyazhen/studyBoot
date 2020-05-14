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
import com.csupervise.modules.system.service.ISysPermissionService;
import com.csupervise.modules.system.vo.PermissionView;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @Author: leiyz
 * @since 2020-05-11
 */
@Api(tags = "系统权限")
@Controller
@RequestMapping("/system/sysPermission")
public class SysPermissionController {
    @Autowired
    private ISysPermissionService permissionService;

    public Result<List<PermissionView>> queryPermissionByUser()
    {
        return null;
    }
}
