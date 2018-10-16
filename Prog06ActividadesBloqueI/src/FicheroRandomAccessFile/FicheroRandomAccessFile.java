package FicheroRandomAccessFile;

import Directorios.LeerTeclado;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FicheroRandomAccessFile {

    /**
     * grabar varias secuencias int int long | int int long y a continuacion
     * indicar que posicion se quiere leer y mostrarla en pantalla
     */
    public static void main(String[] args) {
    
        try {
            int numero = 0;
            long longitudFichero;

            //se abre el fichero para lectura y escritura
            RandomAccessFile fichero = new RandomAccessFile("\\prog06BloqueIII\\SecuenciaRandomAccessFile.txt", "rw");
            System.out.println("Grabando 1 11 11111111");
            fichero.writeInt(1);
            longitudFichero = fichero.length();            
            System.out.println("Longitud del fichero en bytes con un int"+longitudFichero);
            fichero.writeInt(11);
            longitudFichero = fichero.length();            
            System.out.println("Longitud del fichero en bytes con int int"+longitudFichero);
            fichero.writeLong(11111111);
            longitudFichero = fichero.length();            
            System.out.println("Longitud del fichero en bytes con int int long"+longitudFichero);

            System.out.println("Grabando 2 22 22222222 ...");
            fichero.writeInt(2);
            fichero.writeInt(22);
            fichero.writeLong(22222222);

            System.out.println("Grabando 3 33 33333333...");
            fichero.writeInt(3);
            fichero.writeInt(33);
            fichero.writeLong(33333333);

            System.out.println("Grabando 4 44 44444444...");
            fichero.writeInt(4);
            fichero.writeInt(44);
            fichero.writeLong(44444444);

            System.out.println("Grabando 5 55 55555555...");
            fichero.writeInt(5);
            fichero.writeInt(55);
            fichero.writeLong(55555555);

            //leyendo una secuencia concreta
            
            do {
                longitudFichero = fichero.length()/16; 
                System.out.print("Introduce el número de secuencia a leer: entre 1 y "+ longitudFichero+": ");

                numero = LeerTeclado.leerInt(); //se lee el entero a añadir en el fichero

            } while (numero < 1 || numero > longitudFichero );
            
            long posicion = (long) ((numero-1)*16); //cada secuencia ocupa 16 bytes
            System.out.println("situandome en la posicilon "+posicion+" byte");
            fichero.seek(posicion); //nos situamos en inicio posicion pero en bytes 

            //mostramos la secuencia  int   int   long de esa posicion
            System.out.println(fichero.readInt() + "  " + fichero.readInt() + "   " + fichero.readLong());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheroRandomAccessFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicheroRandomAccessFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    }


