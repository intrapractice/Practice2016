<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Event Harbor</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="/EventSitePractice2016/resources/css/calendar/flatpickr.min.css">
    <link rel="stylesheet" type="text/css" href="/EventSitePractice2016/resources/css/headerFooterEventDetailsPage.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="/EventSitePractice2016/resources/js/sdkScript.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDBWf1meYriYFQVot9hYrBggczlMcgk9_o&v=3.exp&libraries=places"></script>
    <script src="/EventSitePractice2016/resources/js/maps.js"></script>
    <script src="/EventSitePractice2016/resources/js/calendar/flatpickr.min.js"></script>
    <script type="text/javascript" src="/EventSitePractice2016/resources/js/selectPicker.js"></script>
    <script type="text/javascript" src="/EventSitePractice2016/resources/js/header.js"></script>
    
    <!-- BOOTSTRAP -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">

  <!--TODO: Put here any style and CSS imports -->
  </head>
  <body>
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img id="logoSize" src="/EventSitePractice2016/resources/images/logo.png">
	  </a>
    </div>
    <ul class="nav navbar-nav">
      <li>
	    <a id="events" href="#">
		  <div>Events</div>
		</a>
	  </li>
      <li>
	    <a id="create" href="#">
		  <div>Create</div>
		</a>
      </li>
      <li id="bute">
	    <a class="no-padding">
	      <img id="userPicture" src="http://gravatar.com/avatar/a81ed73040d354ca940a27c64001364a?d=mm&s=50&r=G"/>
	      <div>
	        <span id="user">Alexander Dimitrov</span>
			<i class="fa fa-pencil" aria-hidden="true"></i>
		  </div>
		</a>
	  </li>	  
	</ul>
  </div>
</nav>

  <div class="userdropdown">
    <div class="userdropdown-content">
      <a id="userdropsettings" href="#">Settings</a>
      <a href="#">Logout</a>
	</div>
  </div>
  
    <div class="dropdown">
	  <button class="dropbtn">
	    <img src="/EventSitePractice2016/resources/images/dropdown.png"/>
	  </button>
	    <div class="dropdown-content">
		  <a id="dr1" href="#">Events</a>
		  <a id="dr2" href="#">Create</a>
		  <a id="dr3" href="#">
		  <img id="userDrop" src="http://gravatar.com/avatar/a81ed73040d354ca940a27c64001364a?d=mm&s=50&r=G"/>
		    <div id="usercontainer">
			  <span id="user">Alexander Dimitrov</span>
			  <i class="fa fa-pencil" aria-hidden="true"></i>
			</div>
		  </a>
		  <a id="dr4" href="#">Settings</a>
		  <a id="dr5" href="#">Sign Out</a>
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
