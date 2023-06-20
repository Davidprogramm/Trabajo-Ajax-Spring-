package com.example.trabajoSpringWeb.controlador;

import com.example.trabajoSpringWeb.entidad.productos;
import com.example.trabajoSpringWeb.servicio.productoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")


public class productosControlador {

    private productoServicio productosServicio;

    public productosControlador(productoServicio productosServicio) {
        this.productosServicio = productosServicio;
    }

    @GetMapping("/listar")
    public List<productos> listarProductos() {
        return productosServicio.listarProductos();
    }

    @GetMapping("/categoria/{categoria}")
    public List<productos> categoria(@PathVariable String categoria) {
        return productosServicio.categoria(categoria);
    }

    @PostMapping("/agregar")
    public List<productos> agregar(@RequestBody productos productos) {
        return productosServicio.agregarProducto(productos);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
