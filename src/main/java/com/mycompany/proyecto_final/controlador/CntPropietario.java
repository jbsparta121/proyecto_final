package com.mycompany.proyecto_final.controlador;

import com.mycompany.proyecto_final.modelo.Apartamento;
import com.mycompany.proyecto_final.modelo.ApartamentoDAO;
import com.mycompany.proyecto_final.modelo.Persona;
import com.mycompany.proyecto_final.modelo.PersonaDAO;
import com.mycompany.proyecto_final.modelo.PropietarioApartamento;
import com.mycompany.proyecto_final.modelo.PropietarioApartamentoDAO;
import com.mycompany.proyecto_final.vista.FrmPropietario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.table.DefaultTableModel;

public class CntPropietario extends InternalFrameAdapter implements ActionListener {

    private FrmPropietario frmPropietario;
    private Apartamento apartamento;
    private Persona persona;
    private PersonaDAO personaDAO;
    private ApartamentoDAO apartamentoDAO;
    private PropietarioApartamento propietarioApartamento;
    private PropietarioApartamentoDAO propietarioApartamentoDAO;
    private int fila;
    private int filaComboBox;
    private List<Apartamento> listadoApartamentos;
    private Set<Apartamento> listadoApartamentosCambiarEstadoAsignado;
    private Set<PropietarioApartamento> listaPropietarioApartamento;
    private int contadorConsultar = 0;

    public CntPropietario(FrmPropietario frmPropietario,
            PersonaDAO personaDAO, PropietarioApartamentoDAO propietarioApartamentoDAO, ApartamentoDAO apartamentoDAO) {
        this.frmPropietario = frmPropietario;
        this.personaDAO = personaDAO;
        this.propietarioApartamentoDAO = propietarioApartamentoDAO;
        this.apartamentoDAO = apartamentoDAO;
        registrarControladores();
        cargarApartamento();
    }

    private void registrarControladores() {
        frmPropietario.getBtnGrabar().addActionListener(this);
        frmPropietario.getBtnAdicionar().addActionListener(this);
        frmPropietario.getBtnBorrar().addActionListener(this);
        frmPropietario.getCbxApartamentos().addActionListener(this);
        frmPropietario.getBtnConsultar().addActionListener(this);
    }

    private void cargarApartamento() {
        frmPropietario.getCbxApartamentos().removeAllItems();
        listadoApartamentos = apartamentoDAO.listarApartamentosNoAsignado();
        Integer matricula, parqueadero;

        for (Apartamento apartamento : listadoApartamentos) {
            Integer numeroUnico = apartamento.getNumeroUnico();
            Integer numeroApartamento = apartamento.getNumeroApartamento();
            Integer numeroBloque = apartamento.getNumeroBloque();
            matricula = (apartamento.getMatricula() == null ? null : apartamento.getMatricula());
            parqueadero = (apartamento.getParqueadero() == null ? null : apartamento.getParqueadero());
            String relleno = "Numero unico " + numeroUnico.toString() + " Apartamento "
                    + numeroApartamento.toString() + " Bloque " + numeroBloque.toString()
                    + " Matricula " + matricula + " Parqueadero " + parqueadero;
            frmPropietario.getCbxApartamentos().addItem(relleno);
        }
    }

    public void obtenerPropietario() {
        Integer id = Integer.valueOf(frmPropietario.getTxtId().getText());
        String nombre1 = frmPropietario.getTxtNombre1().getText();
        String nombre2 = frmPropietario.getTxtNombre2().getText();
        String apellido1 = frmPropietario.getTxtApellido1().getText();
        String apellido2 = frmPropietario.getTxtApellido2().getText();
        String emailPersona = frmPropietario.getTxtEmail().getText();
        String celular = frmPropietario.getTxtCelular().getText();
        String tipo = "Propietario";
        persona = new Persona(id, apellido1, apellido2, nombre1, nombre2, celular, emailPersona, tipo);
        crearListadoPropietarioApartamento();
        persona.setListadoPropietarioApartamento(listaPropietarioApartamento);
    }

