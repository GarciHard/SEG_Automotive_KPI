/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructores;

import java.sql.Date;

/**
 *
 * @author zgm_e
 */
public class Registro {

    private Date fecha;
    private String hora;
    private String linea;
    private String turno;
    private String tema;
    private String operacion;
    private String area;
    private String problema;
    private String cleinte;
    private String noParte;
    private int cantPiezas;
    private String tiempoIn;
    private String tiempoFin;
    private int duracion;
    private String noParteCambio;

    

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the linea
     */
    public String getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * @return the operacion
     */
    public String getOperacion() {
        return operacion;
    }

    /**
     * @param operacion the operacion to set
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the problema
     */
    public String getProblema() {
        return problema;
    }

    /**
     * @param problema the problema to set
     */
    public void setProblema(String problema) {
        this.problema = problema;
    }

    /**
     * @return the cleinte
     */
    public String getCleinte() {
        return cleinte;
    }

    /**
     * @param cleinte the cleinte to set
     */
    public void setCleinte(String cleinte) {
        this.cleinte = cleinte;
    }

    /**
     * @return the noParte
     */
    public String getNoParte() {
        return noParte;
    }

    /**
     * @param noParte the noParte to set
     */
    public void setNoParte(String noParte) {
        this.noParte = noParte;
    }

    /**
     * @return the cantPiezas
     */
    public int getCantPiezas() {
        return cantPiezas;
    }

    /**
     * @param cantPiezas the cantPiezas to set
     */
    public void setCantPiezas(int cantPiezas) {
        this.cantPiezas = cantPiezas;
    }

    /**
     * @return the tiempoIn
     */
    public String getTiempoIn() {
        return tiempoIn;
    }

    /**
     * @param tiempoIn the tiempoIn to set
     */
    public void setTiempoIn(String tiempoIn) {
        this.tiempoIn = tiempoIn;
    }

    /**
     * @return the tiempoFin
     */
    public String getTiempoFin() {
        return tiempoFin;
    }

    /**
     * @param tiempoFin the tiempoFin to set
     */
    public void setTiempoFin(String tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the noParteCambio
     */
    public String getNoParteCambio() {
        return noParteCambio;
    }

    /**
     * @param noParteCambio the noParteCambio to set
     */
    public void setNoParteCambio(String noParteCambio) {
        this.noParteCambio = noParteCambio;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}
