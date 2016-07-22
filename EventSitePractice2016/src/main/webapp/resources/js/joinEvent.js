

    function getJoinedEvents() {
	   var userId = window.user;
	   if(typeof userId !== "number") {
		   setTimeout(getJoinedEvents, 200);
		   return;
	   }
	   $.ajax({
			   type: "GET",
			   cache: false,
			   url: "/EventSitePractice2016/joinedEvents?userId=" + userId,
			   success: function(data) {
					var joined = JSON.parse(data);
					for(index in joined){
						var eventLength = $(".event"+joined[index]).length;
						if(eventLength > 0){
							$(".event"+joined[index]).text("Already joined");
						}
					}
				   
			   
				}
		   
		});
   }  

   function joinEvent(eventId) {
       var userId = window.user;
       this.eventId = eventId;
       $.ajax({
           type: "POST",
           cache: false,
           url: "/EventSitePractice2016/join?eventId="+eventId+"&userId="+userId,
           success: function(){
			   $(".event"+eventId).text("Already joined");
           }
           
       });
   }

   $(document).ready(function(){
       getJoinedEvents();
       $("button").click(function(){
           var eventId = $(this).find("input").val();
           joinEvent(eventId);
       })
   })
