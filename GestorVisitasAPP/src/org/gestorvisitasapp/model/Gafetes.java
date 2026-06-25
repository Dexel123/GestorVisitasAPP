package org.gestorvisitasapp.model;

public class Gafetes {
    
    private int id_gafete;
    private String tipo_gafete;
    private String estado_gafete;
    private String direccion_de_visita;
    private String estado_de_vuelta;
   
    
    public Gafetes() {
    }
    
    public Gafetes(int id_gafete, String tipo_gafete, String estado_gafete, String direccion_de_visita, String estado_de_vuelta) {
        this.id_gafete = id_gafete;
        this.tipo_gafete = tipo_gafete;
        this.estado_gafete = estado_gafete;
        this.direccion_de_visita = direccion_de_visita;
        this.estado_de_vuelta = estado_de_vuelta;
    }

    public int getIdGafete() {
        return id_gafete;
    }

    public void setIdGafete(int id_gafete) {
        this.id_gafete = id_gafete;
    }

    public String getTipoGafete() {
        return tipo_gafete;
    }

    public void setTipoGafete(String tipo_gafete) {
        this.tipo_gafete = tipo_gafete;
    }

    public String getEstadoGafete() {
        return estado_gafete;
    }

    public void setEstadoGafete(String estado_gafete) {
        this.estado_gafete = estado_gafete;
    }

    public String getDireccionVisita() {
        return direccion_de_visita;
    }

    public void setDireccionVisita(String direccion_de_visita) {
        this.direccion_de_visita = direccion_de_visita;
    }

    public String getEstadoVuelta() {
        return estado_de_vuelta;
    }

    public void setEstadoVuelta(String estado_de_vuelta) {
        this.estado_de_vuelta = estado_de_vuelta;
    }

  

    @Override
    public String toString() {
        return "ID: " + id_gafete + " | Tipo de Gafete: " + tipo_gafete  + " | Estado Gafete: " + estado_gafete + " | Direccion Visita: " + direccion_de_visita +  " | Estado de Vuelta: " + estado_de_vuelta;
    } 
}
