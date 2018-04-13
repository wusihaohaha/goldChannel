/**
 * Project Name:goldChannel
 * File Name:GoodsInfo.java
 * Package Name:com.golden.goods.po
 * Date:2016年10月19日上午11:03:46
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.goods.po;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 
 * ClassName: GoodsBidInfo <br/>
 * Function: 竞标信息 -实体类. <br/>
 * date: 2016年11月1日 上午9:17:54 <br/>
 * @author zhoujq
 * @version 
 * @since JDK 1.7
 */


@Component
public class GoodsBidInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String goodsBidId; //竞标ID  自动生成
    private String goodsId; //货源ID  来源：货源信息表.货源ID
    private String bidUser; //竞标人  来源：用户信息表.用户ID
    private String shipId; //竞标船只 来源：船舶信息表.船只ID
    private String bidPrice; //竞标价格
    private String bidDeposit; //竞价保证金
    private String createTime; //创建时间
    private String status; //状态  1:待付保证金 2:竞标中 3:中标 4:竞标失败 5:退款成功
    public String getGoodsBidId() {
        return goodsBidId;
    }
    public void setGoodsBidId(String goodsBidId) {
        this.goodsBidId = goodsBidId;
    }
    public String getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
    public String getBidUser() {
        return bidUser;
    }
    public void setBidUser(String bidUser) {
        this.bidUser = bidUser;
    }
    public String getShipId() {
        return shipId;
    }
    public void setShipId(String shipId) {
        this.shipId = shipId;
    }
    public String getBidPrice() {
        return bidPrice;
    }
    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }
    public String getBidDeposit() {
        return bidDeposit;
    }
    public void setBidDeposit(String bidDeposit) {
        this.bidDeposit = bidDeposit;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

