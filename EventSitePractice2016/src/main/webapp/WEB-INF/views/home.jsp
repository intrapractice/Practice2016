<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.intrapractice.pojo.Event" %>
<%@ page import="java.util.List" %>
<html>
    <head>
        <title>Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="resources/homePageStyle.css">
    </head>
    <body background="resources/images/ocean.jpg">
        <ul>
			<li><a  href="#home" id="logo"><img src="resources/images/logoButton.jpg"></a></li>
			<li><a href="#home"><font style="font-family:Buxton Sketch">Home</font></a></li>
			<li><a href="CreateEvent"><font style="font-family:Buxton Sketch">Create Event</font></a></li>
		</ul>
		<br><br><br>
        <% List<Event> events = (List) request.getAttribute("events"); %>
        <%int count=0; %>
        <% for (Event event: events) {%>
				<section>
					<code><span style="background-color: rgba(0,0,0,0.5)"><h3 style="font-weight: bold;"><%=event.getTitle() %></h3></span></code>
				</section>
				<% if(count==2) {%>
					<br><br>
					<%count=0;} %>
		<%}%>
		
		
		
    </body>
</html>
