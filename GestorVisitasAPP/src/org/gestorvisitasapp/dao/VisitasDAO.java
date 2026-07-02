package org.gestorvisitasapp.dao;

import org.gestorvisitasapp.model.Visitas; 

public interface VisitasDAO extends CRUD<Visitas, Integer> {
    boolean registrarSalida(int idVisita);

}

