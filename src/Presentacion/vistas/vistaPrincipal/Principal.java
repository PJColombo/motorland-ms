package Presentacion.vistas.vistaPrincipal;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



import Presentacion.comandos.listadecomandos.ListaComandos;
import Presentacion.controlador.Controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
    	this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/MotorLand.png")).getImage());
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	    	
        jButtonAlquiler = new javax.swing.JButton();
        jButtonClientes = new javax.swing.JButton();
        jButtonDepartamento = new javax.swing.JButton();
        jButtonVehiculo = new javax.swing.JButton();
        jButtonConcesionario = new javax.swing.JButton();
        jButtonEmpleados = new javax.swing.JButton();
        jButtonAcercaDe = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAlquiler.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAlquiler.setText("ALQUILER");
        jButtonAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlquilerActionPerformed(evt);
            }
        });

        jButtonClientes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonClientes.setText("CLIENTES");
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });

        jButtonDepartamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonDepartamento.setText("DEPARTAMENTOS");
        jButtonDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDepartamentoActionPerformed(evt);
            }
        });

        jButtonVehiculo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonVehiculo.setText("VEHICULO");
        jButtonVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVehiculoActionPerformed(evt);
            }
        });

        jButtonConcesionario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonConcesionario.setText("CONCESINARIO");
        jButtonConcesionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcesionarioActionPerformed(evt);
            }
        });

        jButtonEmpleados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonEmpleados.setText("EMPLEADOS");
        jButtonEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmpleadosActionPerformed(evt);
            }
        });

        jButtonAcercaDe.setText("Acerca de");
        jButtonAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcercaDeActionPerformed(evt);
            }
        });
        /*
        jButtonAyuda.setText("Ayuda");
        jButtonAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAyudaActionPerformed(evt);
            }
        });
        */

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAcercaDe)
                        .addGap(91, 91, 91)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonConcesionario, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConcesionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAcercaDe)
                    //.addComponent(jButtonAyuda)
                    .addComponent(jButtonSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVehiculoActionPerformed
    	Controller.getInstance().run(ListaComandos.VISTAMENUVEHICULO, null);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonVehiculoActionPerformed

    private void jButtonAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlquilerActionPerformed
    	Controller.getInstance().run(ListaComandos.VISTAMENUALQUILER, null);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAlquilerActionPerformed

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
    	Controller.getInstance().run(ListaComandos.VISTAMENUCLIENTE, null);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDepartamentoActionPerformed
        JOptionPane.showMessageDialog(null,"En mantenimiento");
    }//GEN-LAST:event_jButtonDepartamentoActionPerformed

    private void jButtonConcesionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcesionarioActionPerformed
        JOptionPane.showMessageDialog(null,"En mantenimiento");
    }//GEN-LAST:event_jButtonConcesionarioActionPerformed

    private void jButtonEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmpleadosActionPerformed
        JOptionPane.showMessageDialog(null,"En mantenimiento");
    }//GEN-LAST:event_jButtonEmpleadosActionPerformed

    private void jButtonAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcercaDeActionPerformed
    	Controller.getInstance().run(ListaComandos.VISTAACERCADE, null);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAcercaDeActionPerformed


    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
         JOptionPane.showMessageDialog(null,"Hasta pronto :D");
         System.exit(WIDTH);
    }//GEN-LAST:event_jButtonSalirActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcercaDe;
    private javax.swing.JButton jButtonAlquiler;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonConcesionario;
    private javax.swing.JButton jButtonDepartamento;
    private javax.swing.JButton jButtonEmpleados;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonVehiculo;
    // End of variables declaration//GEN-END:variables
}


