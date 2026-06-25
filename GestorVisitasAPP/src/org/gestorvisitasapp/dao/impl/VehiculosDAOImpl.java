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
        String sql = "{call sp_agregar_Vehiculos(?, ?, ?, ?)}";
        try (Connection con = Conexion.getInstancia().conectar();
            CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, objeto.getPlaca());
              cs.setString(2, objeto.getTipo_vehiculo());
            cs.setString(3, objeto.getMarca());
            cs.setString(4, objeto.getColor());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Insertar Vehiculos]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Vehiculos> listar() {
        List<Vehiculos> lista = new ArrayList<>();
        String sql = "{call sp_listar_Vehiculos()}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                lista.add(new Vehiculos(
                rs.getString("placa"),
                rs.getString("tipo_vehiculo"),
                rs.getString("marca"),
                rs.getString("color")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error [Listar Vehiculos]: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Vehiculos buscar(String placa) {
        String sql = "{call sp_buscar_Vehiculos(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, placa);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return new Vehiculos(
                    rs.getString("placa"),
                    rs.getString("tipo_vehiculo"),
                    rs.getString("marca"),
                    rs.getString("color")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error [Buscar Vehiculos]: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Vehiculos objeto) {
        String sql = "{call sp_actualizar_Vehiculoss(?, ?, ?, ?)}";
        try (Connection con = Conexion.getInstancia().conectar();
            CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, objeto.getPlaca());
            cs.setString(2, objeto.getTipo_vehiculo());
            cs.setString(3, objeto.getMarca());
            cs.setString(4, objeto.getColor());           
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Actualizar Vehiculos]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(String placa) {
        String sql = "{call sp_eliminar_Vehiculos(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, placa);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Eliminar Vehiculos]: " + e.getMessage());
            return false;
        }
    }
    
}
