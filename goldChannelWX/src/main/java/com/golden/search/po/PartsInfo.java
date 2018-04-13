package com.golden.search.po;

import org.springframework.stereotype.Component;
/**
 * 配件建筑材料实体类
 * @author xie
 */
@Component
public class PartsInfo {

	//配件id
	private String partsid;
	//配件名称
	private String partsname;
	//类型
	private String type;
	//生产厂家
	private String manufacturer;
	//参考报价
	private String price;
	//配件图片
	private String picturepath;
	//配件联系人
	private String contactuser;
	//联系人电话
	private String contacttel;
	//发布时间
	private String createtime;
	
	public String getPartsid() {
		return partsid;
	}
	public void setPartsid(String partsid) {
		this.partsid = partsid;
	}
	public String getPartsname() {
		return partsname;
	}
	public void setPartsname(String partsname) {
		this.partsname = partsname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
    public String getPicturepath() {
		return picturepath;
	}
	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}
	public String getContactuser() {
		return contactuser;
	}
	public void setContactuser(String contactuser) {
		this.contactuser = contactuser;
	}
	public String getContacttel() {
		return contacttel;
	}
	public void setContacttel(String contacttel) {
		this.contacttel = contacttel;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
}
