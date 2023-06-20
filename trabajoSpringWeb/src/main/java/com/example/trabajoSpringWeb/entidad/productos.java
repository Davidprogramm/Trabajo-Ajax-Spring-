package com.example.trabajoSpringWeb.entidad;

public class productos {
    private String referencia;
    private String nombre;
    private String categoria;
    private int precioUnidad;
    private int cantidad;
    private double descuento;
    private double total;

    public productos(String referencia, String nombre, String categoria, int precioUnidad, int cantidad, double descuento, double total) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioUnidad = precioUnidad;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.total = total;
    }

    // getters y setters

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "productos{" +
                "referencia='" + referencia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precioUnidad=" + precioUnidad +
                ", cantidad=" + cantidad +
                ", descuento=" + descuento +
                ", total=" + total +
                '}';
    }
}
