/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author sebas
 */
public class Prenda extends Producto {

    private String talla;
    private boolean permitePlanchado;

    public Prenda(String talla, boolean permitePlanchado, String codigo, String descripcion, double precioCompra, double precioVenta, int cantBodega, int cantMinimaBodega, int cantMaxInventario) {
        super(codigo, descripcion, precioCompra, precioVenta, cantBodega, cantMinimaBodega, cantMaxInventario);
        this.talla = talla;
        this.permitePlanchado = permitePlanchado;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public boolean isPermitePlanchado() {
        return permitePlanchado;
    }

    public void setPermitePlanchado(boolean permitePlanchado) {
        this.permitePlanchado = permitePlanchado;
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
