package Ficheros.Bytes;

import java.io.*;

/**
 * Clase que gestiona la transferencia de datos hacia o desde un fichero de
 * bytes. Hay que abrir el flujo antes y cerrarlo despues de usarlo con sendos
 * metodos. Abre un flujo de bytes con File(Input/Output)Stream que envuelve con
 * un Data(Input/Output)Stream, segun el metodo sea de lectura o escritura.
 *
 * @author Silvia Leon
 */
public class FicheroDeBytes {

    // ATRIBUTOS
    private File fichero;
    private DataInputStream dis;
    private DataOutputStream dos;

    // METODOS
    //CONSTRUCTOR 
    /**
     * Crea un objeto de tipo FicheroDeBytes y asigna el parametro al atributo
     * fichero.
     *
     * @param fichero Con este fichero se abrira el flujo de transferencia de
     * bytes para leer o grabar en el.
     */
    public FicheroDeBytes(File fichero) {
        this.fichero = fichero;
    }

    // ABRIR 
    /**
     * Abre el flujo para leer del fichero situando el puntero en la posicion
     * inicial. Devuelve un mensaje si el fichero no existe,
     */
    public void abrirLector() {
        try {
            dis = new DataInputStream(new FileInputStream(fichero));
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no existe.");
        }
    }

    /**
     * Abre el flujo para grabar en el fichero. Si el fichero no existe lo crea,
     * si no puede devuelve un mensaje,
     *
     * @param anadir True para escribir la informacion al final de la existente,
     * False para sobrescribir.
     */
    public void abrirEscritor(boolean anadir) {
        try {
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            dos = new DataOutputStream(new FileOutputStream(fichero, anadir));
        } catch (IOException ex) {
            System.out.println("Error al acceder el fichero o al crearlo");
        }
    }

    // CIERRA EL FICHERO
    /**
     * Cierra el flujo de lectura abierto con el fichero.
     */
    public void cerrarLector() {
        try {
            dis.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero.");
        }
    }

    /**
     * Cierra el flujo de escritura abierto con el fichero.
     */
    public void cerrarEscritor() {
        try {
            dos.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero.");
        }
    }

    // LECTURA
    /**
     * Lee un boolean del fichero y lo devuelve. Si llega al fin del fichero o
     * tiene un error devuelve False y muestra un mensaje.
     *
     * @return El valor del boolean que ha leido del fichero.
     */
    public boolean leerBoolean() {
        boolean bo;
        try {
            bo = dis.readBoolean();
            return bo;
        } catch (EOFException ex) {
            System.out.println("Fin de fichero");
            return false;
        } catch (IOException ex) {
            System.out.println("Error al leer el boolean");
            return false;
        }
    }

    /*          MAIN  - Para leer todo el fichero
        for(int i=0;i<fichero.length();i+=3 ){
            System.out.println(lector.leerBoolean());
        }
    *Boolean ocupa 3 bytes
     */
    /**
     * Lee un byte del fichero y lo devuelve. Si llega al fin del fichero o
     * tiene un error devuelve el MIN_VALUE de Byte y muestra un mensaje.
     *
     * @return El valor del byte que ha leido del fichero.
     */
    public byte leerByte() {
        byte num;
        try {
            num = dis.readByte();
            return num;
        } catch (EOFException ex) {
            System.out.println("Fin de fichero");
            return Byte.MIN_VALUE;
        } catch (IOException ex) {
            System.out.println("Error al leer el byte.");
            return Byte.MIN_VALUE;
        }
    }

    /**
     * Lee un short del fichero y lo devuelve. Si llega al fin del fichero o
     * tiene un error devuelve el MIN_VALUE de Short y muestra un mensaje.
     *
     * @return El valor del short que ha leido del fichero.
     */
    public short leerShort() {
        short num;
        try {
            num = dis.readShort();
            return num;
        } catch (EOFException ex) {
            System.out.println("Fin de fichero");
            return Short.MIN_VALUE;
        } catch (IOException ex) {
            System.out.println("Error al leer el short.");
            return Short.MIN_VALUE;
        }
    }

