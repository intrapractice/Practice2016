<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.intrapractice.pojo.Category" %>
   <%@ page import="java.util.List" %>
   <%@ page import="java.lang.Boolean" %>

<jsp:include page="header.jsp" />

    <form:form id="createForm"
     action='<%=(String) request.getAttribute("formURL")%>' method="post" modelAttribute="events" accept-charset="utf-8">
   <div class="mainCont">  
    <% if((boolean) request.getAttribute("error")){ %>
    <div class="error">Error Creating or Updating Event!</div>
    <% } %>
    <div class="title">  CREATE AN EVENT  </div>
    <div class="firstCont">
    <form:input type="text" placeholder="  Event Tittle*" id = "textbox" pattern="[0-9a-zA-Z][a-zA-Z0-9.,!\-\"?_&@+*#%\s]{1,100}" required="required" path="title"/>
    <span id="span">Recommended number of characters: 120 </span>
    <form:textarea type="text" placeholder=" Description*" id = "textarea" path="description"/> </textarea>
        <span id="spanLoc">CHOOSE A LOCATION* </span>
    <form:input id="pac-input" class="controls" type="text" name="place" required="required" placeholder="Search Box" path="location"/>
    <div id="map-canvas" ></div>
    <div id="capture"></div>
    </div>
    <div  class="secondCont">
        <span id="chooseDate">CHOOSE A DATE* </span>
        <form:input type="text" id="firstDate" class="flatpickr"  data-enableTime="true" data-time_24hr="true" placeholder="START DATE*" path="date"/>
        <form:input type="text" id="secondDate" class="flatpickr"  data-enableTime="true" data-time_24hr="true" placeholder="END DATE*" path="endDate"/> 
        <span id="catEvent">CATEGORIZE THE EVENT* </span>
        
        <div id="checkDiv">
        <input type="checkbox" id="checkbox" />  <label>MARK THE EVENT AS ONLINE</label> 
        </div>
        <span id="smallText">no location needed</span>
        <% List<Category> categories = (List) request.getAttribute("categories"); %>
        <form:select class="selectpicker" path="categoryId">
        <option disabled selected>Please Choose...</option>
        <% for (Category category: categories) {%>
        <form:option value="<%= category.getId()%>">
        <%= category.getTitle() %>
        </form:option>
        <% } %>
        </form:select>
        
        <form:hidden id="hiddenForm"  path="userId"></form:hidden>
        
        <span id="addCat">ADD CATEGORY </span>
        <input type="text" placeholder="  Enter name of category" id = "textboxCat" />
        <input type="button" onclick="createCategory()" id="buttonRemove">ADD</input>
        
        
    </div>  
</div>
    <span id="bottomText">All fields marked with * are mandatory.</span>
    <hr id="line">
    <div id="buttons">
    <button id="cancel">CANCEL</button> 
    <button id="preview">PREVIEW</button> 
    <button type="submit" id="button">CREATE</button> 
    </div>
    </form:form>
    

        
<script src="/EventSitePractice2016/resources/js/calendar/calendar.js"></script>

<jsp:include page="footer.jsp" />
