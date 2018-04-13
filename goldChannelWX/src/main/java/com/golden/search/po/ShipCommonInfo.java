package com.golden.search.po;

import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * 运联盟实体类
 * @author xie
 */
@Component
public class ShipCommonInfo {

	//id
	//private String shipid;
	//名称 可以是成员名，也可以是企业名
	private String shipname;
	//头像 图片
	private String shipimg;
	
	/*public String getShipid() {
		return shipid;
	}
	public void setShipid(String shipid) {
		this.shipid = shipid;
	}*/
	public String getShipname() {
		return shipname;
	}
	public void setShipname(String shipname) {
		this.shipname = shipname;
	}
	public String getShipimg() {
		return shipimg;
	}
	public void setShipimg(String shipimg) {
		this.shipimg = shipimg;
	}
}
