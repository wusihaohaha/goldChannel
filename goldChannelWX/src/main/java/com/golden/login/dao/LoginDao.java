/**
 * Project Name:goldChannel
 * File Name:LoginDao.java
 * Package Name:com.system.login.dao
 * Date:2016年5月18日下午5:12:08
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.login.dao;

import java.util.Map;

import com.golden.login.po.UserBean;

/**
 * 用户登录Dao
 * date: 2016年9月12日 下午5:42:56 <br/>
 * @author jiangmeng
 * @version 
 * @since JDK 1.7
 */
public interface LoginDao
{
    /**
     * login:用户登录操作
     * @author jiangmeng
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    public UserBean login(Map<String, String> map) throws Exception;

    /**
     * checkTelephone:判断手机号码是否存在. <br/>
     * @author zhoujq
     * @param telephone 手机号
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    public int checkTelephone(String telephone) throws Exception;

    /**
     * addRegisterUser:用户注册. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    public void addRegisterUser(Map<String, String> map) throws Exception;

    /**
     * updatePassword:修改用户密码. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    public void updatePassword(Map<String, String> map) throws Exception;

    /**
     * checkOldPwd:验证旧密码是否正确. <br/>
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    public int checkOldPwd(Map<String, String> map) throws Exception;

    /**
     * updateUserById:修改用户信息. <br/>
     * @author zhoujq
     * @param userInfo
     * @throws Exception
     * @since JDK 1.7
     */
    public void updateUserById(UserBean userInfo) throws Exception;

    /**
     * findUserById:根据用户ID查询用户信息. <br/>
     * @author zhoujq
     * @param userTel
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    public UserBean findUserById(String userTel) throws Exception;

    /**
     * 查询昵称是否已被使用
     * @param username
     * @return
     */
	public int queryHadname(String username);

	/**
	 * 修改用户头像
	 * @param map
	 */
	public void updateSelfHead(Map<String, String> map);

	/**
	 * 查询用户是否是维修师傅
	 * @param userid
	 * @return
	 */
	public String queryRepairApplyId(String userid);

	/**
	 * 修改维修师傅信息地址
	 * @param map
	 */
	public void updateRepairAdress(Map<String, String> map);
	
    public int updateUserByOpenId(UserBean userInfo);

    public void updateUserById(String id);
}

