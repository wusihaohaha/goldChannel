package com.golden.login.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.common.Constants;
import com.golden.common.DateUtil;
import com.golden.common.Encrypt;
import com.golden.common.FileUploadCommon;
import com.golden.common.SmsValidateUtil;
import com.golden.common.State;
import com.golden.login.po.UserBean;
import com.golden.login.service.LoginService;
import com.golden.pubParameter.service.PictureRootPathService;
import com.golden.weixin.CommonUtil;

/**
 * 用户登录Controller
 * date: 2016年9月12日 下午5:41:29 <br/>
 * @author jiangmeng
 * 修改 xie
 * 修改时间 2016年10月18日 10:38:01
 * @version 
 * @since JDK 1.7
 */
@Controller
public class LoginController extends LoginBaseController
{
    
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;
    @Autowired
    private PictureRootPathService pictureRootPathService;
    
    /**
     * loginPreview:跳转至登录界面
     * @author jiangmeng
     * @param request
     * @param response
     * @return
     * @since JDK 1.7
     */
    @RequestMapping(value = "/loginpreview")
    public String loginPreview(HttpServletRequest request, HttpServletResponse response)
    {
        return "login/login";
    }
    
    /**
     * login:用户登录操作
     * @author jiangmeng
     * @param request
     * @param response
     * @param session
     * @param telephone
     * @param password
     * @since JDK 1.7
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public void login(String telephone,String password,String currentProvince,String currentCity,
    		HttpServletRequest request,HttpServletResponse response, HttpSession session)
    {
        // 取得通知对象
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try
        {
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
            out = response.getWriter();

            //判断手机号是否注册
            int isPhoneExist = loginService.checkTelephone(telephone);
            if(isPhoneExist == Constants.ZERO)
            {
                juser.put("suc", 'n');
                juser.put("msg", "账号不存在");
                String jstr = juser.toString();
                out.write(jstr);
            }else{
                // 接着通过用户输入的用户名和密码查询用户信息 加密
                UserBean userInfo = loginService.login(telephone, Encrypt.getEncString(password));
                if (null != userInfo)
                {
                    // 保存用户信息到session中
                    //session.setAttribute("user", userInfo);
                    //logger.info(userInfo.getUsername()+"：登录成功");
                    String applyId="";//loginService.queryRepairApplyId(userInfo.getUserid());//查询用户有没有维修师傅身份
                    if(StringUtils.isNotBlank(applyId))
                    {//已申请并通过审核
                    	if(StringUtils.isNotBlank(currentProvince)&&StringUtils.isNotBlank(currentCity))
                    	{//如果地址不为空
                    		//修改维修师傅信息地址
                    		loginService.updateRepairAdress(applyId,currentProvince,currentCity);
                    	}
                    }
                    juser.put("data", userInfo);
                    juser.put("suc", 'y');
                    juser.put("msg", "登录成功");
                    String jstr = juser.toString();
                    out.write(jstr);
                } else{
                    logger.info("用户名或者密码错误");
                    juser.put("suc",'n');
                    juser.put("msg","用户名或者密码错误");
                    String jstr = juser.toString();
                    out.write(jstr);
                }
            }
            out.flush();
        } catch (Exception e)
        {
            logger.error("用户登录异常:", e);
            juser.put("suc",'n');
            juser.put("msg","登录异常");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null)
            {
                out.close();
            }
        }
    }
    
    /**
     * registerPreview:进入注册页面. <br/>
     * @author zhoujq
     * @param request
     * @param response
     * @return
     * @since JDK 1.7
     */
    @RequestMapping(value = "/registerpreview")
    public String registerPreview(HttpServletRequest request, HttpServletResponse response)
    {
        return "login/register";
    }
    
    /**
     * obtainValidate:发送用户注册时的验证码. <br/>
     * @author zhoujq
     * @param request
     * @param response
     * @param telephone 手机号码
     * @since JDK 1.7
     */
    @RequestMapping(value = "/obtainvalidate")
    @ResponseBody
    public void obtainValidate(HttpServletRequest request, HttpServletResponse response, String telephone) 
    {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            /* 设置格式为text/json    */
            response.setContentType("text/json");
            /*设置字符集为'UTF-8'*/
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            //判断手机号是否注册
            String code = sendMessage(telephone, request);
            juser.put("code",code);
            System.out.println(">>>>>>>>>>>>>>>>>>code="+code);
            if(code!=null&&code.equals("100")){
            	juser.put("suc",'y');
                juser.put("msg","发送注册验证码成功");
                String jstr = juser.toString();
                out.write(jstr); 
            } else {
            	juser.put("suc",'n');
                juser.put("msg","发送注册验证码失败");
                String jstr = juser.toString();
                out.write(jstr);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("发送注册验证码异常:"+e.getMessage(),e);
            juser.put("suc",'n');
            juser.put("msg","发送注册验证码异常");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if(null != out){
                out.close();
            }
        }
    }
    
