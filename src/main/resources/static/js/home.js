(async function(){

    const userInSession = getUserInSession();
    if (userInSession) {
        window.location.href = 'home_page.html';
        return;
    }

    //document.body.style.display = "block";

    const urlParams = new URLSearchParams(window.location.search);
    const msg = urlParams.get("msg");
    if (msg && msg === "ok_contact_saved") {
        document.getElementById("ok_contact_saved").style.display = "block";
        setTimeout(() => {
            document.getElementById("ok_contact_saved").style.display = "none";
        }, 5000)
    }

    /*document.getElementById("btn_entrar").addEventListener("click", function (e) {
        e.preventDefault();
        setUserInSession(userInSession);
    });*/
    document.getElementById("btn_entrar").addEventListener("click", function (e) {
        e.preventDefault();
        window.location.href = 'login.html';
    });
})();