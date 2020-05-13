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
import com.csupervise.common.constant.CommonConstant;
import com.csupervise.common.util.PasswordUtil;
import com.csupervise.common.util.oConvertUtils;
import com.csupervise.modules.system.entity.SysUser;
import com.csupervise.modules.system.service.ISysUserService;
import com.csupervise.modules.system.vo.UserView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @Author: leiyz
 * @since 2020-05-11
 */
@Controller
@RequestMapping("/system/sysUser")
@Api(tags = "用户管理")
@Slf4j
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;
    @ApiOperation("新增用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody UserView view) {
        try {
            SysUser user = new SysUser();
            BeanUtils.copyProperties(view, user);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            String salt = oConvertUtils.randomGen(8);
            user.setSalt(salt);
            String passwordEncode = PasswordUtil.encrypt(user.getUsername(), user.getPassword(), salt);
            user.setPassword(passwordEncode);
            user.setStatus("1");
            user.setDelFlag(CommonConstant.DEL_FLAG_0);
            return sysUserService.saveUser(user, view.getSelectDeparts(), view.getSelectRoles());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
           return Result.fail("操作失败");
        }
    }
}
