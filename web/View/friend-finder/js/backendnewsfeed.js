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
var request2, id,comment,nameus;
function sendComment(x,z)
{
    id = x;
    nameus = z;
    comment = document.getElementById("comment"+id).value;
    var url = "../../addComment?comment="+comment+"&id=" + id;
    if (window.XMLHttpRequest) {
        request2 = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        request2 = new ActiveXObject("Microsoft.XMLHTTP");
    }
    try
    {
        request2.onreadystatechange = getInfocomment;
        request2.open("GET", url, true);
        request2.send();
    } catch (e)
    {
        alert("Unable to connect to server");
    }
}
function getInfocomment() {
    if (this.readyState == 4 && this.status == 200) {
        var val = this.responseText;
        if (val == "comment") {
            document.getElementById("commenterror" + id).innerHTML = "Invalid Comment";
            clear(id);
        } else if (val == "success") {
            var par = document.createElement("P"),
            anc = document.createElement("A"),
            I1  = document.createElement("I"),
            I2	= document.createElement("I"),
            div = document.createElement("DIV"),
            img = document.createElement("IMG");
            div.setAttribute("class","post-comment");
            img.setAttribute("src","images/users/user-11.jpg");
            img.setAttribute("class","profile-photo-sm");
            anc.setAttribute("href","timeline.html");
            anc.setAttribute("class","profile-link");
            I1.setAttribute("class","em em-laughing");
            anc.innerText =nameus;
            I2.innerText = comment;
            div.appendChild(img);
            par.appendChild(anc);
            par.appendChild(I1);
            par.appendChild(I2);
            div.appendChild(par);
            document.getElementById("newscomment"+id).appendChild(div);
        }
    }
    
}
function clear(x) {
    setTimeout(function () {
        document.getElementById("commenterror" + x).innerHTML = "";
    }, 3000);
}