package Ficheros.Objetos;

import java.io.*;

/**
 * Clase que hereda de ObjectOutputStream y realiza las mismas funciones con la
 * salvedad de que al grabar objetos no graba la cabecera del fichero.
 *
 * @author Silvia Leon
 */
public class AddOOS extends ObjectOutputStream {

    /**
     * Constructor de la clase que crea un objeto de tipo AddOOS.
     *
     * @param out Objeto de tipo OutputStream a traves del cual se va a abrir el
     * flujo de salida hacia el fichero.
     * @throws IOException
     */
    public AddOOS(OutputStream out) throws IOException {
        super(out);
    }

    /**
     * Constructor de la clase que crea un objeto de tipo AddOOS.
     *
     * @throws IOException
     */
    public AddOOS() throws IOException {
        super();
    }

    /**
     *
     * @throws IOException
     */
    @Override
    protected void writeStreamHeader() throws IOException {

    }

}
