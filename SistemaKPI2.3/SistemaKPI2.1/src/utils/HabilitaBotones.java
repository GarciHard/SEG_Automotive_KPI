package utils;

/* Nombre de clase		: HabilitaBotones
*Descripción de la clase	: Es la clase que determina los métodos para poder habilitar y manipular botones de la interfaz.
*Fecha	de creación		: 18/07/2017
*Elaboró			: Areli P.C 
*Usuario                        : PRR1TL
*Fecha	de Liberación		: 
*Autorizó			: 
*Fecha Mantenimiento		: dd/MM/AAAA
*Responsable			: 
*Revisor 			: 
*/


import vista.Principal;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * @author PRR1TL 
 */
//public class HabilitaBotones {
//    private static DefaultComboBoxModel listaVacia = new DefaultComboBoxModel();
//        
//    public static void estadoInicial(Principal pr) {
//        inhabilitaCombos(pr);  
//        limpiaeInhabilitaPiezaCambio(pr);
//        limpiaeInhabilitaHora(pr);
//        limpiaCombos(pr);
//    }
//
//    public static void seleccionTema(Principal pr){
//        listasVacias(pr);
//        inhabilitaCombos(pr);
//        limpiaeInhabilitaHora(pr);
//        limpiaeInhabilitaPiezaCambio(pr);
//    }
//    
//    public static void limpiaeInhabilitaHora(Principal pr){
//        pr.getCmbHora().setEnabled(false);
//        pr.getCmbHora().setSelectedIndex(0);
//        pr.getTxtTiempoInicio().setEditable(false);        
//        pr.getTxtTiempoFin().setEditable(false);        
//        pr.getTxtDuracion().setEditable(false); 
//        pr.getTxtTiempoInicio().setText("");
//        pr.getTxtTiempoFin().setText("");
//        pr.getTxtDuracion().setText("");
//    }
//
//    public static void limpiaeInhabilitaPiezaCambio(Principal pr){
//        pr.getCmbParteCambio().setEnabled(false);
//        pr.getCmbParteCambio().setVisible(false);
//        pr.getCmbParteCambio().setModel(listaVacia);
//        //pr.getLblParteCambio().setVisible(false);
//    }
//
//    public static void listasVacias(Principal pr){
//        pr.getCmbOperacion().setModel(listaVacia);
//        pr.getCmbArea().setModel(listaVacia);
//        pr.getCmbProblema().setModel(listaVacia);
//        pr.getCmbCliente().setModel(listaVacia);
//        pr.getCmbNoParte().setModel(listaVacia);
//    }
//
//    public static void limpiaTodo(Principal pr){
//        inhabilitaCombos(pr);
//        listasVacias(pr);
//        limpiaeInhabilitaPiezaCambio(pr);
//        limpiaeInhabilitaHora(pr);
//        limpiaCombos(pr);
//    }
//    
//    public static void limpiaCombos(Principal pr){
//        pr.getTxtCantidadProducida();
//        pr.getTxtScrap();
//        pr.getTxtDuracion();
//        pr.getTxtTiempoFin();
//        pr.getTxtTiempoInicio();
//    }
//
//    public static void inhabilitaCombos(Principal pr){
//        pr.getCmbOperacion().setEnabled(false);
//        pr.getCmbArea().setEnabled(false);
//        pr.getCmbProblema().setEnabled(false);
//        pr.getCmbCliente().setEnabled(false);
//        pr.getCmbNoParte().setEnabled(false);
//        pr.getTxtCantidadProducida().setEditable(false);
//    }
//    
//    public static void seleccionOperacio(Principal pr){
//        pr.getCmbArea().setEnabled(false);
//        pr.getCmbArea().setModel(listaVacia);
//        pr.getCmbProblema().setEnabled(false);
//        pr.getCmbProblema().setModel(listaVacia);
//        pr.getCmbCliente().setEnabled(false);
//        pr.getCmbCliente().setModel(listaVacia);
//        pr.getCmbNoParte().setEnabled(false);
//        pr.getCmbNoParte().setModel(listaVacia);
//        pr.getTxtCantidadProducida().setEditable(false);
//        pr.getTxtCantidadProducida().setText("");
//        pr.getTxtScrap().setEditable(false);
//        pr.getTxtScrap().setText("");
//        limpiaeInhabilitaHora(pr);
//    }
//    
//    public static void seleccionArea(Principal pr){
//        pr.getCmbProblema().setEnabled(false);
//        pr.getCmbProblema().setModel(listaVacia);
//        pr.getCmbCliente().setEnabled(false);
//        pr.getCmbCliente().setModel(listaVacia);
//        pr.getCmbNoParte().setEnabled(false);
//        pr.getCmbNoParte().setModel(listaVacia);
//        pr.getTxtCantidadProducida().setEditable(false);
//        pr.getTxtCantidadProducida().setText("");
//        pr.getTxtScrap().setEditable(false);
//        pr.getTxtScrap().setText("");
//        limpiaeInhabilitaHora(pr);
//    }
//    
//    public static void seleccionProblema(Principal pr){
//        pr.getCmbCliente().setEnabled(false);
//        pr.getCmbCliente().setModel(listaVacia);
//        pr.getCmbNoParte().setEnabled(false);
//        pr.getCmbNoParte().setModel(listaVacia);
//        pr.getTxtCantidadProducida().setEditable(false);
//        pr.getTxtCantidadProducida().setText("");
//        pr.getTxtScrap().setEditable(false);
//        pr.getTxtScrap().setText("");
//        limpiaeInhabilitaHora(pr);
//    }
//    
//    public static void seleccionCliente(Principal pr){
//        pr.getCmbNoParte().setEnabled(false);
//        pr.getCmbNoParte().setModel(listaVacia);
//        pr.getTxtCantidadProducida().setEditable(false);
//        pr.getTxtCantidadProducida().setText("");
//        pr.getTxtScrap().setEditable(false);
//        pr.getTxtScrap().setText("");
//        limpiaeInhabilitaHora(pr);
//    }
//    
//    public static void seleccionHora(Principal pr){
//        pr.getTxtTiempoInicio().setEditable(false);
//        pr.getTxtTiempoInicio().setText("");        
//        pr.getTxtTiempoFin().setEditable(false); 
//        pr.getTxtTiempoFin().setText("");
//        pr.getTxtDuracion().setEditable(false);
//        pr.getTxtDuracion().setText("");
//    }
//    
//}
//

