/**
 * Project Name:fbSuperSystem
 * File Name:FileUploadCommon.java
 * Package Name:com.system.common
 * Date:2016年5月19日下午8:23:18
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.common;
/**
 * ClassName:FileUploadCommon <br/>
 * Date:     2016年5月19日 下午8:23:18 <br/>
 * @author   litong
 * @since    JDK 1.7
 * @see 	 
 */
public class FileUploadCommon
{
/*    *//** 允许上传的扩展名*//*  
    public static final String [] EXTENS_IONPERMIT = {"jpg", "png", "gif"};
    *//** 上传文件最大为10M*//*   
    public static final Long FILE_MAXSIZE = 10*1024*1024L;
    *//** 统一的编码格式*//*
    public static final String ENCODE = "UTF-8";
    */
    /** 反斜线符号*/
    public static final String BACK_SLASH ="/";
    /** 图片保存根目录  本地*//*
    public static final String ROOTPATH_ID_LOCAL = "file_root_local";*/
    /** 图片保存根目录  服务器 session中存储文件的根路径key*/
    public static final String ROOTPATH_ID = "file_root";//file_root
    /** 默认球员头像路径  服务器*/
    public static final String USER_HEAD = "user_head";
/*    *//** 默认球队头像路径  服务器*//*
    public static final String TEAM_IMG = "team_img";
    *//** 默认协会头像路径  服务器*//*
    public static final String ASSOCIATION_IMG = "association_img";
    
    *//** 上传目录名*/
    public static final String UPLOADFOLDER_NAME = "uploadFiles";
	
    /** 上传临时文件存储目录*//*  
    public static final String TEMPFOLDER_NAME = "tempFiles";
    *//**session中存储文件的根路径key*//*
    //public static final String FILE_ROOT = "PicRoot";
    
    *//**文件上真实目录相对于指定路径的路径*/
    public static final String UPLOAD_FILES = "/upload/userPic/";// /upload/uploadFiles/
}

