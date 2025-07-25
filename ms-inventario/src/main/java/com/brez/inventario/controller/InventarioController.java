package com.brez.inventario.controller;

import com.brez.inventario.dto.ActualizacionRequestDTO;
import com.brez.inventario.dto.ActualizacionResponseDTO;
import com.brez.inventario.dto.InventarioDTO;
import com.brez.inventario.service.InventarioService;
import com.brez.inventario.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventario")
public class InventarioController {

    private final InventarioService servicio;
    private final ProductoService productoService;

    public InventarioController(InventarioService servicio, ProductoService productoService) {
        this.servicio = servicio;
        this.productoService = productoService;
    }

    // Consultar la cantidad disponible por ID de producto
    @GetMapping("/{productoId}")
    public ResponseEntity<InventarioDTO> consultarCantidad(@PathVariable Long productoId) {
        return ResponseEntity.ok(servicio.consultarInventarioPorProductoId(productoId));
    }

    // Actualizar la cantidad disponible
    @PutMapping("/{productoId}")
    public ResponseEntity<InventarioDTO> actualizarCantidad(
            @PathVariable Long productoId,
            @RequestParam int cantidad) {
        return ResponseEntity.ok(servicio.actualizarCantidad(productoId, cantidad));
    }
    @PutMapping("/actualizar_cantidad")
    public ResponseEntity<ActualizacionResponseDTO> actualizarCantidadProducto(
            @RequestBody ActualizacionRequestDTO request) {

        ActualizacionResponseDTO response = productoService.actualizarCantidadProducto(
                request.getProductoId(), request.getNuevaCantidad());

        return ResponseEntity.ok(response);
    }
}
