



function getConfirm() {
    var confi = document.getElementById("confiNum").value;
    if (confi == "")
        confi = "1";
    var hurl = "viewcart?num=" + confi;
    window.location.href = hurl;
}

function validate(evt) {
    var theEvent = evt || window.event;
    if (theEvent.keyCode === 13) {
        getConfirm();
    }
    var key = theEvent.keyCode || theEvent.which;
    key = String.fromCharCode(key);
    var regex = /[0-9]|\./;
    if (!regex.test(key)) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault)
            theEvent.preventDefault();
    }
}

