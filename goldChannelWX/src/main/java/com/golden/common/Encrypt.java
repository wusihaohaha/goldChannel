package com.golden.common;

/*
 *   
 *   当前文件：DesEncrypt.java   
 *   创建日期�?005-7-29   
 *   �?  �?  号：1.0   
 *   作�?：kang1   
 *     
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.cloopen.rest.sdk.utils.encoder.BASE64Encoder;

/**
 * 
 * <使用MD5加密直接传�?过来>
 * <功能详细描述>
 * 
 */
public class Encrypt
{
    
    /**
     * 加密String明文输入,String密文输出
     * 
     * @param strMing
     * @return
     */
    public static String getEncString(String strMing)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bt = md.digest(strMing.getBytes());
            // 将md5加密后的字节数组,采用base64算法处理
            BASE64Encoder base64 = new BASE64Encoder();
            String msg = base64.encode(bt);
            System.out.println("加密后的字符�?" + msg);
            return msg;
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args)
    {
       Encrypt.getEncString("123456");
       //MD5:4QrcOUm6Wau+VuBX8g+IPg==
    }
}