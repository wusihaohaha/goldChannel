package com.golden.weixin;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.golden.common.Encrypt;
import com.golden.login.service.LoginService;
import com.golden.search.action.SearchController;

import net.sf.json.JSONObject;

//import com.whemap.common.util.JsonUtils;
//import com.whemap.modules.povertyhelp.service.AntiPovertyService;
/**
 * 专门用来获取用户基本信息的控制类
 * @author ZJT
 *
 */
@Controller
public class WXUserInfoController {
	
	private String server_url=ConfigUtil.THE_SERVER_URL;//  服务器地址  正式  发布的时候 就换这一条
    private static final Logger logger = LoggerFactory.getLogger(WXUserInfoController.class);
    @Autowired
    private LoginService loginService;

	
	/**
	 * 获取微信用户信息   使用需要传入一个重定向的Url(back_url)最后转到的页面
	 * 在该页 如果流程走成功的话  会得到两个Map的session数据
	 * 1：wxUserInfo  :用户的微信信息
	 * 2：accessTokenInfo  : 用户的accessToken信息
	 * **应该在用完之后及时清除两个session数据**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("wx/getWxUserInfo")
	public void getWxUserInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String backUrl=request.getParameter("back_url");
		String redirectUrl=URLEncoder.encode(server_url+"wx/getWxUserInfoRedirect", "UTF-8");
		String responseUrl="https://open.weixin.qq.com/connect/oauth2/authorize";
		String stateStr=backUrl;
		
		responseUrl+="?appid="+ConfigUtil.APPID;
		responseUrl+="&redirect_uri="+redirectUrl;
		responseUrl+="&response_type=code";
		responseUrl+="&scope=snsapi_userinfo";//snsapi_base[不出获取信息框只能获取用户openId] snsapi_userinfo[出获取信息提示框可以获取用户基本信息]
		responseUrl+="&state="+stateStr;
		responseUrl+="#wechat_redirect";
		response.sendRedirect(responseUrl);
	}
	
//	@SuppressWarnings("unchecked")
//	@RequestMapping("wx/getWxUserInfoRedirect")
//	public void getWxUserInfoRedirectx(HttpServletRequest request,HttpServletResponse response) throws IOException{
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		
//		Map<String, Object> returnMap=null;
//		HttpSession session=request.getSession();
//		
//		String code = request.getParameter("code");
//		String state = request.getParameter("state");
//		if(code!=null&&!code.equals("")){
//			//1首先通过code获取accsss_token以及用户open_id
//			String getAccess_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+ConfigUtil.APPID+"&secret="+ConfigUtil.APP_SECRECT+"&code="+code+"&grant_type=authorization_code";
//			String tokenStr=CommonUtil.httpsRequest(getAccess_token_url,"GET",null);
//			Map<String,Object> tokenMap=JsonUtils.readValue(tokenStr,Map.class);
//			if(!tokenMap.isEmpty()&&tokenMap.get("access_token")!=null){
//				String access_token=tokenMap.get("access_token").toString();//注意：此access_token与基础支持的access_token不同
//				String openid=tokenMap.get("openid").toString();//用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
//				
//				//如果session中没有openID 则更新
//				if(session.getAttribute("wxOpenId")==null){
//					updateDynamicOpenId(openid,session.getAttribute("STAFF_ID").toString());
//					session.setAttribute("wxOpenId",openid);
//				}
//				
//				//2获取用户信息
//				String getWxUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
//				String wxUserStr=CommonUtil.httpsRequest(getWxUserInfoUrl, "GET", null);
//				returnMap=JsonUtils.readValue(wxUserStr,Map.class);
//				session.setAttribute("wxUserInfo", returnMap);
//			}
//		}
//		//把存入session
//		if(returnMap!=null){
//			session.setAttribute("wxNickname",returnMap.get("nickname"));
//		}
//		response.sendRedirect(state);//跳转
//	}
	
	
    @SuppressWarnings({ "unchecked", "null" })
    @RequestMapping("wx/getWxUserInfoRedirect")
    public void getWxUserInfoRedirect(HttpServletRequest request,HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        /* 设置格式为text/json */
        response.setContentType("text/json");
        
        JSONObject juser = new JSONObject();
        PrintWriter out = null;
        
        //Map<String, Object> returnMap=null;
//        HttpSession session=request.getSession();
        
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        out = response.getWriter();
        if(code!=null&&!code.equals("")){
            
            try {
                //1首先通过code获取accsss_token以及用户open_id
                String getAccess_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+ConfigUtil.APPID+"&secret="+ConfigUtil.APP_SECRECT+"&code="+code+"&grant_type=authorization_code";
                String tokenStr=CommonUtil.httpsRequest(getAccess_token_url,"GET",null);
                System.out.println(">>>>>>>>>>>>>"+tokenStr);
                JSONObject tokenJson = JSONObject.fromObject(tokenStr);
    //            Map<String,Object> tokenMap=JsonUtils.readValue(tokenStr,Map.class);
                if(!tokenJson.isEmpty()&&tokenJson.get("access_token")!=null){
                    String access_token=tokenJson.getString("access_token");//注意：此access_token与基础支持的access_token不同
                    String openid=tokenJson.getString("openid");//用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID

                    //如果session中没有openID 则更新
    //                if(session.getAttribute("wxOpenId")==null){
    //                    updateDynamicOpenId(openid,session.getAttribute("STAFF_ID").toString());
    //                    session.setAttribute("wxOpenId",openid);
    //                }
                    
                    //2获取用户信息
                    String getWxUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
                    String wxUserStr=CommonUtil.httpsRequest(getWxUserInfoUrl, "GET", null);
                    System.out.println(">>>>>>>>>>>>>"+wxUserStr);
                    
                    if(wxUserStr!=null){
                        juser = JSONObject.fromObject(wxUserStr);
                        //3插入WX_USER表数据
                        loginService.addRegisterUser(juser.getString("openid"), juser.getString("nickname"),juser.getString("province"), juser.getString("city"),juser.getString("sex"), juser.getString("headimgurl"));
                    }
                    juser.put("url", state);
                    String jstr=juser.toString();
                    out.write(jstr);
//                returnMap=JsonUtils.readValue(wxUserStr,Map.class);
//                session.setAttribute("wxUserInfo", returnMap);
                }
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                logger.error("查询异常:", e.getMessage());
                juser.put("suc", 'n');
                juser.put("msg", "查询失败");
                String jstr=juser.toString();
                out.write(jstr);
            }
        }else{
            logger.error("查询异常token为空:");
            juser.put("suc", 'n');
            juser.put("msg", "查询失败,token为空:");
            String jstr=juser.toString();
            out.write(jstr);
        }
        //把存入session
//        if(returnMap!=null){
//            session.setAttribute("wxNickname",returnMap.get("nickname"));
//        }
//        response.sendRedirect(state);//跳转
    }
	
//	private Integer updateDynamicOpenId(String openId,String staffId){
//		try {
//			antiPovertyService.updateDynamicOpenId(openId, staffId);
//			return 1;
//		} catch (Exception e) {
//			System.err.println("添加OpenId失败 staffID="+staffId);
//			return 0;
//		}
//	}
	
//	@Resource
//	private AntiPovertyService antiPovertyService;
}
