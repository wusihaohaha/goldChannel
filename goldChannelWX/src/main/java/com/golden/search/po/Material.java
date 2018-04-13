package com.golden.search.po;

import org.springframework.stereotype.Component;
/**
 * 建材实体类
 * @author xie
 */
@Component
public class Material {

	//建材id
	private String materialid;
	//建材名称
	private String name;
	//规格
	private String specifications;
	//单价
	private String price;
	//图片
	private String picturepath;
	//联系人
	private String contactuser;
	//联系电话
	private String contacttel;
	//发货地
	private String address;
	//发布时间
	private String createtime;
	//产地
    private String origin;
    //到达港
    private String arrival;
    //备注
    private String remarks;
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getArrival() {
        return arrival;
    }
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
	
	public String getMaterialid() {
		return materialid;
	}
	public void setMaterialid(String materialid) {
		this.materialid = materialid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
}
