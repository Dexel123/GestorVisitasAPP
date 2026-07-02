package org.gestorvisitasapp.dao.impl;

import org.gestorvisitasapp.util.Conexion;
import org.gestorvisitasapp.model.Areas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.gestorvisitasapp.dao.AreasDAO;

public class AreasDAOImpl implements AreasDAO {

    @Override
    public boolean insertar(Areas objeto) {
        String sql = "{call sp_agregar_areas(?,?,?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, objeto.getIdArea());
            cs.setString(2, objeto.getNombreArea());
            cs.setString(3, objeto.getCarreraTecnicaAsignada());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Insertar Area]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Areas> listar() {
        List<Areas> lista = new ArrayList<>();
        String sql = "{call sp_listar_areas()}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                lista.add(new Areas(
                    rs.getInt("id_area"),
                    rs.getString("nombre_area"),
                    rs.getString("carrera_tecnica_asignada")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error [Listar Areas]: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Areas buscar(Integer id) {
        String sql = "{call sp_buscar_areas(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return new Areas(
                        rs.getInt("id_area"),
                        rs.getString("nombre_area"),
                        rs.getString("carrera_tecnica_asignada")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error [Buscar Area]: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Areas objeto) {
        String sql = "{call sp_actualizar_areas(?,?,?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, objeto.getIdArea());
            cs.setString(2, objeto.getNombreArea());
            cs.setString(3, objeto.getCarreraTecnicaAsignada());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Actualizar Area]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer id) {
        String sql = "{call sp_eliminar_areas(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Eliminar Area]: " + e.getMessage());
            return false;
        }
    }
}