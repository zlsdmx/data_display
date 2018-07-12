<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<title>注册</title>
		<style>
			html {
				font-family: "微软雅黑";
			}
			
			h1 {
				font-size: 20px;
				font-weight: normal;
			}
			
			h1 img {
				width: 20%;
				vertical-align: top;
			}
			
			.log {
				margin-left: 25px;
				color: white;
				background-color: #344D5A;
				border-radius: 3px;
				padding: 3px 20px;
			}
			
			form>div {
				border-radius: 6px;
				margin: 10px 0;
				background: #fff;
				width: 100%;
				border: 1px solid #ddd;
				height: 45px;
				line-height: 45px;
				overflow: hidden;
				box-sizing: border-box;
			}
			
			div>input {
				border-radius: 6px;
				width: 100%;
				height: 100%;
				box-sizing: border-box;
				left: 0;
				top: 0;
				bottom: 0;
				padding: 10px;
				border: 0;
			}
			
			.sub {
				border: 1px solid #344D5A;
				text-align: center;
				box-sizing: border-box;
				width: 100%;
				border-radius: 32px;
				padding: 12px;
				margin-bottom: 10px;
				font-size: 16px;
				color: white;
				background-color: #344D5A;
			}
			
			.warm {
				font-size: 12px;
				color: darkred;
			}
		</style>
	</head>

	<body>
		<h1>
		<img src="<%=basePath%>images/logo1.png" /><span> | 登录</span>
	</h1>
		<font color='red'>${msg}</font>
		<form action="/weixin/weixin/login" method="post" > <!--  onsubmit="return subtest()" -->
			<input type="hidden" name="openId" value="${openId}" />
			<div>
				<input type="text" name="userId" id='phone' placeholder="帐号:手机号" />
			</div>
			<span class="warm w-phone"></span>
			<div>
				<input type="text" name="password" id='userpass' placeholder="密码:请输入密码" />
			</div>
			<span class="warm w-userpass"></span>
			<input class="sub" type="submit" name="提交" value="登录" />
		</form>
		<!-- <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
		<script type="text/javascript">
			var submitflag = false;
			$('#phone').on('blur', function() {
				var myreg = /^(((13[0-9]{1})|(14[0-9]{1})||(19[0-9]{1})||(17[0-9]{1})||(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
				obj = $('#phone').val().replace(/\s/g, "");
				if(!myreg.test(obj)) {
					$('.w-phone').html('*请输入正确手机号码')
				} else {
					$('.w-phone').html('')
				}
				$.get('checkUserId',{
					userId:obj
				},function(data){
					flag = JSON.parse(data);
					if(flag){
						$('.w-phone').html('手机号正确');
					}

				});
			})
			$('#userpass').on('blur', function() {
				var namereg = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
				obj = $('#userpass').val().replace(/\s/g, "");
				if(!obj) {
					$('.w-userpass').html('*密码不可为空')
				} else {
					if(namereg.test(obj)) {
						$('.w-userpass').html('*密码不可使用特殊符号')
					} else {
						$('.w-userpass').html('')
					}
				}
				/* $.get('checkIdentityNo', {
					PassWord: obj
				}, function(data) {
					flag = JSON.parse(data);
					if(flag) {
						$('.w-userpass').html('密码错误');
					}
				}); */
			})
			function subtest() {
				var inputnum = 0;
				var warmnum = 0;
				for(var i = 0; i < $('.warm').length; i++) {
					if(!$('.warm').eq(i).html()) {
						warmnum++
					}
				}
				for(var k = 0; k < $('form input').length; k++) {
					if($('form input').eq(k).val()) {
						inputnum++
					}
				}
				if(warmnum == $('.warm').length && inputnum == $('form input').length) {
					$('form').submit()
				}
				return false;
			}
		</script> -->
	</body>

</html>