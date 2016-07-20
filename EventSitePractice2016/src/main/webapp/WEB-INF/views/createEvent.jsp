<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.intrapractice.pojo.Category" %>
   <%@ page import="java.util.List" %>
   <%@ page import="java.lang.Boolean" %>

<jsp:include page="header.jsp" />

<link rel="stylesheet" type="text/css" href="/EventSitePractice2016/resources/css/CreateEventStyle.css">


    <div class="createEventClass">
    <form:form id="createForm"
     action='<%=(String) request.getAttribute("formURL")%>' method="post" modelAttribute="events" accept-charset="utf-8">
   <div class="mainCont">  
    <% if((boolean) request.getAttribute("error")){ %>
    <div class="error">Error Creating or Updating Event!</div>
    <% } %>
    <div class="title">  CREATE/EDIT AN EVENT  </div>
    <div class="firstCont">
    <form:input type="text" placeholder="  Event Tittle*" id = "textbox" pattern="[0-9a-zA-Z][a-zA-Z0-9.,!\-\"?_&@+*#%\s]{1,100}" required="true" path="title"/>
    <span id="span">Recommended number of characters: 120 </span>
    <form:textarea type="text" placeholder=" Description*" id = "textarea" path="description" required="true"/> </textarea>
        <span id="spanLoc">CHOOSE A LOCATION* </span>
    <form:input id="pac-input" class="controls" type="text" name="place" required="true" placeholder="Search Box" path="location"/>
    <div id="map-canvas" ></div>
    <div id="capture"></div>
    </div>
    <div  class="secondCont">
        <span id="chooseDate">CHOOSE A DATE* </span>
        <form:input type="text" id="firstDate" class="flatpickr"  data-enableTime="true" data-time_24hr="true" placeholder="START DATE*" required="true" path="date"/>
        <form:input type="text" id="secondDate" class="flatpickr"  data-enableTime="true" data-time_24hr="true" placeholder="END DATE*" required="true" path="endDate"/> 
        <span id="catEvent">CATEGORIZE THE EVENT* </span>
        
        <% List<Category> categories = (List) request.getAttribute("categories"); %>
        <form:select class="selectpicker" required="true"
         path="categoryId">
        <option disabled selected>Please Choose...</option>
        <% for (Category category: categories) {%>
        <form:option value="<%= category.getId()%>">
        <%= category.getTitle() %>
        </form:option>
        <% } %>
        </form:select>
        
        <form:hidden id="hiddenForm"  path="userId"></form:hidden>
        
        <span id="addCat">ADD CATEGORY </span>
        <input type="text" placeholder="  Enter name of category" id = "textboxCat" pattern="[0-9a-zA-Z][a-zA-Z0-9.,!\-?_&@+*#%\s]{1,100}" />
        <input type="button" onclick="createCategory()" id="buttonRemove" value="ADD">
    </div>  
</div>
    <span id="bottomText">All fields marked with * are mandatory.</span>
    <hr id="line">
    <div id="buttons">
    <button onclick="window.location='/EventSitePractice2016/'" id="cancel">CANCEL</button> 
    <button type="submit" id="button">SAVE</button> 
    </div>
    </form:form>
</div>
        
<script src="/EventSitePractice2016/resources/js/calendar/calendar.js"></script>

<jsp:include page="footer.jsp" />
