package com.golden.common;

public class Constants
{
    /****************************************返回码****************************************************/
    /** 0 */
    public static final int ZERO = 0;
    /** 1 */
    public static final int ONE = 1;
    /** 成功 */
    public static final String SUCCESS = "200";
    /** 失败 */
    public static final String ERROR = "400";

    // 短信发送模板ID
    public static class SmsTemplateId
    {
        // 【黄金水道】您本次操作的短信验证码是：{1}，请在{2}分钟之内完成操作，否则将会过期。
        public static final String VALIDATECODE = "135069";//97643 73413 98104
        
        // 【爱刷科技】您已成功领取{1}，卡号：{2}，请在{3}之前使用，否则将会过期。
        public static final String GETMEMBERCODE = "73417";
        
        // 【爱刷科技】您已成功领取{1}，券凭证码：{2}，过期时间：{3}，商家地址：{4}。
        public static final String GETCOUPONCODE = "73418";
        
        // 【爱刷科技】尊敬的用户:{1}，您的提交的资料审核{2}，请知晓!
        public static final String CHANGEBUSSTATIC = "77148";
    }
    
    public static class loginCode
    {
        /** 手机号未注册*/
        public static final String TELEPHONE_NOEXIST = "1000";
        /** 手机号码已注册*/
        public static final String TELEPHONE_EXIST = "1001";
        /** 昵称已注册*/
        public static final String NICKNAME_EXIST = "1002";
        /** 验证码错误*/
        public static final String CODE_ERROR = "1003";
        /** 登录-用户名或者密码错误*/
        public static final String USERNAME_PWD_ERROR = "1004";
        /** 旧密码不正确 */
        public static final String OLDPWD_ERROR = "1005";
        /** 没有获取验证码或者验证码已失效 */
        public static final String CODE_OUT = "1006";
        /** 短信接口-发送注册验证码 成功*/
        public static final String SHORTMESSAGE_CODE_SUCCESS = "000000";
        /**更新用户头像时图片存放的key名称*/
        public static final String USERPIC = "userPic";
    }
    
    /*** 货物状态 */
    public static class goodsStatus
    {
        /*** 信息 */
        public static final String info = "1";
        /*** 待审核 */
        public static final String audit = "2";
        /*** 竞标中 */
        public static final String biding = "3";
        /*** 流标(无人竞标，显示) */
        public static final String failBid = "4";
        /*** 竞标结束 */
        public static final String end = "5";
        /*** 申请船运 */
        public static final String apply = "6";
        /*** 定船 */
        public static final String ship = "7";
        /*** 删除 */
        public static final String delete = "8";
        /*** 流标（不显示） */
        public static final String failBidNoShow = "9";
    }
    
    /*** 船舶状态 */
    public static class shipStatus
    {
        /*** 空闲 */
        public static final String free = "1";
        /*** 竞标中 */
        public static final String biding = "2";
        /*** 货运中 */
        public static final String transport = "3";
    }
    
    /*** 船舶审核状态 */
    public static class shipAuditState
    {
        /*** 待审核 */
        public static final String audit = "1";
        /*** 待修改 */
        public static final String update = "2";
        /*** 通过 */
        public static final String pass = "3";
        /*** 删除 */
        public static final String delete = "4";
    }

    /*** 竞标状态 */
    public static class bidStatus
    {
        /*** 待付保证金 */
        public static final String pay = "1";
        /*** 竞标中 */
        public static final String biding = "2";
        /*** 中标 */
        public static final String winBid = "3";
        /*** 竞标失败 */
        public static final String failBid = "4";
        /*** 退款成功 */
        public static final String refund = "5";
    }
    
    /*** 船运申请状态 */
    public static class shipApplyStatus
    {
        /*** 申请 */
        public static final String apply = "1";
        /*** 待指派跟单员 */
        public static final String assign = "2";
    }
    
    /*** 竞标（货）状态 or 船运申请（船）状态 */
    public static class applyStatus
    {
        /*** 未竞标  or 未申请*/
        public static final String noApply = "0";
        /*** 已竞标 or 已申请 */
        public static final String apply = "1";
    }
    
