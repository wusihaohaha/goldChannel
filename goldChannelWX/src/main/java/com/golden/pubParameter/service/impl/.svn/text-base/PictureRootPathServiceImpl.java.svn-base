package com.golden.pubParameter.service.impl;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.pubParameter.dao.PictureRootPathDao;
import com.golden.pubParameter.service.PictureRootPathService;

@Service
public class PictureRootPathServiceImpl implements PictureRootPathService {
	
	@Autowired
	private PictureRootPathDao pictureRootPathDao;
	/**
	 * 功能：获取图片保存的根目录
	 * @param session
	 * @return
	 */
	public String getPicRoot(HttpSession session, String pId)
	{
		String fileRoot = (String) session.getAttribute(pId);
    	if(!StringUtils.isNotBlank(fileRoot))
    	{
    		fileRoot = pictureRootPathDao.getCouponPicRoot(pId);
    		session.setAttribute(pId, fileRoot);
    		System.out.println(session.getAttribute(pId).toString());
    	}
		return fileRoot;
    }
}