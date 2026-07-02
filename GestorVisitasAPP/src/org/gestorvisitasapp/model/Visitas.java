package org.gestorvisitasapp.model;

public class Visitas {
    
    private int id_visita;
    private String fecha_hora_entrada;
    private String fecha_hora_salida;
    private String motivo_visita;

    private int id_visitante;
    private int id_secretario;
    private int id_area;
    private Integer id_gafete;
    private String placa;

    private String nombres;
    private String apellidos;
    private String tipo_visitante;
    private String nombre_secretario;
    private String nombre_area;
    private String tipo_gafete;
    private String tipo_vehiculo;
    private String color_vehiculo;

    public Visitas() {
    }

    public Visitas(int id_visita, String motivo_visita, int id_visitante, int id_secretario, int id_area, Integer id_gafete, String placa) {
        this.id_visita = id_visita;
        this.motivo_visita = motivo_visita;
        this.id_visitante = id_visitante;
        this.id_secretario = id_secretario;
        this.id_area = id_area;
        this.id_gafete = id_gafete;
        this.placa = placa;
    }

    public Visitas(int id_visita, String fecha_hora_entrada, String fecha_hora_salida, String motivo_visita,
                   String nombres, String apellidos, String tipo_visitante, String nombre_secretario,
                   String nombre_area, String tipo_gafete, String placa, String tipo_vehiculo, String color_vehiculo) {
        
        this.id_visita = id_visita;
        this.fecha_hora_entrada = fecha_hora_entrada;
        this.fecha_hora_salida = fecha_hora_salida;
        this.motivo_visita = motivo_visita;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo_visitante = tipo_visitante;
        this.nombre_secretario = nombre_secretario;
        this.nombre_area = nombre_area;
        this.tipo_gafete = tipo_gafete;
        this.placa = placa;
        this.tipo_vehiculo = tipo_vehiculo;
        this.color_vehiculo = color_vehiculo;
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

    public int getId_visitante() {
        return id_visitante;
    }

    public void setId_visitante(int id_visitante) {
        this.id_visitante = id_visitante;
    }

    public int getId_secretario() {
        return id_secretario;
    }

    public void setId_secretario(int id_secretario) {
        this.id_secretario = id_secretario;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public Integer getId_gafete() {
        return id_gafete;
    }

    public void setId_gafete(Integer id_gafete) {
        this.id_gafete = id_gafete;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public String getTipo_gafete() {
        return tipo_gafete;
    }

    public void setTipo_gafete(String tipo_gafete) {
        this.tipo_gafete = tipo_gafete;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getColor_vehiculo() {
        return color_vehiculo;
    }

    public void setColor_vehiculo(String color_vehiculo) {
        this.color_vehiculo = color_vehiculo;
    }

    @Override
    public String toString() {
        return "ID: " + id_visita + " | Motivo: " + motivo_visita;
    }
}