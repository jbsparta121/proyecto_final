/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto_final.vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author David
 */
public class BarraProgreso extends javax.swing.JFrame {

    /**
     * Creates new form BarraProgreso
     */
    public BarraProgreso() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void iniciarProceso() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    barraProgreso.setValue(i);
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            protected void done() {
                dispose(); 
            }
        };
        worker.execute();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraProgreso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        barraProgreso.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    // End of variables declaration//GEN-END:variables
}
