/**
 * Project Name:goldChannel
 * File Name:LoginBaseController.java
 * Package Name:com.golden.login.action
 * Date:2016年5月20日下午3:34:54
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.login.action;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * ClassName:LoginBaseController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年5月20日 下午3:34:54 <br/>
 * @author   zhangliu
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class LoginBaseController
{
    @InitBinder  
    public void initBindUser(WebDataBinder binder)
    {
        binder.setFieldDefaultPrefix("ballplayerinfo.");
    }
}

