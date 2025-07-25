package com.brez.inventario.dto;

import lombok.Data;

@Data
public class InventarioDTO {
    private Long productoId;
    private String nombreProducto;
    private int cantidadDisponible;

    public InventarioDTO() { }
    public InventarioDTO(Long productoId, Integer cantidad) {
        this.productoId = productoId;
        this.cantidadDisponible = cantidad;
    }
}
