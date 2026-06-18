package org.gestorvisitasapp.dao.impl;

import org.gestorvisitasapp.util.Conexion;
import org.gestorvisitasapp.model.Secretarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.gestorvisitasapp.dao.SecretariosDAO;

public class SecretariosDAOImpl implements SecretariosDAO {
    
    @Override
    public boolean insertar(Secretarios objeto) {
        String sql = "{call sp_agregar_Secretarios(?, ?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getInstancia().conectar();
            CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, objeto.getIdSecretario());
            cs.setString(2, objeto.getNombres());
            cs.setString(3, objeto.getApellidos());
            cs.setString(4, objeto.getCargoPuesto());
            cs.setString(5, objeto.getCorreoElectronico());
            cs.setString(6, objeto.getJornadaLaboral());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Insertar Secretarios]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Secretarios> listar() {
        List<Secretarios> lista = new ArrayList<>();
        String sql = "{call sp_listar_Secretarios()}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                lista.add(new Secretarios(
                rs.getInt("id_secretario"),
                rs.getString("nombres"),
                rs.getString("apellidos"),
                rs.getString("cargo_puesto"),
                rs.getString("correo_electronico"),
                rs.getString("jornada_laboral")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error [Listar Secretarios]: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Secretarios buscar(Integer id) {
        String sql = "{call sp_buscar_Secretarios(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return new Secretarios(
                    rs.getInt("id_secretario"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("cargo_puesto"),
                    rs.getString("correo_electronico"),
                    rs.getString("jornada_laboral")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error [Buscar Secretarios]: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Secretarios objeto) {
        String sql = "{call sp_actualizar_Secretarios(?, ?, ?, ?, ?, ?)}";
        try (Connection con = Conexion.getInstancia().conectar();
            CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, objeto.getIdSecretario());
            cs.setString(2, objeto.getNombres());
            cs.setString(3, objeto.getApellidos());
            cs.setString(4, objeto.getCargoPuesto());
            cs.setString(5, objeto.getCorreoElectronico());
            cs.setString(6, objeto.getJornadaLaboral());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Actualizar Secretarios]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer id) {
        String sql = "{call sp_eliminar_Secretarios(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Eliminar Secretarios]: " + e.getMessage());
            return false;
        }
    }
    
}
