/**
 * Project Name:goldChannel
 * File Name:MessageService.java
 * Package Name:com.golden.personal.service
 * Date:2016年11月11日下午4:56:22
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.personal.service;

import java.util.List;

import com.golden.login.po.UserBean;
import com.golden.personal.po.BillInfo;
import com.golden.personal.po.MessageInfo;

/**
 * ClassName:MessageService <br/>
 * Function: 消息中心  Service层. <br/>
 * Date:     2016年11月11日 下午4:56:22 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface PersonalService {

    /**
     * createMessageInfo:创建消息. <br/>
     * @author zhoujq
     * @param messageInfo 消息信息
     * @throws Exception
     * @since JDK 1.7
     */
    void createMessageInfo(MessageInfo messageInfo) throws Exception;
    
    /**
     * deleteMessageById:通过id删除消息. <br/>
     * @author zhoujq
     * @param messageId 消息ID
     * @throws Exception
     * @since JDK 1.7
     */
    void deleteMessageById(String messageId) throws Exception;

    /**
     * selectMessageInfo:查询我的消息列表. <br/>
     * @author zhoujq
     * @param userId 用户id
     * @param type 类型
     * @param rowMin 开始行
     * @param rowMax 最大行
     * @return 
     * @throws Exception
     * @since JDK 1.7
     */
    List<MessageInfo> selectMessageInfo(String userId, String type, String rowMin, String rowMax) throws Exception;

    /**
     * selectMyBillInfo:查询我的账单列表. <br/>
     * @author zhoujq
     * @param userId 用户id
     * @param rowMin 开始行
     * @param rowMax 最大行
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<BillInfo> selectMyBillInfo(String userId, String rowMin, String rowMax) throws Exception;

    /**
     * selectUnreadMessageCount:查询未读消息条数. <br/>
     * @author zhoujq
     * @param userId 用户ID
     * @param status 状态
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    int selectUnreadMessageCount(String userId ,String status) throws Exception;

    /**
     * updateMyAccount:更新我的账户. <br/>
     * @author zhoujq
     * @param userBean 用户信息
     * @throws Exception
     * @since JDK 1.7
     */
    void updateMyAccount(UserBean userBean) throws Exception;

    /**
     * selectMyAccount:查询我的账户. <br/>
     * @author zhoujq
     * @param userId 用户ID
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    UserBean selectMyAccount(String userId) throws Exception;

    /**
     * deleteMyAccount:账户解绑. <br/>
     * @author zhoujq
     * @param userId 用户id
     * @param type 1.支付宝 2.微信
     * @throws Exception
     * @since JDK 1.7
     */
    void deleteMyAccount(String userId, String type) throws Exception;

}

