package com.golden.search.po;

import org.springframework.stereotype.Component;
/**
 * 在线加油
 * @author Xie
 *
 */
@Component
public class OilInfo {

	//名称
	private String name;
	//加油站名称
	private String manufacturer;
	//挂牌价
	private String price;
	//图片
	private String picturePath;
	//联系人
	private String contactUser;
	//联系电话
	private String contactTel;
	//备注
	private String remarks;
	public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getAllowance() {
        return allowance;
    }
    public void setAllowance(String allowance) {
        this.allowance = allowance;
    }
    //加油补贴
	private String allowance;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getContactUser() {
		return contactUser;
	}
	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	
}
