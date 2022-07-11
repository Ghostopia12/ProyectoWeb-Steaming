(async () => {

    const userInSession = getUserInSession();
    if (userInSession) {
        window.location.href = 'home_page.html';
        return;
    }

    //document.body.style.display = "block";



    document.getElementById("btn_register").addEventListener("click", saveUser)


})();


async function saveUser() {
    const nombre = document.querySelector("#nombreCompleto").value.trim();
    const password = document.querySelector("#inputPassword").value.trim();
    const usuario = document.querySelector("#nombreUsuario").value.trim();

    const validacionNombre = document.querySelector("#validation-name");
    const validacionUser = document.querySelector("#validation-user");
    const validacionPass = document.querySelector("#validation-pasword");



    validacionNombre.style.display = "none"
    validacionUser.style.display = "none"
    validacionPass.style.display = "none"

    let hasError = false;
    if (nombre === "") {
        hasError = true;
        validacionNombre.style.display = "block";
    }
    if (password === "") {
        hasError = true;
        validacionPass.innerHTML = "La contraseña es requerida"
        validacionPass.style.display = "block";
    } /*else if (!isEmailValid(email)) {
        hasError = true;
        validacionPass.innerHTML = "La contraseña ingresada no es válida"
        validacionPass.style.display = "block";
    }*/
    if (usuario === "") {
        hasError = true;
        validacionUser.innerHTML = "El usuario es requerido"
        validacionUser.style.display = "block";
    } /*else if (!isEmailValid(email)) {
        hasError = true;
        validacionUser.innerHTML = "El usuario que ha ingresado no es válido"
        validacionUser.style.display = "block";
    }*/


    if (hasError) {
        return;
    }

    const new_usuario = {
        "nombreCompleto": nombre,
        "userName": usuario,
        "contra": password,
        "adm": false
    }

    try{
        const resp = await fetch("api/usuario/register",{
            "method": "POST",
            headers:{
                "Accept": "application/json",
                "Content-Type":'application/json'
            }
        });
        if(!resp.ok){
            validacionUser.style.display = "block";
            console.log(resp.error)
        }else {
            validacionUser.style.display = "none";
        }
        const data = await resp.json();
        if(!data){
            console.log(resp.error)
        }
        window.location.href = "home_page.html?msg=ok_contact_saved";
    }catch (err){
        console.error(err)
    }
}


/*function isEmailValid(email) {
    const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

const method = contactoId === 0 ? "POST" : "PUT";
    const response = await fetch("api/usuario", {
        method: method,
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json"
        },
        body: JSON.stringify(new_usuario)
    });
    if (!response.ok) {
        console.log(response.error);
        msgError.innerHTML = "Error al guardar el contacto";
        msgError.style.display = "block";
        return;
    }
    const data = await response.json();
    if (!data) {
        console.log(response.error);
        msgError.innerHTML = "Error al guardar el contacto";
        msgError.style.display = "block";
    }*/
