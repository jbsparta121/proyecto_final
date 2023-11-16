package com.mycompany.proyecto_final;

import com.mycompany.proyecto_final.controlador.CntNumerosApartamentos;
import com.mycompany.proyecto_final.vista.FrmNumeroApartamentos;

public class Proyecto_Final {

    public static void main(String[] args) {
        FrmNumeroApartamentos frmNumeroApartamentos = new FrmNumeroApartamentos();
        CntNumerosApartamentos cntNumerosApartamentos = new CntNumerosApartamentos(frmNumeroApartamentos);
        frmNumeroApartamentos.setVisible(true);
    }
}
