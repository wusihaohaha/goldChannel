/**
 * Project Name:goldChannel
 * File Name:AddressInfo.java
 * Package Name:com.golden.pubParameter.po
 * Date:2016年10月27日下午2:45:40
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.pubParameter.po;

import java.io.Serializable;

/**
 * ClassName:AddressInfo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年10月27日 下午2:45:40 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class AddressInfo implements Serializable{

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.7
     */
    private static final long serialVersionUID = 1L;
    
    private String d_key; //key值
    private String d_value; //内容
    private String parentkey; //上一级key 0的场合，为第一级
    private String type; //类别 1:省 2:市 3:港口 4:码头
    
    public String getD_key() {
        return d_key;
    }
    public void setD_key(String d_key) {
        this.d_key = d_key;
    }
    public String getD_value() {
        return d_value;
    }
    public void setD_value(String d_value) {
        this.d_value = d_value;
    }
    public String getParentkey() {
        return parentkey;
    }
    public void setParentkey(String parentkey) {
        this.parentkey = parentkey;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}

