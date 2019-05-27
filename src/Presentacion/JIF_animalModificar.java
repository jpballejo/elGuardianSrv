/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.controladorCliente;
import Logica.fabricaElGuardian;
import Logica.mascota;
import Logica.utilidades;
import java.awt.Image;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jp
 */
public class JIF_animalModificar extends javax.swing.JInternalFrame {
 JFileChooser navegadorArchivos = new JFileChooser();
    private Image fotoMascota;
  //  private final JDesktopPane escritorio;
    private controladorCliente contC = (controladorCliente) fabricaElGuardian.getInstance().getInstanceIControladorCliente();
    private DefaultListModel modelo = null;
    private HashMap<String, String> clientes = new HashMap<>();
    String rutaFoto = "/home/jp/Escritorio/elGuardianServidor/ImagenesMascotas";
    private final String idMascota;
    utilidades util = utilidades.getInstance();
    private DefaultListModel dlm = new DefaultListModel();
    /**
     * Creates new form JIF_animalModificar
     * @param idMascota
     */
    public JIF_animalModificar(String idMascota) {
        initComponents();
        this.idMascota = idMascota;
        cargarMascota();
        
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
        jLabel1 = new javax.swing.JLabel();
        JLab_nombreCliente = new javax.swing.JLabel();
        JLab_cedula = new javax.swing.JLabel();
        JLab_nomMascota = new javax.swing.JLabel();
        JText_nomMascota = new javax.swing.JTextField();
        JRad_perro = new javax.swing.JRadioButton();
        JRad_gato = new javax.swing.JRadioButton();
        JLab_tipMascota = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRaza = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        JLab_descripcion = new javax.swing.JLabel();
        btn_foto = new javax.swing.JButton();
        JLAB_foto = new javax.swing.JLabel();
        btn_aceptar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jText_buscarRaza = new javax.swing.JTextField();
        btn_nuevaRaza = new javax.swing.JButton();

        jLabel1.setText("Cliente:");

        JLab_nombreCliente.setText("NombreCliente");

        JLab_cedula.setText("Cedula");

        JLab_nomMascota.setText("Nombre Mascota:");

        JRad_perro.setText("PERRO");

        JRad_gato.setText("GATO");

        JLab_tipMascota.setText("Tipo Mascota:");

        jListRaza.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListRaza);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        JLab_descripcion.setText("Descripcion:");

        btn_foto.setText("Foto Mascota");

        JLAB_foto.setText("FOTO");

        btn_aceptar.setText("Aceptar");

        btn_cancelar.setText("Cancelar");

        jLabel3.setText("Raza:");

        jText_buscarRaza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jText_buscarRazaKeyTyped(evt);
            }
        });

        btn_nuevaRaza.setText("Nueva");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(38, 38, 38)
                                .addComponent(jText_buscarRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(JLab_descripcion)
                                        .addGap(15, 15, 15))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_nuevaRaza)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))))
                        .addGap(42, 42, 42)
                        .addComponent(btn_aceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JLab_nomMascota)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JText_nomMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JLab_nombreCliente)
                                        .addGap(18, 18, 18)
                                        .addComponent(JLab_cedula))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(JLab_tipMascota)
                                        .addGap(18, 18, 18)
                                        .addComponent(JRad_perro)
                                        .addGap(18, 18, 18)
                                        .addComponent(JRad_gato)))
                                .addGap(114, 114, 114)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLAB_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JLab_nombreCliente)
                            .addComponent(JLab_cedula)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btn_foto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLab_nomMascota)
                            .addComponent(JText_nomMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLab_tipMascota)
                            .addComponent(JRad_perro)
                            .addComponent(JRad_gato))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jText_buscarRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btn_nuevaRaza))))
                    .addComponent(JLAB_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLab_descripcion)
                        .addGap(84, 84, 84))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_aceptar)
                                .addComponent(btn_cancelar)))
                        .addContainerGap(26, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jText_buscarRazaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jText_buscarRazaKeyTyped
        buscar(jText_buscarRaza);
    }//GEN-LAST:event_jText_buscarRazaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLAB_foto;
    private javax.swing.JLabel JLab_cedula;
    private javax.swing.JLabel JLab_descripcion;
    private javax.swing.JLabel JLab_nomMascota;
    private javax.swing.JLabel JLab_nombreCliente;
    private javax.swing.JLabel JLab_tipMascota;
    private javax.swing.JRadioButton JRad_gato;
    private javax.swing.JRadioButton JRad_perro;
    private javax.swing.JTextField JText_nomMascota;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_foto;
    private javax.swing.JButton btn_nuevaRaza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListRaza;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jText_buscarRaza;
    // End of variables declaration//GEN-END:variables

    public void cargarRazas() {
        List<String> razasApiRest = contC.getRazasDB();
        DefaultListModel dlm = new DefaultListModel();
        for (String raza : razasApiRest) {
            dlm.addElement(raza);
        }
        jListRaza.setModel(dlm);

        this.setModelo(dlm);
    }

    private void buscar(JTextField jtxt) {

        DefaultListModel modeln = (DefaultListModel) util.filtrarJList(jtxt.getText(), this.getModelo());
        jListRaza.setModel(modeln);
    }

    private void limpiar() {
        //.setText(null);
        jTextArea1.setText(null);
       // jComboClientes.setSelectedIndex(0);
        jListRaza.clearSelection();

    }

 
    private void selecImagen() {
      
    }

    private boolean validarDatos() {
        if (JText_nomMascota.getText() == null) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para la mascota!");
            JText_nomMascota.requestFocus();
            JText_nomMascota.selectAll();
            return false;
        }
        if (jListRaza.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una raza para la mascota!");
            jListRaza.requestFocus();
            return false;
        }
      

        return true;

    }
    
    private void cargarMascota() {
        mascota msc= (mascota)   contC.getMascota(idMascota);
        
    }

    public DefaultListModel getModelo() {
        return dlm;
    }

    public void setModelo(DefaultListModel dlm) {
        this.dlm = dlm;
    }
}
