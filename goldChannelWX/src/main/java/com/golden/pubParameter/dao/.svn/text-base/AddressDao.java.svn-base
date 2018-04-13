/**
 * Project Name:goldChannel
 * File Name:AddressDao.java
 * Package Name:com.golden.pubParameter.dao
 * Date:2016年10月27日下午2:40:43
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.pubParameter.dao;

import java.util.List;
import java.util.Map;

import com.golden.pubParameter.po.AddressInfo;

/**
 * ClassName:AddressDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年10月27日 下午2:40:43 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface AddressDao {

    /**
     * selectPortByProvince:查询省下的港口. <br/>
     * @author zhoujq
     * @param key
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<AddressInfo> selectPortByProvince(String key) throws Exception;

    /**
     * selectAddressByParentkey:通过父key查询子地址. <br/>
     * @author zhoujq
     * @param key
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<AddressInfo> selectAddressByParentkey(String key) throws Exception;

    /**
     * selectAllPortInfo:所有港口及与省的关联. <br/>
     * @author zhoujq
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<AddressInfo> selectAllPortInfo() throws Exception;

    /**
     * createWharf:添加码头. <br/>
     * @author zhoujq
     * @param map
     * @throws Exception
     * @since JDK 1.7
     */
    void createWharf(Map<String, String> map) throws Exception;

    /**
     * selectAllInfo:查询地址(所有省/所有市/所有港口/码头). <br/>
     * @author zhoujq
     * @param type
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<AddressInfo> selectAllInfo(String type) throws Exception;

}

