function ready(callback) {
    if (document.readyState != 'loading') callback();
    else if(document.addEventListener) document.addEventListener('DOMContentLoaded',callback);
    else document.attachEvent('onreadystatechange', function () {
           if (document.readyState == 'complete') callback();
        });
}

ready(function () {



});
