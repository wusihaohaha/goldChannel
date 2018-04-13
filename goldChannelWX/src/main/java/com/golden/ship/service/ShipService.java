package com.golden.ship.service;

import java.util.List;
import java.util.Map;

import com.golden.ship.po.ApplyShipping;
import com.golden.ship.po.Ship;

public interface ShipService {

	/**
	 * 添加船舶信息
	 * @param Ship ship 实体类
	 * @return void
	 * @author wusihao
	 */
	void addShips(Ship ship) throws Exception;

	/**
	 * 我的船舶列表
	 * @param createuser 用户id
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	List<Ship> queryMyshipList(String createuser,int beginIndex,int endIndex) throws Exception;

	/**
	 * 查询地方船舶列表
	 * @param currentprovince 省
	 * @param currentcity 市
	 * @param tonnage 吨位
	 * @param shiptype 船型
	 * @param beginindex 起始 分页
	 * @param endindex 结束 分页
	 * @return
	 * @throws Exception
	 */
	List<Ship> findShiponRound(String currentPort,
			String topton,String downton,int beginIndex,int endIndex) throws Exception;

	/**
	 * 修改船舶详情
	 * @param ship
	 */
	void updateShipinfoByid(Ship ship);

	/**
	 * applyShipping:船运申请. <br/>
	 * @author zhoujq
	 * @param applyShipping 申请信息
     * @param title 标题
	 * @param content 内容
	 * @throws Exception
	 * @since JDK 1.7
	 */
    void applyShipping(ApplyShipping applyShipping, String title, String content) throws Exception;

    /**
     * 查询船舶名称是否已存在
     * @param shipname
     * @return
     */
	int queryShipCountByName(String shipname);

	/**
	 * 查询船舶名称是否已存在
	 * @param shipid
	 * @param shipname
	 * @return
	 */
	int queryShipCountById(String shipid,String shipname);

	/**
	 * 查询船舶使用状态
	 * @param shipId
	 * @return
	 */
	String queryShipStatusById(String shipId);

	/**
	 * 删除船舶信息
	 * @param shipId
	 * @param statu
	 */
	void deleteMyShipById(String shipId);

    Map<String, Object> getShipById(String id);

    void updateShip(Map<String, String> map);
	
}
