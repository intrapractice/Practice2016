<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.intrapractice.pojo.Category"%>
<%@ page import="com.intrapractice.pojo.User"%>
<%@ page import="java.util.List"%>
<jsp:include page="header.jsp" />
<link rel="stylesheet" type="text/css" href="/EventSitePractice2016/resources/css/interests.css">
<script>
    var currentUser;
	$(document).ready(function() {
		 
		$("button").click(function() {
			var src = $(this).find("img").attr('src');
			if (src.indexOf("greyHeart") > 0) {
				$(this).find("img").attr('src', 'resources/images/redHeart.png');
				var categoryId = $(this).find("input").val();
				console.log(categoryId);
				console.log(window.user);
			} else {
				$(this).find("img").attr('src', 'resources/images/greyHeart.png');
			}
		});

	});
</script>

	<div class="mainContainer">
	
		<%
			List<Category> categories = (List) request.getAttribute("categories");
		%>
  		<%   String image=null;
			for (Category category : categories) {
				if(category.getTitle().equals("Photography")) {
				    image= "resources/images/interest1.jpg";
				}else if(category.getTitle().equals("Music")) {
					image = "resources/images/interest2.jpg";
				}else if(category.getTitle().equals("Motor sports")) {
                    image = "resources/images/interest3.jpg";
                }else if(category.getTitle().equals("Sport")) {
                    image = "resources/images/interest4.jpg";
                }else if(category.getTitle().equals("Learning")) {
                    image = "resources/images/interest5.jpg";
                }else if(category.getTitle().equals("Technology")) {
                    image = "resources/images/interest6.jpg";
                }else if(category.getTitle().equals("For children")) {
                    image = "resources/images/interest7.jpg";
                }else if(category.getTitle().equals("Business")) {
                    image = "resources/images/interest8.jpg";
                }else if(category.getTitle().equals("BBQ")) {
                	image = "resources/images/interest9.jpg";
                }else image = "resources/images/interestDefault.jpg";
		%>
		
		<div class="otherContainer">
			<div id="relativePosition">
				<button name="button" class="heartImage" id="absolutePosition"
					onClick="">
					<input type="hidden" value="<%=category.getId()%>"/>
					<img class="heartImage" src="resources/images/greyHeart.png" />
				</button>
				<img class="categoryImage" src=<%=image %> id="relativePosition" />
			</div>
			<div class="categoryName" align="center"><%=category.getTitle()%></div>
		</div>
		<%
			}
		%>

	</div>

<jsp:include page="footer.jsp" />
