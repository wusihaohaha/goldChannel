package com.golden.search.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.common.Constants;
import com.golden.search.dao.SearchDao;
import com.golden.search.po.ApkVersionInfo;
import com.golden.search.po.HomeInfo;
import com.golden.search.po.Material;
import com.golden.search.po.NoticeInfo;
import com.golden.search.po.OilInfo;
import com.golden.search.po.PartsInfo;
import com.golden.search.po.ShipCommonInfo;
import com.golden.search.po.ShipDealInfo;
import com.golden.search.service.SearchService;
import com.golden.ship.po.Ship;
/**
 * Service层
 * @author xie
 */
@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	private SearchDao searchDao;
	
	/**
	 * 根据类型查询运联盟信息列表 成员及企业
	 * 1普通成员 2企业
	 */
	@Override
	public List<ShipCommonInfo> queryShipMembersBytype(String membertype,int beginIndex,int endIndex) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("membertype", membertype);
		map.put("beginIndex", beginIndex);
		map.put("endIndex", endIndex);
		return searchDao.queryShipMembersBytype(map);
	}

	/**
	 * 查询配件信息列表 
	 */
	@Override
	public List<PartsInfo> queryPartsListBytype(String partsname,int beginIndex,int endIndex) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("partsname", partsname);
		map.put("beginIndex", beginIndex);
		map.put("endIndex", endIndex);
		return searchDao.queryPartsListBytype(map);
	}

	/**
	 * 根据配件(建筑材料)id查询配件详情
	 */
	@Override
	public PartsInfo queryPartdetailByid(String partsid) {
		return searchDao.queryPartdetailByid(partsid);
	}

	/**
	 * 查询船舶交易信息列表
	 */
	@Override
	public List<ShipDealInfo> queryShipdealList(String tradetype,int beginIndex,int endIndex) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("tradetype", tradetype);
		map.put("beginIndex", beginIndex);
		map.put("endIndex", endIndex);
		return searchDao.queryShipdealList(map);
	}

	/**
	 * 根据id查询船舶交易信息详情
	 */
	@Override
	public ShipDealInfo queryShipdealInfoByid(String shiptradeid) {
		return searchDao.queryShipdealInfoByid(shiptradeid);
	}

	/**
	 * 查询联盟成员的总数
	 */
	@Override
	public int queryShipMemberscount(String membertype) {
		return searchDao.queryShipMemberscount(membertype);
	}

	/**
	 * 查询配件或建材总数
	 */
	@Override
	public int queryPartscount(String partstype) {
		return searchDao.queryPartscount(partstype);
	}

	/**
	 * 查询船舶交易总数
	 */
	@Override
	public int queryqueryShipdealscount() {
		return searchDao.queryqueryShipdealscount();
	}

	/**
	 * 查询建材列表
	 */
	@Override
	public List<Material> queryMaterialsList(String name, int beginIndex,
			int endIndex) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("name", name);
		map.put("beginIndex", beginIndex);
		map.put("endIndex", endIndex);
		return searchDao.queryMaterialsList(map);
	}

	/**
	 * 根据建材id查询建材详情
	 */
	@Override
	public Material queryMaterialdetailByid(String materialid) {
		return searchDao.queryMaterialdetailByid(materialid);
	}

	/**
	 * 公告列表
	 */
	@Override
	public List<NoticeInfo> queryOutbidNoticeList(String status,int beginIndex,int endIndex) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("status", status);
		map.put("beginIndex", beginIndex);
		map.put("endIndex", endIndex);
		return searchDao.queryOutbidNoticeList(map);
	}

	/**
	 * 公告详情
	 */
	@Override
	public NoticeInfo queryNoticedealInfoByid(String goodsbidid) {
		return searchDao.queryNoticedealInfoByid(goodsbidid);
	}

	/**
	 * 查询船舶详情
	 */
	@Override
	public Ship queryShipinfoByid(String shipid,String userid) {
	    Map<String,String> map=new HashMap<String, String>();
        map.put("shipid", shipid);
        map.put("userid", userid);
        map.put("apply", Constants.applyStatus.apply);
        map.put("noApply", Constants.applyStatus.noApply);
		return searchDao.queryShipinfoByid(map);
	}

	/**
	 * 查询平台统计数据.
	 * @see com.golden.search.service.SearchService#selectDataStatistics()
	 */
    @Override
    public HomeInfo selectDataStatistics() throws Exception {
        return searchDao.selectDataStatistics();
    }

    //获取app文件路径
	@Override
	public ApkVersionInfo queryApkUpdateurl() {
		return searchDao.queryApkUpdateurl();
	}

	//加油信息
	@Override
	public OilInfo queryOilOnlineByType(String type) {
		return searchDao.queryOilOnlineByType(type);
	}
	 
}
