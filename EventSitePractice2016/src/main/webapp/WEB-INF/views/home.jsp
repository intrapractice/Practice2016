<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.intrapractice.pojo.Event" %>
<%@ page import="java.util.List" %>

<jsp:include page="header.jsp" />
<link rel="stylesheet" type="text/css" href="/EventSitePractice2016/resources/css/homePageStyle.css">
<link rel="stylesheet" type="text/css" href="/EventSitePractice2016/resources/css/style.css">
        <% List<Event> events = (List) request.getAttribute("events");
        int count=0;
        for (Event event: events) {%>
				<section>
					<code>
					<%= event.getEventStatus() %>
					<span style="background-color: rgba(0,0,0,0.5)"><h3 style="font-weight: bold;"><%=event.getTitle() %></h3></span>
					</code>
				</section>
				<% if(count==2) {%>
					<br><br>
					<%count=0;} %>
		<%}%>
<jsp:include page="footer.jsp" />
   
