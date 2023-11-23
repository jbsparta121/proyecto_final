package com.mycompany.proyecto_final.controlador;

import com.mycompany.proyecto_final.modelo.Apartamento;
import com.mycompany.proyecto_final.modelo.ApartamentoDAO;
import com.mycompany.proyecto_final.vista.BarraProgreso;
import com.mycompany.proyecto_final.vista.FrmApartamentos;
import com.mycompany.proyecto_final.vista.FrmNumeroApartamentos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CntNumerosApartamentos implements ActionListener {

    private FrmNumeroApartamentos frmNumeroApartamentos;
    private FrmApartamentos frmApartamentos;
    private Apartamento apartamento;
    private ApartamentoDAO apartamentoDAO;

    public CntNumerosApartamentos(FrmNumeroApartamentos frmNumeroApartamentos) {
        this.frmNumeroApartamentos = frmNumeroApartamentos;
        registrarControladores();
    }

    private void registrarControladores() {
        frmNumeroApartamentos.getBtnInsertar().addActionListener(this);
    }

    public void crearListadoApartamentos() {
        try {
            ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
            Integer numeroBloques = Integer.valueOf(frmNumeroApartamentos.getTxtBloques().getText());
            Integer numeroPisos = Integer.valueOf(frmNumeroApartamentos.getTxtPisos().getText());
            Integer numeroApartamentosXPiso = Integer.valueOf(frmNumeroApartamentos.getTxtApartamentos().getText());

            Integer numeroUnico = 1;
            Integer numeroBloque = 0;
            Integer numeroApartamento = 100;
            Integer matricula = null;
            Integer parqueadero = null;

            for (int i = 0; i < numeroBloques; i++) {
                numeroBloque++;
                for (int j = 0; j < numeroPisos; j++) {
                    for (int k = 0; k < numeroApartamentosXPiso; k++) {
                        numeroApartamento++;
                        if (!apartamentoDAO.grabar(new Apartamento(numeroUnico, numeroApartamento, numeroBloque, matricula, parqueadero, "N", "S"))) {
                            JOptionPane.showMessageDialog(null, "No almacenado");
                        }
                    }
                    numeroApartamento = numeroApartamento - numeroApartamentosXPiso + 100;
                }
                numeroApartamento = 100;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error Ingrese numeros");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmNumeroApartamentos.getBtnInsertar()) {
            crearListadoApartamentos();
            BarraProgreso barraProgreso = new BarraProgreso();
            barraProgreso.setVisible(true);
            barraProgreso.iniciarProceso();    
        }
    }
}
