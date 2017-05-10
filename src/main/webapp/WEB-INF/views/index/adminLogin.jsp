<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="cn.blaze.utils.BlazeConstants" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录页面</title>
		<meta name="description" content="校友管理" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<jsp:include page="/component/title.jsp"/>
		<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
		<!-- basic styles -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
		<link rel="shortcut icon" href="css/blaze.ico" type="image/x-icon" />
		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
	</head>
	<script type="text/javascript">
		var loginMsg = "${msg}";
		$(function(){
			if(loginMsg!=null&&loginMsg!=""){
				alert(loginMsg);// 登录错误提示
			}
		});
		function checkForm(){
			var username = $("#username").val();
			var password = $("#password").val();
			if(username==""){
				alert("请输入用户名!");
			}else if(password==""){
				alert("请输入密码!");
			}else {
				return true;
			}
			return false;
		}
	</script>
	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">Ace</span>
									<span class="white">Application</span>
								</h1>
								<h4 class="blue">&copy; Blaze Project</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												管理员用户登录
											</h4>

											<div class="space-6"></div>

											<form action="user/login" method="post" onsubmit="checkForm();">
												<input type="hidden" name="type" value="0">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="username" name="userName" type="text" class="form-control" placeholder="Username" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="password" name="password" type="password" class="form-control" placeholder="Password" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<!-- <label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> Remember Me</span>
														</label> -->

														<button id="login_btn" type="submit" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															Login
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>
										</div><!-- /widget-main -->
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
		<!-- <![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			function show_box(id) {
			 jQuery('.widget-box.visible').removeClass('visible');
			 jQuery('#'+id).addClass('visible');
			}
		</script>
</body>
</html>
