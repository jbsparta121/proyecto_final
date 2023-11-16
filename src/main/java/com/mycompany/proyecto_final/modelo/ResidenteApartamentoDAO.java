
package com.mycompany.proyecto_final.modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ResidenteApartamentoDAO {
    
    private Session sesion;
    private Transaction trns;

    private void iniciaOperacion() {
        sesion = HibernateUtil.getSessionFactory().openSession();
        trns = sesion.beginTransaction();
    }

    private void manejaException(HibernateException e) {
        trns.rollback();
        throw new HibernateException("Error en la capa de datos." + e);
    }

    public boolean grabar(ResidenteApartamento residenteApartamento) {
        boolean ok = false;

        try {
            iniciaOperacion();
            sesion.save(residenteApartamento);
            trns.commit();
            ok = true;
        } catch (HibernateException e) {
            manejaException(e);
        }
        return ok;
    }
    
    public List<ResidenteApartamento> listarResidenteApartamento(Integer idResidente) {
        List<ResidenteApartamento> listadoResidenteApartamento = null;
        
        try {
            iniciaOperacion();
            listadoResidenteApartamento = sesion.createQuery("from ResidenteApartamento " + 
                    "where residente = " + idResidente).list();
        } catch (HibernateException e) {
            manejaException(e);
        }
        return listadoResidenteApartamento;
    }
}
