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
  write_cookie('accepted', true, "/");
  document.location = "/EventSitePractice2016/";
}

function read_cookie (key, skips)
{
    if (skips == null)
            skips = 0;
    var cookie_string = "" + document . cookie;
    var cookie_array = cookie_string . split ("; ");

    for (var i = 0; i < cookie_array . length; ++ i)
    {
        var single_cookie = cookie_array [i] . split ("=");
        if (single_cookie . length != 2)
            continue;
        var name  = unescape (single_cookie [0]);
        var value = unescape (single_cookie [1]);
        if (key == name && skips -- == 0)
            return value;
        }
    return null;
}

function write_cookie (name, value, path)
{
    var expiration_date = new Date ();
    expiration_date . setYear (expiration_date . getYear () + 1);
    expiration_date = expiration_date . toGMTString ();
    var cookie_string = escape (name) + "=" + escape (value) +
            "; expires=" + expiration_date;
    if (path != null)
            cookie_string += "; path=" + path;
    document . cookie = cookie_string;
}

function checkCookie() {
	var accepted = read_cookie("accepted");
    if (accepted == null && document.location.pathname.indexOf('license') < 0) {
		document.location = "/EventSitePractice2016/license/";
    }
}

checkCookie();
