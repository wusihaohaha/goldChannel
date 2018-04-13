/**
 * Project Name:goldChannel
 * File Name:MessageInfo.java
 * Package Name:com.golden.personal.po
 * Date:2016年11月11日下午4:59:56
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.personal.po;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * ClassName:MessageInfo <br/>
 * Function: 消息中心-实体类. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月11日 下午4:59:56 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component
public class MessageInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String messageId; //消息ID 自动生成
    private String receiveUser; //接收用户  来源：用户信息表.用户ID
    private String title; //主题
    private String messageType; //消息类型（1:系统消息/招聘邀请/竞标信息/邀请信息/……）
    private String messageContent; //消息内容
    private String createTime; //发送时间
    private String status; //是否已查看 1:否 2:是
    
    public String getMessageId() {
        return messageId;
    }
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
    public String getReceiveUser() {
        return receiveUser;
    }
    public void setReceiveUser(String receiveUser) {
        this.receiveUser = receiveUser;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMessageType() {
        return messageType;
    }
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    public String getMessageContent() {
        return messageContent;
    }
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

