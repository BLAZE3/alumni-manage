<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Contact</title>
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
<!--contact start here-->
<div class="contact">
	<div class="container">
		<div class="contact-top">
			<h2>Contact Us</h2>
			<p>您还可以访问<a href="http://www.ustc.edu.cn/" target="_blank">中国科学技术大学官网</a>或<a href="http://sse.ustc.edu.cn/pages/index.php" target="_blank">软件学院官网</a>更加详细的了解我们.</p>
		</div>
		<div class="map">
			<h1>GET IN TOUCH</h1>
		</div>
			<iframe id="frame" src="http://www.ustc.edu.cn/lxwm/" height="850px" width="100%"> </iframe>
		<!-- <div class="contact-infom">
			<h4>CONTACT INFO</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,sheets containing Lorem Ipsum passages, 
				sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.It was popularised in the 1960s with the release of Letraset
				  and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
		</div>	
		<div class="contact-form">
			<form>
				<input type="text" placeholder="Name">
				<input type="text"  class="email" placeholder="email">
                   <input type="text" placeholder="Telephone">
				<textarea placeholder="Message" required=""></textarea>								
				<input type="submit" value="Submit" >
			</form>
		</div> -->
	</div>
</div>
<!--contact end here-->
<jsp:include page="/component/footer.jsp"/>
</body>
</html>