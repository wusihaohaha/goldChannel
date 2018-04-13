/**
 * Project Name:goldChannel
 * File Name:PersonalDaoImpl.java
 * Package Name:com.golden.personal.dao.impl
 * Date:2016年11月11日下午4:59:30
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.personal.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.golden.common.BaseDao;
import com.golden.login.po.UserBean;
import com.golden.personal.dao.PersonalDao;
import com.golden.personal.po.BillInfo;
import com.golden.personal.po.MessageInfo;

/**
 * ClassName:PersonalDaoImpl <br/>
 * Function: 消息中心. <br/>
 * Date:     2016年11月11日 下午4:59:30 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component
public class PersonalDaoImpl extends BaseDao implements PersonalDao{

    /**
     * 创建消息.
     * @see com.golden.personal.dao.PersonalDao#createMessageInfo(com.golden.personal.po.MessageInfo)
     */
    @Override
    public void createMessageInfo(MessageInfo messageInfo) throws Exception {
        getSqlMapClientTemplate().insert("PersonalSqlMap.createMessageInfo",messageInfo);
    }
    
    /**
     * 创建消息（订单支付）.
     * @see com.golden.personal.dao.PersonalDao#createOrderPayMessageInfo(java.util.Map)
     */
    @Override
    public void createOrderPayMessageInfo(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().insert("PersonalSqlMap.createOrderPayMessageInfo",map);
    }
    
    /**
     * 通过id删除消息.
     * @see com.golden.personal.dao.PersonalDao#deleteMessageById(java.lang.String)
     */
    @Override
    public void deleteMessageById(String messageId) throws Exception {
        getSqlMapClientTemplate().delete("PersonalSqlMap.deleteMessageById",messageId);
    }

    /**
     * 查询我的消息列表.
     * @see com.golden.personal.dao.PersonalDao#selectMessageInfo(java.util.Map)
     */
    @Override
    public List<MessageInfo> selectMessageInfo(Map<String, String> map) throws Exception {
        return getSqlMapClientTemplate().queryForList("PersonalSqlMap.selectMessageInfo",map);
    }

    /**
     * 查询我的账单列表.
     * @see com.golden.personal.dao.PersonalDao#selectMyBillInfo(java.util.Map)
     */
    @Override
    public List<BillInfo> selectMyBillInfo(Map<String, String> map) throws Exception {
        return getSqlMapClientTemplate().queryForList("PersonalSqlMap.selectMyBillInfo",map);
    }

    /**
     * 查询未读消息条数.
     * @see com.golden.personal.dao.PersonalDao#selectUnreadMessageCount(java.util.Map)
     */
    @Override
    public int selectUnreadMessageCount(Map<String, String> map) throws Exception {
        return (int) getSqlMapClientTemplate().queryForObject("PersonalSqlMap.selectUnreadMessageCount",map);
    }

    /**
     * 修改消息状态.
     * @see com.golden.personal.dao.PersonalDao#updateMessagestatus(java.util.Map)
     */
    @Override
    public void updateMessagestatus(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().update("PersonalSqlMap.updateMessagestatus",map);
    }

    /**
     * 更新我的账户.
     * @see com.golden.personal.dao.PersonalDao#updateMyAccount(com.golden.login.po.UserBean)
     */
    @Override
    public void updateMyAccount(UserBean userBean) throws Exception {
        getSqlMapClientTemplate().update("PersonalSqlMap.updateMyAccount",userBean);
    }

    /**
     * 查询我的账户.
     * @see com.golden.personal.dao.PersonalDao#selectMyAccount(java.lang.String)
     */
    @Override
    public UserBean selectMyAccount(String userId) throws Exception {
        return (UserBean) getSqlMapClientTemplate().queryForObject("PersonalSqlMap.selectMyAccount",userId);
    }

    /**
     * 创建消息（船运）.
     * @see com.golden.personal.dao.PersonalDao#insertMessageByShipApplyId(java.util.Map)
     */
    @Override
    public void insertMessageByShipApplyId(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().insert("PersonalSqlMap.insertMessageByShipApplyId",map);
    }

    /**
     * 账户解绑.
     * @see com.golden.personal.dao.PersonalDao#deleteMyAccount(java.util.Map)
     */
    @Override
    public void deleteMyAccount(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().update("PersonalSqlMap.deleteMyAccount",map);
    }
    
}

