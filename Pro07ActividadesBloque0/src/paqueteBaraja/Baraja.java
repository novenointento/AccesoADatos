/*
 * Clase que crea una clase baraja con 52 cartas
 */
package paqueteBaraja;

public class Baraja {
    private final String[] VALOR={"AS","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private final char[] PALO={'♥','♦','♣','♠'};
    
    private Carta[]  baraja = new Carta[52];

    public Baraja() {
        System.out.println("Creando la baraja");
        int contCartas=0;
        for (int posPalo=0; posPalo<PALO.length; posPalo++){
            System.out.println("creando las cartas del palo "+PALO[posPalo]);
            for(int posValor=0; posValor<VALOR.length; posValor++){
                baraja[contCartas]= new Carta(VALOR[posValor],PALO[posPalo]);
                contCartas++;
            }            
        }
    }
    
    public void mostrarBaraja(){
        for (Carta objBaraja: this.baraja){
            System.out.println(objBaraja);
        }
    }
    
    
}
