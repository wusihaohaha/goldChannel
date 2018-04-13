/**
 * Project Name:fbSuperSystem
 * File Name:PictureRootPathService.java
 * Package Name:com.system.pubParameter.service
 * Date:2016年5月20日上午10:05:33
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.pubParameter.service;
import javax.servlet.http.HttpSession;
/**
 * ClassName:PictureRootPathService <br/>
 * Date:     2016年5月20日 上午10:05:33 <br/>
 * @author   litong
 * @since    JDK 1.7
 * @see 	 
 */

public interface PictureRootPathService
{

    /**
     * 功能：获取图片保存的根目录
     * @param session
     * @return
     */
    public String getPicRoot(HttpSession session, String pId);
}

