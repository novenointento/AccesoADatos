package Cadenas;

public class GestorCadenas {

    // ATRIBUTOS
    char[] NUMEROS = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] VOCALES = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    char[] LETRAS;

    // METODOS GENERICOS
    public GestorCadenas() {
        LETRAS = new char[52];
        for (int i = 0; i < 26; i++) {
            LETRAS[i] = (char) (i + 65);
        }
        for (int i = 26; i < 52; i++) {
            LETRAS[i] = (char) (i + 71);
        }
    }

    public void setLETRAS(char[] LETRAS) {
        this.LETRAS = LETRAS;
    }

    public char[] getLETRAS() {
        return LETRAS;
    }

    public void setVOCALES(char[] VOCALES) {
        this.VOCALES = VOCALES;
    }

    public char[] getVOCALES() {
        return VOCALES;
    }

    public void setNUMEROS(char[] NUMEROS) {
        this.NUMEROS = NUMEROS;
    }

    public char[] getNUMEROS() {
        return NUMEROS;
    }

    // METODOS ESPECIFICOS
    // NUMEROS
    public boolean esNumero(char x) {
        boolean esNumero = false;
        for (char numero : NUMEROS) {
            if (numero == x) {
                esNumero = true;
            }
        }
        return esNumero;
    }

    public int contarNumeros(String cadena) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (esNumero(cadena.charAt(i))) {
                contador++;
            }
        }
        return contador;
    }

    public int primerNumero(String cadena) {
        int primerNumero = -1;
        int posicion;
        for (posicion = cadena.length() - 1; ((posicion >= 0) || (primerNumero == -1)); posicion--) {
            if (esNumero(cadena.charAt(posicion))) {
                primerNumero = posicion;
            }
        }
        return primerNumero;
    }

    public int ultimoNumero(String cadena) {
        int ultimoNumero = -1;
        int posicion;
        for (posicion = 0; ((posicion < cadena.length()) || (ultimoNumero == -1)); posicion++) {
            if (esNumero(cadena.charAt(posicion))) {
                ultimoNumero = posicion;
            }
        }
        return ultimoNumero;
    }

    // LETRAS
    public boolean esLetra(char x) {
        boolean esLetra = false;
        for (char letra : LETRAS) {
            if (x == letra) {
                esLetra = true;
            }
        }
        return esLetra;

    }

    // VOCALES
    public boolean esVocal(char x) {
        boolean esVocal = false;
        for (char vocal : VOCALES) {
            if (vocal == x) {
                esVocal = true;
            }
        }
        return esVocal;
    }

    public int contarVocales(String cadena) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (esVocal(cadena.charAt(i))) {
                contador++;
            }
        }
        return contador;
    }

    public int primeraVocal(String cadena) {
        int primeraVocal = -1;
        int posicion;
        for (posicion = cadena.length() - 1; ((posicion >= 0) || (primeraVocal == -1)); posicion--) {
            if (esVocal(cadena.charAt(posicion))) {
                primeraVocal = posicion;
            }
        }
        return primeraVocal;
    }

    public int ultimaVocal(String cadena) {
        int ultimaVocal = -1;
        int posicion;
        for (posicion = 0; ((posicion < cadena.length()) || (ultimaVocal == -1)); posicion++) {
            if (esVocal(cadena.charAt(posicion))) {
                ultimaVocal = posicion;
            }
        }
        return ultimaVocal;
    }

    // LETRAS
    public boolean esConsonante(char x) {
        return (esLetra(x) && !esVocal(x));
    }

    public int contarConsonantes(String cadena) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (esConsonante(cadena.charAt(i))) {
                contador++;
            }
        }
        return contador;
    }

    public int primeraConsonante(String cadena) {
        int primeraConsonante = -1;
        int posicion;
        for (posicion = cadena.length() - 1; ((posicion >= 0) || (primeraConsonante == -1)); posicion--) {
            if (esConsonante(cadena.charAt(posicion))) {
                primeraConsonante = posicion;
            }
        }
        return primeraConsonante;
    }

    public int ultimaConsonante(String cadena) {
        int ultimaConsonante = -1;
        int posicion;
        for (posicion = 0; ((posicion < cadena.length()) || (ultimaConsonante == -1)); posicion++) {
            if (esConsonante(cadena.charAt(posicion))) {
                ultimaConsonante = posicion;
            }
        }
        return ultimaConsonante;
    }
    
    // CARACTERES
    public boolean compararCharIgnoreCase(char x, char y) {
        boolean iguales = false;
        if (x == y) {
            iguales = true;
        } else if ((esVocal(x) && esVocal(y)) || (esConsonante(x) && esConsonante(y))) {
            switch (x - y) {
                case 32:
                case -32:
                    iguales = true;
                    break;
            }
        }
        return iguales;
    }

    public int contarChar(String cadena, char caracter) {
        int contador = 0;
        for (int x = 0; x < cadena.length(); x++) {
            if (compararCharIgnoreCase(cadena.charAt(x), caracter)) {
                contador++;
            }
        }
        return contador;
    }
   
    // CARACTERES ESPECIALES
    public boolean esCaracterEspecial(char x) {
        return !(esNumero(x) || esLetra(x));
    }

    public int contarCaracteresEspeciales(String cadena) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (esCaracterEspecial(cadena.charAt(i))) {
                contador++;
            }
        }
        return contador;
    }

    public int primerCaracterEspecial(String cadena) {
        int primerCaracterEspecial = -1;
        int posicion;
        for (posicion = cadena.length() - 1; ((posicion >= 0) || (primerCaracterEspecial == -1)); posicion--) {
            if (esCaracterEspecial(cadena.charAt(posicion))) {
                primerCaracterEspecial = posicion;
            }
        }
        return primerCaracterEspecial;
    }

    public int ultimoCaracterEspecial(String cadena) {
        int ultimoCaracterEspecial = -1;
        int posicion;
        for (posicion = 0; ((posicion < cadena.length()) || (ultimoCaracterEspecial == -1)); posicion++) {
            if (esCaracterEspecial(cadena.charAt(posicion))) {
                ultimoCaracterEspecial = posicion;
            }
        }
        return ultimoCaracterEspecial;
    }


}
