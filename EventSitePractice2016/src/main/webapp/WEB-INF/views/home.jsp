<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.intrapractice.pojo.Event" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:main>
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
</template:main>
