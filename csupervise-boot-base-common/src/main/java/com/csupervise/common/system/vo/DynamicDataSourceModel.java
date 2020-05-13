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
package com.csupervise.common.system.vo;

import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class DynamicDataSourceModel {

    public DynamicDataSourceModel() {

    }

    public DynamicDataSourceModel(Object dbSource) {
        if (dbSource != null) {
            BeanUtils.copyProperties(dbSource, this);
        }
    }

    /**
     * id
     */
    private java.lang.String id;
    /**
     * 数据源编码
     */
    private java.lang.String code;
    /**
     * 数据库类型
     */
    private java.lang.String dbType;
    /**
     * 驱动类
     */
    private java.lang.String dbDriver;
    /**
     * 数据源地址
     */
    private java.lang.String dbUrl;
    /**
     * 数据库名称
     */
    private java.lang.String dbName;
    /**
     * 用户名
     */
    private java.lang.String dbUsername;
    /**
     * 密码
     */
    private java.lang.String dbPassword;

}
