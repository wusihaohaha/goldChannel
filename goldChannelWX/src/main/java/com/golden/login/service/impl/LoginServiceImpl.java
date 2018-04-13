/**
 * Project Name:goldChannel
 * File Name:LoginServiceImpl.java
 * Package Name:com.golden.login.service.impl
 *
*/

package com.golden.login.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.common.Constants;
import com.golden.common.StringUtil;
import com.golden.login.dao.LoginDao;
import com.golden.login.po.UserBean;
import com.golden.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private LoginDao loginDao;
    
    /**
     * 查找用户信息
     * @see com.gold.login.service.LoginService#login(java.lang.String, java.lang.String)
     */
    @Override
    public UserBean login(String telephone, String password) throws Exception
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("telephone", telephone);
        map.put("password", password);
        return loginDao.login(map);
    }

    /**
     * 判断手机号码是否存在
     * @see com.golden.login.service.LoginService#checkTelephone(java.lang.String)
     */
    @Override
    public int checkTelephone(String telephone) throws Exception {
        int count = loginDao.checkTelephone(telephone);
        if (count >= Constants.ONE) {
            return Constants.ONE;
        }
        return Constants.ZERO;
    }

    /**
     * 用户注册 .
     * @see com.golden.login.service.LoginService#addRegisterUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void addRegisterUser(String openid, String nickname, String province, String city, String sex, String headimgurl)
            throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", StringUtil.getUUID());
        map.put("openid", openid);
        map.put("nickname", nickname);
        map.put("province", province);
        map.put("city", city);
        map.put("sex", sex.equals("1")?"男":"女");
        map.put("headimgurl", headimgurl);
        loginDao.addRegisterUser(map);
    }

    /**
     * 修改用户密码.
     * @see com.golden.login.service.LoginService#updatePassword(java.lang.String, java.lang.String)
     */
    @Override
    public void updatePassword(String telephone, String password) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("telephone", telephone);
        map.put("password", password);
        loginDao.updatePassword(map);
    }

    /**
     * 验证旧密码是否正确.
     * @see com.golden.login.service.LoginService#checkOldPwd(java.lang.String, java.lang.String)
     */
    @Override
    public int checkOldPwd(String telephone, String oldpassword) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("telephone", telephone);
        map.put("password", oldpassword);
        return loginDao.checkOldPwd(map);
    }

    /**
     * 修改用户信息.
     * @see com.golden.login.service.LoginService#updateUserById(com.golden.login.po.UserBean)
     */
    @Override
    public void updateUserById(UserBean userInfo) throws Exception {
        loginDao.updateUserById(userInfo);
    }

    /**
     * 根据用户ID查询用户信息.
     * @see com.golden.login.service.LoginService#findUserById(java.lang.String)
     */
    @Override
    public UserBean findUserById(String userTel) throws Exception {
        return loginDao.findUserById(userTel);
    }

    /**
     * 查询昵称是否已被使用
     */
	@Override
	public int queryHadname(String username) throws Exception {
		return loginDao.queryHadname(username);
	}

	/**
	 * 修改用户头像
	 */
	@Override
	public void updateSelfHead(String userid, String filepath) {
		 Map<String, String> map = new HashMap<String, String>();
	     map.put("userid", userid);
	     map.put("filepath", filepath);
		loginDao.updateSelfHead(map);
	}

	/**
	 * 查询用户是否是维修师傅
	 */
	@Override
	public String queryRepairApplyId(String userid) {
		return loginDao.queryRepairApplyId(userid);
	}

	/**
	 * 修改维修师傅信息地址
	 */
	@Override
	public void updateRepairAdress(String applyId, String currentProvince,
			String currentCity) {
		 Map<String, String> map = new HashMap<String, String>();
	     map.put("applyId", applyId);
	     map.put("currentProvince", currentProvince);
	     map.put("currentCity", currentCity);
		loginDao.updateRepairAdress(map);
	}
	
	/**
	 * 用户注册
	 */
    @Override
    public int updateUserByOpenId(UserBean userInfo) throws Exception {
        return loginDao.updateUserByOpenId(userInfo);
    }

    @Override
    public void updateUserById(String id) throws Exception {
        loginDao.updateUserById(id);

        
    }

}
