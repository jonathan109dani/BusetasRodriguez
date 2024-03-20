/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto_lenguajes_bd;

import CRUD_Conductores.Crear_Conductor;
import CRUD_Conductores.Eliminar_Conductor;
import CRUD_Conductores.Modificar_Conductor;
import CRUD_Conductores.Visualizar_Conductor;
import CRUD_Escuelas.Eliminar_Escuelas;
import CRUD_Escuelas.Crear_Escuelas;
import CRUD_Escuelas.Modificar_Escuelas;
import CRUD_Escuelas.Visualizar_Escuelas;
import CRUD_Usuarios.Crear_Usuario;
import CRUD_Usuarios.Eliminar_Usuario;
import CRUD_Usuarios.Modificar_Usuario;
import CRUD_Usuarios.Visualizar_Usuario;
import CRUD_VehiculosEmpresa.Crear_VehiculoEmp;
import CRUD_VehiculosEmpresa.Eliminar_VehiculoEmp;
import CRUD_VehiculosEmpresa.Modificar_VehiculoEmp;
import CRUD_VehiculosEmpresa.Visualizar_VehiculoEmp;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);//Centrar
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        MenuUsuario_Crear = new javax.swing.JMenuItem();
        MenuUsuarioEliminar = new javax.swing.JMenuItem();
        MenuUsuarioModificar = new javax.swing.JMenuItem();
        MenuUsuarioVisualizar = new javax.swing.JMenuItem();
        MenuVehiculoEmpresaCrear = new javax.swing.JMenu();
        menuCrearVehiculoEmp = new javax.swing.JMenuItem();
        MenuVehiculoEmpresaEliminar = new javax.swing.JMenuItem();
        MenuVehiculoEmpresaModificar = new javax.swing.JMenuItem();
        MenuVehiculoEmpresaVisualizar = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        MenuEscuelaCrear = new javax.swing.JMenuItem();
        MenuEscuelaModificar = new javax.swing.JMenuItem();
        MenuEscuelaEliminar = new javax.swing.JMenuItem();
        MenuEscuelaVisualizar = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        MenuConductorCrear = new javax.swing.JMenuItem();
        MenuConductorEliminar = new javax.swing.JMenuItem();
        MenuConductorModificar = new javax.swing.JMenuItem();
        MenuConductorVisualizar = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPrincipal.setBackground(new java.awt.Color(27, 145, 201));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(195, 232, 236));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("BUSETAS RODRIGUEZ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel1)
                .addContainerGap(343, Short.MAX_VALUE))
        );

        jMenu3.setText("Usuarios");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        MenuUsuario_Crear.setText("Crear");
        MenuUsuario_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUsuario_CrearActionPerformed(evt);
            }
        });
        jMenu3.add(MenuUsuario_Crear);

        MenuUsuarioEliminar.setText("Eliminar");
        MenuUsuarioEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUsuarioEliminarActionPerformed(evt);
            }
        });
        jMenu3.add(MenuUsuarioEliminar);

        MenuUsuarioModificar.setText("Modificar");
        MenuUsuarioModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUsuarioModificarActionPerformed(evt);
            }
        });
        jMenu3.add(MenuUsuarioModificar);

        MenuUsuarioVisualizar.setText("Visualizar");
        MenuUsuarioVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUsuarioVisualizarActionPerformed(evt);
            }
        });
        jMenu3.add(MenuUsuarioVisualizar);

        jMenuBar1.add(jMenu3);

        MenuVehiculoEmpresaCrear.setText("Vehiculos de Empresa");
        MenuVehiculoEmpresaCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVehiculoEmpresaCrearActionPerformed(evt);
            }
        });

        menuCrearVehiculoEmp.setText("Crear");
        menuCrearVehiculoEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCrearVehiculoEmpActionPerformed(evt);
            }
        });
        MenuVehiculoEmpresaCrear.add(menuCrearVehiculoEmp);

        MenuVehiculoEmpresaEliminar.setText("Eliminar");
        MenuVehiculoEmpresaEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVehiculoEmpresaEliminarActionPerformed(evt);
            }
        });
        MenuVehiculoEmpresaCrear.add(MenuVehiculoEmpresaEliminar);

        MenuVehiculoEmpresaModificar.setText("Modificar");
        MenuVehiculoEmpresaModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVehiculoEmpresaModificarActionPerformed(evt);
            }
        });
        MenuVehiculoEmpresaCrear.add(MenuVehiculoEmpresaModificar);

        MenuVehiculoEmpresaVisualizar.setText("Visualizar");
        MenuVehiculoEmpresaVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVehiculoEmpresaVisualizarActionPerformed(evt);
            }
        });
        MenuVehiculoEmpresaCrear.add(MenuVehiculoEmpresaVisualizar);

        jMenuBar1.add(MenuVehiculoEmpresaCrear);

        jMenu5.setText("Escuelas");

        MenuEscuelaCrear.setText("Crear");
        MenuEscuelaCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEscuelaCrearActionPerformed(evt);
            }
        });
        jMenu5.add(MenuEscuelaCrear);

        MenuEscuelaModificar.setText("Modificar");
        MenuEscuelaModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEscuelaModificarActionPerformed(evt);
            }
        });
        jMenu5.add(MenuEscuelaModificar);

        MenuEscuelaEliminar.setText("Eliminar");
        MenuEscuelaEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEscuelaEliminarActionPerformed(evt);
            }
        });
        jMenu5.add(MenuEscuelaEliminar);

        MenuEscuelaVisualizar.setText("Visualizar");
        MenuEscuelaVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEscuelaVisualizarActionPerformed(evt);
            }
        });
        jMenu5.add(MenuEscuelaVisualizar);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Conductores");

        MenuConductorCrear.setText("Crear");
        MenuConductorCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConductorCrearActionPerformed(evt);
            }
        });
        jMenu6.add(MenuConductorCrear);

        MenuConductorEliminar.setText("Eliminar");
        MenuConductorEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConductorEliminarActionPerformed(evt);
            }
        });
        jMenu6.add(MenuConductorEliminar);

        MenuConductorModificar.setText("Modificar");
        MenuConductorModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConductorModificarActionPerformed(evt);
            }
        });
        jMenu6.add(MenuConductorModificar);

        MenuConductorVisualizar.setText("Visualizar");
        MenuConductorVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConductorVisualizarActionPerformed(evt);
            }
        });
        jMenu6.add(MenuConductorVisualizar);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Horarios");
        jMenuBar1.add(jMenu7);

        jMenu8.setText("Fechas de Recogida");
        jMenuBar1.add(jMenu8);

        jMenu9.setText("Rutas");
        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuUsuario_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUsuario_CrearActionPerformed
        Crear_Usuario Crear_Usuario = new Crear_Usuario(this, true);
        Crear_Usuario.setVisible(true);
    }//GEN-LAST:event_MenuUsuario_CrearActionPerformed

    private void MenuUsuarioEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUsuarioEliminarActionPerformed
        Eliminar_Usuario Eliminar_Usuario = new Eliminar_Usuario(this, true);
        Eliminar_Usuario.setVisible(true);
    }//GEN-LAST:event_MenuUsuarioEliminarActionPerformed

    private void MenuVehiculoEmpresaModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVehiculoEmpresaModificarActionPerformed
        Modificar_VehiculoEmp Modificar_VehiculoEmp = new Modificar_VehiculoEmp(this, true);
        Modificar_VehiculoEmp.setVisible(true);
    }//GEN-LAST:event_MenuVehiculoEmpresaModificarActionPerformed

    private void MenuUsuarioModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUsuarioModificarActionPerformed
        Modificar_Usuario Modificar_Usuario = new Modificar_Usuario(this, true);
        Modificar_Usuario.setVisible(true);
    }//GEN-LAST:event_MenuUsuarioModificarActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void MenuUsuarioVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUsuarioVisualizarActionPerformed
        Visualizar_Usuario Visualizar_Usuario = new Visualizar_Usuario(this, true);
        Visualizar_Usuario.setVisible(true);
    }//GEN-LAST:event_MenuUsuarioVisualizarActionPerformed

    private void MenuVehiculoEmpresaCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVehiculoEmpresaCrearActionPerformed
       /* Crear_VehiculoEmp Crear_VehiculoEmp = new Crear_VehiculoEmp(this, true);
        Crear_VehiculoEmp.setVisible(true);*/
    }//GEN-LAST:event_MenuVehiculoEmpresaCrearActionPerformed

    private void MenuVehiculoEmpresaEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVehiculoEmpresaEliminarActionPerformed
        Eliminar_VehiculoEmp Eliminar_VehiculoEmp = new Eliminar_VehiculoEmp(this, true);
        Eliminar_VehiculoEmp.setVisible(true);
    }//GEN-LAST:event_MenuVehiculoEmpresaEliminarActionPerformed

    private void MenuVehiculoEmpresaVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVehiculoEmpresaVisualizarActionPerformed
        Visualizar_VehiculoEmp Visualizar_VehiculoEmp = new Visualizar_VehiculoEmp(this, true);
        Visualizar_VehiculoEmp.setVisible(true);
    }//GEN-LAST:event_MenuVehiculoEmpresaVisualizarActionPerformed

    private void MenuEscuelaCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEscuelaCrearActionPerformed
        Crear_Escuelas Crear_Escuelas = new Crear_Escuelas(this, true);
        Crear_Escuelas.setVisible(true);
    }//GEN-LAST:event_MenuEscuelaCrearActionPerformed

    private void MenuEscuelaModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEscuelaModificarActionPerformed
        Modificar_Escuelas Modificar_Escuelas = new Modificar_Escuelas(this, true);
        Modificar_Escuelas.setVisible(true);
    }//GEN-LAST:event_MenuEscuelaModificarActionPerformed

    private void MenuEscuelaEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEscuelaEliminarActionPerformed
        Eliminar_Escuelas Eliminar_Escuelas = new Eliminar_Escuelas(this, true);
        Eliminar_Escuelas.setVisible(true);
    }//GEN-LAST:event_MenuEscuelaEliminarActionPerformed

    private void MenuEscuelaVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEscuelaVisualizarActionPerformed
        Visualizar_Escuelas Visualizar_Escuelas = new Visualizar_Escuelas(this, true);
        Visualizar_Escuelas.setVisible(true);
    }//GEN-LAST:event_MenuEscuelaVisualizarActionPerformed

    private void menuCrearVehiculoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCrearVehiculoEmpActionPerformed
        Crear_VehiculoEmp Crear_VehiculoEmp = new Crear_VehiculoEmp(this, true);
        Crear_VehiculoEmp.setVisible(true);
    }//GEN-LAST:event_menuCrearVehiculoEmpActionPerformed

    private void MenuConductorCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConductorCrearActionPerformed
        Crear_Conductor Crear_Conductor = new Crear_Conductor(this, true);
        Crear_Conductor.setVisible(true);     
    }//GEN-LAST:event_MenuConductorCrearActionPerformed

    private void MenuConductorEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConductorEliminarActionPerformed
        Eliminar_Conductor Eliminar_Conductor = new Eliminar_Conductor(this, true);
        Eliminar_Conductor.setVisible(true); 
    }//GEN-LAST:event_MenuConductorEliminarActionPerformed

    private void MenuConductorModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConductorModificarActionPerformed
        Modificar_Conductor Modificar_Conductor = new Modificar_Conductor(this, true);
        Modificar_Conductor.setVisible(true); 
    }//GEN-LAST:event_MenuConductorModificarActionPerformed

    private void MenuConductorVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConductorVisualizarActionPerformed
        Visualizar_Conductor Visualizar_Conductor = new Visualizar_Conductor(this, true);
        Visualizar_Conductor.setVisible(true); 
    }//GEN-LAST:event_MenuConductorVisualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Menu().setVisible(true);
                
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuConductorCrear;
    private javax.swing.JMenuItem MenuConductorEliminar;
    private javax.swing.JMenuItem MenuConductorModificar;
    private javax.swing.JMenuItem MenuConductorVisualizar;
    private javax.swing.JMenuItem MenuEscuelaCrear;
    private javax.swing.JMenuItem MenuEscuelaEliminar;
    private javax.swing.JMenuItem MenuEscuelaModificar;
    private javax.swing.JMenuItem MenuEscuelaVisualizar;
    private javax.swing.JMenuItem MenuUsuarioEliminar;
    private javax.swing.JMenuItem MenuUsuarioModificar;
    private javax.swing.JMenuItem MenuUsuarioVisualizar;
    private javax.swing.JMenuItem MenuUsuario_Crear;
    private javax.swing.JMenu MenuVehiculoEmpresaCrear;
    private javax.swing.JMenuItem MenuVehiculoEmpresaEliminar;
    private javax.swing.JMenuItem MenuVehiculoEmpresaModificar;
    private javax.swing.JMenuItem MenuVehiculoEmpresaVisualizar;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem menuCrearVehiculoEmp;
    // End of variables declaration//GEN-END:variables
}