    /*** 支付类型：线上/线下 */
    public static class payType
    {
        /*** 线上 */
        public static final String onLine = "1";
        /*** 线下 */
        public static final String line = "2";
    }
    
    /*** 支付比例 */
    public static class payPercent
    {
        /*** 支付保证金的百分比-3% */
        public static final String depositPercent = "0.03";
    }
    
    /*** 角色类型：货方/船方 */
    public static class roleType
    {
        /*** 货方*/
        public static final String goods = "1";
        /*** 船方 */
        public static final String ship = "2";
    }
    
    /*** 船运类型 */
    public static class shippingType
    {
        /*** 发标*/
        public static final String publish = "1";
        /*** 竞标 */
        public static final String compete = "2";
        /*** （货方）申请（船运）*/
        public static final String apply = "1";
        /*** （船方）被申请（船运） */
        public static final String beApply = "2";
        /*** （订单）待指派跟单员 */
        public static final String assign = "3";
        
    }
    
    /*** 船运订单(船方)状态 */
    public static class shippingOrderStatus
    {
        /*** 待上传合同 */
        public static final String upload = "1";
        /*** 审核合同中 */
        public static final String audit = "2";
        /*** 待确认首款 */
        public static final String firstConfirm = "3";
        /*** 待确认尾款 */
        public static final String lastConfirm = "4";
        /*** 交易完成 */
        public static final String finish = "5";
        /*** 删除 */
        public static final String delete = "6";
    }
    
    /*** 船运订单(货方)状态 */
    public static class goodsOrderStatus
    {
        /*** 待上传合同 */
        public static final String upload = "1";
        /*** 审核合同中 */
        public static final String audit = "2";
        /*** 待支付首款 */
        public static final String firstPay = "3";
        /*** 待支付尾款 */
        public static final String lastPay = "4";
        /*** 交易完成 */
        public static final String finish = "5";
        /*** 删除 */
        public static final String delete = "6";
    }
    
    /*** 图片存储路径 */
    public static class picturePath
    {
        /*** 货图片路径 */
        public static final String goodsPic = "goodsPic";
        /**文件上真实目录相对于指定路径的路径*/
        public static final String Upload_GoodsFiles = "/upload/goodsPic/";
        /*** 船图片路径 */
        public static final String shipPic = "shipPic";
        /**文件上真实目录相对于指定路径的路径*/
        public static final String Upload_ShipFile = "/upload/shipPic/";
        /*** 船舶营业证路径*/
        public static final String businessPic = "businessPic";
        /**文件上真实目录相对于指定路径的路径*/
        public static final String Upload_BusinessFile = "/upload/businessPic/";
        /*** 船舶适航证书路径 */
        public static final String airworthinessPic = "airworthinessPic";
        /**文件上真实目录相对于指定路径的路径*/
        public static final String Upload_AirworthinessPicFile = "/upload/airworthinessPic/";
        /*** 船舶国籍证书路径 */
        public static final String nationalityPic = "nationalityPic";
        /**真实目录相对于指定路径的路径*/
        public static final String Upload_NationalityPic = "/upload/nationalityPic/";
        /*** 维修资格证书路径 */
        public static final String repairpassPic = "repairpassPic";
        /**文件上真实目录相对于指定路径的路径*/
        public static final String Upload_RepairpassFile = "/upload/repairpassPic/";
        /*** 创建简历照片路径 */
        public static final String resumePic = "resumePic";
        /**文件上真实目录相对于指定路径的路径*/
        public static final String Upload_ResumeFile = "/upload/resumePic/";
        /*** 合同文件路径 */
        public static final String bidFilePic = "bidFilePic";
        /**合同文件上真实目录相对于指定路径的路径*/
        public static final String Upload_bidFilePic = "/upload/bidFilePic/";
        
    }
    
    /*** 货物-装运要求 */
    public static class loadingDemand
    {
        /*** 不要求 */
        public static final String noDemand = "1";
        /*** 要求 */
        public static final String demand = "2";
        
        /*** 装运要求(计件交接) */
        public static final String byThePiece = "计件交接";
        /*** 装运要求(过磅交接) */
        public static final String byWeigh = "过磅交接";
        /*** 装运要求(原装原卸) */
        public static final String originalBinding = "原装原卸";
        /*** 装运要求(防雨防潮) */
        public static final String moistureProof = "防雨防潮";
        /*** 装运要求(防污染) */
        public static final String antiPollution = "防污染";
    }
    
