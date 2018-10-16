/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.agenda;

/**
 *
 * @author gnord
 */
public class controlador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        agenda a= new agenda();
        byte menu;
        a.crearElDat();
        a.leerAgendaArchivoDat();
        
        do {
            a.menu();
            menu = a.SeguridadMenu();
            switch (menu) {
                case 1:
                    a.grabarContacto();
                    a.grabarAgendaArchivoDat();
                    break;
                case 2:
                    a.buscarPorCualquierValor();
                    break;
                case 3:
                    a.buscarContacto();
                    a.grabarAgendaArchivoDat();
                    break;
                
            }
            
        } while (menu != 0);
        System.out.println("Ha salido del programa");
    
        
     
    }
    
}
