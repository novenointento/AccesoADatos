package BarajaModelos;


public class BarajaEspanola {

    private Carta[] carta;

    public BarajaEspanola() {

    }

    public void inicializar() {

        //PALO
        String[] palo = {"Oros", "Bastos", "Espadas", "Copas"};

        //NUMERO
        String[] tipo = new String[10];
        for (int i = 0; i < 7; i++) {
            tipo[i] = Integer.toString(i + 1);
        }
        tipo[7] = "Sota";
        tipo[8] = "Caballo";
        tipo[9] = "Rey";

        //VALOR
        int[] valor = new int[10];
        for (int i = 0; i < 10; i++) {
            valor[i] = (i + 1);
        }

        //CARTAS
        int contador = 0;
        this.carta = new Carta[40];
        for (int paloX = 0; paloX < 4; paloX++) {

            for (int tipoX = 0; tipoX < 10; tipoX++) {
                if (contador <= 40) {
                    carta[contador] = new Carta(palo[paloX], tipo[tipoX], valor[tipoX]);
                }
                contador++;
            }
        }
    }

    public void verCartas() {
        for (Carta carta1 : carta) {
            System.out.println(carta1.toString());
        }
    }

}
