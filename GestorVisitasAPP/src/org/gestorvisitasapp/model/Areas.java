package org.gestorvisitasapp.model;

public class Areas {
    
    private int idArea;
    private String nombreArea;
    private String carreraTecnicaAsignada;

    public Areas() {
    }

    public Areas(int idArea, String nombreArea, String carreraTecnicaAsignada) {
        this.idArea = idArea;
        this.nombreArea = nombreArea;
        this.carreraTecnicaAsignada = carreraTecnicaAsignada;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getCarreraTecnicaAsignada() {
        return carreraTecnicaAsignada;
    }

    public void setCarreraTecnicaAsignada(String carreraTecnicaAsignada) {
        this.carreraTecnicaAsignada = carreraTecnicaAsignada;
    }

    @Override
    public String toString() {
        return "ID: " + idArea + " | Area: " + nombreArea + " | Carrera: " + carreraTecnicaAsignada;
    } 
}