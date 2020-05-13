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

/**
 * 字典查询参数实体
 */
@Data
public class DictQuery {
    /**
     * 表名
     */
    private String table;
    /**
     * 存储列
     */
    private String code;

    /**
     * 显示列
     */
    private String text;

    /**
     * 关键字查询
     */
    private String keyword;

    /**
     * 存储列的值 用于回显查询
     */
    private String codeValue;

}
