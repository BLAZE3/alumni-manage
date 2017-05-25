<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
				return false;
			}else if(password==""){
				alert("请输入密码!");
				return false;
			}else {
				return true;
			}
			return false;
		}
		
		function checkRegisterForm(){
			var username = $("#userName_input").val();
			var password = $("#password_input").val();
			var repassword = $("#repassword_input").val();
			if(username==""){
				alert("请输入用户名!");
			}else if(password==""){
				alert("请输入密码!");
			}else if(password != repassword){
				alert("两次密码不一致!");
				/**清空密码**/
				$("#password_input").val("");
				$("#repassword_input").val("");
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
									<span class="red">Alumni Manage</span>
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
												Please Enter Your Information
											</h4>

											<div class="space-6"></div>

											<form action="user/login" method="post" onsubmit="return checkForm();">
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
														<label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> Remember Me</span>
														</label>
														
														<button id="login_btn" type="submit" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															Login
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

											<div class="social-or-login center">
												<span class="bigger-110">Or Login Using</span>
											</div>

											<div class="social-login center">
												<a class="btn btn-primary">
													<i class="icon-facebook"></i>
												</a>

												<a class="btn btn-info">
													<i class="icon-twitter"></i>
												</a>

												<a class="btn btn-danger">
													<i class="icon-google-plus"></i>
												</a>
											</div>
										</div><!-- /widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
													<i class="icon-arrow-left"></i>I forgot my password
												</a>
											</div>

											<div>
												<a href="studentInfo/forwardStudentRegister" onclick="show_box('signup-box'); return false;" class="user-signup-link">
													I want to register
													<i class="icon-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /widget-body -->
									<div align="right">
										<a href="#">返回首页</a>
									</div>
								</div><!-- /login-box -->
								<!-- 忘记密码 -->
								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="icon-key"></i>
												Retrieve Password
											</h4>

											<div class="space-6"></div>
											<p>
												Enter your email and to receive instructions
											</p>

											<form id="send_form" action="" method="post" onsubmit="return checkGetPassword();">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" name="userName" id="userName" placeholder="Username" />
															<i class="icon-envelope"></i>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" name="email" id="email" placeholder="Email" />
															<i class="icon-envelope"></i>
														</span>
													</label>
													<div class="clearfix">
														<button id="send_btn" type="button" class="width-35 pull-right btn btn-sm btn-danger">
															<i class="icon-lightbulb"></i>
															Send Me!
														</button>
													</div>
												</fieldset>
											</form>
										</div><!-- /widget-main -->
										<script type="text/javascript">
											$(function(){
												$("#send_btn").click(function(){
													var url="user/forgetPassword";
													var data = $("#send_form").serialize();
													if(checkGetPassword()){
														$.post(url,data,function(data){
															if(data.info=="success"){
																alert("邮件已发送,请查收!");
																$("#email").val("");
																$("#userName").val("");
															}else {
																alert(data.data);
															}
														});
													}
												});
											});
										
											function checkGetPassword(){
												var userName = $.trim($("#userName").val());
												var email = $.trim($("#email").val());
												if(userName==""){
													alert("用户名不能为空!");
												}else if(email==""){
													alert("邮箱不能为空!");
												}else {
													return true;
												}
												return false;
											}
										</script>
										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
												Back to login
												<i class="icon-arrow-right"></i>
											</a>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /forgot-box -->

								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="icon-group blue"></i>
												New User Registration
											</h4>

											<div class="space-6"></div>
											<p> Enter your details to begin: </p>
											<!-- **********************************注册页面******************************** -->
											<form action="user/userRegister" method="post" onsubmit="return checkRegisterForm();">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="userName_input" type="text" class="form-control" name="userName" placeholder="请输入账户名" />
															<i class="icon-user"></i>
														</span>
													</label>
												
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="password_input" type="password" class="form-control" name="password" placeholder="请输入密码" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="repassword_input" type="password" class="form-control" placeholder="确认密码" />
															<i class="icon-retweet"></i>
														</span>
													</label>

													<!-- <label class="block">
														<input type="checkbox" class="ace" />
														<span class="lbl">
															I accept the
															<a href="#">User Agreement</a>
														</span>
													</label> -->
													<div class="space-24"></div>
													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="icon-refresh"></i>
															Reset
														</button>

														<button type="submit" class="width-65 pull-right btn btn-sm btn-success">
															Register
															<i class="icon-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
												<i class="icon-arrow-left"></i>
												Back to login
											</a>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /signup-box -->
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
