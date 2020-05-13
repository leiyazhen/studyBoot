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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  类描述:  字典注解
 * @Author: leiyz
 * @Date: 2020年5月11日下午15:52:41
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dict {
    /**
     * 方法描述:  数据code
     * @Author: leiyz
     * @Date: 2020年5月11日下午15:52:41
     *
     * @return 返回类型： String
     */
    String dicCode();

    /**
     * 方法描述:  数据Text
     * @Author: leiyz
     * @Date: 2020年5月11日下午15:52:41
     *
     * @return 返回类型： String
     */
    String dicText() default "";

    /**
     * 方法描述: 数据字典表
     * @Author: leiyz
     * @Date: 2020年5月11日下午15:52:41
     *
     * @return 返回类型： String
     */
    String dictTable() default "";
}
