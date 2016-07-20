<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<title>Event Harbor</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
	<link rel="stylesheet" type="text/css" href="resources/css/homePageStyle.css">
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="resources/js/sdkScript.js"></script>
	<script src="resources/js/maps.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDBWf1meYriYFQVot9hYrBggczlMcgk9_o&v=3.exp&sensor=false&libraries=places"></script>
  <!--TODO: Put here any style and CSS imports -->
  </head>
  <body>
  	<div id="pageNavigation">
  		<jsp:invoke fragment="header"/>
  	</div>
    <div id="body">
      <jsp:doBody/>
    </div>
    <div id="pagefooter">
      <jsp:invoke fragment="footer"/>
    </div>
  </body>
</html>