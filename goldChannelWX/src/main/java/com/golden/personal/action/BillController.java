/**
 * Project Name:goldChannel
 * File Name:Bill.java
 * Package Name:com.golden.personal.action
 * Date:2016年11月15日下午7:54:14
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
import com.golden.personal.po.BillInfo;
import com.golden.personal.po.MessageInfo;
import com.golden.personal.service.PersonalService;

/**
 * ClassName:Bill <br/>
 * Function: 账单 Controller层. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月15日 下午7:54:14 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class BillController {
    
 private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    
    @Autowired
    private PersonalService personalService;
    
    /*** 每页显示的最大行数*/
    private int maxSize=10;
    
    /**
     * selectMyBillInfo:查询我的账单列表. <br/>
     * @author zhoujq
     * @param response
     * @param userId 用户id
     * @param pageNum 需查询页
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectMyBillInfo")
    public void selectMyBillInfo(HttpServletResponse response, String userId , String pageNum) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            List<BillInfo> billInfoList=personalService.selectMyBillInfo(userId,
                    String.valueOf((Integer.parseInt(pageNum)-1)*maxSize+1),String.valueOf(Integer.parseInt(pageNum)*maxSize));
            
            juser.put("data", billInfoList);
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
}

