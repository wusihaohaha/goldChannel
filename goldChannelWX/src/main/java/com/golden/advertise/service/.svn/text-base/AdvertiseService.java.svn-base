package com.golden.advertise.service;

import java.util.List;
import java.util.Map;

import com.golden.advertise.po.InviteInfo;
import com.golden.advertise.po.Resume;

public interface AdvertiseService {

	/**
	 * 查询用户是否创建简历
	 * @param userId
	 * @return
	 */
	int queryIsaddResumeinfo(String userId);

	/**
	 * 创建简历
	 * @param resume
	 */
	void addResumeInfo(Resume resume);

	/**
	 * 简历信息
	 * @param userId
	 * @return
	 */
	Resume queryResumeinfoByid(String inviteid);

	/**
	 * 查询聘请信息列表
	 * @param userId
	 * @return
	 */
	List<InviteInfo> queryInviteListByid(String userId,String status);

	/**
	 * 同意或拒绝聘请
	 * @param inviteId
	 * @param status
	 */
	void updateInviteStatuByid(String inviteId, String status,String userId);

	/**
	 * 删除简历信息
	 * @param userId
	 */
	void deleteResumeInfoByid(String userId);

	/**
	 * 查询所有简历信息列表
	 * @param currentCity
	 * @param workExperience
	 * @param needDuty
	 * @param salary
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	List<Resume> queryAllResume(String currentCity, String workExperience,
			String needDuty, String salary,int beginIndex,int endIndex);

	/**
	 * 查询简历id
	 * @param userId
	 * @return
	 */
	String queryInviteidByuid(String userId);

	/**
	 * 查询邀请状态
	 * @param userid
	 * @param inviteId
	 * @return
	 */
	String queryIsinviteByuid(String userid, String inviteId);

	/**
	 * 添加邀请记录
	 * @param myid
	 * @param otid
	 */
	void addInviteInfo(String myid, String otid);

	/**
	 * 我的船员
	 * @param userId
	 * @return
	 */
	List<Resume> queryMyshipperList(String userId);

	/**
	 * 查询是否已经加入船队
	 * @param userId
	 * @return
	 */
	int queryIsagreeInvite(String userId);

	/**
	 * 修改个人简历信息
	 * @param resume
	 */
	void updateRemuseInfoByid(Resume resume);

	/**
	 * 查询简历审核状态
	 * @param cvId
	 * @return
	 */
	String queryResumeStatus(String cvId);

	/**
	 * 查询是否已经添加简历信息
	 * @param createUser
	 * @return
	 */
	int queryApplyCount(String userId);

	/**
	 * 查询是否已经接受邀请
	 * @return
	 */
	int queryAgreeCount(String userId);

	/**
	 * 邀请记录状态
	 * @param inviteId
	 * @return
	 */
	String queryInviteStatus(String inviteId);

	/**
	 * 删除邀请记录
	 * @param inviteId
	 */
	void deleteInviteInfo(String inviteId,String hadstatus);

	/**
	 * 选中记录的被邀请用户id
	 * @param inviteId
	 * @return
	 */
	String queryBeinviterId(String inviteId);

	/**
	 * 修改用户简历状态
	 * @param map
	 */
	void updateRemuseStatuByid(Map<String, String> map);

	/**
	 * 发送消息通知
	 * @param map
	 */
	void addSendMessage(Map<String, String> map);

	/**
	 * 取消船员邀请及移出已邀请船员
	 * @param inviteId
	 * @param status
	 */
	String deleteInveteInfoByid(String inviteId,String status);

	/**
	 * 查询是否已经邀请该用户
	 * @param myid
	 * @param otid
	 * @return
	 */
	int queryInviteCount(String myid, String otid);

}
