/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;

import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gnord
 */
public class FiltroArchivos implements FilenameFilter {
    private List<String>lista;

    public FiltroArchivos(List<String> lista) {
        this.lista = lista;
    }

    public FiltroArchivos(String extension) {
        lista=new ArrayList();
        lista.add(extension);
    }
    
    
    
    
    
    /**
     *
     * @param dir
     * @param extension
     * @return
     */
    public boolean accept(File dir, String extension) {
        return dir.getName().endsWith(extension);
    }

    
    
    
}
