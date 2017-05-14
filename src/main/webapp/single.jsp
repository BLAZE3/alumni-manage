<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Single</title>
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
<jsp:include page="/component/header.jsp"/>
<!--single start here-->
		 <div class="single">
			<div class="container">
			<div class="col-md-8 ">
				<div class=" single-grid">
					<img class="img-responsive" src="images/4.jpg" alt=""  class="img-responsive">
					<div class="lone-line">
						<h4>Social Sense Perception of Loneliness</h4>
						<div class="cal">
							<ul>
								<li><span ><i class="glyphicon glyphicon-calendar"> </i>22.08.2014</span></li>
								<li><a href="#" ><i class="glyphicon glyphicon-comment"> </i>24</a></li>
							</ul>
						</div>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error.</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error.</p>

					</div>
				</div>
					<div class=" single-profile">
				<h4> Related Posts</h4>
				<div class="single-left ">					
					<div class="col-md-3 post-top">
					<img class="img-responsive " src="images/s1.jpg" alt="">
						<h6>Duis autem</h6>
						<p>Lorem ipsum dolor sit amet, consectetuer .</p>
					</div>
					<div class="col-md-3 post-top">
					<img class="img-responsive " src="images/s2.jpg" alt="">
						<h6>Duis autem</h6>
						<p>Lorem ipsum dolor sit amet, consectetuer .</p>
					</div>
					<div class="col-md-3 post-top">
					<img class="img-responsive " src="images/s3.jpg" alt="">
						<h6>Duis autem</h6>
						<p>Lorem ipsum dolor sit amet, consectetuer .</p>
					</div>
					<div class="col-md-3 post-top">
					<img class="img-responsive " src="images/s4.jpg" alt="">
						<h6>Duis autem</h6>
						<p>Lorem ipsum dolor sit amet, consectetuer .</p>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="single-bottom">
		
			<h3>Leave a Comment</h3>
				<form>
						<div class="col-md-6 comment">
							<input type="text" placeholder="Name">
						</div>
						<div class="col-md-6 comment">
							<input type="text" placeholder="email">
						</div>
						<div class="clearfix"> </div>
							<textarea placeholder="Message" required=""></textarea>	
							<input type="submit" value="Send">
						
				</form>
			
		</div>
				</div>
					<div class="col-md-3 categories-grid">
				<div class="grid-categories">
					<h4>Categories</h4>
					<ul class="popular ">
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>Contrary to popular belief</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>There are many variation</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>Lorem Ipsum is simply</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>Sed ut perspiciatis unde</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>Nemo enim ipsam volume</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>At vero eos et accusamus</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>Contrary to popular belief</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>There are many variation</a></li>
					</ul>
				</div>
				<div class="grid-categories">
					<h4>Achivements</h4>
					<ul class="popular popular-in">
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>MAY 2014</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>SEP 2012</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>JANUARY 2011</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>FEB 2010</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-ok"> </i>NOV 2009</a></li>
					</ul>
				</div>
			</div>
				<div class="clearfix"> </div>
			
			</div>
	</div>

<!--//single end here-->
<jsp:include page="/component/footer.jsp"/>
</body>
</html>