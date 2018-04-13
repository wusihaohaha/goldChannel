package com.golden.search.po;

import org.springframework.stereotype.Component;
/**
 * app版本更新信息实体类
 * @author xie
 */
@Component
public class ApkVersionInfo {

	//版本记录id
	private String versionId;
	//版本code
	private String versionCode;
	//版本号
	private String versionName;
	//版本更新url
	private String versionUrl;
	
	public String getVersionId() {
		return versionId;
	}
	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}
	public String getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public String getVersionUrl() {
		return versionUrl;
	}
	public void setVersionUrl(String versionUrl) {
		this.versionUrl = versionUrl;
	}
	
}
