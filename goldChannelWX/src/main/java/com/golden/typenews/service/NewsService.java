package com.golden.typenews.service;

import java.util.List;

import com.golden.typenews.po.Information;

public interface NewsService {

	/**
	 * 资讯列表
	 * @param type
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	List<Information> queryNewsListInfoBytype(String type, int beginIndex, int endIndex);

	/**
	 * 资讯详情
	 * @param informationId
	 * @return
	 */
	Information queryNewsDetailsByid(String informationId);

    List<Information> querySetNews();

    List<Information> queryRefer();

}
