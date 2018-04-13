package com.golden.typenews.dao;

import java.util.List;
import java.util.Map;

import com.golden.typenews.po.Information;

public interface NewsDao {

	/**
	 * 资讯列表
	 * @param map
	 * @return
	 */
	List<Information> queryNewsListInfoBytype(Map<String, Object> map);

	/**
	 * 资讯详情
	 * @param informationId
	 * @return
	 */
	Information queryNewsDetailsByid(String informationId);

    List<Information> querySetNews();

    List<Information> queryRefer();

}
