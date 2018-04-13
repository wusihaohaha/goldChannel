package com.golden.advertise.action;

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

import com.golden.advertise.po.InviteInfo;
import com.golden.advertise.po.Resume;
import com.golden.advertise.service.AdvertiseService;
import com.golden.common.Constants;
import com.golden.common.FileOperateUtil;
import com.golden.common.FileUploadCommon;
import com.golden.login.po.UserBean;
import com.golden.pubParameter.service.PictureRootPathService;
/**
 * 招聘Controller
 * @author xie
 */
@Controller
public class AdvertiseController {

	private static final Logger logger = LoggerFactory.getLogger(AdvertiseController.class);
	
	@Autowired
	private AdvertiseService advertiseService;
	
	@Autowired
	private PictureRootPathService pictureRootPathService;
	
	//分页 每页最大展示数
	int maxNum=10;
	/**
	 * 查询用户是否已经创建过简历
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="queryIsaddResumeinfo")
	public void queryIsaddResumeinfo(String userId,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            String isReady="";
            int applyCount=advertiseService.queryIsaddResumeinfo(userId);
            if(applyCount>0)
            {
            	isReady="1";//已创建
            }else
            {
            	isReady="0";//未创建
            }
            juser.put("date", isReady);
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
	 * 上传简历头像
	 * return picturePath
	 */
	@RequestMapping(value="addResumeHead")
	public void addResumeHead(HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            String resumehead="";
            // 获取系统文件保存路径
            String localUrl = pictureRootPathService.getPicRoot(session, FileUploadCommon.ROOTPATH_ID);
            // 文件保存目录路径
            String fileSavePatha = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.resumePic;
            String controlName = "resumehead";// 控件名称
            String postfix = ".jpg";// 图片后缀
            // 上传图片并获取图片路径list
            List<String> resumeList=FileOperateUtil.uploadFile(request,fileSavePatha,controlName,postfix);
            if(resumeList.size()>0)
            {
            	resumehead=Constants.picturePath.Upload_ResumeFile+resumeList.get(0).toString();
            }
            juser.put("data", resumehead);
            juser.put("suc", 'y');
            juser.put("msg", "上传成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "上传失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        }
	}   
	