    /**
     * Lee un int del fichero y lo devuelve. Si llega al fin del fichero o tiene
     * un error devuelve el MIN_VALUE de Integer y muestra un mensaje.
     *
     * @return El valor del int que ha leido del fichero.
     */
    public int leerInt() {
        int num;
        try {
            num = dis.readInt();
            return num;
        } catch (EOFException ex) {
            System.out.println("Fin de fichero");
            return Integer.MIN_VALUE;
        } catch (IOException ex) {
            System.out.println("Error al leer el int.");
            return Integer.MIN_VALUE;
        }
    }

    /**
     * Lee un long del fichero y lo devuelve. Si llega al fin del fichero o
     * tiene un error devuelve el MIN_VALUE de Long y muestra un mensaje.
     *
     * @return El valor del long que ha leido del fichero.
     */
    public long leerLong() {
        long num;
        try {
            num = dis.readLong();
            return num;
        } catch (EOFException ex) {
            System.out.println("Fin de fichero");
            return Long.MIN_VALUE;
        } catch (IOException ex) {
            System.out.println("Error al leer el long.");
            return Long.MIN_VALUE;
        }
    }

    /**
     * Lee un float del fichero y lo devuelve. Si llega al fin del fichero o
     * tiene un error devuelve el MIN_VALUE de Float y muestra un mensaje.
     *
     * @return El valor del float que ha leido del fichero.
     */
    public float leerFloat() {
        float num;
        try {
            num = dis.readFloat();
            return num;
        } catch (EOFException ex) {
            System.out.println("Fin de fichero");
            return Float.MIN_VALUE;
        } catch (IOException ex) {
            System.out.println("Error al leer el float.");
            return Float.MIN_VALUE;
        }
    }

    /**
     * Lee un double del fichero y lo devuelve. Si llega al fin del fichero o
     * tiene un error devuelve el MIN_VALUE de Double y muestra un mensaje.
     *
     * @return El valor del double que ha leido del fichero.
     */
    public double leerDouble() {
        double num;
        try {
            num = dis.readDouble();
            return num;
        } catch (EOFException ex) {
            System.out.println("Fin de fichero");
            return Double.MIN_VALUE;
        } catch (IOException ex) {
            System.out.println("Error al leer el float.");
            return Double.MIN_VALUE;
        }
    }

    /**
     * Lee un char del fichero y lo devuelve. Si llega al fin del fichero o
     * tiene un error devuelve '\0' y muestra un mensaje.
     *
     * @return El valor del char que ha leido del fichero.
     */
    public char leerChar() {
        char num;
        try {
            num = dis.readChar();
            return num;
        } catch (EOFException ex) {
            System.out.println("Fin de fichero");
            return '\0';
        } catch (IOException ex) {
            System.out.println("Error al leer el caracter");
            return '\0';
        }
    }

    /*          MAIN
    for(int i=0;i<fichero.length();i++ ){
            System.out.print(lector.leerChar());
        }
     */
    /**
     * Lee una linea del fichero y la devuelve. Si llega al final de fichero o
     * tiene un error devuelve null y muestra un mensaje.
     *
     * @return El String que ha leido del fichero.
     */
    public String leerLinea() {
        String linea;
        try {
            linea = dis.readUTF();
            return linea;
        } catch (EOFException ex) {
            System.out.println("Fin de fichero");
            return null;
        } catch (IOException ex) {
            System.out.println("Error al leer la cadena de texto");
            return null;
        }

    }

    /**
     * Lee un byte de informacion del fichero y lo devuelve. Si llega al final
     * del fichero o tiene un error devuelve el MIN_VALUE de Integer y muestra
     * un mensaje.
     *
     * @return Un int que contiene el byte de informacion leido.
     */
    public int leerArchivoByteAByte() {
        int b;
        try {
            if ((b = dis.read()) != -1) {
                return b;
            } else {
                System.out.println("Fin de fichero");
                return Integer.MIN_VALUE;
            }
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo");
            return Integer.MIN_VALUE;
        }
    }

