<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>校友管理首页</title>
<jsp:include page="/component/title.jsp"/>
<link rel="shortcut icon" href="css/blaze.ico" type="image/x-icon" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Study Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--Google Fonts-->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			});
		});
	</script>
<!-- //end-smoth-scrolling -->
<script src="js/menu_jquery.js"></script>
</head>
<body>
<!--header start here-->
<div class="header">
	<div class="container">
		<div class="header-main">
			
			<div class="header-logo">
				<div class="logo">
					<a href="index.jsp"><img src="images/lo1.png" alt=""></a>
				</div>
				<div class="top-nav">
					<span class="icon"><img src="images/menu.png" alt="">
					</span>
					<ul>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="about.jsp">About </a></li>
						<li><a href="typo.jsp">Short Codes</a></li>
						<li><a href="galley.jsp">Gallery</a></li>
						<li><a href="contact.jsp">Contact </a></li>
					</ul>
					script
					<script>
							$("span.icon").click(function(){
								$(".top-nav ul").slideToggle(500, function(){
								});
							});
					</script>
				</div>
				<div class="clearfix"></div>
			</div>
			
			<div class="top-menu">
				<ul>
					<li>
						<div class="header-login">
							<div class="top-nav-right">
								<div>
									<a href="user/admin" target="_top"><span>Admin</span></a>
								</div>
							</div>
						</div>
					</li>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About </a></li>
					<!-- <li><a href="typo.jsp">Short Codes</a></li> -->
					<li><a href="index.jsp"> <img src="images/lo1.png" alt="">
					</a></li>
					<li><a href="galley.jsp">Gallery </a></li>
					<li><a href="contact.jsp">Contact</a></li>
					<li><div class="header-login">
							<div class="top-nav-right">
								<div id="loginContainer">
									<a href="user/userLogin" target="_top"><span>Login</span></a>
									<!-- <div id="loginBox">
										<form action="user/login" method="post" id="loginForm"
											onsubmit="checkForm();">
											<fieldset id="body">
												<fieldset>
													<label for="username">用户名</label> <input id="username"
														name="userName" type="text">
												</fieldset>
												<fieldset>
													<label for="password">密码</label> <input id="password"
														name="password" type="password">
												</fieldset>
												<input type="submit" id="login" value="Sign in"> <label
													for="checkbox"><input type="checkbox" id="checkbox">
													<i>Remember me</i></label>
											</fieldset>
											<span><a href="#">Forgot your password?</a></span>
										</form>
									</div> -->
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<!--script-->
			<div class="bann-bottom">
				<h1>Alumni management platform</h1>
				<p>This platform is for USTC students.</p>
				<div class="bann-main">
					<div class="col-md-4 bann-grid">
						<img src="images/i1.png" alt="">
						<h4>系统公告</h4>
					</div>
					<div class="col-md-4 bann-grid">
						<img src="images/i2.png" alt="">
						<h4>校友新闻</h4>
					</div>
					<div class="col-md-4 bann-grid">
						<img src="images/i3.png" alt="">
						<h4>为我点赞</h4>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--header end here-->

<!--baner-info start here-->
<div class="banner-info">
	<div class="container">
		<div class="banner-info-main">
			<div class="col-md-6 bann-info-left">
				<img src="images/2.jpg" alt="" class="img-responsive">
				<p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur</p>
			</div>
			<div class="col-md-6 bann-info-left">
				<img src="images/balance.jpg" alt="" class="img-responsive">
				<p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur</p>
			</div>
		  <div class="clearfix"> </div>
		</div>
		<div class="bann-info-btn"><a href="single.jsp" class="hvr-bounce-to-right">Read More</a></div>
	</div>
</div>
<!--banner-info end here-->
<!--testimonal start here-->
<div class="testimonal">
	<div class="container">
		<div class="testimonal-main">
			 <h2>Nor again anyone who loves  pursues desires</h2>
			 <p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids</p>
			 <a href="single.jsp" class="hvr-bounce-to-right  testimo-btn">Read More</a>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!--testimonal end here-->
<!--we work strat her-->
<div class="we-work">
	<div class="container">
		<div class="we-work-main">
			<div class="we-work-top">
				<h3>How We Work</h3>
				<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
			</div>
			<div class="we-work-bottom">
				 <div class="col-md-6 we-work-left">
				 	<div class="col-md-6 we-left-img1">
				 		<img src="images/w1.jpg" alt="" class="img-responsive">
				 	</div>
				 	<div class="col-md-6 we-left-img2">
				 		<img src="images/w2.jpg" alt="" class="img-responsive">
				 	</div>
				 	<div class="clearfix"> </div>
				 </div>
				 <div class="col-md-6 we-work-right">
				 	<p> Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit.omnis iste natus error sit voluptatem accusantium doloremque laudantium</p>
				 </div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
</div>
<!--we work end here-->
<!--feature start here-->
<div class="features">
	<div class="container">
		<div class="features-main">
			  <div class="features-top">
			  	 <h3>Features</h3>
			  	 <p> </p>
			  </div>
			  <div class="features-bottom">
			  	 <div class="col-md-3 feature-grid">
			  	 	<img src="images/f1.jpg" alt="" class="img-responsive">
			  	 	<h4>voluptatem accusantium</h4>
			  	 	<p>quae ab illo inventore veritatis et quasi architecto beatae vitae</p>
			  	 </div>
			  	  <div class="col-md-3 feature-grid">
			  	 	<img src="images/f2.jpg" alt="" class="img-responsive">
			  	 	<h4>voluptatem accusantium</h4>
			  	 	<p>quae ab illo inventore veritatis et quasi architecto beatae vitae</p>
			  	 </div>
			  	  <div class="col-md-3 feature-grid">
			  	 	<img src="images/f3.jpg" alt="" class="img-responsive">
			  	 	<h4>voluptatem accusantium</h4>
			  	 	<p>quae ab illo inventore veritatis et quasi architecto beatae vitae</p>
			  	 </div>
			  	  <div class="col-md-3 feature-grid">
			  	 	<img src="images/f4.jpg" alt="" class="img-responsive">
			  	 	<h4>voluptatem accusantium</h4>
			  	 	<p>quae ab illo inventore veritatis et quasi architecto beatae vitae</p>
			  	 </div>
			  	 <div class="clearfix"> </div>
			  </div>
		</div>
	</div>
</div>
<!--services end here-->
<jsp:include page="/component/footer.jsp"/>
</body>
</html>