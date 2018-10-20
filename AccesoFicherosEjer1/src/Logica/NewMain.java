/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author daniel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        // TODO code application logic here
     
        
        
        File texto =new File("quijote.txt");
        
  TreeMap<String,Integer> c =  (TreeMap<String,Integer>) OperacionesStream.listarPalabras(OperacionesStream.leerDeFile(texto));
        
       
        
        for (Map.Entry<String, Integer> entry : c.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

    }
}
