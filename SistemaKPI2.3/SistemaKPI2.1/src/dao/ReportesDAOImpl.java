/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
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
    private ArrayList<String> listaProduccionClienteModelo;
    private ArrayList<String> listaProduccionClientesGeneral;
    private ArrayList<String> listaProduccionClienteEspecifico;
    private ArrayList<String> listaProduccionModelosGeneral;
    private ArrayList<String> listaProduccionModeloEspecifico;
    
    private ArrayList<String> listaPerdidasTema;
    private ArrayList<String> listaPerdidasTemaArea;
    
    //BD        
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
    
    //PRODUCCION    
    String PRODUCCION_CLIENTES_GENERAL = "SELECT cliente, Sum(cantPzas) FROM Bitacora "
            +"WHERE linea = ? AND tema = ? AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY') GROUP BY cliente ORDER BY cliente ASC";
    String PRODUCCION_CLIENTE_MODELO_GENERAL = "SELECT cliente, noParte, Sum(cantPzas) FROM Bitacora "
            +"WHERE linea = ? AND tema = ? AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY') GROUP BY cliente, noParte ORDER BY cliente, noParte ASC";
    String PRODUCCION_MODELOS_GENERAL = "SELECT noParte, Sum(cantPzas) FROM Bitacora "
            +"WHERE linea = ? AND cliente = ? AND tema = ? AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY') GROUP BY noParte ORDER BY noParte ASC";
    String PRODUCCION_MODELOS_ESPECIFICO = "SELECT Sum(cantPzas) FROM Bitacora "
            +"WHERE linea = ? AND tema = ? AND noParte = ? AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY') GROUP BY noParte ORDER BY noParte ASC";
    String PRODUCCION_CLIENTE_ESPECIFICO = "SELECT Sum(cantPzas) FROM Bitacora "
            +"WHERE linea = ? AND tema = ? AND Cliente = ? AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY') GROUP BY cliente ORDER BY cliente ASC";
    
    //PERDIDAS
    String PERDIDAS_TEMA_GENERAL = "SELECT Sum(scrap) FROM Bitacora "
            +"WHERE linea = ? AND tema <> ? AND fecha >= TO_DATE(?, 'DD/MM/YYYY') AND fecha <= TO_DATE(?, 'DD/MM/YYYY') GROUP BY tema ORDER BY tema ASC";
    
    @Override
    public DefaultComboBoxModel listaLineasBitacora() throws Exception {
        listaLineas = new ArrayList<>();
        listaLineas.add("LINEA");
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
        listaNoParte.add("NUMERO DE PARTE");
        listaNoParte.add("TODOS");
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
        
        return new DefaultComboBoxModel(listaNoParte.toArray());        
    }

    @Override
    public DefaultComboBoxModel listaNoParteScrap (String linea, String tema, String cliente, String fechaInicial, String fechaFinal) throws Exception {
        listaNoParte = new ArrayList();
        listaNoParte.add("NUMERO DE PARTE");
        listaNoParte.add("TODOS");
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
        
        return new DefaultComboBoxModel(listaNoParte.toArray()); 
    }
    
    @Override
    public DefaultComboBoxModel listaClientesProduccion(String linea, String tema, String fechaInicial, String fechaFinal) throws Exception {
        listaClientes = new ArrayList();
        listaClientes.add("CLIENTE");
        listaClientes.add("TODOS");
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
        
        return new DefaultComboBoxModel(listaClientes.toArray());
    }
    
    @Override
    public DefaultComboBoxModel listaClientesScrap(String linea, String tema, String fechaInicial, String fechaFinal) throws Exception {
        listaClientes = new ArrayList();
        listaClientes.add("CLIENTE");
        listaClientes.add("TODOS");
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
    public int scrapTotal(String linea,String tema, String fechaInicial, String fechaFinal) throws Exception {
        int scrap = 0;
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(SCRAP_TOTAL);
            ps.setString(1, linea);
            ps.setString(2, tema);
            ps.setString(3, fechaInicial);
            ps.setString(4, fechaFinal);

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
    public ArrayList produccionClientesGeneral(String linea, String tema, String fechaInicial, String fechaFinal) throws Exception {
        listaProduccionClientesGeneral = new ArrayList<String> ();
        Object[] producionModeloObj = new Object[2];
        System.out.println(linea+" , "+tema+" , "+fechaInicial+" , "+fechaFinal);
        try {
            this.conectar();
                ps = this.conexion.prepareStatement(PRODUCCION_CLIENTES_GENERAL);
                ps.setString(1, linea);
                ps.setString(2, tema);
                ps.setString(3, fechaInicial);
                ps.setString(4, fechaFinal);
                rs = ps.executeQuery();
                while(rs.next()){
                    producionModeloObj [0] = rs.getString(1);
                    producionModeloObj [1] = rs.getString(2);                    
                    listaProduccionClientesGeneral.add(Arrays.deepToString(producionModeloObj));
                    listaProduccionClientesGeneral.add("\n");
                }
            //}
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        //System.out.println(listaProduccionModelo);
        return listaProduccionClientesGeneral;
    }
    
    @Override
    public ArrayList produccionClienteEpecifico(String linea, String tema, String cliente, String fechaInicial, String fechaFinal) throws Exception {
        listaProduccionClienteEspecifico = new ArrayList<>();
        Object[] producionModeloObj = new Object[2];
        try {
            this.conectar();
                ps = this.conexion.prepareStatement(PRODUCCION_CLIENTE_ESPECIFICO);
                ps.setString(1, linea);
                ps.setString(2, tema);
                ps.setString(3, cliente);
                ps.setString(4, fechaInicial);
                ps.setString(5, fechaFinal);
                rs = ps.executeQuery();
                while(rs.next()){
                    producionModeloObj [0] = rs.getString(1);
                    producionModeloObj [1] = rs.getString(2);
                    listaProduccionClientesGeneral.add(Arrays.deepToString(producionModeloObj));
                    listaProduccionClientesGeneral.add("\n");
                }
        }catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        
        return listaProduccionClienteEspecifico;        
    }

    @Override
    public ArrayList produccionModeloGeneral(String linea, String tema, String cliente, String fechaInicial, String fechaFinal) throws Exception {
       listaProduccionModelosGeneral = new ArrayList<String> ();
        Object[] producionModeloObj = new Object[2];
        try {
            this.conectar();
                ps = this.conexion.prepareStatement(PRODUCCION_MODELOS_GENERAL);
                ps.setString(1, linea);
                ps.setString(2, tema);
                ps.setString(3, cliente);
                ps.setString(4, fechaInicial);
                ps.setString(5, fechaFinal);
                rs = ps.executeQuery();
                while(rs.next()){
                    producionModeloObj [0] = rs.getString(1);
                    producionModeloObj [1] = rs.getString(2);                    
                    listaProduccionModelosGeneral.add(Arrays.deepToString(producionModeloObj));
                    listaProduccionModelosGeneral.add("\n");
                }
            //}
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        //System.out.println(listaProduccionModelo);
        return listaProduccionModelosGeneral;
    }

    @Override
    public ArrayList produccionModeloEpecifico(String linea, String tema, String noParte, String fechaInicial, String fechaFinal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    @Override
    public ArrayList produccionClientesModelosGeneral(String linea, String tema, String fechaInicial, String fechaFinal) throws Exception {
        listaProduccionClienteModelo = new ArrayList<String> ();
        Object[] producionModeloObj = new Object[3];
        System.out.println(linea+" , "+tema+" , "+fechaInicial+" , "+fechaFinal);
        try {
            this.conectar();
                ps = this.conexion.prepareStatement(PRODUCCION_CLIENTE_MODELO_GENERAL);
                ps.setString(1, linea);
                ps.setString(2, tema);
                ps.setString(3, fechaInicial);
                ps.setString(4, fechaFinal);
                rs = ps.executeQuery();
                while(rs.next()){
                    producionModeloObj [0] = rs.getString(1);
                    producionModeloObj [1] = rs.getString(2);
                    producionModeloObj [2] = rs.getString(3);                    
                    listaProduccionClienteModelo.add(Arrays.deepToString(producionModeloObj));
                    listaProduccionClienteModelo.add("\n");
                }
            //}
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        //System.out.println(listaProduccionModelo);
        return listaProduccionClienteModelo;
    }
    
    @Override
    public ArrayList perdidasPorTemaGeneral(String linea, String tema, String fechaInicial, String fechaFinal) throws Exception {
        listaPerdidasTema = new ArrayList<String> ();
        Object[] producionModeloObj = new Object[2];
        //System.out.println(linea+" , "+tema+" , "+fechaInicial+" , "+fechaFinal);
        try {
            this.conectar();
                ps = this.conexion.prepareStatement(PERDIDAS_TEMA_GENERAL);
                ps.setString(1, linea);
                ps.setString(2, tema);
                ps.setString(3, fechaInicial);
                ps.setString(4, fechaFinal);
                rs = ps.executeQuery();
                while(rs.next()){
                    producionModeloObj [0] = rs.getString(1);
                    producionModeloObj [1] = rs.getString(2);                    
                    listaPerdidasTema.add(Arrays.deepToString(producionModeloObj));
                    listaPerdidasTema.add("\n");
                }
            //}
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return listaPerdidasTema;
    }
    
    @Override
    public ArrayList perdidasPorTemaYArea(String linea, String tema, String fechaInicial, String fechaFinal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public ArrayList produccionClienteModeloEspecifico(String linea, String tema, String cliente, String modelo, String fechaInicial, String fechaFinal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    ///////////////////////////////////////////////////
    
}
