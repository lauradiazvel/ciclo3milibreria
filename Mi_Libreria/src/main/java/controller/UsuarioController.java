package controller;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Usuario;
import connection.Conexion;
import java.util.HashMap;
import java.util.Map;

public class UsuarioController implements IUsuarioController {
    
    
    @Override    
    public String login(String username, String password) {
        Gson gson = new Gson();
        Conexion con = new Conexion();
        String sql = "SELECT * FROM usuarios WHERE  username= '" + username
                + "' and password = '" + password + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                Integer id_usuario = rs.getInt("id_usuario");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                Usuario usuario = new Usuario(id_usuario,username, password, nombres, apellidos,email);
                
                return gson.toJson(usuario);
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.Desconectar();
        }
        
        return "false";
    }
    @Override
    public String register(String username, String password, String nombres , String apellidos, String email){
        
        Gson gson = new Gson();
        Conexion con = new Conexion();
        
        String sql = "INSERT INTO usuarios (username , password , nombres , apellidos,email)"
                + " values('" + username + "','"+ password +"' , '"+ nombres 
                +"' ,'"+ apellidos + "' , '"+ email +"')";
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            
            Usuario usuario = new Usuario(username , password, nombres , apellidos , email);
            
            st.close();
            
            return gson.toJson(usuario);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.Desconectar();
        }
        return "false";
    }
    
    @Override
    public String pedir(String username){

        Gson gson = new Gson();

        Conexion con = new Conexion();
        String sql = "Select * from usuarios where username = '" + username + "'";

        try{

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                 String password = rs.getString("password");
                 String nombres = rs.getString("nombres");
                 String apellidos = rs.getString("apellidos");
                 String email = rs.getString("email");

                 Usuario usuario = new Usuario(username, password, nombres, apellidos,email);

                 return gson.toJson(usuario);
            }
        } catch(Exception ex){
             System.out.println(ex.getMessage());
        } finally {
             con.Desconectar();
        }
         
         return "false";
     }
     
     @Override
     public String modificar(String username , String nuevoPassword , String nuevosNombres , String nuevosApellidos,
            String nuevoEmail) {

         Conexion con = new Conexion();
         String sql = "UPDATE usuarios set password = '"+ nuevoPassword + "' , nombres = '" + nuevosNombres +"' , apellidos ='" + nuevosApellidos + "' , email='"+ nuevoEmail + "'";

         sql += "WHERE username = '" + username + "'";

         try {

             Statement st = con.getConnection().createStatement();
             st.executeUpdate(sql);

             return "true";
         } catch (Exception ex){
             System.out.println(ex.getMessage());
         } finally {
             con.Desconectar();

         }

         return "false";
    }

     @Override

     public String verlibros (String username){

         Conexion con = new Conexion();
         String sql = "SELECT id_libro, count(*) as num_copias from biblioteca where username = '" + username + "' group by id_libro;";

         Map<Integer , Integer> libros = new HashMap<Integer , Integer>();

         try {

             Statement st = con.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql);

             while (rs.next()) {
                 Integer id_libro = rs.getInt("id_libro");
                 Integer num_copias= rs.getInt("num_copias");

                 libros.put(id_libro, num_copias);
             }
             devolver(username , libros);

             return "true";
         } catch (Exception ex) {

             System.out.println(ex.getMessage());
         } finally {
             con.Desconectar();
         }

         return "false";
     }

     @Override
     public String devolver (String username , Map<Integer , Integer> libros) {

         Conexion con = new Conexion();

         try {
             for (Map.Entry<Integer , Integer> libro : libros.entrySet()){
                 Integer id_libro= libro.getKey();
                 Integer num_copias = libro.getValue();

                 String sql ="UPDATE libros set copias = (Select copias +" + num_copias
                         + " from libros where id_libro = " + id_libro +") where id_libro= "+ id_libro;

                 Statement st = con.getConnection().createStatement();
                 st.executeUpdate(sql);
             }

             this.eliminar(username);
         } catch (Exception ex) {

             System.out.println(ex.getMessage());
         } finally {
             con.Desconectar();
         }
         return "false";
     }

     public String eliminar(String username) {

         Conexion con = new Conexion();

         String sql1 = "Delete from biblioteca where username = '" + username + "'";
         String sql2 = "Delete from usuarios where username = '" + username + "'";

         try {

             Statement st = con.getConnection().createStatement();
             st.executeUpdate(sql1);
             st.executeUpdate(sql2);

             return "true";
         } catch (Exception ex) {
             System.out.println();ex.getMessage();
         } finally {
             con.Desconectar();
         }

         return "false";
     }
}  