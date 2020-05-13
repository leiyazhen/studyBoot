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
package com.csupervise.modules.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 知识库表
 * </p>
 *
 * @Author: leiyz
 * @since 2020-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("biz_notice_info")
public class BizNoticeInfo extends Model<BizNoticeInfo> {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "ID")
    private java.lang.String id;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @Excel(name = "创建人", width = 15)
    private java.lang.String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime;
    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    @Excel(name = "更新人", width = 15)
    private java.lang.String updateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @Excel(name = "更新时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date updateTime;

    /**
     * 消息通知主题
     */
    private String topic;

    /**
     * 消息通知内容
     */
    private String content;

    /**
     * 消息通知类别1-通知公告,2-用户消息
     */
    private String noticeType;

    /**
     * 发送状态0-失败，1-成功
     */
    private String status;

    /**
     * 行政区域编码
     */
    private String areaCode;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
