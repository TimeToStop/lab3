const w = 530;
const h = 530;
const px_mult = 48;

const ox = w / 2;
const oy = h / 2;

document.addEventListener('DOMContentLoaded', function() {
    let e = document.getElementById('content-canvas');

    if(e) {
        let canvas = document.createElement('canvas');
        canvas.id = 'canvas';
        canvas.width = w;
        canvas.height = h;
        e.width = w;
        e.appendChild(canvas);

        canvas.addEventListener('click', imageClicked);

        let e_input = document.getElementById('form:r-input-1');
        let es = document.getElementsByClassName('r-input');
        for(let e_inputs of es) {
            e_inputs.checked = false;
        }

        e_input.checked = true;
        redraw();
    }
});

function toXOY(x, y) {
    return {
        x : (x - ox)/px_mult,
        y :  (-y + oy)/px_mult
    }
}

// TODO:
function fromXOY(x, y) {
    return {
        x : x,
        y : y
    }
}


function imageClicked(e) {
    let rect = e.target.getBoundingClientRect();
    let x = e.x - rect.left;
    let y = e.y - rect.top;
    let point = toXOY(x, y);

    let input_x = document.getElementById('hidden:hidden-x');
    let input_y = document.getElementById('hidden:hidden-y');
    let input_r = document.getElementById('hidden:hidden-r');

    let submit = document.getElementById('hidden:submit');

    if (input_x && input_y && input_r && form) {
        input_x.value = point.x;
        input_y.value = point.y;
        input_r.value = current;

        submit.click();
    }
}

function redraw() {
    let table = document.getElementById('table');
    let dots = [];

    if (table) {
        for(let i = 0; i < table.rows.length; i++) {
            let x = Number(table.rows[i].cells[0].innerHTML.trim());
            let y = Number(table.rows[i].cells[1].innerHTML.trim());
            let r = Number(table.rows[i].cells[2].innerHTML.trim());
            let result = table.rows[i].cells[3].innerHTML.trim() !== 'Не попадает в область';

            if (Math.abs(r - current) < 1e-10) {
                dots.push({
                    x : x,
                    y : y,
                    result : result
                });
            }
        }
    }

    drawGrid(current, dots);
}

function drawDot(ctx, dot) {
    ctx.beginPath();
    ctx.arc(ox + px_mult * dot.x, oy - px_mult * dot.y, 5, 0, 2 * Math.PI, false);
    ctx.fillStyle = dot.result ? 'green' : 'red';
    ctx.fill();
}

function drawGrid(radius, dots) {
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
        for(let i = -5.0; i <= 5.1; i += 0.5) {
            if(i * i > 0.1) {
                ctx.fillText(i.toString(), ox + i * px_mult - d, oy - d);
            }
        }

        for(let i = -5.0; i <= 5.1; i += 0.25) {
            if(i * i > 0.01) {
                ctx.beginPath();
                ctx.moveTo(ox + i * px_mult , oy - d / 2);
                ctx.lineTo(ox + i * px_mult , oy + d / 2);
                ctx.stroke();
            }
        }

        // Vertical digits
        for(let i = -5.0; i <= 5.1; i += 0.5) {
            if(i * i > 0.1) {
                ctx.fillText((-i).toString(), ox + d, oy + i * px_mult);
            }
        }

        for(let i = -5.0; i <= 5.1; i += 0.25) {
            if(i * i > 0.01) {
                ctx.beginPath();
                ctx.moveTo(ox - d/2, oy + i * px_mult);
                ctx.lineTo(ox + d/2, oy + i * px_mult);
                ctx.stroke();
            }
        }

        ctx.fillText('0', ox + d, oy - d);

        for(let dot of dots) {
            drawDot(ctx, dot);
        }
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