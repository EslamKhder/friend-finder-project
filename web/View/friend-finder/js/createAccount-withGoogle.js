/* Log in With Google*/
var fname = document.getElementById("fullname"),
    email = document.getElementById("email");
function onSignIn(googleUser)
{
    // Useful data for your client-side scripts:
    var profile = googleUser.getBasicProfile();
    fname.value = profile.getName();
    email.value = profile.getEmail();
}