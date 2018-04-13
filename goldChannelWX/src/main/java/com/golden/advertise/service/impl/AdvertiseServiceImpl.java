package com.golden.advertise.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.advertise.dao.AdvertiseDao;
import com.golden.advertise.po.InviteInfo;
import com.golden.advertise.po.Resume;
import com.golden.advertise.service.AdvertiseService;
@Service
public class AdvertiseServiceImpl implements AdvertiseService{

	@Autowired
	private AdvertiseDao advertiseDao;

	/**
	 * 查询用户是否创建建立
	 */
	@Override
	public int queryIsaddResumeinfo(String userId) {
		return advertiseDao.queryIsaddResumeinfo(userId);
	}

	/**
	 * 创建简历
	 */
	@Override
	public void addResumeInfo(Resume resume) {
		advertiseDao.addResumeInfo(resume);
	}

	/**
	 * 简历信息
	 */
	@Override
	public Resume queryResumeinfoByid(String inviteid) {
		return advertiseDao.queryResumeinfoByid(inviteid);
	}

	/**
	 * 查询聘请信息列表
	 */
	@Override
	public List<InviteInfo> queryInviteListByid(String userId,String status) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userId);
		map.put("status", status);
		return advertiseDao.queryInviteListByid(map);
	}

	/**
	 * 同意或拒绝聘请
	 */
	@Override
	public void updateInviteStatuByid(String inviteId, String status,String userId) {
		String message="";
		String workstatus="";
		String title="邀请动态";
		String beInveterName=advertiseDao.queryBeInveterNameByuid(userId);//被邀请人姓名
		String thisInveter=advertiseDao.queryThisInveterId(inviteId);//选中记录的邀请人id
		if(status.equals("2"))
		{//如果同意
			workstatus="2";
			List<String> inveterIds=advertiseDao.queryInveterIds(userId);//所有邀请者id
			for(int i=0;i<inveterIds.size();i++)
			{
				String inveterId=inveterIds.get(i);
				if(inveterId.equals(thisInveter))
				{//如果是选中记录邀请者
					status="2";
					message=beInveterName+"已成功加入您的船队";
					Map<String,String> map = new HashMap<String,String>();
					map.put("status", status);
					map.put("userId", userId);
					map.put("workstatus", workstatus);
					map.put("inveterId", inveterId);
					map.put("title", title);
					map.put("message", message);
					//修改邀请状态
					advertiseDao.updateInviteStatuByid(map);
					//更新简历状态
					advertiseDao.updateRemuseStatuByid(map);
					//发送消息
					advertiseDao.addSendMessage(map);
				}else
				{//其他邀请者 拒绝
					status="3";
					message=beInveterName+"拒绝了您的邀请";
					Map<String,String> map = new HashMap<String,String>();
					map.put("status", status);
					map.put("userId", userId);
					map.put("inveterId", inveterId);
					map.put("title", title);
					map.put("message", message);
					//拒绝其他所有邀请信息
					advertiseDao.updateInviteStatuByid(map);
					//发送拒绝消息
					advertiseDao.addSendMessage(map);
				}
			}
		}else if(status.equals("3"))
		{//如果拒绝
			message=beInveterName+"拒绝了您的邀请";
			Map<String,String> map = new HashMap<String,String>();
			map.put("status", status);
			map.put("userId", userId);
			map.put("inveterId", thisInveter);
			map.put("title", title);
			map.put("message", message);
			//修改邀请状态
			advertiseDao.updateInviteStatuByid(map);
			//发送拒绝消息
			advertiseDao.addSendMessage(map);
		}
	}

	/**
	 * 删除简历信息
	 */
	@Override
	public void deleteResumeInfoByid(String userId) {
		advertiseDao.deleteResumeInfoByid(userId);
	}

	/**
	 * 查询所有简历信息列表
	 */
	@Override
	public List<Resume> queryAllResume(String currentCity,
			String workExperience, String needDuty, String salary,int beginIndex,int endIndex) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("currentCity", currentCity);
		map.put("workExperience", workExperience);
		map.put("needDuty", needDuty);
		map.put("salary", salary);
		map.put("beginIndex", beginIndex);
		map.put("endIndex", endIndex);
		return advertiseDao.queryAllResume(map);
	}

	/**
	 * 查询简历id
	 */
	@Override
	public String queryInviteidByuid(String userId) {
		return advertiseDao.queryInviteidByuid(userId);
	}

	/**
	 * 查询邀请状态
	 */
	@Override
	public String queryIsinviteByuid(String userid, String inviteId) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userid);
		map.put("inviteId", inviteId);
		return advertiseDao.queryIsinviteByuid(map);
	}

	/**
	 * 添加邀请记录
	 */
	@Override
	public void addInviteInfo(String myid, String otid) {
		String title="邀请动态";
		String inviteName=advertiseDao.queryInviterName(myid);//邀请者姓名
		String message=inviteName+"邀请您加入他的船队";
		Map<String,String> map = new HashMap<String,String>();
		map.put("myid", myid);
		map.put("otid", otid);
		map.put("inveterId", otid);//发送消息与添加邀请参数字段不一致
		map.put("title", title);
		map.put("message", message);
		advertiseDao.addInviteInfo(map);
		advertiseDao.addSendMessage(map);
	}

	/**
	 * 我的船员
	 */
	@Override
	public List<Resume> queryMyshipperList(String userId) {
		return advertiseDao.queryMyshipperList(userId);
	}

	/**
	 * 查询是否已经加入船队
	 */
	@Override
	public int queryIsagreeInvite(String userId) {
		return advertiseDao.queryIsagreeInvite(userId);
	}

	/**
	 * 修改个人简历信息
	 */
	@Override
	public void updateRemuseInfoByid(Resume resume) {
		advertiseDao.updateRemuseInfoByid(resume);
	}

	/**
	 * 查询简历审核状态
	 */
	@Override
	public String queryResumeStatus(String cvId) {
		return advertiseDao.queryResumeStatus(cvId);
	}

	/**
	 * 查询是否已经添加简历信息
	 */
	@Override
	public int queryApplyCount(String userId) {
		return advertiseDao.queryApplyCount(userId);
	}

	/**
	 * 查询是否已经接受邀请
	 */
	@Override
	public int queryAgreeCount(String userId) {
		return  advertiseDao.queryAgreeCount(userId);
	}

	/**
	 * 邀请记录状态
	 */
	@Override
	public String queryInviteStatus(String inviteId) {
		return advertiseDao.queryInviteStatus(inviteId);
	}

	/**
	 * 删除邀请记录
	 */
	@Override
	public void deleteInviteInfo(String inviteId,String hadstatus) {
		Map<String,String> map = new HashMap<String,String>();
 		map.put("inviteId", inviteId);
 		map.put("status", hadstatus);
		advertiseDao.deleteInviteInfo(map);
	}

	/**
	 * 选中记录的被邀请用户id
	 */
	@Override
	public String queryBeinviterId(String inviteId) {
		return advertiseDao.queryBeinviterId(inviteId);
	}

	@Override
	public void updateRemuseStatuByid(Map<String, String> map) {
		advertiseDao.updateRemuseStatuByid(map);
	}

	/**
	 * 发送消息通知
	 */
	@Override
	public void addSendMessage(Map<String, String> map) {
		advertiseDao.addSendMessage(map);
	}

	/**
	 * 取消船员邀请及移出已邀请船员
	 */
	@Override
	public String deleteInveteInfoByid(String inviteId,String status) {
		String mess="";
		String hadstatus="";//邀请或同意 取消邀请和移出船员专用状态
		Map<String, String> map = new HashMap<String, String>();
     	if(status.equals("1"))
     	{//取消
     		String inviteStatus=advertiseDao.queryInviteStatus(inviteId);//邀请记录状态
     		if(inviteStatus.equals("2"))
            {//已同意
            	mess="对方已是您的船员";
            }else
            {
            	mess="取消成功";
            	hadstatus="1";//取消
            	map.put("inviteId", inviteId);
         		map.put("status", hadstatus);
            	advertiseDao.deleteInviteInfo(map);//删除邀请
            }
     	}else
     	{//移出
     		mess="移出成功";
     		hadstatus="2";//移出
     		map.put("inviteId", inviteId);
     		map.put("status", hadstatus);
     		String userid=advertiseDao.queryBeinviterId(inviteId);//选中记录的被邀请用户id
     		String inviterName=advertiseDao.queryInviterNameByInvid(inviteId);//邀请人姓名
     		advertiseDao.deleteInviteInfo(map);//移出船员
     		String title="求职招聘信息";
     		String message=inviterName+"已解除与您的合作";
     		String workstatus="1";
     		Map<String,String> map2 = new HashMap<String,String>();
     		map2.put("userId", userid);
     		map2.put("inveterId", userid);//发送消息与修改简历参数字段不一致
     		map2.put("workstatus", workstatus);
     		map2.put("title", title);
     		map2.put("message", message);
     		//修改船员简历状态
     		advertiseDao.updateRemuseStatuByid(map2);//改为空闲状态
     		advertiseDao.addSendMessage(map2);//发送消息通知
     	}
         return mess;
	}

	/**
	 * 查询是否已经邀请该用户
	 */
	@Override
	public int queryInviteCount(String myid, String otid) {
		Map<String,String> map = new HashMap<String,String>();
 		map.put("inviteUser", myid);
 		map.put("beinvitedUser", otid);
		return advertiseDao.queryInviteCount(map);
	}

}
