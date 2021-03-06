/**
 * Project Name:goldChannel
 * File Name:GoodsDao.java
 * Package Name:com.golden.goods.dao
 * Date:2016年10月19日上午11:00:36
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.goods.dao;

import java.util.List;
import java.util.Map;

import com.golden.goods.po.GoodsInfo;
import com.golden.order.po.ShipOrderInfo;
import com.golden.ship.po.ApplyShipping;

/**
 * ClassName:GoodsDao <br/>
 * Function: 货物信息管理 DAO层. <br/>
 * Date:     2016年10月19日 上午11:00:36 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface GoodsDao {

    /**
     * selectMyGoodsInfo:查询我的货物. <br/>
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<GoodsInfo> selectMyGoodsInfo(Map<String, String> map) throws Exception;

    /**
     * selectGoodsDetailById:通过id查询货物详细信息. <br/>
     * @author zhoujq
     * @param goodsId
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    GoodsInfo selectGoodsDetailById(String goodsId) throws Exception;

    /**
     * selectGoodsInfoByCondition:通过条件查询货物. <br/>
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<Map<String, Object>> selectGoodsInfoByCondition(Map<String, String> map) throws Exception;
    
    /**
     * createGoodsInfo:增加货物信息. <br/>
     * @author zhoujq
     * @param goodsInfo
     * @throws Exception
     * @since JDK 1.7
     */
    void createGoodsInfo(Map<String, String> goodsInfo) throws Exception;

    /**
     * deleteGoodsInfo:删除货物信息. <br/>
     * @author zhoujq
     * @param goodsId
     * @throws Exception
     * @since JDK 1.7
     */
    void deleteGoodsInfo(String goodsId) throws Exception;

    /**
     * updateGoodsInfo:更新货物信息. <br/>
     * @author zhoujq
     * @param goodsInfo
     * @throws Exception
     * @since JDK 1.7
     */
    void updateGoodsInfo(GoodsInfo goodsInfo) throws Exception;

    /**
     * selectBidDetailById:通过id查询标书详情. <br/>
     * @author zhoujq
     * @param map 
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    GoodsInfo selectBidDetailById(Map<String, String> map) throws Exception;

    /**
     * createBidInfo:创建标书. <br/>
     * @author zhoujq
     * @param bidInfo
     * @throws Exception
     * @since JDK 1.7
     */
    void createBidInfo(GoodsInfo bidInfo) throws Exception;

    /**
     * deleteMyBidById:撤标（发标）. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    void deleteMyBidById(Map<String, String> map) throws Exception;

    /**
     * selectMyBidInfo:查询我的发标.
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<GoodsInfo> selectMyBidInfo(Map<String, String> map) throws Exception;

    /**
     * createGoodsBidInfo:创建竞价信息. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    int createGoodsBidInfo(Map<String, String> map) throws Exception;

    /**
     * deleteShipApply:删除船运申请. <br/>
     * @author zhoujq
     * @param shipApplyId
     * @throws Exception
     * @since JDK 1.7
     */
    void deleteShipApply(String shipApplyId) throws Exception;

    /**
     * updateShipApply:修改船运申请状态. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    void updateShipApply(Map<String, String> map) throws Exception;

    /**
     * selectShipApplyInfo:查询我的船运（申请/被申请）,默认时间倒序. <br/>
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<ApplyShipping> selectShipApplyInfo(Map<String, String> map) throws Exception;

    /**
     * deleteOtherApply:删除其他申请. <br/>
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    void deleteOtherApply(Map<String, String> map) throws Exception;

    /**
     * updateShipStatus:修改船只状态. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    void updateShipStatus(Map<String, String> map) throws Exception;
    
    /**
     * selectBiddingNumber:查询竞标人数. <br/>
     * @author zhoujq
     * @param map
     * @return 
     * @throws Exception
     * @since JDK 1.7
     */
    int selectBiddingNumber(Map<String, String> map) throws Exception;
    
    /**
     * 根据ID删除竞标信息
     * @param goodsBidId 竞标ID
     */
    void deleteGoodsBidInfoById(String goodsBidId) throws Exception;

    /**
     * updateGoodsStatusByApplyId:根据船运申请id修改货物状态. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    void updateGoodsStatusByApplyId(Map<String, String> map) throws Exception;

    /**
     * selectBidCount:通过id查询标是否存在. <br/>
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    int selectBidCount(Map<String, String> map) throws Exception;

    /**
     * selectShipApplyDetailInfo:查询我的船运（申请/被申请）详情. <br/>
     * @author zhoujq
     * @param shipApplyId
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    ShipOrderInfo selectShipApplyDetailInfo(String shipApplyId) throws Exception;

    /**
     * selectShipStatus:查询船状态. <br/>
     * @author zhoujq
     * @param shipId
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    int selectShipStatus(String shipId) throws Exception;

    /**
     * selectShipApply:船运申请是否存在. <br/>
     * @author zhoujq
     * @param shipApplyId
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    int selectShipApply(String shipApplyId) throws Exception;

    /**
     * createBakGoodsInfo:创建备份货物. <br/>
     * @author zhoujq
     * @param goodsSourceId
     * @throws Exception
     * @since JDK 1.7
     */
    void createBakGoodsInfo(String goodsSourceId) throws Exception;
    
    
    List<Map<String, Object>> queryAll(Map<String, String> map);

    List<Map<String, Object>> getGoodsName();
    Map<String, Object> getGoodsDetail(String id);

    List<Map<String, Object>> myGoods(Map<String, String> map);

    void updateGoods(Map<String, String> map);
    void deleteGoods(String id);

    Map<String, String> getData();

    void createData(Map<String, String> map);

    void deleteData();

}

