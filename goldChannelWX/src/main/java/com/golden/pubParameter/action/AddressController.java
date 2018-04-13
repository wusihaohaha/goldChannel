/**
 * Project Name:goldChannel
 * File Name:AddressController.java
 * Package Name:com.golden.pubParameter.action
 * Date:2016年10月27日下午2:37:46
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.pubParameter.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.golden.common.Constants;
import com.golden.goods.action.GoodsController;
import com.golden.pubParameter.po.AddressInfo;
import com.golden.pubParameter.service.AddressService;

/**
 * ClassName:AddressController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年10月27日 下午2:37:46 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class AddressController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    
    @Autowired
    private AddressService addressService;
    
/**
     * selectAddressByKey:通过key查询子地址. <br/>
     * @author zhoujq
     * @param response
     * @param key key值  空值的场合查省份
     * @param type 类型  1:省下的港口  其他场合传空值
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectAddressByKey")
    public void selectAddressByKey (HttpServletResponse response,String key ,String type) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();

            if(key==null ||key.length()<=0){
                key="0";
            }
            
            List<AddressInfo> addressInfoList=null;
            if(type!=null && type.equals("1")){
                addressInfoList= addressService.selectPortByProvince(key);
            }else{
                addressInfoList= addressService.selectAddressByParentkey(key);
            }
            
            juser.put("data", addressInfoList);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
            
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectAddressByKey异常:"+e.getMessage());
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
     * selectAddressInfo:查询地址(所有省、所有港口及港口与省的关联). <br/>
     * @author zhoujq
     * @param response
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectAddressInfo")
    public void selectAddressInfo (HttpServletResponse response) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();

            //所有省
            List<AddressInfo> provinceInfoList = addressService.selectAddressByParentkey("0");
            //所有港口及与省的关联
            List<AddressInfo> portInfoList=addressService.selectAllPortInfo();

            Map<String, List<AddressInfo>> map =new HashMap<String, List<AddressInfo>>();
            map.put("allProvince", provinceInfoList);
            map.put("allPort", portInfoList);
            
            juser.put("data", map);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
            
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectAddressInfo异常:"+e.getMessage());
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
     * selectAllInfo:查询地址(所有省、所有市、所有港口). <br/>
     * @author zhoujq
     * @param response
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectAllInfo")
    public void selectAllInfo (HttpServletResponse response) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();

            //所有省
            List<AddressInfo> provinceInfoList=addressService.selectAllInfo(Constants.AddressType.province);
            //所有市
            List<AddressInfo> cityInfoList=addressService.selectAllInfo(Constants.AddressType.city);
            //所有港口
            List<AddressInfo> portInfoList=addressService.selectAllInfo(Constants.AddressType.port);

            Map<String, List<AddressInfo>> map =new HashMap<String, List<AddressInfo>>();
            map.put("allProvince", provinceInfoList);
            map.put("allCity", cityInfoList);
            map.put("allPort", portInfoList);
            
            juser.put("data", map);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
            
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectAddressInfo异常:"+e.getMessage());
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
     * createWharf:添加码头. <br/>
     * @author zhoujq
     * @param response
     * @param parentKey 父key
     * @param wharf 码头名称
     * @since JDK 1.7
     */
    @RequestMapping(value="/createWharf")
    public void createWharf (HttpServletResponse response,String parentKey,String wharf) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();

            addressService.createWharf(parentKey,wharf,Constants.AddressType.wharf);//添加码头
            
            juser.put("suc", 'y');
            juser.put("msg", "添加成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加码头异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "添加失败");
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

