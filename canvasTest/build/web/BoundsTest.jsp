<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8 />
<title>Using maxBounds to restrict map panning</title>
<meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />
<script src='https://api.mapbox.com/mapbox.js/v2.3.0/mapbox.js'></script>
<link href='https://api.mapbox.com/mapbox.js/v2.3.0/mapbox.css' rel='stylesheet' />
<style>
  body { margin:0; padding:0; }
  #map { position:absolute; top:0; bottom:0; width:100%; }
</style>
</head>
<body>


<div id='map'></div>

<script>
L.mapbox.accessToken = 'pk.eyJ1IjoiY2lhc2N1OTMiLCJhIjoiY2lscDU0aGxvMDAzbXY4bHUyZTVjYTV3NiJ9.kbtAc60uO-yBgaSQ78P0Jw';
// Construct a bounding box for this map that the user cannot
// move out of
var southWest = L.latLng(53.617215, -6.188311),
    northEast = L.latLng(53.61619,-6.18830167),
    bounds = L.latLngBounds(southWest, northEast);

var map = L.mapbox.map('map', 'mapbox.streets', {
    // set that bounding box as maxBounds to restrict moving the map
    // see full maxBounds documentation:
    // http://leafletjs.com/reference.html#map-maxbounds
    maxBounds: bounds,
    maxZoom: 19,
    minZoom: 10
});

// zoom the map to that bounding box
map.fitBounds(bounds);
   L.mapbox.featureLayer({
    // this feature is in the GeoJSON format: see geojson.org
    // for the full specification
    type: 'Feature',
    geometry: {
        type: 'Point',
        // coordinates here are in longitude, latitude order because
        // x, y is the standard for GeoJSON and many formats
        coordinates: [
         53.61644,
         -6.18824
        ]
    }
}).addTo(map);
</script>


</body>
</html>
