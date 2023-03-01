/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author sebas
 */
public abstract class Producto {

    private double porcentaje = 0.01;

    private String codigo;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int cantBodega;
    private int cantMinimaBodega;
    private int cantMaxInventario;

    public Producto() {
    }

    public Producto(String codigo, String descripcion, double precioCompra, double precioVenta, int cantBodega, int cantMinimaBodega, int cantMaxInventario) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantBodega = cantBodega;
        this.cantMinimaBodega = cantMinimaBodega;
        this.cantMaxInventario = cantMaxInventario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantBodega() {
        return cantBodega;
    }

    public void setCantBodega(int cantBodega) {
        this.cantBodega = cantBodega;
    }

    public int getCantMinimaBodega() {
        return cantMinimaBodega;
    }

    public void setCantMinimaBodega(int cantMinimaBodega) {
        this.cantMinimaBodega = cantMinimaBodega;
    }

    public int getCantMaxInventario() {
        return cantMaxInventario;
    }

    public void setCantMaxInventario(int cantMaxInventario) {
        this.cantMaxInventario = cantMaxInventario;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public abstract boolean solicitarPedido();

    public abstract double calcularTotalPagar(int cantidad);

}
