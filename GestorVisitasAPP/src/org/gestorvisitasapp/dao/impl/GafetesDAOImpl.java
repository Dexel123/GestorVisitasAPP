package org.gestorvisitasapp.dao.impl;

import org.gestorvisitasapp.util.Conexion;
import org.gestorvisitasapp.model.Gafetes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.gestorvisitasapp.dao. GafetesDAO;

public class GafetesDAOImpl implements GafetesDAO {
    
    @Override
    public boolean insertar( Gafetes objeto) {
        String sql = "{call sp_agregar_Gafetes(?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getInstancia().conectar();
            CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, objeto.getIdGafete());
            cs.setString(2, objeto.getTipoGafete());
            cs.setString(3, objeto.getEstadoGafete());
            cs.setString(4, objeto.getDireccionVisita());
            cs.setString(5, objeto.getEstadoVuelta());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Insertar  Gafetes]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Gafetes> listar() {
        List<Gafetes> lista = new ArrayList<>();
        String sql = "{call sp_listar_Gafetes}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                lista.add(new  Gafetes(
                rs.getInt("id_gafete"),
                rs.getString("tipo_gafete"),
                rs.getString("estado_gafete"),
                rs.getString("direccion_de_visita"),
                rs.getString("estado_de_vuelta")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error [Listar Gafetes]: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public  Gafetes buscar(Integer id_gafete) {
        String sql = "{call sp_buscar_Gafetes(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id_gafete);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return new  Gafetes(
                    rs.getInt("id_gafete"),
                    rs.getString("tipo_gafete"),
                    rs.getString("estado_gafete"),
                    rs.getString("direccion_de_visita"),
                    rs.getString("estado_de_vuelta")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error [Buscar  Gafetes]: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar( Gafetes objeto) {
        String sql = "{call sp_actualizar_Gafetes(?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getInstancia().conectar();
            CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, objeto.getIdGafete());
            cs.setString(2, objeto.getTipoGafete());
            cs.setString(3, objeto.getEstadoGafete());
            cs.setString(4, objeto.getDireccionVisita());
            cs.setString(5, objeto.getEstadoVuelta());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Actualizar  Gafetes]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer id_gafete) {
        String sql = "{call sp_eliminar_Gafetes(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id_gafete);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Eliminar  Gafetes]: " + e.getMessage());
            return false;
        }
    }
    
}
