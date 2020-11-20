function checkBoxClicked(e) {
    let elements = document.getElementsByClassName('r-input');

    for(let element of elements) {
        element.checked = false;
    }

    e.checked = true;
}

function validation() {
    let error = document.getElementById('error');
    let x = document.getElementById('x-input');
    let rs = document.getElementsByClassName('r-input');

    let x_str = x.value;

    if(isNaN(Number(x_str))) {
        error.innerHTML = 'X is not a number';
        return false;
    }

    if(x_str.length > 5) {
        x_str = x_str.slice(0, 5);
    }

    let x_value = Number(x_str);

    if (x_value < -3 || x_value > 4) {
        error.innerHTML = 'X is not in range (-3, 4)';
        return false;
    }

    let count = 0;

    for(let r of rs) {
        if(r.checked) {
            count++;
        }
    }

    if(count !== 1) {
        error.innerHTML = 'R is not selected';
        return false;
    }

    return true;
}