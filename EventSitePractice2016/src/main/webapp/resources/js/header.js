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
});