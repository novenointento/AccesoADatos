package BarajaModelos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BarajaColeccion {

    // ATRIBUTOS
    
    private List<Carta> baraja;
    private final String[] PALOS = {"♠", "♣", "♦", "♥"};
    private final String[] TIPOS = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    
    // METODOS
    
    public BarajaColeccion() {
        baraja = new LinkedList<>();
    }
    
    public void rellenarBaraja(){
        int valor;
        for (String palo : PALOS) {
            valor = 1;
            for (String tipo : TIPOS) {
                Carta carta = new Carta(tipo, palo, valor);
                baraja.add(carta);
                valor++;
            }
        }
    }

    public List<Carta> getBaraja() {
        return baraja;
    }
    
    public void setBaraja(List<Carta> baraja) {
        this.baraja = baraja;
    }

    // ESPECIFICOS
    
    public void verBaraja() {
        for (Carta carta : baraja) {
            System.out.println(carta.toString());
        }
    }

    public boolean barajar() {
        HashSet<Carta> barajaAux = new HashSet<>();
        if (!baraja.isEmpty() && barajaAux.addAll(baraja)) {
            baraja.clear();
            return baraja.addAll(barajaAux);
        } else {
            return false;
        }
    }
    
    public Carta sacarCartaArriba(){
        Carta carta = baraja.get(0);
        baraja.remove(0);
        return carta;
    }
    
    public boolean meterCartaAbajo(Carta carta){
        return baraja.add(carta);
    }

    
    
    
    
    
}
