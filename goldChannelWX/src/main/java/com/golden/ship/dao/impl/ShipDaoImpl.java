package com.golden.ship.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.golden.common.BaseDao;
import com.golden.ship.dao.ShipDao;
import com.golden.ship.po.ApplyShipping;
import com.golden.ship.po.Ship;

/**
 * @author wusihao
 */
@Component
public class ShipDaoImpl extends BaseDao implements ShipDao{

	/**
	 * 添加船舶信息.
	 * @see com.golden.ship.dao.ShipDao#addShips(com.golden.ship.po.Ship)
	 */
	@Override
	public void addShips(Ship ship) throws Exception {
		getSqlMapClientTemplate().insert("Ship.addShips",ship);
	}

	/**
	 * 我的船舶列表
	 */
	@Override
	public List<Ship> queryMyshipList(Map<String,Object> map) {
		return getSqlMapClientTemplate().queryForList("Ship.queryMyshipList",map);
	}

	/**
	 * 查询地方船舶列表
	 */
	@Override
	public List<Ship> findShiponRound(Map<String,Object> map) {
		return getSqlMapClientTemplate().queryForList("Ship.findShiponRound",map);
	}

	/**
	 * 修改船舶详情
	 */
	@Override
	public void updateShipinfoByid(Ship ship) {
		getSqlMapClientTemplate().update("Ship.updateShipinfoByid",ship);
	}

	/**
	 * 补全货物信息
	 */
	@Override
	public void updateGoodsInfo(Map<String,String> map) {
		getSqlMapClientTemplate().update("Ship.updateGoodsInfo",map);
	}

	/**
	 * 添加申请船运信息
	 */
	@Override
	public void addApplyShipping(Map<String, String> map) {
		getSqlMapClientTemplate().insert("Ship.addApplyShipping",map);
	}

	/**
	 * 查询用户名及船名
	 */
	@Override
	public ApplyShipping queryLettelInfo(Map<String, String> map) {
		return (ApplyShipping) getSqlMapClientTemplate().queryForObject("Ship.queryLettelInfo",map);
	}

	/**
	 * 添加消息
	 */
	@Override
	public void addMessageInfo(Map<String, String> map) {
		getSqlMapClientTemplate().insert("Ship.addMessageInfo",map);
	}

	/**
	 * 查询船舶名称是否已存在
	 */
	@Override
	public int queryShipCountByName(String shipname) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Ship.queryShipCountByName",shipname);
	}

	/**
	 * 查询船舶名称是否已存在
	 */
	@Override
	public int queryShipCountById(Map<String, String> map) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Ship.queryShipCountById",map);
	}

	/**
	 * 查询船舶状态
	 */
	@Override
	public String queryShipStatusById(String shipId) {
		return (String) getSqlMapClientTemplate().queryForObject("Ship.queryShipStatusById",shipId);
	}

	/**
	 * 删除船舶信息
	 */
	@Override
	public void deleteMyShipById(String id) {
		getSqlMapClientTemplate().delete("Ship.deleteMyShipById",id);
	}

    @Override
    public Map<String, Object> getShipById(String id) {
        return (Map<String, Object>) getSqlMapClientTemplate().queryForObject("Ship.getShipById",id);

    }

    @Override
    public void updateShip(Map<String, String> map) {
        getSqlMapClientTemplate().update("Ship.updateShip",map);

        
    }
	
	
}
