package com.golden.typenews.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.typenews.dao.NewsDao;
import com.golden.typenews.po.Information;
import com.golden.typenews.service.NewsService;
@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;

	/**
	 * 资讯列表
	 */
	@Override
	public List<Information> queryNewsListInfoBytype(String type,
			int beginIndex, int endIndex) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("type",type);
		map.put("beginIndex",beginIndex);
		map.put("endIndex",endIndex);
		return newsDao.queryNewsListInfoBytype(map);
	}

	/**
	 * 资讯详情
	 */
	@Override
	public Information queryNewsDetailsByid(String informationId) {
		return newsDao.queryNewsDetailsByid(informationId);
	}

    @Override
    public List<Information> querySetNews() {
        return newsDao.querySetNews();
    }

    @Override
    public List<Information> queryRefer() {
        return newsDao.queryRefer();
    }

}
