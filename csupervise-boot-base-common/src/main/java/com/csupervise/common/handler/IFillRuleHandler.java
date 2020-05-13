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
package com.csupervise.common.handler;

import com.alibaba.fastjson.JSONObject;

/**
 * 填值规则接口
 *
 * @Author: leiyz
 * 如需使用填值规则功能，规则实现类必须实现此接口
 */
public interface IFillRuleHandler {

    /**
     * @param params 页面配置固定参数
     * @param formData  动态表单参数
     * @return
     */
    public Object execute(JSONObject params, JSONObject formData);

}

