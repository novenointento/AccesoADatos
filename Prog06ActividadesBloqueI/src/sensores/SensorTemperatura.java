/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensores;

/**
 *
 * @author gnord
 */
public class SensorTemperatura extends Sensor {
    private final int valorMaximo=30;
    private final int valorMinimo=10;
    private final int desviacion=5;
   

    @Override
    public void calcularValores() {
      super.calcularValorInicial(valorMinimo, valorMaximo);
      super.mediciones.add(super.medicionInicial);      
        for(int i=0;i<9;i++){
        mediciones.add(medicionInicial-desviacion+(int)(Math.random()*(desviacion*2)));        
        }
    }
    
    
    
    
    
}
