function dotsReset(radius) {
    $.get('imagedots.xhtml',
        function(data) {
            console.log(data);
            redraw(radius, JSON.parse(data));
        });
}

function redraw(radius, data) {
    console.log("Redraw called from dotsReset");
    drawGrid(radius, data);
}