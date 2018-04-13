/**
 * Project Name:goldChannel
 * File Name:transactionService.java
 * Package Name:com.golden.transaction.service
 * Date:2016年11月16日下午3:50:39
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.transaction.service;
/**
 * ClassName:transactionService <br/>
 * Function: 交易记录 Service 层
 * Date:     2016年11月16日 下午3:50:39 <br/>
 * @author   wusihao
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface TransactionService {
    
    
    /**
     * 解析P++支付回调参数
     * @param string
     */
    void queryPingCallbacks(String string, String signature) throws Exception;
    
    /**
     * 
     * 生成交易记录
     * @author wusihao
     * @param goodsOrderId 订单ID  来源：订单信息表.订单ID
     * @param goodsBidId 竞标ID  来源：竞标信息表.竞标ID
     * @param tradeNo 交易单号（支付宝交易号）
     * @param tradeType 交易类型 1:转入 2:转出
     * @param tradeAccount 对方账号
     * @param tradeAmount 支付金额
     * @param amountType 金额类型  1:支付 2:保证金 3:首付款 4:尾款
     * @param paymentExplain 交易说明
     * @param userId 支付用户  来源：用户信息表.用户ID
     * @since JDK 1.7
     */
    void createTransaction(String goodsOrderId, String goodsBidId, String tradeNo, String tradeType, String tradeAccount,
                String tradeAmount, String amountType, String paymentExplain, String userId) throws Exception;
    
}

