package com.golden.search.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.golden.common.Constants;
import com.golden.search.po.ApkVersionInfo;
import com.golden.search.po.HomeInfo;
import com.golden.search.po.Material;
import com.golden.search.po.NoticeInfo;
import com.golden.search.po.OilInfo;
import com.golden.search.po.PartsInfo;
import com.golden.search.po.ShipCommonInfo;
import com.golden.search.po.ShipDealInfo;
import com.golden.search.service.SearchService;
import com.golden.ship.po.Ship;
/**
 * 数据信息展示Controller层
 * 目前包含运联盟，建筑材料，船舶配件，船舶交易等信息
 * @author xie
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	//分页 每页最大展示数
	int maxNum=10;
	/**
	 * 功能:查询运联盟信息 成员及企业
	 * @param membertype 1普通成员 2企业
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/queryShipMembers")
	public void queryShipMembers(String membertype,String pageNum,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         response.addHeader("Access-Control-Allow-Origin", "*");
			 response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			 response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 if(null==pageNum||"".equals(pageNum))
			 {
				 pageNum="1";
			 }
			 //通过类型查询相应的数据
			 List<ShipCommonInfo> shipCommonInfoList=searchService.queryShipMembersBytype(membertype,maxNum * (Integer.parseInt(pageNum)-1)+1,maxNum * Integer.parseInt(pageNum));
			 if(shipCommonInfoList.size()>0)
			 {
				 juser.put("data", shipCommonInfoList);
			 }else
			 {
				 juser.put("data", new ArrayList<ShipCommonInfo>());
			 }
			 juser.put("suc", 'y');
			 juser.put("msg", "查询成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询异常:", e.getMessage());
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
	 * 功能:查询配件列表
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/queryPartsList")
	public void queryPartsList(String partsname,String pageNum,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         response.addHeader("Access-Control-Allow-Origin", "*");
			 response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			 response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 if(null==pageNum||"".equals(pageNum))
			 {
				pageNum="1";
			 }
			 //通过类型查询相应的数据
			 List<PartsInfo> PartsInfoList=searchService.queryPartsListBytype(partsname,maxNum * (Integer.parseInt(pageNum)-1)+1,maxNum * Integer.parseInt(pageNum));
			 if(PartsInfoList.size()>0)
			 {
				 juser.put("data", PartsInfoList);
			 }else
			 {
				 juser.put("data", new ArrayList<PartsInfo>());
			 }
			 juser.put("suc", 'y');
			 juser.put("msg", "查询成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询异常:", e.getMessage());
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	/**
	 * 查询建材列表
	 * @param name
	 * @param pageNum
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/queryMaterialsList")
	public void queryMaterialsList(String name,String pageNum,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         response.addHeader("Access-Control-Allow-Origin", "*");
			 response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			 response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 if(null==pageNum||"".equals(pageNum))
			 {
				pageNum="1";
			 }
			 //通过类型查询相应的数据
			 List<Material> MaterialsInfoList=searchService.queryMaterialsList(name,maxNum * (Integer.parseInt(pageNum)-1)+1,maxNum * Integer.parseInt(pageNum));
			 if(MaterialsInfoList.size()>0)
			 {
				 juser.put("data", MaterialsInfoList);
			 }else
			 {
				 juser.put("data", new ArrayList<Material>());
			 }
			 juser.put("suc", 'y');
			 juser.put("msg", "查询成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询异常:", e.getMessage());
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
	 * 功能:根据配件id查询配件详情
	 * @param partsid 建材、配件id
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/queryPartdetailByid")
	public void queryPartdetailByid(String partsid,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         response.addHeader("Access-Control-Allow-Origin", "*");
			 response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			 response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 //通过配件id查询配件详情
			 PartsInfo partdetail=searchService.queryPartdetailByid(partsid);
			 juser.put("data", partdetail);
			 juser.put("suc", 'y');
			 juser.put("msg", "查询成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询异常:", e.getMessage());
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
	 * 根据建材id查询建材详情
	 * @param materialid
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/queryMaterialdetailByid")
	public void queryMaterialdetailByid(String materialid,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         response.addHeader("Access-Control-Allow-Origin", "*");
			 response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			 response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 //通过建材id查询建材详情
			 Material materialdetail=searchService.queryMaterialdetailByid(materialid);
			 juser.put("data", materialdetail);
			 juser.put("suc", 'y');
			 juser.put("msg", "查询成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询异常:", e.getMessage());
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
	 * 功能:查询船舶交易信息列表
	 * @param tradetype1:出售 2:出租
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/queryShipdealList")
	public void queryShipdealList(String tradetype,String pageNum,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         response.addHeader("Access-Control-Allow-Origin", "*");
			 response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			 response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 if(null==pageNum||"".equals(pageNum))
			 {
				pageNum="1";
			 }
			 //查询船舶交易信息列表
			 List<ShipDealInfo> ShipDealList=searchService.queryShipdealList(tradetype,maxNum * (Integer.parseInt(pageNum)-1)+1,maxNum * Integer.parseInt(pageNum));
			 if(ShipDealList.size()>0)
			 {
				 juser.put("data", ShipDealList);
			 }else
			 {
				 juser.put("data", new ArrayList<ShipDealInfo>());
			 }
			 
			 juser.put("suc", 'y');
			 juser.put("msg", "查询成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询异常:", e.getMessage());
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
	 * 功能:根据id查询船舶交易详细信息
	 * @param shiptradeid 船舶交易id
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/queryShipdealInfoByid")
	public void queryShipdealInfoByid(String shiptradeid,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         response.addHeader("Access-Control-Allow-Origin", "*");
			 response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
			 response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 //根据id查询船舶交易信息详情
			 ShipDealInfo ShipDeal=searchService.queryShipdealInfoByid(shiptradeid);
			 juser.put("data", ShipDeal);
			 juser.put("suc", 'y');
			 juser.put("msg", "查询成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询异常:", e.getMessage());
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
	 * 查询竞价公告列表
	 * @param pageNum
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/queryOutbidNoticeList")
	public void queryOutbidNoticeList(String pageNum,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 if(null==pageNum||"".equals(pageNum))
			 {
				pageNum="1";
			 }
			 //公告列表
			 List<NoticeInfo> noticeList=searchService.queryOutbidNoticeList(Constants.bidStatus.winBid,maxNum * (Integer.parseInt(pageNum)-1)+1,maxNum * Integer.parseInt(pageNum));//状态：中标
			 if(noticeList.size()>0)
			 {
				 juser.put("data", noticeList);
			 }else
			 {
				 juser.put("data", new ArrayList<NoticeInfo>());
			 }
			 juser.put("suc", 'y');
			 juser.put("msg", "查询成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询异常:", e.getMessage());
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
	 * 公告详情
	 * @param goodsbidid
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/queryNoticedealInfoByid")
	public void queryNoticedealInfoByid(String goodsbidid,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 //公告详情
			 NoticeInfo noticeInfo=searchService.queryNoticedealInfoByid(goodsbidid);
			 juser.put("data", noticeInfo);
			 juser.put("suc", 'y');
			 juser.put("msg", "查询成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询异常:", e.getMessage());
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
	 * 查询船舶详情
     * @param userId
	 * @param shipid
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/queryShipInfo")
	public void queryShipinfoByid(String applyuser,String shipid,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 //船舶详情
			 Ship ship=searchService.queryShipinfoByid(shipid,applyuser);
			 juser.put("data", ship);
			 juser.put("suc", 'y');
			 juser.put("msg", "查询成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询异常:", e.getMessage());
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
     * 查询平台统计数据
     * @param userId
     * @param shipid
     * @param request
     * @param response
     */
    @RequestMapping(value="/selectDataStatistics")
    public void selectDataStatistics(HttpServletResponse response)
    {
         PrintWriter out = null;
         JSONObject juser = new JSONObject();
         try {
             /* 设置格式为text/json */
             response.setContentType("text/json");
             /* 设置字符集为'UTF-8' */
             response.setCharacterEncoding("UTF-8");
             out = response.getWriter();
             
             //查询统计数据
             HomeInfo homeInfo = searchService.selectDataStatistics();
             
             juser.put("data", homeInfo);
             juser.put("suc", 'y');
             juser.put("msg", "查询成功");
             String jstr=juser.toString();
             out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询统计数据异常:", e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr=juser.toString();
            out.write(jstr);
        }
    }
    
    //版本更新 获取app文件路径进行下载安装
    @RequestMapping(value="queryApkUpdateurl")
    public void queryApkUpdateurl(HttpServletRequest request,HttpServletResponse response)
    {
    	PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            //查询Apk文件路径
            ApkVersionInfo appinfo = searchService.queryApkUpdateurl();
            juser.put("data", appinfo);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr=juser.toString();
            out.write(jstr);
       } catch (Exception e) {
           e.printStackTrace();
           logger.error("查询异常:", e.getMessage());
           juser.put("suc", 'n');
           juser.put("msg", "查询失败");
           String jstr=juser.toString();
           out.write(jstr);
       }
    }
    
    //在线加油
    @RequestMapping(value="oilOnline")
    public void showOilOnline(String type,HttpServletRequest request,HttpServletResponse response)
    {
    	PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            /* 设置格式为text/json */
            response.setContentType("text/json");
            response.addHeader("Access-Control-Allow-Origin", "*");
    		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
    		response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            //查询加油信息
            OilInfo oilInfo=searchService.queryOilOnlineByType(type);
            juser.put("data", oilInfo);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr=juser.toString();
            out.write(jstr);
       } catch (Exception e) {
           e.printStackTrace();
           logger.error("查询异常:", e.getMessage());
           juser.put("suc", 'n');
           juser.put("msg", "查询失败");
           String jstr=juser.toString();
           out.write(jstr);
       }
    	
    }
}
