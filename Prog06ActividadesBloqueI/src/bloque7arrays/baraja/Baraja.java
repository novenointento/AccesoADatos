package bloque7arrays.baraja;

/**
 *
 * @author gnord
 */
public class Baraja {

    private final String[] VALOR = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "k"};
    private char PALO[] = {'♥', '♠', '♦', '♣'};
    private Naipe[] baraja = new Naipe[52];

    public Baraja() {

    }

    public void barajaFrancesa() {
        System.out.println("Creando baraja");
        int contador = 0;
        for (int i = 0; i < PALO.length; i++) {
            System.out.println("Creando las cartas del palo " + PALO[i]);
            for (int g = 0; g < VALOR.length; g++) {
                baraja[contador] = new Naipe(PALO[i], VALOR[g]);
                contador++;
            }

        }
    }

    @Override
    public String toString() {
        return "Baraja{" + "VALOR=" + VALOR + ", PALO=" + PALO + ", baraja=" + baraja + '}';
    }

    public void mostrarBaraja() {

        for (Naipe objBaraja : this.baraja) {
            System.out.println(objBaraja);
        }

    }

    public char[] getPALO() {
        return PALO;
    }

    public void setPALO(char[] PALO) {
        this.PALO = PALO;
    }

    public Naipe[] getBaraja() {
        return baraja;
    }

    public void setBaraja(Naipe[] baraja) {
        this.baraja = baraja;
    }

}
