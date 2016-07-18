<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.intrapractice.pojo.Event" %>
<%@ page import="com.intrapractice.pojo.User" %>
<%@ page import="java.util.List" %>

<% Event event = (Event) request.getAttribute("event");
//TODO: populate the page using event object
%>
<h1 id="eventTitle"><%= event.getTitle() %></h1>

<%
//TODO: list all participants in the event
for(User participant: event.getParticipants()){
%>


<%}%>