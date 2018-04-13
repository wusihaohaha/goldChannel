/**
 * Project Name:goldChannel
 * File Name:GoodsServiceImpl.java
 * Package Name:com.golden.goods.service.impl
 * Date:2016年10月19日上午11:00:07
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.goods.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.common.Constants;
import com.golden.goods.dao.GoodsDao;
import com.golden.goods.po.GoodsBidInfo;
import com.golden.goods.po.GoodsInfo;
import com.golden.goods.service.GoodsService;
import com.golden.order.po.ShipOrderInfo;
import com.golden.personal.dao.PersonalDao;
import com.golden.ship.po.ApplyShipping;

/**
 * ClassName:GoodsServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年10月19日 上午11:00:07 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private PersonalDao personalDao;
    
    /**
     * 查询我的货物信息.
     * @see com.golden.goods.service.GoodsService#selectMyGoodsInfo(java.lang.String, java.lang.String)
     */
    @Override
    public List<GoodsInfo> selectMyGoodsInfo(String userId,String status,String rowMin, String rowMax) throws Exception {
        Map<String, String> map=new HashMap<String, String>();
        map.put("userId", userId);
        map.put("status", status);
        map.put("rowMin", rowMin);
        map.put("rowMax", rowMax);
        return goodsDao.selectMyGoodsInfo(map);
    }
    
    /**
     * 通过id查询货物详细信息.
     * @see com.golden.goods.service.GoodsService#selectGoodsDetailById(java.lang.String)
     */
    @Override
    public GoodsInfo selectGoodsDetailById(String goodsId) throws Exception {
        return goodsDao.selectGoodsDetailById(goodsId);
    }

    /**
     * 通过条件查询货物.
     * @see com.golden.goods.service.GoodsService#selectGoodsInfoByCondition(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<Map<String, Object>> selectGoodsInfoByCondition(String departurePlace, String arrivalPlace, String emptyTonnageMin,
            String emptyTonnageMax, String rowMin, String rowMax, String status) throws Exception {
        Map<String, String> map=new HashMap<String, String>();
        map.put("departurePlace", departurePlace);
        map.put("arrivalPlace", arrivalPlace);
        map.put("emptyTonnageMin", emptyTonnageMin);
        map.put("emptyTonnageMax", emptyTonnageMax);
        map.put("rowMin", rowMin);
        map.put("rowMax", rowMax);
        map.put("status", "2");
        return goodsDao.selectGoodsInfoByCondition(map);
    }
    
    
    
    /**
     * 增加货物信息.
     * @see com.golden.goods.service.GoodsService#createGoodsInfo(com.golden.goods.po.GoodsInfo)
     */
    @Override
    public void createGoodsInfo(Map<String, String> goodsInfo) throws Exception {
        goodsDao.createGoodsInfo(goodsInfo);
    }

    /**
     * 删除货物信息.
     * @see com.golden.goods.service.GoodsService#deleteGoodsInfo(java.lang.String)
     */
    @Override
    public void deleteGoodsInfo(String goodsId) throws Exception {
        goodsDao.deleteGoodsInfo(goodsId);
    }

    /**
     * 更新货物信息.
     * @see com.golden.goods.service.GoodsService#updateGoodsInfo(com.golden.goods.po.GoodsInfo)
     */
    @Override
    public void updateGoodsInfo(GoodsInfo goodsInfo) throws Exception {
        goodsDao.updateGoodsInfo(goodsInfo);
    }

    /**
     * 通过id查询标书详情.
     * @see com.golden.goods.service.GoodsService#selectBidDetailById(java.lang.String)
     */
    @Override
    public GoodsInfo selectBidDetailById(String userId,String goodsId) throws Exception {
        Map<String, String> map=new HashMap<String, String>();
        map.put("demand", Constants.loadingDemand.demand);
        map.put("byThePiece", Constants.loadingDemand.byThePiece);
        map.put("byWeigh", Constants.loadingDemand.byWeigh);
        map.put("originalBinding", Constants.loadingDemand.originalBinding);
        map.put("moistureProof", Constants.loadingDemand.moistureProof);
        map.put("antiPollution", Constants.loadingDemand.antiPollution);
        map.put("userId", userId);
        map.put("goodsId", goodsId);
        map.put("apply", Constants.applyStatus.apply);
        map.put("noApply", Constants.applyStatus.noApply);
        map.put("biding", Constants.bidStatus.biding);//竞标中
        return goodsDao.selectBidDetailById(map);
    }

    /**
     * 创建标书.
     * @see com.golden.goods.service.GoodsService#createBidInfo(com.golden.goods.po.GoodsInfo)
     */
    @Override
    public void createBidInfo(GoodsInfo bidInfo) throws Exception {
        //备份货物
        goodsDao.createBakGoodsInfo(bidInfo.getGoodsSourceId().toString());
        //创建标书
        goodsDao.createBidInfo(bidInfo);
    }

    /**
     * 撤标（发标）.
     * @see com.golden.goods.service.GoodsService#deleteMyBidById(java.lang.String,java.lang.String,java.lang.String,java.lang.String)
     */
    @Override
    public void deleteMyBidById(String goodsId,String status,String failbidnoshow, String failbid) throws Exception {
        Map<String, String> map=new HashMap<String, String>();
        map.put("goodsId", goodsId);
        map.put("status", status);
        map.put("failbidnoshow", failbidnoshow);
        map.put("failbid", failbid);
        goodsDao.deleteMyBidById(map);
    }

    /**
     * 查询我的竞标（发标、竞标）.
     * @see com.golden.goods.service.GoodsService#selectMyBidInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<GoodsInfo> selectMyBidInfo(String userId, String goodsStatus,String shipStatus, String rowMin, String rowMax) throws Exception {
        Map<String, String> map=new HashMap<String, String>();
        map.put("userId", userId);
        map.put("goodsStatus", goodsStatus);
        map.put("shipStatus", shipStatus);
        map.put("rowMin", rowMin);
        map.put("rowMax", rowMax);
        map.put("pay", Constants.bidStatus.pay);//待付保证金
        map.put("goodsEnd", Constants.goodsStatus.end);//货物状态：竞标结束
        map.put("failBid", Constants.bidStatus.failBid);//竞标失败
        map.put("biding", Constants.bidStatus.biding);//竞标中
        map.put("publish", Constants.shippingType.publish);
        map.put("compete", Constants.shippingType.compete);
        return goodsDao.selectMyBidInfo(map);
    }

    /**
     * 创建竞价信息.
     * @see com.golden.goods.service.GoodsService#createGoodsBidInfo(com.golden.goods.po.GoodsBidInfo)
     */
    @Override
    
    public int createGoodsBidInfo(GoodsBidInfo goodsBidInfo) throws Exception {
        Map<String, String> map=new HashMap<String, String>();
        //修改船只状态
        map.put("shipId", goodsBidInfo.getShipId());
        map.put("status", Constants.shipStatus.biding);
        goodsDao.updateShipStatus(map);
        
        //创建竞价信息
        map.clear();
        map.put("goodsId", goodsBidInfo.getGoodsId());
        map.put("bidUser", goodsBidInfo.getBidUser());
        map.put("shipId", goodsBidInfo.getShipId());
        map.put("bidPrice", goodsBidInfo.getBidPrice().toString());
        map.put("pay", Constants.bidStatus.pay);
        map.put("biding", Constants.bidStatus.biding);
        map.put("onLine", Constants.payType.onLine);
        map.put("depositPercent", Constants.payPercent.depositPercent);
        return goodsDao.createGoodsBidInfo(map);
    }
    
    /**
     * 删除船运申请.
     * @see com.golden.goods.service.GoodsService#deleteShipApply(java.lang.String,java.lang.String,java.lang.String)
     */
    @Override
    public void deleteShipApply(String shipApplyId,String message,String role) throws Exception {
        //修改货物状态-删除
        Map<String, String>map=new HashMap<String, String>();
        map.put("shipApplyId", shipApplyId);
        map.put("status", Constants.goodsStatus.delete);
        goodsDao.updateGoodsStatusByApplyId(map);
        
        //发送消息
        map.clear();
        map.put("shipApplyId", shipApplyId);
        map.put("message", message);
        map.put("title", Constants.MessageTitle.shipping);
        map.put("messageType", Constants.MessageType.personal);
        map.put("status", Constants.MessageStatus.Unread);
        map.put("role", role);
        map.put("roleGoods", Constants.roleType.goods);
        personalDao.insertMessageByShipApplyId(map);
        
        //删除船运申请
        goodsDao.deleteShipApply(shipApplyId);
    }

    /**
     * 查询我的船运（申请/被申请）,默认时间倒序.
     * @throws Exception 
     * @see com.golden.goods.service.GoodsService#selectShipApplyInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<ApplyShipping> selectShipApplyInfo(String userId, String status, String rowMin, String rowMax) throws Exception {
        Map<String, String> map=new HashMap<String, String>();
        map.put("userId", userId);
        map.put("status", status);
        map.put("rowMin", rowMin);
        map.put("rowMax", rowMax);
        map.put("apply", Constants.shippingType.apply);
        map.put("beApply", Constants.shippingType.beApply);
        map.put("assign", Constants.shippingType.assign);
        return goodsDao.selectShipApplyInfo(map);
    }

    /**
     * 
     * (船方)同意船运申请.
     * @see com.golden.goods.service.GoodsService#agreeShipApply(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void agreeShipApply(String shipApplyId, String assign,String shipId, String apply,String transport,String message) throws Exception {
        //修改船运申请状态
        Map<String, String> map=new HashMap<String, String>();
        map.put("shipApplyId", shipApplyId);
        map.put("status", assign);
        goodsDao.updateShipApply(map);
        
        //删除其他申请
        map.clear();
        map.put("shipId", shipId);
        map.put("status", apply);
        goodsDao.deleteOtherApply(map);
        
        //修改船只状态
        map.clear();
        map.put("shipId", shipId);
        map.put("status", transport);
        goodsDao.updateShipStatus(map);

        //发送消息
        map.clear();
        map.put("shipApplyId", shipApplyId);
        map.put("message", message);
        map.put("title", Constants.MessageTitle.shipping);
        map.put("messageType", Constants.MessageType.personal);
        map.put("status", Constants.MessageStatus.Unread);
        map.put("role", Constants.roleType.ship);
        map.put("roleGoods", Constants.roleType.goods);
        personalDao.insertMessageByShipApplyId(map);
    }

    /**
     * 查询竞标人数.
     * @return 
     * @see com.golden.goods.service.GoodsService#selectBiddingNumber(java.lang.String,java.lang.String)
     */
    @Override
    public int selectBiddingNumber(String goodsId, String failbid) throws Exception {
        Map<String, String> map= new HashMap<String, String>();
        map.put("goodsId", goodsId);
        map.put("failbid", failbid);
        return goodsDao.selectBiddingNumber(map);
    }
    
    /**
     * 根据ID删除竞标信息
     */
    @Override
    public void deleteGoodsBidInfoById(String goodsBidId) throws Exception {
        goodsDao.deleteGoodsBidInfoById(goodsBidId);
    }

    /**
     * 通过id查询标是否存在.
     * @see com.golden.goods.service.GoodsService#selectBidCount(java.lang.String, java.lang.String)
     */
    @Override
    public int selectBidCount(String goodsId, String status) throws Exception {
        Map<String, String> map= new HashMap<String, String>();
        map.put("goodsId", goodsId);
        map.put("status", status);
        return goodsDao.selectBidCount(map);
    }

    /**
     * 查询我的船运（申请/被申请）详情.
     * @see com.golden.goods.service.GoodsService#selectShipApplyDetailInfo(java.lang.String)
     */
    @Override
    public ShipOrderInfo selectShipApplyDetailInfo(String shipApplyId) throws Exception {
        return goodsDao.selectShipApplyDetailInfo(shipApplyId);
    }

    /**
     * 查询船状态.
     * @see com.golden.goods.service.GoodsService#selectShipStatus(java.lang.String)
     */
    @Override
    public int selectShipStatus(String shipId) throws Exception {
        return goodsDao.selectShipStatus(shipId);
    }

    /**
     * 船运申请是否存在.
     * @see com.golden.goods.service.GoodsService#selectShipApply(java.lang.String)
     */
    @Override
    public int selectShipApply(String shipApplyId) throws Exception {
        return goodsDao.selectShipApply(shipApplyId);
    }

    @Override
    public void cancelBid(String goodsBidId, String shipId) throws Exception {
        goodsDao.deleteGoodsBidInfoById(goodsBidId);
        Map<String, String> map= new HashMap<String, String>();
        map.put("shipId", shipId);
        map.put("status", Constants.shipStatus.free);
        goodsDao.updateShipStatus(map);

        
    }

    @Override
    public List<Map<String, Object>> queryAll(String valueOf, String valueOf2) {
        Map<String, String> map= new HashMap<String, String>();
        map.put("rowMin", valueOf);
        map.put("rowMax", valueOf2);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list = goodsDao.queryAll(map);
        return list;
    }

    @Override
    public List<Map<String, Object>> getGoodsName() {
        return goodsDao.getGoodsName();
    }
    
    @Override
    public Map<String, Object> getGoodsDetail(String id) {
        return goodsDao.getGoodsDetail(id);
    }

    @Override
    public List<Map<String, Object>> myGoods(String userId, String valueOf, String valueOf2) {
        Map<String, String> map= new HashMap<String, String>();
        map.put("userId", userId);
        map.put("rowMin", valueOf);
        map.put("rowMax", valueOf2);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list = goodsDao.myGoods(map);
        return list;
    }

    @Override
    public void updateGoods(Map<String, String> map) {
        goodsDao.updateGoods(map);
        
    }

    @Override
    public void deleteGoods(String id) {
        goodsDao.deleteGoods(id);
    }

    @Override
    public Map<String, String> getData() {
        return goodsDao.getData();
    }

    @Override
    public void deleteData() {
        goodsDao.deleteData();
        
    }

    @Override
    public void createData(Map<String, String> map) {
        goodsDao.createData(map);
    }
    
}

