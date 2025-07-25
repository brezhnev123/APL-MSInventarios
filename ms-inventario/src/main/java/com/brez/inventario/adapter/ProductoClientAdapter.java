package com.brez.inventario.adapter;

import com.brez.inventario.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductoClientAdapter {

    private final RestTemplate restTemplate;
    private final String urlBase;

    public ProductoClientAdapter(RestTemplate restTemplate,
                                 @Value("${servicios.productos.url}") String urlBase) {
        this.restTemplate = restTemplate;
        this.urlBase = urlBase;
    }

    public ProductoDTO obtenerProductoPorId(Long productoId) {
        String url = urlBase + "/api/v1/productos/" + productoId;
        return restTemplate.getForObject(url, ProductoDTO.class);
    }
}
