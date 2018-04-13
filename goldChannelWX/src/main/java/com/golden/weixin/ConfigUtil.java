package com.golden.weixin;

public class ConfigUtil {
	/**
	 * 服务号相关信息
	 */
	
	/* 咸丰网格化
	 * AppID(应用ID)wx12e846e394cc7ac4
	AppSecret(应用密钥)4a59ceaf670ac44f8c55238e62b2e831 */
	
	/* 咸丰精准扶贫
	 * AppID(应用ID)wxc9183f6ef21e234e
	AppSecret(应用密钥)7440cee6424064b8793352f3c49c182a */
	
	/*测试号信息
	appID
	wx090c48b42aa7c676
	appsecret
	9cacf006ac53b0b91776aa8e0372f311*/
	/*汶上
	appID
	wx986e4158c5d36639
	appsecret
	57997f110ed3164c7304f5198df6a5bf*/
	
	 public final static String APPID = "wxa47ba5ed0b2d685a";//服务号的应用号 
//	 public final static String MCHID = "1264917501";//商户ID
	 public final static String APP_SECRECT = "47adbe4d79dd732f02c954ae20976c5c";//服务号的应用密码
	 public final static String TOKEN = "wsjzp";//服务号的配置token 
	 public final static String SIGN_TYPE = "MD5";//签名加密方式
	 //public final static String TEMPLATE_ID = "qORukYUO1qRCFesFFJ45kjIeBdrOhzKTr6znbeMI1EA";//模板消息模板id
	 public final static String SEND_TEMPLATE_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";//发送模板消息接口
	 //oauth2授权时回调action 
	 //http://xfjzfp.ngrok.natapp.cn/ 
	 public final static String THE_SERVER_URL="http://m.hjsdwl.com/goldChannelWX/"; 
	 public final static String REDIRECT_URI = THE_SERVER_URL+"redirect";
	 /**
	 * 微信基础接口地址
	 */
	 //oauth2授权接口(GET)
	 public final static String OAUTH2_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	 //刷新access_token接口（GET）
	 public final static String REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	 //拉取用户信息接口（GET）
	 public final static String SNSAPI_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	
}
