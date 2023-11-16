package com.mycompany.proyecto_final.modelo;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApartamentoDAO {

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

    public boolean grabar(Apartamento apartamento) {
        boolean ok = false;

        try {
            iniciaOperacion();
            sesion.save(apartamento);
            trns.commit();
            ok = true;
        } catch (HibernateException e) {
            manejaException(e);
        }
        return ok;
    }

    public boolean actualizar(Apartamento apartamento) {
        boolean ok = false;

        try {
            iniciaOperacion();
            sesion.update(apartamento);
            trns.commit();
            ok = true;
        } catch (HibernateException e) {
            manejaException(e);
            ok = false;
        }
        return ok;
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

    public List<Apartamento> listarApartamentosNoAsignado() {
        List<Apartamento> listarApartamentosNoAsignado = null;

        try {
            iniciaOperacion();
            listarApartamentosNoAsignado = sesion.createQuery("from Apartamento where asignado ='N' order by numeroUnico").list();
        } catch (HibernateException e) {
            manejaException(e);
        } finally {
            return listarApartamentosNoAsignado;
        }
    }
}
