package com.brez.inventario.service;

import com.brez.inventario.adapter.ProductoFunctionAdapter;
import com.brez.inventario.dto.ActualizacionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoFunctionAdapter productoAdapter;

    @Autowired
    public ProductoServiceImpl(ProductoFunctionAdapter productoAdapter) {
        this.productoAdapter = productoAdapter;
    }

    @Override
    public ActualizacionResponseDTO actualizarCantidadProducto(Integer productoId, Integer nuevaCantidad) {
        return productoAdapter.actualizarCantidadProducto(productoId, nuevaCantidad);
    }
}
