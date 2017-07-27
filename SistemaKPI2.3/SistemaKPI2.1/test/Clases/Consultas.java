/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import Constructores.Registro;
import Interfaz.PrincipalOne;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zgm_e
 */
public class Consultas {

    public ArrayList tipoEnsamble;
    Conexion con = new Conexion();
    Connection cn = con.getConnection();

    private ResultSet rs;
    private PreparedStatement pstm;
    private JFrame form;
    DefaultTableModel tabla = null;
//    Modelos ms;

    public Consultas() {
//        ms = new Modelos();
        tipoEnsamble = new ArrayList();
        tipoEnsamble.add("Alternador");
        tipoEnsamble.add("Rotor");
        tipoEnsamble.add("Estator");
        tipoEnsamble.add("Rectificador");
        tipoEnsamble.add("Marcha");
        tipoEnsamble.add("Inducido");
    }

    //==============METODOS PARA REGISTROS==============
    public boolean eliminarRegistro(String id) {
        try {
            pstm = cn.prepareStatement("DELETE FROM Perfiles WHERE Id=?");
            pstm.setString(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "Error al eliminar registro : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;

    }

    public boolean InsertarRegistro(ArrayList bitacora) {
        String consulta;
        java.util.Date uDate;
        Object[] reg = new Object[bitacora.size()];
        try {
            for (int i = 0; i < bitacora.size(); i++) {
                reg[i] = (Object) bitacora.get(i);
            }
            uDate = ParseFecha(reg[1].toString());
            Date fecha = convertUtilToSql(uDate);
            consulta = "INSERT INTO bitacora (linea, fecha, hora, tiempoIni, tiempoFin, duracion,"
                    + " tema, operacion, area, problema, cliente, noParte, cantPzas, noParteCambio) VALUES";
            pstm = cn.prepareStatement(consulta + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, reg[0].toString());
            pstm.setDate(2, fecha);
            pstm.setInt(3, Integer.parseInt(reg[2].toString()));
            pstm.setInt(4, Integer.parseInt(reg[3].toString()));
            pstm.setInt(5, Integer.parseInt(reg[4].toString()));
            pstm.setInt(6, Integer.parseInt(reg[5].toString()));
            pstm.setString(7, reg[6].toString());
            pstm.setString(8, reg[7].toString());
            pstm.setString(9, reg[8].toString());
            pstm.setString(10, reg[9].toString());
            pstm.setString(11, reg[10].toString());
            pstm.setString(12, reg[11].toString());
            pstm.setInt(13, Integer.parseInt(reg[12].toString()));
            pstm.setString(14, reg[13].toString());
            pstm.execute();
            pstm.close();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "No se pudo insertar el registro : \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    //============METODOS PARA LISTAS============
    public DefaultTableModel ListaPerfiles(int sql, String valor) {
        ArrayList<Registro> perfiles = new ArrayList();
        Registro reg;

        tabla = new DefaultTableModel();
        String consulta_total = null;
        try {
            if (sql == 0) {
                consulta_total = "select fecha, hora, linea, turno, tema, operacion, area, problema,cliente, noParte, cantPzas, tiempoIni, tiempoFin, duracionTiem, noParteCambio  from Bitacora";
            } else if (sql == 1) {
                consulta_total = "select Id, Puesto, Departamento , Escolaridad, conRequeridos,Experiencia  from Perfiles where Departamento='" + valor + "'";
            } else if (sql == 2) {
                consulta_total = "select Id, Puesto, Departamento , Escolaridad, conRequeridos,Experiencia  from Perfiles where Id='" + valor + "'";
            } else if (sql == 3) {
                consulta_total = "select Id, Puesto, Departamento , Escolaridad, conRequeridos,Experiencia  from Perfiles where Puesto='" + valor + "'";
            }

            pstm = cn.prepareStatement(consulta_total);
            rs = pstm.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {

                    reg = new Registro();

                    reg.setFecha(rs.getDate(1));
                    reg.setHora(rs.getString(2));
                    reg.setLinea(rs.getString(3));
                    reg.setTurno(rs.getString(4));
                    reg.setTema(rs.getString(5));
                    reg.setOperacion(rs.getString(6));
                    reg.setArea(rs.getString(7));
                    reg.setProblema(rs.getString(8));
                    reg.setCleinte(rs.getString(9));
                    reg.setNoParte(rs.getString(10));
                    reg.setCantPiezas(rs.getInt(11));
                    reg.setTiempoIn(rs.getString(12));
                    reg.setTiempoFin(rs.getString(13));
                    reg.setDuracion(rs.getInt(14));
                    reg.setNoParteCambio(rs.getString(15));

                    perfiles.add(reg);
                }
                String[] columnas = new String[16];
                columnas[0] = "LINEA";
                columnas[1] = "FECHA";
                columnas[2] = "TURNO";
                columnas[3] = "TIPO TURNO";
                columnas[4] = "HORA";
                columnas[5] = "INICIO INCIDENCIA";
                columnas[6] = "FIN INCIDENCIA";
                columnas[7] = "DURACION";
                columnas[8] = "TEMA";
                columnas[9] = "OPERACION";
                columnas[10] = "AREA";
                columnas[11] = "PROBLEMA";
                columnas[12] = "CLIENTE";
                columnas[13] = "NO PARTE";
                columnas[14] = "CANTIDAD";
                columnas[15] = "NoPARTE CAMBIO";
                tabla.setColumnIdentifiers(columnas);

                Object[] campos = new Object[15];
                for (Registro f : perfiles) {
                    campos[0] = f.getFecha();
                    campos[1] = f.getHora();
                    campos[2] = f.getLinea();
                    campos[3] = f.getTurno();
                    campos[4] = f.getTema();
                    campos[5] = f.getOperacion();
                    campos[6] = f.getArea();
                    campos[7] = f.getProblema();
                    campos[8] = f.getCleinte();
                    campos[9] = f.getNoParte();
                    campos[10] = f.getCantPiezas();
                    campos[11] = f.getTiempoIn();
                    campos[12] = f.getTiempoFin();
                    campos[13] = f.getDuracion();
                    campos[14] = f.getNoParteCambio();

                    tabla.addRow(campos);

                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun registro con esa caracteristica ");
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta :\n" + ex.getMessage());
        }

        return tabla;
    }
    //==========METODOS PARA COMBOBOX DE DATOS==========================

    public DefaultComboBoxModel ListaTemas() {
        DefaultComboBoxModel listaTema = new DefaultComboBoxModel();
        Object[] tema = new Object[7];
        tema[0] = "Selecciona Tema";
        tema[1] = "Piezas Producidas";
        tema[2] = "Calidad";
        tema[3] = "Tecnicas";
        tema[4] = "Organizacionales";
        tema[5] = "Cambio";
        tema[6] = "Planeados";
        listaTema.addElement(tema[0]);
        listaTema.addElement(tema[1]);
        listaTema.addElement(tema[2]);
        listaTema.addElement(tema[3]);
        listaTema.addElement(tema[4]);
        listaTema.addElement(tema[5]);
        listaTema.addElement(tema[6]);
        return listaTema;
    }

    public DefaultComboBoxModel ListaClientes(String lin) {
        String consulta;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String[] linea;
        int numCli = 0, i = 0;
        try {
            model.addElement("Elije Cliente");
            consulta = "select count(*) as cliente from clientes where linea ='" + lin + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            if (rs.next()) {
                numCli = rs.getInt(1);
            }
            linea = new String[numCli];
            consulta = "select cliente from clientes where linea ='" + lin + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                linea[i] = rs.getString(1);
                model.addElement(linea[i]);
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Modelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    public DefaultComboBoxModel ListaHoras() {
        DefaultComboBoxModel listaCliente = new DefaultComboBoxModel();
        ArrayList list = new ArrayList();
        list.add("Elija Hora");
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        list.add("21");
        list.add("22");
        list.add("23");
        for (int i = 0; i < list.size(); i++) {
            listaCliente.addElement(list.get(i));
        }
        return listaCliente;
    }

    public DefaultComboBoxModel lineas() {
        DefaultComboBoxModel listaOP = new DefaultComboBoxModel();
        String consulta, valor = null;
        try {
            consulta = "select linea from lineas";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                valor = rs.getString(1);
                listaOP.addElement(valor);
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta :\n" + ex.getMessage());
        }

        return listaOP;
    }

    public DefaultComboBoxModel ListaOperacionesPorLinea(String linea) {
        DefaultComboBoxModel listaOP = new DefaultComboBoxModel();
        String consulta, valor = null;
        listaOP.addElement("Elije OPERACION");
        try {
            consulta = "select operacion from Operaciones WHERE linea='" + linea + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                valor = rs.getString(1);
                listaOP.addElement(valor);
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta :\n" + ex.getMessage());
        }

        return listaOP;
    }

    public String DescOp(String linea, String op) {
        DefaultComboBoxModel listaOP = new DefaultComboBoxModel();
        String consulta, valor = null;
        String desc = "";
        try {
            consulta = "select descripcion from Operaciones WHERE linea='" + linea + "' and operacion='" + op + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            if (rs.next()) {
                desc = rs.getString(1);
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta DescOp:\n" + ex.getMessage());
        }

        return desc;
    }

    public DefaultComboBoxModel ListaPartes(String cliente) {
        DefaultComboBoxModel listaNoParte = new DefaultComboBoxModel();
        String consulta, valor = null;
        listaNoParte.addElement("Elije no de parte");
        try {
            consulta = "select noParte from ListaNumPartes where cliente ='" + cliente + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                valor = rs.getString(1);
                listaNoParte.addElement(valor);
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta :\n" + ex.getMessage());
        }

        return listaNoParte;
    }

    //ESTE YA ESTA
    public DefaultComboBoxModel ListaOperaciones(String tema, String linea) {
        DefaultComboBoxModel listaOP = new DefaultComboBoxModel();
        String consulta, valor = null;
        listaOP.addElement("Elije OPERACION");
        try {
            consulta = "select operacion from Operaciones WHERE linea='" + linea + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                valor = rs.getString(1);
                listaOP.addElement(valor);
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta :\n" + ex.getMessage());
        }

        return listaOP;
    }

    public DefaultComboBoxModel ListaAreas(String tema) {
        DefaultComboBoxModel listaAreas = new DefaultComboBoxModel();
        String consulta, valor = null;
        listaAreas.addElement("Elije Area");
        try {
            consulta = "select area from areas WHERE tema='" + tema + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                valor = rs.getString(1);
                listaAreas.addElement(valor);
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta :\n" + ex.getMessage());
        }

        return listaAreas;
    }

    public DefaultComboBoxModel ListaAreasPorOperacion(String linea, String tema, String op) {
        DefaultComboBoxModel listAreas = new DefaultComboBoxModel();
        String consulta, valor;
        ArrayList lista = new ArrayList();
        try {
            if (tema.equals("Organizacionales") || tema.equals("Cambio") || tema.equals("Planeados")
                    || tema.equals("organizacionales") || tema.equals("cambio") || tema.equals("planeados")) {
                consulta = "select area from Perdidas where linea='" + linea + "' and tema ='" + tema + "'";
            } else {
                consulta = "select area from Perdidas where linea='" + linea + "' and tema ='" + tema + "' AND operacion='" + op + "'";
            }
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            listAreas.addElement("Elije Area");
            while (rs.next()) {
                if (!lista.contains(rs.getString(1))) {
                    lista.add(rs.getString(1));
                    valor = rs.getString(1);
                    listAreas.addElement(valor);
                }
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta :\n" + ex.getMessage());
        }

        return listAreas;
    }

    public DefaultComboBoxModel ListaProblemas(String op, String tema, String area, String linea) {
        DefaultComboBoxModel listaProblemas = new DefaultComboBoxModel();
        String consulta, valor = "";
        ArrayList lista = new ArrayList();
        listaProblemas.addElement("Elije Problema");
        try {
            if (tema.equals("Organizacionales") || tema.equals("Cambio") || tema.equals("Planeados")
                    || tema.equals("organizacionales") || tema.equals("cambio") || tema.equals("planeados")) {
                consulta = "select problema from Perdidas where linea='" + linea + "' AND tema='" + tema + "' AND area='" + area + "'";
            } else {
                consulta = "select problema from Perdidas where linea='" + linea + "' AND operacion ='" + op + "' AND tema='" + tema + "'AND area='" + area + "'";
            }
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                if (!tema.equals("Planeados") && !valor.equalsIgnoreCase(rs.getString(1))) {
                    if (!lista.contains(rs.getString(1))) {
                        lista.add(rs.getString(1));
                        valor = rs.getString(1);
                        listaProblemas.addElement(valor);
                    }
                }
            }
            pstm.close();
            rs.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta :\n" + ex.getMessage());
        }
        return listaProblemas;
    }

    public int nivelUsuario(String usuario, String pass) {

        String consulta;
        int n = 0;
        try {
            consulta = "select privilegios from Usuarios where usuario='" + usuario + "' and password='" + pass + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            if (rs.next()) {
                n = rs.getInt(1);
            } else {
                JOptionPane.showMessageDialog(form, "Usuario no Encontrado");
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "Error al hacer la consulta nivelUsuario:\n" + ex.getMessage());
        }
        return n;
    }

    public Object[] buscaTiempoLiena(String linea, int turno) {
        String consulta;
        Object[] datos = new Object[5];
        try {
            consulta = "SELECT noPersonas, duracionTurno,tcPromedio, pzaHora, pzaDiaPorTurno from promedioLinea where linea ='" + linea + "' and turno ='" + turno + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            if (rs.next()) {
                datos[0] = rs.getInt(1);
                datos[1] = rs.getFloat(2);
                datos[2] = rs.getFloat(3);
                datos[3] = rs.getFloat(4);
                datos[4] = rs.getFloat(5);
            } else {
                JOptionPane.showMessageDialog(form, "linea no encontrada");
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta :\n" + ex.getMessage());
        }
        return datos;
    }

    public void actualizaTiemposLinea(Object[] datos) {
        String consulta;
        try {
            consulta = "UPDATE promedioLinea SET noPersonas=?, duracionTurno=?,tcPromedio=?, pzaHora=?, pzaDiaPorTurno=? "
                    + "where linea='" + datos[0].toString() + "' and turno ='" + datos[1].toString() + "'";
            pstm = cn.prepareStatement(consulta);
            pstm.setFloat(1, Float.parseFloat(datos[2].toString()));
            pstm.setFloat(2, Float.parseFloat(datos[3].toString()));
            pstm.setFloat(3, Float.parseFloat(datos[4].toString()));
            pstm.setFloat(4, Float.parseFloat(datos[5].toString()));
            pstm.setFloat(5, Float.parseFloat(datos[6].toString()));
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta :\n" + ex.getMessage());
        }
    }

    public ArrayList Lineas() {
        ArrayList lineas = new ArrayList();
        String consulta;
        Object[] linea;
        try {
            consulta = "select linea,oee from Lineas";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                linea = new Object[2];
                if (!rs.getString(1).equals("IMP")) {
                    linea[0] = rs.getString(1);
                    linea[1] = rs.getString(2);
                    lineas.add(linea);
                }
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "Error al hacer la consulta :\n" + ex.getMessage());
        }
        return lineas;
    }

    public int buscarHoras(Date fecha) {
        String consulta;
        int hora = -1;
        try {
            consulta = "select hora from bitacora where fecha='" + fecha + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                if (hora == -1) {
                    hora = rs.getInt(1);
                } else {
                    if (rs.getInt(1) > hora) {
                        hora = rs.getInt(1);
                    }
                }
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "Error al hacer la consulta buscarHoras:\n" + ex.getMessage());
        }
        return hora;
    }

    public DefaultTableModel busqueda(String linea, String tipo, String txtBuscado, DefaultTableModel model) {
        String consulta;
        Object[] operacion = new Object[4];
        PrincipalOne.ms.ClearTable(model);
        try {
            consulta = "select tema, operacion, area, problema from perdidas "
                    + "where linea='" + linea + "' and " + tipo + " LIKE '%" + txtBuscado + "%'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();

            while (rs.next()) {
                operacion[0] = rs.getString(1);
                operacion[1] = rs.getString(2);
                operacion[2] = rs.getString(3);
                operacion[3] = rs.getString(4);
                model.addRow(operacion);
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "Error al hacer la consulta busqueda:\n" + ex.getMessage());
        }
        return model;
    }

    public ArrayList ExisteFechaBitacora(String f, DefaultTableModel bitacora) {
        String consulta;
        java.util.Date uDate;
        ArrayList horas = new ArrayList();
        Object[] dat = new Object[3];
        uDate = ParseFecha(f);
        Date fecha = convertUtilToSql(uDate);
        try {
            for (int i = 0; i < bitacora.getRowCount(); i++) {
                consulta = "select hora, tiempoIni, tiempoFin from Bitacora "
                        + "WHERE fecha = TO_DATE('" + fecha + "', 'YYYY-MM-DD') and hora='" + bitacora.getValueAt(i, 2) + "'";
                pstm = cn.prepareStatement(consulta);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    if (rs.getInt(3) > Integer.parseInt(bitacora.getValueAt(i, 3).toString())) {
                        dat[0] = bitacora.getValueAt(i, 2);
                        dat[1] = bitacora.getValueAt(i, 3);
                        dat[2] = bitacora.getValueAt(i, 4);
                        horas.add(dat);
                    }
                }
                pstm.close();
                rs.close();

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(form, "Error al hacer la consulta ExisteFecha:\n" + ex.getMessage());
        }
        return horas;
    }

    public ArrayList ExisteFechaEdicionBitacora(String fecha, DefaultTableModel bitacora) {
        String consulta;
//        Date f;
        ArrayList horas = new ArrayList();
        Object[] dat = new Object[3];
//        f = Date.valueOf(fecha);
        try {
            for (int i = 0; i < bitacora.getRowCount(); i++) {
                consulta = "select hora, tiempoIni, tiempoFin from Bitacora "
                        + "WHERE fecha = TO_DATE('" + fecha + "', 'YYYY-MM-DD') and hora='" + bitacora.getValueAt(i, 2) + "'";
                pstm = cn.prepareStatement(consulta);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    if (rs.getInt(3) > Integer.parseInt(bitacora.getValueAt(i, 3).toString())) {
                        dat[0] = bitacora.getValueAt(i, 2);
                        dat[1] = bitacora.getValueAt(i, 3);
                        dat[2] = bitacora.getValueAt(i, 4);
                        horas.add(dat);
                    }
                }
                pstm.close();
                rs.close();

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(form, "Error al hacer la consulta ExisteFecha:\n" + ex.getMessage());
        }
        return horas;
    }

    public DefaultTableModel EditaDiaBitacora(Object fecha, DefaultTableModel tabla) {
        String consulta;
        Date f;
        f = Date.valueOf(fecha.toString());
        Object[] reg = new Object[14];
        ClearTable(tabla);
        try {
            consulta = "select linea, fecha, hora, tiempoIni, tiempoFin, duracion,"
                    + " tema, operacion, area, problema, cliente, noParte, cantPzas, noParteCambio from Bitacora "
                    + "WHERE fecha = TO_DATE('" + f + "', 'YYYY-MM-DD')";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                reg[0] = rs.getInt(1);
                reg[1] = rs.getDate(2);
                reg[2] = rs.getInt(3);
                reg[3] = rs.getInt(4);
                reg[4] = rs.getInt(5);
                reg[5] = rs.getInt(6);
                reg[6] = rs.getString(7);
                reg[7] = rs.getString(8);
                reg[8] = rs.getString(9);
                reg[9] = rs.getString(10);
                reg[10] = rs.getString(11);
                reg[11] = rs.getString(12);
                reg[12] = rs.getInt(13);
                reg[13] = rs.getString(14);
                tabla.addRow(reg);
            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(form, "Error al hacer la consulta ExisteFecha:\n" + ex.getMessage());
        }
        return tabla;
    }

    public void ClearTable(DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
    }

    public static java.util.Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
