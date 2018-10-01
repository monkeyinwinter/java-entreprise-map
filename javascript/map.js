jQuery.noConflict();

(function ($) {

    var _leafletTileProvider = 'https://server.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer/tile/{z}/{y}/{x}';
    var _leafletAttribution = 'Tiles &copy; Esri &mdash; Source: Esri, DeLorme, NAVTEQ, USGS, Intermap, iPC, NRCAN, Esri Japan, METI, Esri China (Hong Kong), Esri (Thailand), TomTom, 2012';

    function buildMap(data) {
        // Create leaflet map object.
        var map = L.map('map', {});
        var points = [];

        // Define layer.
        L.tileLayer(_leafletTileProvider, {
            attribution: _leafletAttribution,
            maxZoom: 18
        }).addTo(map);

        // Display all entreprises as marker.
        $.each(data, function(key, entreprise) {
            // console.log(entreprise);
            coord = entreprise.coord; //[39.61, -105.02];
            L.marker(coord).bindPopup(entreprise.name).addTo(map);
            points.push(coord);
        });

        // Fit map to bounds.
        var bounds = new L.LatLngBounds(points);
        map.fitBounds(bounds);
    }

    $(document).ready(function () {
        $.getJSON($('#map').data('src'), buildMap);
    });

}(jQuery));