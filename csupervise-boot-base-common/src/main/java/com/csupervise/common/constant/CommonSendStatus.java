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
package com.csupervise.common.constant;

/**
 * 	系统通告 - 发布状态
 * @Author: leiyz
 *
 */
public interface CommonSendStatus {
	
	public static final String UNPUBLISHED_STATUS_0 = "0";	//未发布
	
	public static final String PUBLISHED_STATUS_1 = "1";		//已发布
	
	public static final String REVOKE_STATUS_2 = "2";			//撤销



	/**流程催办——系统通知消息模板*/
	public static final String TZMB_BPM_CUIBAN = "bpm_cuiban";
	/**标准模板—系统消息通知*/
	public static final String TZMB_SYS_TS_NOTE = "sys_ts_note";
	/**流程超时提醒——系统通知消息模板*/
	public static final String TZMB_BPM_CHAOSHI_TIP = "bpm_chaoshi_tip";
}
