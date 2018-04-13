/**
 * Project Name:goldChannel
 * File Name:GoodsController.java
 * Package Name:com.golden.goods.action
 * Date:2016年10月19日上午10:51:48
 * Copyright (c) 2016, 武汉麦尔盛科技有限公司 All Rights Reserved.
 *
*/

package com.golden.goods.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golden.common.Constants;
import com.golden.common.FileOperateUtil;
import com.golden.common.FileUploadCommon;
import com.golden.common.JsonDateValueProcessor;
import com.golden.common.StringUtil;
import com.golden.goods.po.GoodsBidInfo;
import com.golden.goods.po.GoodsInfo;
import com.golden.goods.service.GoodsService;
import com.golden.order.po.ShipOrderInfo;
import com.golden.pubParameter.service.PictureRootPathService;
import com.golden.ship.po.ApplyShipping;

/**
 * ClassName:GoodsController <br/>
 * 数据信息展示Controller层
 * 货物信息
 * Date:     2016年10月19日 上午10:51:48 <br/>
 * @author   zhoujq
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PictureRootPathService pictureRootPathService;
    
    /*** 每页显示的最大行数*/
    private int maxSize=10;

    /**
     * selectMyGoodsInfo:查询我的货物，默认时间倒序. <br/>
     * @author zhoujq
     * @param response
     * @param String userId 用户id
     * @param String pageNum 需查询页
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectMyGoodsInfo")
    public void selectMyGoodsInfo(HttpServletResponse response,String userId ,String pageNum ) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();

            String status=Constants.goodsStatus.info;//状态:1:信息
            List<GoodsInfo> myGoodsInfoList= goodsService.selectMyGoodsInfo(userId,status,
                    String.valueOf((Integer.parseInt(pageNum)-1)*maxSize+1),String.valueOf(Integer.parseInt(pageNum)*maxSize));
            
            juser.put("data", myGoodsInfoList);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("我的货物查询异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * selectGoodsDetailById:通过id查询我的货物详细信息. <br/>
     * @author zhoujq
     * @param response
     * @param goodsId 货物id
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectGoodsDetailById")
    public void selectGoodsDetailById(HttpServletResponse response, String goodsId) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            GoodsInfo goodsDetailInfo= goodsService.selectGoodsDetailById(goodsId);
            
            juser.put("data", goodsDetailInfo);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            
            logger.error("货物详细查询异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * createGoodsInfo:添加货物信息. <br/>
     * @author zhoujq
     * @param response
     * @param userId 用户id
     * @param goodsInfo 货物信息
     * @since JDK 1.7
     */

    @RequestMapping(value="/createGoodsInfo")
    public void createGoodsInfo(HttpServletResponse response, HttpServletRequest request ,String GOODSNAME,String GOODSWEIGHT,
            String DEPARTUREPROVINCE,String DEPARTUREWHARF,String ARRIVALPROVINCE,String ARRIVALWHARF,String FREIGHTPRICE,String LOADTIME,String LOADINGTIME,String DISCHARGETIME,
            String DELAYRPRICE,String CREATEUSER,String SOURCE,String REMARK,String XHRQ
            ) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
          //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            Map<String, String> map = new HashMap<String, String>();
            map.put("GOODSNAME", GOODSNAME);
            map.put("GOODSWEIGHT", GOODSWEIGHT);
            map.put("DEPARTUREPROVINCE", DEPARTUREPROVINCE);
            map.put("DEPARTUREWHARF", DEPARTUREWHARF);
            map.put("ARRIVALPROVINCE", ARRIVALPROVINCE);
            map.put("ARRIVALWHARF", ARRIVALWHARF);
            map.put("FREIGHTPRICE", FREIGHTPRICE);
            map.put("LOADTIME", LOADTIME);
            map.put("XHRQ", XHRQ);
            map.put("LOADINGTIME", LOADINGTIME);
            map.put("DISCHARGETIME", DISCHARGETIME);
            map.put("DELAYRPRICE", DELAYRPRICE);
            map.put("CREATEUSER", CREATEUSER);
            map.put("SOURCE", SOURCE);
            map.put("REMARK", REMARK);
            map.put("STATUS", "1");
            map.put("ID", StringUtil.getUUID());  
            //增加新的货物信息
            goodsService.createGoodsInfo(map);
            
            juser.put("suc", 'y');
            juser.put("msg", "添加成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("添加货物信息异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "添加失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * deleteGoodsInfo:删除货物信息. <br/>
     * @author zhoujq
     * @param response
     * @param session
     * @param goodsId 货物id
     * @param picturePath 货物图片路径
     * @since JDK 1.7
     */
    @RequestMapping(value="/deleteGoodsInfo")
    public void deleteGoodsInfo(HttpServletResponse response, HttpSession session, String goodsId, String picturePath) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
          //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            if(picturePath!=null&&!picturePath.isEmpty()){
                //获取系统文件保存路径
                String localUrl = pictureRootPathService.getPicRoot(session, FileUploadCommon.ROOTPATH_ID);
                //删除货物图片
                FileOperateUtil.deleteFile(localUrl+FileUploadCommon.BACK_SLASH+Constants.picturePath.goodsPic+picturePath.substring(picturePath.indexOf("/")));
            }
            //删除指定货物信息
            goodsService.deleteGoodsInfo(goodsId);
            
            juser.put("suc", 'y');
            juser.put("msg", "删除成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("货物删除异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "删除失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * updateGoodsInfo:更新货物信息. <br/>
     * @author zhoujq
     * @param response
     * @param session
     * @param goodsInfo 货物信息
     * @since JDK 1.7
     */
    @RequestMapping(value="/updateGoodsInfo")
    public void updateGoodsInfo(HttpServletResponse response,HttpServletRequest request , HttpSession session, GoodsInfo goodsInfo) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
          //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            //获取系统文件保存路径
            String localUrl = pictureRootPathService.getPicRoot(session, FileUploadCommon.ROOTPATH_ID);
            // 文件保存目录路径
            String fileSavePath = localUrl+FileUploadCommon.BACK_SLASH+Constants.picturePath.goodsPic;
            String controlName="1";//控件名称
            String postfix=".jpg";//图片后缀
            
            //判断是否有数据流（针对andriod端不传图片的场合）
            if("multipart/form-data".equals(request.getContentType().split(";")[0]))
            {
                //上传图片并获取图片路径list
                List<String> strReturnList=FileOperateUtil.uploadFile(request,fileSavePath,controlName,postfix);
                if(strReturnList.size()>0){
                    goodsInfo.setPicturePath(Constants.picturePath.Upload_GoodsFiles+strReturnList.get(0).toString());//货图片路径
                }
            }
            goodsInfo.setStatus(Constants.goodsStatus.info);//状态：1:信息
            
            //更新指定货物信息
            goodsService.updateGoodsInfo(goodsInfo);
            
            juser.put("suc", 'y');
            juser.put("msg", "修改成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("货物修改异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "修改失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * createBidInfo:提交标书(发标). <br/>
     * @author zhoujq
     * @param response
     * @param goodsInfo
     * @since JDK 1.7
     */
    @RequestMapping(value="/createBidInfo")
    public void createBidInfo(HttpServletResponse response, GoodsInfo bidInfo) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            bidInfo.setStatus(Constants.goodsStatus.audit);//状态：2:待审核
            
            //创建标书、备份货物
            goodsService.createBidInfo(bidInfo);
            
            juser.put("suc", 'y');
            juser.put("msg", "提交成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("提交标书异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "提交失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * selectMyBidInfo:查询我的竞标（发标/竞标），默认时间倒序. <br/>
     * @author zhoujq
     * @param response
     * @param String userId 用户id
     * @param String pageNum 需查询页
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectMyBidInfo")
    public void selectMyBidInfo(HttpServletResponse response,String userId,String pageNum) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();

            String goodsStatus=Constants.goodsStatus.audit+","+Constants.goodsStatus.biding+","
                    +Constants.goodsStatus.failBid;//发标 状态:2:待审核 3:竞标中 4:流标(无人竞标)
            String shipStatus=Constants.bidStatus.pay+","+Constants.bidStatus.biding+","+Constants.bidStatus.failBid;//竞标 状态: 待付保证金、竞标中 、竞标失败
            
            List<GoodsInfo> myBidInfoList= goodsService.selectMyBidInfo(userId,goodsStatus,shipStatus,
                    String.valueOf((Integer.parseInt(pageNum)-1)*maxSize+1),String.valueOf(Integer.parseInt(pageNum)*maxSize));
            
            juser.put("data", myBidInfoList);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("我的货物查询异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * selectBidInfoByCondition:通过条件查询货物(标). <br/>
     * @author zhoujq
     * @param response
     * @param userId 用户id
     * @param departurePlace 出发地
     * @param arrivalPlace 目的地
     * @param emptyTonnage 重量 0:全部 1:2000以下 2:2000-5000 3:5000-10000 4:10000-15000 5:15000-30000 6:30000以上
     * @param pageNum 需查询页
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectBidInfoByCondition")
    public void selectBidInfoByCondition(HttpServletResponse response,String departurePlace, String arrivalPlace, String emptyTonnage, String pageNum) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            String status=Constants.goodsStatus.biding;//状态  3:竞标中
            String emptyTonnageMin="";
            String emptyTonnageMax="";
            if(emptyTonnage==null||emptyTonnage.equals("")){
                emptyTonnage = "0";
            }
            if(pageNum==null||pageNum.equals("")){
                pageNum = "1";
            }
            switch (emptyTonnage) {
            case "1":
                emptyTonnageMax="2000";
                break;
            case "2":
                emptyTonnageMin="2000";
                emptyTonnageMax="5000";
                break;
            case "3":
                emptyTonnageMin="5000";
                emptyTonnageMax="10000";
                break;
            case "4":
                emptyTonnageMin="10000";
                emptyTonnageMax="15000";
                break;
            case "5":
                emptyTonnageMin="15000";
                emptyTonnageMax="30000";
                break;
            case "6":
                emptyTonnageMin="30000";
                break;
            default:
                break;
            }

            List<Map<String, Object>> bidInfoList= goodsService.selectGoodsInfoByCondition(departurePlace,arrivalPlace,emptyTonnageMin,emptyTonnageMax,
                                String.valueOf((Integer.parseInt(pageNum)-1)*maxSize+1),String.valueOf(Integer.parseInt(pageNum)*maxSize),status);
            juser.put("data", bidInfoList);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("我要找货信息查询异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * selectBidInfoById:获取标书详情. <br/>
     * @author zhoujq
     * @param response
     * @param userId 用户id
     * @param goodsId 货源id
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectBidInfoById")
    public void selectBidInfoById(HttpServletResponse response,String userId, String goodsId) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            GoodsInfo bidDetailInfo= goodsService.selectBidDetailById(userId,goodsId);
            
            juser.put("data", bidDetailInfo);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("查询标书详情异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
            
        }
    }
    
    /**
     * deleteBidById:撤标(撤除我发的标). <br/>
     * @author zhoujq
     * @param response
     * @param goodsId 货物id
     * @since JDK 1.7
     */
    @RequestMapping(value="/deleteBidById")
    public void deleteBidById(HttpServletResponse response, String goodsId) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();

            //判断是否已有人竞标，流标除外
            int number=goodsService.selectBiddingNumber(goodsId,Constants.goodsStatus.failBid);
            if(number==0){
                //修改货物状态：删除,流标货物改为流标不显示
                goodsService.deleteMyBidById(goodsId,Constants.goodsStatus.delete,Constants.goodsStatus.failBidNoShow,Constants.goodsStatus.failBid);
                juser.put("suc", 'y');
                juser.put("msg", "取消成功");
            }else{
                juser.put("suc", 'n');
                juser.put("msg", "已有人竞标，不可以撤标！");
            }
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("撤除我发的标异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "取消失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * createGoodsBidInfo:竞价. <br/>
     * @author zhoujq
     * @param response
     * @param goodsBidInfo 竞价信息
     * @since JDK 1.7
     */
    @RequestMapping(value="/createGoodsBidInfo")
    public void createGoodsBidInfo(HttpServletResponse response, GoodsBidInfo goodsBidInfo) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            //判断标是否存在或过期（开标时间小于当前）
            int count=goodsService.selectBidCount(goodsBidInfo.getGoodsId(),Constants.goodsStatus.biding);
            if(count==0){
                juser.put("suc", 'n');
                juser.put("msg", "标不存在，请刷新");
            }else{
                //提交标书 、修改船状态
                goodsService.createGoodsBidInfo(goodsBidInfo);//状态：线上的场合：竞标中 ;线下的场合：待付保证金
                juser.put("suc", 'y');
                juser.put("msg", "提交成功");
            }
            
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("参与竞价异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "提交失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * 船方取消竞标. <br/>
     * @author wsh
     * @param response
     * @param goodsBidId 竞标ID
     * @param shipId 船只ID
     * @since JDK 1.7
     */
    @RequestMapping(value="/cancelBid")
    public void cancelBid(HttpServletResponse response, String goodsBidId, String shipId) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            goodsService.cancelBid(goodsBidId,shipId);//删除竞价记录,修改船舶状态
            juser.put("suc", 'y');
            juser.put("msg", "取消成功");
         
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("取消竞标异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "取消失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }

    /**
     * selectShipApplyInfo:查询我的船运（申请/被申请），默认时间倒序. <br/>
     * @author zhoujq
     * @param response
     * @param String userId 用户id
     * @param String pageNum 需查询页
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectShipApplyInfo")
    public void selectShipApplyInfo(HttpServletResponse response,String userId,String pageNum) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            List<ApplyShipping> myShippingInfoList= goodsService.selectShipApplyInfo(userId,Constants.shipApplyStatus.apply,
                    String.valueOf((Integer.parseInt(pageNum)-1)*maxSize+1),String.valueOf(Integer.parseInt(pageNum)*maxSize));
            
            juser.put("data", myShippingInfoList);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("我的货物查询异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * selectShipApplyDetailInfo:查询我的船运（申请/被申请）详情. <br/>
     * @author zhoujq
     * @param response
     * @param String shipApplyId 船运申请id
     * @since JDK 1.7
     */
    @RequestMapping(value="/selectShipApplyDetailInfo")
    public void selectShipApplyDetailInfo(HttpServletResponse response,String shipApplyId) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            ShipOrderInfo shippingDetailInfo= goodsService.selectShipApplyDetailInfo(shipApplyId);
            
            juser.put("data", shippingDetailInfo);
            juser.put("suc", 'y');
            juser.put("msg", "查询成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("我的货物查询异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "查询失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    
    /**
     * deleteShipApply:(货方)取消船运申请. <br/>
     * @author zhoujq
     * @param response
     * @param shipApplyId 船运申请ID
     * @since JDK 1.7
     */
    @RequestMapping(value="/deleteShipApply")
    public void deleteShipApply(HttpServletResponse response, String shipApplyId) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            //船运申请是否存在
            int count=goodsService.selectShipApply(shipApplyId);
            if(count>0){
                //修改货物状态-删除、发送消息、删除船运申请
                goodsService.deleteShipApply(shipApplyId,Constants.MessageInfos.shipping_cancel_s,Constants.roleType.goods);
                juser.put("suc", 'y');
                juser.put("msg", "取消成功");
            }else{
                juser.put("suc", 'n');
                juser.put("msg", "船运申请不存在或船方已拒绝了您的申请，请刷新");
            }
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("船运申请取消异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "取消失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * agreeShipApply:(船方)同意船运申请. <br/>
     * @author zhoujq
     * @param response
     * @param shipApplyId 船运申请ID
     * @param shipId 船只ID
     * @since JDK 1.7
     */
    @RequestMapping(value="/agreeShipApply")
    public void agreeShipApply(HttpServletResponse response, String shipApplyId, String shipId) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            //船运申请是否存在
            int count=goodsService.selectShipApply(shipApplyId);
            if(count>0){
                //船状态
                int status=goodsService.selectShipStatus(shipId);
                //判断船是否空闲
                if(Constants.shipStatus.free.equals(String.valueOf(status))){
                  //同意申请（申请同意、删除其他申请、修改船只状态、发送消息）
                    goodsService.agreeShipApply(shipApplyId,Constants.shipApplyStatus.assign,shipId,Constants.shipApplyStatus.apply,
                            Constants.shipStatus.transport,Constants.MessageInfos.shipping_agree_s);
                    juser.put("suc", 'y');
                    juser.put("msg", "操作成功");
                }else{
                    juser.put("suc", 'n');
                    juser.put("msg", "船已竞标，不可同意船运");
                }
            }else{
                juser.put("suc", 'n');
                juser.put("msg", "船运申请不存在，请刷新");
            }
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("(船方)同意船运申请操作异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * refuseShipApply:(船方)拒绝船运申请. <br/>
     * @author zhoujq
     * @param response
     * @param shipApplyId 船运申请ID
     * @since JDK 1.7
     */
    @RequestMapping(value="/refuseShipApply")
    public void refuseShipApply(HttpServletResponse response, String shipApplyId) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            
            //船运申请是否存在
            int count=goodsService.selectShipApply(shipApplyId);
            if(count>0){
              //修改货物状态-删除、发送消息、删除船运申请
                goodsService.deleteShipApply(shipApplyId,Constants.MessageInfos.shipping_refuse_s,Constants.roleType.ship);
                juser.put("suc", 'y');
                juser.put("msg", "操作成功");
            }else{
                juser.put("suc", 'n');
                juser.put("msg", "船运申请不存在，请刷新");
            }
            
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("(船方)同意船运申请操作异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    

    @RequestMapping(value="/queryAll")
    public void queryAll(HttpServletResponse response, String pageNum) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
                List<Map<String, Object>> list = new ArrayList<>();

                if(pageNum.equals("")){
                    pageNum = "1";
                }
                list = goodsService.queryAll(String.valueOf((Integer.parseInt(pageNum)-1)*maxSize+1),String.valueOf(Integer.parseInt(pageNum)*maxSize));

              //修改货物状态-删除、发送消息、删除船运申请
                juser.put("data", list);
                juser.put("suc", 'y');
                juser.put("msg", "操作成功");
            
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("(船方)同意船运申请操作异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    @RequestMapping(value="/getGoodsName")
    public void getGoodsName(HttpServletResponse response) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

                
                list = goodsService.getGoodsName();
                List list1 = new ArrayList<>();
                for(int i=0;i<list.size();i++){
                    list1.add(list.get(i).get("NAME"));
                }

              //修改货物状态-删除、发送消息、删除船运申请
//                juser.put("data", array.toString());
                juser.put("data", list1);
                juser.put("suc", 'y');
                juser.put("msg", "操作成功");
            
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("(船方)同意船运申请操作异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    @RequestMapping(value="/getGoodsDetail")
    public void getGoodsDetail(HttpServletResponse response,String id) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            Map<String, Object> list =  new HashMap<String, Object>();             
            list = goodsService.getGoodsDetail(id);
            juser.put("data", list);
            juser.put("suc", 'y');
            juser.put("msg", "操作成功");
            
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("(船方)同意船运申请操作异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    @RequestMapping(value="/myGoods")
    public void myGoods(HttpServletResponse response,String userId, String pageNum) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
            //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            if(pageNum==null||pageNum.equals("")){
                pageNum = "1";
            }
            List<Map<String, Object>> list= goodsService.myGoods(userId,String.valueOf((Integer.parseInt(pageNum)-1)*maxSize+1),String.valueOf(Integer.parseInt(pageNum)*maxSize));
            juser.put("data", list);
            juser.put("suc", 'y');
            juser.put("msg", "操作成功");
            
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("(船方)同意船运申请操作异常:",e);
            juser.put("suc", 'n');
            juser.put("msg", "操作失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * createGoodsInfo:添加货物信息. <br/>
     * @author zhoujq
     * @param response
     * @param userId 用户id
     * @param goodsInfo 货物信息
     * @since JDK 1.7
     */

    @RequestMapping(value="/updateGoods")
    public void updateGoods(HttpServletResponse response, HttpServletRequest request ,String id,String GOODSNAME,String GOODSWEIGHT,
            String DEPARTUREPROVINCE,String DEPARTUREWHARF,String ARRIVALPROVINCE,String ARRIVALWHARF,String FREIGHTPRICE,String LOADTIME,String LOADINGTIME,String DISCHARGETIME,
            String DELAYRPRICE,String SOURCE,String REMARK,String XHRQ
            ) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
          //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            Map<String, String> map = new HashMap<String, String>();
            map.put("ID", id);
            map.put("GOODSNAME", GOODSNAME);
            map.put("GOODSWEIGHT", GOODSWEIGHT);
            map.put("DEPARTUREPROVINCE", DEPARTUREPROVINCE);
            map.put("DEPARTUREWHARF", DEPARTUREWHARF);
            map.put("ARRIVALPROVINCE", ARRIVALPROVINCE);
            map.put("ARRIVALWHARF", ARRIVALWHARF);
            map.put("FREIGHTPRICE", FREIGHTPRICE);
            map.put("LOADTIME", LOADTIME);
            map.put("XHRQ", XHRQ);
            map.put("LOADINGTIME", LOADINGTIME);
            map.put("DISCHARGETIME", DISCHARGETIME);
            map.put("DELAYRPRICE", DELAYRPRICE);
            map.put("SOURCE", SOURCE);
            map.put("REMARK", REMARK);
            map.put("STATUS", "1");
            //增加新的货物信息
            goodsService.updateGoods(map);
            
            juser.put("suc", 'y');
            juser.put("msg", "更新成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("更新成功:",e);
            juser.put("suc", 'n');
            juser.put("msg", "添加失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    @RequestMapping(value="/deleteGoods")
    public void deleteGoods(HttpServletResponse response, String id) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
          //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
          
            goodsService.deleteGoods(id);
            
            juser.put("suc", 'y');
            juser.put("msg", "删除成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("删除失败:",e);
            juser.put("suc", 'n');
            juser.put("msg", "删除失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    @RequestMapping(value="/getData")
    public void getData(HttpServletResponse response, String id) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
          //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
          
            Map<String, String> map = goodsService.getData();
            juser.put("data", map);
            juser.put("suc", 'y');
            juser.put("msg", "成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("失败:",e);
            juser.put("suc", 'n');
            juser.put("msg", "失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    

    @RequestMapping(value="/createData")
    public void createData(HttpServletResponse response, String one,String two,String three,String four) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
          //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
          
            goodsService.deleteData();
            Map<String, String> map = new HashMap<String, String>();

            map.put("id", StringUtil.getUUID());
            map.put("one", one);
            map.put("two", two);
            map.put("three", three);
            map.put("four", four);
            goodsService.createData(map);
            juser.put("suc", 'y');
            juser.put("msg", "成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("失败:",e);
            juser.put("suc", 'n');
            juser.put("msg", "失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
    
    @RequestMapping(value="/renzheng")
    public void renzheng(HttpServletResponse response, String one,String two,String three,String four) {
        PrintWriter out = null;
        JSONObject juser = new JSONObject();
        try {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
          //设置格式为text/json 
            response.setContentType("text/json");
            //设置字符集为'UTF-8' 
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
          
            goodsService.deleteData();
            Map<String, String> map = new HashMap<String, String>();

            map.put("id", StringUtil.getUUID());
            map.put("one", one);
            map.put("two", two);
            map.put("three", three);
            map.put("four", four);
            goodsService.createData(map);
            juser.put("suc", 'y');
            juser.put("msg", "成功");
            String jstr = juser.toString();
            out.write(jstr);
        } catch (Exception e) {
            logger.error("失败:",e);
            juser.put("suc", 'n');
            juser.put("msg", "失败");
            String jstr = juser.toString();
            out.write(jstr);
            out.flush();
        } finally {
            if (out != null){
                out.close();
            }
        }
    }
}

