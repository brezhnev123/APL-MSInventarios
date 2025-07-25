package com.brez.inventario.adapter;

import com.brez.inventario.dto.ActualizacionResponseDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Value;

@Repository
public class ProductoFunctionAdapter {

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${sql.update.product}")
    private String sqlActualizarProducto;

    public ActualizacionResponseDTO actualizarCantidadProducto(Integer productoId, Integer nuevaCantidad) {
        Query query = entityManager.createNativeQuery(sqlActualizarProducto);
        query.setParameter("productoId", productoId);
        query.setParameter("nuevaCantidad", nuevaCantidad);

        Object[] resultado = (Object[]) query.getSingleResult();

        ActualizacionResponseDTO response = new ActualizacionResponseDTO();
        response.setCodeError((Integer) resultado[0]);
        response.setMensajeError((String) resultado[1]);

        return response;
    }
}
