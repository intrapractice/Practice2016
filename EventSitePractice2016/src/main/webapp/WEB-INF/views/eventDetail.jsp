<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.intrapractice.pojo.Event" %>
<%@ page import="com.intrapractice.pojo.User" %>
<%@ page import="java.util.List" %>

<jsp:include page="header.jsp" />
<% Event event = (Event) request.getAttribute("event");
System.out.println("event in jsp is"+event);
%>
<script>
var curEventId = <%=event.getId()%>;
</script>
<script type="text/javascript" src="/EventSitePractice2016/resources/js/eventDetailsScript.js"></script>
<div class="eventDetailsPageV">
 <div id="photo"></div>
	    <div class="container">
		  <h1><%=event.getTitle()%></h1>
		    <div class="col-xs-12 col-md-8 upleftcol">
			  <div class="duration">
			    <div class="month">jun jul</div>
				<div class="se-dates">25 - 01</div>
				<div class="start-end">start end</div>
			  </div>
			  <div class="heartImage">
				<input type="hidden" id="eventId" value="<%=event.getId()%>"/>
				<span id="hearticon">&#x2764;</span>
				<span id="favmsg">Mark as favorite</span>
			  </div>
		    </div>
			  <div class="col-xs-12 col-md-4 ml2">
		        <div class="join">
			      <a href="#joinmsg" class="button">Join the event</a>
			    </div>
		      </div>
			  
			    <div class="col-xs-12 col-md-8 leftcol">
				  <div class="host">
				    <h2><img id="userPicture" style="transform: skew(0deg);" src="http://gravatar.com/avatar/a81ed73040d354ca940a27c64001364a?d=mm&s=50&r=G"/><%=event.getOwner().getName()%></h2>
					<p style="color: lightgrey; font-size: 1em; line-height: 0em;">host</p>
				  </div>
				    <div class="desc">
					  <h4 id="dtitle">Description</h4>
					  <p><%=event.getDescription()%></p>
					</div>
				</div>
				
				  <div class="col-xs-12 col-md-4 rightcol ml2">
				    <p><img id="pin" src="/EventSitePractice2016/resources/images/pin.png"><%=event.getLocation()%></p>
					  <input type"hidden" value="<%=event.getLocation()%>" id="pac-input"/>
					  <div id="map-canvas" ></div>
    					<div id="capture"></div>
					  <div class="datetimes">
					    <div class="dates-l">
					      <p>start date</p>
						  <h6 id="startdate">25.06.2016</h6>
						  <p>end date</p>
						  <h6 id="enddate">01.07.2016</h6>
						</div>
					  </div>
				  </div>
				  
				    

<div class="col-xs-12 col-md-4 participants">
					  <div class="going">
					    <h4 id="gtitle">Going to the event</h4>
						<ul id="participants">
						<li><%=event.getOwner().getName()%></li>
<%
if(event.getParticipants()!=null){
for(User participant: event.getParticipants()){
%>
						  <li><%=participant.getName()%></li>
						  
<%}}%>
						</ul>
					  </div>
					</div>
</div>
</div>
<jsp:include page="footer.jsp" />