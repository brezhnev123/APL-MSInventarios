package com.brez.inventario.mapper;

import com.brez.inventario.dto.InventarioDTO;
import com.brez.inventario.entity.Inventario;

public class InventarioMapper {

    public static InventarioDTO toDTO(Inventario entity) {
        if (entity == null) {
            return null;
        }
        return new InventarioDTO(
                entity.getProductoId(),
                entity.getCantidad()
        );
    }

    public static Inventario toEntity(InventarioDTO dto) {
        if (dto == null) {
            return null;
        }
        Inventario entity = new Inventario();
        entity.setProductoId(dto.getProductoId());
        entity.setCantidad(dto.getCantidadDisponible());
        return entity;
    }
}
