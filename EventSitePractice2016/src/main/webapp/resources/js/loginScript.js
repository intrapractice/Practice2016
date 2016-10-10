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

function acceptLicenseAgreement() {
  console.log('accepted!');
  setCookie('accepted', true, 1);
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function checkCookie() {
    var accepted = getCookie("accepted");
    if (accepted == "" && document.location.pathname.indexOf('license') < 0) {
      document.location = "/EventSitePractice2016/license/";
    }
}

checkCookie();