package com.brez.inventario.repository;

import com.brez.inventario.dto.ActualizacionResponseDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoFunctionRepository {

    List<Object[]> updateCantidadProducto(@Param("productoId") Integer productoId,
                                          @Param("nuevaCantidad") Integer nuevaCantidad);
}
