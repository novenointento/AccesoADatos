package serializacion;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class SerializarAnhadirObjetosEnFichero {

    /**
     * Añadir informacion de objetos en un archivo
     */

    public class MyAppendingObjectOutputStream extends ObjectOutputStream {
        //bloque que sobreescribe el metodo writeStreamHeader para que no vuelva a 
        //escribir la cabecera del fichero cada vez qeu abramos el fichero para 
        //añadir. Sobreescribirmos el método writeStremHeader con reset() y asi
        //no pone nueva cabecera al nuevo bloque de registros que escribamos

        public MyAppendingObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            // do not write a header, but reset:
            // this line added after another question
            // showed a problem with the original
            reset();
        }

    }

    public static void main(String[] args) {
        SerializarAnhadirObjetosEnFichero eyl = new SerializarAnhadirObjetosEnFichero();
        eyl.appendFichero("c:/ficheros/mascotas.dat");

    }

    /**
     * Añade en el fichero que se le pasa
     *
     * @param fichero Path completo del fichero que se quiere escribir
     */
    public void appendFichero(String fichero) {
        try {
            //creamos el ObjetOutputStream como  MyAppendingObjetStream 
            //para que no escriba la cabecera del nuevo bloque de registros
            MyAppendingObjectOutputStream oos = new MyAppendingObjectOutputStream(new FileOutputStream(fichero, true));
            for (int i = 0; i < 3; i++) {
                // ojo, se hace un new por cada Persona. El new dentro
                // del bucle.
                System.out.println("Persona" + i);
                System.out.print("introduce nombre mascota:");
                String nomMascota = LeerTeclado.leerCadena();
                System.out.print("introduce tipo de mascota:");
                String tipoMascota = LeerTeclado.leerCadena();

                Persona p = new Persona("nombre" + i, "apellido" + i, new Mascota(nomMascota, tipoMascota), i);
                oos.writeObject(p);
            }

        } catch (EOFException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
