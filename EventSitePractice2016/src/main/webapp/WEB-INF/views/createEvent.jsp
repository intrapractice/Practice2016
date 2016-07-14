<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New/Edit Event</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div align="center">
    <% if((boolean) request.getAttribute("error")){ %>
    <div class="error">Error Creating or Updating Event!</div>
    <% } %>

  <form:form action='<%=(String) request.getAttribute("formURL")%>' method="post" modelAttribute="events">
    <table>
	<tr>	
          <td>Event name:</td>
	  <td> <form:input type="text" id="title" name="title" placeholder="Add short, clear name" pattern="[0-9a-zA-Z][a-zA-Z0-9.,!\-\"?_&@+*#%\s]{1,100}" path="title"/> </td>
	</tr>
	<tr>
    <td>Description: </td>
	 <td><form:input type="text" id="description" placeholder="Add description"  path="description"/></td>
	</tr>	
	<tr>
    <td>Date: </td>
	 <td><form:input type="text" id="date" name="calendar" placeholder="YYYY-MM-DD" pattern= "(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" path="date"/></td>
	</tr>
	<tr>
    <td>End date: </td>
	 <td><form:input type="text" id="endDate" name="calendar" placeholder="YYYY-MM-DD" pattern= "(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" path="endDate"/></td>
	</tr>
	<tr>
	 <td>Location: </td>
	 <td><form:input type="text" id="location" name="place" placeholder="Add a location"  path="location"/> </td>
	</tr>
	<tr> 
	 <td><input type = "submit" value="Save"></td>
	</tr>  
    </table> 
	 
  </form:form>
</div>
</body>
</html>