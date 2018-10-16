package paqueteJuegoPalillos;

public class Tablero {

    private boolean[][] tablero = {{true},
    {true, true},
    {true, true, true},
    {true, true, true, true},
    {true, true, true, true, true}};

    public boolean[][] getTablero() {
        return tablero;
    }

    public void setTablero(boolean[][] tablero) {
        this.tablero = tablero;
    }

    public void mostrarTablero() {
        for (boolean[] varFila : tablero) {
            //cogemos el array de la cada fila
            System.out.println();
            //mostramos con un nuevo bucle todos sus elementos
            for (boolean varCol : varFila) {
                if (varCol) {
                    System.out.print(" I ");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
    }
}
