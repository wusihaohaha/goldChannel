package com.golden.weixin;

import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoader;

/** 
* @description:  更新token
* @author webmaster@sunow.org 
* @date 2016年3月1日 下午11:34:55 
*/ 
public class DailyTaskJob {
	
	public DailyTaskJob (){
        System.out.println("jobs...............");
    }
    public void run() {
        System.out.println(" i running");
        try {
			 
			 ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
			 Map<String,String> map= WeixinUtil.getAccessToken();
			 servletContext.setAttribute("access_token", map.get("access_token"));
			 servletContext.setAttribute("jsapi_ticket", map.get("jsapi_ticket"));
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    }
}
