package com.golden.repair.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.login.po.UserBean;
import com.golden.repair.dao.RepairDao;
import com.golden.repair.po.Maintainer;
import com.golden.repair.po.RepairApply;
import com.golden.repair.service.RepairService;
@Service
public class RepairServiceImpl implements RepairService{

	@Autowired
	private RepairDao repairDao;

	/**
	 * 查询用户简单信息
	 */
	@Override
	public UserBean querySimpUserinfoByid(String userId) {
		return repairDao.querySimpUserinfoByid(userId);
	}

	/**
	 * 添加维修师傅信息
	 */
	@Override
	public void addMaintainerInfo(Maintainer maintainer) {
		Map<String,String> map =new HashMap<String,String>();
		map.put("applyUser", maintainer.getApplyUser());
		map.put("userName", maintainer.getUserName());
		map.put("userTel", maintainer.getUserTel());
		map.put("repairContent", maintainer.getRepairContent());
		map.put("qualifiCation", maintainer.getQualifiCation());
		map.put("wechat", maintainer.getWechat());
		repairDao.addMaintainerInfo(map);
	}

	/**
	 * 我的报修列表
	 */
	@Override
	public List<RepairApply> queryRepairinfoList(String userId,int beginIndex,int endIndex) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("beginIndex", beginIndex);
		map.put("endIndex", endIndex);
		return repairDao.queryRepairinfoList(map);
	}

	/**
	 * 查询报修详情
	 */
	@Override
	public RepairApply queryRepairinfoByid(String maintenanceId) {
		return repairDao.queryRepairinfoByid(maintenanceId);
	}

	/**
	 * 查询维修申请信息
	 */
	@Override
	public Maintainer queryMaintainerApplyInfoByid(String userId) {
		return repairDao.queryMaintainerApplyInfoByid(userId);
	}

	/**
	 * 查询维修列表
	 */
	@Override
	public List<RepairApply> queryMaintainerRepairListByid(String userId) {
		return repairDao.queryMaintainerRepairListByid(userId);
	}

	/**
	 * 查询报修信息列表
	 */
	@Override
	public List<RepairApply> queryAllOrdersByround(String city,int beginIndex,int endIndex) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("city", city);
		map.put("beginIndex", beginIndex);
		map.put("endIndex", endIndex);
		return repairDao.queryAllOrdersByround(map);
	}

	/**
	 * 查询是否已经申请为师傅
	 */
	@Override
	public int queryUserIsHadApply(String userId) {
		return repairDao.queryUserIsHadApply(userId);
	}

	/**
	 * 删除报修信息
	 */
	@Override
	public void deleteRepairInfoByid(String maintenanceId) {
		repairDao.deleteRepairInfoByid(maintenanceId);
	}

	/**
	 * 查询报修单状态
	 */
	@Override
	public String queryRepairStatus(String maintenanceId) {
		return repairDao.queryRepairStatus(maintenanceId);
	}

	/**
	 * 修改报修单状态为已被接
	 */
	@Override
	public void updateMaintenanceStatus(String maintenanceId) {
		repairDao.updateMaintenanceStatus(maintenanceId);
	}

	/**
	 * 添加订单信息
	 */
	@Override
	public void addOrderInfo(String maintenanceId, String customerid,
			String repairmanid) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("maintenanceId", maintenanceId);
		map.put("customerid", customerid);
		map.put("repairmanid", repairmanid);
		repairDao.addOrderInfo(map);
	}

	/**
	 * 修改船舶修理状态
	 */
	@Override
	public void updateRepairStatus(String maintenanceId, String status) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("maintenanceId", maintenanceId);
		map.put("status", status);
		repairDao.updateRepairStatus(map);
	}

	/**
	 * 添加报修信息
	 */
	@Override
	public void addneedRepairinfo(RepairApply repairApply) {
		repairDao.addneedRepairinfo(repairApply);
	}

	/**
	 * 查询订单
	 */
	@Override
	public int queryOrderCountByid(String maintenanceId) {
		return repairDao.queryOrderCountByid(maintenanceId);
	}

	/**
	 * 查询未被接单信息
	 */
	@Override
	public RepairApply queryLessRepairinfoByid(String maintenanceId) {
		return repairDao.queryLessRepairinfoByid(maintenanceId);
	}

	/**
	 * 维修师傅申请打回状态修改信息
	 */
	@Override
	public void updateMaintainerInfo(Maintainer maintainer) {
		repairDao.updateMaintainerInfo(maintainer);
	}

	/**
	 * 维修师傅申请通过状态修改信息
	 */
	@Override
	public void updateRepairInfoByStatu(Maintainer maintainer) {
		repairDao.updateRepairInfoByStatu(maintainer);
	}
	
}
