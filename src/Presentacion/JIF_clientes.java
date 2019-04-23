/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.cliente;
import Logica.controladorCliente;
import Logica.fabricaElGuardian;
import Logica.utilidades;
import com.sun.imageio.plugins.png.RowFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jp
 */
public class JIF_clientes extends javax.swing.JInternalFrame {

    fabricaElGuardian fabIns = fabricaElGuardian.getInstance();
    controladorCliente contCliente = (controladorCliente) fabIns.getInstanceIControladorCliente();
    utilidades util = utilidades.getInstance();
    private final JDesktopPane escritorio;
    private String cedula = null;

    /**
     * Creates new form JIF_clientes
     *
     * @param escritorio
     */
    public JIF_clientes(JDesktopPane escritorio) {

        initComponents();
        cargarClientes(null);
        this.escritorio = escritorio;

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
        jT_buscar = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btn_cancelar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTab_clientes = new javax.swing.JTable();

        jLabel1.setText("Buscar");

        jT_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jT_buscarKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_buscarKeyPressed(evt);
            }
        });

        btn_cancelar.setText("Cerrar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addComponent(btn_cancelar)
                .addGap(188, 188, 188))
        );

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_modificar.setText("Modificcar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        jTab_clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTab_clientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(jT_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jT_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        JIF_clientesAlta altaCliente = new JIF_clientesAlta();
        escritorio.add(altaCliente);

        altaCliente.setVisible(true);// TODO add your handling code here:
        //cargarClientes();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        eliminarCliente();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        JIF_clientesModificar modCliente = new JIF_clientesModificar(cedula, this);
        escritorio.add(modCliente);

        modCliente.setVisible(true);// TODO add your handling code here:
        cargarClientes(null);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void jT_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_buscarKeyPressed
        util.filtrarTabla(jT_buscar.getText(), jTab_clientes);

    }//GEN-LAST:event_jT_buscarKeyPressed

    private void jT_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_buscarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_buscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jT_buscar;
    private javax.swing.JTable jTab_clientes;
    // End of variables declaration//GEN-END:variables

////////////////////funciones
    public void cargarClientes(ArrayList<cliente> listaC) {
        jTab_clientes.setEnabled(true);
        if (listaC == null) {
            ArrayList clientes = (ArrayList) contCliente.getClientes();
            if (clientes.size() > 0) {
                jTab_clientes.setEnabled(true);
                String[] cabeceras = (String[]) cabeceras((cliente) clientes.get(0));
                DefaultTableModel modelo = new DefaultTableModel(cabeceras, clientes.size() - 2);
                Iterator it = clientes.listIterator();
                while (it.hasNext()) {
                    cliente cl = (cliente) it.next();
                    Object[] dat = {cl.getNombre(), cl.getApellido(), cl.getCedula(), cl.getTel_cel(), cl.getDireccion(), cl.getCorreo()};
                    modelo.addRow(dat);

                }
                jTab_clientes.setModel(modelo);

            } else {
                JOptionPane.showMessageDialog(this, "No hay clientes ingresados!");
                jTab_clientes.setEnabled(false);
            }
        } else {
            jTab_clientes.setEnabled(true);
            String[] cabeceras = (String[]) cabeceras((cliente) listaC.get(0));
            DefaultTableModel model = new DefaultTableModel(cabeceras, listaC.size() - 1);
            for (cliente cl : listaC) {
                Object[] dat = {cl.getNombre(), cl.getApellido(), cl.getCedula(), cl.getTel_cel(), cl.getDireccion(), cl.getCorreo()};
                model.addRow(dat);
            }
            jTab_clientes.setModel(model);
            //  JXTable table = new JXTable(model);

        }

    }

    private String[] cabeceras(Object obj) {

        ArrayList<String> cab = new ArrayList<>();
        try {

            String separador = Pattern.quote("/");
            String[] cabAux = obj.toString().split(separador);

            for (int i = 0; i < cabAux.length; i++) {
                System.out.println("Tamaño cabAux: " + cabAux.length);
                System.out.println(i);
                String add = cabAux[i];
                cab.add(add);

                System.out.println(cabAux[i]);
                i++;

            }
            String[] cabe = new String[cab.size()];
            for (int s = 0; s < cab.size(); s++) {
                cabe[s] = cab.get(s);
            }

            return cabe;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }

    }

    private void eliminarCliente() {
        int res = JOptionPane.showConfirmDialog(this, "Desea eliminar este cliente: " + cedula + "?");
        if (res == 0) {
            {
                if (contCliente.eliminarCliente(cedula)) {
                    JOptionPane.showMessageDialog(this, "Cliente eliminado con exito!");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el cliente!");
                }
            }
        }
    }

}