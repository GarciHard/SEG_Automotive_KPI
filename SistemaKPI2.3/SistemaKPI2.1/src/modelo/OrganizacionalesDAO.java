package modelo;

import javax.swing.DefaultComboBoxModel;

/**
 * Hecho con <3 por:
 * @author garcihard
 */
public interface OrganizacionalesDAO {
    
    public DefaultComboBoxModel listaAreasOrganizacional(String tema) throws Exception;
    public DefaultComboBoxModel listaProblemasOrganizacional(String linea, String tema, String area) throws Exception;
}
