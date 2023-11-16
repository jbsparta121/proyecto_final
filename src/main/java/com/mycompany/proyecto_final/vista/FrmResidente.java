/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.proyecto_final.vista;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.edisoncor.gui.button.ButtonAction;
import org.edisoncor.gui.textField.TextField;

/**
 *
 * @author Master
 */
public class FrmResidente extends javax.swing.JInternalFrame {

    private DefaultComboBoxModel dtmModelComboBox;
    private DefaultTableModel dtmTablaResidenteApartamento;
    
    public FrmResidente() {
        initComponents();
        configurarTablaApartamentos();
    }
        
    private void configurarTablaApartamentos() {
        dtmTablaResidenteApartamento = new DefaultTableModel(
                null,
                new String[]{"No. Unico", "No. Apartamento",
                    "Bloque", "Fecha Inicio" , "Fecha Fin"}
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tblResidenteApartamentos.setModel(dtmTablaResidenteApartamento);
    }

    public DefaultComboBoxModel getDtmModelComboBox() {
        return dtmModelComboBox;
    }

    public void setDtmModelComboBox(DefaultComboBoxModel dtmModelComboBox) {
        this.dtmModelComboBox = dtmModelComboBox;
    }

    public DefaultTableModel getDtmTablaResidenteApartamento() {
        return dtmTablaResidenteApartamento;
    }

    public void setDtmTablaResidenteApartamento(DefaultTableModel dtmTablaResidenteApartamento) {
        this.dtmTablaResidenteApartamento = dtmTablaResidenteApartamento;
    }

    public ButtonAction getBtnAdicionarResidente() {
        return btnAdicionarResidente;
    }

    public void setBtnAdicionarResidente(ButtonAction btnAdicionarResidente) {
        this.btnAdicionarResidente = btnAdicionarResidente;
    }

    public ButtonAction getBtnBorrarResidente() {
        return btnBorrarResidente;
    }

    public void setBtnBorrarResidente(ButtonAction btnBorrarResidente) {
        this.btnBorrarResidente = btnBorrarResidente;
    }

    public ButtonAction getBtnGrabarResidente() {
        return btnGrabarResidente;
    }

    public void setBtnGrabarResidente(ButtonAction btnGrabarResidente) {
        this.btnGrabarResidente = btnGrabarResidente;
    }

    public JComboBox<String> getCbxApartamentosResidente() {
        return cbxApartamentosResidente;
    }

    public void setCbxApartamentosResidente(JComboBox<String> cbxApartamentosResidente) {
        this.cbxApartamentosResidente = cbxApartamentosResidente;
    }

    public JTable getTblResidenteApartamentos() {
        return tblResidenteApartamentos;
    }

    public void setTblResidenteApartamentos(JTable tblResidenteApartamentos) {
        this.tblResidenteApartamentos = tblResidenteApartamentos;
    }

    public TextField getTxtApellido1Residente() {
        return txtApellido1Residente;
    }

    public void setTxtApellido1Residente(TextField txtApellido1Residente) {
        this.txtApellido1Residente = txtApellido1Residente;
    }

    public TextField getTxtApellido2Residente() {
        return txtApellido2Residente;
    }

    public void setTxtApellido2Residente(TextField txtApellido2Residente) {
        this.txtApellido2Residente = txtApellido2Residente;
    }

    public TextField getTxtCelularResidente() {
        return txtCelularResidente;
    }

    public void setTxtCelularResidente(TextField txtCelularResidente) {
        this.txtCelularResidente = txtCelularResidente;
    }

    public TextField getTxtEmailResidente() {
        return txtEmailResidente;
    }

    public void setTxtEmailResidente(TextField txtEmailResidente) {
        this.txtEmailResidente = txtEmailResidente;
    }

    public TextField getTxtIdResidente() {
        return txtIdResidente;
    }

    public void setTxtIdResidente(TextField txtIdResidente) {
        this.txtIdResidente = txtIdResidente;
    }

    public TextField getTxtNombre1Residente() {
        return txtNombre1Residente;
    }

    public void setTxtNombre1Residente(TextField txtNombre1Residente) {
        this.txtNombre1Residente = txtNombre1Residente;
    }

    public TextField getTxtNombre2Residente() {
        return txtNombre2Residente;
    }

    public void setTxtNombre2Residente(TextField txtNombre2Residente) {
        this.txtNombre2Residente = txtNombre2Residente;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdResidente = new org.edisoncor.gui.textField.TextField();
        txtNombre1Residente = new org.edisoncor.gui.textField.TextField();
        txtApellido1Residente = new org.edisoncor.gui.textField.TextField();
        txtEmailResidente = new org.edisoncor.gui.textField.TextField();
        txtNombre2Residente = new org.edisoncor.gui.textField.TextField();
        txtApellido2Residente = new org.edisoncor.gui.textField.TextField();
        txtCelularResidente = new org.edisoncor.gui.textField.TextField();
        panelImageReflect1 = new org.edisoncor.gui.panel.PanelImageReflect();
        jLabel6 = new javax.swing.JLabel();
        cbxApartamentosResidente = new javax.swing.JComboBox<>();
        btnAdicionarResidente = new org.edisoncor.gui.button.ButtonAction();
        btnBorrarResidente = new org.edisoncor.gui.button.ButtonAction();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResidenteApartamentos = new javax.swing.JTable();
        btnGrabarResidente = new org.edisoncor.gui.button.ButtonAction();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Residentes");
        setPreferredSize(new java.awt.Dimension(912, 557));

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo-azul-clasico-abstracto_23-2148421773.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Identificacion");

        jLabel2.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Primer Nombre");

        jLabel3.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Primer Apellido");

        jLabel8.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("E-mail");

        jLabel4.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Segundo Nombre ");

        jLabel5.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Segundo Apellido ");

        jLabel7.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Celular");

        panelImageReflect1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apartamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apartamento");
        panelImageReflect1.add(jLabel6);
        jLabel6.setBounds(20, 30, 124, 20);

        panelImageReflect1.add(cbxApartamentosResidente);
        cbxApartamentosResidente.setBounds(120, 30, 550, 22);

        btnAdicionarResidente.setText("Adicionar");
        panelImageReflect1.add(btnAdicionarResidente);
        btnAdicionarResidente.setBounds(680, 20, 80, 35);

        btnBorrarResidente.setText("Borrar");
        panelImageReflect1.add(btnBorrarResidente);
        btnBorrarResidente.setBounds(770, 20, 70, 35);

        tblResidenteApartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.Unico", "No.Apartamento", "Bloque", "FechaCompra", "FechaFin"
            }
        ));
        jScrollPane1.setViewportView(tblResidenteApartamentos);

        panelImageReflect1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 840, 180);

        btnGrabarResidente.setText("Grabar");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre1Residente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellido1Residente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmailResidente, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtIdResidente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(83, 83, 83)
                        .addComponent(txtCelularResidente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellido2Residente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre2Residente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(panelImageReflect1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(btnGrabarResidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(379, 379, 379))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdResidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre1Residente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre2Residente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellido1Residente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido2Residente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtEmailResidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelularResidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelImageReflect1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGrabarResidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnAdicionarResidente;
    private org.edisoncor.gui.button.ButtonAction btnBorrarResidente;
    private org.edisoncor.gui.button.ButtonAction btnGrabarResidente;
    private javax.swing.JComboBox<String> cbxApartamentosResidente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelImageReflect panelImageReflect1;
    private javax.swing.JTable tblResidenteApartamentos;
    private org.edisoncor.gui.textField.TextField txtApellido1Residente;
    private org.edisoncor.gui.textField.TextField txtApellido2Residente;
    private org.edisoncor.gui.textField.TextField txtCelularResidente;
    private org.edisoncor.gui.textField.TextField txtEmailResidente;
    private org.edisoncor.gui.textField.TextField txtIdResidente;
    private org.edisoncor.gui.textField.TextField txtNombre1Residente;
    private org.edisoncor.gui.textField.TextField txtNombre2Residente;
    // End of variables declaration//GEN-END:variables
}
