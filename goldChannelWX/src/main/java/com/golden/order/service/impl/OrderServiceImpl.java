/**
 * Project Name:goldChannel
 * File Name:OrderServiceImpl.java
 * Package Name:com.golden.order.service.impl
 * Date:2016年11月8日下午3:57:29
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.order.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.common.Constants;
import com.golden.order.dao.OrderDao;
import com.golden.order.po.ShipOrderInfo;
import com.golden.order.service.OrderService;
import com.golden.personal.dao.PersonalDao;
import com.golden.transaction.dao.TransactionDao;

/**
 * ClassName:OrderServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月8日 下午3:57:29 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private PersonalDao personalDao;
    @Autowired
    private TransactionDao transactionDao;
    
    
    /**
     * 查询我的订单.
     * @see com.golden.order.service.OrderService#selectMyOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<ShipOrderInfo> selectMyOrder(String userId, String goodsStatus, String shipStatus, String rowMin,
            String rowMax) throws Exception {
        Map<String, String>map=new HashMap<String, String>();
        map.put("userId", userId);
        map.put("goodsStatus", goodsStatus);
        map.put("shipStatus", shipStatus);
        map.put("rowMin", rowMin);
        map.put("rowMax", rowMax);
        map.put("goods", Constants.roleType.goods);
        map.put("ship", Constants.roleType.ship);
        map.put("shipAudit", Constants.shippingOrderStatus.audit);
        map.put("goodsAudit", Constants.goodsOrderStatus.audit);
        map.put("firstConfirm", Constants.shippingOrderStatus.firstConfirm);
        map.put("firstPay", Constants.goodsOrderStatus.firstPay);
        map.put("lastConfirm", Constants.shippingOrderStatus.lastConfirm);
        map.put("goodsOrderOne", Constants.GoodsOrder.SYSTEM_STATUS_ONE);
        map.put("goodsOrderTwo", Constants.GoodsOrder.SYSTEM_STATUS_TWO);
        map.put("goodsOrderThree", Constants.GoodsOrder.SYSTEM_STATUS_THREE);
        map.put("goodsOrderThree", Constants.GoodsOrder.SYSTEM_STATUS_THREE);
        map.put("operateStatusSix", "6");//6:首尾款都不可用 
        return orderDao.selectMyOrder(map);
    }

    /**
     * 更新合同文件.
     * @see com.golden.order.service.OrderService#updateBidFile(com.golden.order.po.ShipOrderInfo)
     */
    @Override
    public void updateBidFile(String orderId, String userId, String filePath) throws Exception {
        Map<String, String>map=new HashMap<String, String>();
        map.put("orderId", orderId);
        map.put("userId", userId);
        map.put("goodsStatus", Constants.goodsOrderStatus.audit);//状态:（货方）合同审核中
        map.put("shipStatus", Constants.shippingOrderStatus.audit);//状态:（船方）合同审核中
        map.put("filePath", filePath);
        orderDao.updateBidFile(map);
    }

    /**
     * 查询合同文件.
     * @see com.golden.order.service.OrderService#selectBidFile(java.lang.String,java.lang.String)
     */
    @Override
    public ShipOrderInfo selectBidFile(String orderId,String userId) throws Exception {
        Map<String, String>map=new HashMap<String, String>();
        map.put("orderId", orderId);
        map.put("userId", userId);
        return orderDao.selectBidFile(map);
    }

    /**
     * 查看订单详情.
     * @see com.golden.order.service.OrderService#selectOrderDetailInfo(java.lang.String,java.lang.String)
     */
    @Override
    public ShipOrderInfo selectOrderDetailInfo(String orderId,String role) throws Exception {
        Map<String, String>map=new HashMap<String, String>();
        map.put("orderId", orderId);
        map.put("role", role);
        map.put("goods", Constants.roleType.goods);
        map.put("ship", Constants.roleType.ship);
        map.put("firstConfirm", Constants.shippingOrderStatus.firstConfirm);
        map.put("firstPay", Constants.goodsOrderStatus.firstPay);
        return orderDao.selectOrderDetailInfo(map);
    }

    /**
     *  更新订单状态.
     * @see com.golden.order.service.OrderService#updateOrderStatus(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void updateOrderStatus(String orderId, String goodsStatus, String shipStatus) throws Exception {
        Map<String, String>map=new HashMap<String, String>();
        map.put("orderId", orderId);
        map.put("goodsStatus", goodsStatus);
        map.put("shipStatus", shipStatus);
        
        //更新订单状态
        orderDao.updateOrderStatus(map);
        
        //订单完成的场合，放开船
        if(Constants.shippingOrderStatus.finish.equals(shipStatus)){
            map.clear();
            map.put("orderId", orderId);
            map.put("shipStatus", Constants.shipStatus.free);
            orderDao.updateShipStatusByOrderId(map);
        }
    }

}

