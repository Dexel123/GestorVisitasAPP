package org.gestorvisitasapp.dao.impl;

import org.gestorvisitasapp.util.Conexion;
import org.gestorvisitasapp.model.Vehiculos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.gestorvisitasapp.dao.VehiculosDAO;

public class VehiculosDAOImpl implements VehiculosDAO {

    @Override
    public boolean insertar(Vehiculos objeto) {
        String sql = "{call sp_agregar_vehiculos(?,?,?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, objeto.getPlaca());
            cs.setString(2, objeto.getTipoVehiculo());
            cs.setString(3, objeto.getColorVehiculo());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Insertar Vehiculo]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Vehiculos> listar() {
        List<Vehiculos> lista = new ArrayList<>();
        String sql = "{call sp_listar_vehiculos()}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                lista.add(new Vehiculos(
                    rs.getString("placa"),
                    rs.getString("tipo_vehiculo"),
                    rs.getString("color_vehiculo")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error [Listar Vehiculos]: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Vehiculos buscar(String placa) {
        String sql = "{call sp_buscar_vehiculos(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, placa);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return new Vehiculos(
                        rs.getString("placa"),
                        rs.getString("tipo_vehiculo"),
                        rs.getString("color_vehiculo")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error [Buscar Vehiculo]: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Vehiculos objeto) {
        String sql = "{call sp_actualizar_vehiculos(?,?,?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, objeto.getPlaca());
            cs.setString(2, objeto.getTipoVehiculo());
            cs.setString(3, objeto.getColorVehiculo());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Actualizar Vehiculo]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(String placa) {
        String sql = "{call sp_eliminar_vehiculos(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, placa);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Eliminar Vehiculo]: " + e.getMessage());
            return false;
        }
    }
}