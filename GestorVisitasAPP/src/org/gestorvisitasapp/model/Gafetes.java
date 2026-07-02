package org.gestorvisitasapp.model;

public class Gafetes {
    
    private Integer idGafete;
    private String tipoGafete;
    private String estadoGafete;

    public Gafetes() {
    }

    public Gafetes(Integer idGafete, String tipoGafete, String estadoGafete) {
        this.idGafete = idGafete;
        this.tipoGafete = tipoGafete;
        this.estadoGafete = estadoGafete;
    }

    public Integer getIdGafete() {
        return idGafete;
    }

    public void setIdGafete(Integer idGafete) {
        this.idGafete = idGafete;
    }

    public String getTipoGafete() {
        return tipoGafete;
    }

    public void setTipoGafete(String tipoGafete) {
        this.tipoGafete = tipoGafete;
    }

    public String getEstadoGafete() {
        return estadoGafete;
    }

    public void setEstadoGafete(String estadoGafete) {
        this.estadoGafete = estadoGafete;
    }

    @Override
    public String toString() {
        return "ID: " + idGafete + " | Tipo: " + tipoGafete + " | Estado: " + estadoGafete;
    } 
}