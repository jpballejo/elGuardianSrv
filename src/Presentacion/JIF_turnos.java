/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ControladorReservas;
import Logica.turno;
import Logica.utilidades;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

/**
 *
 * @author jp
 */
public class JIF_turnos extends javax.swing.JInternalFrame {
    
    private ControladorReservas contReser = ControladorReservas.getInstance();
    private Long turnoSeleccionado = null;
    utilidades util = utilidades.getInstance();

    /**
     * Creates new form JIF_turnos
     */
    public JIF_turnos() {
        Dimension d = new Dimension(472, 292);
        this.setSize(d);
        initComponents();
        cargarTurnos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTurno = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTab_turnos = new javax.swing.JTable();
        btn_nuevo = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jcb_hora = new javax.swing.JComboBox<>();
        btn_agregar = new javax.swing.JButton();

        setResizable(true);
        setPreferredSize(new java.awt.Dimension(472, 292));

        panelTurno.setPreferredSize(new java.awt.Dimension(462, 292));
        panelTurno.setRequestFocusEnabled(false);

        jTab_turnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTab_turnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTab_turnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTab_turnos);

        btn_nuevo.setText("Nuevo Turno");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar Turno");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jcb_hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTurnoLayout = new javax.swing.GroupLayout(panelTurno);
        panelTurno.setLayout(panelTurnoLayout);
        panelTurnoLayout.setHorizontalGroup(
            panelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTurnoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelTurnoLayout.createSequentialGroup()
                        .addComponent(jcb_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTurnoLayout.setVerticalGroup(
            panelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTurnoLayout.createSequentialGroup()
                .addGroup(panelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTurnoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTurnoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btn_nuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btn_eliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancelar)))
                .addGap(18, 18, 18)
                .addGroup(panelTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_agregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTurno, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );

        panelTurno.getAccessibleContext().setAccessibleName("");
        panelTurno.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Desea agregar un nuevo turno?") == 0) {
            //[472, 375]   
            cargarHorasDisponibles();
            this.setSize(472, 375);
            panelTurno.setSize(472, 375);
            btn_agregar.setEnabled(true);
            
        }  // TODO add your handling code here:
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        
        eliminarTurno();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        nuevoTurno();// TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void jTab_turnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTab_turnosMouseClicked
        int row = jTab_turnos.rowAtPoint(evt.getPoint());
        turnoSeleccionado = (Long) jTab_turnos.getValueAt(row, 0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTab_turnosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTab_turnos;
    private javax.swing.JComboBox<String> jcb_hora;
    private javax.swing.JPanel panelTurno;
    // End of variables declaration//GEN-END:variables

    private void cargarTurnos() {
        List<turno> turnos = contReser.getTurnos();
        if (turnos.size() > 0) {
            String[] cabeceras = util.cabeceras(turnos.get(0));
            DefaultTableModel nuevoModelo = new DefaultTableModel(cabeceras, 0);
            
            for (turno tur : turnos) {
                Object[] datos = {tur.getId(), tur.getHora()};
                nuevoModelo.addRow(datos);
            }
            jTab_turnos.setModel(nuevoModelo);
            jTab_turnos.setEnabled(true);
            util.resizeColumnWidth(jTab_turnos);
            
        } else {
            JOptionPane.showMessageDialog(this, "No existen turnos en el sistema!");
            jTab_turnos.setEnabled(false);
            jTab_turnos.setModel(null);
        }
    }
    
    private void nuevoTurno() {
        if (jcb_hora.getSelectedIndex() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Desea agregar el nuevo turno") == 0) {
                turno nuevo = new turno();
                nuevo.setHora(jcb_hora.getSelectedItem().toString());
                if (!contReser.existeTurno(nuevo)) {
                    boolean res = contReser.nuevoTurno(nuevo);
                    if (res) {
                        JOptionPane.showMessageDialog(this, "Turno agregado con exito!");
                        Dimension d = new Dimension(472, 292);
                        this.setSize(d);
                        
                    }
                    this.cargarTurnos();
                    this.cargarHorasDisponibles();
                } else {
                    JOptionPane.showMessageDialog(this, "Ya existe un turno registrado en esa hora!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una hora!");
            jcb_hora.requestFocus();
        }
    }
    
    private void eliminarTurno() {
        if (turnoSeleccionado != null) {
            int res = JOptionPane.showConfirmDialog(this, "Desea eliminar el turno: " + turnoSeleccionado);
            if (res == 0) {
                if (contReser.eliminarTurno(turnoSeleccionado)) {
                    JOptionPane.showMessageDialog(this, "El turno fue eliminado!");
                    cargarTurnos();
                    cargarHorasDisponibles();
                }
            }
        }
    }
    
    private void cargarHorasDisponibles() {
        List<String> horas = (List<String>) contReser.getHorasDisponibles();
        JComboBox comboHoras = new JComboBox();
        comboHoras.addItem("Seleccionar HORA");
        for (String hs : horas) {
            comboHoras.addItem(hs);
        }
        jcb_hora.setModel(comboHoras.getModel());
    }
}