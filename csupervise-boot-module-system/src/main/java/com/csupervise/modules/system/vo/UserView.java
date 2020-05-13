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
 *  *  Author: leiyz (lei88119@126.com)
 *  *
 *
 *
 */

package com.csupervise.modules.system.vo;

import com.csupervise.modules.system.entity.SysDepart;
import com.csupervise.modules.system.entity.SysPermission;
import com.csupervise.modules.system.entity.SysRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Project Name:csupervise
 * Package Name:com.csupervise.modules.system.vo
 *
 * @Author: leiyz
 * Date:2020/5/13 16:24
 */
@Data
@NoArgsConstructor
public class UserView implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */

    private java.lang.String id;
    /**
     * 创建人
     */

    private java.lang.String createBy;
    /**
     * 创建时间
     */

    private java.util.Date createTime;
    /**
     * 更新人
     */

    private java.lang.String updateBy;
    /**
     * 更新时间
     */

    private java.util.Date updateTime;
    /**
     * 登录账号
     */
    @ApiModelProperty(value = "登陆账号")
    private String username;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String realname;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * md5密码盐
     */
    private String salt;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别(0-默认未知,1-男,2-女)
     */
    @ApiModelProperty(value ="性别,0-默认未知,1-男,2-女")
    private String sex;

    /**
     * 电子邮件
     */
    @ApiModelProperty(value ="电子邮箱")
    private String email;

    /**
     * 电话
     */
    @ApiModelProperty(value ="手机号码")
    private String phone;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 性别(1-正常,2-冻结)
     */
    private String status;

    /**
     * 删除状态(0-正常,1-已删除)
     */
    private String delFlag;

    /**
     * 职务，关联职务表
     */
    @ApiModelProperty(value ="职务")
    private String post;

    /**
     * 座机号
     */
    @ApiModelProperty(value ="座机电话")
    private String telephone;
    private List<SysDepart> departs;
    private List<SysRole> roles;
    private List<SysPermission> permissions;
    @ApiModelProperty(value ="添加用户选择部门id，逗号分隔")
    private String selectDeparts;
    @ApiModelProperty(value ="添加用户选择角色id，逗号分隔")
    private String selectRoles;

}
