package com.golden.search.dao;

import java.util.List;
import java.util.Map;

import com.golden.search.po.ApkVersionInfo;
import com.golden.search.po.HomeInfo;
import com.golden.search.po.Material;
import com.golden.search.po.NoticeInfo;
import com.golden.search.po.OilInfo;
import com.golden.search.po.PartsInfo;
import com.golden.search.po.ShipCommonInfo;
import com.golden.search.po.ShipDealInfo;
import com.golden.ship.po.Ship;

public interface SearchDao {

	/**
	 * 更具类型查询运联盟信息列表 成员及企业 
	 * @param membertype 1普通成员 2企业
	 * @return
	 */
	List<ShipCommonInfo> queryShipMembersBytype(Map<String,Object> map);

	/**
	 * 查询建材、配件信息列表 
	 * @param partstype 1建材 2配件
	 * @return
	 */
	List<PartsInfo> queryPartsListBytype(Map<String,Object> map);

	/**
	 * 根据配件(建筑材料)id查询配件详情
	 * @param partsid 建材、配件id
	 * @return
	 */
	PartsInfo queryPartdetailByid(String partsid);

	/**
	 * 查询船舶交易信息列表
	 * @return
	 */
	List<ShipDealInfo> queryShipdealList(Map<String,Object> map);

	/**
	 * 根据id查询船舶交易信息详情
	 * @param shiptradeid 船舶交易id
	 * @return
	 */
	ShipDealInfo queryShipdealInfoByid(String shiptradeid);

	/**
	 * 查询联盟成员的总数
	 * @param membertype
	 * @return
	 */
	int queryShipMemberscount(String membertype);

	/**
	 * 查询配件或建材总数
	 * @param partstype
	 * @return
	 */
	int queryPartscount(String partstype);

	/**
	 * 查询船舶交易总数
	 * @return
	 */
	int queryqueryShipdealscount();

	/**
	 * 查询建材列表
	 * @param map
	 * @return
	 */
	List<Material> queryMaterialsList(Map<String, Object> map);

	/**
	 * 根据建材id查询建材详情
	 * @param materialid
	 * @return
	 */
	Material queryMaterialdetailByid(String materialid);

	/**
	 * 公告列表
	 * @return
	 */
	List<NoticeInfo> queryOutbidNoticeList(Map<String,Object> map);

	/**
	 * 公告详情
	 * @param goodsbidid
	 * @return
	 */
	NoticeInfo queryNoticedealInfoByid(String goodsbidid);

	/**
	 * 查询船舶详情
	 * @param shipid
	 * @return
	 */
	Ship queryShipinfoByid(Map<String, String> map);

	/**
	 * selectDataStatistics:查询平台统计数据. <br/>
	 * @author zhoujq
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
    HomeInfo selectDataStatistics() throws Exception;

    //获取app文件路径
    ApkVersionInfo queryApkUpdateurl();

    //加油信息
	OilInfo queryOilOnlineByType(String type);

}
