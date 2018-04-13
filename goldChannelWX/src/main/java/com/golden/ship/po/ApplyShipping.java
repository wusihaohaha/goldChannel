package com.golden.ship.po;

import java.io.Serializable;

import org.springframework.stereotype.Component;
/**
 * 申请船运实体类
 * @author xie
 */
@Component
public class ApplyShipping implements Serializable{

    private static final long serialVersionUID = 1L;
    
    //船运申请ID
    private String shipapplyid;
    //船舶id
	private String shipid;
	//货物id
	private String goodssourceid;
	//货运价格(*元/吨)
	private String freightprice;
	//首付款
	private String thefirstpayment;
	//结算方式
	private String paytype;
	//用户id(申请人id)
	private String applyuser;
	//船主  (船主id)
    private String shipowner;
    //状态
    private String status;
    //船运状态  1:货方操作 2:船方操作 3:待指派订单
    private String applystatus;
    //船名
    private String shipname;
    //货名
    private String goodsname;
    //货物图片
    private String picturepath;
    //发货港
    private String departureport;
    //到达港
    private String arrivalport;
    //申请时间
    private String applytime;
    //货物信息—货量（吨）
    private String goodsweight; 
    
	public String getShipapplyid() {
        return shipapplyid;
    }
    public void setShipapplyid(String shipapplyid) {
        this.shipapplyid = shipapplyid;
    }
    public String getShipid() {
		return shipid;
	}
	public void setShipid(String shipid) {
		this.shipid = shipid;
	}
	public String getGoodssourceid() {
		return goodssourceid;
	}
	public void setGoodssourceid(String goodssourceid) {
		this.goodssourceid = goodssourceid;
	}
    public String getFreightprice() {
        return freightprice;
    }
    public void setFreightprice(String freightprice) {
        this.freightprice = freightprice;
    }
    public String getThefirstpayment() {
		return thefirstpayment;
	}
	public void setThefirstpayment(String thefirstpayment) {
		this.thefirstpayment = thefirstpayment;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getApplyuser() {
		return applyuser;
	}
	public void setApplyuser(String applyuser) {
		this.applyuser = applyuser;
	}
    public String getShipowner() {
        return shipowner;
    }
    public void setShipowner(String shipowner) {
        this.shipowner = shipowner;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getApplystatus() {
        return applystatus;
    }
    public void setApplystatus(String applystatus) {
        this.applystatus = applystatus;
    }
    public String getShipname() {
        return shipname;
    }
    public void setShipname(String shipname) {
        this.shipname = shipname;
    }
    public String getGoodsname() {
        return goodsname;
    }
    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }
    public String getDepartureport() {
        return departureport;
    }
    public void setDepartureport(String departureport) {
        this.departureport = departureport;
    }
    public String getArrivalport() {
        return arrivalport;
    }
    public void setArrivalport(String arrivalport) {
        this.arrivalport = arrivalport;
    }
    public String getApplytime() {
        return applytime;
    }
    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }
    public String getPicturepath() {
        return picturepath;
    }
    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }
    public String getGoodsweight() {
        return goodsweight;
    }
    public void setGoodsweight(String goodsweight) {
        this.goodsweight = goodsweight;
    }
}
