package com.golden.weixin;

import java.io.UnsupportedEncodingException;

import org.json.JSONObject;

import com.golden.weixin.entity.WeiXinOauth2Token;

public class WeiXinOauth2TokenUtil {

	// 第二步:通过code换取网页授权access_token
	public static WeiXinOauth2Token getOauth2AccessToken(String appId,
			String appSecret, String code) {
		WeiXinOauth2Token wat = new WeiXinOauth2Token();
		String requestUrl = ConfigUtil.OAUTH2_URL.replace("APPID", appId)
				.replace("SECRET", appSecret).replace("CODE", code);
		JSONObject jsonObject = new JSONObject(CommonUtil.httpsRequest(
				requestUrl, "GET", null));
		if (null != jsonObject) {
			try {
				wat = new WeiXinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefeshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;

			}

		}
		return wat;
	}

	// 第三步：刷新access_token（如果需要）(由于access_token拥有较短的有效期，当access_token超时后，可以使用refresh_token进行刷新，refresh_token拥有较长的有效期（7天、30天、60天、90天），当refresh_token失效的后，需要用户重新授权)
	public static WeiXinOauth2Token getOauth2NewAccessToken(String appId,
			String refresh_token) {
		WeiXinOauth2Token wat = new WeiXinOauth2Token();
		String requestUrl = ConfigUtil.REFRESH_TOKEN_URL
				.replace("APPID", appId)
				.replace("REFRESH_TOKEN", refresh_token);
		JSONObject jsonObject = new JSONObject(CommonUtil.httpsRequest(
				requestUrl, "GET", null));
		if (null != jsonObject) {
			try {
				wat = new WeiXinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefeshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;
			}

		}
		return wat;
	}

	// 第四步：拉取用户信息(需scope为 snsapi_userinfo)
	public static WeiXinOauth2Token getOauth2User(String access_token,
			String openid) {
		WeiXinOauth2Token wat = new WeiXinOauth2Token();
		String requestUrl = ConfigUtil.SNSAPI_USERINFO_URL.replace(
				"ACCESS_TOKEN", access_token).replace("OPENID", openid);
		JSONObject jsonObject = new JSONObject(CommonUtil.httpsRequest(
				requestUrl, "GET", null));
		System.err.println(jsonObject.toString());
		if (null != jsonObject) {
			try {
				wat = new WeiXinOauth2Token();
				// wat.setNickname(jsonObject.get("nickname").toString());
				wat.setSex(jsonObject.get("sex").toString().equals("1") ? "男"
						: "女");
				wat.setProvince(jsonObject.getString("province"));
				wat.setCity(jsonObject.getString("city"));
				wat.setHeadimgurl(jsonObject.getString("headimgurl"));
			} catch (Exception e) {
				e.printStackTrace();
				wat = null;
			}

		}
		return wat;
	}

	// 转码
	public static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
