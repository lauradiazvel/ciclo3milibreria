package controller;
import java.util.Map;

public interface IUsuarioController {
    
    public String login (String username , String password);

    public String register(String username, String password, String nombres, String apellidos, String email);

    public String pedir(String username);
    
    public String modificar(String username , String nuevoPassword , String nuevosNombres , String nuevosApellidos,
            String nuevoEmail);

    public String verlibros (String username);

    public String devolver (String username, Map<Integer , Integer> libros);

    public String eliminar(String username);

}