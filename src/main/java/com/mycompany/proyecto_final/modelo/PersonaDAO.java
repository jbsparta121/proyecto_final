
package com.mycompany.proyecto_final.modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonaDAO {
    
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

    public boolean grabar(Persona persona) {
        boolean ok = false;

        try {
            iniciaOperacion();
            sesion.save(persona);
            trns.commit();
            ok = true;
        } catch (HibernateException e) {
            manejaException(e);
        }
        return ok;
    }
    
    public Persona consultar(int id) {
        Persona persona = null;
        try {
            iniciaOperacion();
            persona = (Persona) sesion.get(Persona.class, id);
        } catch (HibernateException e) {
            manejaException(e);
        } finally {
            sesion.close();
        }
        return persona;
    }
    
    public List<Apartamento> listarApartamentos() {
        List<Apartamento> listadoApartamentos = null;

        try {
            iniciaOperacion();
            listadoApartamentos = sesion.createQuery("from Apartamento order by numeroUnico").list();
        } catch (HibernateException e) {
            manejaException(e);
        } finally {
            return listadoApartamentos;
        }
    }
}
