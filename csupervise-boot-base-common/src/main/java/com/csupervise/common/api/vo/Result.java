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
package com.csupervise.common.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * 接口返回数据格式
 *
 * @Author: leiyz
 * @email: lyz88119@126.com
 * @Date: 2020年5月11日下午15:52:41
 */
@Builder
@ToString
@Accessors(chain = true)
public class Result<T> implements Serializable {

    public static final Integer SUCCESSFUL_CODE = 0;
    public static final Integer FAIL_CODE = -1;
    public static final String SUCCESSFUL_MESG = "处理成功";
    /**
     * serialVersionUID:TODO(please write your description).
     *
     * @since JDK 1.8
     */
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String mesg;
    @Getter
    @Setter
    private Instant timestamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Getter
    @Setter
    private T data;

    public Result() {
        this.timestamp = ZonedDateTime.now().toInstant();
    }

    public Result(T data) {
        super();
        this.data = data;
    }


    /**
     * 内部使用，用于构造成功的结果
     *
     * @param code
     * @param mesg
     * @param data
     */
    private Result(Integer code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
        this.timestamp = ZonedDateTime.now().toInstant();
    }

    private Result(Integer code, String mesg, Instant timestamp, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
        this.timestamp = timestamp;
    }

    /**
     * 快速创建成功结果并返回结果数据
     *
     * @param data
     * @return Result
     */
    public static Result success(Object data) {
        return new Result<>(SUCCESSFUL_CODE, SUCCESSFUL_MESG, data);
    }

    public static Result success(String mesg, Object data) {
        return new Result<>(SUCCESSFUL_CODE, mesg, data);
    }
    public static Result success(String mesg) {
        return new Result<>(SUCCESSFUL_CODE, mesg, null);
    }
    /**
     * 快速创建成功结果
     *
     * @return Result
     */
    public static Result success() {
        return success(null);
    }


    /**
     * 快速创建成功结果
     *
     * @return Result
     */
    public static Result fail(String mesg) {
        return new Result<>(FAIL_CODE, mesg, null);
    }

    /**
     * 成功code=000000
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESSFUL_CODE.equals(this.code);
    }

    /**
     * 失败
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }
}

