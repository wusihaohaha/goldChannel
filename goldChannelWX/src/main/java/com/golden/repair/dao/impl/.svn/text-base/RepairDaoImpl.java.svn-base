package com.golden.repair.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.golden.common.BaseDao;
import com.golden.login.po.UserBean;
import com.golden.repair.dao.RepairDao;
import com.golden.repair.po.Maintainer;
import com.golden.repair.po.RepairApply;
@Component
public class RepairDaoImpl extends BaseDao implements RepairDao{

	/**
	 * 查询用户简单信息
	 */
	@Override
	public UserBean querySimpUserinfoByid(String userId) {
		return (UserBean) getSqlMapClientTemplate().queryForObject("repair.querySimpUserinfoByid",userId);
	}

	/**
	 * 添加维修师傅信息
	 */
	@Override
	public void addMaintainerInfo(Map<String, String> map) {
		getSqlMapClientTemplate().insert("repair.addMaintainerInfo",map);
	}

	/**
	 * 我的报修列表
	 */
	@Override
	public List<RepairApply> queryRepairinfoList(Map<String,Object> map) {
		return getSqlMapClientTemplate().queryForList("repair.queryRepairinfoList",map);
	}

	/**
	 * 查询报修详情
	 */
	@Override
	public RepairApply queryRepairinfoByid(String maintenanceId) {
		return (RepairApply) getSqlMapClientTemplate().queryForObject("repair.queryRepairinfoByid",maintenanceId);
	}

	/**
	 * 查询维修申请信息
	 */
	@Override
	public Maintainer queryMaintainerApplyInfoByid(String userId) {
		return (Maintainer) getSqlMapClientTemplate().queryForObject("repair.queryMaintainerApplyInfoByid",userId);
	}

	/**
	 * 查询维修列表
	 */
	@Override
	public List<RepairApply> queryMaintainerRepairListByid(String userId) {
		return getSqlMapClientTemplate().queryForList("repair.queryMaintainerRepairListByid",userId);
	}

	/**
	 * 查询报修信息列表
	 */
	@Override
	public List<RepairApply> queryAllOrdersByround(Map<String,Object> map) {
		return getSqlMapClientTemplate().queryForList("repair.queryAllOrdersByround",map);
	}

	/**
	 * 查询是否已经申请为师傅
	 */
	@Override
	public int queryUserIsHadApply(String userId) {
		return (Integer)getSqlMapClientTemplate().queryForObject("repair.queryUserIsHadApply",userId);
	}

	//删除报修信息
	@Override
	public void deleteRepairInfoByid(String maintenanceId) {
		getSqlMapClientTemplate().delete("repair.deleteRepairInfoByid",maintenanceId);
	}

	/**
	 * 查询报修单状态
	 */
	@Override
	public String queryRepairStatus(String maintenanceId) {
		return (String) getSqlMapClientTemplate().queryForObject("repair.queryRepairStatus",maintenanceId);
	}

	/**
	 * 修改报修单状态为已被接
	 */
	@Override
	public void updateMaintenanceStatus(String maintenanceId) {
		getSqlMapClientTemplate().update("repair.updateMaintenanceStatus",maintenanceId);
	}

	/**
	 * 添加订单信息
	 */
	@Override
	public void addOrderInfo(Map<String, String> map) {
		getSqlMapClientTemplate().insert("repair.addOrderInfo",map);
	}

	/**
	 * 修改船舶修理状态
	 */
	@Override
	public void updateRepairStatus(Map<String, String> map) {
		getSqlMapClientTemplate().update("repair.updateRepairStatus",map);
	}

	/**
	 * 添加报修信息
	 */
	@Override
	public void addneedRepairinfo(RepairApply repairApply) {
		getSqlMapClientTemplate().insert("repair.addneedRepairinfo",repairApply);
	}

	/**
	 * 查询订单
	 */
	@Override
	public int queryOrderCountByid(String maintenanceId) {
		return (Integer)getSqlMapClientTemplate().queryForObject("repair.queryOrderCountByid",maintenanceId);
	}

	/**
	 * 查询未被接单信息
	 */
	@Override
	public RepairApply queryLessRepairinfoByid(String maintenanceId) {
		return (RepairApply) getSqlMapClientTemplate().queryForObject("repair.queryLessRepairinfoByid",maintenanceId);
	}

	/**
	 * 维修师傅申请打回状态修改信息
	 */
	@Override
	public void updateMaintainerInfo(Maintainer maintainer) {
		getSqlMapClientTemplate().update("repair.updateMaintainerInfo",maintainer);
	}

	/**
	 * 维修师傅申请通过状态修改信息
	 */
	@Override
	public void updateRepairInfoByStatu(Maintainer maintainer) {
		getSqlMapClientTemplate().update("repair.updateRepairInfoByStatu",maintainer);
	}

	
}
