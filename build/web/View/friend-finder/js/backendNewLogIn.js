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

function getInfo() {
    var e = document.getElementById("E"),
            p = document.getElementById("P"),
            j = document.getElementById("J"),
            n = document.getElementById("N"),
            d = document.getElementById("D");
    if (this.readyState == 4 && this.status == 200) {
        var val = this.responseText;
        if (val == "email") {
            e.innerHTML = "Invalid Email";
            p.innerHTML = "";
            j.innerHTML = "";
            n.innerHTML = "";
            d.innerHTML = "";
        } else if (val == "password") {
            p.innerHTML = "Invalid Password";
            e.innerHTML = "";
            j.innerHTML = "";
            n.innerHTML = "";
            d.innerHTML = "";
        } else if (val == "job") {
            j.innerHTML = "Invalid Job";
            e.innerHTML = "";
            p.innerHTML = "";
            n.innerHTML = "";
            d.innerHTML = "";
        } else if (val == "name") {
            n.innerHTML = "Invalid NAME";
            e.innerHTML = "";
            p.innerHTML = "";
            j.innerHTML = "";
            d.innerHTML = "";
        } else if (val == "distance") {
            d.innerHTML = "Invalid Distance";
            e.innerHTML = "";
            p.innerHTML = "";
            j.innerHTML = "";
            n.innerHTML = "";
        } else if (val == "success") {
            location.replace("newsfeed.jsp");
        }
    }
}