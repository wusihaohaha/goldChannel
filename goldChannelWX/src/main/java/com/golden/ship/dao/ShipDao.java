package com.golden.ship.dao;

import java.util.List;
import java.util.Map;

import com.golden.ship.po.ApplyShipping;
import com.golden.ship.po.Ship;


public interface ShipDao {
	
	/**
	 * 添加船舶信息
	 * @param Ship ship
	 * @return 
	 * @author wusihao
	 */
	void addShips(Ship ship) throws Exception;

	/**
	 * 我的船舶列表
	 * @param createuser
	 * @return
	 */
	List<Ship> queryMyshipList(Map<String,Object> map);

	/**
	 * 查询地方船舶列表
	 * @param map
	 * @return
	 */
	List<Ship> findShiponRound(Map<String,Object> map);

	/**
	 * 修改船舶详情
	 * @param ship
	 */
	void updateShipinfoByid(Ship ship);

	/**
	 * 补全货物信息
	 */
	void updateGoodsInfo(Map<String,String> map);

	/**
	 * 添加申请船运信息
	 * @param map
	 */
	void addApplyShipping(Map<String, String> map);

	/**
	 * 查询用户名及船名
	 * @param map
	 * @return
	 */
	ApplyShipping queryLettelInfo(Map<String, String> map);

	/**
	 * 添加消息
	 * @param map
	 */
	void addMessageInfo(Map<String, String> map);

	/**
	 * 查询船舶名称是否已存在
	 * @param shipname
	 * @return
	 */
	int queryShipCountByName(String shipname);

	/**
	 * 查询船舶名称是否已存在
	 * @param map
	 * @return
	 */
	int queryShipCountById(Map<String, String> map);

	/**
	 * 查询船舶状态
	 * @param shipId
	 * @return
	 */
	String queryShipStatusById(String shipId);

	/**
	 * 删除船舶信息
	 * @param map
	 */
	void deleteMyShipById(String id);

    Map<String, Object> getShipById(String id);

    void updateShip(Map<String, String> map);
}
