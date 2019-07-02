/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ControladorReservas;
import Logica.controladorServicios;
import Logica.fabricaElGuardian;
import Logica.hiloHijo;
import Logica.hiloMadre;
import Logica.iControladorCliente;
import Logica.iControladorReservas;
import Logica.iControladorServicios;
import Logica.iControladorVentas;
import Logica.reserva;
import Logica.utilidades;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.persistence.EntityManager;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jp
 */
public class Principal extends javax.swing.JFrame {
    
    private utilidades util = utilidades.getInstance();
    private EntityManager eM;
    String cuerpo = "coso", asunto = "cospe";
    iControladorCliente ICC = fabricaElGuardian.getInstance().getInstanceIControladorCliente();
    iControladorVentas ICV = fabricaElGuardian.getInstance().getInstanceIControladorVentas();
    iControladorReservas ICR = fabricaElGuardian.getInstance().getInstanceIControladorReservas();
    iControladorServicios ICS=fabricaElGuardian.getInstance().getInstanceIControladorServicios();
    //ICC.cargarMascotas();
    // private JDesktopPane escritorioPrincipal = new JDesktopPane();
    private Long idReserva;

    /**
     * Creates new form Principal
     */
    public Principal() throws AddressException {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
             UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo laf : installedLookAndFeels) {
        }
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.err.println(e.getMessage());
        }
        initComponents();
        cargarInicio();

        // eM= controladorCliente.getEm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorioPrincipal = new javax.swing.JDesktopPane();
        btn_reservar = new javax.swing.JButton();
        btn_modReserva = new javax.swing.JButton();
        btn_eliminarReserva = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableReservas = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jM_cliente = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jM_animal = new javax.swing.JMenu();
        jMenANimal = new javax.swing.JMenuItem();
        jMenItem_banioEsquila = new javax.swing.JMenuItem();
        JM_Configuracion = new javax.swing.JMenu();
        jMenConfRaza = new javax.swing.JMenuItem();
        jMenConfTurno = new javax.swing.JMenuItem();
        jMenuProductos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuListarProductos = new javax.swing.JMenuItem();
        jMenuVentas = new javax.swing.JMenu();
        jMenuIAltaVenta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_reservar.setText("Reservar");
        btn_reservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reservarActionPerformed(evt);
            }
        });

        btn_modReserva.setText("Modificar");
        btn_modReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modReservaActionPerformed(evt);
            }
        });

        btn_eliminarReserva.setText("Eliminar");
        btn_eliminarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarReservaActionPerformed(evt);
            }
        });

        jTableReservas.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableReservasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableReservas);

        escritorioPrincipal.setLayer(btn_reservar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorioPrincipal.setLayer(btn_modReserva, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorioPrincipal.setLayer(btn_eliminarReserva, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorioPrincipal.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioPrincipalLayout = new javax.swing.GroupLayout(escritorioPrincipal);
        escritorioPrincipal.setLayout(escritorioPrincipalLayout);
        escritorioPrincipalLayout.setHorizontalGroup(
            escritorioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_reservar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btn_modReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btn_eliminarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(813, 813, 813))
            .addGroup(escritorioPrincipalLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        escritorioPrincipalLayout.setVerticalGroup(
            escritorioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioPrincipalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(escritorioPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reservar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        jM_cliente.setText("Cliente");

        jMenuItem1.setText("Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jM_cliente.add(jMenuItem1);

        jMenuBar1.add(jM_cliente);

        jM_animal.setText("Mascota");

        jMenANimal.setText("Mascota");
        jMenANimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenANimalActionPerformed(evt);
            }
        });
        jM_animal.add(jMenANimal);

        jMenItem_banioEsquila.setText("Baño/Esquila");
        jMenItem_banioEsquila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenItem_banioEsquilaActionPerformed(evt);
            }
        });
        jM_animal.add(jMenItem_banioEsquila);

        jMenuBar1.add(jM_animal);

        JM_Configuracion.setText("Configuracion");

        jMenConfRaza.setText("Razas");
        jMenConfRaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenConfRazaActionPerformed(evt);
            }
        });
        JM_Configuracion.add(jMenConfRaza);

        jMenConfTurno.setText("Turnos");
        jMenConfTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenConfTurnoActionPerformed(evt);
            }
        });
        JM_Configuracion.add(jMenConfTurno);

        jMenuBar1.add(JM_Configuracion);

        jMenuProductos.setText("Productos");

        jMenuItem2.setText("Alta Producto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuProductos.add(jMenuItem2);

        jMenuListarProductos.setText("Listar Productos");
        jMenuListarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListarProductosActionPerformed(evt);
            }
        });
        jMenuProductos.add(jMenuListarProductos);

        jMenuBar1.add(jMenuProductos);

        jMenuVentas.setText("Ventas");

        jMenuIAltaVenta.setText("Alta Venta");
        jMenuIAltaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIAltaVentaActionPerformed(evt);
            }
        });
        jMenuVentas.add(jMenuIAltaVenta);

        jMenuBar1.add(jMenuVentas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorioPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorioPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        /*Alta_Perfil altaP = new Alta_Perfil();
        this.getContentPane().add(altaP);
        altaP.show();*/
        JIF_clientes altaCliente = new JIF_clientes(escritorioPrincipal);
        this.escritorioPrincipal.add(altaCliente);
        //this.getContentPane().add(altaCliente);
        altaCliente.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenConfRazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenConfRazaActionPerformed
        JIF_raza raza = new JIF_raza(escritorioPrincipal);
        this.escritorioPrincipal.add(raza);
        raza.setVisible(true);
    }//GEN-LAST:event_jMenConfRazaActionPerformed

    private void jMenConfTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenConfTurnoActionPerformed
        JIF_turnos turno = new JIF_turnos();
        this.escritorioPrincipal.add(turno);
        turno.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenConfTurnoActionPerformed

    private void jMenANimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenANimalActionPerformed
        JIF_animal animal;
        animal = new JIF_animal(escritorioPrincipal);
        this.escritorioPrincipal.add(animal);
        animal.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenANimalActionPerformed

    private void btn_reservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reservarActionPerformed
        JIF_reservarTurno reservaTurno = new JIF_reservarTurno(escritorioPrincipal);
        this.escritorioPrincipal.add(reservaTurno);
        reservaTurno.setVisible(true);
    }//GEN-LAST:event_btn_reservarActionPerformed

    private void jMenItem_banioEsquilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenItem_banioEsquilaActionPerformed
        JIF_esquilaBaño banioEsquila = new JIF_esquilaBaño(this.escritorioPrincipal);
        this.escritorioPrincipal.add(banioEsquila);
        banioEsquila.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jMenItem_banioEsquilaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        /*        
        AltaProducto altaP = new AltaProducto();
        this.escritorioPrincipal.add(altaP);
        altaP.setVisible(true);     */   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuIAltaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIAltaVentaActionPerformed
        /*        AltaVenta altv = new AltaVenta();
        this.escritorioPrincipal.add(altv);
        altv.setVisible(true);   */     // TODO add your handling code here:
    }//GEN-LAST:event_jMenuIAltaVentaActionPerformed

    private void jMenuListarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListarProductosActionPerformed
        /*        ListarProductos lsProd = new ListarProductos(this.escritorioPrincipal);
        this.escritorioPrincipal.add(lsProd);
        lsProd.setVisible(true);*/
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuListarProductosActionPerformed

    private void btn_modReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modReservaActionPerformed
        if (this.idReserva != null) {
            if (JOptionPane.showConfirmDialog(this, "Desea modificar la reserva?") == 0) {
                JIF_modificarReserva nuevoModificarReserva = new JIF_modificarReserva(this.escritorioPrincipal, this.idReserva);
                escritorioPrincipal.add(nuevoModificarReserva);
                nuevoModificarReserva.setVisible(true);
            }
        }
    }//GEN-LAST:event_btn_modReservaActionPerformed

    private void jTableReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableReservasMouseClicked
        int row = jTableReservas.rowAtPoint(evt.getPoint());
        this.idReserva = (Long) jTableReservas.getValueAt(row, 0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableReservasMouseClicked

    private void btn_eliminarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarReservaActionPerformed
        if (this.idReserva != null) {
            if (JOptionPane.showConfirmDialog(this, "Desea eliminar la reserva?") == 0) {
                if (ControladorReservas.getInstance().eliminarReserva(this.idReserva) == true) {
                    JOptionPane.showMessageDialog(this, "Se ha eliminado la reserva!");
                    cargarReservas();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar la reserva!");
                }
                
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarReservaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (AddressException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JM_Configuracion;
    private javax.swing.JButton btn_eliminarReserva;
    private javax.swing.JButton btn_modReserva;
    private javax.swing.JButton btn_reservar;
    private javax.swing.JDesktopPane escritorioPrincipal;
    private javax.swing.JMenu jM_animal;
    private javax.swing.JMenu jM_cliente;
    private javax.swing.JMenuItem jMenANimal;
    private javax.swing.JMenuItem jMenConfRaza;
    private javax.swing.JMenuItem jMenConfTurno;
    private javax.swing.JMenuItem jMenItem_banioEsquila;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuIAltaVenta;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuListarProductos;
    private javax.swing.JMenu jMenuProductos;
    private javax.swing.JMenu jMenuVentas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableReservas;
    // End of variables declaration//GEN-END:variables

    public JDesktopPane getEscritorioPrincipal() {
        return escritorioPrincipal;
    }
    
    public void setEscritorioPrincipal(JDesktopPane escritorioPrincipal) {
        this.escritorioPrincipal = escritorioPrincipal;
    }
    
    private void cargarInicio() {
        
        ICV.cargarproductos();
        ICS.cargarTiposServicios();//carga los tipos de servicios
        // cargarReservas();
        hiloMadre m = new hiloMadre();
        m.start();
        jTableReservas.setEnabled(true);
        hiloHijo hhijo = new hiloHijo();
        //  cargarReservas();
        hhijo.setTablaParaLLenar(this.jTableReservas);
        m.agregarHilo("h1", hhijo);
        /* try {
            m.sleep(1000);
            } catch (Exception e) {
            }*/
        // m.pararHilo("h1");

    }
    
    public void cargarModelo(DefaultTableModel model) {
        jTableReservas.setModel(model);
    }
    
    private void cargarReservas() {
        try {
            List<reserva> reservasDelDia = (List<reserva>) ICR.getReservasDelDia();
            if (!reservasDelDia.isEmpty()) {
                String[] cabeceras = util.cabeceras(reservasDelDia.get(0));
                DefaultTableModel dtm = new DefaultTableModel(cabeceras, 0);
                for (reserva r : reservasDelDia) {
                    Object[] data = {r.getId(), r.getFechaReserva(), r.getDescripcion(), r.isCorrea(), r.isBozal(), r.getMascota().getNombre(), r.getCliente().getCorreo()};
                    dtm.addRow(data);
                }
                //jTableReservas.setEnabled(true);
                this.jTableReservas.setModel(dtm);
            } else {
                //  jTableReservas.setModel(new DefaultTableModel(0, 0));
                this.jTableReservas.setEnabled(false);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
