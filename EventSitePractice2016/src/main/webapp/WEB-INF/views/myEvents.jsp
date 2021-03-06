<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.intrapractice.pojo.Event" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.SimpleDateFormat" %>


<link rel="stylesheet" type="text/css" href="resources/css/myEventsStyle.css">
<jsp:include page="header.jsp"/>
<script src="/EventSitePractice2016/resources/js/userIdScript.js"></script>
	
	<div class="homePageContainer"> 
		<div id = "hero"></div>
		<div class ="container">		
			<h1 id="create" > CREATE & DISCOVER </h1>
			<h2 id= "events"> Events based on your interests </h2>
			<div class="box"> 
				<div id="searchbox">  <img class = "lupa" src="resources\images\lupa.png">
					<input type= "text" name = "search" placeholder = "Search">
				</div>
				<nav>
					<ul class = "menu">
						<li class="last active"><a id="rounded" class="limenu" href="../EventSitePractice2016/myEvents?userId="><div style="transform: skew(15deg)"><span class="small-text">view</span>MY ЕVENTS</div></a></li>
						<li><a class="limenu" href="../EventSitePractice2016/interests"><div style="transform: skew(15deg)"><span class="small-text">check</span>INTERESTS</div></a></li>
						<li><a class="limenu" href="#location"><div style="transform: skew(15deg)"><span class="small-text">events</span>LOCATIONS</div></a></li>
						<li class = "calendar" ><a  href="../EventSitePractice2016/"><div style="transform: skew(15deg)"><span class="small-text">view</span>CALENDAR</div></a></li>
					</ul>
				</nav>
			</div>
		</div>

		<div class="myEvents">
		
			<% List<Event> events = (List) request.getAttribute("events"); %>
			<% for (Event event: events) { %>
				<div class="event">
					<div id="eventFirstPart">
						<% long timestampDate = event.getDate().getTime(); %>
						<% Calendar calDate = Calendar.getInstance(); %>
						<% calDate.setTimeInMillis(timestampDate); %>
						<p class="eventDate month"> <%= new SimpleDateFormat("MMM", Locale.ENGLISH).format(calDate.getTime()).toUpperCase() %> </p>
						<p class="eventDate day"> <%= calDate.get(Calendar.DAY_OF_MONTH) %> </p>
						
						<% if (event.getEndDate() != null) { %>
							<% long timestampEndDate = event.getEndDate().getTime(); %>
							<% Calendar calEndDate = Calendar.getInstance(); %>
							<% calEndDate.setTimeInMillis(timestampEndDate); %>
							<% if (calDate.get(Calendar.DAY_OF_MONTH) != calEndDate.get(Calendar.DAY_OF_MONTH)) { %>
								<hr class="eventDateLine"/>
								<p class="eventDate month"> <%= new SimpleDateFormat("MMM", Locale.ENGLISH).format(calEndDate.getTime()).toUpperCase() %> </p>
								<p class="eventDate day"> <%= calEndDate.get(Calendar.DAY_OF_MONTH) %> </p>
							<% } %>
						<% } %>
					</div>
					<div id="eventSecondPart">
						<div id="eventThirdPart">
						</div>
						<div id="eventFourthPart">
							<p class="eventTitle"> <%= event.getTitle() %> </p>
							<p class="eventLocation"> <img src="resources/images/pin.png" class="eventPin"/> <%= event.getLocation() %> </p>
							<p class="eventTime"> &#128344; <%= new SimpleDateFormat("HH:mm").format(calDate.getTime()) %> </p>
							
							<a href="../EventSitePractice2016/UpdateEvent/<%=event.getId()%>" class="eventEdit">Edit The Event</a>
							<a href="../EventSitePractice2016/Event/<%=event.getId()%>" class="eventLink">&rarr; View Event Details</a>
						</div>
					</div>
				</div>
			<% } %>
			
		</div>
			
	</div>
			
<jsp:include page="footer.jsp"/>