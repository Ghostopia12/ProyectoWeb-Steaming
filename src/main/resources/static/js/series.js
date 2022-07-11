(async () => {

    const userInSession = getUserInSession();
    if (!userInSession) {
        window.location.href = 'index.html';
        return;
    }

    //document.body.style.display = "block";

    document.getElementById("btn-salir").addEventListener("click", function (e) {
        e.preventDefault();
        salir();
    });

    document.getElementById("btn_listas").addEventListener("click", addSerie);


})();

async function addSerie(){

}

// async function loadContact(serieId){
//     const response = await fetch(`api/series/${serieId}`);
//     if (!response.ok) {
//         alert("Error al cargar el contacto");
//         return;
//     }
//
//     const data = await response.json();
//
//     const nombre = document.querySelector("#nombreContacto");
//     const email = document.querySelector("#email");
//     const telefono = document.querySelector("#telefono");
//     const contactoIdControl = document.querySelector("#contactoId");
//     const imageId = document.querySelector("#imageId");
//
//     nombre.value = data.nombreContacto;
//     email.value = data.email;
//     telefono.value = data.telefonos.length == 0 ? "" : data.telefonos[0].nroContacto;
//     contactoIdControl.value = data.contactoId;
//     imageId.value = data.imagenId;
//
//     if (data.imagenId && data.imagenId > 0) {
//         const miniatura = document.getElementById("miniatura");
//         miniatura.src = "api/image/" + data.imagenId;
//     }
//
//     if (data.telefonos.length > 1) {
//         telefono.dataset.id = data.telefonos[0].telefonoContactoId;
//         let html = "";
//         data.telefonos.slice(1, data.telefonos.length).forEach((telefono, index) => {
//             html += createPhoneElement(index, telefono.nroContacto, telefono.telefonoContactoId);
//         });
//
//         const extraPhoneList = document.getElementById("phone-list");
//         extraPhoneList.innerHTML = html;
//     }
// }
//
// function addPhone() {
//     let phones = [...document.querySelectorAll(".extra-phone")];
//     const phoneNumbers = phones.map(phone => phone.value);
//
//     const index = phoneNumbers.length;
//     const newPhoneElement = createPhoneElement(index);
//
//     const container = document.getElementById("phone-list");
//     container.innerHTML += newPhoneElement;
//
//     phones = document.querySelectorAll(".extra-phone");
//     for (let i in phoneNumbers) {
//         const phoneNumber = phoneNumbers[i];
//         phones[i].value = phoneNumber;
//     }
// }
//
// function removePhone(index) {
//     const phones = [...document.querySelectorAll(".extra-phone")];
//     const phoneNumbers = phones.map(phoneElement => {
//         return {
//             "value": phoneElement.value,
//             "id": phoneElement.dataset.id
//         };
//     });
//
//     phoneNumbers.splice(index, 1);
//
//
//     let html = "";
//     for (let i in phoneNumbers) {
//         const phoneData = phoneNumbers[i];
//         html += createPhoneElement(i, phoneData.value, phoneData.id);
//     }
//
//     const container = document.getElementById("phone-list");
//     container.innerHTML = html;
// }
// function createPhoneElement(index, value = "", id = 0) {
//     return `<div class="mt-3">
//                 <div class="input-group">
//                     <input type="text" class="form-control telephone extra-phone" value="${ value }" data-id="${ id }">
//                     <div class="input-group-append">
//                         <span class="input-group-text pointer" onclick="removePhone(${ index })">
//                             <i class="fa-solid fa-trash"></i>
//                         </span>
//                     </div>
//                 </div>
//                 <div class="text-danger validation" style="display: none" id="validation-telefono">
//                     El número de teléfono es requerido
//                 </div>
//             </div>`
// }