    /*** 地址-类型 */
    public static class AddressType
    {
        /*** 省 */
        public static final String province = "1";
        /*** 市 */
        public static final String city = "2";
        /*** 港口 */
        public static final String port = "3";
        /*** 码头 */
        public static final String wharf = "4";
    }
    
    /*** 消息-类型 */
    public static class MessageType
    {
        /*** 系统消息 */
        public static final String system = "1";
        /*** 个人消息 */
        public static final String personal = "2";
    }
    
    /*** 消息-状态 */
    public static class MessageStatus
    {
        /*** 未读 */
        public static final String Unread = "1";
        /*** 已读*/
        public static final String read = "2";
    }
    
    /*** 消息-主题 */
    public static class MessageTitle
    {
        /*** 系统消息 */
        public static final String system = "系统消息";
        /*** 竞标信息 */
        public static final String bid = "竞标信息";
        /*** 船运信息 */
        public static final String shipping = "船运信息";
        /*** 订单信息 */
        public static final String order = "订单信息";
        /*** 维修信息 */
        public static final String maintenance = "维修信息";
        /*** 招聘信息 */
        public static final String job = "招聘信息";
    }
    
    /*** 消息信息 */
    public static class MessageInfos
    {
        /*** 标书审核不通过 */
        public static final String audit_bid_fail = "您好，您发的标（%s）审核不通过。" + System.getProperty("line.separator") +
                                                    "以下内容不符合要求：%s。" + System.getProperty("line.separator") +
                                                    "请您前往【我的货物】，修改后再发标。";
        
        /*** 船只审核不通过 */
        public static final String audit_ship_fail ="您好，您添加的船只（%s）审核不通过。" + System.getProperty("line.separator") +
                                                    "以下内容不符合要求：%s。" + System.getProperty("line.separator") +
                                                    "请您前往【我的船舶】，进行修改。";
        
        /*** 船只审核通过 */
        public static final String audit_ship_success ="您好，您添加的船只（%s）审核通过。" + System.getProperty("line.separator") +
                                                       "可以开始竞标了。";
        
        /*** 合同审核不通过*/
        public static final String audit_contract_fail ="订单号：%s 合同审核不通过。"+ System.getProperty("line.separator") +
                                                        "请您重新上传合同图片。";
        
        /*** 线上的场合，合同审核通过后，货方的场合*/
        public static final String audit_contract_success_online ="您好，合同已审核通过。"+ System.getProperty("line.separator") +
                                                                  "请您向船方支付首付款。";
        
        /*** 线下的场合，合同审核通过后，货方的场合*/
        public static final String audit_contract_success_line ="您好，合同已审核通过。"+ System.getProperty("line.separator") +
                                                                "请您联系船方支付首付款，支付完成后请在【我的订单】确认。";
        
        /*** 维修师傅申请审核不通过*/
        public static final String audit_beRepairer_fail ="您好，您提交的成为维修师傅的申请审核不通过。"+ System.getProperty("line.separator") +
                                                          "以下内容符合要求：%s。"+ System.getProperty("line.separator") +
                                                          "请您前往【我的维修信息】里修改后，再次提交。";
        
        /*** 维修师傅申请审核通过*/
        public static final String audit_beRepairer_success ="您好，恭喜您已成为一名维修师傅。"+ System.getProperty("line.separator") +
                                                             "现在可以开始接单了。";
        
        /*** 求职信息审核不通过*/
        public static final String audit_cv_fail ="您好，您的简历审核不通过。"+ System.getProperty("line.separator") +
                                                  "以下内容不符合要求：***。"+ System.getProperty("line.separator") +
                                                  "请您前往【我的简历】，进行修改。";

        /*** 线下的场合，提交竞价 */
        public static final String biding_line_submit ="您好，您参与了标（标号：%s）的竞价。" + System.getProperty("line.separator") +
                                                       "请您尽快联系客服（%s 电话：%s），支付保证金%s元，以免耽误您的竞标。";
        
