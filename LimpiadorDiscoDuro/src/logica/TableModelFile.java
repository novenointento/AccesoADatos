/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daniel regueiro
 */
public class TableModelFile extends AbstractTableModel {

    private long tamanoBorrable;
    private String extensionBorrable;
    private final List<File> listaFiles;
    private List<File> listaFilesBorrables;
    private final String[] columnas = {"Nombre", "Tamaño", "Ruta", "Contenido", "Antiguedad", "Borrable"};

    public TableModelFile(long tamanoBorrable, String extensionBorrable, List<File> listaFiles) {
        this.tamanoBorrable = tamanoBorrable;
        this.extensionBorrable = extensionBorrable;
        this.listaFiles = listaFiles;
        this.listaFilesBorrables = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return listaFiles.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override //Este no es obligatorio asi que lo tenemos que implementar nosotros
    public String getColumnName(int i) {
        return columnas[i];
    }

    @Override
    public Object getValueAt(int filas, int columnas) {
        switch (columnas) {

            case 0:
                return listaFiles.get(filas).getName();
            case 1:
                return listaFiles.get(filas).length() + " bytes";
            case 2:
                return listaFiles.get(filas).getAbsolutePath();
            case 3:
                if (listaFiles.get(filas).isDirectory() && listaFiles.get(filas).list().length == 0) {
                    return "Vacio";
                } else {
                    return "Lleno";
                }
            case 4:
                return OperacionesFicheros.fechaCreacionArchivo(listaFiles.get(filas));
            case 5:
                boolean borrable = false;
                if (listaFiles.get(filas).isDirectory() && listaFiles.get(filas).list().length == 0) {
                    borrable = true;
                }
                if (listaFiles.get(filas).isFile() && listaFiles.get(filas).length() > tamanoBorrable) {
                    borrable = true;
                }
                if (listaFiles.get(filas).getName().endsWith(extensionBorrable)) {
                    borrable = true;
                }
                if (borrable) {
                    this.listaFilesBorrables.add(listaFiles.get(filas));
                    return "Si";
                } else {
                    return "No";
                }
        }
        return null;
    }
    
    public List<File> getListaBorrables(){
        return this.listaFilesBorrables;
    }

}
