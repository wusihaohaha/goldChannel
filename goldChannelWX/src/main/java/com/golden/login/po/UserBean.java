package com.golden.login.po;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 用户个人信息实体类
 * date: 2016年9月12日 下午2:36:41 <br/>
 * @author jiangmeng
 * @version 
 * @since JDK 1.7
 */
@Component
public class UserBean implements Serializable
{
    /**
     * serialVersionUID:版本1
     * @since JDK 1.7
     */
    private static final long serialVersionUID = 1L;
    
    private String id; //用户id
    private String openId; //openid
    private String avatar; //头像
    private String nickName; //昵称
    private String lastUpdateTime; //最近更新时间
    private String lastLoginTime;
    private String createUser;
    private String create_date;
    private String update_user;
    private String update_date;
    private String mobile;
    private String type;
    private String star;
    private String companyName;
    private String name;
    private String cardNum; 
    private String isLogin; 
    private String path1; 
    private String path2; 
    private String path3; 
    private String path4; 
    private String category; 
    private String isAuthentication;
    private String province;
    private String city;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getOpenId() {
        return openId;
    }
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    public String getLastLoginTime() {
        return lastLoginTime;
    }
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public String getCreate_date() {
        return create_date;
    }
    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
    public String getUpdate_user() {
        return update_user;
    }
    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }
    public String getUpdate_date() {
        return update_date;
    }
    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getStar() {
        return star;
    }
    public void setStar(String star) {
        this.star = star;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCardNum() {
        return cardNum;
    }
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
    public String getIsLogin() {
        return isLogin;
    }
    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }
    public String getPath1() {
        return path1;
    }
    public void setPath1(String path1) {
        this.path1 = path1;
    }
    public String getPath2() {
        return path2;
    }
    public void setPath2(String path2) {
        this.path2 = path2;
    }
    public String getPath3() {
        return path3;
    }
    public void setPath3(String path3) {
        this.path3 = path3;
    }
    public String getPath4() {
        return path4;
    }
    public void setPath4(String path4) {
        this.path4 = path4;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getIsAuthentication() {
        return isAuthentication;
    }
    public void setIsAuthentication(String isAuthentication) {
        this.isAuthentication = isAuthentication;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    } 

}
