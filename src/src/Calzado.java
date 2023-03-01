/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author sebas
 */
public class Calzado extends Producto {

    private String talla;

    public Calzado(String talla, String codigo, String descripcion, double precioCompra, double precioVenta, int cantBodega, int cantMinimaBodega, int cantMaxInventario) {
        super(codigo, descripcion, precioCompra, precioVenta, cantBodega, cantMinimaBodega, cantMaxInventario);
        this.talla = talla;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public boolean solicitarPedido() {
        return this.getCantBodega() < this.getCantMinimaBodega();
    }

    @Override
    public double calcularTotalPagar(int cantidad) {
        return cantidad < 0 ? 0 : (cantidad * this.getPrecioCompra());
    }

}
