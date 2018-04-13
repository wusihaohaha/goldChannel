package com.golden.search.service;

import java.util.List;

import com.golden.search.po.ApkVersionInfo;
import com.golden.search.po.HomeInfo;
import com.golden.search.po.Material;
import com.golden.search.po.NoticeInfo;
import com.golden.search.po.OilInfo;
import com.golden.search.po.PartsInfo;
import com.golden.search.po.ShipCommonInfo;
import com.golden.search.po.ShipDealInfo;
import com.golden.ship.po.Ship;

public interface SearchService {

	/**
	 * 根据类型查询运联盟信息列表 成员及企业
	 * @param membertype 1普通成员 2企业
	 * @return
	 */
	List<ShipCommonInfo> queryShipMembersBytype(String membertype,int beginIndex,int endIndex);

	/**
	 * 查询配件信息列表 
	 * @return
	 */
	List<PartsInfo> queryPartsListBytype(String partsname,int beginIndex,int endIndex);

	/**
	 * 根据配件(建筑材料)id查询配件详情
	 * @param partsid
	 * @return
	 */
	PartsInfo queryPartdetailByid(String partsid);

	/**
	 * 查询船舶交易信息列表
	 * @return
	 */
	List<ShipDealInfo> queryShipdealList(String tradetype,int beginIndex,int endIndex);

	/**
	 * 根据id查询船舶交易信息详情
	 * @param shiptradeid
	 * @return
	 */
	ShipDealInfo queryShipdealInfoByid(String shiptradeid);

	/**
	 * 查询运联盟成员的总数
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
	 * @param name
	 * @param string
	 * @param string2
	 * @return
	 */
	List<Material> queryMaterialsList(String name, int beginIndex, int endIndex);

	/**
	 * 根据建材id查询建材详情
	 * @param materialid
	 * @return
	 */
	Material queryMaterialdetailByid(String materialid);

	/**
	 * 公告列表
     * @param status 竞标状态
	 * @return
	 */
	List<NoticeInfo> queryOutbidNoticeList(String status,int beginIndex,int endIndex);

	/**
	 * 公告详情
	 * @param goodsbidid 竞标id
	 * @return
	 */
	NoticeInfo queryNoticedealInfoByid(String goodsbidid);

	/**
	 * 查询船舶详情
	 * @param shipid
	 * @return
	 */
	Ship queryShipinfoByid(String shipid,String userid);

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
