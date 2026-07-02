package org.gestorvisitasapp.model;

public class Secretarios {
    
    private int idSecretario;
    private String nombres;
    private String apellidos;
    private String cargoPuesto;

    public Secretarios() {
    }

    public Secretarios(int idSecretario, String nombres, String apellidos, String cargoPuesto) {
        this.idSecretario = idSecretario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargoPuesto = cargoPuesto;
    }

    public int getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(int idSecretario) {
        this.idSecretario = idSecretario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargoPuesto() {
        return cargoPuesto;
    }

    public void setCargoPuesto(String cargoPuesto) {
        this.cargoPuesto = cargoPuesto;
    }

    @Override
    public String toString() {
        return "ID: " + idSecretario + " | Nombre: " + nombres + " " + apellidos + " | Cargo: " + cargoPuesto;
    } 
}