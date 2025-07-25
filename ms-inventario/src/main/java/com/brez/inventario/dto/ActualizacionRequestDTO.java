package com.brez.inventario.dto;

import lombok.Data;

@Data
public class ActualizacionRequestDTO {
    private Integer productoId;
    private Integer nuevaCantidad;
}
