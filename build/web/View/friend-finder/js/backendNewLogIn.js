/*New Log IN*/
var request;
var fullname, email, password, job, distance;
function create()
{
    email = document.getElementById("email").value,
            password = document.getElementById("password").value,
            fullname = document.getElementById("fullname").value,
            job = document.getElementById("job").value,
            distance = document.getElementById("distance").value;
    var url = "../../NewAccount";
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
        request.send("fullname=" + fullname + "&email=" + email + "&password=" + password + "&job=" + job + "&distance=" + distance);
    } catch (e)
    {
        alert("Unable to connect to server");
    }
}
var e = document.getElementById("E"),
        p = document.getElementById("P"),
        j = document.getElementById("J"),
        n = document.getElementById("N"),
        d = document.getElementById("D");
function getInfo() {
    if (this.readyState === 4 && this.status === 200) {
        var val = this.responseText;
        if (val === "email") {
            e.innerHTML = "Invalid Email";
        }if (val === "emailexist") {
            e.innerHTML = "Email Is Exist";
        } else if (val === "password") {
            p.innerHTML = "Invalid Password";
        } else if (val === "job") {
            j.innerHTML = "Invalid Job";
        } else if (val === "name") {
            n.innerHTML = "Invalid NAME";
        } else if (val === "distance") {
            d.innerHTML = "Invalid Distance";
        } else if (val === "success") {
            location.replace("newsfeed.jsp");
        }
    }
    clear();
}
function clear() {
    setTimeout(function () {
        d.innerHTML = "";
        e.innerHTML = "";
        p.innerHTML = "";
        j.innerHTML = "";
        n.innerHTML = "";
    }, 4000);
}