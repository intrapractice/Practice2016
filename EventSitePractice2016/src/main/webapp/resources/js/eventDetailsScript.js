function likeEvent(eventId) {
    var userId = window.user;
    this.eventId = eventId; 
    $.ajax({
        type:"POST",
        cache:false,
        url:"/EventSitePractice2016/likeEvent?eventId="+ eventId+"&userId="+userId,
        success: function (html) {
        }
      });
}

function unlikeEvent(eventId) {
	var userId = window.user;
	this.eventId = eventId;
	 $.ajax({
	        type:"POST",
	        cache:false,
	        url:"/EventSitePractice2016/unlikeEvent?eventId="+ eventId +"&userId="+userId,
	        success: function (html) {
	        }
   });
}
function setLikedEvents(){
	var liked = window.userJSON.likedEvents;
    for(index in liked){
        if(liked[index]==curEventId){
        	$("#hearticon").addClass("active");
			$("#favmsg").text("Favorite");
        }
    }
}

$(document).ready(function(){
	$("li#bute").on('mouseenter', function(){
		$(".userdropdown").show();
		$(".userdropdown").on('mouseenter', function(){
			$(this).show();
			$("li#bute").addClass("hovered");
			$("li#bute div").addClass("hovered");
			$("li#bute i").addClass("hovered");
			$("li#bute img").addClass("hovered");
		});
	});
	$(".userdropdown, li#bute").on('mouseleave', function(){
		$(".userdropdown").hide();
		$("li#bute").removeClass("hovered");
		$("li#bute div").removeClass("hovered");
		$("li#bute i").removeClass("hovered");
		$("li#bute img").removeClass("hovered");
	});
	$(".userdropdown").css('left', $("li#bute").offset().left);

	$(".heartImage").click(function() {
			if (!$("#hearticon").hasClass("active")) {
				$("#hearticon").addClass("active");
				var eventId = $("#eventId").val();
				$("#favmsg").text("Favorite");
				likeEvent(eventId);
			} else {
				$("#hearticon").removeClass("active");
				var eventId = $("#eventId").val();
				$("#favmsg").text("Mark as favorite");
				unlikeEvent(eventId);
			}
		});
	
});