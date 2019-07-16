/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Imagenes;
import Logica.fabricaElGuardian;
import Logica.iControladorCliente;
import Logica.utilidades;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author PC
 */
public class JIF_galeria extends javax.swing.JInternalFrame {
    
    private static iControladorCliente iCC = fabricaElGuardian.getInstance().getInstanceIControladorCliente();
    private String ruta=iCC.getRutaFotoImagenesGaleriaLevantar();
    private File imageDir = new File(ruta);
    private File[] images = imageDir.listFiles();
    private List<Imagenes> imgGalBD = new ArrayList<>();
    private String nombreViejo;
     private static JDesktopPane escritorio = null;
    
    private utilidades util = utilidades.getInstance();
    int orden=0;
     
       
    
 
  
    /**
     * Creates new form JIF_galeria
     */
    public JIF_galeria(JDesktopPane escritorioV) {
        this.escritorio = escritorioV;
        initComponents();
   
       this.imgGalBD= iCC.getListaImagenesGaleria();
       recargarLista();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGaleria = new javax.swing.JTable();
        jLab_foto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        comboOrden = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nombfot = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        prio = new javax.swing.JLabel();
        spinnerprio = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);

        tablaGaleria.setAutoCreateRowSorter(true);
        tablaGaleria.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tablaGaleria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero", "Prioridad", "Nombre", "Fecha de modificacion", "Tamaño"
            }
        ));
        tablaGaleria.setRowHeight(20);
        tablaGaleria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGaleriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGaleria);

        jLab_foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Imagen Seleccionada");

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Persistir Orden");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        comboOrden.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        comboOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Order por Nombre Asc.", "Order por Nombre Desc.", "Ordenar por fecha Asc.", "Ordenar por fecha Desc.", "Ordernar por Prioridad Asc.", "Ordernar por Prioridad Desc." }));
        comboOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrdenActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton5.setText("Actualizar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel2.setText("Galeria de Fotos");

        nombfot.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        nombfot.setText("Nombre Foto");

        jButton6.setText("Guardar Cambios");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("Nombre:");

        prio.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        prio.setText("Prioridad:");

        spinnerprio.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        spinnerprio.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(comboOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(prio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombfot, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerprio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLab_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLab_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nombfot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spinnerprio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaGaleriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGaleriaMouseClicked
        int rowAtPoint = tablaGaleria.rowAtPoint(evt.getPoint()); 
        String nombreFoto = (String) tablaGaleria.getValueAt(rowAtPoint, 2);
        
        nombreViejo= nombreFoto;
        
        
        nombfot.setText((String) tablaGaleria.getValueAt(rowAtPoint, 2));
        spinnerprio.setValue(tablaGaleria.getValueAt(rowAtPoint,1));
        
       
        
        cargarFoto(nombreFoto);        // TODO add your handling code here:
    }//GEN-LAST:event_tablaGaleriaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index = tablaGaleria.getSelectedRow();
        TableModel model = tablaGaleria.getModel();
        String nombreFoto = (String)model.getValueAt(index, 2);

        int respuesta = JOptionPane.showConfirmDialog(null, "Esta imagen/es será eliminada/s\n Desea continuar?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (respuesta == 0) {

            boolean ok = iCC.EliminarFotoGaleria(nombreFoto);
            if(ok)
                JOptionPane.showMessageDialog(null, "Imagen Eliminada con exito");
                recargarLista();
                nombfot.setText("");
                        spinnerprio.setValue(1);
                        jLab_foto.setIcon(null);

        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        
        for(int i=0;i<iCC.getListaImagenesGaleria().size();i++){
               
               Imagenes img = iCC.getListaImagenesGaleria().get(i);
               img.setIndice(i);
               iCC.modificarFoto(img, nombreViejo);
            }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void comboOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrdenActionPerformed
        this.orden=comboOrden.getSelectedIndex();        // TODO add your handling code here:
    }//GEN-LAST:event_comboOrdenActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if (this.orden==0)
            ordenarPorNombre(true);
       
        if (this.orden==1)
            ordenarPorNombre(false);
        
        if (this.orden==2)
            ordenarPorFecha(true);
        
        if (this.orden==3)
            ordenarPorFecha(false);
        
       
        if (this.orden==4)
            ordenarPorPrioridad(true);
        
        if (this.orden==5)
            ordenarPorPrioridad(false);

                
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      String nombre = nombfot.getText();
      int prior= (Integer) spinnerprio.getValue();
      
      if("".equals(nombre))
           JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
      else{
      
      
      
       for(int i=0;i<imgGalBD.size();i++){
           
           if(imgGalBD.get(i).getNombre().compareTo(nombreViejo)==0){
                   
               Imagenes img = imgGalBD.get(i);
               img.setPrioridad(prior);
               img.setNombre(nombre);
               iCC.modificarFoto(img,nombreViejo);
               JOptionPane.showMessageDialog(null, "Imagen Modificada con exito");
            }

      }
      
      
      }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        NuevaImagen nv = new NuevaImagen();
        this.escritorio.add(nv);
        
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = nv.getSize();
        nv.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        //m.show();
        
        nv.setVisible(true);              // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboOrden;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLab_foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombfot;
    private javax.swing.JLabel prio;
    private javax.swing.JSpinner spinnerprio;
    private javax.swing.JTable tablaGaleria;
    // End of variables declaration//GEN-END:variables

    public void cargarFoto(String nombreFoto) {
        
        
        if (!nombreFoto.equals("")) {
            BufferedImage image = (BufferedImage) util.dameEstaImagen(ruta+nombreFoto);
            jLab_foto.setIcon(new ImageIcon(image));
            Image scaledInstance = image.getScaledInstance(427, 400, Image.SCALE_DEFAULT);
            jLab_foto.setIcon(new ImageIcon(scaledInstance));
        }

    
    }

    public void recargarLista() {
        
        
        DefaultTableModel modelo = (DefaultTableModel) tablaGaleria.getModel();
        modelo.setRowCount(0);

         
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );

        
        tablaGaleria.getColumnModel().getColumn(0).setPreferredWidth(30);
        tablaGaleria.getColumnModel().getColumn(1).setPreferredWidth(30);
        tablaGaleria.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaGaleria.getColumnModel().getColumn(3).setPreferredWidth(100);
        tablaGaleria.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        

        tablaGaleria.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        tablaGaleria.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        tablaGaleria.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        tablaGaleria.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        
        
        
         for(int i=0;i<iCC.getListaImagenesGaleria().size();i++){
               
            Imagenes img = iCC.getListaImagenesGaleria().get(i);



            File imageFile = new File(imageDir, img.getNombre());

            double bytes = imageFile.length();
            double kilobytes = (bytes / 1024);

            DecimalFormat df = new DecimalFormat("#,##");      
            kilobytes = Double.valueOf(df.format(kilobytes));

            DecimalFormat formatter = new DecimalFormat("00");


            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            Object[] dat = {modelo.getRowCount(),img.getPrioridad(),img.getNombre(),sdf.format(imageFile.lastModified()), kilobytes+"KB"};

            modelo.addRow(dat);
                
            
               
            }
         
  
      

        
    }
    
    public void ordenarPorNombre(final boolean sortAsc) {

         
        Collections.sort(imgGalBD, new Comparator<Imagenes>() {
        @Override
        public int compare(Imagenes i1, Imagenes i2) {



              if (sortAsc) {
                 return i1.getNombre().compareTo(i2.getNombre());
              } else {
                 return -1 * i1.getNombre().compareTo(i2.getNombre());
              }



            }
          });

        iCC.setListaImagenesGaleria(imgGalBD);
        recargarLista();
          
  

    }

    public void ordenarPorFecha(final boolean sortAsc) {
       Comparator<File> comparator = new Comparator<File>() {
          @Override
            public int compare(File o1, File o2) {

                if (sortAsc) {
                    return Long.valueOf(o1.lastModified()).
                            compareTo(o2.lastModified());
                } else {
                   return -1 * Long.valueOf(o1.lastModified()).
                            compareTo(o2.lastModified());
                }
            }
        };

        Arrays.sort(images, comparator);
        
        List<Imagenes> imgOrd= new ArrayList<>();
        
         for (File imageFile : images) {
           Imagenes im = null;
             
             for(int i=0;i<imgGalBD.size();i++){
             
                if(imgGalBD.get(i).getNombre().compareTo(imageFile.getName())==0)
                    im= imgGalBD.get(i);
            }
             
             imgOrd.add(im);
         }
         
        iCC.setListaImagenesGaleria(imgOrd);
        

        recargarLista();
    }

    public void ordenarPorPrioridad(final boolean sortAsc) {
        
        
        Collections.sort(imgGalBD, new Comparator<Imagenes>() {
        @Override
        public int compare(Imagenes i1, Imagenes i2) {



              if (sortAsc) {
                 return i1.getPrioridad()-i2.getPrioridad();
              } else {
                 return -1 * i1.getPrioridad()-i2.getPrioridad();
              }



            }
          });

        iCC.setListaImagenesGaleria(imgGalBD);
        recargarLista();
        
        
    }
    
    
    public boolean existeNombre(String nombre) {
        
        
        
         for(int i=0;i<imgGalBD.size();i++){
             
                if(imgGalBD.get(i).getNombre().compareTo(nombre)==0)
                     return true;
            }
         
       
        
    return false;
        
    }
    
}
