/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import Controlador.ControladorProductos;
import javax.swing.JOptionPane;
import src.Calzado;
import src.Prenda;

/**
 *
 * @author sebas
 */
public class Vista {

    Prenda prenda;
    Calzado calzado;

    public static void main(String[] args) {

        ControladorProductos controlador = new ControladorProductos();
        int opcion1, opcion2, opcion3, opcion4, opcion5, opcion6, opcionModificar;

        do {

            opcion1 = Integer.parseInt(JOptionPane.showInputDialog("¡BIENVENIDO AL MENU DE PRODUCTOS! \nIngrese una opcion: "
                    + "\n1- Consultar productos"
                    + "\n2- Gestionar productos"
                    + "\n3- Salir"));

            switch (opcion1) {

                case 1:

                    do {

                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion: "
                                + "\n1- Prendas de Vestir"
                                + "\n2- Calzado"
                                + "\n3 - Salir"));

                        switch (opcion2) {
                            case 1:

                                //Menu de consulta de prendas de vestir
                                do {

                                    opcion5 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion: "
                                            + "\n1- Consultar prenda de vestir "
                                            + "\n2- Verificar prendas a pedir"
                                            + "\n3- Prenda de vestir con mayor unidades "
                                            + "\n4- Modificar cantidad minima en Bodega de prendas "
                                            + "\n5- Vender prenda de vestir "
                                            + "\n6 - Salir"));

                                    switch (opcion5) {

                                        case 1:
                                            break;

                                        case 2:
                                            break;

                                        case 3:
                                            break;

                                        case 4:
                                            break;

                                        case 5:
                                            break;

                                        default:
                                            break;
                                    }

                                } while (opcion5 != 6);

                                break;

                            case 2:
                                //Menu de consulta de calzados

                                do {

                                    opcion6 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion: "
                                            + "\n1- Consultar calzado "
                                            + "\n2- Verificar calzado a pedir"
                                            + "\n3- Calzado con mayor unidades "
                                            + "\n4- Modificar cantidad minima en Bodega de calzado "
                                            + "\n5- Vender calzado "
                                            + "\n6 - Salir"));

