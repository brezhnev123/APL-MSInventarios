package com.brez.inventario.adapter;
import com.brez.inventario.dto.InventarioDTO;
import com.brez.inventario.entity.Inventario;
import com.brez.inventario.mapper.InventarioMapper;
import com.brez.inventario.repository.InventarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InventarioPersistenceAdapter {

    private final InventarioRepository inventarioJpaRepository;

    public InventarioPersistenceAdapter(InventarioRepository inventarioJpaRepository) {
        this.inventarioJpaRepository = inventarioJpaRepository;
    }

    public Optional<InventarioDTO> obtenerPorProductoId(Long productoId) {
        return inventarioJpaRepository.findByProductoId(productoId)
                .map(InventarioMapper::toDTO);
    }

    public InventarioDTO actualizarCantidad(Long productoId, int nuevaCantidad) {
        Inventario entity = inventarioJpaRepository.findByProductoId(productoId)
                .orElse(new Inventario());

        entity.setProductoId(productoId);
        entity.setCantidad(nuevaCantidad);

        Inventario guardado = inventarioJpaRepository.save(entity);
        return InventarioMapper.toDTO(guardado);
    }
}
