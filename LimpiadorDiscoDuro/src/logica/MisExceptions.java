/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author gnord
 */
public class MisExceptions {

    public static class CarpetaVacia extends Exception {

        public CarpetaVacia(String string) {
            super(string);
        }

    }

    public static class NoEsUnDirectorioNoSePuedeListar extends Exception {

        public NoEsUnDirectorioNoSePuedeListar(String string) {
            super(string);
        }

    }

    public static class RutaNoValida extends Exception {

        public RutaNoValida(String string) {
            super(string);
        }

        RutaNoValida() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public static class ArchivoYaExiste extends Exception {

        public ArchivoYaExiste(String string) {
            super(string);
        }
    }

    public static class RutaYaExiste extends Exception {

        public RutaYaExiste(String string) {
            super(string);
        }
    }
}
