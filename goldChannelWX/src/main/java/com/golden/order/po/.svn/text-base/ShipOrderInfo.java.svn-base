/**
 * Project Name:goldChannel
 * File Name:OrderInfo.java
 * Package Name:com.golden.order.po
 * Date:2016年11月8日下午4:01:13
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.order.po;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * ClassName:ShipOrderInfo <br/>
 * Function: 船运订单信息 -实体类. <br/>
 * Date:     2016年11月8日 下午4:01:13 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component
public class ShipOrderInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String orderId; //订单ID 自动生成（格式:HJSD+YYYYMMDD+自动id 6位）（船运/维修/代驾共用单号）
    private String goodsUser; //货方  来源：用户信息表.用户ID
    private String shipUser; //船方  来源：用户信息表.用户ID
    private String goodsSourceId; //货源ID  来源：货源信息表.货源ID
    private String shipId; //船只ID  来源：船舶信息表.船只ID
    private String amount; //总金额
    private String theFirstPayment; //首付款
    private String shipStatus; //状态(船方用) 1:待上传合同 2:审核合同中 3:待确认首款 4:待确认尾款 5:交易完成 6:删除
    private String goodsStatus; //状态合同(货方) 1:待上传合同 2:审核合同中 3:待支付首款 4:待支付尾款 5:交易完成 6:删除
    private String shipBidFilePath; //合同(船方)文件路径
    private String goodsBidFilePath; //合同(货方)文件路径
    private String createTime; //创建时间
    private String updateTime; //更新时间
    private String systemStatus; //平台状态 1:待支付首款 2:待支付尾款 3:完成交易
    
    private String goodsName; //货名
    private String picturePath; //货物图片
    private String shipName;//船名
    private String freightPrice;//货运价格（元/吨）
    private String goodsWeight; //货量（吨）
    private String departurePort; //发货港
    private String departureWharf; //发货码头
    private String arrivalPort; //到达港
    private String arrivalWharf; //到达码头
    private String location; //当前位置
    private String lastPay;//尾款
    private String role;//角色 1:货方 2:船方
    private String filePath;//合同文件路径
    private String payType; //结算方式 1:线上 2:线下
    private String operateStatus; //操作状态 1:上传合同钮可用 2:查看合同按钮可用 3:首款按钮可用 4:尾款按钮可用 5:交易完成 6:首尾款都不可用 
    private String orderStatus; //订单状态:1:待上传合同 2:合同审核中 3:进行中 4:交易完成
    private String goodsUserName;//发货人
    private String goodsUserTel;//发货人电话
    private String shipUserName;//运货人
    private String shipUserTel;//运货人电话
    private String adminName; //跟单管理员 
    private String adminTel;//跟单员电话
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getGoodsUser() {
        return goodsUser;
    }
    public void setGoodsUser(String goodsUser) {
        this.goodsUser = goodsUser;
    }
    public String getShipUser() {
        return shipUser;
    }
    public void setShipUser(String shipUser) {
        this.shipUser = shipUser;
    }
    public String getGoodsSourceId() {
        return goodsSourceId;
    }
    public void setGoodsSourceId(String goodsSourceId) {
        this.goodsSourceId = goodsSourceId;
    }
    public String getShipId() {
        return shipId;
    }
    public void setShipId(String shipId) {
        this.shipId = shipId;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getTheFirstPayment() {
        return theFirstPayment;
    }
    public void setTheFirstPayment(String theFirstPayment) {
        this.theFirstPayment = theFirstPayment;
    }
    public String getShipStatus() {
        return shipStatus;
    }
    public void setShipStatus(String shipStatus) {
        this.shipStatus = shipStatus;
    }
    public String getGoodsStatus() {
        return goodsStatus;
    }
    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }
    public String getShipBidFilePath() {
        return shipBidFilePath;
    }
    public void setShipBidFilePath(String shipBidFilePath) {
        this.shipBidFilePath = shipBidFilePath;
    }
    public String getGoodsBidFilePath() {
        return goodsBidFilePath;
    }
    public void setGoodsBidFilePath(String goodsBidFilePath) {
        this.goodsBidFilePath = goodsBidFilePath;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getSystemStatus() {
        return systemStatus;
    }
    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public String getPicturePath() {
        return picturePath;
    }
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
    public String getShipName() {
        return shipName;
    }
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    public String getFreightPrice() {
        return freightPrice;
    }
    public void setFreightPrice(String freightPrice) {
        this.freightPrice = freightPrice;
    }
    public String getGoodsWeight() {
        return goodsWeight;
    }
    public void setGoodsWeight(String goodsWeight) {
        this.goodsWeight = goodsWeight;
    }
    public String getDeparturePort() {
        return departurePort;
    }
    public void setDeparturePort(String departurePort) {
        this.departurePort = departurePort;
    }
    public String getDepartureWharf() {
        return departureWharf;
    }
    public void setDepartureWharf(String departureWharf) {
        this.departureWharf = departureWharf;
    }
    public String getArrivalPort() {
        return arrivalPort;
    }
    public void setArrivalPort(String arrivalPort) {
        this.arrivalPort = arrivalPort;
    }
    public String getArrivalWharf() {
        return arrivalWharf;
    }
    public void setArrivalWharf(String arrivalWharf) {
        this.arrivalWharf = arrivalWharf;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLastPay() {
        return lastPay;
    }
    public void setLastPay(String lastPay) {
        this.lastPay = lastPay;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getPayType() {
        return payType;
    }
    public void setPayType(String payType) {
        this.payType = payType;
    }
    public String getOperateStatus() {
        return operateStatus;
    }
    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getGoodsUserName() {
        return goodsUserName;
    }
    public void setGoodsUserName(String goodsUserName) {
        this.goodsUserName = goodsUserName;
    }
    public String getGoodsUserTel() {
        return goodsUserTel;
    }
    public void setGoodsUserTel(String goodsUserTel) {
        this.goodsUserTel = goodsUserTel;
    }
    public String getShipUserName() {
        return shipUserName;
    }
    public void setShipUserName(String shipUserName) {
        this.shipUserName = shipUserName;
    }
    public String getShipUserTel() {
        return shipUserTel;
    }
    public void setShipUserTel(String shipUserTel) {
        this.shipUserTel = shipUserTel;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getAdminTel() {
        return adminTel;
    }
    public void setAdminTel(String adminTel) {
        this.adminTel = adminTel;
    }

}

