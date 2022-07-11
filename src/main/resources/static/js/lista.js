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

// async function loadSerie(usuarioId){
//     const response = await fetch(`api/lista/${usuarioId}`);
//     if (!response.ok) {
//         alert("Error al cargar la serie");
//         return;
//     }
//
//     const data = await response.json();
//
//     // const imageId = document.querySelector("#imageId");
//     // imageId.value = data.imagenId;
//     //
//     // if (data.imagenId && data.imagenId > 0) {
//     //     const miniatura = document.getElementById("miniatura");
//     //     miniatura.src = "api/image/" + data.imagenId;
//     // }
//     const listOfSeries = await response.json();
//     mostrarSeries(listOfSeries);
//
// }
// function mostrarSeries(listOfSeries){
//     const contactosHtml = document.getElementById("series");
//
//     if (listOfSeries.length === 0) {
//         contactosHtml.innerHTML =
//             `<div class="col-12 text-center mb-5">
//                 No tiene contactos registrados. Presione el botón "Nuevo contacto" para registrar uno nuevo.
//             </div>`;
//         return;
//     }
//
//     let html = "";
//     for (let i in listOfSeries) {
//         const obj = listOfSeries[i];
//         html += getSerieInHtml(obj);
//     }
//     contactosHtml.innerHTML = html;
// }
//
// function getSerieInHtml(obj) {
//     const imageUrl = !obj.imagenId || obj.imagenId === 0 ? 'img/User-icon.png' : `api/image/${obj.imagenId}`;
//     return `<a>
//         <div class="card">
//             <img src="${imageUrl}">
//         </div>
//          </a><!-- cambia de acuerdo al usuario -->`
// }