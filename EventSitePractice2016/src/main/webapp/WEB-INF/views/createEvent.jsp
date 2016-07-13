<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New/Edit Event</title>
<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
<div align="center">
    <% if((boolean) request.getAttribute("error")){ %>
    <div class="error">Error Creating Event!</div>
    <% } %>

  <form:form action="/EventSitePractice2016/CreateEvent" method="post" modelAttribute="events">
    <table>
	<tr>	
          <td>Event name:</td>
	  <td> <form:input type="text" id="title" name="title" placeholder="Add short, clear name"  path="title"/> </td>
	</tr>
	<tr>
    <td>Description: </td>
	 <td><form:input type="text" placeholder="Add description"  path="description"/></td>
	</tr>	
	<tr>
    <td>Data: </td>
	 <td><form:input type="text" name="calendar" placeholder="yyyy/mm/dd"  path="date"/></td>
	</tr>
	<tr>
	 <td>Location: </td>
	 <td><form:input type="text" name="place" placeholder="Add a location"  path="location"/> </td>
	</tr>
	<tr> 
	 <td><input type = "submit" value="Save"></td>
	</tr>  
    </table> 
	 
  </form:form>
</div>
</body>
</html>