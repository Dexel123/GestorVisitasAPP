package org.gestorvisitasapp.dao.impl;

import org.gestorvisitasapp.util.Conexion;
import org.gestorvisitasapp.model.Visitas;
import org.gestorvisitasapp.dao.VisitasDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class VisitasDAOImpl implements VisitasDAO {

    @Override
    public boolean insertar(Visitas objeto) {
        String sql = "{call sp_agregar_visitas(?,?,?,?,?,?,?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, objeto.getId_visita());
            cs.setString(2, objeto.getMotivo_visita());
            cs.setInt(3, objeto.getId_visitante());
            cs.setInt(4, objeto.getId_secretario());
            cs.setInt(5, objeto.getId_area());
            if (objeto.getId_gafete() != null) {
                cs.setInt(6, objeto.getId_gafete());
            } else {
                cs.setNull(6, Types.INTEGER);
            }
            if (objeto.getPlaca() != null && !objeto.getPlaca().isEmpty()) {
                cs.setString(7, objeto.getPlaca());
            } else {
                cs.setNull(7, Types.VARCHAR);
            }
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Insertar Visita]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Visitas> listar() {
        List<Visitas> lista = new ArrayList<>();
        String sql = "{call sp_listar_visitas()}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                lista.add(new Visitas(
                    rs.getInt("id_visita"),
                    rs.getString("fecha_hora_entrada"),
                    rs.getString("fecha_hora_salida"),
                    rs.getString("motivo_visita"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("tipo_visitante"),
                    rs.getString("nombre_secretario"),
                    rs.getString("nombre_area"),
                    rs.getString("tipo_gafete"),
                    rs.getString("placa"),
                    rs.getString("tipo_vehiculo"),
                    rs.getString("color_vehiculo")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error [Listar Visitas]: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Visitas buscar(Integer id) {
        String sql = "{call sp_buscar_visitas(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return new Visitas(
                        rs.getInt("id_visita"),
                        rs.getString("fecha_hora_entrada"),
                        rs.getString("fecha_hora_salida"),
                        rs.getString("motivo_visita"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("tipo_visitante"),
                        rs.getString("nombre_secretario"),
                        rs.getString("nombre_area"),
                        rs.getString("tipo_gafete"),
                        rs.getString("placa"),
                        rs.getString("tipo_vehiculo"),
                        rs.getString("color_vehiculo")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error [Buscar Visita]: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Visitas objeto) {
        String sql = "{call sp_actualizar_visitas(?,?,?,?,?,?,?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, objeto.getId_visita());
            cs.setString(2, objeto.getMotivo_visita());
            cs.setInt(3, objeto.getId_visitante());
            cs.setInt(4, objeto.getId_secretario());
            cs.setInt(5, objeto.getId_area());
            if (objeto.getId_gafete() != null) {
                cs.setInt(6, objeto.getId_gafete());
            } else {
                cs.setNull(6, Types.INTEGER);
            }
            if (objeto.getPlaca() != null && !objeto.getPlaca().isEmpty()) {
                cs.setString(7, objeto.getPlaca());
            } else {
                cs.setNull(7, Types.VARCHAR);
            }
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Actualizar Visita]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer id) {
        String sql = "{call sp_eliminar_visitas(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Eliminar Visita]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean registrarSalida(int idVisita) {
        String sql = "{call sp_registrar_salida(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, idVisita);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Registrar Salida]: " + e.getMessage());
            return false;
        }
    }
}