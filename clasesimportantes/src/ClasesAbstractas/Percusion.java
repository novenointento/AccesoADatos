/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesAbstractas;

/**
 *
 * @author gnord
 */
public class Percusion extends Instrumento{
    
    public Percusion(String nombre) {
        super(nombre);
    }

    @Override
    public void tocar() {
        System.out.println("Golpeando mi"+nombre);
    }
    
}
