/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;



/**
 *
 * @author gnord
 */
public class MainCalculadoraBucles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CalculadoraConMenu calculadora;
        
        calculadora=new CalculadoraConMenu();
        
        calculadora.menu();
        calculadora.cuentas();

        
    }
        
}
