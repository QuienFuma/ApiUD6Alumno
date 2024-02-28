//1º cargar la lista de juegos
cargarListaJuegos()




function cargarListaJuegos(){
    const requestOptions = {
        method: "GET",
        redirect: "follow"
    };

    fetch("http://localhost:8080/api/juego", requestOptions)
        .then((response) => response.json())
        .then((result) => rellenaCombo(result))
        .catch((error) => console.error(error));
}
//Rellenar combobox de los juegos
function rellenaCombo(resultado){
    selector = document.getElementById("comboJuegos")
    for (let juego of resultado) {
        opcion = document.createElement("option");
        opcion.text=juego.nombre;
        opcion.value=juego.id;
        selector.appendChild(opcion);
    }
}

//Buscar las puntuaciones del juego seleccionado
function mostrarPuntuaciones(id){
    const requestOptions = {
        method: "GET",
        redirect: "follow"
    };

    fetch("http://localhost:8080/api/puntuacion/categoria/" + id, requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.error(error));
}
//Crear la puntuacion de los juegos
function crearPuntuacion(){
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "modo": document.getElementById("modo").value,
        "nickJugador": document.getElementById("nickname").value,
        "puntuacion": document.getElementById("puntos").value
    });
    console.log(raw);
    const requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    fetch("http://localhost:8080/api/puntuacion/juego/"+ document.getElementById("comboJuegos").value, requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.error(error));
}
//Borrar la puntuacion de un juego por id
function borrarPuntuacion(){
    const requestOptions = {
        method: "DELETE",
        redirect: "follow"
    };

    fetch("http://localhost:8080/api/puntuacion/"+document.getElementById("idPuntuacion").value, requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.error(error));
}

//Modificar la puntuacion de un juego por su id
function modificarPuntuacion(){
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "modo": document.getElementById("modo").value,
        "nickJugador": document.getElementById("nickname").value,
        "puntuacion": document.getElementById("puntos").value
    });

    const requestOptions = {
        method: "PUT",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    fetch("http://localhost:8080/api/puntuacion/"+document.getElementById("idPuntuacion").value, requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.error(error));
}