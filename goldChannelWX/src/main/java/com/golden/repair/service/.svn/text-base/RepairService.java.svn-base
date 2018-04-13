package com.golden.repair.service;

import java.util.List;

import com.golden.login.po.UserBean;
import com.golden.repair.po.Maintainer;
import com.golden.repair.po.RepairApply;

public interface RepairService {

	/**
	 * 查询用户简单信息
	 * @param userId
	 * @return
	 */
	UserBean querySimpUserinfoByid(String userId);

	/**
	 * 添加维修师傅信息
	 * @param maintainer
	 */
	void addMaintainerInfo(Maintainer maintainer);

	/**
	 * 我的报修列表
	 * @param userId
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	List<RepairApply> queryRepairinfoList(String userId,int beginIndex,int endIndex);

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
	 * @param city
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	List<RepairApply> queryAllOrdersByround(String city,int beginIndex,int endIndex);

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
	 * @param maintenanceId
	 * @param customerid
	 * @param repairmanid
	 */
	void addOrderInfo(String maintenanceId, String customerid,
			String repairmanid);

	/**
	 * 修改船舶修理状态
	 * @param maintenanceId
	 * @param status
	 */
	void updateRepairStatus(String maintenanceId, String status);

	/**
	 * 添加报修信息
	 * @param repairApply
	 */
	void addneedRepairinfo(RepairApply repairApply);

	/**
	 * 查询订单
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
