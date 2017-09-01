package modelo;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author PRR1TL
 */
public class ModelosListasOperaciones {
    
    private static final String[] temas = {"Selecciona Tema", "Calidad",
        "Tecnicas", "Organizacionales", "Cambio", "Planeados"};

    public static DefaultComboBoxModel listaTema() {
        return new DefaultComboBoxModel(temas);
    }
    
    private static final String[] areaCalidad = {
        "Selecciona Area", "Scrap Operador", "Scrap Maquina",
        "Scrap Proveedor ", "Scrap Planeado", "Rework"
    };
    
    public static DefaultComboBoxModel listaAreaCalidad() {
        return new DefaultComboBoxModel(areaCalidad);
    }
    
    private static final String[] areaTecnicas = {
        "Selecciona Area","Maquina Proceso","Mecanicos","Electricos",
        "Hidraulicos Pneumaticos","Software Computadora","Reajuste Maquina"
    };
    
    public static DefaultComboBoxModel listaAreTecnicas(){
        return new DefaultComboBoxModel(areaTecnicas);
    }
    
    private static final String[] areaOrganizacionalez = {
        "Selecciona Area","Produccion","Logistica","Otras"  
    };
    
    public static DefaultComboBoxModel listaAreaOrganizacionales(){
        return new DefaultComboBoxModel(areaOrganizacionalez);
    }
    
    private static final String[] areaCambio = {
        "Selecciona Area","Cambio de modelo planeado","Cambio de modelo NO Planeado","Perdidas despues del cambio"  
    };
    
    public static DefaultComboBoxModel listaAreaCambio(){
        return new DefaultComboBoxModel(areaCambio);
    }
    
    private static final String[] areaPlaneados = {
        "Selecciona Area","Planeados","Mantenimiento Planeado/TPM","Otros Paros Planeados",
        "Worshop Planeado","Entrenamiento Planeado","Produccion de Prototipos/Muestras",
        "Juntas de trabajo Planeado","Comedor","Activacion Fisica","Descanso","5S's"
    };
    
    public static DefaultComboBoxModel listaAreaPlaneados(){
        return new DefaultComboBoxModel(areaPlaneados);
    }
    
}
