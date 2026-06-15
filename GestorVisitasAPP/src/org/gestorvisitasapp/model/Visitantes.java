package org.gestorvisitasapp.model;

public class Visitantes {
    private int idVisitante; 
    private String nombres; 
    private String apellidos; 
    private String tipoVisitante; 
    private String telefonoContacto; 

    public Visitantes() {
    }
    
    public Visitantes(int idVisiante, String nombres, String apellidos, String tipoVisitante, String telefonoContacto) {
        this.idVisitante = idVisitante; 
        this.nombres = nombres; 
        this.apellidos = apellidos; 
        this.tipoVisitante = tipoVisitante; 
        this.telefonoContacto = telefonoContacto; 
    }

    public int getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
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

    public String getTipoVisitante() {
        return tipoVisitante;
    }

    public void setTipoVisitante(String tipoVisitante) {
        this.tipoVisitante = tipoVisitante;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Override
    public String toString() {
         return "ID: " + idVisitante + " | Nombre: " + nombres + " " + apellidos + " | Tipo: " + tipoVisitante + " | Telefono   : " + telefonoContacto;
    }
            
    
}
