/**
 * Project Name:goldChannel
 * File Name:MessageServiceImpl.java
 * Package Name:com.golden.personal.service.impl
 * Date:2016年11月11日下午4:56:52
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.personal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.common.Constants;
import com.golden.login.po.UserBean;
import com.golden.personal.dao.PersonalDao;
import com.golden.personal.po.BillInfo;
import com.golden.personal.po.MessageInfo;
import com.golden.personal.service.PersonalService;

/**
 * ClassName:MessageServiceImpl <br/>
 * Function: 消息中心. <br/>
 * Date:     2016年11月11日 下午4:56:52 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Service
public class PersonalServiceImpl implements PersonalService{
    @Autowired
    private PersonalDao personalDao;

    /**
     * 创建消息.
     * @see com.golden.personal.service.PersonalService#createMessageInfo(com.golden.personal.po.MessageInfo)
     */
    @Override
    public void createMessageInfo(MessageInfo createMessageInfo) throws Exception {
        personalDao.createMessageInfo(createMessageInfo);
    }
    
    /**
     * 通过id删除消息.
     * @see com.golden.personal.service.PersonalService#deleteMessageById(java.lang.String)
     */
    @Override
    public void deleteMessageById(String messageId) throws Exception {
        personalDao.deleteMessageById(messageId);
    }

    /**
     * 查询我的消息列表.
     * @return 
     * @see com.golden.personal.service.PersonalService#selectMessageInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<MessageInfo> selectMessageInfo(String userId, String type, String rowMin, String rowMax) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", userId);
        map.put("type", type);
        map.put("rowMin", rowMin);
        map.put("rowMax", rowMax);
        if("1".equals(rowMin)){
            //修改消息状态
            map.put("unread", Constants.MessageStatus.Unread);
            map.put("read", Constants.MessageStatus.read);
            personalDao.updateMessagestatus(map);
        }
        return personalDao.selectMessageInfo(map);
    }

    /**
     * 查询我的账单列表.
     * @see com.golden.personal.service.PersonalService#selectMyBillInfo(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<BillInfo> selectMyBillInfo(String userId, String rowMin, String rowMax) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", userId);
        map.put("rowMin", rowMin);
        map.put("rowMax", rowMax);
        return personalDao.selectMyBillInfo(map);
    }

    /**
     * 查询未读消息条数.
     * @see com.golden.personal.service.PersonalService#selectUnreadMessageCount(java.lang.String, java.lang.String)
     */
    @Override
    public int selectUnreadMessageCount(String userId, String status) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", userId);
        map.put("status", status);
        return personalDao.selectUnreadMessageCount(map);
    }

    /**
     * 更新我的账户.
     * @see com.golden.personal.service.PersonalService#updateMyAccount(com.golden.login.po.UserBean)
     */
    @Override
    public void updateMyAccount(UserBean userBean) throws Exception {
        personalDao.updateMyAccount(userBean);
    }

    /**
     * 查询我的账户.
     * @see com.golden.personal.service.PersonalService#selectMyAccount(java.lang.String)
     */
    @Override
    public UserBean selectMyAccount(String userId) throws Exception {
        return personalDao.selectMyAccount(userId);
    }

    /**
     * 账户解绑.
     * @see com.golden.personal.service.PersonalService#deleteMyAccount(java.lang.String, java.lang.String)
     */
    @Override
    public void deleteMyAccount(String userId, String type) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", userId);
        map.put("type", type);
        personalDao.deleteMyAccount(map);
    }

}

