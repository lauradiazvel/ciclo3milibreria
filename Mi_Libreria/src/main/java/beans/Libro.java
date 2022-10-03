
package beans;


public class Libro {
    Integer id_libro;
    String titulo;
    String categoria;
    String sub_categoria;
    String autor;
    Integer anio_publicacion;
    Integer paginas;

    public Libro(Integer id_libro, String titulo, String categoria, String sub_categoria, String autor, Integer anio_publicacion, Integer paginas) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.categoria = categoria;
        this.sub_categoria = sub_categoria;
        this.autor = autor;
        this.anio_publicacion = anio_publicacion;
        this.paginas = paginas;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSub_categoria() {
        return sub_categoria;
    }

    public void setSub_categoria(String sub_categoria) {
        this.sub_categoria = sub_categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(Integer anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Libro{" + "id_libro=" + id_libro + ", titulo=" + titulo + ", categoria=" + categoria + ", sub_categoria=" + sub_categoria + ", autor=" + autor + ", anio_publicacion=" + anio_publicacion + ", paginas=" + paginas + '}';
    }

 }  