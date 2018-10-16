package prog05bloqueiii_excepciones.ejer3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jugador {

    private String nombre;
    private int intentos;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int pedirNumero(int minimo, int maximo) {
        Scanner teclado = new Scanner(System.in);
        int num = 0;
        boolean noValido = true;
        while (noValido) {
            try {
                System.out.println("Introduce un número entre " + minimo + " y " + maximo);
                num = teclado.nextInt();
                if (num < minimo || num > maximo) {
                    throw new MiExcepcionErrorEntradaNumero("Número fuera de Rango");
                } else {
                    noValido = false;
                }
            } catch (MiExcepcionErrorEntradaNumero ex) {
                System.out.println(ex.getMessage());
            }
            catch (InputMismatchException ex){
                System.out.println("Has metido un valor no numerico");
                //para vaciar el buffer
                teclado.nextLine();
            }
     
        }
        intentos++;
        return num;
    }
}
