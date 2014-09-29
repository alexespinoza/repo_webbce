package Dao;

public class P_Promociones {

    private int idpromo_oferta;
    private String titulo;
    private String nombre;
    private String subtitulo;
    private String img;
    private String url;
    private String descripcion;
    private int orden;

    public int getIdpromo_oferta() {
        return idpromo_oferta;
    }

    public void setIdpromo_oferta(int idpromo_oferta) {
        this.idpromo_oferta = idpromo_oferta;
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

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
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

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }


}
