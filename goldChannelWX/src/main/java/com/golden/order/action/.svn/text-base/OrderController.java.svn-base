/**
 * Project Name:goldChannel
 * File Name:OrderController.java
 * Package Name:com.golden.order.action
 * Date:2016年11月8日下午4:13:26
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.order.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.golden.common.Constants;
import com.golden.common.FileOperateUtil;
import com.golden.common.FileUploadCommon;
import com.golden.order.po.ShipOrderInfo;
import com.golden.order.service.OrderService;
import com.golden.pubParameter.service.PictureRootPathService;

/**
 * ClassName:OrderController <br/>
 * 数据信息展示Controller层
 * 订单信息
 * Date:     2016年11月8日 下午4:13:26 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    
    @Autowired
    private OrderService orderService;
    @Autowired
    private PictureRootPathService pictureRootPathService;
    
    /*** 每页显示的最大行数*/
    private int maxSize=10;
    
    /**
     * selectMyOrder:查询我的订单. <br/>
     * @author zhoujq
     * @param response
     * @param userId 用户ID
     * @param pageNum 需查询页
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectMyOrder")
    public void selectMyOrder(HttpServletResponse response,String userId ,String pageNum) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            List<ShipOrderInfo> myOrderInfoList= orderService.selectMyOrder(userId,Constants.goodsOrderStatus.delete,Constants.shippingOrderStatus.delete,
                    String.valueOf((Integer.parseInt(pageNum)-1)*maxSize+1),String.valueOf(Integer.parseInt(pageNum)*maxSize));
            
            juser.put("data", myOrderInfoList);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("我的订单查询异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * uploadBidFile:上传合同文件. <br/>
     * @author zhoujq
     * @param response
     * @param request
     * @param session
     * @param orderId 订单ID
     * @param userId 用户ID
     * @since JDK 1.7
     */
    @RequestMapping(value="/uploadBidFile")
    public void uploadBidFile(HttpServletResponse response, HttpServletRequest request ,HttpSession session,String orderId,String userId) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
          //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            //获取系统文件保存路径
            String localUrl = pictureRootPathService.getPicRoot(session, FileUploadCommon.ROOTPATH_ID);
            // 文件保存目录路径
            String fileSavePath = localUrl+FileUploadCommon.BACK_SLASH+Constants.picturePath.bidFilePic;
            String controlName="1";//控件名称
            String postfix=".jpg";//图片后缀
            //上传图片并获取图片路径list
            List<String> strReturnList=FileOperateUtil.uploadFile(request,fileSavePath,controlName,postfix);
            
            //更新合同文件
            orderService.updateBidFile(orderId,userId,Constants.picturePath.Upload_bidFilePic+strReturnList.get(0).toString());
            
            juser.put("suc", 'y');
            juser.put("msg", "上传成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传合同文件异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "上传失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * selectBidFile:查看我的合同. <br/>
     * @author zhoujq
     * @param response
     * @param orderId 订单ID
     * @param userId 用户ID
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectBidFile")
    public void selectBidFile(HttpServletResponse response,String orderId,String userId ) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            ShipOrderInfo bidFileInfo= orderService.selectBidFile(orderId,userId);
            
            juser.put("data", bidFileInfo);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("合同查询异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * operateOrder:订单操作. <br/>
     * @author zhoujq
     * @param response
     * @param orderId 订单ID
     * @param type 操作类型 1:支付首款 2:支付尾款 3：确认收到首款 4:确认收到尾款 5:（货方）删除订单 6:（船方）删除订单
     * @since JDK 1.7
     */
    @RequestMapping(value="/operateOrder")
    public void operateOrder(HttpServletResponse response, String orderId, String type) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            String goodsStatus="";//货方状态
            String shipStatus="";//船方状态

            switch (type) {
            case "1":
                goodsStatus=Constants.goodsOrderStatus.lastPay;
                break;
            case "2":
                goodsStatus=Constants.goodsOrderStatus.finish;
                break;
            case "3":
                shipStatus=Constants.shippingOrderStatus.lastConfirm;
                break;
            case "4":
                shipStatus=Constants.shippingOrderStatus.finish;
                break;
            case "5":
                goodsStatus=Constants.goodsOrderStatus.delete;
                break;
            case "6":
                shipStatus=Constants.shippingOrderStatus.delete;
                break;
            default:
                break;
            }

            //更新订单状态
            orderService.updateOrderStatus(orderId,goodsStatus,shipStatus);

            juser.put("suc", 'y');
            juser.put("msg", "操作成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("我的订单操作异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * selectOrderDetailInfo:查看订单详情. <br/>
     * @author zhoujq
     * @param response
     * @param orderId 订单ID
     * @param role 角色  1:货方 2:船方
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectOrderDetailInfo")
    public void selectOrderDetailInfo(HttpServletResponse response,String orderId,String role) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            ShipOrderInfo orderDetailInfo= orderService.selectOrderDetailInfo(orderId,role);
            
            juser.put("data", orderDetailInfo);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("我的订单详情查询异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
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

