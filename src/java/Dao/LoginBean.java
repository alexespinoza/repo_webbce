package Dao;

//Data Encapsulation using Getters and Setters
public class LoginBean {

    private String password;
    private String NomAnexo;
    private String CodAnexo;
    private String Usuario;
    private String pin;
    private String dni;
    public boolean valid;
    public String ms;

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomAnexo() {
        return NomAnexo;
    }

    public void setNomAnexo(String NomAnexo) {
        this.NomAnexo = NomAnexo;
    }

    public String getCodAnexo() {
        return CodAnexo;
    }

    public void setCodAnexo(String CodAnexo) {
        this.CodAnexo = CodAnexo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
