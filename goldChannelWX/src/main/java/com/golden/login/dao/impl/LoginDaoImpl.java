/**
 * Project Name:goldChannel
 * File Name:LoginDao.java
 * Package Name:com.golden.login.dao
 * Date:2016年5月18日下午5:12:08
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.login.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.golden.common.BaseDao;
import com.golden.login.dao.LoginDao;
import com.golden.login.po.UserBean;

/**
 * 用户登录Dao实现
 * date: 2016年9月12日 下午5:43:12 <br/>
 * @author jiangmeng
 * @version 
 * @since JDK 1.7
 */
@Component 
public class LoginDaoImpl extends BaseDao implements LoginDao
{
    /**
     * 用户登录操作
     * @see com.golden.login.dao.LoginDao#login(java.util.Map)
     */
    @Override
    public UserBean login(Map<String, String> map) throws Exception
    {
        return (UserBean) getSqlMapClientTemplate().queryForObject("UserBeanSqlMap.login", map);
    }

    /**
     * 判断手机号码是否存在
     * @see com.golden.login.dao.LoginDao#checkTelephone(java.lang.String)
     */
    @Override
    public int checkTelephone(String telephone) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("UserBeanSqlMap.checkTelephone", telephone);
    }

    /**
     * 用户注册.
     * @see com.golden.login.dao.LoginDao#addRegisterUser(java.util.Map)
     */
    @Override
    public void addRegisterUser(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().insert("UserBeanSqlMap.addRegisterUser", map);
        
    }

    /**
     * 修改用户密码.
     * @see com.golden.login.dao.LoginDao#updatePassword(java.util.Map)
     */
    @Override
    public void updatePassword(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().update("UserBeanSqlMap.updatePassword", map);
    }

    /**
     * 验证旧密码是否正确.
     * @see com.golden.login.dao.LoginDao#checkOldPwd(java.util.Map)
     */
    @Override
    public int checkOldPwd(Map<String, String> map) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("UserBeanSqlMap.checkOldPwd", map);
    }

    /**
     * 修改用户信息.
     * @see com.golden.login.dao.LoginDao#updateUserById(com.golden.login.po.UserBean)
     */
    @Override
    public void updateUserById(UserBean userInfo) throws Exception {
        getSqlMapClientTemplate().update("UserBeanSqlMap.updateUserById", userInfo);
    }

    /**
     * 根据用户ID查询用户信息.
     * @see com.golden.login.dao.LoginDao#findUserById(java.lang.String)
     */
    @Override
    public UserBean findUserById(String userTel) throws Exception {
        return (UserBean) getSqlMapClientTemplate().queryForObject("UserBeanSqlMap.findUserById", userTel);
    }

    /**
     * 查询昵称是否已被使用
     */
	@Override
	public int queryHadname(String username) {
		return (Integer)getSqlMapClientTemplate().queryForObject("UserBeanSqlMap.queryHadname",username);
	}

	/**
	 * 修改用户头像
	 */
	@Override
	public void updateSelfHead(Map<String, String> map) {
		getSqlMapClientTemplate().update("UserBeanSqlMap.updateSelfHead",map);
	}

	/**
	 * 查询用户是否是维修师傅
	 */
	@Override
	public String queryRepairApplyId(String userid) {
		return (String)getSqlMapClientTemplate().queryForObject("UserBeanSqlMap.queryRepairApplyId",userid);
	}

	/**
	 * 修改维修师傅信息地址
	 */
	@Override
	public void updateRepairAdress(Map<String, String> map) {
		getSqlMapClientTemplate().update("UserBeanSqlMap.updateRepairAdress",map);
	}

    @Override
    public int updateUserByOpenId(UserBean userInfo) {
        return getSqlMapClientTemplate().update("UserBeanSqlMap.updateUserByOpenId", userInfo);
    }

    @Override
    public void updateUserById(String id) {
        // TODO Auto-generated method stub
        
    }

}

