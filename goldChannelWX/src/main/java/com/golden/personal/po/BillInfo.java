/**
 * Project Name:goldChannel
 * File Name:BillInfo.java
 * Package Name:com.golden.personal.po
 * Date:2016年11月15日下午7:56:42
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.personal.po;

import java.io.Serializable;

/**
 * ClassName:BillInfo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月15日 下午7:56:42 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class BillInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tradeId; //交易ID 自动生成
    private String orderId; //订单ID  来源：订单信息表.订单ID
    private String goodsSourceId; //货源ID  来源：货源信息表.货源ID
    private String goodsBidId; //竞标ID  来源：竞标信息表.竞标ID
    private String tradeNo; //交易单号（支付宝交易号）
    private String tradeType; //交易类型 1:转入 2:转出
    private String userId; //支付用户  来源：用户信息表.用户ID
    private String tradeAccount; //对方账号
    private String tradeAmount; //支付金额
    private String amountType; //金额类型  1:支付 2:保证金 3:首付款 4:尾款 
    private String paymentExplain; //交易说明
    private String createTime; //创建时间
    private String time1; //创建时间-日期
    private String time2; //创建时间-时间hh24:mm
    
    public String getTradeId() {
        return tradeId;
    }
    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getGoodsSourceId() {
        return goodsSourceId;
    }
    public void setGoodsSourceId(String goodsSourceId) {
        this.goodsSourceId = goodsSourceId;
    }
    public String getGoodsBidId() {
        return goodsBidId;
    }
    public void setGoodsBidId(String goodsBidId) {
        this.goodsBidId = goodsBidId;
    }
    public String getTradeNo() {
        return tradeNo;
    }
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    public String getTradeType() {
        return tradeType;
    }
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getTradeAccount() {
        return tradeAccount;
    }
    public void setTradeAccount(String tradeAccount) {
        this.tradeAccount = tradeAccount;
    }
    public String getTradeAmount() {
        return tradeAmount;
    }
    public void setTradeAmount(String tradeAmount) {
        this.tradeAmount = tradeAmount;
    }
    public String getAmountType() {
        return amountType;
    }
    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }
    public String getPaymentExplain() {
        return paymentExplain;
    }
    public void setPaymentExplain(String paymentExplain) {
        this.paymentExplain = paymentExplain;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getTime1() {
        return time1;
    }
    public void setTime1(String time1) {
        this.time1 = time1;
    }
    public String getTime2() {
        return time2;
    }
    public void setTime2(String time2) {
        this.time2 = time2;
    }
}

