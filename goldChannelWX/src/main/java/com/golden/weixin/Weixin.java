package com.golden.weixin;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Weixin {
	
	@Resource
	private WeixinService weixinService;
	
	/**
     * 发送模板消息
     * appId 公众账号的唯一标识
     * appSecret 公众账号的密钥
     * openId 用户标识
     */
	@RequestMapping("send_template_message")
	@ResponseBody
    public String  send_template_message(HttpServletRequest request) {
    	ServletContext c=request.getSession().getServletContext();
		String access_token=c.getAttribute("access_token").toString();
		
		String firstValue=request.getParameter("firstValue");//面试标语
		String keyword1Value=request.getParameter("keyword1Value");//面试时间
		String keyword2Value=request.getParameter("keyword2Value");//面试地点
		String keyword3Value=request.getParameter("keyword3Value");//所需材料
		String keyword4Value=request.getParameter("keyword4Value");//联系电话
		String remarkValue=request.getParameter("remarkValue");//备注
		String opendId=request.getParameter("opendId");//面试接受者的微信openId,用户注册时会添加到user表中
        
        Map<String, Object> map=new HashMap<>();
        Map<String, Object> data=new HashMap<>();
        
        Map<String, Object> first=new HashMap<>();   
        first.put("value", firstValue);
        data.put("first", first);
        
        Map<String, Object> keyword1=new HashMap<>();
        keyword1.put("value",keyword1Value);
        data.put("keyword1", keyword1);
        
        Map<String, Object> keyword2=new HashMap<>();
        keyword2.put("value", keyword2Value);
        data.put("keyword2", keyword2);
        
        Map<String, Object> keyword3=new HashMap<>();
        keyword3.put("value", keyword3Value);
        data.put("keyword3", keyword3);
        
        Map<String, Object> keyword4=new HashMap<>();
        keyword4.put("value", keyword4Value);
        data.put("keyword4", keyword4);
        
        Map<String, Object> remark=new HashMap<>();
        remark.put("value", remarkValue);
        data.put("remark", remark);

        map.put("data", data);
        map.put("touser", opendId);
        map.put("template_id", "填写模板ID");
        
        String jsonString = new JSONObject(map).toString();
        
        String r=weixinService.send_template_message(access_token,jsonString);
        return r;
    }
	
	
	
	
	// 验证Token
	@RequestMapping("/checkToken")
	public void checkToken(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		if(isGet){//判断是不是get请求
			System.out.println("进入get请求！");
			
			String TOKEN = ConfigUtil.TOKEN;
			// 微信加密签名
			String signature = request.getParameter("signature");
			// 随机字符串
			String echostr = request.getParameter("echostr");
			// 时间戳
			String timestamp = request.getParameter("timestamp");
			// 随机数
			String nonce = request.getParameter("nonce");
			System.out.println(signature + "-----------" + echostr + "---------"
					+ timestamp);

			String[] str = { TOKEN, timestamp, nonce };
			Arrays.sort(str); // 字典序排序
			String bigStr = str[0] + str[1] + str[2];
			// SHA1加密
			String digest = new SHA1().getDigestOfString(bigStr.getBytes())
					.toLowerCase();

			// 确认请求来至微信
			if (digest.equals(signature)) {
				response.getWriter().print(echostr);
			}
		}else{
			System.out.println("进入post请求！");
			try {
				//acceptMessage(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
