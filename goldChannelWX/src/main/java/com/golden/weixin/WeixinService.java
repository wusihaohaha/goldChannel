package com.golden.weixin;

import org.springframework.stereotype.Service;

@Service
public class WeixinService {

	
	public String send_template_message(String access_token,String data){
		String url = ConfigUtil.SEND_TEMPLATE_MESSAGE_URL+access_token;
		return WeixinUtil.httpPost(url, data);
	}
}
