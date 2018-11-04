package logica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;

/**

 *
 * @author Daniel
 *
 */
public class VisualizadorPagina {

    public VisualizadorPagina(String pagina) {

                // create jeditorpane
                JEditorPane jEditorPane = new JEditorPane();
                // create a scrollpane; modify its attributes as desired
                JScrollPane scrollPane = new JScrollPane(jEditorPane);

                // add an html editor kit
                HTMLEditorKit kit = new HTMLEditorKit();
                jEditorPane.setEditorKit(kit);

             
               
                // create a document, set it on the jeditorpane, then add the html
                Document doc = kit.createDefaultDocument();
                jEditorPane.setDocument(doc);
                jEditorPane.setText(pagina);

                // now add it all to a frame
                JFrame j = new JFrame("Ocupacion del disco");
                j.getContentPane().add(scrollPane, BorderLayout.CENTER);
                j.setSize(new Dimension(800, 600));
                j.setVisible(true);
            }

}
