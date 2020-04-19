/* Log in */
var request;
var email, password;
function login()
{
    email = document.getElementById("email").value,
            password = document.getElementById("password").value;
    var url = "../../logIn";
    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    try
    {
        request.onreadystatechange = getInfo;
        request.open("post", url, true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.send("email=" + email + "&password=" + password);
    } catch (e)
    {
        alert("Unable to connect to server");
    }
}

function getInfo() {
    if (this.readyState == 4 && this.status == 200) {
        var val = this.responseText;
        var error = document.getElementById("inva");
        if (val == "email") {
            error.innerHTML = "Invalid Email";
        } else if (val == "password") {
            error.innerHTML = "Invalid Password";
        } else if (val == "invalid") {
            error.innerHTML = "Invalid Email And Password";
        } else if (val == "success") {
            location.replace("newsfeed.jsp");
        }
    }
}
