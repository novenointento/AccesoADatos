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
public class InstrumentosClasesAbstractas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Instrumento cuerda= new Cuerda("violin");
      Instrumento viento= new Viento("flauta");
      Instrumento tambor= new Percusion("tambor");
      Orquesta ospa= new Orquesta();
      
      
      ospa.AfinarInstrumento(viento);
      ospa.AfinarInstrumento(cuerda);
      ospa.AfinarInstrumento(tambor);
      
      
    }
    
}
