package com.brez.inventario.service;

import com.brez.inventario.dto.ActualizacionResponseDTO;


public interface ProductoService {
    ActualizacionResponseDTO actualizarCantidadProducto(Integer productoId, Integer nuevaCantidad);
}