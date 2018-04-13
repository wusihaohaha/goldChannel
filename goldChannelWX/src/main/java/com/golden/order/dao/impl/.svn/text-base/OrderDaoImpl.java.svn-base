/**
 * Project Name:goldChannel
 * File Name:OrderDaoImpl.java
 * Package Name:com.golden.order.dao.impl
 * Date:2016年11月8日下午4:00:17
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.order.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.golden.common.BaseDao;
import com.golden.order.dao.OrderDao;
import com.golden.order.po.ShipOrderInfo;

/**
 * ClassName:OrderDaoImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月8日 下午4:00:17 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component
public class OrderDaoImpl  extends BaseDao implements OrderDao {

    /**
     * 查询我的订单.
     * @see com.golden.order.dao.OrderDao#selectMyOrder(java.util.Map)
     */
    @Override
    public List<ShipOrderInfo> selectMyOrder(Map<String, String> map) throws Exception {
        return getSqlMapClientTemplate().queryForList("OrderInfoSqlMap.selectMyOrder",map);
    }

    /**
     * 更新合同文件.
     * @see com.golden.order.dao.OrderDao#updateBidFile(java.util.Map)
     */
    @Override
    public void updateBidFile(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().update("OrderInfoSqlMap.updateBidFile",map);
    }

    /**
     * 查询合同文件.
     * @see com.golden.order.dao.OrderDao#selectBidFile(java.util.Map)
     */
    @Override
    public ShipOrderInfo selectBidFile(Map<String, String> map) throws Exception {
        return (ShipOrderInfo) getSqlMapClientTemplate().queryForObject("OrderInfoSqlMap.selectBidFile",map);
    }

    /**
     * 查看订单详情.
     * @see com.golden.order.dao.OrderDao#selectOrderDetailInfo(java.util.Map)
     */
    @Override
    public ShipOrderInfo selectOrderDetailInfo(Map<String, String> map) throws Exception {
        return (ShipOrderInfo) getSqlMapClientTemplate().queryForObject("OrderInfoSqlMap.selectOrderDetailInfo",map);
    }

    /**
     * 更新订单状态.
     * @see com.golden.order.dao.OrderDao#updateOrderStatus(java.util.Map)
     */
    @Override
    public void updateOrderStatus(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().update("OrderInfoSqlMap.updateOrderStatus",map);
    }

    /**
     * 通过订单id修改船状态.
     * @see com.golden.order.dao.OrderDao#updateShipStatusByOrderId(java.util.Map)
     */
    @Override
    public void updateShipStatusByOrderId(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().update("OrderInfoSqlMap.updateShipStatusByOrderId",map);
    }

}

