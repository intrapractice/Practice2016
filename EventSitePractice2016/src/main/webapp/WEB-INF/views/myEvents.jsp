<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.intrapractice.pojo.Event" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
		
<html>
    <head>
		<title>My Events</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="resources/css/myEventsStyle.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
		<script src="resources/js/sdkScript.js"></script>
    </head>
	<body> 
	
	<div class="myEvents">
	
		<% List<Event> events = (List) request.getAttribute("events"); %>
		<% for (Event event: events) { %>
			<% if (event.getOwner().getId() == 6) { %>
				<div class="event">
					<div id="eventFirstPart">
						<% long timestampDate = event.getDate().getTime(); %>
						<% Calendar calDate = Calendar.getInstance(); %>
						<% calDate.setTimeInMillis(timestampDate); %>
						<p class="eventDate month"> <%= new SimpleDateFormat("MMM").format(calDate.getTime()).toUpperCase() %> </p>
						<p class="eventDate day"> <%= calDate.get(Calendar.DAY_OF_MONTH) %> </p>
						
						<% if (event.getEndDate() != null) { %>
							<% long timestampEndDate = event.getEndDate().getTime(); %>
							<% Calendar calEndDate = Calendar.getInstance(); %>
							<% calEndDate.setTimeInMillis(timestampEndDate); %>
							<% if (calDate.get(Calendar.DAY_OF_MONTH) != calEndDate.get(Calendar.DAY_OF_MONTH)) { %>
								<hr class="eventDateLine"/>
								<p class="eventDate month"> <%= new SimpleDateFormat("MMM").format(calEndDate.getTime()).toUpperCase() %> </p>
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
							
							<a href="#event" class="noUnderline"><p class="eventLink">&rarr; View Event Details</p></a>
						</div>
					</div>
				</div>
			<% } %>
		<% } %>
		
	</div>
	
    </body>
</html>