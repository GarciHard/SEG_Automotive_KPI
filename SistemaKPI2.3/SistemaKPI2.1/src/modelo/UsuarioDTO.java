package modelo;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class UsuarioDTO {
    
    private String usuario;
    private String password;
    private String puesto;
    private int privilegio;

    public UsuarioDTO(String usuario, String password, String puesto, int privilegio) {
        this.usuario = usuario;
        this.password = password;
        this.puesto = puesto;
        this.privilegio = privilegio;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getPuesto() {
        return puesto;
    }

    public int getPrivilegio() {
        return privilegio;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }
    
    

}
