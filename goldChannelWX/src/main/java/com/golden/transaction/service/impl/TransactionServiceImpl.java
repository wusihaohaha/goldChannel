/**
 * Project Name:goldChannel
 * File Name:TransactionServiceImpl.java
 * Package Name:com.golden.transaction.service.impl
 * Date:2016年11月16日下午3:53:16
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.transaction.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.common.Constants;
import com.golden.goods.dao.GoodsDao;
import com.golden.order.dao.OrderDao;
import com.golden.transaction.dao.TransactionDao;
import com.golden.transaction.service.TransactionService;



/**
 * ClassName:TransactionServiceImpl <br/>
 * Function: 交易记录Service实现层
 * Date:     2016年11月16日 下午3:53:16 <br/>
 * @author   wusihao
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Service
public class TransactionServiceImpl implements TransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
    
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    OrderDao orderDao;
    
    /**
     * 解析P++支付回调参数
     * @throws Exception 
     */
    @Override
    public void queryPingCallbacks(String string, String signature) throws Exception 
    {
        
        JSONObject jsonObject = new JSONObject(string);
        String isPayTrue = jsonObject.getString("type");
        //支付回调：支付成功
        if("charge.succeeded".equals(isPayTrue))
        {
            JSONObject dataJson = jsonObject.getJSONObject("data");
            
            JSONObject objectJson = dataJson.getJSONObject("object");
            JSONObject extraJson = objectJson.getJSONObject("extra");
            JSONObject metadata = objectJson.getJSONObject("metadata");
            String order_no = objectJson.getString("order_no");
            int tradeAmount = objectJson.getInt("amount");
            String subject = objectJson.getString("subject");
            String buyer_account = "";
            String channel = objectJson.getString("channel");
            if(channel.equalsIgnoreCase("alipay")){
                buyer_account = extraJson.getString("buyer_account");
            }
            String amountType = metadata.getString("amountType");
            String shipId = metadata.getString("shipId");
            String goodsId = metadata.getString("goodsId");
            String bidPrice = metadata.getString("bidPrice");
            String userId = metadata.getString("userId");
            String orderId = metadata.getString("orderId");
            String goodsBidId = null; 
            
            if(Constants.Transaction.AMOUNT_TYPE_TWO.equals(amountType)){//支付保证金成功 生成竞标信息
                Map<String, String> bidMap=new HashMap<String, String>();
                bidMap.put("goodsId", goodsId);
                bidMap.put("bidUser", userId);
                bidMap.put("shipId", shipId);
                bidMap.put("bidPrice", bidPrice);
                bidMap.put("pay", Constants.bidStatus.pay);
                bidMap.put("biding", Constants.bidStatus.biding);
                bidMap.put("onLine", Constants.payType.onLine);
                bidMap.put("depositPercent", Constants.payPercent.depositPercent);
                goodsBidId = String.valueOf(goodsDao.createGoodsBidInfo(bidMap));
            }else if(Constants.Transaction.AMOUNT_TYPE_THREE.equals(amountType)){
                Map<String, String> orderMap = new HashMap<String, String>();
                orderMap.put("orderId", orderId);
                orderMap.put("goodsStatus", Constants.goodsOrderStatus.lastPay);
                orderDao.updateOrderStatus(orderMap);
            }else if(Constants.Transaction.AMOUNT_TYPE_FOUR.equals(amountType)){
                Map<String, String> orderMap = new HashMap<String, String>();
                orderMap.put("orderId", orderId);
                orderMap.put("goodsStatus", Constants.goodsOrderStatus.finish);
                orderDao.updateOrderStatus(orderMap);
            }
            
            Map<String, String> transactionMap = new HashMap<String, String>();
            
            //生成交易记录
            transactionMap.put("goodsBidId", goodsBidId);
            transactionMap.put("orderId", orderId);
            transactionMap.put("tradeNo", order_no);
            transactionMap.put("tradeType", Constants.Transaction.TRADE_TYPE_ONE);
            transactionMap.put("tradeAccount", buyer_account);
            transactionMap.put("tradeAmount", tradeAmount+"");
            transactionMap.put("amountType", amountType);
            transactionMap.put("paymentExplain", subject);
            transactionMap.put("userId", userId);
            transactionDao.createTransaction(transactionMap);
        }
    }
    
    
    /**
     * 
     * 生成交易记录
     * @see com.golden.transaction.service.TransactionService#createTransaction(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void createTransaction(String goodsOrderId, String goodsBidId, String tradeNo,
            String tradeType, String tradeAccount, String tradeAmount, String amountType, String paymentExplain,
            String userId) throws Exception{
        
        Map<String, String> map=new HashMap<String, String>();
        map.put("orderId", goodsOrderId);
        map.put("goodsBidId", goodsBidId);  
        map.put("tradeNo", tradeNo);
        map.put("tradeType", tradeType);
        map.put("tradeAccount", tradeAccount);
        map.put("tradeAmount", tradeAmount);
        map.put("amountType", amountType);
        map.put("paymentExplain", paymentExplain);
        map.put("orderId", goodsOrderId);
        map.put("userId", userId);
        transactionDao.createTransaction(map);
    }

}

