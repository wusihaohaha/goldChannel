/**
 * Project Name:goldChannel
 * File Name:LoginService.java
 * Package Name:com.golden.login.service
 *
*/

package com.golden.login.service;

import com.golden.login.po.UserBean;


public interface LoginService
{
    /**
     * 用户登录
 	*/
    public UserBean login(String telephone, String password) throws Exception;

    /**
     * checkTelephone:用户注册获取验证码时：判断手机号码是否存在. <br/>
     * @author zhoujq
     * @param telephone 手机号码
     * @return 如果返回0 代表手机号码可以注册；如果返回1 代表手机号码已注册。
     * @throws Exception
     * @since JDK 1.7
     */
    public int checkTelephone(String telephone) throws Exception;

    /**
     * addRegisterUser:用户注册. <br/>
     * @author zhoujq
     * @param telephone 手机号码
     * @param password 密码
     * @param userHeadimg 头像
     * @param userName 姓名
     * @throws Exception
     * @since JDK 1.7
     */
   // public void addRegisterUser(String telephone, String password, String userHeadimg, String userName) throws Exception;

    /**
     * updatePassword:修改用户密码. <br/>
     * @author zhoujq
     * @param telephone 手机号
     * @param password 新密码
     * @throws Exception
     * @since JDK 1.7
     */
    public void updatePassword(String telephone, String password) throws Exception;

    /**
     * checkOldPwd:验证旧密码是否正确. <br/>
     * @author zhoujq
     * @param telephone 手机号
     * @param password 旧密码
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    public int checkOldPwd(String telephone, String oldpassword) throws Exception;

    /**
     * updateUserById:修改用户信息. <br/>
     * @author zhoujq
     * @param userInfo
     * @throws Exception
     * @since JDK 1.7
     */
    public void updateUserById(UserBean userInfo) throws Exception;
    
    /**
     * updateUserById:修改用户信息. <br/>
     * @author zhoujq
     * @param userInfo
     * @throws Exception
     * @since JDK 1.7
     */
    public void updateUserById(String id) throws Exception;
    
    /**
     * updateUserById:用户注册. <br/>
     * @author zhoujq
     * @param userInfo
     * @throws Exception
     * @since JDK 1.7
     */
    public int updateUserByOpenId(UserBean userInfo) throws Exception;

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
     * @throws Exception
     */
	public int queryHadname(String username) throws Exception;

	/**
	 * 修改用户头像
	 * @param userid
	 * @param string
	 */
	public void updateSelfHead(String userid, String filepath);

	/**
	 * 查询用户是否是维修师傅
	 * @param userid
	 * @return
	 */
	public String queryRepairApplyId(String userid);

	/**
	 * 修改维修师傅信息地址
	 * @param applyId
	 * @param currentProvince
	 * @param currentCity
	 */
	public void updateRepairAdress(String applyId, String currentProvince,
			String currentCity);

    void addRegisterUser(String openid, String nickname, String province, String city, String sex, String headimgurl)
            throws Exception;


}

