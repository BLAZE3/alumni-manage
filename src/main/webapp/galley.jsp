<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Gallery</title>
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
<!--script-->
	<script src="js/modernizr.custom.97074.js"></script>
<script src="js/jquery.chocolat.js"></script>
		<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen" charset="utf-8">
		<!--light-box-files -->
		<script type="text/javascript" charset="utf-8">
		$(function() {
			$('.gallery a').Chocolat();
		});
		</script>
		<script type="text/javascript" src="js/jquery.hoverdir.js"></script>

</head>
<body>
<jsp:include page="/component/header.jsp"/>
<!--gallery-starts-->
	<div class="gallery">
		<div class="container">
			<div class="gallery-top heading">
				<h2>Our Gallery</h2>
				<p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas tristique orci ac sem. Duis ultricies pharetra</p>
			</div>
			<section>
				<ul id="da-thumbs" class="da-thumbs">
					<li>
						<a href="images/g1.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/g1.jpg" alt="" class="img-responsive">
							<div>
								<h5>Education</h5>
								<span>non suscipit leo fringilla non suscipit leo fringilla molestie</span>
							</div>
						</a>
					</li>
					<li>
						<a href="images/g2.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/g2.jpg" alt="">
							<div>
								<h5>Education</h5>
								<span>non suscipit leo fringilla non suscipit leo fringilla molestie</span>
							</div>
						</a>
					</li>
					<li>
						<a href="images/g3.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/g3.jpg" alt="">
							<div>
								<h5>Education</h5>
								<span>non suscipit leo fringilla non suscipit leo fringilla molestie</span>
							</div>
						</a>
					</li>
					<li>
						<a href="images/g4.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/g4.jpg" alt="">
							<div>
								<h5>Education</h5>
								<span>non suscipit leo fringilla non suscipit leo fringilla molestie</span>
							</div>
						</a>
					</li>
					<li>	
						<a href="images/g5.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/g5.jpg" alt="">
							<div>
								<h5>Education</h5>
								<span>non suscipit leo fringilla non suscipit leo fringilla molestie</span>
							</div>
						</a>
					</li>
					<li>
						<a href="images/g6.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/g6.jpg" alt="">
							<div>
								<h5>Education</h5>
								<span>non suscipit leo fringilla non suscipit leo fringilla molestie</span>
							</div>
						</a>
					</li>
					<li>
						<a href="images/g7.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/g7.jpg" alt="">
							<div>
								<h5>Education</h5>
								<span>non suscipit leo fringilla non suscipit leo fringilla molestie</span>
							</div>
						</a>
					</li>
					<li>
						<a href="images/g8.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/g8.jpg" alt="">
							<div>
								<h5>Education</h5>
								<span>non suscipit leo fringilla non suscipit leo fringilla molestie</span>
							</div>
						</a>
					</li>
					<li>
						<a href="images/g9.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox">
							<img src="images/g9.jpg" alt="">
							<div>
								<h5>Educatione</h5>
								<span>non suscipit leo fringilla non suscipit leo fringilla molestie</span>
							</div>
						</a>
					</li>
					<div class="clearfix"> </div>
				</ul>
			</section>
				
		<script type="text/javascript">
			$(function() {
			
				$(' #da-thumbs > li ').each( function() { $(this).hoverdir(); } );

			});
		</script>
        </div>
	</div>
<!--gallery-end-->
<jsp:include page="/component/footer.jsp"/>
</body>
</html>