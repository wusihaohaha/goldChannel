/**
 * Project Name:goldChannel
 * File Name:OrderService.java
 * Package Name:com.golden.order.service
 * Date:2016年11月8日下午3:56:13
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.order.service;

import java.util.List;

import com.golden.order.po.ShipOrderInfo;

/**
 * ClassName:OrderService <br/>
 * FUNCTION： 订单信息管理 Service层
 * Date:     2016年11月8日 下午3:56:13 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface OrderService{

    /**
     * selectMyOrder:查询我的订单. <br/>
     * @author zhoujq
     * @param userId 用户id
     * @param goodsStatus 货状态
     * @param shipStatus 船状态
     * @param rowMin 开始行
     * @param rowMax 最大行
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<ShipOrderInfo> selectMyOrder(String userId, String goodsStatus, String shipStatus ,String rowMin, String rowMax) throws Exception;

    /**
     * updateBidFile:更新合同文件. <br/>
     * @author zhoujq
     * @param orderId 船运订单ID
     * @param userId 用户ID
     * @param filePath 文件路径
     * @throws Exception
     * @since JDK 1.7
     */
    void updateBidFile(String orderId, String userId, String filePath) throws Exception;

    /**
     * selectBidFile:查询合同文件. <br/>
     * @author zhoujq
     * @param orderId 订单ID
     * @param userId 用户ID
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    ShipOrderInfo selectBidFile(String orderId,String userId) throws Exception;

    /**
     * selectOrderDetailInfo:查看订单详情. <br/>
     * @author zhoujq
     * @param orderId 订单ID
     * @param role 角色
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    ShipOrderInfo selectOrderDetailInfo(String orderId,String role) throws Exception;

    /**
     * updateOrderStatus:更新订单状态. <br/>
     * @author zhoujq
     * @param orderId 订单ID
     * @param goodsStatus 货方状态
     * @param shipStatus 船方状态啊
     * @throws Exception
     * @since JDK 1.7
     */
    void updateOrderStatus(String orderId, String goodsStatus, String shipStatus) throws Exception;




}

