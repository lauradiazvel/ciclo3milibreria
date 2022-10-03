package beans;

import java.util.Date;

public class Biblioteca {
    
    Integer id;
    Date fecha_seleccion;
    Date fecha_inicio_lectura;
    Date fecha_fin_lectura;
    String comentario;
    String meta_lectura;
    Integer calificacion;
    Integer id_libro;
    Integer id_usuario;

    public Biblioteca(Integer id, Date fecha_seleccion, Date fecha_inicio_lectura, Date fecha_fin_lectura, String comentario, String meta_lectura, Integer calificacion, Integer id_libro, Integer id_usuario) {
        this.id = id;
        this.fecha_seleccion = fecha_seleccion;
        this.fecha_inicio_lectura = fecha_inicio_lectura;
        this.fecha_fin_lectura = fecha_fin_lectura;
        this.comentario = comentario;
        this.meta_lectura = meta_lectura;
        this.calificacion = calificacion;
        this.id_libro = id_libro;
        this.id_usuario = id_usuario;
    }

    public Biblioteca(Integer id_libro, String titulo, String categoria, java.sql.Date fecha_seleccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha_seleccion() {
        return fecha_seleccion;
    }

    public void setFecha_seleccion(Date fecha_seleccion) {
        this.fecha_seleccion = fecha_seleccion;
    }

    public Date getFecha_inicio_lectura() {
        return fecha_inicio_lectura;
    }

    public void setFecha_inicio_lectura(Date fecha_inicio_lectura) {
        this.fecha_inicio_lectura = fecha_inicio_lectura;
    }

    public Date getFecha_fin_lectura() {
        return fecha_fin_lectura;
    }

    public void setFecha_fin_lectura(Date fecha_fin_lectura) {
        this.fecha_fin_lectura = fecha_fin_lectura;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getMeta_lectura() {
        return meta_lectura;
    }

    public void setMeta_lectura(String meta_lectura) {
        this.meta_lectura = meta_lectura;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Biblioteca{" + "id=" + id + ", fecha_seleccion=" + fecha_seleccion + ", fecha_inicio_lectura=" + fecha_inicio_lectura + ", fecha_fin_lectura=" + fecha_fin_lectura + ", comentario=" + comentario + ", meta_lectura=" + meta_lectura + ", calificacion=" + calificacion + ", id_libro=" + id_libro + ", id_usuario=" + id_usuario + '}';
    }
   
}
