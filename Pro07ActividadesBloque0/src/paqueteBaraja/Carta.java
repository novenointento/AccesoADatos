
package paqueteBaraja;

/**
 * clase carta
 * @author rpe
 */
public class Carta {
    private String valor;
    private char palo;

    public Carta(String valor, char palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public char getPalo() {
        return palo;
    }

    public void setPalo(char palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "Carta{" + "valor=" + valor + ", palo=" + palo + '}';
    }   
    
}
