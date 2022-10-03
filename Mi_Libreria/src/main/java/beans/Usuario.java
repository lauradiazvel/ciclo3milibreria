
package beans;


public class Usuario {
    
    Integer id_usuario;
    String username;
    String password;
    String nombres;
    String apellidos;
    String email;

    public Usuario(Integer id_usuario, String username, String password, String nombres, String apellidos, String email) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }
    
     public Usuario(String username, String password, String nombres, String apellidos, String email) {
        this.username = username;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", username=" + username + ", password=" + password + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + '}';
    }

 }   