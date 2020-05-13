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
package com.csupervise.common.aspect.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.csupervise.common.constant.CommonConstant;

/**
 * 系统日志注解
 * 
 * @Author: leiyz
 * @email: lyz88119@126.com
 * @Date: 2020年5月11日下午15:52:41
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoLog {

	/**
	 * 日志内容
	 * 
	 * @return
	 */
	String value() default "";

	/**
	 * 日志类型
	 * 
	 * @return 0:操作日志;1:登录日志;2:定时任务;
	 */
	int logType() default CommonConstant.LOG_TYPE_2;
	
	/**
	 * 操作日志类型
	 * 
	 * @return （1查询，2添加，3修改，4删除）
	 */
	int operateType() default 0;
}
