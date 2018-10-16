package ArraysColecciones;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Silvia Leon
 */
public class GestorArrayInt {

    public GestorArrayInt() {
    }

    //BUSCAR
    public int buscarPrimero(int[] array, int numero) {
        int posicionNum = -1;
        int posicion = 0;
        while ((posicion < array.length) && (posicionNum == -1)) {
            if (array[posicion] == numero) {
                posicionNum = posicion;
            } else {
                posicion++;
            }
        }
        return posicionNum;
    }

    public int[] buscarPrimero(int[][] array, int numero) {
        int[] coordenadas = {-1, -1};
        int fila = 0;
        while ((fila < array.length) || (coordenadas[1] != -1)) {
            coordenadas[1] = buscarPrimero(array[fila], numero);
            if (coordenadas[1] != -1) {
                coordenadas[0] = fila;
            } else {
                fila++;
            }
        }
        return coordenadas;
    }
    

    // ARRAYS
    public int[] arrayNumerosAleatorios(int tamaño, int min, int max) {
        int[] array = new int[tamaño];
        for (int posicion = 0; posicion < array.length; posicion++) {
            array[posicion] = (int) (Math.random() * max + min);
        }
        return array;
    }

    public int[] arrayBinario(int tamaño) {
        int[] array = new int[tamaño];
        for (int posicion = 0; posicion < array.length; posicion++) {
            array[posicion] = (int) (Math.round(Math.random()));
        }
        return array;
    }

    public float mediaArray(int[] array) {
        float media = 0;
        for (int x = 0; x < array.length; x++) {
            media += array[x];
        }
        return (media / array.length);
    }

    public int totalArray(int[] array) {
        int total = 0;
        for (int x = 0; x < array.length; x++) {
            total += array[x];
        }
        return total;
    }

    public void verArray(int[] array, String separador) {
        for (int numero : array) {
            System.out.print(numero + separador);
        }
        System.out.print("\n");
    }

    public int[] ordenarArray(int[] array, boolean ascendente) {

        // Volcar el array en ArrayList y ordenar
        ArrayList<Integer> a = new ArrayList<>();
        for (int i : array) {
            a.add(i);
        }
        a.sort(null);

        // Volcar en int[] y devolver
        int[] arrayOrdenado = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            if (ascendente) {
                arrayOrdenado[i] = a.get(i);
            } else {
                arrayOrdenado[i] = a.get(a.size() - i - 1);
            }
        }
        return arrayOrdenado;
    }

    // MATRICES
    public int[][] matrizNumerosAleatorios(int filas, int columnas, int min, int max) {
        int[][] array = new int[filas][];
        for (int fila = 0; fila < array.length; fila++) {
            array[fila] = new int[columnas];
            for (int columna = 0; columna < array[fila].length; columna++) {
                array[fila][columna] = (int) (Math.random() * max + min);
            }
        }
        return array;
    }

    public int[][] matrizBinaria(int filas, int columnas) {
        int[][] array = new int[filas][];
        for (int fila = 0; fila < array.length; fila++) {
            array[fila] = new int[columnas];
            for (int columna = 0; columna < array[fila].length; columna++) {
                array[fila][columna] = (int) (Math.round(Math.random()));
            }
        }
        return array;
    }

    public float mediaColumnaMatriz(int[][] matriz, int columna) {
        float media = 0;
        for (int fila = 0; fila < matriz.length; fila++) {
            media += matriz[fila][columna];
        }
        return (media / matriz.length);
    }

    public int totalColumnaMatriz(int[][] matriz, int columna) {
        int total = 0;
        for (int fila = 0; fila < matriz.length; fila++) {
            total += matriz[fila][columna];
        }
        return total;
    }

    public int totalMatriz(int[][] matriz) {
        int total = 0;
        for (int[] fila : matriz) {
            for (int celda = 0; celda < fila.length; celda++) {
                total += fila[celda];
            }
        }
        return total;
    }

    public void verTotalFilasColumnasMatriz(int[][] matriz) {
        // Imprimir la matriz
        for (int[] fila : matriz) {
            for (int celda : fila) {
                System.out.print(celda + "\t");
            }
            System.out.print(totalArray(fila) + "\n");
        }
        // Imprimir la suma de las filas y columnas de la matriz
        for (int columna = 0; columna < matriz[0].length; columna++) {
            System.out.print(totalColumnaMatriz(matriz, columna) + "\t");
        }
        System.out.print("\n");
    }

    // ARRAYS BIDIMENSIONALES DESIGUALES
    public int[][] crearArrayBidimensionalDesigual() {
        int entrada = Integer.parseInt(JOptionPane.showInputDialog(new StringBuffer("Introduce el numero de filas:")));

        int[][] array = new int[entrada][];
        for (int fila = 0; fila < array.length; fila++) {
            entrada = Integer.parseInt(JOptionPane.showInputDialog(new StringBuffer("Introduce el numero de elementos de la fila " + fila)));
            array[fila] = new int[entrada];
        }
        return array;
    }

    public void verArrayBi(int[][] array) {
        for (int[] fila : array) {
            for (int celda : fila) {
                System.out.print(celda + "\t");
            }
            System.out.println();
        }
    }

    public int[][] rellenarArrayBidimensionalDesigualAleatorios(int[][] array, int min, int max) {
        for (int fila = 0; fila < array.length; fila++) {
            for (int celda = 0; celda < array[fila].length; celda++) {
                array[fila][celda] = (int) (Math.random() * max + min);
            }
        }
        return array;
    }

    public int[][] rellenarArrayBidimensionalDesigualBinarios(int[][] array) {
        for (int[] fila : array) {
            for (int celda = 0; celda < fila.length; celda++) {
                fila[celda] = (int) (Math.round(Math.random()));
            }
        }
        return array;
    }

   
}
