var socket = new WebSocket('wss://localhost:8443/wss');

socket.onmessage = function (event) {
    showMessage(event.data);
};


function sendMessage() {
    socket.send($("#name").val());
}

function showMessage(message) {
    $("#messages").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#send").click(function () {
        sendMessage();
    });
});