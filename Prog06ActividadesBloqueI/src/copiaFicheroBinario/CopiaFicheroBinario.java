/*
 *programa que copia un fichero binario en otro
 */

package copiaFicheroBinario;
 import java.io.*;

public class CopiaFicheroBinario {

    public static void main(String[] args) {
        //fichero de entrada
        FileInputStream fis = null;
        DataInputStream entrada = null;
        
        //fichero de salida
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        
        char n;
        try {
            fis = new FileInputStream("/ficheros/datos2.txt");
            entrada = new DataInputStream(fis);
            
            fos = new FileOutputStream("/ficheros/copiaDatosBinarios.txt");
            salida = new DataOutputStream(fos);
            
            while (true) {   
                //leemos del fichero
                n = entrada.readChar();  //se lee  un caracter del fichero
                System.out.print(n+" ");  //se muestra en pantalla
                
                //grabamos en el fichero destino
                salida.writeChar(n);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
                if (fos != null){
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }   
}