    public void crearListadoPropietarioApartamento() {
        Apartamento apartamentoAsignado = null;
        DefaultTableModel dtmPropietario = frmPropietario.getDtmTablaPropietarioApartamento();
        listaPropietarioApartamento = new HashSet();
        listadoApartamentosCambiarEstadoAsignado = new HashSet();
        int filas = dtmPropietario.getRowCount();
        int columnas = dtmPropietario.getColumnCount();
        Integer numeroUnico, numeroApartamento, numeroBloque, matricula, parqueadero;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                numeroUnico = Integer.valueOf(dtmPropietario.getValueAt(i, 0).toString());
                numeroApartamento = Integer.valueOf(dtmPropietario.getValueAt(i, 1).toString());
                numeroBloque = Integer.valueOf(dtmPropietario.getValueAt(i, 2).toString());
                matricula = (dtmPropietario.getValueAt(i, 4) == null ? null : Integer.valueOf(dtmPropietario.getValueAt(i, 4).toString()));
                parqueadero = (dtmPropietario.getValueAt(i, 5) == null ? null : Integer.valueOf(dtmPropietario.getValueAt(i, 5).toString()));
                apartamento = new Apartamento(numeroUnico);
                apartamentoAsignado = new Apartamento(numeroUnico, numeroApartamento, numeroBloque, matricula, parqueadero, "", "S");
                propietarioApartamento = new PropietarioApartamento(persona, apartamento);
            }
            listaPropietarioApartamento.add(propietarioApartamento);
            listadoApartamentosCambiarEstadoAsignado.add(apartamentoAsignado);
        }
    }

    private void actualizaEstadoApartamento() {
        for (Apartamento apartamento : listadoApartamentosCambiarEstadoAsignado) {
            apartamento.setNumeroApartamento(apartamento.getNumeroApartamento());
            apartamento.setNumeroBloque(apartamento.getNumeroBloque());
            apartamento.setAsignado("S");
            apartamentoDAO.actualizar(apartamento);
        }
    }

    private void grabarPersona() {
        if (contadorConsultar == 0) {
            obtenerPropietario();
            if (personaDAO.grabar(persona)) {
                JOptionPane.showMessageDialog(null, "Persona almacenado");
                actualizaEstadoApartamento();
            } else {
                JOptionPane.showMessageDialog(null, "Persona no almacenado");
            }
        } else {
            crearListadoPropietarioApartamento();
            //propietarioApartamento = new PropietarioApartamento(persona, apartamento);
            if (propietarioApartamentoDAO.grabar(propietarioApartamento)) {
                JOptionPane.showMessageDialog(null, "Apartamento almacenado");
                actualizaEstadoApartamento();
            } else {
                JOptionPane.showMessageDialog(null, "Apartamento no almacenado");
            }
        }
    }

    private void consultarPropietario() {
        Integer idPropietario = Integer.valueOf(frmPropietario.getTxtId().getText());
        persona = personaDAO.consultar(idPropietario);
        if (persona != null) {
            if (persona.getTipo().equals("Propietario")) {
                frmPropietario.getTxtNombre1().setText(persona.getNombre1());
                frmPropietario.getTxtNombre2().setText(persona.getNombre2());
                frmPropietario.getTxtApellido1().setText(persona.getApellido1());
                frmPropietario.getTxtApellido2().setText(persona.getApellido2());
                frmPropietario.getTxtEmail().setText(persona.getEmailPersona());
                frmPropietario.getTxtCelular().setText(persona.getCelularPersona());
                cargarApartamentosAsignados();
            } else {
                JOptionPane.showMessageDialog(null, "La persona esta registrada como residente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Propietario no existe");
        }
    }

    private void cargarTablaApartamento() {
        Object itemPropietario[] = new Object[6];
        apartamento = listadoApartamentos.get(filaComboBox);
        itemPropietario[0] = apartamento.getNumeroUnico();
        itemPropietario[1] = apartamento.getNumeroApartamento();
        itemPropietario[2] = apartamento.getNumeroBloque();
        itemPropietario[3] = null;
        itemPropietario[4] = apartamento.getMatricula();
        itemPropietario[5] = apartamento.getParqueadero();
        frmPropietario.getDtmTablaPropietarioApartamento().addRow(itemPropietario);
    }

    private void cargarApartamentosAsignados() {
        Object itemTablaPropietarioApartamento[] = new Object[6];
        listaPropietarioApartamento = new HashSet<PropietarioApartamento>(propietarioApartamentoDAO.listarPropietarioApartamento(Integer.valueOf(frmPropietario.getTxtId().getText())));
        for (PropietarioApartamento propietarioApartamento : listaPropietarioApartamento) {
            itemTablaPropietarioApartamento[0] = propietarioApartamento.getApartamento().getNumeroUnico().toString();
            itemTablaPropietarioApartamento[1] = propietarioApartamento.getApartamento().getNumeroApartamento().toString();
            itemTablaPropietarioApartamento[2] = propietarioApartamento.getApartamento().getNumeroBloque().toString();
            itemTablaPropietarioApartamento[3] = propietarioApartamento.getFechaCompra();
            /*if (propietarioApartamento.getApartamento().getMatricula() == null) {
                itemTablaPropietarioApartamento[4] = null;
            } else {
                itemTablaPropietarioApartamento[4] = propietarioApartamento.getApartamento().getMatricula().toString();
            }
            if (propietarioApartamento.getApartamento().getParqueadero() == null) {
                itemTablaPropietarioApartamento[5] = null;
            } else {
                itemTablaPropietarioApartamento[5] = propietarioApartamento.getApartamento().getParqueadero().toString();
            }*/
            itemTablaPropietarioApartamento[4] = (propietarioApartamento.getApartamento().getMatricula() == null ? null : propietarioApartamento.getApartamento().getMatricula().toString());
            itemTablaPropietarioApartamento[5] = (propietarioApartamento.getApartamento().getParqueadero() == null ? null : propietarioApartamento.getApartamento().getParqueadero().toString());
            frmPropietario.getDtmTablaPropietarioApartamento().addRow(itemTablaPropietarioApartamento);
        }
    }

    private void borrarFila() {
        fila = frmPropietario.getTblApartamentosPropietario().getSelectedRow();
        frmPropietario.getDtmTablaPropietarioApartamento().removeRow(fila);
    }

    public void limpiarTabla() {
        int a = frmPropietario.getDtmTablaPropietarioApartamento().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            frmPropietario.getDtmTablaPropietarioApartamento().removeRow(i);
        }
    }

    public void limpiar() {
        frmPropietario.getTxtId().setText("");
        frmPropietario.getTxtNombre1().setText("");
        frmPropietario.getTxtNombre2().setText("");
        frmPropietario.getTxtApellido1().setText("");
        frmPropietario.getTxtApellido2().setText("");
        frmPropietario.getTxtEmail().setText("");
        frmPropietario.getTxtCelular().setText("");
        limpiarTabla();
        cargarApartamento();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPropietario.getBtnGrabar()) {
            grabarPersona();
            limpiar();
            contadorConsultar = 0;
        } else if (e.getSource() == frmPropietario.getBtnAdicionar()) {
            cargarTablaApartamento();
        } else if (e.getSource() == frmPropietario.getBtnBorrar()) {
            borrarFila();
        } else if (e.getSource() == frmPropietario.getCbxApartamentos()) {
            filaComboBox = frmPropietario.getCbxApartamentos().getSelectedIndex();
        } else if (e.getSource() == frmPropietario.getBtnConsultar()) {
            consultarPropietario();
            contadorConsultar++;
        }
    }
}
