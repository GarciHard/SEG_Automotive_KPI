/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.ConexionBD;
import modelo.ReportesDAO;
import vista.Reportes;

/**
 *
 * @author PRR1TL
 */
public class ReportesDAOImpl extends ConexionBD implements ReportesDAO {
    
    //Reportes reporte = new Reportes();
    //COMBOS
    private ArrayList<String> listaLineas; 
    private ArrayList<String> listaNoParte;
    private ArrayList<String> listaClientes;
    
    //CONSULTAS
    private ArrayList produccionModelo;
            
    private PreparedStatement ps;
    private ResultSet rs;
    
    /*********QUERYS*************/
    //LLENA COMBOS
    String LISTA_CLIENTES_PRODUCCION = "SELECT cliente FROM Bitacora WHERE linea = ? AND Tema = ? AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY') GROUP BY cliente ORDER BY cliente ASC";
    String LISTA_CLIENTES_PERDIDAS = "SELECT cliente FROM Bitacora WHERE linea = ? AND Tema <> ? AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY') GROUP BY cliente ORDER BY cliente ASC";
    String LISTA_NOPARTE_PRODUCCION = "SELECT NoParte FROM Bitacora WHERE linea = ? AND Tema = ? AND cliente = ? AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY') GROUP BY NoParte ORDER BY NoParte ASC";
    String LISTA_NOPARTE_PERDIDAS = "SELECT NoParte FROM Bitacora WHERE linea = ? AND Tema <> ? AND cliente = ? AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY') GROUP BY NoParte ORDER BY NoParte ASC";
    String LISTA_LINEAS_REGISTRADAS = "SELECT Linea FROM Bitacora Group By Linea Order BY Linea ASC";
    
    //CONSULTAS
    String SCRAP_TOTAL = "SELECT Sum(scrap) FROM Bitacora WHERE linea = ? AND Tema <> 'Piezas Producidas' AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY')";
    String PRODUCCION_TOTAL = "SELECT Sum(cantPzas) FROM Bitacora WHERE linea = ? AND Tema = 'Piezas Producidas' AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY')";
    
    String PRODUCCION_MODELO = "SELECT cliente, noParte, Sum(cantPzas) FROM Bitacora "
            +"WHERE linea = ? AND tema ? AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY') GROUP BY cliente, noParte ORDER BY cliente, noParte ASC";
    String LISTA_TOTAL_PERDIDAS = "";
    
    @Override
    public DefaultComboBoxModel listaLineasBitacora() throws Exception {
        listaLineas = new ArrayList<>();
        listaLineas.add("Linea");
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_LINEAS_REGISTRADAS);
            rs = ps.executeQuery();

