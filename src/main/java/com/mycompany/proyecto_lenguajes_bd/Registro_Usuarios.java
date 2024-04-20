/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto_lenguajes_bd;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Registro_Usuarios extends javax.swing.JFrame {

    public Registro_Usuarios() {
        initComponents();
        this.setLocationRelativeTo(null);//Centrar
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_RegistroCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_RegistrarUsuario = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_RegistroContrasena = new javax.swing.JPasswordField();
        txt_RegistroConfirmarContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(27, 145, 201));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(195, 232, 236));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cedula");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 98, -1, -1));
        jPanel1.add(txt_RegistroCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 132, 170, -1));

        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 172, -1, -1));

        btn_RegistrarUsuario.setText("Registrarse");
        btn_RegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btn_RegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, -1, -1));

        jLabel3.setText("Confirmar Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 246, -1, -1));

        txt_RegistroContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RegistroContrasenaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_RegistroContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 206, 170, -1));
        jPanel1.add(txt_RegistroConfirmarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 280, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarUsuarioActionPerformed
    
        String contrasena = txt_RegistroContrasena.getText();
        String confirmarContrasena = txt_RegistroConfirmarContrasena.getText();

        if (contrasena.equals(confirmarContrasena)) {
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
            this.setVisible(false);
            new Menu().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden. Intente nuevamente");
        }
    
      
    }//GEN-LAST:event_btn_RegistrarUsuarioActionPerformed

    private void txt_RegistroContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RegistroContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RegistroContrasenaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Registro_Usuarios().setVisible(true);
                
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton btn_RegistrarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_RegistroConfirmarContrasena;
    private javax.swing.JPasswordField txt_RegistroContrasena;
    private javax.swing.JTextField txt_RegistroCorreo;
    // End of variables declaration//GEN-END:variables
}
