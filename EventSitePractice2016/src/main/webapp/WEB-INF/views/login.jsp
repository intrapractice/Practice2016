<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0,  minimum-scale=1.0">
	<title>Login</title>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="/EventSitePractice2016/resources/js/loginScript.js"></script>
	<!-- BOOTSTRAP -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/EventSitePractice2016/resources/css/headerFooterEventDetailsPage.css">	
  	<link rel="stylesheet" type="text/css" href="/EventSitePractice2016/resources/css/LoginPageStyle.css">
</head>
<body id="background">
	<div class="head">
		<nav class="list">
			<li><div><img id="logoSize"   src="/EventSitePractice2016/resources/images/logo.png"/></div></li>
			<li><a class="active" href="/EventSitePractice2016/login"><div style="transform: skewX(15deg)">SIGN IN</div></a></li>
			<li><a href="/EventSitePractice2016/"><div style="transform: skewX(15deg)">EVENTS</div></a></li>
			
			<div class="dropdown">
				<div class="dropskew">
					<div class="dropskew2">
						<button class="dropbtn"><img src="/EventSitePractice2016/resources/images/dropdown.png"/></button>
					</div>
				</div>
				<div class="dropdown-content">
					<a href="#">SIGN IN</a>
					<a href="#">EVENTS</a>
					<a href="http://www.intracol.com/">
		   			<img id="intra" src="/EventSitePractice2016/resources/images/Intarcol-logo.png">
		  			</a>
		 		 	<a href="http://bulpros.com/">
		    		<img id="bul" src="/EventSitePractice2016/resources/images/bulpros-logo.png">
		  			</a>
		  			<a href="http://www.tu-sofia.bg/">
		    		<img id="tus" src="/EventSitePractice2016/resources/images/tu-logo.png">
		  			</a>
				</div>
			</div>
			
		</nav>
		
	</div>
		<div class="signin">
			<div class="signin2">
				<h1>SIGN IN</h1>
				<h2>And discover exciting events nearby</h2>
				<button class="facebook" style="max-width: 100%" onclick="login()"><img style="max-width: 100%" src="/EventSitePractice2016/resources/images/fbbutton.png"/></button>
			</div>
		</div>
<jsp:include page="footer.jsp"/>
</body>

</html>
