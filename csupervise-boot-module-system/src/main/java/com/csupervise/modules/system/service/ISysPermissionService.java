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
package com.csupervise.modules.system.service;

import com.csupervise.modules.system.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @Author: leiyz
 * @since 2020-05-11
 */
public interface ISysPermissionService extends IService<SysPermission> {
    /**
     * 角色集合查找菜单功能
     * @param roleIds
     * @return
     */
    List<SysPermission> queryUserPermissions(List<String> roleIds);
}
