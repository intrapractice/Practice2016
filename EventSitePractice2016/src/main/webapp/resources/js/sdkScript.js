// initialize and setup facebook js sdk
var email;
var user;
window.fbAsyncInit = function() {
	FB.init({
	  appId      : '139441019816215',
	  xfbml      : true,
	  version    : 'v2.6'
	});
	
	FB.getLoginStatus(function(response) {
		if (response.status === 'connected') {
			FB.api('/me', 'GET', {fields: 'email,first_name,last_name,name,id'}, function(response) {
				var fbName = response.name;
				$('.navigation #user').html(fbName);
				email = response.email;
				$.get("/EventSitePractice2016/getCurrentUser", function(data){
					user = data;
					console.log(user);
				});
				//TODO: jquery get call to get user object
				//if event id in user eventlikes red heart otherwise white heart
			});
		} else {
			document.location = "/EventSitePractice2016/login/";
		}
	});
};

(function(d, s, id){
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {return;}
	js = d.createElement(s); js.id = id;
	js.src = "https://connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));