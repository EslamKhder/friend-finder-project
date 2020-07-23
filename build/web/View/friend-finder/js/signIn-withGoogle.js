/* Log in With Google*/
var email = document.getElementById("email");
function onSignIn(googleUser)
{
    // Useful data for your client-side scripts:
    var profile = googleUser.getBasicProfile();
    email.value = profile.getEmail();
}