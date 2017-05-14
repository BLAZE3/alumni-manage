<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:include page="/component/title.jsp" />
<!--header start here-->
<div class="header1">
	<div class="container">
		<div class="header-main">
			<!---->
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
					<!--script-->
					<script>
							$("span.icon").click(function(){
								$(".top-nav ul").slideToggle(500, function(){
								});
							});
					</script>
				</div>
				<div class="clearfix"></div>
			</div>
			<!---->
			<div class="top-menu">
				<ul>
					<li><div class="header-login">
							<div class="top-nav-right">
								<div>
									<a href="user/admin" target="_top"><span>Admin</span></a>
								</div>
							</div>
						</div></li>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About </a></li>
					<!-- <li><a href="typo.jsp">Short Codes</a></li> -->
					<li><a href="index.jsp"> <img src="images/lo1.png" alt="">
					</a></li>
					<li><a href="galley.jsp">Gallery </a></li>
					<li><a href="contact.jsp">Contact</a></li>
					<li>
						<div class="header-login">
							<div class="top-nav-right">
								<div id="loginContainer">
									<a href="user/userLogin" target="_top"><span>Login</span></a>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!--header end here-->
