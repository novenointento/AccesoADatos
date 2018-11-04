/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.TableRowSorter;
import logica.ChartsCreator;
import logica.ControladorLimpiador;
import logica.OperacionesFicheros;
import logica.OperacionesStream;
import logica.TableModelFile;
import logica.VisualizadorPagina;

/**
 *
 * @author daniel
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private final JFileChooser selectorJfileChooser;
    private final FileNameExtensionFilter filtroImagenes = new FileNameExtensionFilter("Imágenes", "bmp", "jpg");
    private final FileNameExtensionFilter filtroTextos = new FileNameExtensionFilter("documentos texto", "txt", "docx", "pdf", "odt", "rtf");
    private final FileNameExtensionFilter filtroVideos = new FileNameExtensionFilter("Archivos de video", "avi", "mp4", "m4v", "mpeg", "mov");
    private final FileNameExtensionFilter filtroTemporales = new FileNameExtensionFilter("Archivos temporales", "tmp");
    private File unidades[];
    private File pagina;
    private VisualizadorPagina visualizador;
    private TableModelFile tableModel;
    private OperacionesStream operacionesStream = new OperacionesStream();

    private enum TAMANO {
        BYTE("60 Bytes", 60), MEGAS("500 Megas", 5 * 1024 * 1024), GIGAS("5 Gigas", 5 * 1024 * 1024 * 1024);
        private final String nombre;
        private final long cantidad;

        private TAMANO(String nombre, long cantidad) {
            this.cantidad = cantidad;
            this.nombre = nombre;
        }

        public String getNombreUnidad() {
            return nombre;
        }

        public long getCantidad() {
            return cantidad;
        }

        public static TAMANO getEnum(String nombre) {
            if (nombre.equalsIgnoreCase(BYTE.nombre)) {
                return BYTE;
            } else if (nombre.equalsIgnoreCase(MEGAS.nombre)) {
                return MEGAS;
            } else if (nombre.equalsIgnoreCase(GIGAS.nombre)) {
                return GIGAS;
            }
            return null;
        }
    };

    private enum TIPOS {
        txt, doc, pdf, avi, jpg, gif, mp3, tmp, bmp
    };

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        this.selectorJfileChooser = new JFileChooser();
        pagina = new File("paginaDisco.html");
        datosSelector();
        buscarUnidades();
        for (TAMANO tamano : TAMANO.values()) {
            jComboBTamano.addItem(tamano.getNombreUnidad());
        }
        for (TIPOS tipo : TIPOS.values()) {
            jComboTipoArchivo.addItem(tipo.toString());
            comboExtensionesBorrables.addItem(tipo.toString());
        }

    }

    public void buscarUnidades() {
        String items[];
        unidades = File.listRoots();
        String it[] = new String[unidades.length];

        for (int i = 0; i < unidades.length; i++) {
            String s1 = FileSystemView.getFileSystemView().getSystemDisplayName(unidades[i]);
            it[i] = s1;
        }
        items = it;
        comboUnidades.removeAllItems();
        comboUnidadesCopiaSeguridad.removeAllItems();
        for (int i = 0; i < it.length; i++) {
            comboUnidades.addItem(it[i]);
            comboUnidadesCopiaSeguridad.addItem(unidades[i].getAbsolutePath());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonEliminar = new javax.swing.JButton();
        jButtonCambiarExtension = new javax.swing.JButton();
        textoUnidad = new javax.swing.JLabel();
        jComboTipoArchivo = new javax.swing.JComboBox<>();
        jButtonCopiaSeguridad = new javax.swing.JButton();
        comboUnidadesCopiaSeguridad = new javax.swing.JComboBox<>();
        jButtonSeleccionar = new javax.swing.JButton();
        jCheckBoxDirectorios = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonUnidades = new javax.swing.JButton();
        comboUnidades = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBTamano = new javax.swing.JComboBox<>();
        comboExtensionesBorrables = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButtonEliminarBorrables = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButtonCodificar = new javax.swing.JButton();
        jButtonDecodificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setToolTipText("Selecciona archivos de esta lista para trabajar con ellos");
        jScrollPane2.setViewportView(jTable1);

        jButtonEliminar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(204, 0, 0));
        jButtonEliminar.setText("Eliminar selección");
        jButtonEliminar.setToolTipText("Elimina los archivos que tengamos seleccionados.");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonCambiarExtension.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonCambiarExtension.setText("Cambiar Extensión");
        jButtonCambiarExtension.setToolTipText("Selecciona un archivo de la lista para eliminarlo");
        jButtonCambiarExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarExtensionActionPerformed(evt);
            }
        });

        textoUnidad.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jComboTipoArchivo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButtonCopiaSeguridad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonCopiaSeguridad.setText("Copia de Seguridad");
        jButtonCopiaSeguridad.setToolTipText("Hace una copia de seguridad de todos los archivos de la lista");
        jButtonCopiaSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCopiaSeguridadActionPerformed(evt);
            }
        });

        comboUnidadesCopiaSeguridad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        comboUnidadesCopiaSeguridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonSeleccionar.setFont(new java.awt.Font("Dialog", 2, 36)); // NOI18N
        jButtonSeleccionar.setText("Buscar");
        jButtonSeleccionar.setToolTipText("Busca en un directorio y todos sus inferiores.");
        jButtonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarActionPerformed(evt);
            }
        });

        jCheckBoxDirectorios.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jCheckBoxDirectorios.setText("Buscar solo directorios");
        jCheckBoxDirectorios.setToolTipText("Seleccionalo para que la lista solo muestre carpetas");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Unidad para la copia:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Cambia extensiones de archivo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(textoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboTipoArchivo, 0, 176, Short.MAX_VALUE)
                                    .addComponent(jButtonCambiarExtension, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(58, 58, 58))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jCheckBoxDirectorios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(48, 48, 48)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboUnidadesCopiaSeguridad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonCopiaSeguridad)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(14, 14, 14)))))
                .addGap(272, 272, 272))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoUnidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jCheckBoxDirectorios))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboUnidadesCopiaSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboTipoArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCopiaSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCambiarExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addComponent(jButtonSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboUnidadesCopiaSeguridad, jComboTipoArchivo});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCambiarExtension, jButtonCopiaSeguridad, jButtonEliminar});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonUnidades.setText("Mostrar Unidad");
        jButtonUnidades.setToolTipText("Muestra el tamaño libre en la unidad escogida.");
        jButtonUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnidadesActionPerformed(evt);
            }
        });

        comboUnidades.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        comboUnidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Unidades:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(comboUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBTamano.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboBTamano.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBTamanoItemStateChanged(evt);
            }
        });

        comboExtensionesBorrables.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        comboExtensionesBorrables.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboExtensionesBorrablesItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Selección borrables:");

        jButtonEliminarBorrables.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonEliminarBorrables.setForeground(new java.awt.Color(204, 0, 0));
        jButtonEliminarBorrables.setText("Eliminar Borrables");
        jButtonEliminarBorrables.setToolTipText("Elimina archivos de más tamaño o cuya estension sea la seleccionada.");
        jButtonEliminarBorrables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarBorrablesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jComboBTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboExtensionesBorrables, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonEliminarBorrables, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboExtensionesBorrables, jComboBTamano});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboExtensionesBorrables, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButtonEliminarBorrables, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonCodificar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonCodificar.setText("Codificar");
        jButtonCodificar.setToolTipText("codifica un archivo para que no sea legible al abrirlo");
        jButtonCodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCodificarActionPerformed(evt);
            }
        });

        jButtonDecodificar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonDecodificar.setText("Decodificar");
        jButtonDecodificar.setToolTipText("Devuelve el archivo a su estado normal usando la misma contraseña que se uso para codificarlo");
        jButtonDecodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecodificarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Encripta archivos:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonDecodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(85, 85, 85))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jButtonCodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDecodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarActionPerformed

        ControladorLimpiador.getInstance().reiniciarBusqueda();
        int respuesta = selectorJfileChooser.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            ControladorLimpiador.getInstance().reiniciarBusqueda();

            //Crear un objeto File con el archivo elegido
            ControladorLimpiador.getInstance().recogerColeccionFiles(selectorJfileChooser.getSelectedFile());
            this.rellenarTable();
        }
    }//GEN-LAST:event_jButtonSeleccionarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
         if (tableModel != null) {
        int seleccionadosTabla[] = jTable1.getSelectedRows();
        if (seleccionadosTabla.length > 0) {
            for (int seleccionadoTabla : seleccionadosTabla) {
                int seleccionadoLista = jTable1.convertRowIndexToModel(seleccionadoTabla);
                File archivo = ControladorLimpiador.getInstance().devolverColeccionArchivos().get(seleccionadoLista);
                archivo.delete();
            }
        }
        ControladorLimpiador.getInstance().reiniciarBusqueda();
        this.rellenarTable();} else {
            JOptionPane.showMessageDialog(this, "Cree primero la lista de archivos ", "Error en la eliminacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnidadesActionPerformed

        if (comboUnidades.getSelectedIndex() != -1) {
            long espaciolibre = unidades[comboUnidades.getSelectedIndex()].getUsableSpace();
            long espacioTotal = unidades[comboUnidades.getSelectedIndex()].getTotalSpace();
            int espacioLibreGb = (int) (((espaciolibre / 1024) / 1024) / 1024);
            int espacioTotalGb = (int) (((espacioTotal / 1024) / 1024) / 1024);
            Map<String, Integer> datos = new TreeMap();
            datos.put("Espacio libre", espacioLibreGb);
            datos.put("Espacio ocupado", espacioTotalGb - espacioLibreGb);

            try {
                ChartsCreator.createChart("Espacio de la unidad", "Espacio", datos, ChartsCreator.TIPO_GRAFICO.DOUGHNUT, pagina);
            } catch (IOException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {

            Desktop.getDesktop().browse(new URI("paginaDisco.html"));

        } catch (URISyntaxException | IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButtonUnidadesActionPerformed

    private void jButtonCambiarExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarExtensionActionPerformed
        int seleccionado = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        if (seleccionado >= 0) {
            File archivo = ControladorLimpiador.getInstance().devolverColeccionArchivos().get(seleccionado);
            String ruta = archivo.getAbsolutePath();
            String rutaCortada = ruta.substring(0, (ruta.length() - 4));
            File nuevaRuta = new File(rutaCortada + "." + jComboTipoArchivo.getSelectedItem());
            archivo.renameTo(nuevaRuta);
            ControladorLimpiador.getInstance().reiniciarBusqueda();
            this.rellenarTable();
        }
    }//GEN-LAST:event_jButtonCambiarExtensionActionPerformed

    private void jButtonCopiaSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCopiaSeguridadActionPerformed
        List<File> listaSeguridad = ControladorLimpiador.getInstance().devolverColeccionArchivos();
        boolean copiaRealizada = false;
        if (listaSeguridad == null) {
            JOptionPane.showMessageDialog(this, "Cree primero la lista de archivos a copiar", "Error en la copia", JOptionPane.ERROR_MESSAGE);
        } else {
            File carpetaCopiaSeguridad = new File(comboUnidadesCopiaSeguridad.getSelectedItem() + "Copia de seguridad");
            carpetaCopiaSeguridad.mkdir();
            for (File file : listaSeguridad) {
                if (file.isFile()) {
                    File copiaSeguridad = new File(carpetaCopiaSeguridad.getAbsolutePath() + "/" + file.getName());
                    copiaRealizada = OperacionesFicheros.copiarArchivo(file.getAbsolutePath(), copiaSeguridad.getAbsolutePath());
                }
            }
            if (copiaRealizada) {
                JOptionPane.showMessageDialog(this, "Se ha acabado de realizar la copia de seguridad", "Copia seguridad", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se ha podido realizar la copia de seguridad", "Copia seguridad", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonCopiaSeguridadActionPerformed

    private void jComboBTamanoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBTamanoItemStateChanged
        if (tableModel != null) {
            ControladorLimpiador.getInstance().reiniciarBusqueda();
            rellenarTable();
        }

    }//GEN-LAST:event_jComboBTamanoItemStateChanged

    private void comboExtensionesBorrablesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboExtensionesBorrablesItemStateChanged
        if (tableModel != null) {
            ControladorLimpiador.getInstance().reiniciarBusqueda();
            rellenarTable();
        }
    }//GEN-LAST:event_comboExtensionesBorrablesItemStateChanged

    private void jButtonEliminarBorrablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarBorrablesActionPerformed
         if (tableModel != null) {
        tableModel.getListaBorrables().forEach((fileABorrar) -> {
            fileABorrar.delete();
        });
        ControladorLimpiador.getInstance().reiniciarBusqueda();
        this.rellenarTable();} else {
            JOptionPane.showMessageDialog(this, "Cree primero la lista de archivos ", "Error en la eliminacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEliminarBorrablesActionPerformed

    private void jButtonCodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCodificarActionPerformed
        if (tableModel != null) {
            int seleccionado = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
            if (seleccionado >= 0) {
                File archivo = ControladorLimpiador.getInstance().devolverColeccionArchivos().get(seleccionado);
                try {
                    operacionesStream.codificadorTxt(archivo, JOptionPane.showInputDialog("Introduzca la contraseña"), false);
                } catch (IOException ex) {
                    Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ControladorLimpiador.getInstance().reiniciarBusqueda();
            this.rellenarTable();
        } else {
            JOptionPane.showMessageDialog(this, "Cree primero la lista de archivos ", "Error en la codificacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCodificarActionPerformed

    private void jButtonDecodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecodificarActionPerformed
        if (tableModel != null) {

            int seleccionado = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());

            if (seleccionado >= 0) {
                File archivo = ControladorLimpiador.getInstance().devolverColeccionArchivos().get(seleccionado);
                try {
                    operacionesStream.codificadorTxt(archivo, JOptionPane.showInputDialog("Introduzca la contraseña"), true);
                } catch (IOException ex) {
                    Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ControladorLimpiador.getInstance().reiniciarBusqueda();
            this.rellenarTable();
        } else {
            JOptionPane.showMessageDialog(this, "Cree primero la lista de archivos ", "Error en la codificacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDecodificarActionPerformed

    public void datosSelector() {
        selectorJfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        selectorJfileChooser.setCurrentDirectory(new File("d:/"));
        selectorJfileChooser.setFileFilter(filtroTextos);
        selectorJfileChooser.setFileFilter(filtroVideos);
        selectorJfileChooser.setFileFilter(filtroTemporales);
        selectorJfileChooser.setFileFilter(filtroImagenes);
    }

    public void rellenarTable() {
        long tamanoMaximo = TAMANO.valueOf(TAMANO.getEnum(jComboBTamano.getSelectedItem().toString()).toString()).getCantidad();
        tableModel = new TableModelFile(tamanoMaximo, "" + comboExtensionesBorrables.getSelectedItem(), ControladorLimpiador.getInstance().ordenarFiles(ControladorLimpiador.getInstance().SeleccionarFilesRecursivamente(), false, jCheckBoxDirectorios.isSelected()));
        jTable1.setModel(tableModel);
        TableRowSorter<TableModelFile> sorter = new TableRowSorter<>(tableModel);
        jTable1.setRowSorter(sorter);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PantallaPrincipal().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboExtensionesBorrables;
    private javax.swing.JComboBox<String> comboUnidades;
    private javax.swing.JComboBox<String> comboUnidadesCopiaSeguridad;
    private javax.swing.JButton jButtonCambiarExtension;
    private javax.swing.JButton jButtonCodificar;
    private javax.swing.JButton jButtonCopiaSeguridad;
    private javax.swing.JButton jButtonDecodificar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonEliminarBorrables;
    private javax.swing.JButton jButtonSeleccionar;
    private javax.swing.JButton jButtonUnidades;
    private javax.swing.JCheckBox jCheckBoxDirectorios;
    private javax.swing.JComboBox<String> jComboBTamano;
    private javax.swing.JComboBox<String> jComboTipoArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel textoUnidad;
    // End of variables declaration//GEN-END:variables
}
