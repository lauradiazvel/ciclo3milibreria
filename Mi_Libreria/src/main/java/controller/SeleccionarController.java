package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import com.google.gson.Gson;

import beans.Biblioteca;
import connection.Conexion;

public class SeleccionarController implements ISeleccionarController{
 

    public String listarSelecciones(String username) {

        Gson gson = new Gson();

        Conexion con = new Conexion();

        String sql = "Select l.id_libro, l.titulo, l.categoria, b.fecha_seleccion from libros l" 
                + "inner join biblioteca b on l.id_libro= b.id_libro inner join usuarios u on b.id_usuario= u.id_usuario" 
                + "where b.username = '" + username + "'";

        List<String> seleccion = new ArrayList<String>();

        try{

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Integer id_libro = rs.getInt("id_libro");
                String titulo = rs.getString("titulo");
                String categoria = rs.getString("categoria");
                Date fecha_seleccion = rs.getDate("fecha_seleccion");

                Biblioteca biblioteca = new Biblioteca(id_libro, titulo, categoria, fecha_seleccion);

                seleccion.add(gson.toJson(biblioteca));
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            con.Desconectar();
        }

        return gson.toJson(seleccion);
    }

}
