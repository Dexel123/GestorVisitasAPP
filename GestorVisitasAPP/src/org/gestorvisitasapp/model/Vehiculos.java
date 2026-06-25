package org.gestorvisitasapp.model;

public class Vehiculos {
    
    private String placa;
    private String tipo_vehiculo;
    private String marca;
    private String color;

    
    public Vehiculos() {
    }
    
    public Vehiculos(String placa, String tipo_vehiculo, String marca, String color) {
        this.placa = placa;
        this.tipo_vehiculo = tipo_vehiculo;
        this.marca = marca;
        this.color = color;
       
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo= tipo_vehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    @Override
    public String toString() {
        return "PLACA: " + placa + " | Tipo_vehiculo: " + tipo_vehiculo + " | Marca: " + marca + " | Color: " + color;
    } 
}
