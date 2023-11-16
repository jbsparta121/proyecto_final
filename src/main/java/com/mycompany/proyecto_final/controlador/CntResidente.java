
package com.mycompany.proyecto_final.controlador;

import com.mycompany.proyecto_final.modelo.ResidenteApartamentoDAO;
import com.mycompany.proyecto_final.vista.FrmResidente;
import java.util.HashSet;

public class CntResidente {
    
    private FrmResidente frmResidente;
    private ResidenteApartamentoDAO residenteApartamentoDAO;
    
    public CntResidente(FrmResidente frmResidente, ResidenteApartamentoDAO residenteApartamentoDAO) {
        this.frmResidente = frmResidente;
        this.residenteApartamentoDAO = residenteApartamentoDAO;
    }
}
