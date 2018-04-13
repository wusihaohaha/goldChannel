function getUrlParam(name) {  
   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象  
   var r = window.location.search.substr(1).match(reg);  //匹配目标参数  
   if (r != null) return unescape(r[2]); return null; //返回参数值  
}

/**控制radio**/
$(".radio_sty").click(function(){
  $(this).addClass("on").parent().siblings().find(".radio_sty").removeClass("on");
})

/**验证码倒计时**/
var countdown=60; 
function countdownfn(_this){
	if (countdown == 0) { 
        $(_this).removeAttr("disabled");
        $(_this).text("点击获取验证码"); 
        countdown = 60; 
        return;
    } 
    else{
    	$(_this).attr("disabled",true);
        $(_this).text(countdown+"s后可重发"); 
        countdown--; 
    } 
	setTimeout(function(){ 
    	countdownfn(_this); 
	},1000);
}
function getcode(_this){
	alert($("#tel").val());
	countdownfn(_this);
}


/**选择支付方式**/
$("#payBtn").click(function(){
	var checkval=$('input:radio[name="paylist"]:checked').val();
	if(checkval==1){
		alert("支付宝")
	}
	else{
		alert("微信")
	}
});