            while (rs.next()) {
                listaLineas.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        }finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return new DefaultComboBoxModel(listaLineas.toArray());         
    }
    
    @Override
    public DefaultComboBoxModel listaNoParteProduccion (String linea, String tema, String cliente, String fechaInicial, String fechaFinal) throws Exception {
        listaNoParte = new ArrayList();
        listaNoParte.add("Numero de Parte");
        System.out.println("l "+linea+" t "+tema+" c "+cliente+" fi "+fechaInicial+" ff"+fechaFinal);
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_NOPARTE_PRODUCCION);
            
            ps.setString(1, linea);
            ps.setString(2, tema);
            ps.setString(3, cliente);
            ps.setString(4, fechaInicial);
            ps.setString(5, fechaFinal);
            
            rs = ps.executeQuery();
            while (rs.next()){
              listaNoParte.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        //System.out.println(listaProduccionModelo);        
        return new DefaultComboBoxModel(listaNoParte.toArray());        
    }

    @Override
    public DefaultComboBoxModel listaNoParteScrap (String linea, String tema, String cliente, String fechaInicial, String fechaFinal) throws Exception {
        listaNoParte = new ArrayList();
        listaNoParte.add("Numero de Parte");
        //System.out.println(linea);
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_NOPARTE_PERDIDAS);
            
            ps.setString(1, linea);
            ps.setString(2, tema);
            ps.setString(3, cliente);
            ps.setString(4, fechaInicial);
            ps.setString(5, fechaFinal);
            
            rs = ps.executeQuery();
            while (rs.next()){
              listaNoParte.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        //System.out.println(listaProduccionModelo);        
        return new DefaultComboBoxModel(listaNoParte.toArray()); 
    }
    
    @Override
    public DefaultComboBoxModel listaClientesProduccion(String linea, String tema, String fechaInicial, String fechaFinal) throws Exception {
        listaClientes = new ArrayList();
        listaClientes.add("Cliente");
        //System.out.println(linea);
        try {
            this.conectar();
           
            ps = this.conexion.prepareStatement(LISTA_CLIENTES_PRODUCCION);
               
            ps.setString(1, linea);
            ps.setString(2, tema);
            ps.setString(3, fechaInicial);
            ps.setString(4, fechaFinal);
            
            rs = ps.executeQuery();
            while (rs.next()){
              listaClientes.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        //System.out.println(listaProduccionModelo);        
        return new DefaultComboBoxModel(listaClientes.toArray());
    }
    
    @Override
    public DefaultComboBoxModel listaClientesScrap(String linea, String tema, String fechaInicial, String fechaFinal) throws Exception {
        listaClientes = new ArrayList();
        listaClientes.add("Cliente");
        //System.out.println(linea);
        try {
            this.conectar();
           
            ps = this.conexion.prepareStatement(LISTA_CLIENTES_PERDIDAS);
               
            ps.setString(1, linea);
            ps.setString(2, tema);
            ps.setString(3, fechaInicial);
            ps.setString(4, fechaFinal);
            
            rs = ps.executeQuery();
            while (rs.next()){
              listaClientes.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        //System.out.println(listaProduccionModelo);        
        return new DefaultComboBoxModel(listaClientes.toArray());
    }
    
    @Override
    public int produccionTotal(String linea, String fechaInicial, String fechaFinal) throws Exception {
        int producidas = 0;
        
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(PRODUCCION_TOTAL);
            ps.setString(1, linea);
            ps.setString(2, fechaInicial);
            ps.setString(3, fechaFinal);

            rs = ps.executeQuery();

            if (rs.next()){
                producidas = rs.getInt(1);
            } else {
                producidas = 0;
            }        
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        
        return producidas; 
    }

    @Override
    public int scrapTotal(String linea, String fechaInicial, String fechaFinal) throws Exception {
        int scrap = 0;
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(SCRAP_TOTAL);
            ps.setString(1, linea);
            ps.setString(2, fechaInicial);
            ps.setString(3, fechaFinal);

            rs = ps.executeQuery();

            if (rs.next()){
                scrap = rs.getInt(1);
            } else {
                scrap = 0;
            }        
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        
        return scrap; 
    }  

    @Override
    public ArrayList listaPerdidasPorTemaYArea(String linea, String fechaInicial, String fechaFinal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList produccionPorModelo(String linea, String tema, String fechaInicial, String fechaFinal) throws Exception {
        produccionModelo = new ArrayList();
        Object[] cantidProduccionModelo;
        try {
            this.conectar();
            //for (int i = 0; i < cantidadRegistrosNoParte; i++){
                ps = this.conexion.prepareStatement(PRODUCCION_MODELO);
                ps.setString(1, linea);
                ps.setString(2, tema);
                ps.setString(3, fechaInicial);
                ps.setString(4, fechaFinal);
                rs = ps.executeQuery();
                if(rs.next()){
                  //cantidades =0 ;
                  //listaProduccionModelo.add(cantidades);
                }
            //}
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return produccionModelo;
    }

    @Override
    public ArrayList perdidasPorTema(String linea, String fechaInicial, String fechaFinal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
