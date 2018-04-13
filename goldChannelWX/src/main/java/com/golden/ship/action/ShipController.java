package com.golden.ship.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.golden.common.Constants;
import com.golden.common.FileOperateUtil;
import com.golden.common.FileUploadCommon;
import com.golden.pubParameter.service.PictureRootPathService;
import com.golden.ship.po.ApplyShipping;
import com.golden.ship.po.Ship;
import com.golden.ship.service.ShipService;
/**
 * 船舶信息Controller层
 * @author wusihao
 */
@Controller
//@RequestMapping(value = "/ship")
public class ShipController {

	@Autowired
	private ShipService shipService;
    @Autowired
    private PictureRootPathService pictureRootPathService;
	private static final Logger logger = LoggerFactory.getLogger(ShipController.class);
	
	//分页 每页最大展示数
	int maxNum=10;
	
	/**
	 * 功能:添加船舶信息（后台审核成功会才会在页面上展示）
	 */
	@RequestMapping(value="/addShips")
	public void addShips(HttpServletRequest request,HttpServletResponse response,HttpSession session, Ship ship)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 String[]arr=request.getContentType().split(";");
             String contentType=arr[0];
             int hadShipByName= shipService.queryShipCountByName(ship.getShipname());
             if(hadShipByName>0)
             {//已有该船名
            	 juser.put("suc", 'n');
				 juser.put("msg", "船舶名称已存在");
				 String jstr=juser.toString();
				 out.write(jstr);
             }else{
	             if(contentType.equals("multipart/form-data"))
	             {
	            	 // 获取系统文件保存路径
	                 String localUrl = pictureRootPathService.getPicRoot(session, FileUploadCommon.ROOTPATH_ID);
	                 String postfix = ".jpg";// 图片后缀
	                 
	                 // 文件保存目录路径
	                 String fileSavePatha = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.shipPic;
	                 String controlNamea = "1";// 控件名称
	                 // 上传图片并获取图片路径list
	                 List<String> strShipList=FileOperateUtil.uploadFile(request,fileSavePatha,controlNamea,postfix);
	     			 
	                 String fileSavePathb = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.businessPic;
	                 String controlNameb = "2";// 控件名称
	                 List<String> strBusinessList=FileOperateUtil.uploadFile(request,fileSavePathb,controlNameb,postfix);
	                 
	                 String fileSavePathc = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.airworthinessPic;
	                 String controlNamec = "3";// 控件名称
	                 List<String> strAirworthinessList=FileOperateUtil.uploadFile(request,fileSavePathc,controlNamec,postfix);
	                 
	                 String fileSavePathd = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.nationalityPic;
	                 String controlNamed = "4";// 控件名称
	                 List<String> strNationalityPicList=FileOperateUtil.uploadFile(request,fileSavePathd,controlNamed,postfix);
	                 
	                 if(strShipList.size()>0)
	    			 {
	    				 ship.setPicturepath(Constants.picturePath.Upload_ShipFile+strShipList.get(0).toString());//船图片
	    			 }
	                 if(strBusinessList.size()>0)
	    			 {
	                	 ship.setBusinesscertificate(Constants.picturePath.Upload_BusinessFile+strBusinessList.get(0).toString());//船舶营业证路径
	    			 }
	                 if(strBusinessList.size()>0)
	    			 {
	                	 ship.setAirworthinesscertificate(Constants.picturePath.Upload_AirworthinessPicFile+strAirworthinessList.get(0).toString());//船舶适航证书路径
	    			 }
	                 if(strNationalityPicList.size()>0)
	    			 {
	                	 ship.setInternationalcertificate(Constants.picturePath.Upload_NationalityPic+strNationalityPicList.get(0).toString());//船舶国籍证书路径
	    			 }
	             }
	             ship.setStatus(Constants.shipStatus.free);//状态：空闲
             	 ship.setAuditstate(Constants.shipAuditState.audit);//状态：待审核
				 //添加船信息
				 shipService.addShips(ship);
				 logger.info("船舶信息添加成功");
				 juser.put("suc", 'y');
				 juser.put("msg", "添加成功");
				 String jstr=juser.toString();
				 out.write(jstr);
             }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("船舶信息添加异常:", e);
			juser.put("suc", 'n');
			juser.put("msg", "添加失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
	 * 功能：查询我的船舶列表
	 * @param request
	 * @param response
	 * @param createuser 用户id
	 */
	@RequestMapping(value="/myShip")
	public void queryMyshipList(String pageNum,HttpServletRequest request,HttpServletResponse response,String createuser)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	         response.addHeader("Access-Control-Allow-Origin", "*");
	         response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
	         response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 if(null==pageNum||"".equals(pageNum))
			 {
				pageNum="1";
			 }
			 //查询我的船舶列表
			 List<Ship> shipList=shipService.queryMyshipList(createuser,maxNum * (Integer.parseInt(pageNum)-1)+1,maxNum * Integer.parseInt(pageNum));
			 if(shipList.size()>0)
			 {
				 juser.put("data", shipList);
			 }else
			 {
				 juser.put("data", new ArrayList<Ship>());
			 }
			 
			 logger.info("船舶列表查询成功");
			 juser.put("suc", 'y');
			 juser.put("msg", "查询成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("船舶列表查询异常:", e);
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
	 * 我要找船
     * @param userId 用户id
	 * @param currentprovince 省
	 * @param currentcity 市
	 * @param tonnage 吨位
	 * @param shiptype 船型
	 * @param pageNum 页数 分页
	 * @param request
	 * @param response
	 */
	
	@RequestMapping(value="/findShiponRound")
	public void findShiponRound(String currentPort,String tonnage,String pageNum,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	         response.addHeader("Access-Control-Allow-Origin", "*");
	         response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
	         response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 if(null==pageNum||"".equals(pageNum))
			 {
				 pageNum="1";
			 }
			 List<Ship> shipList= new ArrayList<Ship>();
			 
            if(tonnage==null||tonnage.equals("")){
                tonnage = "0";
            }
            if(pageNum==null||pageNum.equals("")){
                pageNum = "1";
            }
			 String topton="";
			 String downton="";
			 switch (tonnage) {
	            case "0"://全部
	            	topton="1";
					downton="1000000";
	                break;
	            case "1"://2000以下
	            	topton="1";
					downton="2000";
	                break;
	            case "2"://2001-5000
	            	topton="2001";
					downton="5000";
	                break;
	            case "3"://5001-10000
	            	topton="5001";
					downton="10000";
	                break;
	            case "4"://10001-15000
	            	topton="10001";
					downton="15000";
	                break;
	            case "5"://15001-30000
	            	topton="15001";
					downton="30000";
	                break;
	            case "6"://30000以上
	            	 topton="30001";
					 downton="1000000";
	                break;
	            default:
	                break;
	            }
			 shipList=shipService.findShiponRound(currentPort,topton,downton,maxNum * (Integer.parseInt(pageNum)-1)+1,maxNum * Integer.parseInt(pageNum));
			 if(shipList.size()>0)
			 {
				 juser.put("data", shipList);
			 }else
			 {
				 juser.put("data", new ArrayList<Ship>());
			 }
			 logger.info("查询船舶成功");
			 juser.put("suc", 'y');
			 juser.put("msg", "查询成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询船舶:", e);
			juser.put("suc", 'n');
			juser.put("msg", "查询失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	//修改船舶信息
	@RequestMapping(value="/updateShipInfo")
	public void updateShipinfoByid(Ship ship ,HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 String[]arr=request.getContentType().split(";");
             String contentType=arr[0];
			 int hadShipById= shipService.queryShipCountById(ship.getShipid(),ship.getShipname());
             if(hadShipById>0)
             {//已有该船名
            	 juser.put("suc", 'n');
				 juser.put("msg", "船舶名称已存在");
				 String jstr=juser.toString();
				 out.write(jstr);
             }else{
	             if(contentType.equals("multipart/form-data"))
	             {
	            	 // 获取系统文件保存路径
	                 String localUrl = pictureRootPathService.getPicRoot(session, FileUploadCommon.ROOTPATH_ID);
	                 String postfix = ".jpg";// 图片后缀
	                 
	            	 // 文件保存目录路径
	                 String fileSavePatha = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.shipPic;
	                 String controlNamea = "1";// 控件名称
	                 // 上传图片并获取图片路径list
	                 List<String> strShipList=FileOperateUtil.uploadFile(request,fileSavePatha,controlNamea,postfix);
	      			 if(strShipList.size()>0)
	      			 {
	      				 ship.setPicturepath(Constants.picturePath.Upload_ShipFile+strShipList.get(0).toString());//船图片
	      			 }
	      			 
	                 String fileSavePathb = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.businessPic;
	                 String controlNameb = "2";// 控件名称
	                 List<String> strBusinessList=FileOperateUtil.uploadFile(request,fileSavePathb,controlNameb,postfix);
	                 if(strBusinessList.size()>0)
	                 {
	              	   ship.setBusinesscertificate(Constants.picturePath.Upload_BusinessFile+strBusinessList.get(0).toString());//船舶营业证路径
	                 }
	                 
	                 String fileSavePathc = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.airworthinessPic;
	                 String controlNamec = "3";// 控件名称
	                 List<String> strAirworthinessList=FileOperateUtil.uploadFile(request,fileSavePathc,controlNamec,postfix);
	                 if(strAirworthinessList.size()>0)
	                 {
	              	   ship.setAirworthinesscertificate(Constants.picturePath.Upload_AirworthinessPicFile+strAirworthinessList.get(0).toString());//船舶适航证书路径
	                 }
	                 
	                 String fileSavePathd = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.nationalityPic;
	                 String controlNamed = "4";// 控件名称
	                 List<String> strNationalityPicList=FileOperateUtil.uploadFile(request,fileSavePathd,controlNamed,postfix);
	                 if(strNationalityPicList.size()>0)
	                 {
	              	   ship.setInternationalcertificate(Constants.picturePath.Upload_NationalityPic+strNationalityPicList.get(0).toString());//船舶国籍证书路径
	                 }
	             }
	             //修改船舶信息
				 shipService.updateShipinfoByid(ship);
				 logger.info("船舶信息修改成功");
				 juser.put("suc", 'y');
				 juser.put("msg", "修改成功");
				 String jstr=juser.toString();
				 out.write(jstr);
             }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("船舶信息修改失败:", e);
			juser.put("suc", 'n');
			juser.put("msg", "修改失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	/**
	 * 船运申请
	 * @param applyShipping
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/applyShipping")
	public void applyShipping(ApplyShipping applyShipping,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 
             //船运申请（备份货物、补全货物信息、添加申请船运信息、发送消息）
             shipService.applyShipping(applyShipping,Constants.MessageTitle.shipping,Constants.MessageInfos.shipping_success_s);

			 logger.info("船运申请成功");
			 juser.put("suc", 'y');
			 juser.put("msg", "申请成功");
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("船运申请异常:", e);
			juser.put("suc", 'n');
			juser.put("msg", "申请失败");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	//删除我的船舶
	@RequestMapping(value="deleteMyShipById")
	public void deleteMyShipById(String id,HttpServletRequest request,HttpServletResponse response)
	{
		 PrintWriter out = null;
	     JSONObject juser = new JSONObject();
	     try {
	         response.addHeader("Access-Control-Allow-Origin", "*");
	         response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
	         response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
	    	 /* 设置格式为text/json */
	         response.setContentType("text/json");
	         /* 设置字符集为'UTF-8' */
	         response.setCharacterEncoding("UTF-8");
			 out = response.getWriter();
			 //查询船舶使用状态
			
			 shipService.deleteMyShipById(id);//删除船舶信息
			 juser.put("suc", 'y');
			 juser.put("msg", "船舶删除成功");
			
			 String jstr=juser.toString();
			 out.write(jstr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("船舶删除异常:", e);
			juser.put("suc", 'n');
			juser.put("msg", "删除船舶异常，请稍候再试");
			String jstr=juser.toString();
			out.write(jstr);
		}
	}
	
	@RequestMapping(value="/getShipById")
    public void getShipById(HttpServletResponse response,String id) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            Map<String, Object> list =  new HashMap<String, Object>();             
            list = shipService.getShipById(id);
            juser.put("data", list);
            juser.put("suc", 'y');
            juser.put("msg", "操作成功");
            
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("(船方)同意船运申请操作异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
	
	 /**
     * createGoodsInfo:更新货物. <br/>
     * @author zhoujq
     * @param response
     * @param userId 用户id
     * @param goodsInfo 货物信息
     * @since JDK 1.7
     */

    @RequestMapping(value="/updateShip")
    public void updateShip(HttpServletResponse response, HttpServletRequest request ,String ID,String SHIPNAME,String TONNAGE,
            String S_TIME,String E_TIME,String SHIPTYPE,String JSC,String FCSB,String REGISTRYPORT,String JZSJ,String SHIPLONG,
            String SHIPWIDTH,String SHIPCAPACITY,String DRAUGHT,String SHQY,String CURRENTPORT
            ) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
          //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            Map<String, String> map = new HashMap<String, String>();
            map.put("ID", ID);
            map.put("SHIPNAME", SHIPNAME);
            map.put("TONNAGE", TONNAGE);
            map.put("S_TIME", S_TIME);
            map.put("E_TIME", E_TIME);
            map.put("SHIPTYPE", SHIPTYPE);
            map.put("JSC", JSC);
            map.put("FCSB", FCSB);
            map.put("REGISTRYPORT", REGISTRYPORT);
            map.put("JZSJ", JZSJ);
            map.put("SHIPLONG", SHIPLONG);
            map.put("SHIPWIDTH", SHIPWIDTH);
            map.put("SHIPCAPACITY", SHIPCAPACITY);
            map.put("DRAUGHT", DRAUGHT);
            map.put("SHQY", SHQY);
            map.put("CURRENTPORT", CURRENTPORT);
            map.put("AUDITSTATE", "1");
            //增加新的货物信息
            shipService.updateShip(map);
            
            juser.put("suc", 'y');
            juser.put("msg", "更新成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("更新失败:",e);
            juser.put("suc", 'n');
            juser.put("msg", "更新失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    
    @RequestMapping(value="/addShip")
    public void addShip(HttpServletRequest request,HttpServletResponse response,HttpSession session,String shipName)
    {
         PrintWriter out = null;
         JSONObject juser = new JSONObject();
         try {
             response.addHeader("Access-Control-Allow-Origin", "*");
             response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
             response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
             /* 设置格式为text/json */
             response.setContentType("text/json");
             /* 设置字符集为'UTF-8' */
             response.setCharacterEncoding("UTF-8");
             out = response.getWriter();
             String[]arr=request.getContentType().split(";");
             String contentType=arr[0];
                 if(contentType.equals("multipart/form-data"))
                 {
                     // 获取系统文件保存路径
                     String localUrl = "c://upload";//pictureRootPathService.getPicRoot(session, FileUploadCommon.ROOTPATH_ID);
                     String postfix = ".jpg";// 图片后缀
                     
                     // 文件保存目录路径
                     String fileSavePatha = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.shipPic;
                     String controlNamea = "1";// 控件名称
                     // 上传图片并获取图片路径list
                     List<String> strShipList=FileOperateUtil.uploadFile(request,fileSavePatha,controlNamea,postfix);
                     
                     String fileSavePathb = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.businessPic;
                     String controlNameb = "2";// 控件名称
                     List<String> strBusinessList=FileOperateUtil.uploadFile(request,fileSavePathb,controlNameb,postfix);
                     
                     String fileSavePathc = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.airworthinessPic;
                     String controlNamec = "3";// 控件名称
                     List<String> strAirworthinessList=FileOperateUtil.uploadFile(request,fileSavePathc,controlNamec,postfix);
                     
                     String fileSavePathd = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.nationalityPic;
                     String controlNamed = "4";// 控件名称
                     List<String> strNationalityPicList=FileOperateUtil.uploadFile(request,fileSavePathd,controlNamed,postfix);
                     
//                     if(strShipList.size()>0)
//                     {
//                         ship.setPicturepath(Constants.picturePath.Upload_ShipFile+strShipList.get(0).toString());//船图片
//                     }
//                     if(strBusinessList.size()>0)
//                     {
//                         ship.setBusinesscertificate(Constants.picturePath.Upload_BusinessFile+strBusinessList.get(0).toString());//船舶营业证路径
//                     }
//                     if(strBusinessList.size()>0)
//                     {
//                         ship.setAirworthinesscertificate(Constants.picturePath.Upload_AirworthinessPicFile+strAirworthinessList.get(0).toString());//船舶适航证书路径
//                     }
//                     if(strNationalityPicList.size()>0)
//                     {
//                         ship.setInternationalcertificate(Constants.picturePath.Upload_NationalityPic+strNationalityPicList.get(0).toString());//船舶国籍证书路径
//                     }
                 }
//                 ship.setStatus(Constants.shipStatus.free);//状态：空闲
//                 ship.setAuditstate(Constants.shipAuditState.audit);//状态：待审核
//                 //添加船信息
//                 shipService.addShips(ship);
                 logger.info("船舶信息添加成功");
                 juser.put("suc", 'y');
                 juser.put("msg", "添加成功");
                 String jstr=juser.toString();
                 out.write(jstr);
             
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("船舶信息添加异常:", e);
            juser.put("suc", 'n');
            juser.put("msg", "添加失败");
            String jstr=juser.toString();
            out.write(jstr);
        }
    }
}
