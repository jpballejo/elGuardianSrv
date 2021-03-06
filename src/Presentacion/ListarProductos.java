/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.GenerarPDF;
import Logica.fabricaElGuardian;
import Logica.iControladorVentas;
import Logica.producto;
import Logica.utilidades;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PabloP
 */
public class ListarProductos extends javax.swing.JInternalFrame {

    private static iControladorVentas iCV = fabricaElGuardian.getInstance().getInstanceIControladorVentas();
    private static JDesktopPane escritorio = null;
    //ModificarProducto modProd = new ModificarProducto();
    utilidades util = utilidades.getInstance();

    /**
     * Creates new form ListarProductos
     */
    public ListarProductos(JDesktopPane escritorioV) {
        this.escritorio = escritorioV;
        initComponents();
        recargarlista();
    }

    ListarProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProd = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TablaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Descripcion", "Disponible", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaProd.setFocusable(false);
        jScrollPane1.setViewportView(TablaProd);

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jButton4)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //fabricaElGuardian fabrica = fabricaElGuardian.getInstance();
        //iControladorVentas iCV = fabrica.getInstanceIControladorVentas();

        int index = TablaProd.getSelectedRow();
        TableModel model = TablaProd.getModel();
        String codigo = model.getValueAt(index, 0).toString();
        String nombre = model.getValueAt(index, 1).toString();
        String precio = model.getValueAt(index, 2).toString();
        String descripcion = model.getValueAt(index, 3).toString();
        String stock = model.getValueAt(index, 5).toString();

        try {
            ModificarProducto ModificarProd = new ModificarProducto(this.escritorio);
            this.escritorio.add(ModificarProd);
            this.setVisible(false);
            ModificarProd.toFront();
            ModificarProd.setVisible(true);
            ModificarProd.pack();
            ModificarProd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            ModificarProd.jTextField5.setText(codigo);
            ModificarProd.jTextField2.setText(nombre);
            ModificarProd.jTextField3.setText(precio);
            ModificarProd.jTextField4.setText(descripcion);
            ModificarProd.jTextField1.setText(stock);

            String disponible;
            disponible = model.getValueAt(index, 4).toString();

            if (disponible.compareTo("Disponible") == 0) {
                ModificarProd.jCheckBox1.setSelected(true);
            } else {
                ModificarProd.jCheckBox1.setSelected(false);
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int index = TablaProd.getSelectedRow();
        TableModel model = TablaProd.getModel();
        Long codigo = Long.parseLong(model.getValueAt(index, 0).toString());

        int respuesta = JOptionPane.showConfirmDialog(null, "Este producto será eliminado\n Desea continuar?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (respuesta == 0) {

            iCV.EliminarProducto(codigo);
            JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
            recargarlista();

        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        AltaProducto altaP = new AltaProducto();
        this.escritorio.add(altaP);
        altaP.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

  

    public void recargarlista() {

        List<producto> listaP =null;
        listaP = (List<producto>) iCV.ListarProductos();
        
      
        if (listaP.size() > 0) {
            String[] cabeceras = util.cabeceras(listaP.get(0));
            DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();
        //  DefaultTableModel modelo = new DefaultTableModel(cabeceras, 0);
            modelo.setRowCount(0);
            for (int i = 0; i < listaP.size(); i++) {
                String dispo;

                if (listaP.get(i).isDisponible() == true) {
                    dispo = "Disponible";
                } else {
                    dispo = "No Disponible";
                }

                Object[] dat = {listaP.get(i).getCodigo(), listaP.get(i).getNombre(), listaP.get(i).getPrecio(),
                    listaP.get(i).getDescripcion(), dispo,listaP.get(i).getCantidad()};

                modelo.addRow(dat);
            }
          //  TablaProd.setModel(modelo);
       } else {
            JOptionPane.showMessageDialog(null, "No existen productos en el sistema!");
            TablaProd.setVisible(false);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable TablaProd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