        /*** 竞标成功 */
        public static final String biding_winBid ="恭喜您中标（标号：%s）。" + System.getProperty("line.separator") +
                                                  "平台已为您指定跟单员（%s 电话：%s），【我的订单】可查看详情(订单号：%s)。请尽快联系货方，签订合同。";

        /*** 竞标失败 */
        public static final String biding_failBid ="您好，很抱歉，您未能中标（标号：%s）。" + System.getProperty("line.separator") +
                                                   "您可以继续参与其他标的竞标。";
        
        /*** 船运申请成功 */
        public static final String shipping_success ="您好，用户（%s）申请了您的船运（船名：%s）。" + System.getProperty("line.separator") +
                                                     "详情请前往【我的船运】查看。";
        
        /*** 船运申请成功 sql用*/
        public static final String shipping_success_s ="您好，用户（[0]）申请了您的船运（船名：[1]）。" + System.getProperty("line.separator") +
                                                     "详情请前往【我的船运】查看。";
        
        /*** （货方）取消（船运）申请 */
        public static final String shipping_cancel ="您好，用户（%s）取消了您的船运（船名：%s）申请。";
        
        /*** （货方）取消（船运）申请  sql用*/
        public static final String shipping_cancel_s ="您好，用户（[0]）取消了您的船运（船名：[1]）申请。";
        
        /*** （船方）同意（船运）申请*/
        public static final String shipping_agree ="您好，船主（%s）同意了您的船运（船名：%s）申请。"+ System.getProperty("line.separator") +
                                                   "平台正在为您指派跟单员，请耐心等待。";
        
        /*** （船方）同意（船运）申请 sql用*/
        public static final String shipping_agree_s ="您好，船主（[0]）同意了您的船运（船名：[1]）申请。"+ System.getProperty("line.separator") +
                                                   "平台正在为您指派跟单员，请耐心等待。";
        
        /*** （船方）同意（船运）申请 → 平台指定跟单员后*/
        public static final String shipping_assign ="您好，平台已为您指派了跟单员（%s 电话：%s）。"+ System.getProperty("line.separator") +
                                                    "请前往【我的订单】查看详情(订单号：%s)，并进行下一步操作。"+ System.getProperty("line.separator") +
                                                    "【温馨提示】除了您的跟单员，请勿轻信其他人。";
        
        /*** （船方）拒绝（船运）申请*/
        public static final String shipping_refuse ="您好，船主（%s）拒绝了您的船运（船名：%s）申请。"+ System.getProperty("line.separator") +
                                                    "您可以向其他船主提出申请，或者参与竞标。";
        
        /*** （船方）拒绝（船运）申请 sql用*/
        public static final String shipping_refuse_s ="您好，船主（[0]）拒绝了您的船运（船名：[1]）申请。"+ System.getProperty("line.separator") +
                                                    "您可以向其他船主提出申请，或者参与竞标。";
        
        /*** 线上的场合，货方确认支付首款后*/
        public static final String order_firstPay_online ="订单号：%s 货主已向您支付首付款%s元。"+ System.getProperty("line.separator") +
                                                          "请您在收到款项后，在【我的订单】确认。如若未收到款项，请及时与您的跟单员联系。";
        
        /*** 线下的场合，货方确认支付首款后*/
        public static final String order_firstPay_line ="您好，若您已收到货主向您支付（订单号：%s）的首付款%s元，请在【我的订单】确认。"+ System.getProperty("line.separator") +
                                                         "如若未收到款项，请及时与货主联系，并向您的跟单员反映。";
        
        /*** 线上的场合，货方确认支付尾款后*/
        public static final String order_lastPay_online ="订单号：%s 货主已向您支付尾款%s元。"+ System.getProperty("line.separator") +
                                                         "请您在收到款项后，在【我的订单】确认。如若未收到款项，请及时与您的跟单员联系。";
        
        /*** 线上的场合，货方确认支付尾款后*/
        public static final String order_lastPay_line ="您好，若您已收到货主向您支付（订单号：%s）的尾款%s元，请在【我的订单】确认。"+ System.getProperty("line.separator") +
                                                       "如若未收到款项，请及时与货主联系，并向您的跟单员反映。";
        
