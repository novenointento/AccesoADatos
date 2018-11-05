/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Daniel Regueiro
 */
public class CreadorPaginas {

    public static enum TIPO_GRAFICO {
        BAR, LINE, RADAR, PIE, DOUGHNUT, POLARAREA
    }

    public static void crearPagina(String tituloWeb, String tituloGrafico, Map<String, Integer> datos, TIPO_GRAFICO chartType, File archivoSalida) throws FileNotFoundException, IOException {
        String type = (chartType == TIPO_GRAFICO.POLARAREA) ? "polarArea" : chartType.name().toLowerCase();

        String cabecera
                = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>" + tituloWeb + "</title>\n"
                + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js\"></script>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div id=\"container\" style=\"height: 40%;\">\n"
                + "            <canvas id=\"myChart\" ></canvas>\n"
                + "        </div>\n"
                + "        <script>\n"
                + "            var ctx = document.getElementById('myChart').getContext('2d');\n"
                + "            var chart = new Chart(ctx, {\n"
                + "                type: '" + type + "',\n"
                + "                data: {\n"
                + "                    labels: [";

        String keys = "";
        int keyCounter = 1;
        for (String key : datos.keySet()) {
            keys = keys.concat('"' + key + '"');
            if (keyCounter < datos.size()) {
                keys = keys.concat(", ");
            }
            keyCounter++;
        }

        String body = "],\n"
                + "                    datasets: [{\n"
                + "                            label: \"" + tituloGrafico + "\",\n"
                + "                            backgroundColor: [\n"
                + "                                'rgba(255, 99, 132, 0.2)',\n"
                + "                                'rgba(54, 162, 235, 0.2)',\n"
                + "                                'rgba(255, 206, 86, 0.2)',\n"
                + "                                'rgba(75, 192, 192, 0.2)',\n"
                + "                                'rgba(153, 102, 255, 0.2)',\n"
                + "                                'rgba(255, 159, 64, 0.2)'\n"
                + "                            ],\n"
                + "                            borderColor: [\n"
                + "                                'rgba(255,99,132,1)',\n"
                + "                                'rgba(54, 162, 235, 1)',\n"
                + "                                'rgba(255, 206, 86, 1)',\n"
                + "                                'rgba(75, 192, 192, 1)',\n"
                + "                                'rgba(153, 102, 255, 1)',\n"
                + "                                'rgba(255, 159, 64, 1)'\n"
                + "                            ],\n"
                + "                            data: [";

        String valores = "";
        int valueCounter = 1;
        for (Integer value : datos.values()) {
            valores = valores.concat(value.toString());
            if (valueCounter < datos.size()) {
                valores = valores.concat(", ");
            }
            valueCounter++;
        }

        String piePagina = "]\n"
                + "                        }]\n"
                + "                },\n"
                + "                options: {}\n"
                + "            });\n"
                + "        </script>\n"
                + "    </body>\n"
                + "</html>";

        String web = cabecera + keys + body + valores + piePagina;
        OperacionesFicheros fichero= new OperacionesFicheros(archivoSalida);
        fichero.abrirEscritorFlujoDatos(false);
        fichero.grabarEnDisco(web);
        
    }
     

}
