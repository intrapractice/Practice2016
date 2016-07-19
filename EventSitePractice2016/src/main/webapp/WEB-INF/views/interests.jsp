<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<link rel="stylesheet" type="text/css" href="resources/css/interests.css">
<%@ page import="com.intrapractice.pojo.Category"%>
<%@ page import="com.intrapractice.pojo.User"%>
<%@ page import="java.util.List"%>
<html>
<head>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/sdkScript.js"></script>

<script>
    var currentUser;
	$(document).ready(function() {
		 
		$("button").click(function() {
			var src = $(this).find("img").attr('src');
			if (src.indexOf("greyHeart") > 0) {
				$(this).find("img").attr('src', 'resources/images/redHeart.png');
				var categoryId = $(this).find("input").val();
				console.log(categoryId);
				console.log(window.user);
			} else {
				$(this).find("img").attr('src', 'resources/images/greyHeart.png');
			}
		});

	});
</script>



</head>
<body bgcolor="#ebf3f6">

	<div class="head">
		<ul class="list">
			<li><div id="logo">
					<img src="resources/images/logo.png">
				</div></li>
			<li><a class="li" href="#home"><div
						style="transform: skew(15deg)">EVENTS</div></a></li>
			<li><a class="li" href="#signin"><div
						style="transform: skew(15deg)">SIGN IN</div></a></li>
		</ul>
	</div>

	<img id="hero" src="resources/images/hero_img.jpg">
	<div class="container">
		<h1 id="create">CREATE & DISCOVER</h1>
		<h2 id="events">Events based on your interests</h2>


		<div class="box">

			<div id="searchbox">
				<img class="lupa" src="resources/images/lupa.png"> <input type="text"
					name="search" placeholder="Search">
			</div>
			<nav>
			<ul class="menu">
				<li><a class="limenu" href="#myplaces"><div
							style="transform: skew(15deg)">MY PLACES</div></a></li>
				<li><a class="limenu" href="#interest"><div
							style="transform: skew(15deg)">INTERESTS</div></a></li>
				<li><a class="limenu" href="#location"><div
							style="transform: skew(15deg)">LOCATIONS</div></a></li>
				<li><a class="limenu" href="#calendar"><div
							style="transform: skew(15deg)">CALENDAR</div></a></li>
			</ul>
			</nav>

		</div>

	</div>
	<div id="background"></div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="mainContainer">
	
		<%
			List<Category> categories = (List) request.getAttribute("categories");
		%>
  		<%   String image=null;
			for (Category category : categories) {
				if(category.getTitle().equals("Photography")) {
				    image= "resources/images/interest1.jpg";
				}else if(category.getTitle().equals("Music")) {
					image = "resources/images/interest2.jpg";
				}else if(category.getTitle().equals("Motor sports")) {
                    image = "resources/images/interest3.jpg";
                }else if(category.getTitle().equals("Sport")) {
                    image = "resources/images/interest4.jpg";
                }else if(category.getTitle().equals("Learning")) {
                    image = "resources/images/interest5.jpg";
                }else if(category.getTitle().equals("Technology")) {
                    image = "resources/images/interest6.jpg";
                }else if(category.getTitle().equals("For children")) {
                    image = "resources/images/interest7.jpg";
                }else if(category.getTitle().equals("Business")) {
                    image = "resources/images/interest8.jpg";
                }else if(category.getTitle().equals("BBQ")) {
                	image = "resources/images/interest9.jpg";
                }else image = "resources/images/interestDefault.jpg";
		%>
		
		<div class="otherContainer">
			<div id="relativePosition">
				<button name="button" class="heartImage" id="absolutePosition"
					onClick="">
					<input type="hidden" value="<%=category.getId()%>"/>
					<img class="heartImage" src="resources/images/greyHeart.png" />
				</button>
				<img class="categoryImage" src=<%=image %> id="relativePosition" />
			</div>
			<div class="categoryName" align="center"><%=category.getTitle()%></div>
		</div>
		<%
			}
		%>

	</div>

</body>


</html>
