package com.golden.search.po;

import org.springframework.stereotype.Component;

/**
 * 竞价公告实体类
 * @author xie
 */
@Component
public class NoticeInfo {

	//标号
	private String goodsbidid;
	//中标人
	private String username;
	//联系方式
	private String usertel;
	//中标价格
	private String bidprice;
	//中标时间(开标时间)
	private String bidopentime;
	//船名
	private String shipname;
	//标书id
	private String bidid;
	//跟单员姓名
	private String merchandiser;
	//跟单员联系方式
	private String merchandisertel;
	//首付款
	private String thefirstpayment;
	//出发港
	private String departureport;
	//到达港
	private String arrivalport;
	//保险金额 (保留)
	/*private String ;*/
	//限价
	private String limitedprice;
	//重量
	private String goodsweight;
	//货物名称
	private String goodsname;
	//竞价详情
	private String status;
	//出价时间
	private String createtime;
	//图片
	private String picturepath;
    public String getGoodsbidid() {
        return goodsbidid;
    }
    public void setGoodsbidid(String goodsbidid) {
        this.goodsbidid = goodsbidid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsertel() {
        return usertel;
    }
    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }
    public String getBidprice() {
        return bidprice;
    }
    public void setBidprice(String bidprice) {
        this.bidprice = bidprice;
    }
    public String getBidopentime() {
        return bidopentime;
    }
    public void setBidopentime(String bidopentime) {
        this.bidopentime = bidopentime;
    }
    public String getShipname() {
        return shipname;
    }
    public void setShipname(String shipname) {
        this.shipname = shipname;
    }
    public String getBidid() {
        return bidid;
    }
    public void setBidid(String bidid) {
        this.bidid = bidid;
    }
    public String getMerchandiser() {
        return merchandiser;
    }
    public void setMerchandiser(String merchandiser) {
        this.merchandiser = merchandiser;
    }
    public String getMerchandisertel() {
        return merchandisertel;
    }
    public void setMerchandisertel(String merchandisertel) {
        this.merchandisertel = merchandisertel;
    }
    public String getThefirstpayment() {
        return thefirstpayment;
    }
    public void setThefirstpayment(String thefirstpayment) {
        this.thefirstpayment = thefirstpayment;
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
    public String getLimitedprice() {
        return limitedprice;
    }
    public void setLimitedprice(String limitedprice) {
        this.limitedprice = limitedprice;
    }
    public String getGoodsweight() {
        return goodsweight;
    }
    public void setGoodsweight(String goodsweight) {
        this.goodsweight = goodsweight;
    }
    public String getGoodsname() {
        return goodsname;
    }
    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCreatetime() {
        return createtime;
    }
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
    public String getPicturepath() {
        return picturepath;
    }
    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

}
