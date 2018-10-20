/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;

/**
 *
 * @author daniel regueiro
 */
public class FiltroArchivos {

    public static final String EXT_TEXTO[] = {".txt", ".docx", ".pdf", ".odt", ".rtf"};
    public static final String EXT_EJECUTABLES[] = {"exe", "bat"};
    public static final String EXT_IMAGENES[] = {"jpg", "gif", "bmp"};
    public static final String EXT_TEMPORAL[] = {"tmp"};
    public static final String EXT_COMPRIMIDAS[] = {"zip", "rar", "gz", "SITX", "7z"};
    public static final String EXT_VIDEO[] = {"avi", "mp4", "m4v", "mpeg", "mov"};

    public static class FiltroPorExtension implements FileFilter {

        private final String[] extensiones;

        public FiltroPorExtension(String[] extensiones) {
            this.extensiones = extensiones;
        }

        @Override
        public boolean accept(File dir) {

            for (int i = 0; i < extensiones.length; i++) {
                if (dir.getName().endsWith(extensiones[i])) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class FiltroEsDirectorio implements FileFilter {

        @Override
        public boolean accept(File file) {
            return file.isDirectory();
        }
    }

    public static class FiltroOcultos implements FileFilter {

        @Override
        public boolean accept(File file) {
            return file.isHidden();
        }
    }

    public static class FiltroPorTamanoMinimo implements FileFilter {

        private int tamanoBytes;

        public FiltroPorTamanoMinimo(int tamanoMegas) {
            this.tamanoBytes = tamanoMegas * 1024;
        }

        @Override
        public boolean accept(File file) {
            return (file.length() > tamanoBytes);
        }
    }

    public static class FiltroPorTamanoMaximo implements FileFilter {

        private int tamanoBytes;

        public FiltroPorTamanoMaximo(int tamanoMegas) {
            this.tamanoBytes = tamanoMegas * 1024;
        }

        @Override
        public boolean accept(File file) {
            return (file.length() < tamanoBytes);
        }
    }

    public static class FiltroDespuesDeUnaFecha implements FileFilter {

        private Date fecha;

        public FiltroDespuesDeUnaFecha(Date fecha) {
            this.fecha = fecha;
        }

        @Override
        public boolean accept(File file) {
            Date fechaUltimaModificacion = new Date(file.lastModified());
            return (fechaUltimaModificacion.after(fecha));
        }
    }
}
