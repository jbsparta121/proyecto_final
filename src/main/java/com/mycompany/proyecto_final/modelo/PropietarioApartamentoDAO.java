
package com.mycompany.proyecto_final.modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PropietarioApartamentoDAO {
    
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

    public boolean grabar(PropietarioApartamento propietarioApartamento) {
        boolean ok = false;

        try {
            iniciaOperacion();
            sesion.save(propietarioApartamento);
            trns.commit();
            ok = true;
        } catch (HibernateException e) {
            manejaException(e);
        }
        return ok;
    }
    
    public List<PropietarioApartamento> listarPropietarioApartamento(Integer idPropietario) {
        List<PropietarioApartamento> listadoPropietarioApartamento = null;
        
        try {
            iniciaOperacion();
            listadoPropietarioApartamento = sesion.createQuery("from PropietarioApartamento " + 
                    "where propietario = " + idPropietario).list();
        } catch (HibernateException e) {
            manejaException(e);
        }
        return listadoPropietarioApartamento;
    }
}
