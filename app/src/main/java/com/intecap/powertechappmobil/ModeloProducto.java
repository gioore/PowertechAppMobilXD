package com.intecap.powertechappmobil;

public class ModeloProducto {

    private String idProducto, nombreProducto, descripcionProducto;
    private int stockProducto;
    private boolean disponibilidadProducto;
    private double precioProducto;

    public ModeloProducto() {
    }

    public ModeloProducto(String idProducto, String nombreProducto, String descripcionProducto, int stockProducto, boolean disponibilidadProducto, double precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.stockProducto = stockProducto;
        this.disponibilidadProducto = disponibilidadProducto;
        this.precioProducto = precioProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public boolean isDisponibilidadProducto() {
        return disponibilidadProducto;
    }

    public void setDisponibilidadProducto(boolean disponibilidadProducto) {
        this.disponibilidadProducto = disponibilidadProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
}
