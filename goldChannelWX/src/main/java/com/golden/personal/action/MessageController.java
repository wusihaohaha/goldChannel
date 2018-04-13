/**
 * Project Name:goldChannel
 * File Name:MessageController.java
 * Package Name:com.golden.personal.action
 * Date:2016年11月11日下午4:55:08
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.personal.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.golden.common.Constants;
import com.golden.goods.action.GoodsController;
import com.golden.personal.po.MessageInfo;
import com.golden.personal.service.PersonalService;

/**
 * ClassName:MessageController <br/>
 * Function: 消息中心. <br/>
 * Date:     2016年11月11日 下午4:55:08 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class MessageController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    
    @Autowired
    private PersonalService personalService;
    
    /*** 每页显示的最大行数*/
    private int maxSize=10;
    
    /**
     * sendMessageInfo:发送消息. <br/>
     * @author zhoujq
     * @param messageInfo 消息信息
     * @return
     * @since JDK 1.7
     */
    @RequestMapping(value="/sendMessageInfo")
    public String sendMessageInfo(MessageInfo messageInfo) {
        String strRetrun="发送消息失败";
        try {
            personalService.createMessageInfo(messageInfo);
            strRetrun="";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加消息信息异常:"+e.getMessage());
        }
        return strRetrun;
    }
    
    /**
     * selectMyMessageInfo:查询我的消息列表. <br/>
     * @author zhoujq
     * @param response
     * @param userId 用户id
     * @param type 类型  1:系统消息 2:个人消息
     * @param pageNum 需查询页
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectMyMessageInfo")
    public void selectMyMessageInfo(HttpServletResponse response, String userId ,String type , String pageNum) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            //查询消息列表；修改消息状态
            List<MessageInfo> messageInfoList=personalService.selectMessageInfo(userId,type,
                    String.valueOf((Integer.parseInt(pageNum)-1)*maxSize+1),String.valueOf(Integer.parseInt(pageNum)*maxSize));
            
            juser.put("data", messageInfoList);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询消息列表异常:"+e.getMessage());
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
     * deleteMessageById:删除消息. <br/>
     * @author zhoujq
     * @param response
     * @param messageId 消息id
     * @since JDK 1.7
     */
    @RequestMapping(value="/deleteMessageById")
    public void deleteMessageById(HttpServletResponse response, String messageId) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            personalService.deleteMessageById(messageId);
            
            juser.put("suc", 'y');
            juser.put("msg", "删除成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("消息删除异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "删除失败");
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
     * selectUnreadMessageCount:查询未读消息条数. <br/>
     * @author zhoujq
     * @param response
     * @param userId 用户id
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectUnreadMessageCount")
    public void selectUnreadMessageCount(HttpServletResponse response, String userId) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            int unreadCount=personalService.selectUnreadMessageCount(userId,Constants.MessageStatus.Unread);
            
            juser.put("unreadCount", unreadCount);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询未读消息条数异常:"+e.getMessage());
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