	/**
	 * 添加求职信息 创建简历
	 * @param resume
	 * @param request
	 * @param response
	 * @param session
	 */
	@RequestMapping(value="addResumeInfo")
	public void addResumeInfo(Resume resume,HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            int applyCount=advertiseService.queryApplyCount(resume.getCreateUser());
            if(applyCount>0)
            {
            	juser.put("suc", 'n');
                juser.put("msg", "已添加简历信息,请等待审核");
                String jstr = juser.toString();
                out.write(jstr);
            }else
            {
            	// 获取系统文件保存路径
                String localUrl = pictureRootPathService.getPicRoot(session, FileUploadCommon.ROOTPATH_ID);
                // 文件保存目录路径
                String fileSavePatha = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.resumePic;
                String controlName = "1";// 控件名称
                String postfix = ".jpg";// 图片后缀
                // 上传图片并获取图片路径list
                List<String> resumeList=FileOperateUtil.uploadFile(request,fileSavePatha,controlName,postfix);
                if(resumeList.size()>0)
                {
                	resume.setCertificate(Constants.picturePath.Upload_ResumeFile+resumeList.get(0).toString());
                }
                advertiseService.addResumeInfo(resume);//创建简历
                juser.put("suc", 'y');
                juser.put("msg", "添加成功");
                String jstr = juser.toString();
                out.write(jstr);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "添加失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        }
	}
	
	/**
	 * 删除简历信息
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="deleteResumeInfo")
	public void deleteResumeInfoByid(String userId,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            advertiseService.deleteResumeInfoByid(userId);
            juser.put("suc", 'y');
            juser.put("msg", "删除成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "删除失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 查询简历及邀请信息
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="queryResumeAndInvite")
	public void queryResumeAndInvite(String userId,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            Map<String,Object> datamap= new HashMap<String,Object>();
            String inviteid=advertiseService.queryInviteidByuid(userId);//查询简历id
            List<InviteInfo> inviteList=new ArrayList<InviteInfo>();
            Resume resume=new Resume();
            String status="";
            if(null!=inviteid)
            {
            	//简历信息
                resume=advertiseService.queryResumeinfoByid(inviteid);
            }
            int isAgree=advertiseService.queryIsagreeInvite(userId);
            if(isAgree>0)
            {//已经同意
            	status="2";//同意
            	//聘请信息
                inviteList=advertiseService.queryInviteListByid(userId,status);
            }else
            {//未同意
            	status="1";
            	inviteList=advertiseService.queryInviteListByid(userId,status);
            }
            
            datamap.put("resume", resume);
            datamap.put("inviteList", inviteList);
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
	
	/**
	 * 修改简历信息
	 * @param resume
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="updateRemuseInfo")
	public void updateRemuseInfoByid(Resume resume,HttpServletRequest request,HttpServletResponse response,HttpSession session)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            //查询简历审核状态
            String status=advertiseService.queryResumeStatus(resume.getCvId());
            if(status.equals("2"))
            {//待修改
            	// 获取系统文件保存路径
                String localUrl = pictureRootPathService.getPicRoot(session, FileUploadCommon.ROOTPATH_ID);
                // 文件保存目录路径
                String fileSavePatha = localUrl + FileUploadCommon.BACK_SLASH + Constants.picturePath.resumePic;
                String controlName = "1";// 控件名称
                String postfix = ".jpg";// 图片后缀
                String[]arr=request.getContentType().split(";");
                String contentType=arr[0];
                if(contentType.equals("multipart/form-data"))
                {
                	// 上传图片并获取图片路径list
                	List<String> resumeList=FileOperateUtil.uploadFile(request,fileSavePatha,controlName,postfix);
                    if(resumeList.size()>0)
                    {
                    	resume.setCertificate(Constants.picturePath.Upload_ResumeFile+resumeList.get(0).toString());
                    }	
                }
            	//修改个人简历信息
                advertiseService.updateRemuseInfoByid(resume);
                juser.put("suc", 'y');
                juser.put("msg", "修改成功");
            }else if(status.equals("1"))
            {
            	juser.put("suc", 'n');
                juser.put("msg", "待审核中，不能修改信息");
            }else
            {
            	juser.put("suc", 'n');
                juser.put("msg", "已通过审核，修改信息请联系后台管理员");
            }
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 同意拒绝聘请
	 * @param inviteId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="enterOpration")
	public void updateInviteStatuByid(String userId,String inviteId,String status,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            int agreeCount=advertiseService.queryAgreeCount(userId);
            if(agreeCount>0)
            {//已经同意
            	juser.put("msg", "请求有误！");
            }else
            {//未同意
            	//修改邀请记录及个人简历状态
                advertiseService.updateInviteStatuByid(inviteId,status,userId);
                juser.put("msg", "操作成功");
            }
            juser.put("suc", 'y');
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 条件筛选简历信息列表
	 * @param currentCity
	 * @param workExperience
	 * @param needDuty
	 * @param salary
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="showAllResume")
	public void queryAllResume(String currentCity,String workExperience,String needDuty,String salary,
			String pageNum,HttpServletRequest request,HttpServletResponse response)
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
            //查询所有简历信息列表
            List<Resume> resumeList=advertiseService.queryAllResume(currentCity,workExperience,needDuty,salary,maxNum * (Integer.parseInt(pageNum)-1)+1,maxNum * Integer.parseInt(pageNum));
            if(resumeList.size()>0)
            {
            	juser.put("data", resumeList);
            }else
            {
            	juser.put("data", new ArrayList<Resume>());
            }
            juser.put("suc", 'y');
            juser.put("msg", "操作成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 查询建简历详情及是否邀请状态
	 * @param userid
	 * @param inviteId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="showRemuseInfoByid")
	public void queryRemuseInfoByid(String userid,String inviteId,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            String isinvite="";
            //查询简历详情
            Resume resume=advertiseService.queryResumeinfoByid(inviteId);
            String status=advertiseService.queryIsinviteByuid(userid,inviteId);//查询请求状态
            if(null!=status)
            {
            	resume.setIsinvite(status);
            }else
            {
            	status="0";
            	resume.setIsinvite(status);
            }
            juser.put("data", resume);
            juser.put("suc", 'y');
            juser.put("msg", "操作成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 添加邀请信息
	 * @param myid 邀请人id
	 * @param otid 被邀请id
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="addInviteInfo")
	public void addInviteInfo(String myid,String otid,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            int inviteCount=advertiseService.queryInviteCount(myid,otid);//是否已经邀请
            if(inviteCount>0)
            {
            	juser.put("suc", 'n');
            	juser.put("msg", "已邀请该用户,请勿重复邀请");
            }else
            {
            	advertiseService.addInviteInfo(myid,otid);//添加邀请记录及消息通知
            	juser.put("suc", 'y');
            	juser.put("msg", "已发出邀请");
            }
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 我的船员列表 包含发出的邀请信息
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="showMyshipper")
	public void queryMyshipperList(String userId,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            List<Resume> shipperList= advertiseService.queryMyshipperList(userId);//我的船员
            if(shipperList.size()>0)
            {
            	juser.put("data", shipperList);
            }else
            {
            	juser.put("data", new ArrayList<Resume>());
            }
            juser.put("suc", 'y');
            juser.put("msg", "操作成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
	
	/**
	 * 取消船员邀请及移出已邀请船员
	 * @param inviteId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="cencelInveteInfo")
	public void deleteInveteInfoByid(String inviteId,String status,HttpServletRequest request,HttpServletResponse response)
	{
		PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
           String mess=advertiseService.deleteInveteInfoByid(inviteId,status);
           juser.put("suc", 'y');
           juser.put("msg", mess);
           String jstr = juser.toString();
           out.write(jstr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("操作异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
        }
	}
}
