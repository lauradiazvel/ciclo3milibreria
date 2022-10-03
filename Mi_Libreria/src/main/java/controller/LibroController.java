package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Libro;
import connection.Conexion;

public class LibroController implements ILibroController{

    @Override
    public String listar(boolean ordenar, String orden){

        Gson gson = new Gson();

        Conexion con = new Conexion();
        String sql = "SELECT * FROM libros";

        if(ordenar == true){
            sql += " order by categoria" + orden;
        }

        List<String> libros = new ArrayList<String>();

        try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Integer id_libro = rs.getInt("id_libro");
                String titulo = rs.getString("titulo");
                String categoria = rs.getString("categoria");
                String sub_categoria = rs.getString("sub_categoria");
                String autor = rs.getString("autor");
                Integer anio_publicacion= rs.getInt("anio_publicacion");
                Integer paginas = rs.getInt("paginas");

                Libro libro = new Libro(id_libro, titulo, categoria, sub_categoria, autor, anio_publicacion, paginas);

                libros.add(gson.toJson(libro));

            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            con.Desconectar();
        }

        return gson.toJson(libros);
    }
    
    @Override
    public String seleccionar(int id_libro, String username){
        
        Timestamp fecha= new Timestamp(new Date().getTime());
        Conexion con = new Conexion();
        String sql = "Insert into seleccionar values ('"+ id_libro+"','"+username+"','"+fecha+"')";
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            
                       
        } catch (Exception ex){
            System.out.println(ex.toString());
        } finally {
            con.Desconectar();
        }
        return "false";
        
    }  

    @Override
    public String modificar(int id_libro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}