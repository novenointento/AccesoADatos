/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaEscritura;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author gnord
 */
public class DeepClone {

    /**
     * * Copiar objeto a través de mecanismos de serialización.
     */
    public static <T extends Serializable> T deepClone(T objetoACopiar) {
        try {
            // convertimos el objeto en un array de Bytes   
            //grabamos el objeto en un fichero en memoria          
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);

            //copiamos el objeto en la memoria en el fichero de objetos          
            oos.writeObject(objetoACopiar);
            oos.flush();
            //convertimos el objeto almacenado en el fichero de memoria en un array de Bytes    
            byte[] bytes = baos.toByteArray();
            //HACEMOS LA OPERACIÓN CONTRARIO       
            //leemos del fichero de memoria el array de bytes como objeto y devolvemos el objeto  
            InputStream is = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(is);

            return (T) ois.readObject();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException(objetoACopiar.getClass().getName(), e);   
        }   
    } 
 
}
