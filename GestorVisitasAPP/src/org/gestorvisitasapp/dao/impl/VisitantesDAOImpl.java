package org.gestorvisitasapp.dao.impl;

import org.gestorvisitasapp.util.Conexion;
import org.gestorvisitasapp.model.Visitantes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.gestorvisitasapp.dao.VisitantesDAO;

public class VisitantesDAOImpl implements VisitantesDAO {

    @Override
    public boolean insertar(Visitantes objeto) {
        String sql = "{call sp_agregar_visitantes(?,?,?,?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, objeto.getIdVisitante());
            cs.setString(2, objeto.getNombres());
            cs.setString(3, objeto.getApellidos());
            cs.setString(4, objeto.getTipoVisitante());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Insertar Visitante]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Visitantes> listar() {
        List<Visitantes> lista = new ArrayList<>();
        String sql = "{call sp_listar_visitantes()}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                lista.add(new Visitantes(
                    rs.getInt("id_visitante"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("tipo_visitante")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error [Listar Visitantes]: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Visitantes buscar(Integer id) {
        String sql = "{call sp_buscar_visitantes(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return new Visitantes(
                        rs.getInt("id_visitante"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("tipo_visitante")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error [Buscar Visitante]: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Visitantes objeto) {
        String sql = "{call sp_actualizar_visitantes(?,?,?,?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, objeto.getIdVisitante());
            cs.setString(2, objeto.getNombres());
            cs.setString(3, objeto.getApellidos());
            cs.setString(4, objeto.getTipoVisitante());
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Actualizar Visitante]: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer id) {
        String sql = "{call sp_eliminar_visitantes(?)}";
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error [Eliminar Visitante]: " + e.getMessage());
            return false;
        }
    }
}
