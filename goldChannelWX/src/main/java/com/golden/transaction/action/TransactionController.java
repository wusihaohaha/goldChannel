/**
 * Project Name:goldChannel
 * File Name:TransactionController.java
 * Package Name:com.golden.transaction.action
 * Date:2016年11月17日上午9:46:13
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.transaction.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.golden.common.Constants;
import com.golden.order.action.OrderController;
import com.golden.order.service.OrderService;
import com.golden.transaction.service.TransactionService;

import net.sf.json.JSONObject;


/**
 * ClassName:TransactionController
 * Function: 交易信息Controller层
 * Date:     2016年11月17日 上午9:46:13 <br/>
 * @author   wusihao
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
@RequestMapping(value="/transaction")
public class TransactionController {
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
    
    @Autowired
    TransactionService transactionService;
    @Autowired
    OrderService orderService;
    
    @RequestMapping(value="/makeTransaction")
    public void makeTransaction(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out = null;
        JSONObject juser = new JSONObject(); 
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            String goodsOrderId = request.getParameter("goodsOrderId");//订单ID  来源：订单信息表.订单ID
            String goodsBidId = request.getParameter("goodsBidId");//竞标ID  来源：竞标信息表.竞标ID
            String tradeNo = request.getParameter("tradeNo");//交易单号（支付宝交易号）
            String tradeType = request.getParameter("tradeType");//交易类型 1:转入 2:转出
            String tradeAccount = request.getParameter("tradeAccount");// 对方账号
            String tradeAmount = request.getParameter("tradeAmount");// 支付金额
            String amountType = request.getParameter("amountType");//金额类型  1:支付 2:保证金 3:首付款 4:尾款
            String theFirstPayment = request.getParameter("theFirstPayment");//首付款
            String amount = request.getParameter("amount");//总金额
            String userId = request.getParameter("userId");// 支付用户  来源：用户信息表.用户ID
            String paymentExplain = request.getParameter("userId");//交易说明
            String systemStatus = null;
            if(Constants.Transaction.TRADE_TYPE_ONE.equals(tradeType)){ //转入
                if(Constants.Transaction.AMOUNT_TYPE_TWO.equals(amountType)){ //保证金
                    paymentExplain = Constants.Transaction.PAYMENT_EXPLAIN_ONE;
                }
                if(Constants.Transaction.AMOUNT_TYPE_THREE.equals(amountType)){ //首款
                    paymentExplain = Constants.Transaction.PAYMENT_EXPLAIN_THREE;
                    tradeAmount = theFirstPayment;
                    
                    //修改订单状态、发送消息
                    String payType=Constants.payType.onLine;//支付方式 线上
                    String type="1";//操作方式 支付首款
                    OrderController orderController =new OrderController();
                    orderController.operateOrder(response, goodsOrderId, type);
                    
                }
                if(Constants.Transaction.AMOUNT_TYPE_FOUR.equals(amountType)){ //尾款
                    paymentExplain = Constants.Transaction.PAYMENT_EXPLAIN_FIVE;
                    tradeAmount = String.valueOf((Double.parseDouble(amount) - Double.parseDouble(theFirstPayment)));
                    
                    //修改订单状态、发送消息
                    String payType=Constants.payType.onLine;//支付方式 线上
                    String type="2";//操作方式 支付尾款
                    OrderController orderController =new OrderController();
                    orderController.operateOrder(response, goodsOrderId, type);
                }
            }else if(Constants.Transaction.TRADE_TYPE_TWO.equals(tradeType)){
                if(Constants.Transaction.AMOUNT_TYPE_TWO.equals(amountType)){ //保证金
                    paymentExplain = Constants.Transaction.PAYMENT_EXPLAIN_TWO;
                }
                if(Constants.Transaction.AMOUNT_TYPE_THREE.equals(amountType)){ //首款
                    paymentExplain = Constants.Transaction.PAYMENT_EXPLAIN_FOUR;
                    tradeAmount = theFirstPayment;
                    systemStatus = Constants.GoodsOrder.SYSTEM_STATUS_TWO;
                }
                if(Constants.Transaction.AMOUNT_TYPE_FOUR.equals(amountType)){ //尾款
                    paymentExplain = Constants.Transaction.PAYMENT_EXPLAIN_SIX;
                    tradeAmount = String.valueOf((Double.parseDouble(amount) - Double.parseDouble(theFirstPayment)));
                    systemStatus = Constants.GoodsOrder.SYSTEM_STATUS_THREE;
                }
            }
            
            transactionService.createTransaction(goodsOrderId, goodsBidId, tradeNo, tradeType, tradeAccount, tradeAmount, amountType, paymentExplain, userId);
            juser.put("returnCode", Constants.SUCCESS);
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>Exception occurred in makeTransaction",e);
            juser.put("returnCode", Constants.ERROR);
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
        
}

