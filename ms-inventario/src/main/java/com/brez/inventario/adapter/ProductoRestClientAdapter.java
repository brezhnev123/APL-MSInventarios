package com.brez.inventario.adapter;

import com.brez.inventario.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductoRestClientAdapter {

    private final RestTemplate restTemplate;
    private final String productoServiceUrl;

    public ProductoRestClientAdapter(RestTemplate restTemplate,
                                     @Value("${servicios.productos.url}") String productoServiceUrl) {
        this.restTemplate = restTemplate;
        this.productoServiceUrl = productoServiceUrl;
    }

    public ProductoDTO obtenerProductoPorId(Long idProducto) {
        String url = productoServiceUrl + "/api/v1/productos/" + idProducto;
        return restTemplate.getForObject(url, ProductoDTO.class);
    }
}
