package com.golden.advertise.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.golden.advertise.dao.AdvertiseDao;
import com.golden.advertise.po.InviteInfo;
import com.golden.advertise.po.Resume;
import com.golden.common.BaseDao;
@Component
public class AdvertiseDaoImpl extends BaseDao implements AdvertiseDao{

	@Override
	public int queryIsaddResumeinfo(String userId) {
		return (Integer)getSqlMapClientTemplate().queryForObject("advertise.queryIsaddResumeinfo",userId);
	}

	/**
	 * 创建简历
	 */
	@Override
	public void addResumeInfo(Resume resume) {
		getSqlMapClientTemplate().insert("advertise.addResumeInfo",resume);
	}

	/**
	 * 简历信息
	 */
	@Override
	public Resume queryResumeinfoByid(String inviteid) {
		return (Resume) getSqlMapClientTemplate().queryForObject("advertise.queryResumeinfoByid",inviteid);
	}

	/**
	 * 查询聘请信息列表
	 */
	@Override
	public List<InviteInfo> queryInviteListByid(Map<String, String> map) {
		return getSqlMapClientTemplate().queryForList("advertise.queryInviteListByid",map);
	}

	/**
	 * 同意或拒绝聘请
	 */
	@Override
	public void updateInviteStatuByid(Map<String, String> map) {
		getSqlMapClientTemplate().update("advertise.updateInviteStatuByid",map);
	}

	/**
	 * 删除简历信息
	 */
	@Override
	public void deleteResumeInfoByid(String userId) {
		getSqlMapClientTemplate().delete("advertise.deleteResumeInfoByid",userId);
	}

	/**
	 * 查询所有简历信息列表
	 */
	@Override
	public List<Resume> queryAllResume(Map<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("advertise.queryAllResume",map);
	}

	/**
	 * 修改个人简历状态
	 */
	@Override
	public void updateRemuseStatuByid(Map<String, String> map) {
		getSqlMapClientTemplate().update("advertise.updateRemuseStatuByid",map);
	}

	/**
	 * 查询简历id
	 */
	@Override
	public String queryInviteidByuid(String userId) {
		return (String) getSqlMapClientTemplate().queryForObject("advertise.queryInviteidByuid",userId);
	}

	/**
	 * 查询邀请状态
	 */
	@Override
	public String queryIsinviteByuid(Map<String, String> map) {
		return (String) getSqlMapClientTemplate().queryForObject("advertise.queryIsinviteByuid", map);
	}

	/**
	 * 添加邀请记录
	 */
	@Override
	public void addInviteInfo(Map<String, String> map) {
		getSqlMapClientTemplate().insert("advertise.addInviteInfo",map);
	}

	/**
	 * 我的船员
	 */
	@Override
	public List<Resume> queryMyshipperList(String userId) {
		return getSqlMapClientTemplate().queryForList("advertise.queryMyshipperList",userId);
	}

	/**
	 * 查询是否已经加入船队
	 */
	@Override
	public int queryIsagreeInvite(String userId) {
		return (Integer)getSqlMapClientTemplate().queryForObject("advertise.queryIsagreeInvite",userId);
	}

	/**
	 * 修改个人简历信息
	 */
	@Override
	public void updateRemuseInfoByid(Resume resume) {
		getSqlMapClientTemplate().update("advertise.updateRemuseInfoByid",resume);
	}

	/**
	 * 查询简历审核状态
	 */
	@Override
	public String queryResumeStatus(String cvId) {
		return (String) getSqlMapClientTemplate().queryForObject("advertise.queryResumeStatus",cvId);
	}

	/**
	 * 查询是否已经添加简历信息
	 */
	@Override
	public int queryApplyCount(String userId) {
		return (Integer)getSqlMapClientTemplate().queryForObject("advertise.queryApplyCount",userId);
	}

	/**
	 * 查询邀请信息是否存在
	 */
	@Override
	public int queryIsExistInfoByid(String inviteId) {
		return (Integer)getSqlMapClientTemplate().queryForObject("advertise.queryIsExistInfoByid",inviteId);
	}

	/**
	 * 查询简要信息 被邀请人姓名 邀请人id
	 */
	@Override
	public InviteInfo querySimpInfoByid(String inviteId) {
		return (InviteInfo) getSqlMapClientTemplate().queryForObject("advertise.querySimpInfoByid",inviteId);
	}

	/**
	 * 删除拒绝的信息
	 */
	@Override
	public void refuseOtherInviteInfo(Map<String, String> map) {
		getSqlMapClientTemplate().update("advertise.deleteOtherInviteInfo",map);
	}

	/**
	 * 发送消息通知
	 */
	@Override
	public void addSendMessage(Map<String, String> map) {
		getSqlMapClientTemplate().insert("advertise.addSendMessage",map);
	}

	/**
	 * 被邀请者姓名
	 */
	@Override
	public String queryBeInveterNameByuid(String userId) {
		return (String) getSqlMapClientTemplate().queryForObject("advertise.queryBeInveterNameByuid",userId);
	}

	/**
	 * 选中记录的邀请人id
	 */
	@Override
	public String queryThisInveterId(String inviteId) {
		return (String) getSqlMapClientTemplate().queryForObject("advertise.queryThisInveterId",inviteId);
	}

	/**
	 * 所有邀请者id
	 */
	@Override
	public List<String> queryInveterIds(String userId) {
		return getSqlMapClientTemplate().queryForList("advertise.queryInveterIds",userId);
	}

	/**
	 * 查询是否已经接受邀请
	 */
	@Override
	public int queryAgreeCount(String userId) {
		return (Integer)getSqlMapClientTemplate().queryForObject("advertise.queryAgreeCount",userId);
	}

	/**
	 * 邀请记录状态
	 */
	@Override
	public String queryInviteStatus(String inviteId) {
		return (String) getSqlMapClientTemplate().queryForObject("advertise.queryInviteStatus",inviteId);
	}

	/**
	 * 删除邀请记录
	 */
	@Override
	public void deleteInviteInfo(Map<String, String> map) {
		getSqlMapClientTemplate().delete("advertise.deleteInviteInfo",map);
	}

	/**
	 * 选中记录的被邀请用户id
	 */
	@Override
	public String queryBeinviterId(String inviteId) {
		return (String)getSqlMapClientTemplate().queryForObject("advertise.queryBeinviterId",inviteId);
	}

	/**
	 * 查询是否已经邀请该用户
	 */
	@Override
	public int queryInviteCount(Map<String, String> map) {
		return (Integer)getSqlMapClientTemplate().queryForObject("advertise.queryInviteCount",map);
	}

	/**
	 * 邀请者姓名
	 */
	@Override
	public String queryInviterName(String myid) {
		return (String) getSqlMapClientTemplate().queryForObject("advertise.queryInviterName",myid);
	}

	/**
	 * 通过邀请记录查询邀请人姓名
	 */
	@Override
	public String queryInviterNameByInvid(String inviteId) {
		return (String) getSqlMapClientTemplate().queryForObject("advertise.queryInviterNameByInvid",inviteId);
	}

}
