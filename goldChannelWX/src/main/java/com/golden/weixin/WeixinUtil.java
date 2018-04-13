package com.golden.weixin;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

//import net.coobird.thumbnailator.Thumbnails;

import org.json.JSONObject;

//import com.whemap.common.util.Constant;
//import com.whemap.modules.attachment.entity.Attachment;

public class WeixinUtil {
	public static String httpPost(String url, Object param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
		
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return result;
	}

	public static String httpGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段

			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("DATE:"+new Date().toString());
		System.out.println("URL："+url);
		System.out.println("RESULT："+result);
		return result;
	}

	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	/**
    * 根据文件id下载文件
    * 
    * @param mediaId
    *            媒体id
    * @throws Exception
    */
//	public static Attachment downWxImg(HttpServletRequest request, String mediaId, String refId) {
//		String access_token = (String) request.getServletContext()
//				.getAttribute("access_token");
//		if (access_token == null || access_token == ""
//				|| "null".equals(access_token)) {
//			String url = "https://api.weixin.qq.com/cgi-bin/token";
//			String param = "grant_type=client_credential&appid="
//					+ ConfigUtil.APPID + "&secret=" + ConfigUtil.APP_SECRECT;
//			String token = WeixinUtil.httpGet(url, param);
//			JSONObject j = new JSONObject(token);
//			access_token = (String) j.get("access_token");
//			request.getServletContext().setAttribute("access_token",
//					access_token);
//		}
//		String url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="
//				+ access_token + "&media_id=" + mediaId;
//		
//		 HttpURLConnection httpURLConnection = null;  
//	     OutputStream out = null;  
//	     InputStream in = null;  
//	     Attachment attachment =null;
//		
//		try {
//			
//			 URL sendUrl = new URL(url);  
//	            httpURLConnection = (HttpURLConnection) sendUrl.openConnection();  
//	            httpURLConnection.setRequestMethod("POST");  
//	            httpURLConnection.setRequestProperty("contentType", "utf-8");  
//	            httpURLConnection.setDoOutput(true);   
//	            httpURLConnection.setUseCaches(false);  
//	            httpURLConnection.setConnectTimeout(3000);  
//	            httpURLConnection.setReadTimeout(3000);  
//	            httpURLConnection.setRequestProperty(  
//	                    "User-agent",InetAddress.getLocalHost().getHostAddress() + ":"  
//	                            + System.getProperty("catalina.home"));  
//	            out = httpURLConnection.getOutputStream();  
//	            // 清空缓冲区数据  
//	            out.flush();  
//	            // 获取HTTP状态码  
//	            int httpStatusCode = httpURLConnection.getResponseCode();  
//	            if(httpStatusCode!=200){  
//	                throw new RuntimeException("异常");  
//	            }  
//	            in = httpURLConnection.getInputStream();  
//	            // 获取文件长度  
//	            int len = httpURLConnection.getContentLength(); 
//	            
//	            String attachmentId=new SimpleDateFormat("yyyyMMddHHmmssSSS")
//				.format(new Date());
//	            String attachmentName="帮扶活动照片"+attachmentId;
//	            
//	            //微信名称(一大长串字母)
//	            String filename = httpURLConnection.getHeaderField("Content-disposition").split(
//						"=\"")[1].replace("\"", "");
//
//			
//	            
//	            String dateStr=new SimpleDateFormat("yyyy/MM/dd").format(new Date());
//	     		String path=Constant.UPLOAD_PATH+dateStr+"/";
//	            
//			//构造GpAttachment对象
//			String fileType=filename.split("[.]")[1];
//			attachment = new Attachment();
//			attachment.setAttachmentId(attachmentId);
//			attachment.setName(attachmentName);
//			attachment.setDescription(null);
//			attachment.setType(fileType);
//			attachment.setTime(new Date());
//			attachment.setFileSize((long)len);
//			attachment.setPath(path+attachmentId+"."+fileType);
//			attachment.setRefId(refId != null ? refId.toString() : null);
//			attachment.setRefType(null);
//			attachment.setSource("yzjzfp_m");
//			attachment.setIsConverted("0");
//			
//			//保存文件
//			byte[] byteDatas = new byte[len];  
//	        BufferedOutputStream bw = null;  
//	        try {  
//	            // 创建文件对象  
//	            File f = new File(attachment.getPath());  
//	            // 创建文件路径  
//	            if (!f.getParentFile().exists())  
//	                f.getParentFile().mkdirs();  
//	            // 写入文件  
//	            bw = new BufferedOutputStream(new FileOutputStream(attachment.getPath()));  
//	            int bytesRead = 0;  
//	            while ((bytesRead = in.read(byteDatas, 0, byteDatas.length)) != -1) {  
//	                bw.write(byteDatas, 0, bytesRead);  
//	            }  
//	            //生成缩略图文件路径
//	            String filePath=attachment.getPath();
//	    		String prefix=filePath.substring(filePath.lastIndexOf(".")+1);
//	    		String outFile=filePath.replaceAll("\\." + prefix + "$", "_s."+prefix);
//	    		//如果不存在才去生成缩略图
//	    		if(!new File(outFile).exists()){
//	    		Thumbnails.of(filePath).size(72,72).toFile(outFile);
//	    		}
//	        } catch (Exception e) {  
//	            e.printStackTrace();  
//	            throw e;  
//	        } finally {  
//	            try {  
//	                if (bw != null)  
//	                    bw.close();  
//	            } catch (Exception e) {  
//	                throw e;  
//	            }  
//	        }
//			
//		} catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            if (out != null) {  
//                try {  
//                    out.close();  
//                } catch (Exception e) {  
//                    e.printStackTrace();  
//                    throw new RuntimeException(e.getMessage());  
//                }  
//            }  
//            if (in != null) {  
//                try {  
//                    in.close();  
//                } catch (Exception e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//            if (httpURLConnection != null) {  
//                httpURLConnection.disconnect();  
//                httpURLConnection = null;  
//            }  
//        } 
//		
//		return attachment; 
//	}
	
	/**  
	* @description: 获取getAccessToken
	* @author webmaster@sunow.org 
	* @date 2016年3月1日 下午11:32:23 
	* @return
	*/ 
	public static  Map<String,String> getAccessToken(){
		
		String url="https://api.weixin.qq.com/cgi-bin/token";
		String param="grant_type=client_credential&appid="+ConfigUtil.APPID+"&secret="+ConfigUtil.APP_SECRECT;
		String token=WeixinUtil.httpGet(url, param);
		JSONObject j=new JSONObject(token);
	
		String access_token=(String) j.get("access_token");
			
			
		String url_ticket="https://api.weixin.qq.com/cgi-bin/ticket/getticket";
		String param_ticket="access_token="+access_token+"&type=jsapi";
		String ticket=WeixinUtil.httpGet(url_ticket, param_ticket);
		JSONObject jt=new JSONObject(ticket);
		String jsapi_ticket=(String) jt.get("ticket");
		
		 Map<String,String> map=new HashMap<>();
		 map.put("access_token", access_token);
		 map.put("jsapi_ticket", jsapi_ticket);
		 return map;
		
	}
	
	
	
}
