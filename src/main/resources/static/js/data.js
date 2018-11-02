function ready(callback){
    // in case the document is already rendered
    if (document.readyState!='loading') callback();
    // modern browsers
    else if (document.addEventListener) document.addEventListener('DOMContentLoaded', callback);
    // IE <= 8
    else document.attachEvent('onreadystatechange', function(){
            if (document.readyState=='complete') callback();
        });
}

ready(function () {
    mapboxgl.accessToken = 'pk.eyJ1IjoiYWxvbnphem8iLCJhIjoiY2puZnVtOTVxMWkyMTNsbzdqdGF3NmF2ZCJ9.XV9WSeYRUQypS9wbVjP38A';
    var map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/alonzazo/cjnfv9mg43eri2so4o8onrzcp',
        center: [-83.67,8.69], // starting position [lng, lat]
        zoom: 14
    });

    map.on('click', function(e){
        var features = map.queryRenderedFeatures(e.point, {
            layers: ['boundaries']
        });

        if (!features.length) {
            return;
        }

        var feature = features[0];

        var popup = new mapboxgl.Popup({ offset: [0, -15] , className:'popup-map'})
            .setLngLat(JSON.parse(feature.properties.coordinates))
            .setHTML('<h3>' + feature.properties.name + '</h3>' +
                '<p> Agua: ' + feature.properties.aguas + '</p>' +
                '<p> Frecuencia: ' + feature.properties.frecuencia + '</p>' +
                '<p> Porcentaje: ' + feature.properties.porcentaje + '</p>')
            .setLngLat(JSON.parse(feature.properties.coordinates))
            .addTo(map);
    });

    // Center the map on the coordinates of any clicked symbol from the 'symbols' layer.
    map.on('click', 'boundaries', function (e) {
        map.flyTo({center: JSON.parse(e.features[0].properties.coordinates)});
    });

    // Change the cursor to a pointer when the it enters a feature in the 'symbols' layer.
    map.on('mouseenter', 'boundaries', function () {
        map.getCanvas().style.cursor = 'pointer';
    });

    // Change it back to a pointer when it leaves.
    map.on('mouseleave', 'boundaries', function () {
        map.getCanvas().style.cursor = '';
    });
});
