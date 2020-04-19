/* Add Like */
var request, num;
function sendLike(x)
{
    num = x;
    var url = "../../addLike?idpo=" + x;
    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    try
    {
        request.onreadystatechange = getInfo;
        request.open("GET", url, true);
        request.send();
    } catch (e)
    {
        alert("Unable to connect to server");
    }
}
function getInfo() {
    if (this.readyState == 4 && this.status == 200) {
        var val = this.responseText;
        var likes = document.getElementById("likes" + num);
        if (val == "remove") {
            likes.innerHTML = parseInt(likes.innerHTML) - 1;
        } else if (val == "add") {
            likes.innerHTML = parseInt(likes.innerHTML) + 1;
        }
    }
}
/* Add Comment*/