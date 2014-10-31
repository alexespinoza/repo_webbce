package Dao;

import javax.print.DocFlavor;

public class P_Menu {

    private Integer idmenu;
    private String titulo;
    private String url;
    private String descripcion;
    private String esactivo;
    private String orden;
    private  int idmenu_submenu;

    public int getIdmenu_submenu() {
        return idmenu_submenu;
    }

    public void setIdmenu_submenu(int idmenu_submenu) {
        this.idmenu_submenu = idmenu_submenu;
    }
    
            public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getEsactivo() {
        return esactivo;
    }

    public void setEsactivo(String esactivo) {
        this.esactivo = esactivo;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

}
