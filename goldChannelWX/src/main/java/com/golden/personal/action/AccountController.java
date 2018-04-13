/**
 * Project Name:goldChannel
 * File Name:AccountController.java
 * Package Name:com.golden.personal.action
 * Date:2016年11月22日上午11:38:14
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.personal.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.golden.goods.action.GoodsController;
import com.golden.login.po.UserBean;
import com.golden.personal.service.PersonalService;

/**
 * ClassName:AccountController <br/>
 * Function: 账户 Controller层. <br/>
 * Date:     2016年11月22日 上午11:38:14 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class AccountController {
 private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    
    @Autowired
    private PersonalService personalService;
    
    /**
     * selectMyAccountInfo:查询我的账户. <br/>
     * @author zhoujq
     * @param response
     * @param userId 用户id
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectMyAccountInfo")
    public void selectMyAccount(HttpServletResponse response, String userId) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            UserBean myAccount=personalService.selectMyAccount(userId);
            
            juser.put("data", myAccount);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询我的账户异常:"+e.getMessage());
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
     * updateMyAccount:更新我的账户. <br/>
     * @author zhoujq
     * @param response
     * @param userBean 用户信息
     * @since JDK 1.7
     */
    @RequestMapping(value="/updateMyAccount")
    public void updateMyAccount(HttpServletResponse response, UserBean userBean) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            personalService.updateMyAccount(userBean);

            juser.put("suc", 'y');
            juser.put("msg", "操作成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新我的账户异常:"+e.getMessage());
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

     * deleteMyAccount:账户解绑. <br/>
     * @author zhoujq
     * @param response
     * @param userId 用户id
     * @param type 1.支付宝 2.微信
     * @since JDK 1.7
     */
    @RequestMapping(value="/deleteMyAccount")
    public void deleteMyAccount(HttpServletResponse response, String userId ,String type) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            personalService.deleteMyAccount(userId,type);

            juser.put("suc", 'y');
            juser.put("msg", "操作成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("账户解绑异常:"+e.getMessage());
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
}

