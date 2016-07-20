<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0,  minimum-scale=1.0">
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/LoginPageStyle.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="../resources/js/loginScript.js"></script>
</head>
<body id="background">
	<div class="head">
		<nav class="list">
			<li><div><img id="logoSize"   src="../resources/images/logo.png"/></div></li>
			<li><a class="active" href="#signin"><div style="transform: skewX(15deg)">SIGN IN</div></a></li>
			<li><a href="#home"><div style="transform: skewX(15deg)">EVENTS</div></a></li>
			
			<div class="dropdown">
				<div class="dropskew">
					<div class="dropskew2">
						<button class="dropbtn"><img src="../resources/images/dropdown.png"/></button>
					</div>
				</div>
				<div class="dropdown-content">
					<a href="#">SIGN IN</a>
					<a href="#">EVENTS</a>
				</div>
			</div>
			
		</nav>
		
	</div>
		<div class="signin">
			<div class="signin2">
				<h1>SIGN IN</h1>
				<h2>And discover exciting events nearby</h2>
				<button class="facebook" style="max-width: 100%" onclick="login()"><img style="max-width: 100%" src="../resources/images/fbbutton.png"/></button>
			</div>
		</div>

</body>
</html>