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
package com.csupervise.common.exception;
/**
 * @Description: 异常类
 * @Author: leiyz
 * @Date: 2020年5月11日下午15:52:41
 */
public class CsuperviseBootException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CsuperviseBootException(String message){
		super(message);
	}
	
	public CsuperviseBootException(Throwable cause)
	{
		super(cause);
	}
	
	public CsuperviseBootException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
