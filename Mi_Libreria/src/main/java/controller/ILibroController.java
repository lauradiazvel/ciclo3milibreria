package controller;


public interface ILibroController {

    public String listar(boolean ordenar, String orden);
    
    public String seleccionar(int id_libro, String username);
    
    public String modificar(int id_libro);
}