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
 * @author Daniel Regueiro
 *
 */
public class VisualizadorPagina {

    public VisualizadorPagina(String pagina) {

                JEditorPane jEditorPane = new JEditorPane();
                JScrollPane scrollPane = new JScrollPane(jEditorPane);

                HTMLEditorKit kit = new HTMLEditorKit();
                jEditorPane.setEditorKit(kit);

             

                Document doc = kit.createDefaultDocument();
                jEditorPane.setDocument(doc);
                jEditorPane.setText(pagina);


                JFrame j = new JFrame("Ocupacion del disco");
                j.getContentPane().add(scrollPane, BorderLayout.CENTER);
                j.setSize(new Dimension(800, 600));
                j.setVisible(true);
            }

}
