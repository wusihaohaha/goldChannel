/**
 * Project Name:goldChannel
 * File Name:GoodsService.java
 * Package Name:com.golden.goods.service
 * Date:2016年10月19日上午10:58:06
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.goods.service;

import java.util.List;
import java.util.Map;

import com.golden.goods.po.GoodsBidInfo;
import com.golden.goods.po.GoodsInfo;
import com.golden.order.po.ShipOrderInfo;
import com.golden.ship.po.ApplyShipping;

/**
 * ClassName: GoodsService <br/>
 * FUNCTION： 货物信息管理 Service层
 * date: 2016年10月19日 上午11:18:01 <br/>
 * @author zhoujq
 * @version 
 * @since JDK 1.7
 */
public interface GoodsService {

    /**
     * selectMyGoodsInfo:查询我的货物信息. <br/>
     * @author zhoujq
     * @param userId 用户id
     * @param status 查询的货物状态
     * @param rowMin 开始行
     * @param roWMax 最大行
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<GoodsInfo> selectMyGoodsInfo(String userId, String status,String rowMin, String roWMax) throws Exception;

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
     * @param userId 用户id
     * @param departurePlace 出发地
     * @param arrivalPlace 目的地
     * @param emptyTonnageMin 重量(最小)
     * @param emptyTonnageMax 重量(最大)
     * @param rowMin 开始行
     * @param roWMax 最大行
     * @param status 状态
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<Map<String, Object>> selectGoodsInfoByCondition(String departurePlace, String arrivalPlace, String emptyTonnageMin,
            String emptyTonnageMax, String rowMin, String roWMax, String status) throws Exception;
    
    /**
     * createGoodsInfo:增加货物信息. <br/>
     * @author zhoujq
     * @param map 货物信息
     * @throws Exception
     * @since JDK 1.7
     */
    void createGoodsInfo(Map<String, String> map) throws Exception;

    /**
     * deleteGoodsInfo:删除货物信息. <br/>
     * @author zhoujq
     * @param goodsId 货物id
     * @throws Exception
     * @since JDK 1.7
     */
    void deleteGoodsInfo(String goodsId) throws Exception;

    /**
     * updateGoodsInfo:更新货物信息. <br/>
     * @author zhoujq
     * @param goodsInfo 货物信息
     * @throws Exception
     * @since JDK 1.7
     */
    void updateGoodsInfo(GoodsInfo goodsInfo) throws Exception;

    /**
     * selectBidDetailById:通过id查询标书详情. <br/>
     * @author zhoujq
     * @param userId 用户id
     * @param goodsId 货源id
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    GoodsInfo selectBidDetailById(String userId,String goodsId) throws Exception;

    /**
     * createBidInfo:创建标书. <br/>
     * @author zhoujq
     * @param bidInfo 标信息
     * @throws Exception
     * @since JDK 1.7
     */
    void createBidInfo(GoodsInfo bidInfo) throws Exception;

    /**
     * deleteMyBidById:撤标（发标）. <br/>
     * @author zhoujq
     * @param goodsId 货源ID
     * @param status 状态
     * @param failbidnoshow 流标不显示
     * @param failbid 
     * @throws Exception
     * @since JDK 1.7
     */
    void deleteMyBidById(String goodsId,String status, String failbidnoshow, String failbid) throws Exception;

    /**
     * selectMyBidInfo:查询我的竞标（发标、竞标） <br/>
     * @author zhoujq
     * @param userId 用户ID
     * @param status 货物状态
     * @param status 货物状态
     * @param rowMin 开始行
     * @param roWMax 最大行
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<GoodsInfo> selectMyBidInfo(String userId, String goodsStatus,String shipStatus, String rowMin, String roWMax) throws Exception;

    /**
     * createGoodsBidInfo:创建竞价信息. <br/>
     * @author zhoujq
     * @param goodsBidInfo 竞价信息
     * @throws Exception
     * @since JDK 1.7
     */
    int createGoodsBidInfo(GoodsBidInfo goodsBidInfo) throws Exception;

    /**
     * deleteShipApply:删除船运申请. <br/>
     * @author zhoujq
     * @param shipApplyId 船运申请ID
     * @param message 消息
     * @param role (操作)角色
     * @throws Exception
     * @since JDK 1.7
     */
    void deleteShipApply(String shipApplyId,String message,String role) throws Exception;


    /**
     * selectShipApplyInfo:查询我的船运（申请/被申请）,默认时间倒序. <br/>
     * @author zhoujq
     * @param userId 用户id
     * @param status 状态：申请
     * @param rowMin 开始行
     * @param roWMax 最大行
     * @return
     * @since JDK 1.7
     */
    List<ApplyShipping> selectShipApplyInfo(String userId, String status, String rowMin, String roWMax) throws Exception;

    /**
     * agreeShipApply:(船方)同意船运申请. <br/>
     * @author zhoujq
     * @param shipApplyId 船运申请id
     * @param assign 状态-指派
     * @param shipId 船id
     * @param apply 状态-申请
     * @param transport 状态-运输
     * @param message 消息
     * @throws Exception
     * @since JDK 1.7
     */
    void agreeShipApply(String shipApplyId, String assign,String shipId, String apply,String transport,String message) throws Exception;

    /**
     * selectBiddingNumber:查询竞标人数. <br/>
     * @author zhoujq
     * @param goodsId 货物ID
     * @param failbid 
     * @return 
     * @throws Exception
     * @since JDK 1.7
     */
    int selectBiddingNumber(String goodsId, String failbid) throws Exception;
    
    /**
     * 根据ID删除竞标信息
     * @author WSH
     * @param goodsBidId 竞标ID
     * @throws Exception
     */
    void deleteGoodsBidInfoById(String goodsBidId) throws Exception;

    /**
     * selectBidCount:通过id查询标是否存在. <br/>
     * @author zhoujq
     * @param goodsId 货源ID
     * @param status 状态
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    int selectBidCount(String goodsId, String status) throws Exception;

    /**
     * selectShipApplyDetailInfo:查询我的船运（申请/被申请）详情. <br/>
     * @author zhoujq
     * @param shipApplyId 船运申请id
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    ShipOrderInfo selectShipApplyDetailInfo(String shipApplyId) throws Exception;

    /**
     * selectShipStatus:查询船状态. <br/>
     * @author zhoujq
     * @param shipId 船只id
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

    void cancelBid(String goodsBidId, String shipId) throws Exception;

    List<Map<String, Object>> queryAll(String valueOf, String valueOf2);

    List<Map<String, Object>> getGoodsName();
    
    Map<String, Object> getGoodsDetail(String id);

    List<Map<String, Object>> myGoods(String userId, String valueOf, String valueOf2);

    void updateGoods(Map<String, String> map);

    void deleteGoods(String id);

    Map<String, String> getData();

    void deleteData();

    void createData(Map<String, String> map);
}

