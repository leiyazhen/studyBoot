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
package com.csupervise.common.constant;

/**
 * @Description: Websocket常量类
 * @Author: leiyz
 * @Date: 2020年5月11日下午15:52:41
 */
public class WebsocketConst {


    /**
     * 消息json key:cmd
     */
    public static final String MSG_CMD = "cmd";

    /**
     * 消息json key:msgId
     */
    public static final String MSG_ID = "msgId";

    /**
     * 消息json key:msgTxt
     */
    public static final String MSG_TXT = "msgTxt";

    /**
     * 消息json key:userId
     */
    public static final String MSG_USER_ID = "userId";

    /**
     * 消息类型 heartcheck
     */
    public static final String CMD_CHECK = "heartcheck";

    /**
     * 消息类型 user 用户消息
     */
    public static final String CMD_USER = "user";

    /**
     * 消息类型 topic 系统通知
     */
    public static final String CMD_TOPIC = "topic";

    /**
     * 消息类型 email
     */
    public static final String CMD_EMAIL = "email";

    /**
     * 消息类型 meetingsign 会议签到
     */
    public static final String CMD_SIGN = "sign";

}
