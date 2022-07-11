(async function(){

    const userInSession = getUserInSession();
    if (!userInSession) {
        window.location.href = 'index.html';
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

    document.getElementById("btn_salir").addEventListener("click", function (e) {
        e.preventDefault();
        salir();
    });
    await cargarSeries();
    //await cargarContactos();
})();

async function cargarSeries(){
    const response = await fetch(`/api/image`);
    if (!response.ok) {
        return;
    }

    const listOfSeries = await response.json();
    println(listOfSeries);
    mostrarSeries(listOfSeries);
}

function mostrarSeries(listOfSeries){
    const contactosHtml = document.getElementById("series");

    let html = "";
    for (let i in listOfSeries) {
        const obj = listOfSeries[i];
        html += getImagenInHtml(obj);
    }
    contactosHtml.innerHTML = html;
}

function getImagenInHtml(obj) {
    const imageUrl = !obj.imagenId || obj.imagenId === 0 ? 'img/User-icon.png' : `api/image/${obj.imagenId}`;
    return `<div class="card">
            <a href="series.html" class="cuenta" id="serie${obj.imagenId}">
            <img src="${imageUrl}" class="serie-img" alt="Esta es una imagen">
            </a>
    </div>`;
}

/*async function cargarContactos() {
const userInSession = getUserInSession();
const response = await fetch(`/api/contacto/${userInSession.usuarioId}`);
if (!response.ok) {
return;
}

const listOfContacts = await response.json();
mostrarContactos(listOfContacts);
}

function mostrarContactos(listOfContacts){
const contactosHtml = document.getElementById("contactos");

if (listOfContacts.length === 0) {
contactosHtml.innerHTML =
    `<div class="col-12 text-center mb-5">
        No tiene contactos registrados. Presione el botón "Nuevo contacto" para registrar uno nuevo.
    </div>`;
return;
}

let html = "";
for (let i in listOfContacts) {
const obj = listOfContacts[i];
/*obj.telefono = obj.telefonos.length == 0 ? "" : obj.telefonos[0].nroContacto;
html += getContactoInHtml(obj);
}
contactosHtml.innerHTML = html;
}

async function eliminarContacto(contactoId) {
if (!confirm('¿Esta seguro que desea eliminar el contacto seleccionado')) {
return;
}

const response = await fetch(`api/contacto/${contactoId}`, {
method: "DELETE",
headers: {
    "Content-Type": "application/json",
    "Accept": "application/json"
}
});
if (!response.ok) {
alert("Error al eliminar el contacto!!!")
return;
}
cargarContactos();
}


function getContactoInHtml(obj) {
const imageUrl = !obj.imagenId || obj.imagenId === 0 ? 'img/User-icon.png' : `api/image/${obj.imagenId}`;
return `<div class="card">
            <img src="${imageUrl}" class="serie-img" alt="Esta es una imagen">
    </div>`;
}*/
