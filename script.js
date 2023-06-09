const menuitem = document.querySelector('#menu');

$(document).ready(function () {

    menuitem.addEventListener('click', () => {
        $(this).toggleClass('.fa-times');
        document.querySelector('header').toggleClass('toggle');
    });
       
    $(window).on('scroll load', () => {
        menuitem.removeClass('.fa-times');
        document.querySelector('header').removeClass('toggle');

        if ($(window).scrollTop() > 0) {
            $('.top').show();
        } else {
            $('.top').hide();
        }
    });

    // smooth scrolling 

    $('a[href*="#"]').on('click', function (e) {

        e.preventDefault();

        $('html, body').animate({

            scrollTop: $($(this).attr('href')).offset().top,

        },
            500, 'linear'
        );

    });

});