    /**
     * 发送短信模块抽离化
     * @param mobile
     * @param request
     * @return
     * @throws UnsupportedEncodingException 
     */
    private String sendMessage(String mobile, HttpServletRequest request) throws UnsupportedEncodingException 
    {
        //获取随机码
        String sixRandomCode = DateUtil.get4RandomNum();
        HttpSession sessionCode = request.getSession(true); 
        sessionCode.setMaxInactiveInterval(300);//300秒
        sessionCode.setAttribute("messagecode", sixRandomCode);
        sessionCode.setAttribute("mobile", mobile);
        //发送验证码，返回发送结果。‘000000’表示发送成功，其他表示失败
        String content = java.net.URLEncoder.encode("您的验证密码是："+sixRandomCode+"，如需帮助请联系客服。","UTF-8");
        String url = "http://sms.106jiekou.com/utf8/sms.aspx?account=18627055621&password=030108&mobile="+mobile+"&content="+content;
        String code=CommonUtil.sendGet(url, null);
        //建立发送短信记录
        //String arrString = Arrays.toString(paramMap);
        return code;
    }
    
    /**
     * registerUser:用户注册. <br/>
     * 步骤一：判断验证码是否正确；步骤二：判断手机号码是否注册；步骤三：向用户信息表插入数据。
     * @author zhoujq
     * @param request
     * @param response
     * @param session
     * @param telephone 手机号码
     * @param password 密码
     * @param username 姓名
     * @param code 验证码
     * @since JDK 1.7
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public void registerUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, String telephone,
            String type, String openid, String code)
    {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try
        {
            /* 设置格式为text/json    */
            response.setContentType("text/json");
            /*设置字符集为'UTF-8'*/
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            String messagecode = (String) session.getAttribute("messagecode");
            String mobile = (String) session.getAttribute("mobile");
            if(null == messagecode || messagecode.isEmpty())
            {
            	 juser.put("suc", 'n');
                 juser.put("msg", "没有获取验证码或者验证码已失效");
                 String jstr = juser.toString();
                 out.write(jstr);
            } else {
                 
                if (code.equalsIgnoreCase(messagecode) && telephone.equals(mobile)) {
                    // 接着通过用户输入的用户名和密码查询用户信息 加密
                    UserBean userInfo = new UserBean();
                    userInfo.setOpenId(openid);
                    userInfo.setType(type);
                    userInfo.setMobile(telephone);
                    int count = loginService.updateUserByOpenId(userInfo);
                    
                    //清除验证码及注册手机号
                    session.removeAttribute("messagecode");
                    session.removeAttribute("mobile");
                    if(count>0){
                        juser.put("isLogin", "1");
                        juser.put("type", type);
                        juser.put("phone", telephone);
                        juser.put("suc", 'y');
                        juser.put("msg", "注册成功");
                    }else{
                        juser.put("suc", 'n');
                        juser.put("msg", "注册失败，账号不存在");
                        logger.error(">>>>>>>>>>>>>>>>>>>>>>>openid不存在,重新获取微信信息");
                    }
                    String jstr = juser.toString();
                    out.write(jstr);

                   
                } else {
                	juser.put("suc", 'n');
                    juser.put("msg", "验证码已过期或者错误");
                    String jstr = juser.toString();
                    out.write(jstr);  
                }
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户注册异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "注册异常");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    
    /**
     * forgetPwdPreview:进入忘记密码/找回密码页面. <br/>
     * @author zhoujq
     * @param request
     * @param response
     * @return
     * @since JDK 1.7
     */
    @RequestMapping(value = "/forgetpwdpreview")
    public String forgetPwdPreview(HttpServletRequest request, HttpServletResponse response)
    {
        return "login/forgetpwd";
    }
    
