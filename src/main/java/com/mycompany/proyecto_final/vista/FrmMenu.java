/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto_final.vista;

import com.mycompany.proyecto_final.controlador.CntApartamentos;
import com.mycompany.proyecto_final.controlador.CntPropietario;
import com.mycompany.proyecto_final.controlador.CntResidente;
import com.mycompany.proyecto_final.modelo.ApartamentoDAO;
import com.mycompany.proyecto_final.modelo.PersonaDAO;
import com.mycompany.proyecto_final.modelo.PropietarioApartamentoDAO;
import com.mycompany.proyecto_final.modelo.ResidenteApartamentoDAO;

/**
 *
 * @author Master
 */
public class FrmMenu extends javax.swing.JFrame {

    public FrmMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );

        jMenu1.setText("Propietario");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Apartamento");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Residentes");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        //escritorio.removeAll();
        escritorio.updateUI();
        FrmApartamentos frmApartamentos = new FrmApartamentos();
        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
        CntApartamentos cntApartamentos = new CntApartamentos(frmApartamentos, apartamentoDAO);
        escritorio.add(frmApartamentos);
        frmApartamentos.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        //escritorio.removeAll();
        escritorio.updateUI();
        FrmPropietario frmPropietario = new FrmPropietario();
        PersonaDAO personaDAO = new PersonaDAO();
        ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
        PropietarioApartamentoDAO propietarioApartamentoDAO = new PropietarioApartamentoDAO();
        CntPropietario cntApartamentos = new CntPropietario(frmPropietario, personaDAO, propietarioApartamentoDAO, apartamentoDAO);
        escritorio.add(frmPropietario);
        frmPropietario.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        //escritorio.removeAll();
        escritorio.updateUI();
        FrmResidente frmResidente = new FrmResidente();
        ResidenteApartamentoDAO residenteApartamentoDAO = new ResidenteApartamentoDAO();
        CntResidente cntResidente = new CntResidente(frmResidente, residenteApartamentoDAO);
        escritorio.add(frmResidente);
        frmResidente.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
