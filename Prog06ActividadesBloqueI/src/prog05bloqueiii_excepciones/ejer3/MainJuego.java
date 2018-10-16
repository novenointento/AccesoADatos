/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog05bloqueiii_excepciones.ejer3;

/**
 *
 * @author rpe
 */
public class MainJuego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jugador jugador;
        int numAdivinar;
        int opcionJugador;
        int maximo = 100;
        int minimo = 0;

        jugador = new Jugador("Pepe");
        numAdivinar = (int) (Math.random() * 101);

        do {
            opcionJugador = jugador.pedirNumero(minimo, maximo);
            if (opcionJugador != numAdivinar) {
                System.out.println("Has fallado, intentalo de nuevo pero te doy una ayuda...");
                if (opcionJugador < numAdivinar) {
                    minimo = opcionJugador + 1;
                } else {
                    maximo = opcionJugador - 1;
                }
            }
        } while (opcionJugador != numAdivinar);
        System.out.println("Has acertado el número era " + numAdivinar);
        System.out.println("Tu has dicho " + opcionJugador);
        System.out.println("Has necesitado " + jugador.getIntentos() + " intentos");

    }

}
