package com.golden.typenews.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.golden.common.Constants;
import com.golden.typenews.po.Information;
import com.golden.typenews.service.NewsService;
/**
 * 资讯Controller
 * @author xie
 */
@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	//分页 每页最大展示数
	int maxNum=10;
	/**
	 * 查询资讯列表
	 * @param type
	 * @param pageNum
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="showNewsListInfo")
	public void queryNewsListInfoBytype(String type,String pageNum,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out=null;
		JSONObject juser= new JSONObject();
		try {
			/* 设置格式为text/json */
			response.setContentType("text/json");
			/* 设置字符集为'UTF-8' */
			response.setCharacterEncoding("UTF-8");
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
			out=response.getWriter();
			if(null==pageNum||"".equals(pageNum))
			{
				pageNum="1";
			}
			List<Information> setNews= null;
			if(type.equals("5")){
                setNews = newsService.querySetNews();
            }
			List<Information> newsList=newsService.queryNewsListInfoBytype(type,maxNum * (Integer.parseInt(pageNum)-1)+1,maxNum * Integer.parseInt(pageNum));
			
			if(newsList.size()>0)
			{
				juser.put("newsList", newsList);
				juser.put("setNews", setNews);
			}else
			{
				juser.put("newsList", new ArrayList<Information>());
			}
			juser.put("suc", 'y');
			juser.put("msg", "查询成功");
			String jstr=juser.toString();
			out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
	 * 查询资讯详情
	 */
	@RequestMapping(value="showNewsDetails")
	public void queryNewsDetailsByid(String informationId,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out=null;
		JSONObject juser= new JSONObject();
		try {
			/* 设置格式为text/json */
			response.setContentType("text/json");
			/* 设置字符集为'UTF-8' */
			response.setCharacterEncoding("UTF-8");
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
			out=response.getWriter();
			Information newsDetails=newsService.queryNewsDetailsByid(informationId);
			//相关新闻
	        List<Information> newsList=newsService.queryRefer();
			juser.put("newsDetails", newsDetails);
			juser.put("newsList", newsList);
			juser.put("suc", 'y');
			juser.put("msg", "查询成功");
			String jstr=juser.toString();
			out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
}
