<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.intrapractice.pojo.Event" %>
<%@ page import="java.util.List" %>
<html>
    <head>
        <title>Home</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type="text/css">
	
			ul {	
				list-style-type: none;
				margin: 0;
				padding: 0;  
				width:100%;
				height:46px;
				background-color: #555;
			}
			li {
				float: left;
			}
			li a {
				display:block;
				color:white;
				text-align:center;
				padding: 14px 16px;
				text-decoration:none;	
			}
			li #logo{
				padding: 0;
			}	
			li a:hover {
				background-color:#111;
			}
			.active {
				background-color: #4CAF50;
			}
			
			code {
				 background-image:url("resources/images/meetingNoImage.jpg");
				  border-radius: 6px;
				  color: #fff;
				  display: block;
				  font: 38px/0px Times New Roman,"Source Code Pro", Inconsolata, "Lucida Console", Terminal, "Courier New", Courier;
				  padding: 24px 15px;
				  text-align: center;
				  background-size:300px;
				  background-repeat:no-repeat;
				  background-position-y:20%;
				  letter-spacing: .1em;
			}
			header,
			section,
			aside,
			footer {
					margin: 0 1.5% 24px 1.5%;
			}
			section {
				display: inline-block;
				width: 30%;
			}
			footer {
				margin-bottom: 0;
			}
			
		</style>
    </head>
    <body background="resources/images/ocean.jpg">
        <ul>
			<li><a  href="#home" id="logo"><img src="resources/images/logoButton.jpg"></a></li>
			<li><a href="#home"><font style="font-family:Buxton Sketch">Home</font></a></li>
			<li><a href="#createEvent"><font style="font-family:Buxton Sketch">Create Event</font></a></li>
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
