package com.golden.transaction.action;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.golden.transaction.service.TransactionService;
import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Event;
import com.pingplusplus.model.Webhooks;

/**
 * Created by Afon on 16/4/26.
 */
@Controller
public class Main 
{
    
    private static final Logger logger = LoggerFactory.getLogger(Main.class);  

    /**
     * Pingpp 管理平台对应的 API Key，api_key 获取方式：登录 [Dashboard](https://dashboard.pingxx.com)->点击管理平台右上角公司名称->开发信息-> Secret Key
     */
    private final static String apiKey = "sk_live_yDqzzHnrTW5KH4Oyf10qTG80";

    /**
     * Pingpp 管理平台对应的应用 ID，app_id 获取方式：登录 [Dashboard](https://dashboard.pingxx.com)->点击你创建的应用->应用首页->应用 ID(App ID)
     */
    private final static String appId = "app_q9yTyLD40800zHWL";

    /**
   * 设置请求签名密钥，密钥对需要你自己用 openssl 工具生成，如何生成可以参考帮助中心：https://help.pingxx.com/article/123161；
   * 生成密钥后，需要在代码中设置请求签名的私钥(rsa_private_key.pem)；
   * 然后登录 [Dashboard](https://dashboard.pingxx.com)->点击右上角公司名称->开发信息->商户公钥（用于商户身份验证）
   * 将你的公钥复制粘贴进去并且保存->先启用 Test 模式进行测试->测试通过后启用 Live 模式
   */

    // 你生成的私钥路径
    private final static String privateKeyFilePath =  (Main.class.getClassLoader().getResource("").toString()+"res/your_rsa_private_key.pem").replace("file:/", "");
    // 你生成的私钥路径
    private final static String pubKeyPath =  (Main.class.getClassLoader().getResource("").toString()+"res/pingpp_public_key.pem").replace("file:/", "");
    
    @Autowired
    TransactionService transactionService;
    
