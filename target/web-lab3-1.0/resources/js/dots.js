function dotsReset(radius) {
    drawGrid(radius, []);
    $.get('imagedots.xhtml',
        function(data) {
            drawGrid(radius, JSON.parse(data));
        });
}