/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActividadesRepasoBloque6;

import java.io.File;
import java.text.DecimalFormat;

/**
 *
 * @author gnord
 */
public class MainRepartirAlumnosSuspensoAprobados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String linea = "";
        Persona alumno;

        DecimalFormat decimales = new DecimalFormat("0.00");
        File archivo = new File("c:/ficheros/notas.csv");
        File aprobados = new File("c:/ficheros/aprobados.dat");
        File suspensos = new File("c:/ficheros/suspensos.dat");
        LeerAlumnos leer = new LeerAlumnos(archivo);
        AnadirObjetoenDat grabar2 = new AnadirObjetoenDat();
        CrearArchivoDatygrabarObjetos grabar1 = new CrearArchivoDatygrabarObjetos();
        int numeros = 0;
        int numerop = 0;

        while (linea != null) {
            try {

                linea = leer.Leercadenacsv();
                alumno = leer.tokenizar(linea);
                Float notaM = alumno.notamedia();

                if (notaM < 5.0) {
                    if (numeros == 0) {

                        grabar1.crearArchivoYGrabarObjetos(suspensos, alumno);
                        System.out.println("La nota media de " + alumno.getNombre() + " es " + decimales.format(notaM));
                        System.out.println("Grabando primera persona en suspensos");

                        numeros++;
                    } else {

                        grabar2.grabar(alumno, suspensos);
                        System.out.println("La nota media de " + alumno.getNombre() + " es " + decimales.format(notaM));
                        System.out.println("Grabando  persona en suspensos");

                    }
                    System.out.println("");
                } else {
                    if (numerop == 0) {
                        grabar1.crearArchivoYGrabarObjetos(aprobados, alumno);
                        System.out.println("La nota media de " + alumno.getNombre() + " es " + decimales.format(notaM));
                        System.out.println("Grabando primera persona en aprobados");

                        numerop++;
                    } else {
                        grabar2.grabar(alumno, aprobados);
                        System.out.println("La nota media de " + alumno.getNombre() + " es " + decimales.format(notaM));
                        System.out.println("Grabando persona en aprobados");

                    }
                    System.out.println("");
                }

            } catch (NullPointerException ex) {

                System.out.println("no hay mas alumnos");

            }

        }
    }

}
