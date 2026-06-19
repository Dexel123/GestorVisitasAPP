package org.gestorvisitasapp.model;

public class Secretarios {
    
    private int idSecretario;
    private String nombres;
    private String apellidos;
    private String cargoPuesto;
    private String correoElectronico;
    private String jornadaLaboral;
    
    public Secretarios() {
    }
    
    public Secretarios(int idSecretario, String nombres, String apellidos, String cargoPuesto, String correoElectronico, String jornadaLaboral) {
        this.idSecretario = idSecretario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargoPuesto = cargoPuesto;
        this.correoElectronico = correoElectronico;
        this.jornadaLaboral = jornadaLaboral;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getJornadaLaboral() {
        return jornadaLaboral;
    }

    public void setJornadaLaboral(String jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }

    @Override
    public String toString() {
        return "ID: " + idSecretario + " | Nombre: " + nombres + " " + apellidos + " | Cargo: " + cargoPuesto + " | Jornada: " + jornadaLaboral;
    } 
}
