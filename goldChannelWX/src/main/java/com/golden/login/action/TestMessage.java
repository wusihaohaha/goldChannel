package com.golden.login.action;

import java.util.Random;

import com.golden.weixin.CommonUtil;

public class TestMessage {

    public static void main(String[] args) {
//        String url = "http://sms.106jiekou.com/utf8/sms.aspx?account=wusihaohaha&password=wusihaohaha123&mobile=15207246768&content=您的订单编码：123。如需帮助请联系客服。";
//        String code=CommonUtil.sendGet(url, null);
        Random random = new Random();  
        
        int rannum = (int) (random.nextDouble() * (9999 - 1000 + 1)) + 1000;// 获取5位随机数  
  
//        return rannum + "";// 
        System.out.println(rannum);
    }

}
