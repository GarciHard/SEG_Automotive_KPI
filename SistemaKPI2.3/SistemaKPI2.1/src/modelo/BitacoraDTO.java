package modelo;

import java.util.Date;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class BitacoraDTO {
    
    private Date fecha;
    private int hora;
    private String linea;
    private String tema;
    private String operacion;
    private String area;
    private String problema;
    private String cliente;
    private String noParte;
    private int cantPzas;
    private int tiempoIni;
    private int tiempoFin;
    private int duracion;
    private String noParteCambio;
    private String scrap;

    //Constructor por defecto
    public BitacoraDTO() {}

    public BitacoraDTO(Date fecha, int hora, String linea, String tema, String operacion, String area, String problema, String cliente, String noParte, int cantPzas, int tiempoIni, int tiempoFin, int duracion, String noParteCambio, String scrap) {
        this.fecha = fecha;
        this.hora = hora;
        this.linea = linea;
        this.tema = tema;
        this.operacion = operacion;
        this.area = area;
        this.problema = problema;
        this.cliente = cliente;
        this.noParte = noParte;
        this.cantPzas = cantPzas;
        this.tiempoIni = tiempoIni;
        this.tiempoFin = tiempoFin;
        this.duracion = duracion;
        this.noParteCambio = noParteCambio;
        this.scrap = scrap;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNoParte() {
        return noParte;
    }

    public void setNoParte(String noParte) {
        this.noParte = noParte;
    }

    public int getCantPzas() {
        return cantPzas;
    }

    public void setCantPzas(int cantPzas) {
        this.cantPzas = cantPzas;
    }

    public int getTiempoIni() {
        return tiempoIni;
    }

    public void setTiempoIni(int tiempoIni) {
        this.tiempoIni = tiempoIni;
    }

    public int getTiempoFin() {
        return tiempoFin;
    }

    public void setTiempoFin(int tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getNoParteCambio() {
        return noParteCambio;
    }

    public void setNoParteCambio(String noParteCambio) {
        this.noParteCambio = noParteCambio;
    }

    public String getScrap() {
        return scrap;
    }

    public void setScrap(String scrap) {
        this.scrap = scrap;
    }
}