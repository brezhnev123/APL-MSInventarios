package com.brez.inventario.service;

import com.brez.inventario.dto.ActualizacionResponseDTO;
import com.brez.inventario.dto.InventarioDTO;

public interface InventarioService {

   InventarioDTO consultarInventarioPorProductoId(Long productoId);

    InventarioDTO actualizarCantidad(Long productoId, int nuevaCantidad);

    ActualizacionResponseDTO actualizarCantidadProducto(Integer productoId, Integer nuevaCantidad);
}
