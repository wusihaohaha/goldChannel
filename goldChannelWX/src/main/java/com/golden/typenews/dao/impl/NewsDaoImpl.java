package com.golden.typenews.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.golden.common.BaseDao;
import com.golden.typenews.dao.NewsDao;
import com.golden.typenews.po.Information;
import com.ibatis.sqlmap.client.SqlMapClient;
@Component
public class NewsDaoImpl extends BaseDao implements NewsDao {

	/**
	 * 资讯列表
	 */
	@Override
	public List<Information> queryNewsListInfoBytype(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("news.queryNewsListInfoBytype",map);
	}

	/**
	 * 资讯详情
	 */
	@Override
	public Information queryNewsDetailsByid(String informationId) {
		return (Information) getSqlMapClientTemplate().queryForObject("news.queryNewsDetailsByid",informationId);
	}

    @Override
    public List<Information> querySetNews() {
        return getSqlMapClientTemplate().queryForList("news.querySetNews");

    }

    @Override
    public List<Information> queryRefer() {
        return getSqlMapClientTemplate().queryForList("news.queryRefer");
    }
	
}