                                    switch (opcion6) {

                                        case 1:
                                            break;

                                        case 2:
                                            break;

                                        case 3:
                                            break;

                                        case 4:
                                            break;

                                        case 5:
                                            break;

                                        default:
                                            break;
                                    }

                                } while (opcion6 != 6);

                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "[Warning]\n¡Ingrese una opcion valida porfavor!");
                                break;

                        }

                    } while (opcion2 != 3);

                    break;

                case 2:

                    do {

                        opcion3 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion: "
                                + "\n1- Prendas de Vestir"
                                + "\n2- Calzado"
                                + "\n3- Salir"));

                        switch (opcion3) {

                            case 1:

                                //Prendas de Vestir
                                do {
                                    opcion4 = Integer.parseInt(JOptionPane.showInputDialog("¡GESTIONA TUS PRENDAS DE VESTIR!"
                                            + "\nIngrese una opcion:\n "
                                            + "\n1- Registrar nueva prenda"
                                            + "\n2- Modificar prenda"
                                            + "\n3- Eliminar prenda"
                                            + "\n4- Consultar prenda"
                                            + "\n5- Salir"));
                                    switch (opcion4) {

                                        case 1:

                                            //Registrar nueva prenda de vestir
                                            String codigo = JOptionPane.showInputDialog("Ingrese codigo: ");

                                            Prenda aux = controlador.consultarPrenda(codigo);

                                            if (aux == null) {
                                                String descripcion = JOptionPane.showInputDialog("Ingrese descripcion: ");
                                                double precioCompra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio de compra:"));
                                                double precioVenta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio de venta:"));
                                                int cantBodega = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad en bodega:"));

                                                int cantMinimaBodega = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad minima en bodega:"));
                                                int cantMaxBodega = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad maxima en bodega:"));

                                                String talla = JOptionPane.showInputDialog("Ingrese una talla:\n "
                                                        + "Ejemplo: XS - S - M - L - XL ");

                                                int permitePlanchadoOpcion = Integer.parseInt(JOptionPane.showInputDialog("¿Permite planchado? \n [1]- SI\n[2]- NO"));
                                                boolean permitePlanchado = true;

                                                if (permitePlanchadoOpcion != 1) {

                                                    permitePlanchado = false;

                                                }

                                                //Creamos objeto de prenda con los datos recogidos
                                                Prenda prenda = new Prenda(talla, permitePlanchado, codigo, descripcion, precioCompra, precioVenta, cantBodega, cantMinimaBodega, cantMaxBodega);

                                                boolean registro = controlador.registrarPrenda(prenda);

                                                JOptionPane.showMessageDialog(null, registro ? "Registro de prenda exitoso " : "Algo salio mal registrando la prenda");
                                                controlador.imprimirPrendas();
                                                break;

                                            }
                                            JOptionPane.showMessageDialog(null, "Esta prenda ya se encuentra registrada con el codigo ingresado...");

                                            break;

                                        case 2:

                                            //Modificar una prenda de vestir
                                            String code = JOptionPane.showInputDialog("Digite el codigo de la prenda que desea modificar...");

                                            Prenda aux2 = controlador.consultarPrenda(code);

                                            if (aux2 != null) {

                                                do {
                                                    opcionModificar = Integer.parseInt(JOptionPane.showInputDialog("Codigo de prenda [" + aux2.getCodigo() + "]\n"
                                                            + "¿Que deseas modificar?\n\n"
                                                            + "[1]-Descripcion: " + aux2.getDescripcion() + "\n"
                                                            + "[2]-Precio de Compra: " + aux2.getPrecioCompra() + "\n"
                                                            + "[3]-Precio de Venta: " + aux2.getPrecioVenta() + "\n"
                                                            + "[4]-Cantidad en bodega: " + aux2.getCantBodega() + "\n"
                                                            + "[5]-Cantidad minima en bodega: " + aux2.getCantMinimaBodega() + "\n"
                                                            + "[6]-Cantidad maxima en Inventario: " + aux2.getCantMaxInventario() + "\n"
                                                            + "[7]-Talla: " + aux2.getTalla() + "\n"
                                                            + "[8]-Permite planchado: " + aux2.isPermitePlanchado() + "\n"
                                                            + "\n[9] - Salir del menu modificador"
                                                    ));

                                                    switch (opcionModificar) {

                                                        //MODIFICAR A TRIBUTOS ESPECIFICOS DE LA PRENDA
                                                        case 1:

                                                            //Descripcion
                                                            String descripcionNew = JOptionPane.showInputDialog("Modificando prenda: [" + aux2.getCodigo() + "]\n"
                                                                    + "Ingrese nueva descripcion para esta prenda...");

                                                            Prenda prendaModificadDes = new Prenda(aux2.getTalla(), aux2.isPermitePlanchado(),
                                                                    aux2.getCodigo(), descripcionNew, aux2.getPrecioCompra(),
                                                                    aux2.getPrecioVenta(), aux2.getCantBodega(), aux2.getCantMinimaBodega(),
                                                                    aux2.getCantMaxInventario());

                                                            boolean modificar = controlador.modificarPrenda(prendaModificadDes);

                                                            JOptionPane.showMessageDialog(null, modificar ? "Modificada exitosamente" : "No se modifico");
                                                            break;
                                                        case 2:
                                                            //Precio de compra

                                                            double precioCompraNew = Double.parseDouble(JOptionPane.showInputDialog("Modificando prenda: [" + aux2.getCodigo() + "]\n"
                                                                    + "Ingrese nuevo precio de compra para esta prenda..."));

                                                            Prenda prendaModificadaCompra = new Prenda(aux2.getTalla(), aux2.isPermitePlanchado(),
                                                                    aux2.getCodigo(), aux2.getDescripcion(), precioCompraNew,
                                                                    aux2.getPrecioVenta(), aux2.getCantBodega(), aux2.getCantMinimaBodega(),
                                                                    aux2.getCantMaxInventario());

                                                            boolean modificarCompra = controlador.modificarPrenda(prendaModificadaCompra);

                                                            JOptionPane.showMessageDialog(null, modificarCompra ? "Modificada exitosamente" : "No se modifico");
                                                            break;

                                                        case 3:
                                                            //Precio de Venta
                                                            double precioVentaNew = Double.parseDouble(JOptionPane.showInputDialog("Modificando prenda: [" + aux2.getCodigo() + "]\n"
                                                                    + "Ingrese nuevo precio de venta para esta prenda..."));

                                                            Prenda prendaModificadaVent = new Prenda(aux2.getTalla(), aux2.isPermitePlanchado(),
                                                                    aux2.getCodigo(), aux2.getDescripcion(), aux2.getPrecioCompra(),
                                                                    precioVentaNew, aux2.getCantBodega(), aux2.getCantMinimaBodega(),
                                                                    aux2.getCantMaxInventario());

                                                            boolean modificarVenta = controlador.modificarPrenda(prendaModificadaVent);

                                                            JOptionPane.showMessageDialog(null, modificarVenta ? "Modificada exitosamente" : "No se modifico");
                                                            break;

                                                        case 4:
                                                            //Cantidad Bodega
                                                            int precioCantBodNew = Integer.parseInt(JOptionPane.showInputDialog("Modificando prenda: [" + aux2.getCodigo() + "]\n"
                                                                    + "Ingrese nueva cantidad en Bodega para esta prenda..."));

                                                            Prenda prendaModificadaCantBod = new Prenda(aux2.getTalla(), aux2.isPermitePlanchado(),
                                                                    aux2.getCodigo(), aux2.getDescripcion(), aux2.getPrecioCompra(),
                                                                    aux2.getPrecioVenta(), precioCantBodNew, aux2.getCantMinimaBodega(),
                                                                    aux2.getCantMaxInventario());

                                                            boolean modificarCantBod = controlador.modificarPrenda(prendaModificadaCantBod);

                                                            JOptionPane.showMessageDialog(null, modificarCantBod ? "Modificada exitosamente" : "No se modifico");
                                                            break;

                                                        case 5:
                                                            //Cantidad Minima Bodega
                                                            int precioCantMinBodNew = Integer.parseInt(JOptionPane.showInputDialog("Modificando prenda: [" + aux2.getCodigo() + "]\n"
                                                                    + "Ingrese nueva cantidad minima en Bodega para esta prenda..."));

                                                            Prenda prendaModificadaCantMinBod = new Prenda(aux2.getTalla(), aux2.isPermitePlanchado(),
                                                                    aux2.getCodigo(), aux2.getDescripcion(), aux2.getPrecioCompra(),
                                                                    aux2.getPrecioVenta(), aux2.getCantBodega(), precioCantMinBodNew,
                                                                    aux2.getCantMaxInventario());

                                                            boolean modificarCantMinBod = controlador.modificarPrenda(prendaModificadaCantMinBod);

                                                            JOptionPane.showMessageDialog(null, modificarCantMinBod ? "Modificada exitosamente" : "No se modifico");
                                                            break;
                                                        case 6:
                                                            //Cantidad Maxima Inventario
                                                            int precioCantMaxInvNew = Integer.parseInt(JOptionPane.showInputDialog("Modificando prenda: [" + aux2.getCodigo() + "]\n"
                                                                    + "Ingrese nueva cantidad maxima en Inventario para esta prenda..."));

                                                            Prenda prendaModificadaCantMaxInvBod = new Prenda(aux2.getTalla(), aux2.isPermitePlanchado(),
                                                                    aux2.getCodigo(), aux2.getDescripcion(), aux2.getPrecioCompra(),
                                                                    aux2.getPrecioVenta(), aux2.getCantBodega(), aux2.getCantMinimaBodega(),
                                                                    precioCantMaxInvNew);

                                                            boolean modificarCantMaxInv = controlador.modificarPrenda(prendaModificadaCantMaxInvBod);

                                                            JOptionPane.showMessageDialog(null, modificarCantMaxInv ? "Modificada exitosamente" : "No se modifico");
                                                            break;
                                                        case 7:
                                                            //Talla
                                                            String tallaNew = JOptionPane.showInputDialog("Modificando prenda: [" + aux2.getCodigo() + "]\n"
                                                                    + "Ingrese nueva talla para esta prenda...");

                                                            Prenda prendaModificadTalla = new Prenda(tallaNew, aux2.isPermitePlanchado(),
                                                                    aux2.getCodigo(), aux2.getDescripcion(), aux2.getPrecioCompra(),
                                                                    aux2.getPrecioVenta(), aux2.getCantBodega(), aux2.getCantMinimaBodega(),
                                                                    aux2.getCantMaxInventario());

                                                            boolean modificarTalla = controlador.modificarPrenda(prendaModificadTalla);

                                                            JOptionPane.showMessageDialog(null, modificarTalla ? "Modificada exitosamente" : "No se modifico");
                                                            break;

                                                        case 8:
                                                            //Permite aplanchado?

                                                            int permiteAplanchado = Integer.parseInt(JOptionPane.showInputDialog("Modificando prenda: [" + aux2.getCodigo() + "]\n"
                                                                    + "¿Permite aplanchado? \n"
                                                                    + "1- [SI]\n"
                                                                    + "2- [NO]"));

                                                            boolean permiteModificado;
                                                            if (permiteAplanchado == 1) {
                                                                permiteModificado = true;
                                                            } else if (permiteAplanchado == 2) {
                                                                permiteModificado = false;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Digite una opcion correcta...");
                                                                break;
                                                            }
                                                            ;

                                                            Prenda prendaModificarPlanchado = new Prenda(aux2.getTalla(), permiteModificado,
                                                                    aux2.getCodigo(), aux2.getDescripcion(), aux2.getPrecioCompra(),
                                                                    aux2.getPrecioVenta(), aux2.getCantBodega(), aux2.getCantMinimaBodega(),
                                                                    aux2.getCantMaxInventario());

                                                            boolean modificarPlanchado = controlador.modificarPrenda(prendaModificarPlanchado);

                                                            JOptionPane.showMessageDialog(null, modificarPlanchado ? "Modificada exitosamente" : "No se modifico");
                                                            break;

                                                    }

                                                } while (opcionModificar != 9);

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Esta prenda no esta registrada...");

                                            }
                                            break;
                                        case 3:

                                            //Eliminar una prenda de vestir
                                            String msg = controlador.mostrarPrendasRegistradas();

                                            String codigoDelete = JOptionPane.showInputDialog("DIGITE EL CODIGO DE LA PRENDA A ELIMINAR\n\n"
                                                    + msg);

                                            break;

                                        case 4:

                                            //Consultar una prenda de vestir
                                            break;

                                        default:
                                            JOptionPane.showMessageDialog(null, "[Warning]\n¡Ingrese una opcion valida porfavor!");
                                            break;
                                    }

                                } while (opcion4 != 5);

                                break;

                            case 2:

                                //Calzado
                                do {
                                    opcion4 = Integer.parseInt(JOptionPane.showInputDialog("¡GESTIONA TU CALZADO!"
                                            + "\nIngrese una opcion:\n "
                                            + "\n1- Registrar nuevo calzado"
                                            + "\n2- Modificar calzado"
                                            + "\n3- Eliminar calzado"
                                            + "\n4- Consultar calzado"
                                            + "\n5- Salir"));
                                    switch (opcion4) {

                                        case 1:

                                            //Registrar nuevo calzado
                                            break;

                                        case 2:

                                            //Modificar un calzado
                                            break;
                                        case 3:

                                            //Eliminar un calzado
                                            break;

                                        case 4:

                                            //Consultar un calzado
                                            break;

                                        default:
                                            break;
                                    }

                                } while (opcion4 != 5);

                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "[Warning]\n¡Ingrese una opcion valida porfavor!");

                                break;

                        }

                    } while (opcion3 != 3);

                    break;

                default:

                    JOptionPane.showMessageDialog(null, "[Warning]\n¡Ingrese una opcion valida porfavor!");
                    break;
            }

        } while (opcion1 != 3);
    }

}
