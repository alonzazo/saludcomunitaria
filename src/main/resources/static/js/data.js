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
});
