$(document).ready(function() {
    
    $("#form-login").submit(function (event) {
        
        event.preventDefault();
        autenticarUsuario();
    });
    
    $("#form-register").submit(function (event){
        
        event.preventDefault();
        registrarUsuario();
    });
    
    
});

function autenticarUsuario() {
    
    let username = $("#usuario").val();
    let password = $("#contraseña").val();
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            password: password
        }),
        success: function (result){
            let parsedResult = JSON.parse(result);
            if (parsedResult != false){
                $("#login-error").addClass("d-none");
                let username = parsedResult['username'];
                document.location.href = "home.html?username=" + username;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
function registrarUsuario () {
    
    let username = $("#input-username").val();
    let password = $("#input-contrasena").val();
    let contrasenaConfirmacion = $("#input-contrasena-repeat").val();
    let nombres = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let email = $("#input-email").val();
    
    if ( password == contrasenaConfirmacion) {
        
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                username : username,
                password: password,
                nombres: nombres,
                apellidos: apellidos,
                email: email
            }),
            success: function (result){
                let parsedResult =JSON.parse(result);
                
                if(parsedResult != false){
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "home.html?username=" + username;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}
