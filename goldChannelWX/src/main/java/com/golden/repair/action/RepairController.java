package com.golden.repair.action;

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
import com.golden.login.po.UserBean;
import com.golden.pubParameter.service.PictureRootPathService;
import com.golden.repair.po.Maintainer;
import com.golden.repair.po.RepairApply;
import com.golden.repair.service.RepairService;

/**
 * 维修Controller层
 * @author xie
 */
@Controller
public class RepairController {

	@Autowired
	private RepairService repairService;
	@Autowired
	private PictureRootPathService pictureRootPathService;
	
	private static final Logger logger = LoggerFactory.getLogger(RepairController.class);
	
	//分页 每页最大展示数
	int maxNum=10;
	
	/**
	 * 查询用户简单信息
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="gotoApplyMaintainer")
	public void gotoApplyMaintainer(String userId,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            UserBean user=repairService.querySimpUserinfoByid(userId);//查询用户姓名、手机号
            juser.put("data", user);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        }
	}
	
	/**
	 * 添加维修师傅申请
	 * @param applyuser
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="addMaintainerInfo")
	public void addMaintainerInfo(Maintainer maintainer,HttpServletRequest request,HttpServletResponse response,
			HttpSession session)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            // 获取系统文件保存路径
            String localUrl = pictureRootPathService.getPicRoot(session, FileUploadCommon.ROOTPATH_ID);
            String postfix = ".jpg";// 图片后缀
            String[]arr=request.getContentType().split(";");
            String contentType=arr[0];
            if(contentType.equals("multipart/form-data"))
            {
            	// 文件保存目录路径
                String fileSavePatha = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.repairpassPic;
                String controlName = "1";// 控件名称
                // 上传图片并获取图片路径list
                List<String> repairPassList=FileOperateUtil.uploadFile(request,fileSavePatha,controlName,postfix);
                if(repairPassList.size()>0)
                {
                	maintainer.setQualifiCation(Constants.picturePath.Upload_RepairpassFile+repairPassList.get(0).toString());
                }
            }
            repairService.addMaintainerInfo(maintainer);//添加维修师傅信息
            juser.put("suc", 'y');
            juser.put("msg", "添加成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "添加失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 维修师傅申请打回状态修改信息
	 * @param maintainer
	 * @param request
	 * @param response
	 * @param session
	 */
	@RequestMapping(value="updateMaintainerInfo")
	public void updateMaintainerInfo(Maintainer maintainer,HttpServletRequest request,HttpServletResponse response,
			HttpSession session)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            // 获取系统文件保存路径
            String localUrl = pictureRootPathService.getPicRoot(session, FileUploadCommon.ROOTPATH_ID);
            // 文件保存目录路径
            String fileSavePatha = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.repairpassPic;
            String controlName = "1";// 控件名称
            String postfix = ".jpg";// 图片后缀
            String[]arr=request.getContentType().split(";");
            String contentType=arr[0];
            if(contentType.equals("multipart/form-data"))
            {
            	// 上传图片并获取图片路径list
                List<String> repairPassList=FileOperateUtil.uploadFile(request,fileSavePatha,controlName,postfix);
                if(repairPassList.size()>0)
                {
                	maintainer.setQualifiCation(Constants.picturePath.Upload_RepairpassFile+repairPassList.get(0).toString());
                }
            }
            repairService.updateMaintainerInfo(maintainer);//修改维修师傅信息
            juser.put("suc", 'y');
            juser.put("msg", "修改成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "修改失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 维修师傅申请通过状态修改信息
	 * @param maintainer
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="updateRepairInfoByStatu")
	public void updateRepairInfoByStatu(Maintainer maintainer,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            repairService.updateRepairInfoByStatu(maintainer);//修改信息
            juser.put("suc", 'y');
            juser.put("msg", "修改成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "修改失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        }
	}
	
