package com.golden.weixin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.weixin.ConfigUtil;
import com.golden.weixin.SHA1;
import com.golden.weixin.WeixinUtil;

@Controller
public class WxController {

	
	/**
	 * 微信js api验证--找电工页面
	 * @param request
	 * @param response
	 * @return
	 * @throws DataAccessException
	 * @throws Exception
	 */
	@RequestMapping("wx/getWxJSConfig")
	@ResponseBody
	public Map<String,Object> getWxJSConf(HttpServletRequest request,HttpServletResponse response){
		String PageUrl=request.getParameter("url");
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("appId", ConfigUtil.APPID);
//		String jsapi_ticket = (String) ((Object) request).getServletContext().getAttribute("jsapi_ticket");
		/*if(access_token == null || access_token=="" || "null".equals(access_token)){
			String url="https://api.weixin.qq.com/cgi-bin/token";
			String param="grant_type=client_credential&appid="+ConfigUtil.APPID+"&secret="+ConfigUtil.APP_SECRECT;
			String token=WeixinUtil.httpGet(url, param);
			JSONObject j=new JSONObject(token);
			
			
			
			access_token=(String) j.get("access_token");
			request.getServletContext().setAttribute("access_token", access_token);
		}*/
		
		/*String url_ticket="https://api.weixin.qq.com/cgi-bin/ticket/getticket";
		String param="access_token="+access_token+"&type=jsapi";
		String ticket=WeixinUtil.httpGet(url_ticket, param);
		JSONObject j=new JSONObject(ticket);
		jsapi_ticket=(String) j.get("ticket");
		request.getServletContext().setAttribute("jsapi_ticket", jsapi_ticket);*/
	
		
		
		long timestamp = new Date().getTime();
		String nonceStr = WeixinUtil.getRandomString(16);
		//String PageUrl = "http://whemap.3w.net579.com/yzjzfp_m/wx/test";
		StringBuilder sb = new StringBuilder();
		
//		sb.append("jsapi_ticket="+jsapi_ticket);
		sb.append("&noncestr="+nonceStr);
		sb.append("&timestamp="+timestamp);
		sb.append("&url="+PageUrl);
		String signature = new SHA1().getDigestOfString(sb.toString().getBytes());
		result.put("timestamp", timestamp);
		result.put("nonceStr", nonceStr);
		result.put("signature", signature);
		return result;
	}
	
	
}
