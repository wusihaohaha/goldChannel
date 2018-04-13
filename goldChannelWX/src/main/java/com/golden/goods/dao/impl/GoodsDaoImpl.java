/**
 * Project Name:goldChannel
 * File Name:GoodsDaoImpl.java
 * Package Name:com.golden.goods.dao.impl
 * Date:2016年10月19日上午11:01:15
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.goods.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.golden.common.BaseDao;
import com.golden.goods.dao.GoodsDao;
import com.golden.goods.po.GoodsInfo;
import com.golden.order.po.ShipOrderInfo;
import com.golden.ship.po.ApplyShipping;

/**
 * ClassName:GoodsDaoImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年10月19日 上午11:01:15 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component
public class GoodsDaoImpl extends BaseDao implements GoodsDao{

    /**
     * 查询我的货物.
     * @see com.golden.goods.dao.GoodsDao#selectMyGoodsInfo(java.util.Map)
     */
    @Override
    public List<GoodsInfo> selectMyGoodsInfo(Map<String, String> map) throws Exception {
        return  getSqlMapClientTemplate().queryForList("GoodsInfoSqlMap.selectMyGoodsInfo",map);
    }

    /**
     * 通过id查询货物详细信息
     * @see com.golden.goods.dao.GoodsDao#selectGoodsDetailById(java.lang.String)
     */
    @Override
    public GoodsInfo selectGoodsDetailById(String goodsId) throws Exception {
        return (GoodsInfo) getSqlMapClientTemplate().queryForObject("GoodsInfoSqlMap.selectGoodsDetailById", goodsId);
    }

    /**
     * 通过条件查询货物.
     * @see com.golden.goods.dao.GoodsDao#selectGoodsInfoByCondition(java.util.Map)
     */
    @Override
    public List<Map<String, Object>> selectGoodsInfoByCondition(Map<String, String> map) throws Exception {
        return getSqlMapClientTemplate().queryForList("GoodsInfoSqlMap.selectGoodsInfoByCondition1", map);
    }
    
    /**
     * 增加货物信息.
     * @see com.golden.goods.dao.GoodsDao#createGoodsInfo(com.golden.goods.po.GoodsInfo)
     */
    @Override
    public void createGoodsInfo(Map<String, String> goodsInfo) throws Exception {
        getSqlMapClientTemplate().insert("GoodsInfoSqlMap.createGoodsInfo", goodsInfo);
    }

    /**
     * 删除货物信息.
     * @see com.golden.goods.dao.GoodsDao#deleteGoodsInfo(java.lang.String)
     */
    @Override
    public void deleteGoodsInfo(String goodsId) throws Exception {
        getSqlMapClientTemplate().delete("GoodsInfoSqlMap.deleteGoodsInfo", goodsId);
    }

    /**
     * 更新货物信息.
     * @see com.golden.goods.dao.GoodsDao#updateGoodsInfo(com.golden.goods.po.GoodsInfo)
     */
    @Override
    public void updateGoodsInfo(GoodsInfo goodsInfo) throws Exception {
        getSqlMapClientTemplate().update("GoodsInfoSqlMap.updateGoodsInfo", goodsInfo);
    }

    /**
     * 通过id查询标书详情.
     * @see com.golden.goods.dao.GoodsDao#selectBidDetailById(java.util.Map)
     */
    @Override
    public GoodsInfo selectBidDetailById(Map<String, String> map) throws Exception {
        return (GoodsInfo) getSqlMapClientTemplate().queryForObject("GoodsInfoSqlMap.selectBidDetailById", map);
    }

    /**
     * 创建标书.
     * @see com.golden.goods.dao.GoodsDao#createBidInfo(com.golden.goods.po.GoodsInfo)
     */
    @Override
    public void createBidInfo(GoodsInfo bidInfo) throws Exception {
        getSqlMapClientTemplate().update("GoodsInfoSqlMap.createBidInfo", bidInfo);
    }

    /**
     * 撤标（发标）.
     * @see com.golden.goods.dao.GoodsDao#deleteMyBidById(java.util.Map)
     */
    @Override
    public void deleteMyBidById(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().update("GoodsInfoSqlMap.deleteMyBidById", map);
    }

    /**
     * 查询我的发标.
     * @see com.golden.goods.dao.GoodsDao#selectMyBidInfo(java.util.Map)
     */
    @Override
    public List<GoodsInfo> selectMyBidInfo(Map<String, String> map) throws Exception {
        return  getSqlMapClientTemplate().queryForList("GoodsInfoSqlMap.selectMyBidInfo", map);
    }

    /**
     * 创建竞价信息.
     * @see com.golden.goods.dao.GoodsDao#createGoodsBidInfo(com.golden.goods.po.GoodsBidInfo)
     */
    @Override
    public int createGoodsBidInfo(Map<String, String> map) throws Exception {
        return (int) getSqlMapClientTemplate().insert("GoodsInfoSqlMap.createGoodsBidInfo", map);
    }

    /**
     * 删除船运申请.
     * @see com.golden.goods.dao.GoodsDao#deleteShipApply(java.lang.String)
     */
    @Override
    public void deleteShipApply(String shipApplyId) throws Exception {
        getSqlMapClientTemplate().delete("GoodsInfoSqlMap.deleteShipApply", shipApplyId);
    }

    /**
     * 修改船运申请状态.
     * @see com.golden.goods.dao.GoodsDao#updateShipApply(java.util.Map)
     */
    @Override
    public void updateShipApply(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().update("GoodsInfoSqlMap.updateShipApply", map);
    }

    /**
     * 查询我的船运（申请/被申请）,默认时间倒序.
     * @see com.golden.goods.dao.GoodsDao#selectShipApplyInfo(java.util.Map)
     */
    @Override
    public List<ApplyShipping> selectShipApplyInfo(Map<String, String> map) throws Exception {
        return getSqlMapClientTemplate().queryForList("GoodsInfoSqlMap.selectShipApplyInfo", map);
    }

    /**
     * 删除其他申请.
     * @see com.golden.goods.dao.GoodsDao#deleteOtherApply(java.util.Map)
     */
    @Override
    public void deleteOtherApply(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().delete("GoodsInfoSqlMap.deleteOtherApply", map);
    }

    /**
     * 修改船只状态.
     * @see com.golden.goods.dao.GoodsDao#updateShipStatus(java.util.Map)
     */
    @Override
    public void updateShipStatus(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().update("GoodsInfoSqlMap.updateShipStatus", map);
    }

    /**
     * 查询竞标人数.
     * @see com.golden.goods.dao.GoodsDao#selectBiddingNumber(java.util.Map)
     */
    @Override
    public int selectBiddingNumber(Map<String, String> map) throws Exception {
        return (int) getSqlMapClientTemplate().queryForObject("GoodsInfoSqlMap.selectBiddingNumber", map);
    }
    
    /**
     * 根据ID删除竞标信息
     */
    @Override
    public void deleteGoodsBidInfoById(String goodsBidId) throws Exception{
        getSqlMapClientTemplate().delete("GoodsInfoSqlMap.deleteGoodsBidInfoById", goodsBidId);
    }

    /**
     * 根据船运申请id修改货物状态.
     * @see com.golden.goods.dao.GoodsDao#updateGoodsStatusByApplyId(java.util.Map)
     */
    @Override
    public void updateGoodsStatusByApplyId(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().update("GoodsInfoSqlMap.updateGoodsStatusByApplyId", map);
    }

    /**
     * 通过id查询标是否存在.
     * @see com.golden.goods.dao.GoodsDao#selectBidCount(java.util.Map)
     */
    @Override
    public int selectBidCount(Map<String, String> map) throws Exception {
        return (int) getSqlMapClientTemplate().queryForObject("GoodsInfoSqlMap.selectBidCount", map);
    }

    /**
     * 查询我的船运（申请/被申请）详情.
     * @see com.golden.goods.dao.GoodsDao#selectShipApplyDetailInfo(java.lang.String)
     */
    @Override
    public ShipOrderInfo selectShipApplyDetailInfo(String shipApplyId) throws Exception {
        return (ShipOrderInfo) getSqlMapClientTemplate().queryForObject("GoodsInfoSqlMap.selectShipApplyDetailInfo", shipApplyId);
    }

    /**
     * 查询船状态.
     * @see com.golden.goods.dao.GoodsDao#selectShipStatus(java.lang.String)
     */
    @Override
    public int selectShipStatus(String shipId) throws Exception {
        return (int) getSqlMapClientTemplate().queryForObject("GoodsInfoSqlMap.selectShipStatus", shipId);
    }

    /**
     * 船运申请是否存在.
     * @see com.golden.goods.dao.GoodsDao#selectShipApply(java.lang.String)
     */
    @Override
    public int selectShipApply(String shipApplyId) throws Exception {
        return (int) getSqlMapClientTemplate().queryForObject("GoodsInfoSqlMap.selectShipApply", shipApplyId);
    }

    /**
     * 创建备份货物.
     * @see com.golden.goods.dao.GoodsDao#createBakGoodsInfo(java.lang.String)
     */
    @Override
    public void createBakGoodsInfo(String goodsSourceId) throws Exception {
        getSqlMapClientTemplate().insert("GoodsInfoSqlMap.createBakGoodsInfo", goodsSourceId);
    }

    @Override
    public List<Map<String, Object>> queryAll(Map<String, String> map) {
        return getSqlMapClientTemplate().queryForList("GoodsInfoSqlMap.queryAll", map);
    }

    @Override
    public List<Map<String, Object>> getGoodsName() {
        return getSqlMapClientTemplate().queryForList("GoodsInfoSqlMap.getGoodsName");
    }

    @Override
    public Map<String, Object> getGoodsDetail(String id) {
        return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("GoodsInfoSqlMap.getGoodsDetail",id);
    }

    @Override
    public List<Map<String, Object>> myGoods(Map<String, String> map) {
        return getSqlMapClientTemplate().queryForList("GoodsInfoSqlMap.myGoods",map);
    }

    @Override
    public void updateGoods(Map<String, String> map) {
        getSqlMapClientTemplate().update("GoodsInfoSqlMap.updateGoods", map);
    }

    @Override
    public void deleteGoods(String id) {
        getSqlMapClientTemplate().delete("GoodsInfoSqlMap.deleteGoods", id);
        
    }

    @Override
    public Map<String, String> getData() {
        return (Map<String, String>) getSqlMapClientTemplate().queryForObject("GoodsInfoSqlMap.getData");
    }

    @Override
    public void createData(Map<String, String> map) {
        getSqlMapClientTemplate().delete("GoodsInfoSqlMap.createData", map);
    }

    @Override
    public void deleteData() {
        getSqlMapClientTemplate().delete("GoodsInfoSqlMap.deleteData");

    }

}

