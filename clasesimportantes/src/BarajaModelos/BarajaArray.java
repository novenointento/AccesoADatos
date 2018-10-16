package BarajaModelos;

import BarajaModelos.Carta;

public class BarajaArray {

    private Carta[] baraja;
    private final String[] PALOSBARAJAFRANCESA = {"♠", "♣", "♦", "♥"};
    private final String[] TIPOSBARAJAFRANCESA = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public BarajaArray() {
        baraja = new Carta[52];
        int valor;
        int posicion = 0;

        for (String palo : PALOSBARAJAFRANCESA) {
            valor = 1;
            for (String tipo : TIPOSBARAJAFRANCESA) {
                Carta carta = new Carta(tipo, palo, valor);
                baraja[posicion] = carta;
                posicion++;
                valor++;
            }
        }
    }
    
    public void verBaraja(){
        for(Carta carta:baraja){
            System.out.println(carta);
        }
    }
    
    public void setBaraja(Carta[] baraja){
        this.baraja=baraja;
    }
    

}
