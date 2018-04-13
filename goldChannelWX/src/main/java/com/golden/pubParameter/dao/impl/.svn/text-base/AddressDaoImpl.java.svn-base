/**
 * Project Name:goldChannel
 * File Name:AddressDaoImpl.java
 * Package Name:com.golden.pubParameter.dao.impl
 * Date:2016年10月27日下午2:40:54
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.pubParameter.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.golden.common.BaseDao;
import com.golden.pubParameter.dao.AddressDao;
import com.golden.pubParameter.po.AddressInfo;

/**
 * ClassName:AddressDaoImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年10月27日 下午2:40:54 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component
public class AddressDaoImpl extends BaseDao implements AddressDao{

    /**
     * 查询省下的港口.
     * @see com.golden.pubParameter.dao.AddressDao#selectPortByProvince(java.lang.String)
     */
    @Override
    public List<AddressInfo> selectPortByProvince(String key) throws Exception {
        return getSqlMapClientTemplate().queryForList("PubParameterSelect.selectPortByProvince", key);
    }

    /**
     * 通过父key查询子地址.
     * @see com.golden.pubParameter.dao.AddressDao#selectAddressByParentkey(java.lang.String)
     */
    @Override
    public List<AddressInfo> selectAddressByParentkey(String key) throws Exception {
        return getSqlMapClientTemplate().queryForList("PubParameterSelect.selectAddressByParentkey", key);
    }

    /**
     * 所有港口及与省的关联.
     * @see com.golden.pubParameter.dao.AddressDao#selectAllPortInfo()
     */
    @Override
    public List<AddressInfo> selectAllPortInfo() throws Exception {
        return getSqlMapClientTemplate().queryForList("PubParameterSelect.selectAllPortInfo");
    }

    /**
     * 添加码头.
     * @see com.golden.pubParameter.dao.AddressDao#createWharf(java.util.Map)
     */
    @Override
    public void createWharf(Map<String, String> map) throws Exception {
        getSqlMapClientTemplate().insert("PubParameterSelect.createWharf",map);
    }

    /**
     * 查询地址(所有省/所有市/所有港口/码头).
     * @see com.golden.pubParameter.dao.AddressDao#selectAllInfo(java.lang.String)
     */
    @Override
    public List<AddressInfo> selectAllInfo(String type) throws Exception {
        return getSqlMapClientTemplate().queryForList("PubParameterSelect.selectAllInfo",type);
    }

}

