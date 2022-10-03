package test;

import beans.Libro;
import connection.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prueba {
    
    public static void main (String[] args){
        listarlibro();
    }
    
    public static void actualizarlibros(Integer id_libro , String genero) throws SQLException{
        Conexion con = new Conexion();
        String sql = "UPDATE libros SET genero = " + "'" + genero + "WHERE id_libro = " + id_libro;
        try{
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            con.Desconectar();
        }
    }
    
    public static void listarlibro(){
        Conexion con = new Conexion();
        String sql = "SELECT * FROM libros";
        try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Integer id_libro = rs.getInt("id_libro");
                String titulo = rs.getString("titulo");
                String categoria = rs.getString("categoria");
                String sub_categoria = rs.getString("sub_categoria");
                String autor = rs.getString("autor");
                Integer anio_publicacion = rs.getInt("anio_publicacion");
                Integer paginas = rs.getInt("paginas");
                Libro libro = new Libro( id_libro, titulo ,categoria,sub_categoria,autor, anio_publicacion , paginas);
                System.out.println(libro.toString());
            }
            
            st.executeQuery(sql);
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            con.Desconectar();
        }
    }
    
}

