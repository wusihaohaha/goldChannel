/**
 * Project Name:goldChannel
 * File Name:AddressService.java
 * Package Name:com.golden.pubParameter.service
 * Date:2016年10月27日下午2:39:22
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.pubParameter.service;

import java.util.List;

import com.golden.pubParameter.po.AddressInfo;

/**
 * ClassName:AddressService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年10月27日 下午2:39:22 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface AddressService {

    /**
     * selectPortByProvince:查询省下的港口. <br/>
     * @author zhoujq
     * @param key key值
     * @return
     * @throws Exception
     * @since JDK 1.7
     */
    List<AddressInfo> selectPortByProvince(String key) throws Exception;

    /**
     * selectAddressByParentkey:通过父key查询子地址. <br/>
     * @author zhoujq
     * @param key key值
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
     * @param parentKey 父key
     * @param wharf 码头名称
     * @param addressType 地址类型
     * @throws Exception
     * @since JDK 1.7
     */
    void createWharf(String parentKey, String wharf,String addressType) throws Exception;

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

