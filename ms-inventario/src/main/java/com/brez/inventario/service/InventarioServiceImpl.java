package com.brez.inventario.service;

import com.brez.inventario.adapter.ProductoClientAdapter;
import com.brez.inventario.adapter.ProductoFunctionAdapter;
import com.brez.inventario.dto.ActualizacionResponseDTO;
import com.brez.inventario.dto.InventarioDTO;
import com.brez.inventario.dto.ProductoDTO;
import org.springframework.stereotype.Service;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final ProductoClientAdapter productoClientAdapter;
    private final ProductoFunctionAdapter productCustomerAdapter;

    public InventarioServiceImpl(ProductoClientAdapter productoClientAdapter, ProductoFunctionAdapter productCustomerAdapter) {
        this.productoClientAdapter = productoClientAdapter;
        this.productCustomerAdapter = productCustomerAdapter;
    }

    @Override
    public InventarioDTO consultarInventarioPorProductoId(Long productoId) {
        ProductoDTO producto = productoClientAdapter.obtenerProductoPorId(productoId);

        // Simulamos la "cantidad" como dato temporal porque no se guarda en BD
        InventarioDTO dto = new InventarioDTO();
        dto.setProductoId(producto.getId());
        dto.setNombreProducto(producto.getNombre());
        dto.setCantidadDisponible(100); // valor simulado o hardcoded

        return dto;
    }

    @Override
    public InventarioDTO actualizarCantidad(Long productoId, int cantidad) {
        ProductoDTO producto = productoClientAdapter.obtenerProductoPorId(productoId);

        InventarioDTO dto = new InventarioDTO();
        dto.setProductoId(producto.getId());
        dto.setNombreProducto(producto.getNombre());
        dto.setCantidadDisponible(cantidad); // Actualizamos solo en memoria o simulado

        return dto;
    }
    @Override
    public ActualizacionResponseDTO actualizarCantidadProducto(Integer productoId, Integer nuevaCantidad) {
        return productCustomerAdapter.actualizarCantidadProducto(productoId, nuevaCantidad);
    }
}
