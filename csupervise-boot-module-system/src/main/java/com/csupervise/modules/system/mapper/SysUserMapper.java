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
package com.csupervise.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csupervise.modules.system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @Author: leiyz
 * @since 2020-05-11
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     *
     * @param username
     * @return
     */
    @Select(" SELECT * FROM (\n" +
            "        SELECT p.*\n" +
            "        FROM  sys_permission p\n" +
            "        WHERE (exists(\n" +
            "        select a.id from sys_role_permission a\n" +
            "        join sys_role b on a.role_id = b.id\n" +
            "        join sys_user_role c on c.role_id = b.id\n" +
            "        join sys_user d on d.id = c.user_id\n" +
            "        where p.id = a.permission_id  AND p.menu_type='2' AND d.username =#{username}\n" +
            "        ))) h")
    List<String> getPermissionsByUserName(@Param("username") String username);

    /**
     *
     * @param username
     * @return
     */
    @Select("select role_code from sys_role where id in (select role_id from sys_user_role where user_id = (select id from sys_user where username=#{username}))")
    List<String> getRoleByUserName(@Param("username") String username);
}