    // ESCRITURA
    /**
     * Graba como bytes en el fichero el valor del boolean introducido. Si no
     * puede grabarlo muestra un error.
     *
     * @param x El boolean que se quiere grabar en el fichero.
     */
    public void grabarBoolean(boolean x) {
        try {
            dos.writeBoolean(x);
        } catch (IOException ex) {
            System.out.println("Error al grabar el booleano.");
        }
    }

    /**
     * Graba como bytes en el fichero el valor del byte introducido. Si no puede
     * grabarlo muestra un error.
     *
     * @param x El byte que se quiere grabar en el fichero.
     */
    public void grabarByte(byte x) {
        try {
            dos.writeByte(x);
        } catch (IOException ex) {
            System.out.println("Error al grabar el byte.");
        }
    }

    /**
     * Graba como bytes en el fichero el valor del short introducido. Si no
     * puede grabarlo muestra un error.
     *
     * @param x El short que se quiere grabar en el fichero.
     */
    public void grabarShort(short x) {
        try {
            dos.writeShort(x);
        } catch (IOException ex) {
            System.out.println("Error al grabar el short.");
        }
    }

    /**
     * Graba como bytes en el fichero el valor del int introducido. Si no puede
     * grabarlo muestra un error.
     *
     * @param x El int que se quiere grabar en el fichero.
     */
    public void grabarInt(int x) {
        try {
            dos.writeInt(x);
        } catch (IOException ex) {
            System.out.println("Error al grabar el int.");
        }
    }

    /**
     * Graba como bytes en el fichero el valor del long introducido. Si no puede
     * grabarlo muestra un error.
     *
     * @param x El long que se quiere grabar en el fichero.
     */
    public void grabarLong(long x) {
        try {
            dos.writeLong(x);
        } catch (IOException ex) {
            System.out.println("Error al grabar el long.");
        }
    }

    /**
     * Graba como bytes en el fichero el valor del float introducido. Si no
     * puede grabarlo muestra un error.
     *
     * @param x El float que se quiere grabar en el fichero.
     */
    public void grabarFloat(float x) {
        try {
            dos.writeFloat(x);
        } catch (IOException ex) {
            System.out.println("Error al grabar el float.");
        }
    }

    /**
     * Graba como bytes en el fichero el valor del double introducido. Si no
     * puede grabarlo muestra un error.
     *
     * @param x El double que se quiere grabar en el fichero.
     */
    public void grabarDouble(double x) {
        try {
            dos.writeDouble(x);
        } catch (IOException ex) {
            System.out.println("Error al grabar el float.");
        }
    }

    /**
     * Graba como bytes en el fichero el valor del char introducido. Si no puede
     * grabarlo muestra un error.
     *
     * @param x El char que se quiere grabar en el fichero.
     */
    public void grabarChar(char x) {
        try {
            dos.writeChar(x);
        } catch (IOException ex) {
            System.out.println("Error al grabar el caracter");
        }
    }

    /**
     * Graba como bytes en el fichero el valor del String introducido. Si no
     * puede grabarlo muestra un mensaje de error.
     *
     * @param x El String que se quiere grabar en el fichero.
     */
    public void grabarString(String x) {
        try {
            dos.writeUTF(x);
        } catch (IOException ex) {
            System.out.println("Error al grabar la cadena de texto");
        }
    }

    /**
     * Graba un byte de informacion en el fichero. Si no puede grabarlo muestra
     * un error.
     *
     * @param x El byte de datos que se quiere grabar en el fichero.
     */
    public void grabarArchivoByteAByte(int x) {
        try {
            dos.write(x);
        } catch (IOException ex) {
            System.out.println("Error al grabar el archivo");
        }
    }

}