    @RequestMapping(value="toCreateCharge")
//    public  void getCharge(String userid,String amount, String subject, String body, String client_ip, String channel, String orderId,  HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception 
      public  void getCharge(HttpServletRequest request,HttpServletResponse response,HttpSession session){
    	response.setContentType("text/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
    	/*设置字符集为'UTF-8'*/
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = null;
    	JSONObject juser = new JSONObject();
    	
    	String amountType = request.getParameter("amountType");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");
        String channel = request.getParameter("channel");
        String userId = request.getParameter("userId");
        String amount = request.getParameter("amount");
        String goodsId = request.getParameter("goodsId")== null ? "":request.getParameter("goodsId");
        String shipId = request.getParameter("shipId")== null ? "":request.getParameter("shipId");
        String bidPrice = request.getParameter("bidPrice")== null ? "":request.getParameter("bidPrice");
        String orderId = request.getParameter("orderId")== null ? "":request.getParameter("orderId");
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>路径为："+privateKeyFilePath);
		//获取Ping++请求签名Key
//    	String relativelyPath= paymentService.getPingPrivateKey("Ping_rsa_private_key");
    	
        // 设置 API Key
        Pingpp.apiKey = apiKey;

        // 设置私钥路径，用于请求签名
        Pingpp.privateKeyPath = privateKeyFilePath;
        String chargeString = null;
        try 
    	{
        	String orderNo = new Date().getTime()+"1";// + Main.randomString(7);
			out=response.getWriter();
			
			chargeString = ChargeExample.runDemos(appId,userId, amount, subject, body, channel, orderNo, amountType,
			        orderId, shipId,  bidPrice, goodsId);
			
			juser.put("suc", "y");
	        juser.put("data", chargeString);
	        String jstr=juser.toString();
	        out.write(jstr);	
    	} 
    	catch (Exception e) 
    	{
    	    logger.error(">>>>>>>>>>>>>>>>>>>>>>>>Charge对象请求失败>>>>>>>>>>>>>>>",e);
    	    juser.put("suc", "y");
    	    juser.put("data", "null");
    	    String jstr=juser.toString();
            out.write(jstr);
		}finally{
		    if(out!=null){
		        out.close(); 
		    }
		}
    	
        
    }
    
    @RequestMapping(value="pingPayCallbacks")
    public  void pingPayCallbacks(HttpServletRequest request,HttpServletResponse response,HttpSession session)  throws JSONException 
    {
    	response.setContentType("text/json");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
    	/*设置字符集为'UTF-8'*/
    	response.setCharacterEncoding("UTF-8");
        StringBuffer jb = new StringBuffer();
		String line = null;
		try
		{
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
			{
				jb.append(line);
			}
			//获取签名对象
			String signature = request.getHeader("x-pingplusplus-signature");
			logger.info("**********************************签名值="+signature+"**************************************************");
			boolean result = verifyData(jb.toString(), signature, getPubKey());
	        System.out.println("************************验签结果：" + (result ? "通过" : "失败")+":***********************************");

			if(result)
			{
				//解析支付回调参数
			    transactionService.queryPingCallbacks(jb.toString(), signature);
	            response.setStatus(HttpStatus.SC_OK);
	            logger.info("********************************修改订单状态成功*************************");
			}
			else
			{
				response.setStatus(HttpStatus.SC_OK);
				logger.info("********************************修改订单状态失败（验签不通过）*************************");
			}
		}
		catch (Exception e)
		{
			logger.error(">>>>>>>>>>>>>>>>>>>>>>>>Ping++回调失败>>>>>>>>>>>>>>>",e);
		}
    }
    
    @RequestMapping(value="pingPayCallbacks1")
    protected void pingPayCallbacks1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        //获取头部所有信息
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key+" "+value);
        }
        // 获得 http body 内容
        BufferedReader reader = request.getReader();
        StringBuffer buffer = new StringBuffer();
        String string;
        while ((string = reader.readLine()) != null) {
            buffer.append(string);
        }
        reader.close();
        // 解析异步通知数据
        Event event = Webhooks.eventParse(buffer.toString());
        if ("charge.succeeded".equals(event.getType())) {
            response.setStatus(200);
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>支付成功>>>>>>>>>>>>>");
        } else if ("refund.succeeded".equals(event.getType())) {
            response.setStatus(200);
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>退款成功>>>>>>>>>>>>>");
        } else {
            response.setStatus(500);
        }
    }
    
    private static SecureRandom random = new SecureRandom();

    public static String randomString(int length) {
        String str = new BigInteger(130, random).toString(32);
        return str.substring(0, length);
    }
    
    /**
     * 读取文件, 部署 web 程序的时候, 签名和验签内容需要从 request 中获得
     * @param filePath
     * @return
     * @throws Exception
     */
    public static String getStringFromFile(String filePath) throws Exception {
        FileInputStream in = new FileInputStream(filePath);
        InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
        BufferedReader bf = new BufferedReader(inReader);
        StringBuilder sb = new StringBuilder();
        String line;
        do {
            line = bf.readLine();
            if (line != null) {
                if (sb.length() != 0) {
                    sb.append("\n");
                }
                sb.append(line);
            }
        } while (line != null);

        return sb.toString();
    }
    
    /**
	 * 获得公钥
	 * @return
	 * @throws Exception
	 */
	public PublicKey getPubKey() throws Exception 
	{
		//获取Ping++签名公钥
        String pubKeyString = getStringFromFile(pubKeyPath);
		
        pubKeyString = pubKeyString.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");
        byte[] keyBytes = Base64.decodeBase64(pubKeyString);

		// generate public key
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(spec);
		return publicKey;
	}

	/**
	 * 验证签名
	 * @param dataString
	 * @param signatureString
	 * @param publicKey
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 */
	public static boolean verifyData(String dataString, String signatureString, PublicKey publicKey)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        logger.info("=======================verifyData() in================ "); 
	    byte[] signatureBytes = Base64.decodeBase64(signatureString);
        Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initVerify(publicKey);
		signature.update(dataString.getBytes("UTF-8"));
		return signature.verify(signatureBytes);
	}
}
