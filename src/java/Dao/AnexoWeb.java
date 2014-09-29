package Dao;

public class AnexoWeb {

    private Integer IdAnexo;
    private String CodAnexo;
    private String Apellidos;
    private String Nombres;
    private String Documento;
    private String Direccion;
    private String email;
    private String Telefono;
    private String rpm_rpc;
    private String Celular;
    private String PalabraClave;
   private String CodigoSeguridad;
    private String IPCliente;
    private String PreguntaSeguridad;
    private String Contraseña;
    private String FechaHora;

    public Integer getIdAnexo() {
        return IdAnexo;
    }
    public void setIdAnexo(Integer IdAnexo) {
        this.IdAnexo = IdAnexo;
    }
    public String getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(String FechaHora) {
        this.FechaHora = FechaHora;
    }

    public String getCodAnexo() {
        return CodAnexo;
    }

    public void setCodAnexo(String CodAnexo) {
        this.CodAnexo = CodAnexo;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getRpm_rpc() {
        return rpm_rpc;
    }

    public void setRpm_rpc(String rpm_rpc) {
        this.rpm_rpc = rpm_rpc;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getPalabraClave() {
        return PalabraClave;
    }

    public void setPalabraClave(String PalabraClave) {
        this.PalabraClave = PalabraClave;
    }

    public String getCodigoSeguridad() {
        return CodigoSeguridad;
    }

    public void setCodigoSeguridad(String CodigoSeguridad) {
        this.CodigoSeguridad = CodigoSeguridad;
    }

    public String getIPCliente() {
        return IPCliente;
    }

    public void setIPCliente(String IPCliente) {
        this.IPCliente = IPCliente;
    }

    public String getPreguntaSeguridad() {
        return PreguntaSeguridad;
    }

    public void setPreguntaSeguridad(String PreguntaSeguridad) {
        this.PreguntaSeguridad = PreguntaSeguridad;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

}
