package org.gestorvisitasapp.model;

public class Areas {
    
    private int idArea;
    private String nombreArea;
    private String numeroSalonTaller;
    private String sectorEdificio;
    private String nivelPiso;
    private String carreraTecnicaAsignada;
    
    public Areas() {
    }
    
    public Areas(int idArea, String nombreArea, String numeroSalonTaller, String sectorEdificio, String nivelPiso, String carreraTecnicaAsignada) {
        this.idArea = idArea;
        this.nombreArea = nombreArea;
        this.numeroSalonTaller = numeroSalonTaller;
        this.sectorEdificio = sectorEdificio;
        this.nivelPiso = nivelPiso;
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

    public String getNumeroSalonTaller() {
        return numeroSalonTaller;
    }

    public void setNumeroSalonTaller(String numeroSalonTaller) {
        this.numeroSalonTaller = numeroSalonTaller;
    }

    public String getSectorEdificio() {
        return sectorEdificio;
    }

    public void setSectorEdificio(String sectorEdificio) {
        this.sectorEdificio = sectorEdificio;
    }

    public String getNivelPiso() {
        return nivelPiso;
    }

    public void setNivelPiso(String nivelPiso) {
        this.nivelPiso = nivelPiso;
    }

    public String getCarreraTecnicaAsignada() {
        return carreraTecnicaAsignada;
    }

    public void setCarreraTecnicaAsignada(String carreraTecnicaAsignada) {
        this.carreraTecnicaAsignada = carreraTecnicaAsignada;
    }

    @Override
    public String toString() {
       return "ID: " + idArea + " | Area: " + nombreArea + " | Salon: " + numeroSalonTaller + " | Sector: " + sectorEdificio;
    }
}
