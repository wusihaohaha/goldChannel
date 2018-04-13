/**
 * Project Name:goldChannel
 * File Name:AddressServiceImpl.java
 * Package Name:com.golden.pubParameter.service.impl
 * Date:2016年10月27日下午2:39:53
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.pubParameter.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.pubParameter.dao.AddressDao;
import com.golden.pubParameter.po.AddressInfo;
import com.golden.pubParameter.service.AddressService;

/**
 * ClassName:AddressServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年10月27日 下午2:39:53 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressDao addressDao;
    
    /**
     * 查询省下的港口.
     * @see com.golden.pubParameter.service.AddressService#selectPortByProvince(java.lang.String)
     */
    @Override
    public List<AddressInfo> selectPortByProvince(String key) throws Exception {
        return addressDao.selectPortByProvince(key);
    }

    /**
     * 通过父key查询子地址.
     * @see com.golden.pubParameter.service.AddressService#selectAddressByParentkey(java.lang.String)
     */
    @Override
    public List<AddressInfo> selectAddressByParentkey(String key) throws Exception {
        return addressDao.selectAddressByParentkey(key);
    }

    /**
     * 所有港口及与省的关联.
     * @see com.golden.pubParameter.service.AddressService#selectAllPortInfo()
     */
    @Override
    public List<AddressInfo> selectAllPortInfo() throws Exception {
        return addressDao.selectAllPortInfo();
    }

    /**
     * 添加码头.
     * @see com.golden.pubParameter.service.AddressService#createWharf(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void createWharf(String parentKey, String wharf,String addressType) throws Exception {
        Map<String, String> map=new HashMap<String, String>();
        map.put("parentKey", parentKey);
        map.put("wharf", wharf);
        map.put("addressType", addressType);
        addressDao.createWharf(map);
    }

    /**
     * 查询地址(所有省/所有市/所有港口/码头).
     * @see com.golden.pubParameter.service.AddressService#selectAllInfo(java.lang.String)
     */
    @Override
    public List<AddressInfo> selectAllInfo(String type) throws Exception {
        return addressDao.selectAllInfo(type);
    }

}

