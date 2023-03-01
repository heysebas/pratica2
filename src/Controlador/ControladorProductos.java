/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import src.Calzado;
import src.Prenda;

/**
 *
 * @author sebas
 */
public class ControladorProductos {
     private Prenda[] prendas;
    private Calzado[] calzados;

    public ControladorProductos() {

        prendas = new Prenda[10];
        calzados = new Calzado[15];
    }

    public int tamañoPrendasAmanejar() {
        return prendas.length;
    }

    public int tamañoCalzadosAmanejar() {
        return calzados.length;
    }

    //Registrar nuevos productos
    public boolean registrarPrenda(Prenda prenda) {

        Prenda aux = consultarPrenda(prenda.getCodigo());

        if (aux == null) {

            for (int i = 0; i < prendas.length; i++) {

                if (prendas[i] == null) {

                    prendas[i] = prenda;

                    return true;

                }
            }

        }
        return false;

    }

    public Prenda consultarPrenda(String codigo) {

        for (int i = 0; i < prendas.length; i++) {

            if (prendas[i] != null) {

                if (prendas[i].getCodigo().equals(codigo)) {
                    return prendas[i];

                }

            }
        }

        return null;

    }

    public boolean modificarPrenda(Prenda prenda) {

        Prenda aux = consultarPrenda(prenda.getCodigo());

        if (aux != null) {

            aux.setDescripcion(prenda.getDescripcion());
            aux.setPrecioCompra(prenda.getPrecioCompra());
            aux.setPrecioVenta(prenda.getPrecioVenta());
            aux.setCantBodega(prenda.getCantBodega());
            aux.setCantMinimaBodega(prenda.getCantMinimaBodega());
            aux.setCantMaxInventario(prenda.getCantMaxInventario());
            aux.setTalla(prenda.getTalla());
            aux.setPermitePlanchado(prenda.isPermitePlanchado());

            return true;
        }

        return false;
    }

    public boolean eliminarPrenda(String codigo) {
        Prenda aux = consultarPrenda(codigo);

        if (aux != null) {
            for (int i = 0; i < prendas.length; i++) {

                if (prendas[i].getCodigo().equals(codigo)) {
                    prendas[i] = null;
                    return true;
                }

            }
        }
        return false;
    }

    public int contadorPrendas() {

        int contador = 0;
        for (int i = 0; i < prendas.length; i++) {

            if (prendas[i] != null) {

                contador++;

            }
        }

        return contador;
    }

    public String mostrarPrendasRegistradas() {

        System.out.println(contadorPrendas());

        String msg = "Prendas registradas: \n\n";

        if (contadorPrendas() != 0) {

            for (int i = 0; i < prendas.length; i++) {

                if (prendas[i] != null) {

                    msg += "Codigo de prenda: [ " + prendas[i].getCodigo() + " ] // Descripcion: [" + prendas[i].getDescripcion() + "] \n";

                }

            }

        } else {

            msg += "No hay prendas registradas en el momento...";
        }

        return msg;
    }

    //Imprimir prendas en consola (TESTING)
    public void imprimirPrendas() {

        for (int i = 0; i < prendas.length; i++) {

            if (prendas[i] != null) {

                System.out.println("Prenda: " + prendas[i].getCodigo());

            }
        }
    }

    //Prendas que se deben pedir 
    public String prendasApedir() {

        int contador = contadorPrendas();
        String msg = "LAS PRENDAS QUE SE DEBEN PEDIR SON:\n\n ";

        if (contador != 0) {

            for (int i = 0; i < prendas.length; i++) {

                if (prendas[i] != null) {
                    if (prendas[i].solicitarPedido()) {

                        msg += "[" + (i + 1) + "] - Codigo: " + prendas[i].getCodigo() + " - Descripcion: " + prendas[i].getDescripcion() + "\n";
                    }
                }
            }

        } else {
            msg = "No hay prendas registradas...";
        }
        return msg;

    }
    