        /*** 报修人员的场合，订单被接*/
        public static final String repair_orderTake ="您好，您报修的订单（船名：%s）,已被（%s师傅，电话：%s）接单了。"+ System.getProperty("line.separator") +
                                                     "详情请前往【我的报修】查看。";
        
        /*** （雇主）邀请（雇员）加入团队*/
        public static final String job_invite ="您好，用户（%s 电话：%s）邀您加入他的团队。"+ System.getProperty("line.separator") +
                                               "详情请前往【我的求职信息】查看。";
        
        /*** （雇主）取消邀请*/
        public static final String job_invite_cancle ="您好，用户（%s）取消了对您的邀请。"+ System.getProperty("line.separator") +
                                                      "更多的团队在后面等待着您。";
        
        /*** （雇员）拒绝（雇主）邀请*/
        public static final String job_invite_refuse ="您好，您邀请的用户（%s）拒绝了您的邀请。"+ System.getProperty("line.separator") +
                                                      "您可以邀请其他优秀人员加入。";
        
        /*** （雇员）同意（雇主）邀请*/
        public static final String job_invite_agree ="您好，您邀请的用户（%s）同意了您的邀请，成为您团队的一员。"+ System.getProperty("line.separator") +
                                                      "详情请前往【我的船员】查看。";
    }
    public static class Transaction{
        /**交易类型  1-转入*/
        public static final String TRADE_TYPE_ONE = "1";
        /**交易类型  2-转出*/
        public static final String TRADE_TYPE_TWO = "2";
        /**金额类型  1-支付*/
        public static final String AMOUNT_TYPE_ONE = "1";
        /**金额类型  2-保证金*/
        public static final String AMOUNT_TYPE_TWO = "2";
        /**金额类型  3-首付款*/
        public static final String AMOUNT_TYPE_THREE = "3";
        /**金额类型  4-尾款*/
        public static final String AMOUNT_TYPE_FOUR = "4";
        /**交易说明  1-支付竞标保证金*/
        public static final String PAYMENT_EXPLAIN_ONE = "支付竞标保证金";
        /**交易说明  2-平台退还竞标保证金*/
        public static final String PAYMENT_EXPLAIN_TWO = "平台退还竞标保证金";
        /**交易说明  3-支付首款*/
        public static final String PAYMENT_EXPLAIN_THREE = "支付首款";
        /**交易说明  4-平台转交首款*/
        public static final String PAYMENT_EXPLAIN_FOUR = "平台转交首款";
        /**交易说明  5-支付尾款*/
        public static final String PAYMENT_EXPLAIN_FIVE = "支付尾款";
        /**交易说明  6-平台转交尾款*/
        public static final String PAYMENT_EXPLAIN_SIX= "平台转交尾款";

    }
    
    public static class GoodsOrder{
        /**船运订单船状态 状态(船方用) 
         * 1:待上传合同 2:审核合同中 3:待确认首款 4:待确认尾款 5:交易完成 6:删除*/
        public static final String SHIP_STATUS_ONE = "1";
        public static final String SHIP_STATUS_TWO = "2";
        public static final String SHIP_STATUS_THREE = "3";
        public static final String SHIP_STATUS_FOUR = "4";
        public static final String SHIP_STATUS_FIVE = "5";
        public static final String SHIP_STATUS_SIX = "6";
        
        /**船运订单货状态 状态(货方用) 
         * 1:待上传合同 2:审核合同中 3:待支付首款 4:待支付尾款 5:交易完成 6:删除*/
        public static final String GOODS_STATUS_ONE = "1";
        public static final String GOODS_STATUS_TWO = "2";
        public static final String GOODS_STATUS_THREE = "3";
        public static final String GOODS_STATUS_FOUR = "4";
        public static final String GOODS_STATUS_FIVE = "5";
        public static final String GOODS_STATUS_SIX = "6";
        
        /**订单平台状态 1-待支付首款 */
        public static final String SYSTEM_STATUS_ONE = "1";
        /**订单平台状态 2-待支付尾款*/
        public static final String SYSTEM_STATUS_TWO = "2";
        /**订单平台状态 3-完成交易 */
        public static final String SYSTEM_STATUS_THREE = "3";
    }
}
