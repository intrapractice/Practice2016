// This example adds a search box to a map, using the Google Place Autocomplete
// feature. People can enter geographical searches. The search box will return a
// pick list containing a mix of places and predicted search terms.
function initialize() {
  var markers = [];
  var map = new google.maps.Map(document.getElementById('map-canvas'), {
    mapTypeId: google.maps.MapTypeId.ROADMAP
  });
  
  var defaultBounds = new google.maps.LatLngBounds(
      new google.maps.LatLng(-33.8902, 151.1759),
      new google.maps.LatLng(-33.8474, 151.2631));
  
  map.fitBounds(defaultBounds);
  // Create the search box and link it to the UI element.
  var input = document.getElementById('pac-input');
  map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
  var searchBox = new google.maps.places.SearchBox(input);
  // Listen for the event fired when the user selects an item from the
  // pick list. Retrieve the matching places for that item.
  $("#createForm").on("submit", function(e) {
    if(typeof searchBox.getPlaces() === "undefined" || searchBox.getPlaces().length() === 0) {
      $("#pac-input").css('border', '1px solid red');	
	  e.preventDefault();
    }
  });
  google.maps.event.addListener(searchBox, 'places_changed', function() {
    var place = searchBox.getPlaces()[0];
    $("#pac-input").css('border', '1px solid green');	
    if (typeof place === "undefined" || !place.geometry){
    	valid = false;
    	return; 
    }
    // If the place has a geometry, then present it on a map.
    if (place.geometry.viewport) {
    	  
      map.fitBounds(place.geometry.viewport);
    } else {
    
      map.setCenter(place.geometry.location);
      map.setZoom(17);
    }
    
    new google.maps.Marker({
        map: map,
        title: place.name,
        position: place.geometry.location
      });
  });
  // Bias the SearchBox results towards places that are within the bounds of the
  // current map's viewport.
  google.maps.event.addListener(map, 'bounds_changed', function() {
    var bounds = map.getBounds();
    searchBox.setBounds(bounds);
  });
}

google.maps.event.addDomListener(window, 'load', initialize);