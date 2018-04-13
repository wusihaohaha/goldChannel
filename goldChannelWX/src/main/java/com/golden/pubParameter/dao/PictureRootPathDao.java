package com.golden.pubParameter.dao;
import org.springframework.stereotype.Component;

import com.golden.common.BaseDao;

@Component 
public class PictureRootPathDao extends BaseDao
{
	public String getCouponPicRoot(String p_id)
	{
		return (String) getSqlMapClientTemplate().queryForObject("PubParameterSelect.getCouponPicRoot", p_id);
		
	}
}