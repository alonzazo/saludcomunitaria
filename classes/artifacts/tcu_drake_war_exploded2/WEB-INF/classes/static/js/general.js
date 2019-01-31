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

ready(function(){
    const docStyle = document.documentElement.style
    const navOptionElem = document.querySelectorAll('.nav-option')

    navOptionElem.forEach(elem => {
        const boundingClientRect = elem.getBoundingClientRect()

        elem.onmousemove = function(e) {

            const x = e.clientX - boundingClientRect.left

            const xc = boundingClientRect.width/2

            const dx = x - xc

            if (elem.classList.contains('nav-option-selected')){
                elem.style.setProperty('background', `linear-gradient(${ dx/-1 }deg,#222222, #444444)`)
            } else {
                elem.style.setProperty('background', `linear-gradient(${ dx/-1 }deg,#999999, #bbbbbb)`)
            }


        }

        elem.onmouseleave = function (e) {
            if (elem.classList.contains('nav-option-selected')){
                elem.style.setProperty('background', '#444444')
            }else {
                elem.style.setProperty('background', `#bbbbbb`)
            }

        }
    })

    const loginButton = document.querySelector('login-box');

    loginButton.on(
        onclick, function (e) {
            var
        }
    );

});
