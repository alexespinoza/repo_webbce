package Dao;

public class P_Actividades {
    private int idactividades;
    private String titulo;
    private String nombre;
    private String img;
    private String url;
    private String descripcion;

    public int getIdactividades() {
        return idactividades;
    }

    public void setIdactividades(int idactividades) {
        this.idactividades = idactividades;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
