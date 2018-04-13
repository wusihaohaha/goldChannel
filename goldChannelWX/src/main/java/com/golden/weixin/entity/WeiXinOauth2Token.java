package com.golden.weixin.entity;

public class WeiXinOauth2Token {

	private String accessToken;
	private int expiresIn;
	private String refeshToken;
	private String openId;
	private String scope;
	private String nickname;
	private String sex;
	private String province;//用户个人资料填写的省份
	private String city;
	private String headimgurl;//用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getRefeshToken() {
		return refeshToken;
	}
	public void setRefeshToken(String refeshToken) {
		this.refeshToken = refeshToken;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public WeiXinOauth2Token() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WeiXinOauth2Token(String accessToken, int expiresIn,
			String refeshToken, String openId, String scope, String nickname,
			String sex, String province, String city, String headimgurl) {
		super();
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
		this.refeshToken = refeshToken;
		this.openId = openId;
		this.scope = scope;
		this.nickname = nickname;
		this.sex = sex;
		this.province = province;
		this.city = city;
		this.headimgurl = headimgurl;
	}
	
	
	
}
