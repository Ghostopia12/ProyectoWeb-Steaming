window.addEventListener('load',function(){
    new Glider(this.document.querySelector('.carrusel_elementos'),{
        slidesToShow: 1,
        slidesToScroll: 1,
        draggable: true,
        dots: '.carrusel_indicadores',
        arrows: {
            prev: '.carrusel_anterior',
            next: '.carrusel_siguiente'
        },
        responsive: [
            {
              // screens greater than >= 775px
            breakpoint: 768,
            settings: {
                // Set to `auto` and provide item width to adjust to viewport
                slidesToShow: 3,//'auto'
                slidesToScroll: 3,
                itemWidth: 150,
                duration: 0.25
                }
            },{
              // screens greater than >= 1024px
            breakpoint: 992,
            settings: {
                slidesToShow: 4,
                slidesToScroll: 4,
                itemWidth: 150,
                duration: 0.25
                }
            }
        ]
    });
});