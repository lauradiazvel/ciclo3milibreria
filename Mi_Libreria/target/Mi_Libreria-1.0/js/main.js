var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);
        
        getLibros(false, "ASC");

        $("#ordenar-categoria").click(ordenarLibro);
    });
});

async function getUsuario(){

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult !=false){
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}
    function getLibros(ordenar, orden) {

        $.ajax({
            type:"GET",
            dataType: "html",
            url: "./ServletLibroListar",
            data: $.param({
                ordenar:ordenar,
                orden: orden
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                 if(parsedResult != false){
                     mostrarLibro(parsedResult);
                } else {
                    console.log("Error recuperando los datos de los libros");  
                }
            }
        });
    }

    function mostrarLibro(libros) {
        let contenido = "";

        $.each(libros, function(index,libro) {

            libro = JSON.parse(libro);

            contenido += '<tr><th scope="row">' + libro.id_libro + '</th>'  +

                    '<td>' + libro.titulo + '</td>' +
                    '<td>' + libro.categoria + '</td>' +
                    '<td>' + libro.sub_categoria + '</td>' +
                    '<td>' + libro.autor + '</td>' +
                    '<td>' + libro.anio_publicacion+ '</td>' +
                    '<td>' + libro.paginas + '</td>';

            contenido += '></td>' + 
                    '<td><button onclick="SelecionarLibro(' + libro.id_libro + ');" class="btn btn-success" ';

            contenido += '>Seleccionar</button></td></tr>'

    });
    $("#libros-tbody").html(contenido);
}

function ordenarLibros(){
    if ($("#icono-ordenar").hasClass("fa-sort")){
        getLibros(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("icono-ordenar").hasClass("fa-sort-down")){
        getLibros(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("icono-ordenar").hasClass("fa-sort-up")){
        getLibros(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}
function seleccionarLibro(id_libro){
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletLibroSeleccionar",
        data: $.param({
            id: id_libro,
            username: username
        })     
        
    })
}

