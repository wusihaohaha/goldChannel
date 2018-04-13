/**
 * Project Name:goldChannel
 * File Name:PersonalDao.java
 * Package Name:com.golden.personal.dao
 * Date:2016年11月11日下午4:59:16
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.personal.dao;

import java.util.List;
import java.util.Map;

import com.golden.login.po.UserBean;
import com.golden.personal.po.BillInfo;
import com.golden.personal.po.MessageInfo;

/**
 * ClassName:PersonalDao <br/>
 * Function: 消息中心 DAO层. <br/>
 * Date:     2016年11月11日 下午4:59:16 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface PersonalDao {

    /**
     * createMessageInfo:创建消息. <br/>
     * @author zhoujq
     * @param messageInfo
     * @throws Exception
     * @since JDK 1.7
     */
     void createMessageInfo(MessageInfo messageInfo) throws Exception;
     
     /**
      * createOrderPayMessageInfo:创建消息（订单支付）. <br/>
      * @author zhoujq
      * @param map
      * @throws Exception
      * @since JDK 1.7
      */
      void createOrderPayMessageInfo(Map<String, String> map) throws Exception;
      
    /**
     * deleteMessageById:通过id删除消息. <br/>
     * @author zhoujq
     * @param messageId
     * @throws Exception
     * @since JDK 1.7
     */
    void deleteMessageById(String messageId) throws Exception;
    
    /**
     * selectMessageInfo:查询我的消息列表. <br/>
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<MessageInfo> selectMessageInfo(Map<String, String> map) throws Exception;
    
    /**
     * selectMyBillInfo:查询我的账单列表. <br/>
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<BillInfo> selectMyBillInfo(Map<String, String> map) throws Exception;
    
    /**
     * selectUnreadMessageCount:查询未读消息条数. <br/>
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    int selectUnreadMessageCount(Map<String, String> map) throws Exception;
    
    /**
     * updateMessagestatus:修改消息状态. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    void updateMessagestatus(Map<String, String> map) throws Exception;
    
    /**
     * updateMyAccount:更新我的账户. <br/>
     * @author zhoujq
     * @param userBean
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    void updateMyAccount(UserBean userBean) throws Exception;
    
    /**
     * selectMyAccount:查询我的账户. <br/>
     * @author zhoujq
     * @param userId
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    UserBean selectMyAccount(String userId) throws Exception;

    /**
     * insertMessageByShipApplyId:创建消息（船运）. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    void insertMessageByShipApplyId(Map<String, String> map) throws Exception;

    /**
     * deleteMyAccount:账户解绑. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    void deleteMyAccount(Map<String, String> map) throws Exception;
}

