package com.golden.advertise.dao;

import java.util.List;
import java.util.Map;

import com.golden.advertise.po.InviteInfo;
import com.golden.advertise.po.Resume;

public interface AdvertiseDao {

	/**
	 * 查询用户是否创建建立
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
	List<InviteInfo> queryInviteListByid(Map<String, String> map);

	/**
	 * 同意或拒绝聘请
	 * @param map
	 */
	void updateInviteStatuByid(Map<String, String> map);

	/**
	 * 删除简历信息
	 * @param userId
	 */
	void deleteResumeInfoByid(String userId);

	/**
	 * 查询所有简历信息列表
	 * @param map
	 * @return
	 */
	List<Resume> queryAllResume(Map<String, Object> map);

	/**
	 * 修改个人简历状态
	 * @param userId
	 */
	void updateRemuseStatuByid(Map<String, String> map);

	/**
	 * 查询简历id
	 * @param userId
	 * @return
	 */
	String queryInviteidByuid(String userId);

	/**
	 * 查询邀请状态
	 * @param map
	 * @return
	 */
	String queryIsinviteByuid(Map<String, String> map);

	/**
	 * 添加邀请记录
	 * @param map
	 */
	void addInviteInfo(Map<String, String> map);

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
	 * @param userId
	 * @return
	 */
	int queryApplyCount(String userId);

	/**
	 * 查询邀请信息是否存在
	 * @param inviteId
	 * @return
	 */
	int queryIsExistInfoByid(String inviteId);

	/**
	 * 查询简要信息 被邀请人姓名 邀请人id
	 * @param inviteId
	 * @return
	 */
	InviteInfo querySimpInfoByid(String inviteId);

	/**
	 * 删除拒绝的信息
	 * @param map
	 */
	void refuseOtherInviteInfo(Map<String, String> map);

	/**
	 * 发送消息通知
	 * @param map
	 */
	void addSendMessage(Map<String, String> map);

	/**
	 * 被邀请者姓名
	 * @param userId
	 * @return
	 */
	String queryBeInveterNameByuid(String userId);

	/**
	 * 选中记录的邀请人id
	 * @param inviteId
	 * @return
	 */
	String queryThisInveterId(String inviteId);

	/**
	 * 所有邀请者id
	 * @param userId
	 * @return
	 */
	List<String> queryInveterIds(String userId);

	/**
	 * 查询是否已经接受邀请
	 * @param userId
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
	void deleteInviteInfo(Map<String, String> map);

	/**
	 * 选中记录的被邀请用户id
	 * @param inviteId
	 * @return
	 */
	String queryBeinviterId(String inviteId);

	/**
	 * 查询是否已经邀请该用户
	 * @param map
	 * @return
	 */
	int queryInviteCount(Map<String, String> map);

	/**
	 * 邀请者姓名
	 * @param myid
	 * @return
	 */
	String queryInviterName(String myid);

	/**
	 * 通过邀请记录查询邀请人姓名
	 * @param inviteId
	 * @return
	 */
	String queryInviterNameByInvid(String inviteId);

}
