// initialize and setup facebook js sdk
var email;
window.fbAsyncInit = function() {
	FB.init({
	  appId      : '139441019816215',
	  xfbml      : true,
	  version    : 'v2.6'
	});

	FB.getLoginStatus(function(response) {
		if (response.status === 'connected') {
            var accepted = read_cookie("accepted");
			if (accepted == null) {
				document.location = "/EventSitePractice2016/license/";
		    }
			FB.api('/me', 'GET', {fields: 'email,first_name,last_name,name,id'}, function(response) {
				var fbName = response.name;
				email = response.email;
				$.getJSON( '/EventSitePractice2016/getCurrentUser?token='+response.id)
				  .done(function( json ) {
				    	window.userJSON = json;
				    	window.user=json.id;
				    	$("#hiddenForm").val(window.user);
				    	if(window.location.pathname.indexOf("interests")>-1){
				    		setLikedCategories();
				    	}
				    	if(window.location.pathname.indexOf("/Event/")>-1){
				    		setLikedEvents();
				    	}
				  })
				  .fail(function( jqxhr, textStatus, error ) {
					  console.log("error occured");
				});


				$('.navbar #user').html(fbName);
				$('#usercontainer #user').html(fbName);
			    var userId = response.id;
				FB.api(
				"/"+userId+"/picture",
				function (response) {
				  if (response && !response.error) {
					var pictureURL = response.data.url;
					$('.navbar #userPicture').attr("src", pictureURL);
					$('#userDrop').attr("src", pictureURL);
				  }
				});
			});
		} else {
			document.location = "/EventSitePractice2016/login/";
		}
	});
};

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

(function(d, s, id){
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {return;}
	js = d.createElement(s); js.id = id;
	js.src = "https://connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
