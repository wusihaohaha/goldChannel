package com.golden.repair.dao;

import java.util.List;
import java.util.Map;

import com.golden.login.po.UserBean;
import com.golden.repair.po.Maintainer;
import com.golden.repair.po.RepairApply;

public interface RepairDao {

	/**
	 * 查询用户简单信息
	 * @param userId
	 * @return
	 */
	UserBean querySimpUserinfoByid(String userId);

	/**
	 * 添加维修师傅信息
	 * @param map
	 */
	void addMaintainerInfo(Map<String, String> map);

	/**
	 * 我的报修列表
	 * @param userId
	 * @return
	 */
	List<RepairApply> queryRepairinfoList(Map<String,Object> map);

	/**
	 * 查询报修详情
	 * @param maintenanceId
	 * @return
	 */
	RepairApply queryRepairinfoByid(String maintenanceId);

	/**
	 * 查询维修申请信息
	 * @param userId
	 * @return
	 */
	Maintainer queryMaintainerApplyInfoByid(String userId);

	/**
	 * 查询维修列表
	 * @param userId
	 * @return
	 */
	List<RepairApply> queryMaintainerRepairListByid(String userId);

	/**
	 * 查询报修信息列表
	 * @param map
	 * @return
	 */
	List<RepairApply> queryAllOrdersByround(Map<String,Object> map);

	/**
	 * 查询是否已经申请为师傅
	 * @param userId
	 * @return
	 */
	int queryUserIsHadApply(String userId);

	/**
	 * 删除报修信息
	 * @param maintenanceId
	 */
	void deleteRepairInfoByid(String maintenanceId);

	/**
	 * 查询报修单状态
	 * @param maintenanceId
	 * @return
	 */
	String queryRepairStatus(String maintenanceId);

	/**
	 * 修改报修单状态为已被接
	 * @param maintenanceId
	 */
	void updateMaintenanceStatus(String maintenanceId);

	/**
	 * 添加订单信息
	 * @param map
	 */
	void addOrderInfo(Map<String, String> map);

	/**
	 * 修改船舶修理状态
	 * @param map
	 */
	void updateRepairStatus(Map<String, String> map);

	/**
	 * 添加报修信息
	 * @param repairApply
	 */
	void addneedRepairinfo(RepairApply repairApply);

	/**
	 * 查询订单
	 * @param maintenanceId
	 * @return
	 */
	int queryOrderCountByid(String maintenanceId);

	/**
	 * 查询未被接单信息
	 * @param maintenanceId
	 * @return
	 */
	RepairApply queryLessRepairinfoByid(String maintenanceId);

	/**
	 * 维修师傅申请打回状态修改信息
	 * @param maintainer
	 */
	void updateMaintainerInfo(Maintainer maintainer);

	/**
	 * 维修师傅申请通过状态修改信息
	 * @param maintainer
	 */
	void updateRepairInfoByStatu(Maintainer maintainer);

}
