package org.gestorvisitasapp.model;

public class Vehiculos {
    
    private String placa;
    private String tipoVehiculo;
    private String colorVehiculo;

    public Vehiculos() {
    }

    public Vehiculos(String placa, String tipoVehiculo, String colorVehiculo) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.colorVehiculo = colorVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getColorVehiculo() {
        return colorVehiculo;
    }

    public void setColorVehiculo(String colorVehiculo) {
        this.colorVehiculo = colorVehiculo;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + " | Tipo: " + tipoVehiculo + " | Color: " + colorVehiculo;
    } 
}