    /**
     * 功能：忘记密码的的手机验证码
     * @author zhangliu 2016年5月19日10:04:31
     * @param request
     * @param response
     * @param mobile 手机号码
     */
    @RequestMapping(value = "/forgetpwdcode")
    @ResponseBody
    public void forgetPwdCode(HttpServletRequest request, HttpServletResponse response, String telephone) 
    {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            /* 设置格式为text/json    */
            response.setContentType("text/json");
            /*设置字符集为'UTF-8'*/
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            //判断手机号是否注册
            int isPhoneExist = loginService.checkTelephone(telephone);
            if(isPhoneExist > 0)
            {
                String code = sendMessage(telephone, request);
                //String code="000000";
                if(Constants.loginCode.SHORTMESSAGE_CODE_SUCCESS.equals(code))
                {
                	 juser.put("suc", 'y');
                     juser.put("msg", "验证码发送成功");
                    String jstr = juser.toString();
                    out.write(jstr); 
                } else {
                	 juser.put("suc", 'n');
                     juser.put("msg", "验证码发送失败");
                    String jstr = juser.toString();
                    out.write(jstr);
                }
            } else {
            	juser.put("suc", 'n');
                juser.put("msg", "手机号未注册");
                String jstr = juser.toString();
                out.write(jstr);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("发送忘记密码验证码异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "发送验证码异常");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if(null != out)
            {
                out.close();
            }
        }
    }
    
    /**
     * forgetPwd:登录页面的忘记密码. <br/>
     * @author zhoujq
     * @param request
     * @param response
     * @param session
     * @param telephone 手机号
     * @param code 验证码
     * @param password 新密码
     * @since JDK 1.7
     */
    @RequestMapping(value = "/forgetpwd")
    @ResponseBody
    public void forgetPwd(HttpServletRequest request, HttpServletResponse response, HttpSession session,String telephone,
            String code,String password)
    {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try
        {
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            // 先判断验证码是否正确
            if (null!=session.getAttribute("messagecode") && code.equalsIgnoreCase(session.getAttribute("messagecode").toString()) 
                    && null!=session.getAttribute("mobile") && telephone.equals(session.getAttribute("mobile").toString()))
            {
              //判断手机号是否注册
                int isPhoneExist = loginService.checkTelephone(telephone);
                if(isPhoneExist > Constants.ZERO)
                {
                    // 修改密码
                    loginService.updatePassword(telephone, Encrypt.getEncString(password));
                    juser.put("suc", 'y');
                    juser.put("msg", "密码修改成功");
                    String jstr = juser.toString();
                    out.write(jstr);
                } else {
                	 juser.put("suc", 'n');
                     juser.put("msg", "手机号未注册");
                    String jstr = juser.toString();
                    out.write(jstr);
                }
            } else {
            	 juser.put("suc", 'n');
                 juser.put("msg", "验证码错误");
                String jstr = juser.toString();
                out.write(jstr);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("找回密码异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "修改密码异常");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null)
            {
                out.close();
            }
        }
    }
    
    /**
     * modifyPwd:修改密码. <br/>
     * @author zhoujq
     * @param request
     * @param response
     * @param session
     * @param telephone 手机号码
     * @param oldpassword 旧密码
     * @param password 新密码
     * @since JDK 1.7
     */
    @RequestMapping(value = "/modifypwd")
    @ResponseBody
    public void modifyPwd(String telephone,String oldpassword,String password,
    		HttpServletRequest request,HttpServletResponse response, HttpSession session)
    {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try
        {
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            //获取用户注册手机号
            /*UserBean userInfo = (UserBean) session.getAttribute("user");
            String telephone=userInfo.getUsertel();*/
            
            int index = loginService.checkOldPwd(telephone, Encrypt.getEncString(oldpassword));
            if(index > Constants.ZERO)
            {
                loginService.updatePassword(telephone, Encrypt.getEncString(password)); 
                juser.put("suc", 'y');
                juser.put("msg", "修改密码成功");
                String jstr = juser.toString();
                out.write(jstr);
            } else {
            	juser.put("suc", 'n');
                juser.put("msg", "旧密码不正确");
                String jstr = juser.toString();
                out.write(jstr);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改密码异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "修改密码异常");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null)
            {
                out.close();
            }
        }
    }
    
    /**
     * updateUserById:修改用户信息. <br/>
     * @author zhoujq
     * @param request
     * @param response
     * @param session
     * @param userInfo
     * @since JDK 1.7
     */
    @RequestMapping(value = "/updateUserById")
    @ResponseBody
    public void updateBallplayerById(HttpServletRequest request, HttpServletResponse response, HttpSession session,UserBean userInfo)
    {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try
        {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            loginService.updateUserById(userInfo);
            
            //UserBean muserInfo = loginService.findUserById(userInfo.getUsertel());
            // 保存用户信息到session中
            //session.setAttribute("user", userInfo);
           /* System.out.println("成功");*/
            juser.put("suc", 'y');
            juser.put("msg", "修改信息成功");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            /*System.out.println("失败");*/
            logger.error("修改用户信息异常:"+e.getMessage());
            juser.put("suc", 'y');
            juser.put("msg", "修改信息失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null)
            {
                out.close();
            }
        }
    }
    
    /**
     * 功能：更新用户头像
     */
    @RequestMapping("/modifyUserPic")
    public void addPublishPics(HttpServletRequest request,HttpServletResponse response,HttpSession httpSession) throws ServletException, IOException
    {
    	PrintWriter out = null;
        JSONObject juser = new JSONObject();
      //设置格式为text/json 
        response.setContentType("text/json");
        //设置字符集为'UTF-8' 
        response.setCharacterEncoding("UTF-8");
        out = response.getWriter();
        //获取系统文件保存路径
    	String localUrl = pictureRootPathService.getPicRoot(httpSession, FileUploadCommon.ROOTPATH_ID);
    	//String localUrl ="d:/upload";
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // 文件保存目录路径
        //String savePath = localUrl+FileUploadCommon.BACK_SLASH+FileUploadCommon.HEAD_PIC;
        String savePath = localUrl+FileUploadCommon.BACK_SLASH+Constants.loginCode.USERPIC;
        // 临时文件目录
        String tempPath = localUrl+FileUploadCommon.BACK_SLASH+"temp";
        // 创建文件夹
        File dirFile = new File(savePath);
        if (!dirFile.exists()) 
        {
            dirFile.mkdirs();
        }

        // 创建临时文件夹
        File dirTempFile = new File(tempPath);
        if (!dirTempFile.exists()) 
        {
            dirTempFile.mkdirs();
        }
 
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(20 * 1024 * 1024); // 设定使用内存超过5M时，将产生临时文件并存储于临时目录中。
        factory.setRepository(new File(tempPath));  // 设定存储临时文件的目录。
 
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
 
        try 
        {
            List<?> items = upload.parseRequest(request);
            Iterator<?> itr = items.iterator();
 
            while (itr.hasNext()) 
            {
                FileItem item   = (FileItem) itr.next();
                String userid = item.getName();
                if(null != userid && userid.contains(".jpg"))
                {
                	userid = userid.replace(".jpg", "");
                }
                if (!item.isFormField())
                {
                    try 
                    {
                    	DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        				String dfname = df.format(new Date());
                    	String newFileName = userid+"_"+dfname;
                        File uploadedFile = new File(savePath,newFileName+".jpg");
                        OutputStream os = new FileOutputStream(uploadedFile);
                        InputStream is = item.getInputStream();
                        byte buf[] = new byte[1024];// 可以修改 1024 以提高读取速度
                        int length = 0;
                        while ((length = is.read(buf)) > 0) 
                        {
                            os.write(buf, 0, length);
                        }
                        System.out.println("图片上传完成");
                        // 关闭流
                        os.flush();
                        os.close();
                        is.close();
                        String newfilepath=FileUploadCommon.UPLOAD_FILES+newFileName+".jpg";
                        loginService.updateSelfHead(userid,newfilepath);
                        juser.put("data", newfilepath);
                    } catch (Exception e) 
                    {
                        e.printStackTrace();
                        logger.error("修改头像异常:"+e.getMessage());
                        juser.put("suc", 'n');
                        juser.put("msg", "修改失败");
                        String jstr=juser.toString();
                        out.write(jstr);
                    }
                }
            }
            juser.put("suc", 'y');
            juser.put("msg", "修改成功");
            String jstr=juser.toString();
            out.write(jstr);
        } catch (FileUploadException e) 
        {
            e.printStackTrace();
            logger.error("修改头像异常:"+e.getMessage());
            juser.put("suc", 'n');
            juser.put("msg", "修改失败");
            String jstr=juser.toString();
            out.write(jstr);
        }
    }
       
    /**
     * 
     * responseMessage:信息返回
     * @author litong
     * @param request
     * @param response
     * @param state
     * @param picture_url
     * @since JDK 1.7
     */
    private void responseMessage(HttpServletResponse response, 
            State state,String picture_url) 
    {
    	/* 设置格式为text/json */
        response.setContentType("text/json");
        /* 设置字符集为'UTF-8' */
        response.setCharacterEncoding("UTF-8"); 
        PrintWriter writer = null;
        //获取上传图片的路径
        String message = state.getMessage();
        try
        {  
            //message = URLEncoder.encode(message, FileUploadCommon.ENCODE);
            writer = response.getWriter();  
            String str = "{\"code\":" + state.getCode() +",\"message\":\"" + message +"\",\"picture_url\":\"" + picture_url +"\"}";
            writer.write(str);  
            writer.flush();  
            //writer.close();  
        }
        catch(Exception e) 
        {  
            e.getMessage();  
        } 
        finally 
        {  
            IOUtils.closeQuietly(writer);  
        }  
    }
    
    /**
     * loginOut:用户退出 . <br/>
     * @author zhoujq
     * @param request
     * @param response
     * @param session
     * @throws IOException
     * @throws ServletException
     * @since JDK 1.7
     */
    @RequestMapping(value = "/loginout")
    public void loginOut(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException
    {
        if (session != null)
        {
            session.removeAttribute("user");
        }
        request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(request, response);
    }
    
}