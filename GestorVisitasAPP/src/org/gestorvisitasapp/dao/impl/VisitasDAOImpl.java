package org.gestorvisitasapp.dao.impl;

import org.gestorvisitasapp.util.Conexion;
import org.gestorvisitasapp.model.Visitas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.gestorvisitasapp.dao.VisitasDAO;

public class VisitasDAOImpl implements VisitasDAO {
    
    @Override
    public boolean insertar(Visitas objeto) {
        String sql = "{call sp_agregar_Secretarios(?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection con = Conexion.getInstancia().conectar();
            CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, objeto.getId_visita());
            cs.setString(2, objeto.getFecha_hora_entrada());
            cs.setString(3, objeto.getFecha_hora_salida());
            cs.setString(4, objeto.getMotivo_visita());
            cs.setString(5, objeto.getNombre_alumno_relacionado());
            cs.setString(6, objeto.getGrado_seccion_alumno());
            cs.setString(7, objeto.getNombres());
            cs.setString(8, objeto.getApellidos());
            cs.setString(9, objeto.getTipo_visitante());
            cs.setString(10, objeto.getNombre_secretario());
            cs.setString(11, objeto.getNombre_area());
            cs.setString(12, objeto.getSector_edificio());
            cs.setString(13, objeto.getTipo_gafete());
            cs.setString(14, objeto.getEstado_de_vuelta());
            cs.setString(15, objeto.getPlaca());
            cs.setString(16, objeto.getMarca());
            cs.setString(17, objeto.getColor());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Insertar Visitas]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Visitas> listar() {
        List<Visitas> lista = new ArrayList<>();
        String sql = "{call sp_listar_Visitas()}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                lista.add(new Visitas(
                rs.getInt("id_visita"),
                rs.getString("fecha_hora_entrada"),
                rs.getString("fecha_hora_salida"),
                rs.getString("motivo_visita"),
                rs.getString("nombre_alumno_relacionado"),
                rs.getString("grado_seccion_alumno"),
                rs.getString("nombres"),
                rs.getString("apellidos"),
                rs.getString("tipo_visitante"),
                rs.getString("nombre_secretario"),
                rs.getString("nombre_area"),
                rs.getString("sector_edificio"),
                rs.getString("tipo_gafete"),
                rs.getString("estado_de_vuelta"),
                rs.getString("placa"),
                rs.getString("marca"),
                rs.getString("color")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error [Listar Visitas]: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Visitas buscar(Integer id_visita) {
        String sql = "{call sp_buscar_Visitas(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id_visita);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return new Visitas(
                    rs.getInt("id_visita"),
                    rs.getString("fecha_hora_entrada"),
                    rs.getString("fecha_hora_salida"),
                    rs.getString("motivo_visita"),
                    rs.getString("nombre_alumno_relacionado"),
                    rs.getString("grado_seccion_alumno"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("tipo_visitante"),
                    rs.getString("nombre_secretario"),
                    rs.getString("nombre_area"),
                    rs.getString("sector_edificio"),
                    rs.getString("tipo_gafete"),
                    rs.getString("estado_de_vuelta"),
                    rs.getString("placa"),
                    rs.getString("marca"),
                    rs.getString("color")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error [Buscar Visitas]: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Visitas objeto) {
        String sql = "{call sp_actualizar_Visitas(?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection con = Conexion.getInstancia().conectar();
            CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, objeto.getId_visita());
            cs.setString(2, objeto.getFecha_hora_entrada());
            cs.setString(3, objeto.getFecha_hora_salida());
            cs.setString(4, objeto.getMotivo_visita());
            cs.setString(5, objeto.getNombre_alumno_relacionado());
            cs.setString(6, objeto.getGrado_seccion_alumno());
            cs.setString(7, objeto.getNombres());
            cs.setString(8, objeto.getApellidos());
            cs.setString(9, objeto.getTipo_visitante());
            cs.setString(10, objeto.getNombre_secretario());
            cs.setString(11, objeto.getNombre_area());
            cs.setString(12, objeto.getSector_edificio());
            cs.setString(13, objeto.getTipo_gafete());
            cs.setString(14, objeto.getEstado_de_vuelta());
            cs.setString(15, objeto.getPlaca());
            cs.setString(16, objeto.getMarca());
            cs.setString(17, objeto.getColor());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Actualizar Visitas]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer id_visita) {
        String sql = "{call sp_eliminar_Visitas(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id_visita);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Eliminar Visitas]: " + e.getMessage());
            return false;
        }
    }
    
}