    public Prenda prendasConMayorUnidades() {

        int cantidadPrendas = contadorPrendas();

        int aux = 0;
        Prenda cal = null;

        if (cantidadPrendas != 0) {

            for (int i = 0; i < prendas.length; i++) {

                if (prendas[i] != null) {

                    if (prendas[i].getCantBodega() > aux) {

                        aux = prendas[i].getCantBodega();
                        cal = prendas[i];

                    }
                }
            }
        }

        return cal;

    }

    //===========CALZADO======================
    public boolean registrarCalzado(Calzado calzado) {

        Calzado aux = consultarCalzado(calzado.getCodigo());

        if (aux == null) {

            for (int i = 0; i < calzados.length; i++) {

                if (calzados[i] == null) {

                    calzados[i] = calzado;

                    return true;

                }
            }

        }
        return false;

    }

    public Calzado consultarCalzado(String codigo) {

        for (int i = 0; i < calzados.length; i++) {

            if (calzados[i] != null) {

                if (calzados[i].getCodigo().equals(codigo)) {
                    return calzados[i];

                }

            }
        }

        return null;

    }

    public boolean modificarCalzado(Calzado calzado) {

        Calzado aux = consultarCalzado(calzado.getCodigo());

        if (aux != null) {

            aux.setDescripcion(calzado.getDescripcion());
            aux.setPrecioCompra(calzado.getPrecioCompra());
            aux.setPrecioVenta(calzado.getPrecioVenta());
            aux.setCantBodega(calzado.getCantBodega());
            aux.setCantMinimaBodega(calzado.getCantMinimaBodega());
            aux.setCantMaxInventario(calzado.getCantMaxInventario());
            aux.setTalla(calzado.getTalla());

            return true;
        }

        return false;
    }

    public boolean eliminarCalzado(String codigo) {
        Calzado aux = consultarCalzado(codigo);

        if (aux != null) {
            for (int i = 0; i < calzados.length; i++) {

                if (calzados[i].getCodigo().equals(codigo)) {
                    calzados[i] = null;
                    return true;
                }

            }
        }
        return false;
    }

    public int contadorCalzados() {

        int contador = 0;
        for (int i = 0; i < calzados.length; i++) {

            if (calzados[i] != null) {

                contador++;

            }
        }

        return contador;
    }

    public String mostrarCalzadosRegistrados() {

        System.out.println(contadorCalzados());

        String msg = "Calzados registrados: \n\n";

        if (contadorCalzados() != 0) {

            for (int i = 0; i < calzados.length; i++) {

                if (calzados[i] != null) {

                    msg += "Codigo de calzado: [ " + calzados[i].getCodigo() + " ] // Descripcion: [" + calzados[i].getDescripcion() + "] \n";

                }

            }

        } else {

            msg += "No hay calzados registrados en el momento...";
        }

        return msg;
    }

    public void imprimirCalzados() {

        for (int i = 0; i < calzados.length; i++) {

            if (calzados[i] != null) {

                System.out.println("Calzado: " + calzados[i].getCodigo());

            }
        }
    }

    //Prendas que se deben pedir 
    public String calzadosApedir() {

        int contador = contadorCalzados();
        String msg = "LOS CALZADOS QUE SE DEBEN PEDIR SON:\n\n ";

        if (contador != 0) {

            for (int i = 0; i < calzados.length; i++) {

                if (calzados[i] != null) {
                    if (calzados[i].solicitarPedido()) {

                        msg += "[" + (i + 1) + "] - Codigo: " + calzados[i].getCodigo() + " - Descripcion: " + calzados[i].getDescripcion() + "\n";
                    }
                }
            }

        } else {
            msg = "No hay prendas registradas...";
        }
        return msg;

    }

    public Calzado calzadoConMayorUnidades() {

        int cantidadCalzados = contadorCalzados();

        int aux = 0;
        Calzado cal = null;

        if (cantidadCalzados != 0) {

            for (int i = 0; i < calzados.length; i++) {

                if (calzados[i] != null) {

                    if (calzados[i].getCantBodega() > aux) {

                        aux = calzados[i].getCantBodega();
                        cal = calzados[i];

                    }
                }
            }
        }

        return cal;

    }
    
}
