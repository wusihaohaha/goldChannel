/**
 * Project Name:goldChannel
 * File Name:OrderDao.java
 * Package Name:com.golden.order.dao
 * Date:2016年11月8日下午3:59:53
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.order.dao;

import java.util.List;
import java.util.Map;

import com.golden.order.po.ShipOrderInfo;

/**
 * ClassName:OrderDao <br/>
 * Function: 订单信息管理 DAO层. <br/>
 * Date:     2016年11月8日 下午3:59:53 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface OrderDao {

    /**
     * selectMyOrder:查询我的订单. <br/>
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<ShipOrderInfo> selectMyOrder(Map<String, String> map) throws Exception;
    
    /**
     * updateBidFile:更新合同文件. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    void updateBidFile(Map<String, String> map) throws Exception;
    
    /**
     * selectBidFile:查询合同文件. <br/>
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    ShipOrderInfo selectBidFile(Map<String, String> map) throws Exception;
    
    /**
     * selectOrderDetailInfo:查看订单详情. <br/>
     * @author zhoujq
     * @param map
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    ShipOrderInfo selectOrderDetailInfo(Map<String, String> map) throws Exception;

    /**
     * updateOrderStatus:更新订单状态. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    void updateOrderStatus(Map<String, String> map) throws Exception;

    /**
     * updateShipStatusByOrderId:通过订单id修改船状态. <br/>
     * @author zhoujq
     * @param map 
     * @throws Exception
     * @since JDK 1.7
     */
    void updateShipStatusByOrderId(Map<String, String> map) throws Exception;
}

