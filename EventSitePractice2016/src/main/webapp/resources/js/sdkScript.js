// initialize and setup facebook js sdk
window.fbAsyncInit = function() {
	FB.init({
	  appId      : '139441019816215',
	  xfbml      : true,
	  version    : 'v2.6'
	});
	
	FB.getLoginStatus(function(response) {
		if (response.status === 'connected') {
			document.getElementById('status').innerHTML = 'We are connected.';
			document.getElementById('login').style.visibility = 'hidden';
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