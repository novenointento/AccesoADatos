/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class agenda implements Serializable {

    private Contacto c;

    private TreeMap<String, Contacto> agenda = new TreeMap();
    private FileOutputStream fos = null;
    private ObjectOutputStream salida = null;
    private FileInputStream fis = null;
    private ObjectInputStream fentrada = null;
    private byte menu;

    public void crearElDat() {
        try {
            fos = new FileOutputStream("agenda.dat", true);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void leerAgendaArchivoDat() {

        try {

            fis = new FileInputStream("agenda.dat");
            fentrada = new ObjectInputStream(fis);

            agenda = (TreeMap) fentrada.readObject();

            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("no encuentra el archivo dat");
        } catch (IOException ex) {
            System.out.println("no se puede leer/escribir el archivo, se crea la agenda");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void buscarPorCualquierValor() {
        System.out.println("introduce el valor a buscar");
        String villa;
        villa = LeerTeclado.leerCadena();
        System.out.println("Vemos si existe el valo 'Villa' en el Map: treeMap.containsValue(" + villa + ") = " + agenda.containsValue("Villa"));

    }

    public void buscarContacto() {
        System.out.println("introduzca el nombre a buscar");
        String nombre = LeerTeclado.leerCadena();
        System.out.println("introduzca el apellido a buscar");
        String apellido = LeerTeclado.leerCadena();
        nombre = nombre + apellido;
        nombre = nombre.toLowerCase();

        c = agenda.get(nombre);
        if (c == null) {
            System.out.println("no se ha encontrado ningun contacto con ese nombre");
        } else {
            System.out.println("Nombre: " + c.getP().getNombre());
            System.out.println("Apellido: " + c.getP().getApellidos());
            System.out.println("Correo:" + c.getCorreo());
            System.out.println("Telefonos" + c.getTelefonos().toString());
        }
    }
public void actualizarContacto(){System.out.println("introduzca el nombre a buscar");
        String nombre = LeerTeclado.leerCadena();
        System.out.println("introduzca el apellido a buscar");
        String apellido = LeerTeclado.leerCadena();
        nombre = nombre + apellido;
        nombre = nombre.toLowerCase();

        c = agenda.get(nombre);
        if (c == null) {
            System.out.println("no se ha encontrado ningun contacto con ese nombre");
        } else {System.out.println("introduzca datos nuevos");
        
        
        }}
    public void grabarAgendaArchivoDat() {
        try {
            fos = new FileOutputStream("agenda.dat");

            salida = new ObjectOutputStream(fos);
            salida.writeObject(agenda);
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void grabarContacto() {
        do {
            c = new Contacto();
            System.out.println("Introduce el nombre de la persona");
            String n = LeerTeclado.leerCadena();
            System.out.println("introduce el apellido de la persona");
            String a = LeerTeclado.leerCadena();
            System.out.println("Introduce el email de la persona");
            String e = LeerTeclado.leerCadena();
            System.out.println("Introduce el telefono de la persona");
            String t = LeerTeclado.leerCadena();
            c.crearContacto(n, a, e, t);
            n = n + a;
            n = n.toLowerCase();
          
            agenda.put(n, c);
            System.out.println("pulse 1 para meter otro contacto, 2 para salir");
            menu = LeerTeclado.leerByte();
        } while (menu == 1);
    }

    public void menu() {
        System.out.println("=====================================================");
        System.out.println("Selecciona una opcion: \n");
        System.out.println("Pulse 1 para introducir un contacto\n");
        System.out.println("Pulse 2 para buscar por un valor\n");
        System.out.println("Pulse 3 para buscar un contacto\n");
        System.out.println("Pulse 0 para salir\n");
    }

    /**
     * comprueba que el valor introducido por teclado sea correcto y este entre
     * los ofrecidos en el metodo menu devuelve un byte que usaremos en el bucle
     * del controlador para activar las distintas opciones
     *
     * @return byte
     */
    public byte SeguridadMenu() {
        System.out.println("introduzca la opcion de menu elegida");
        byte menu = LeerTeclado.leerByte();
        do {
            if (menu != 1 && menu != 2 && menu != 3 && menu != 0) {
                System.out.println("El numero introducido no es correcto");
                System.out.println("Intentelo de nuevo");
                System.out.println("Introduzca un numero del 1 al 3");
                menu = LeerTeclado.leerByte();
            }
        } while (menu != 1 && menu != 2 && menu != 3 && menu != 0);
        return menu;

    }
}
