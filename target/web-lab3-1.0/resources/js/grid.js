const w = 500;
const h = 500;
const px_mult = 60;

const ox = w / 2;
const oy = h / 2;

document.addEventListener('DOMContentLoaded', init);

function init() {
    let e = document.getElementById('content-canvas');

    if(e) {
        let canvas = document.createElement('canvas');
        canvas.id = 'canvas';
        canvas.width = w;
        canvas.height = h;
        e.width = w;
        e.appendChild(canvas);
        drawGrid(1);
    }
}

function drawGrid(radius) {
    let ctx = document.getElementById('canvas').getContext('2d');

    if(ctx) {
        ctx.fillStyle = '#f8f6f6';
        ctx.fillRect(0, 0, w, h);

        const px_radius = px_mult * radius;
        ctx.fillStyle = '#3399FF';

        // main shape
        ctx.beginPath();

        ctx.moveTo(ox, oy);
        ctx.lineTo(ox + px_radius, oy);
        ctx.lineTo(ox + px_radius, oy + px_radius/2);
        ctx.lineTo(ox, oy + px_radius/2);
        ctx.arc(ox, oy, px_radius/2, 0, Math.PI, false);
        ctx.lineTo(ox - px_radius, oy);
        ctx.lineTo(ox, oy - px_radius/2);
        ctx.lineTo(ox, oy);

        ctx.closePath();
        ctx.fill();

        ctx.fillStyle = '#000000';
        ctx.font = '12px sans-serif';

        // Coordinates
        ctx.beginPath();
        canvas_arrow(ctx, 0, oy, w, oy);
        ctx.closePath();
        ctx.stroke();

        ctx.beginPath();
        canvas_arrow(ctx, ox, h, ox, 0);
        ctx.closePath();
        ctx.stroke();

        const d = 5;

        // Horizontal digits
        for(let i = -3.5; i <= 3.6; i += 0.5) {
            if(i * i > 0.1) {
                ctx.fillText(i.toString(), ox + i * px_mult - d, oy - d);
            }
        }

        for(let i = -3.5; i <= 3.6; i += 0.25) {
            if(i * i > 0.01) {
                ctx.beginPath();
                ctx.moveTo(ox + i * px_mult , oy - d / 2);
                ctx.lineTo(ox + i * px_mult , oy + d / 2);
                ctx.stroke();
            }
        }

        // Vertical digits
        for(let i = -3.5; i <= 3.6; i += 0.5) {
            if(i * i > 0.1) {
                ctx.fillText((-i).toString(), ox + d, oy + i * px_mult);
            }
        }

        for(let i = -3.5; i <= 3.6; i += 0.25) {
            if(i * i > 0.01) {
                ctx.beginPath();
                ctx.moveTo(ox - d/2, oy + i * px_mult);
                ctx.lineTo(ox + d/2, oy + i * px_mult);
                ctx.stroke();
            }
        }

        ctx.fillText('0', ox + d, oy - d);
    }
}

function canvas_arrow(context, fromx, fromy, tox, toy) {
    let headlen = 10;
    let dx = tox - fromx;
    let dy = toy - fromy;
    let angle = Math.atan2(dy, dx);
    context.moveTo(fromx, fromy);
    context.lineTo(tox, toy);
    context.lineTo(tox - headlen * Math.cos(angle - Math.PI / 6), toy - headlen * Math.sin(angle - Math.PI / 6));
    context.moveTo(tox, toy);
    context.lineTo(tox - headlen * Math.cos(angle + Math.PI / 6), toy - headlen * Math.sin(angle + Math.PI / 6));
}