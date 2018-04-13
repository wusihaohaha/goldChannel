package com.golden.ship.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.common.Constants;
import com.golden.goods.dao.GoodsDao;
import com.golden.ship.dao.ShipDao;
import com.golden.ship.po.ApplyShipping;
import com.golden.ship.po.Ship;
import com.golden.ship.service.ShipService;

/**
 * @author wusihao
 */
@Service
public class ShipServiceImpl implements ShipService {
	
	@Autowired
	private ShipDao shipDao;
    @Autowired
    private GoodsDao goodsDao;
	
	@Override
	public void addShips(Ship ship) throws Exception{

         shipDao.addShips(ship);
	}
	
	/**
	 * 我的船舶列表
	 */
	@Override
	public List<Ship> queryMyshipList(String createuser,int beginIndex,int endIndex) throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("createuser", createuser);
		map.put("beginIndex", beginIndex);
		map.put("endIndex", endIndex);
		return shipDao.queryMyshipList(map);
	}

	/**
	 * 查询地方船舶列表
	 */
	@Override
	public List<Ship> findShiponRound(String currentPort,
			String topton,String downton,int beginIndex,int endIndex)
			throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("currentPort", currentPort);
		map.put("topton", topton);
		map.put("downton", downton);
		map.put("beginIndex", beginIndex);
		map.put("endIndex", endIndex);
        map.put("auditstate", Constants.shipAuditState.pass);
        //map.put("status", Constants.shipStatus.free);
//        map.put("apply", Constants.applyStatus.apply);
		return shipDao.findShiponRound(map);
	}

	/**
	 * 修改船舶详情
	 */
	@Override
	public void updateShipinfoByid(Ship ship) {
		shipDao.updateShipinfoByid(ship);
	}

	/**
     * 船运申请
     */
    @Override
    public void applyShipping(ApplyShipping applyShipping,String title, String content) throws Exception {
        Map<String,String> map = new HashMap<String, String>();
        //备份货物
        goodsDao.createBakGoodsInfo(applyShipping.getGoodssourceid());
        
        //补全货物信息
        map.put("goodssourceid", applyShipping.getGoodssourceid());
        map.put("goodsweight", applyShipping.getGoodsweight());
        map.put("freightprice", applyShipping.getFreightprice().toString());
        map.put("thefirstpayment", applyShipping.getThefirstpayment());
        map.put("paytype", applyShipping.getPaytype());
        map.put("status", Constants.goodsStatus.apply);//6 申请船运状态
        shipDao.updateGoodsInfo(map);

        //添加申请船运信息
        map.clear();
        map.put("shipid", applyShipping.getShipid());
        map.put("goodssourceid", applyShipping.getGoodssourceid());
        map.put("applyuser", applyShipping.getApplyuser());
        map.put("shipowner", applyShipping.getShipowner());
        map.put("status", Constants.shipApplyStatus.apply);//1 申请状态
        shipDao.addApplyShipping(map);
        
        //发送消息
        map.clear();
        map.put("shipid", applyShipping.getShipid());
        map.put("shipowner", applyShipping.getShipowner());
        map.put("applyuser", applyShipping.getApplyuser());
        map.put("title", title);
        map.put("content", content);
        map.put("messagetype", Constants.MessageType.personal);
        map.put("status", Constants.MessageStatus.Unread);
        shipDao.addMessageInfo(map);
    }

    /**
     * 查询船舶名称是否已存在
     */
	@Override
	public int queryShipCountByName(String shipname) {
		return shipDao.queryShipCountByName(shipname);
	}

	/**
     * 查询船舶名称是否已存在
     */
	@Override
	public int queryShipCountById(String shipid,String shipname) {
		 Map<String,String> map = new HashMap<String, String>();
		 map.put("shipid",shipid);
	     map.put("shipname",shipname);
		return shipDao.queryShipCountById(map);
	}

	/**
	 * 查询船舶状态
	 */
	@Override
	public String queryShipStatusById(String shipId) {
		return shipDao.queryShipStatusById(shipId);
	}

	/**
	 * 删除船舶信息
	 */
	@Override
	public void deleteMyShipById(String id) {
		shipDao.deleteMyShipById(id);
	}

    @Override
    public Map<String, Object> getShipById(String id) {
        return shipDao.getShipById(id);
    }

    @Override
    public void updateShip(Map<String, String> map) {
        shipDao.updateShip(map);
        
    }
}
