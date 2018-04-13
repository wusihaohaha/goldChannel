package com.golden.search.po;

import org.springframework.stereotype.Component;
/**
 * 船舶交易信息实体类
 * @author xie
 */
@Component
public class ShipDealInfo {

	//船舶交易id
	private String shiptradeid;
	//船舶名称
	private String shipname;
	//信息标题
	//private String title;
	//船型
	private String shiptype;
	//交易类型
	private String tradetype;
	//参考报价
	private String price;
	//建造时间
	private String buildtime;
	//总吨位
	private String totaltonnage;
	//净吨位
	private String actualtonnage;
	//载重吨
	private String loadtonnage;
	//船长
	private String shiplong;
	//净宽
	private String shipwidth;
	//型深
	private String shipdepth;
	//主机马力
	private String bhp;
	//联系电话
	private String usertel;
	//发布时间
	private String publishtime;
	//上传图片1
	private String picturepath1;
	//上传图片2
	private String picturepath2;
	//上传图片3
	private String picturepath3;
	//备注
	private String remark;
    public String getShiptradeid() {
        return shiptradeid;
    }
    public void setShiptradeid(String shiptradeid) {
        this.shiptradeid = shiptradeid;
    }
    public String getShipname() {
        return shipname;
    }
    public void setShipname(String shipname) {
        this.shipname = shipname;
    }
    public String getShiptype() {
        return shiptype;
    }
    public void setShiptype(String shiptype) {
        this.shiptype = shiptype;
    }
    public String getTradetype() {
        return tradetype;
    }
    public void setTradetype(String tradetype) {
        this.tradetype = tradetype;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getBuildtime() {
        return buildtime;
    }
    public void setBuildtime(String buildtime) {
        this.buildtime = buildtime;
    }
    public String getTotaltonnage() {
        return totaltonnage;
    }
    public void setTotaltonnage(String totaltonnage) {
        this.totaltonnage = totaltonnage;
    }
    public String getActualtonnage() {
        return actualtonnage;
    }
    public void setActualtonnage(String actualtonnage) {
        this.actualtonnage = actualtonnage;
    }
    public String getLoadtonnage() {
        return loadtonnage;
    }
    public void setLoadtonnage(String loadtonnage) {
        this.loadtonnage = loadtonnage;
    }
    public String getShiplong() {
        return shiplong;
    }
    public void setShiplong(String shiplong) {
        this.shiplong = shiplong;
    }
    public String getShipwidth() {
        return shipwidth;
    }
    public void setShipwidth(String shipwidth) {
        this.shipwidth = shipwidth;
    }
    public String getShipdepth() {
        return shipdepth;
    }
    public void setShipdepth(String shipdepth) {
        this.shipdepth = shipdepth;
    }
    public String getBhp() {
        return bhp;
    }
    public void setBhp(String bhp) {
        this.bhp = bhp;
    }
    public String getUsertel() {
        return usertel;
    }
    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }
    public String getPublishtime() {
        return publishtime;
    }
    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }
    public String getPicturepath1() {
        return picturepath1;
    }
    public void setPicturepath1(String picturepath1) {
        this.picturepath1 = picturepath1;
    }
    public String getPicturepath2() {
        return picturepath2;
    }
    public void setPicturepath2(String picturepath2) {
        this.picturepath2 = picturepath2;
    }
    public String getPicturepath3() {
        return picturepath3;
    }
    public void setPicturepath3(String picturepath3) {
        this.picturepath3 = picturepath3;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
