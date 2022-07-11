(async () => {

    const userInSession = getUserInSession();
    if (!userInSession) {
        window.location.href = 'index.html';
        return;
    }

    document.body.style.display = "block";

    document.getElementById("btn-salir").addEventListener("click", function (e) {
        e.preventDefault();
        salir();
    });


})();