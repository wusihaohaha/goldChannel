package com.golden.repair.po;

import org.springframework.stereotype.Component;
/**
 * 报修实体类
 * @author xie
 */
@Component
public class RepairApply {

	//报修id
	private String maintenanceId;
	//报修用户..id
	private String applyUser;
	//报修用户手机号
	private String applyUsertel;
	//报修船名
	private String shipName;
	//部位
	private String repairParts;
	//位置 省
	private String province;
	//市
	private String city;
	//港
	private String port;
	//维修描述
	private String repairContent;
	//报修状态 1:待接单  2:已接单
	private String status;
	//订单完成状态 3订单完成
	private String orderStatu;
	//维修师傅姓名
	private String maintainerName;
	//维修师傅电话
	private String maintainerTel;
	//报修时间
	private String applyTime;
	//订单号
	private String orderNum;
	//订单创建日期
	private String orderTime;
	
	public String getMaintenanceId() {
		return maintenanceId;
	}
	public void setMaintenanceId(String maintenanceId) {
		this.maintenanceId = maintenanceId;
	}
	public String getApplyUser() {
		return applyUser;
	}
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}
	public String getApplyUsertel() {
		return applyUsertel;
	}
	public void setApplyUsertel(String applyUsertel) {
		this.applyUsertel = applyUsertel;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public String getRepairParts() {
		return repairParts;
	}
	public void setRepairParts(String repairParts) {
		this.repairParts = repairParts;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getRepairContent() {
		return repairContent;
	}
	public void setRepairContent(String repairContent) {
		this.repairContent = repairContent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderStatu() {
		return orderStatu;
	}
	public void setOrderStatu(String orderStatu) {
		this.orderStatu = orderStatu;
	}
	public String getMaintainerName() {
		return maintainerName;
	}
	public void setMaintainerName(String maintainerName) {
		this.maintainerName = maintainerName;
	}
	public String getMaintainerTel() {
		return maintainerTel;
	}
	public void setMaintainerTel(String maintainerTel) {
		this.maintainerTel = maintainerTel;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
}