	/**
	 * 添加报修信息
	 * @param repairApply
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="addneedRepairinfo")
	public void addneedRepairinfo(RepairApply repairApply,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            repairService.addneedRepairinfo(repairApply);//添加
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        }
	}
	
	/**
	 * 查询报修列表
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="queryRepairinfoList")
	public void queryRepairinfoList(String userId,String pageNum,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            if(null==pageNum||"".equals(pageNum))
			{
            	pageNum="1";
			}
            //我的报修列表
            List<RepairApply> repairList=repairService.queryRepairinfoList(userId,maxNum * (Integer.parseInt(pageNum)-1)+1,maxNum * Integer.parseInt(pageNum));
            if(repairList.size()>0)
            {
            	 juser.put("data", repairList);
            }else
            {
            	juser.put("data", new ArrayList<RepairApply>());
            }
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 查询报修详情
	 * @param maintenanceId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="queryRepairinfoByid")
	public void queryRepairinfoByid(String maintenanceId,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            RepairApply repairinfo=new RepairApply();
            int orderCount=repairService.queryOrderCountByid(maintenanceId);//查询订单
            if(orderCount>0)
            {//已接单
            	//报修详情(含接单人信息)
                repairinfo=repairService.queryRepairinfoByid(maintenanceId);
            }else
            {//未接单
            	String onstatus="0";
            	//报修详情
                repairinfo=repairService.queryLessRepairinfoByid(maintenanceId);
                repairinfo.setStatus(onstatus);
            }
           
            juser.put("data", repairinfo);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 查询师傅维修信息列表及维修申请信息
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="queryRepairListAndApplyinfo")
	public void queryRepairListAndApplyinfo(String userId,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            Map<String,Object> datamap=new HashMap<String,Object>();
            //维修申请信息
            Maintainer maintainer=repairService.queryMaintainerApplyInfoByid(userId);
            datamap.put("maintainer", maintainer);
            //查询维修信息列表
            List<RepairApply> repairList=repairService.queryMaintainerRepairListByid(userId);
            if(repairList.size()>0)
            {
            	datamap.put("repairList", repairList);
            }else
            {
            	datamap.put("repairList", new ArrayList<RepairApply>());
            }
            juser.put("data", datamap);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	//去抢单
	@RequestMapping(value="gotoReceiveOrders")
	public void queryAllOrdersByround(String city,String pageNum,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            if(null==pageNum||"".equals(pageNum))
			{
            	pageNum="1";
			}
            //报修信息列表
            List<RepairApply> repairinfoList=repairService.queryAllOrdersByround(city,maxNum * (Integer.parseInt(pageNum)-1)+1,maxNum * Integer.parseInt(pageNum));
            if(repairinfoList.size()>0)
            {
            	juser.put("data", repairinfoList);
            }else
            {
            	juser.put("data", new ArrayList<RepairApply>());
            }
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 查询用户是否已经申请维修师傅
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="queryUserIsHadApply")
	public void queryUserIsHadApply(String userId,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            String ishadApply="";
            //查询是否已经申请为师傅
            int appCount=repairService.queryUserIsHadApply(userId);
            if(appCount>0)
            {
            	ishadApply="1";//已申请
            }else
            {
            	ishadApply="0";//未申请
            }
            juser.put("data",ishadApply);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 取消报修
	 * @param maintenanceId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="deleteRepairInfoByid")
	public void deleteRepairInfoByid(String maintenanceId,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            String status=repairService.queryRepairStatus(maintenanceId);//删除报修信息前查询接单状态
            if(status.equals("1"))
            {//待接单
            	//删除报修信息
                repairService.deleteRepairInfoByid(maintenanceId);
                juser.put("suc", 'y');
                juser.put("msg", "报修单取消成功");
            }else
            {//2 已接单
            	juser.put("suc", 'n');
                juser.put("msg", "报修单已被接取,取消失败");
            }
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("取消异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "取消失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 添加订单信息
	 * @param maintenanceId
	 * @param customerid
	 * @param repairmanid
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="addOrderInfo")
	public void addOrderInfo(String maintenanceId,String customerid,String repairmanid,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            String status=repairService.queryRepairStatus(maintenanceId);//查询报修单状态
            if(status.equals("1"))
            {//待接单
            	repairService.updateMaintenanceStatus(maintenanceId);//修改报修单状态为已被接
            	repairService.addOrderInfo(maintenanceId,customerid,repairmanid);//添加订单
                juser.put("suc", 'y');
                juser.put("msg", "抢单成功");
            }else
            {//2 已接单
            	juser.put("suc", 'n');
                juser.put("msg", "已被他人接取,抢单失败");
            }
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "抢单失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
     * 更改船舶修理状态
     */
    @RequestMapping(value="updateRepairStatus")
    public void updateRepairStatus(String maintenanceId,String status,HttpServletRequest request,HttpServletResponse response)
    {
    	PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            repairService.updateRepairStatus(maintenanceId,status);//修改状态
            juser.put("suc", 'y');
            juser.put("msg", "修改成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "修改失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
    }
}
