<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.intrapractice.pojo.Event" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>

<link rel="stylesheet" type="text/css" href="resources/css/myEventsStyle.css">
<jsp:include page="header.jsp"/>
	
	<div class="myEvents">
	
		<% List<Event> events = (List) request.getAttribute("events"); %>
		<% for (Event event: events) { %>
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
						
						<a href="../EventSitePractice2016/UpdateEvent/<%=event.getId()%>" class="eventEdit">Edit The Event</a>
						<a href="../EventSitePractice2016/Event/<%=event.getId()%>" class="eventLink">&rarr; View Event Details</a>
					</div>
				</div>
			</div>
		<% } %>
		
	</div>
	
<jsp:include page="footer.jsp"/>