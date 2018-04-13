package com.golden.advertise.po;

import org.springframework.stereotype.Component;
/**
 * 招聘简历实体类
 * @author xie
 */
@Component
public class Resume {

	//简历ID
	private String cvId;
	//用户ID
	private String createUser;
	//姓名
	private String userName;
	//照片
	private String picturePath;
	//年龄
	private String age;
	//电话
	private String contactTel;
	//身份证号
	private String idCard;
	//工作经验（年限
	private String workExperience;
	//应聘职务
	private String needDuty;
	//期望月薪
	private String salary;
	//省份
	private String currentpProvince;
	//市
	private String currentCity;
	//曾经职务
	private String pastDuty;
	//是否有过船舶工作经验 1:有 2:无
	private String shippingExperience;
	//简介
	private String introduction;
	//证书图片
	private String certificate;
	//审核状态  1:待审核 2.待修改 3:通过
	private String auditState;
	//状态  1:空闲 2:忙碌
	private String status;
	//发布时间
	private String publishTime;
	//邀请状态
	private String isinvite;
	//我的船员 邀请id
	private String inviteId;
	
	public String getCvId() {
		return cvId;
	}
	public void setCvId(String cvId) {
		this.cvId = cvId;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public String getNeedDuty() {
		return needDuty;
	}
	public void setNeedDuty(String needDuty) {
		this.needDuty = needDuty;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCurrentpProvince() {
		return currentpProvince;
	}
	public void setCurrentpProvince(String currentpProvince) {
		this.currentpProvince = currentpProvince;
	}
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public String getPastDuty() {
		return pastDuty;
	}
	public void setPastDuty(String pastDuty) {
		this.pastDuty = pastDuty;
	}
	public String getShippingExperience() {
		return shippingExperience;
	}
	public void setShippingExperience(String shippingExperience) {
		this.shippingExperience = shippingExperience;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getAuditState() {
		return auditState;
	}
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getIsinvite() {
		return isinvite;
	}
	public void setIsinvite(String isinvite) {
		this.isinvite = isinvite;
	}
	public String getInviteId() {
		return inviteId;
	}
	public void setInviteId(String inviteId) {
		this.inviteId = inviteId;
	}
	
}
