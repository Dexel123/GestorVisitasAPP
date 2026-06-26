package org.gestorvisitasapp.model;

public class Visitas {
    
    private int id_visita;
    private String fecha_hora_entrada;
    private String fecha_hora_salida;
    private String motivo_visita;
    private String nombre_alumno_relacionado;
    private String grado_seccion_alumno;
    private String nombres;
    private String apellidos;
    private String tipo_visitante;
    private String nombre_secretario;
    private String nombre_area;
    private String sector_edificio;
    private String tipo_gafete;
    private String estado_de_vuelta;
    private String placa;
    private String marca;
    private String color;

      public Visitas() {
    }
      
        public Visitas(int id_visita, String fecha_hora_entrada, String fecha_hora_salida, String motivo_visita, String nombre_alumno_relacionado, String grado_seccion_alumno, String nombres, String apellidos, String tipo_visitante, String nombre_secretario, String nombre_area, String sector_edificio, String tipo_gafete, String estado_de_vuelta, String placa, String marca, String color) {
        this.id_visita = id_visita;
        this.fecha_hora_entrada = fecha_hora_entrada;
        this.fecha_hora_salida = fecha_hora_salida;
        this.motivo_visita = motivo_visita;
        this.nombre_alumno_relacionado = nombre_alumno_relacionado;
        this.grado_seccion_alumno = grado_seccion_alumno;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo_visitante = tipo_visitante;
        this.nombre_secretario = nombre_secretario;
        this.nombre_area = nombre_area;
        this.sector_edificio = sector_edificio;
        this.tipo_gafete = tipo_gafete;
        this.estado_de_vuelta = estado_de_vuelta;
        this.placa = placa;
        this.marca = marca;
        this.color = color;
    }

      
    public int getId_visita() {
        return id_visita;
    }

  
    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public String getFecha_hora_entrada() {
        return fecha_hora_entrada;
    }

    public void setFecha_hora_entrada(String fecha_hora_entrada) {
        this.fecha_hora_entrada = fecha_hora_entrada;
    }

    public String getFecha_hora_salida() {
        return fecha_hora_salida;
    }

    public void setFecha_hora_salida(String fecha_hora_salida) {
        this.fecha_hora_salida = fecha_hora_salida;
    }

    public String getMotivo_visita() {
        return motivo_visita;
    }

    public void setMotivo_visita(String motivo_visita) {
        this.motivo_visita = motivo_visita;
    }

    public String getNombre_alumno_relacionado() {
        return nombre_alumno_relacionado;
    }

    public void setNombre_alumno_relacionado(String nombre_alumno_relacionado) {
        this.nombre_alumno_relacionado = nombre_alumno_relacionado;
    }

    public String getGrado_seccion_alumno() {
        return grado_seccion_alumno;
    }

    public void setGrado_seccion_alumno(String grado_seccion_alumno) {
        this.grado_seccion_alumno = grado_seccion_alumno;
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

    public String getTipo_visitante() {
        return tipo_visitante;
    }

    public void setTipo_visitante(String tipo_visitante) {
        this.tipo_visitante = tipo_visitante;
    }

    public String getNombre_secretario() {
        return nombre_secretario;
    }

    public void setNombre_secretario(String nombre_secretario) {
        this.nombre_secretario = nombre_secretario;
    }

    public String getNombre_area() {
        return nombre_area;
    }

    public void setNombre_area(String nombre_area) {
        this.nombre_area = nombre_area;
    }

    public String getSector_edificio() {
        return sector_edificio;
    }

    public void setSector_edificio(String sector_edificio) {
        this.sector_edificio = sector_edificio;
    }

    public String getTipo_gafete() {
        return tipo_gafete;
    }

    public void setTipo_gafete(String tipo_gafete) {
        this.tipo_gafete = tipo_gafete;
    }

    public String getEstado_de_vuelta() {
        return estado_de_vuelta;
    }

    public void setEstado_de_vuelta(String estado_de_vuelta) {
        this.estado_de_vuelta = estado_de_vuelta;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
         return "ID: " + id_visita + " | Fecha y hora de entrada: " + fecha_hora_entrada + " | Fecha y hora salida: " + fecha_hora_salida  + " | Motivo Visita   : " + motivo_visita + " | Nombre Alumno Relacionado   : " + nombre_alumno_relacionado + " | Grado Seccion Alumno   : " + grado_seccion_alumno + " | Nombres   : " + nombres + " | Apellidos   : " + apellidos + " | Tipo Visitante   : " + tipo_visitante + " | Nombre Secretario   : " + nombre_secretario  + " | Nombre Area   : " + nombre_area + " | Sector Edificio   : " + sector_edificio + " | Tipo Gafete   : " + tipo_gafete + " | Estado de Vuelta   : " + estado_de_vuelta + " | Placa   : " + placa + " | Marca   : " + marca + " | Color   : " + color;
    }
}