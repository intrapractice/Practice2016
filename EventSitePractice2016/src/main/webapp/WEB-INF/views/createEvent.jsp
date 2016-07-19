<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp" />
<div align="center">
    <% if((boolean) request.getAttribute("error")){ %>
    <div class="error">Error Creating or Updating Event!</div>
    <% } %>
  <form:form id="createForm" action='<%=(String) request.getAttribute("formURL")%>' method="post" modelAttribute="events" accept-charset="utf-8">
    <table>
    <tr>    
      <td>Event name:</td>
      <td> <form:input type="text" id="title" name="title" placeholder="Add short, clear name" pattern="[0-9a-zA-Z][a-zA-Z0-9.,!\-\"?_&@+*#%\s]{1,100}" required="required" path="title"/> </td>
    </tr>
    <tr>
    <td>Description: </td>
	 <td><form:input type="text" id="description" placeholder="Add description"  path="description"/></td>
	</tr>	
	<tr>
    <td>Date: </td>
	 <td><form:input type="text" id="date" name="calendar" placeholder="YYYY-MM-DD" pattern= "(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" required="required" path="date"/></td>
	</tr>
	<tr>
    <td>End date: </td>
	 <td><form:input type="text" id="endDate" name="calendar" placeholder="YYYY-MM-DD" pattern= "(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" required="required" path="endDate"/></td>
	</tr>
    <tr>
    <td colspan="2"> 
    <form:input id="pac-input" class="controls" type="text" name="place" required="required" placeholder="Search Box" path="location"/>
    <div id="map-canvas" style="width: 500px; height: 400px"></div>
    <div id="capture"></div>
    </td>
    </tr>
    <tr> 
     <td><input type = "submit" value="Save"></td>
    </tr>  
    </table>
  </form:form>
</div>
<jsp:include page="footer.jsp" />