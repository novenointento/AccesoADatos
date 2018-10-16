/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioBasesDeDatos;

/**
 *
 * @author gnord
 */
public class MainEjercicio1 {

    public static void main(String[] args) {

        ControladorDAOS controlador = new ControladorDAOS();
        MenuConComprobacion menus = new MenuConComprobacion();
        String[] usrycon = new String[2];

        byte opcion;

        do {
            menus.menu();
            opcion = menus.Seguridad();
            switch (opcion) {
                case 1:
                    usrycon[0] = controlador.crearUsuario();
                    usrycon[1] = controlador.crearContraseña();
                    controlador.conectar(usrycon[0], usrycon[1]);
                    break;
                case 2:
                    menus.menuBusquedaUsuario();
                    int num = LeerTeclado.leerInt();
                    menus.cabeceraMostrarEmpleado();
                    controlador.buscarEmpleadoporNumero(num);
                    break;
                case 3:
                    menus.cabeceraMostrarEmpleado();
                    controlador.mostrarTodosLosEmpleadosOrdenadosPorDepartamento();
                    break;
                case 4:

                    break;
            }
            for (int i = 0; i < 4; i++) {
                System.out.println("");
            }
        } while (opcion != 0);
        controlador.desconeztar();
        System.out.println("Ha salido del programa");

    }

}
