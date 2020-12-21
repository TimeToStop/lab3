const inc = 1000;

document.addEventListener('DOMContentLoaded', function() {
    clock();
    setInterval(clock, inc);
});

function clock() {
    const date = new Date();

    const hours = ((date.getHours() + 11) % 12 + 1);
    const minutes = date.getMinutes();
    const seconds = date.getSeconds();

    const hour = hours * 30;
    const minute = minutes * 6;
    const second = seconds * 6;

    document.getElementsByClassName('hour')[0].style.transform = `rotate(${hour}deg)`
    document.getElementsByClassName('minute')[0].style.transform = `rotate(${minute}deg)`
    document.getElementsByClassName('second')[0].style.transform = `rotate(${second}deg)`
}