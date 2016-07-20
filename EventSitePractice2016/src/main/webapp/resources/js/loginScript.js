// initialize and setup facebook js sdk
window.fbAsyncInit = function() {
	FB.init({
	  appId      : '139441019816215',
	  xfbml      : true,
	  version    : 'v2.6'
	});
};

(function(d, s, id){
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {return;}
	js = d.createElement(s); js.id = id;
	js.src = "https://connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

// login with facebook with extra permissions
function login() {
	FB.login(function(response) {
		if (response.status === 'connected') {
			getInfo();
		} else {
			document.location = "/EventSitePractice2016/login/";
		}
	}, {scope: 'email'});
}

// getting basic user info and then posting
function getInfo() {
	FB.api('/me', 'GET', {fields: 'email,first_name,last_name,name,id'}, function(response) {
		$.post("/EventSitePractice2016/createUser?email=" + 
		response.email + "&name=" + response.name + "&token="+response.id, function(data){
			if (data==="true") {
				var successImage = "<img id='success' class='centered' src='../resources/images/successTick.jpg'>";
				$("#content").append(successImage);
			}
			setTimeout(function () {
					document.location = "/EventSitePractice2016/";
				},1000);
		});
	});
}