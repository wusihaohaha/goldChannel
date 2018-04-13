package com.golden.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * ClassName: FileOperateUtil 文件上传下载共通Until
 * date: 2016年8月2日 下午5:14:19 <br/>
 * @author zhoujq
 * @version 
 * @since JDK 1.7
 */
public class FileOperateUtil {
/**
 * upload:文件上传，可上传一个或多个文件（限只上传文件的情况）
 * @author zhoujq
 * @param file 上传文件名称
 * @param projectName 所属工程名称
 * @param request
 * @param model
 * @return 返回文件路径
 * @throws IOException
 * @since JDK 1.7
 */
    @RequestMapping(value = "/fileUpload")
    public String onlyFileUpload(@RequestParam("file[]") MultipartFile file[],String projectName,HttpServletRequest request) throws IOException {
        String strRetrun="";
        try {
            String path = request.getSession().getServletContext().getRealPath("/");//文件保存目录，也可自定为绝对路径
            String strPath="upload//projectFile//"+projectName;
            path=path+strPath;
            for(int i=0;i<file.length ;i++){
                String fileName = file[i].getOriginalFilename();//获取上传文件原名
                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {//文件不存在，创建路径
                    targetFile.mkdirs();
                }
                file[i].transferTo(targetFile);
            }
            strRetrun=strPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strRetrun;
    }
    
    /**
     * 上传一个或多个文件
     * uploadFile:通过控件name自动提取客户端上传的文件，并返回文件名称list，名称为空表示未上传文件. <br/>
     * @author zhoujq
     * @param request Request对象
     * @param fileSavePath 文件保存路径
     * @param controlName 控件的name
     * @param postfix 文件后缀（pc端请传空值）
     * @return
     * @since JDK 1.7
     */
    @RequestMapping(value = "/uploadFile")
    public static List<String> uploadFile(HttpServletRequest request,String fileSavePath,String controlName,String postfix) {
        List<String> strReturnList=new ArrayList<String>();
        Random random = new Random();
        int rannum =0;
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        	List<MultipartFile> files=multipartRequest.getFiles(controlName);//根据控件name获取上传文件
            for(int i=0;i<files.size();i++){
                String fileYName=files.get(i).getOriginalFilename();//文件原名称
                if("".equals(fileYName)){
                    continue;
                }
                if(fileYName.lastIndexOf('.')<=0){//文件无后缀的场合加后缀
                    fileYName=fileYName+postfix;
                }
                rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
                String fileName = Long.toString(System.currentTimeMillis())+String.valueOf(rannum)+String.valueOf(i)+fileYName.substring(fileYName.lastIndexOf('.'),fileYName.length());//重新命名(时间戳+加随机数)
                File targetFile = new File(fileSavePath, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                files.get(i).transferTo(targetFile);
                strReturnList.add(fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strReturnList;
    }
    
    /**
     * fileDownload:文件下载. <br/>
     * @author zhoujq
     * @param response
     * @param filePath 文件路径（含文件名称）
     * @param fileName 文件名称（含后缀）
     * @return
     * @throws IOException
     * @since JDK 1.7
     */
    @RequestMapping(value = "/fileDownload")
    public String fileDownload(HttpServletResponse response,String filePath ,String fileName) throws IOException{
        String strRetrun="fail";
        //获取网站部署路径(通过ServletContext对象)，用于确定下载文件位置，从而实现下载
        /*String path = request.getSession().getServletContext().getRealPath("/");*/
        response.setContentType("multipart/form-data");//设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setHeader("Content-Disposition", "attachment;fileName="+fileName); //设置文件头：最后一个参数是设置下载文件名
        OutputStream out = response.getOutputStream();
        InputStream in = new FileInputStream(filePath);//通过文件路径获得File对象
        try {
          //写文件
            int b;
            while((b=in.read())!= -1){
                out.write(b);
            }
            in.close();
            out.close();
            in=null;
            out=null;
            strRetrun="success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(in!=null){
                in.close();
            }
            if(out!=null){
                out.close();
            }
        }
        return strRetrun;
    }
    
    /**
     * deleteFile:删除单个文件. <br/>
     * @author zhoujq
     * @param filePath
     * @return
     * @since JDK 1.7
     */
    public static boolean deleteFile(String filePath) {
        Boolean bolflag = false;
        try {
            File file = new File(filePath);
            // 路径为文件且不为空则进行删除
            if (file.isFile() && file.exists()) {
                bolflag =file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bolflag;
    }
    
    /**
     * deleteDirectory:删除目录下的所有文件及子目录下所有文件. <br/>
     * @author zhoujq
     * @param directoryPath
     * @return
     * @since JDK 1.7
     */
    public Boolean deleteDirectory(String directoryPath) {
        
        Boolean bloReturn = false;
        Boolean bloflag = true;
        try {
            // 如果sPath不以文件分隔符结尾，自动添加文件分隔符
            if (!directoryPath.endsWith(File.separator)) {
                directoryPath = directoryPath + File.separator;
            }

            File dirFile = new File(directoryPath);

            // 目录不存在或不是一个目录，退出
            if (!dirFile.exists() || !dirFile.isDirectory()) {
                return bloReturn;
            }

            // 删除文件夹下所有文件（包括子目录）
            File[] filesArr = dirFile.listFiles();
            for (int i = 0; i < filesArr.length; i++) {
                // 删除文件
                if (filesArr[i].isFile()) {
                    if(filesArr[i].exists()){
                        bloflag = filesArr[i].delete();
                    }
                    if (!bloflag) break;
                }// 删除子目录
                else {
                    bloflag = deleteDirectory(filesArr[i].getAbsolutePath());
                    if (!bloflag) break;
                }
            }

            if (!bloflag) return bloReturn;

            // 删除当前目录
            if (dirFile.delete()) {
                bloReturn = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bloReturn;
    }
}
