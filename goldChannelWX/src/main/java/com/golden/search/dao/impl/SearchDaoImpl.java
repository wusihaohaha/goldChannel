package com.golden.search.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.golden.common.BaseDao;
import com.golden.search.dao.SearchDao;
import com.golden.search.po.ApkVersionInfo;
import com.golden.search.po.HomeInfo;
import com.golden.search.po.Material;
import com.golden.search.po.NoticeInfo;
import com.golden.search.po.OilInfo;
import com.golden.search.po.PartsInfo;
import com.golden.search.po.ShipCommonInfo;
import com.golden.search.po.ShipDealInfo;
import com.golden.ship.po.Ship;
/**
 * Dao层持久层
 * @author xie
 */
@Component
public class SearchDaoImpl extends BaseDao implements SearchDao{

	/**
	 * 更具类型查询运联盟信息列表 成员及企业
	 * 1普通成员 2企业
	 */
	@Override
	public List<ShipCommonInfo> queryShipMembersBytype(Map<String,Object> map) {
		return getSqlMapClientTemplate().queryForList("search.queryShipMembersBytype",map);
	}

	/**
	 * 查询建材、配件信息列表
	 * 1建材 2配件
	 */
	@Override
	public List<PartsInfo> queryPartsListBytype(Map<String,Object> map) {
		return getSqlMapClientTemplate().queryForList("search.queryPartsListBytype",map);
	}

	/**
	 * 根据配件(建筑材料)id查询配件详情
	 */
	@Override
	public PartsInfo queryPartdetailByid(String partsid) {
		return (PartsInfo) getSqlMapClientTemplate().queryForObject("search.queryPartdetailByid",partsid);
	}

	/**
	 * 查询船舶交易信息列表
	 */
	@Override
	public List<ShipDealInfo> queryShipdealList(Map<String,Object> map) {
		return getSqlMapClientTemplate().queryForList("search.queryShipdealList",map);
	}

	/**
	 * 根据id查询船舶交易信息详情
	 */
	@Override
	public ShipDealInfo queryShipdealInfoByid(String shiptradeid) {
		return (ShipDealInfo) getSqlMapClientTemplate().queryForObject("search.queryShipdealInfoByid",shiptradeid);
	}

	/**
	 * 查询联盟成员的总数
	 */
	@Override
	public int queryShipMemberscount(String membertype) {
		return (Integer) getSqlMapClientTemplate().queryForObject("search.queryShipMemberscount",membertype);
	}

	/**
	 * 查询配件或建材总数
	 */
	@Override
	public int queryPartscount(String partstype) {
		return (Integer) getSqlMapClientTemplate().queryForObject("search.queryPartscount",partstype);
	}

	/**
	 * 查询船舶交易总数
	 */
	@Override
	public int queryqueryShipdealscount() {
		return (Integer) getSqlMapClientTemplate().queryForObject("search.queryqueryShipdealscount");
	}

	/**
	 * 查询建材列表
	 */
	@Override
	public List<Material> queryMaterialsList(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("search.queryMaterialsList",map);
	}

	/**
	 * 根据建材id查询建材详情
	 */
	@Override
	public Material queryMaterialdetailByid(String materialid) {
		return (Material) getSqlMapClientTemplate().queryForObject("search.queryMaterialdetailByid",materialid);
	}

	/**
	 * 公告列表
	 */
	@Override
	public List<NoticeInfo> queryOutbidNoticeList(Map<String,Object> map) {
		return getSqlMapClientTemplate().queryForList("search.queryOutbidNoticeList",map);
	}

	/**
	 * 公告详情
	 */
	@Override
	public NoticeInfo queryNoticedealInfoByid(String goodsbidid) {
		return (NoticeInfo) getSqlMapClientTemplate().queryForObject("search.queryNoticedealInfoByid",goodsbidid);
	}

	/**
	 * 查询船舶详情
	 */
	@Override
	public Ship queryShipinfoByid(Map<String, String> map) {
		return (Ship) getSqlMapClientTemplate().queryForObject("search.queryShipinfoByid",map);
	}

	/**
	 * 查询平台统计数据.
	 * @see com.golden.search.dao.SearchDao#selectDataStatistics()
	 */
    @Override
    public HomeInfo selectDataStatistics() throws Exception {
        return (HomeInfo) getSqlMapClientTemplate().queryForObject("search.selectDataStatistics");
    }

    //获取app文件路径
	@Override
	public ApkVersionInfo queryApkUpdateurl() {
		return (ApkVersionInfo) getSqlMapClientTemplate().queryForObject("search.queryApkUpdateurl");
	}

	//加油信息
	@Override
	public OilInfo queryOilOnlineByType(String type) {
		return (OilInfo) getSqlMapClientTemplate().queryForObject("search.queryOilOnline",type);
	}

}
