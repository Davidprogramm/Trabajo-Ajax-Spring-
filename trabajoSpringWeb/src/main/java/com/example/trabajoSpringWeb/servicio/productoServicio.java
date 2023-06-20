package com.example.trabajoSpringWeb.servicio;

import com.example.trabajoSpringWeb.entidad.productos;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class productoServicio {

    private List<productos> listaProductos = new ArrayList<>();

    public productoServicio() {
        listaProductos.add(new productos("001", "jabon", "personal", 100, 10, 1000, 9000));
        listaProductos.add(new productos("002", "cepillo", "personal", 200, 20, 2000, 18000));
        listaProductos.add(new productos("003", "lapiz", "miscelanea", 300, 30, 3000, 27000));
        listaProductos.add(new productos("004", "esfero", "miscelanea", 400, 40, 4000, 36000));
    }

    public double descuentoTotal(productos producto) {
        double descuento = (((producto.getPrecioUnidad() * producto.getCantidad())) * 10) / 100;
        return descuento;
    }

    public double valorTotal(productos producto) {
        double total = (producto.getPrecioUnidad() * producto.getCantidad()) * 0.9;
        return total;
    }

    public List<productos> listarProductos() {
        return listaProductos;
    }

    public List<productos> categoria(String categoria) {
        List<productos> listaCategoria = new ArrayList<>();
        for (productos c : listaProductos) {
            if (c.getCategoria().equals(categoria)) {
                listaCategoria.add(c);
            }
        }

        if (listaCategoria.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron productos para la categoría especificada.");
        }

        return listaCategoria;
    }

    public List<productos> agregarProducto(productos producto) {
        for (productos p : listaProductos) {
            if (p.getReferencia().equals(producto.getReferencia())) {
                throw new IllegalArgumentException("La referencia del producto ya existe.");
            }
        }

        listaProductos.add(new productos(producto.getReferencia(), producto.getNombre(), producto.getCategoria(),
                producto.getPrecioUnidad(), producto.getCantidad(), descuentoTotal(producto), valorTotal(producto)));

        return listaProductos;
    }
}
