<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.intrapractice.pojo.Category"%>
<%@ page import="com.intrapractice.pojo.User"%>
<%@ page import="java.util.List"%>
<link rel="stylesheet" type="text/css" href="/EventSitePractice2016/resources/css/interests.css">
<jsp:include page="header.jsp" />

<script>
function likeCategory(categoryId) {
    var userId = window.user;
    this.categoryId = categoryId; 
    $.ajax({
        type:"POST",
        cache:false,
        url:"/EventSitePractice2016/likeCategory?categoryId="+ categoryId+"&userId="+userId,
        success: function (html) {
        }
      });
}

function unlikeCategory(categoryId) {
	var userId = window.user;
	this.categoryId = categoryId;
	 $.ajax({
	        type:"POST",
	        cache:false,
	        url:"/EventSitePractice2016/unlikeCategory?categoryId="+ categoryId+"&userId="+userId,
	        success: function (html) {
	        }
   });
}

</script>
<script>
function setLikedCategories(){
	var liked = window.userJSON.likedCategories;
    for(index in liked){
        var categoryLength = $(".category"+liked[index]).length;
        if(categoryLength > 0){
            $(".category"+liked[index]).attr('src', "resources/images/redHeart.png")
        }
    }
}
	$(document).ready(function() {
		$("button").click(function() {
			var src = $(this).find("img").attr('src');
			if (src.indexOf("greyHeart") > 0) {
				$(this).find("img").attr('src', 'resources/images/redHeart.png');
				var categoryId = $(this).find("input").val();
				likeCategory(categoryId);
			} else {
				var categoryId = $(this).find("input").val();
				$(this).find("img").attr('src', 'resources/images/greyHeart.png');
				unlikeCategory(categoryId);
			}
		});

	});
</script>

	
		   
<div class="homePageContainer"> 
	<img id = "hero" src ="resources\images\hero_img.jpg">	
    <div class = "preview"> 
   	</div>
  	<div class ="container">		
		<h1 id="create" > CREATE & DISCOVER </h1>
		<h2 id= "events"> Events based on your interests </h2>
   		<div class="box"> 
     		<div id="searchbox">  <img class = "lupa" src="resources\images\lupa.png">
      			<input type= "text" name = "search" placeholder = "Search">
      		</div>
     		<nav>
        		<ul class = "menu">
          			<li class="last"><a id= "rounded" class="limenu" href="../EventSitePractice2016/myEvents"><div style="transform: skew(15deg)">MY ЕVENTS</div></a></li>
         			<li class = "active"><a class="limenu" href="../EventSitePractice2016/interests"><div style="transform: skew(15deg)">INTERESTS</div></a></li>
           			<li><a class="limenu" href="#location"><div style="transform: skew(15deg)">LOCATIONS</div></a></li>
            		<li class = "calendar" ><a  href="../EventSitePractice2016/" ><div style="transform: skew(15deg)">CALENDAR</div></a></li>
          		</ul>
       		</nav>
    	</div>
     </div>
		    
	<div class="mainContainerHristiyan">
	
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
					<img class="heartImage category<%=category.getId()%>" src="resources/images/greyHeart.png" />
				</button>
				<img class="categoryImage" src=<%=image %> id="relativePosition" />
			</div>
			<div class="categoryName" align="center"><%=category.getTitle()%></div>
		</div>
		<%
			}
		%>

	</div>
	
</div>	

<jsp:include page="footer.jsp" />
