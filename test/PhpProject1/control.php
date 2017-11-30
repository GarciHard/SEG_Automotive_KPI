<?php
class BaseKPI{

    public $IDr = 0 ;
    //Función que crea y devuelve un objeto de conexión a la base de datos y chequea el estado de la misma. 
    private $serverName = "SGLERSQL01\sqlexpress, 1433";
    private $connectionInfo = array( "Database"=>"DB_SystemKPI_SQL", "UID"=>"USRKPI", "PWD"=>"nZQI5NZZN8smsSsc");      
    private $connection = null;
    
    function conectarBD(){ 
        $this->connection = sqlsrv_connect($this->serverName, $this->connectionInfo) or die("Error estableciendo conexion con el servidor");
        return $this->connection;
    }  
    /*Desconectar la conexion a la base de datos*/
    function desconectarBD($conexion){
          sqlsrv_close( $this->connection );        
    }

    //Devuelve un array multidimensional con el resultado de la consulta
    function getArraySQL($sql){
        $conexion = $this->conectarBD();
        if(!$result = sqlsrv_query($conexion, $sql)) die();

        $rawdata = array();
        $i=0;
        while($row = sqlsrv_fetch_array($result)){   
            $rawdata[$i] = $row;
            $i++;
        }
        $this->desconectarBD($conexion);
        return $rawdata;
    }
    ///////////////////Pzas producidas
    function pzasProdAnual(){
        $sql = "SELECT anio, SUM(cantPzas) FROM bitacora GROUP BY anio;";
        return $this->getArraySQL($sql);
    }
    
    function pzasProdDiaMes (){
        $sql = "SELECT dia, SUM(cantPzas) FROM bitacora WHERE linea = 'L003' AND mes = 10 GROUP BY dia ORDER BY dia ASC;";
        return $this->getArraySQL($sql);
    }
    
    function pzasProdMes (){
        $sql = "SELECT mes, SUM(cantPzas) FROM bitacora WHERE linea = 'L003' AND anio = 2017 GROUP BY mes ORDER BY mes ASC;";
        return $this->getArraySQL($sql);
    }
    
    ///////////////////SCRAP
    function scrapAnual(){
        $sql = "SELECT anio, COUNT(scrap) FROM bitacora GROUP BY anio;";
        return $this->getArraySQL($sql);
    }
        
    function scrapMes (){
        $sql = "SELECT mes, COUNT(scrap) FROM bitacora WHERE linea = 'L003' AND anio = 2017 GROUP BY mes ORDER BY mes ASC;";
        return $this->getArraySQL($sql);
    }
    
    function scrapDiaMes (){
        $sql = "SELECT dia, COUNT(scrap) FROM bitacora WHERE linea = 'L003' AND mes = 10 GROUP BY dia ORDER BY dia ASC;";
        return $this->getArraySQL($sql);
    }
    
    /***********CONSULTAS PARA PERDIDAS************/
    function pTecnicasMes(){
        $sql = "SELECT mes,SUM(duracion) FROM Bitacora WHERE tema = 'Tecnicas' AND linea = 'L003' AND anio = 2017 GROUP BY mes ORDER BY mes ASC ";
        return $this->getArraySQL($sql);
    }
    
    function pTecnicasDia(){
        $sql = "SELECT dia, SUM(duracion) FROM Bitacora WHERE tema = 'Tecnicas' AND linea = 'L003' AND mes = 10 GROUP BY dia ORDER BY dia ASC;";
        return $this->getArraySQL($sql);
    }   
    
    function pTecnicasTabla(){
        $sql = "SELECT  dia, area, operacion,problema,SUM(duracion) FROM Bitacora WHERE tema = 'Tecnicas' AND linea = 'L003' AND mes = 10 GROUP BY dia, area, operacion,problema ORDER BY dia ASC;";
        return $this->getArraySQL($sql);
    }
        
    //ORGANIZACIONALES
    function pOrganizacionalesMes(){
        $sql = "SELECT mes,SUM(duracion) FROM Bitacora WHERE tema = 'Organizacionales' AND linea = 'L003' AND anio = 2017 GROUP BY mes ORDER BY mes ASC ";
        return $this->getArraySQL($sql);
    }
    
    function pOrganizacionalesDia(){
        $sql = "SELECT dia, SUM(duracion) FROM Bitacora WHERE tema = 'Organizacionales' AND linea = 'L003' AND mes = 10 GROUP BY dia ORDER BY dia ASC;";
        return $this->getArraySQL($sql);
    }   
    
    function pOrganizacionalesTabla(){
        $sql = "SELECT dia, area,problema,detalleMaterial, SUM(duracion) AS tmp  FROM Bitacora where tema = 'Organizacionales' AND linea = 'L003' AND mes = 10 GROUP BY dia,area, problema, detalleMaterial ORDER BY dia ASC ;";
        return $this->getArraySQL($sql);
    }
    
    //Cambio de Modelo
    function pCambioModMes(){
        $sql = "SELECT mes, SUM(duracion) as tmp FROM Bitacora WHERE tema = 'Calidad' AND linea = 'L022' AND anio = 2017 GROUP BY mes ORDER BY mes ASC;";
        return $this->getArraySQL($sql);
    }
    
    function pCambioModDia(){
        $sql = "SELECT dia, SUM(duracion) FROM Bitacora WHERE tema = 'Cambio de Modelo' AND linea = 'L003' AND mes = 10 GROUP BY dia ORDER BY dia ASC;";
        return $this->getArraySQL($sql);
    }   
    
    function pCambioModTabla(){
        $sql = "SELECT dia, area,problema, SUM(duracion) AS tmp  FROM Bitacora where tema = 'Cambio de Modelo' AND linea = 'L003' AND mes = 10 GROUP BY dia,area, problema ORDER BY dia ASC ;";
        return $this->getArraySQL($sql);
    }
    
    //PLANEADO
    function pPlaneadoMes(){
        $sql = "SELECT mes, SUM(duracion) as tmp FROM Bitacora WHERE tema = 'Paros Planeados' AND linea = 'L612' AND anio = 2017 GROUP BY mes ORDER BY mes ASC;";
        return $this->getArraySQL($sql);
    }
    
    function pPlaneadoDia(){
        $sql = "SELECT dia, SUM(duracion) FROM Bitacora WHERE tema = 'Paros Planeados' AND linea = 'L612' AND mes = 10 GROUP BY dia ORDER BY dia ASC;";
        return $this->getArraySQL($sql);
    }   
    
    function pPlaneadoTabla(){
        $sql = "SELECT dia, area, SUM(duracion) AS tmp  FROM Bitacora where tema = 'Paros Planeados' AND linea = 'L612' AND mes = 10 GROUP BY dia,area ORDER BY dia ASC;";
        return $this->getArraySQL($sql);
    }
    
    //PLANEADO
    function pCalidadMes(){
        $sql = "SELECT mes, SUM(duracion) as tmp FROM Bitacora WHERE tema = 'Calidad' AND linea = 'L022' AND anio = 2017 GROUP BY mes ORDER BY mes ASC;";
        return $this->getArraySQL($sql);
    }
    
    function pCalidadDia(){
        $sql = "SELECT dia, SUM(duracion) FROM Bitacora WHERE tema = 'Calidad' AND linea = 'L022' AND mes = 10 GROUP BY dia ORDER BY dia ASC;";
        return $this->getArraySQL($sql);
    }   
    
    function pCalidadTabla(){
        $sql = "SELECT dia, operacion, problema, SUM(duracion) AS tmp  FROM Bitacora where tema = 'Calidad' AND linea = 'L612' AND mes = 10 GROUP BY dia,operacion,problema ORDER BY dia ASC;";
        return $this->getArraySQL($sql);
    }
    
    /************CONSULTAS PARA EL PARETO DE TOP'S*************/
    function t5TecnicasYOrganizacionales (){
        $sql = "SELECT TOP 5 operacion,problema, SUM(duracion) as tm FROM Bitacora WHERE LINEA = 'L003' AND tema IN('Tecnicas','Organizacionales') and mes = 10 AND problema <> '' GROUP BY operacion,problema order by tm desc;";
        return $this->getArraySQL($sql);
    }
    
    function t1pareto(){
        $sql = "SELECT TOP 1 problema,COUNT(problema) as con, MAX(DURACION) as tm FROM Bitacora WHERE LINEA = 'L003' AND tema IN('Cambio de Modelo') and mes = 10 AND problema <> '' GROUP BY problema order by con DESC ;";
        return $this->getArraySQL($sql);
    }
    
    function t3Calidad(){
        $sql = "SELECT TOP 3 operacion,problema, SUM(duracion) as tm FROM Bitacora WHERE LINEA = 'L003' AND tema IN('Calidad') and mes = 10 AND problema <> '' GROUP BY operacion,problema order by tm desc;";
        return $this->getArraySQL($sql);
    }
    
    /******************TOP 3 ******************/
    function t3Tecnicas(){
        $sql = "SELECT TOP 5 operacion,problema, SUM(duracion) as tm FROM Bitacora WHERE LINEA = 'L003' AND tema IN('Tecnicas') and mes = 10 AND problema <> '' GROUP BY operacion,problema order by tm desc;";
        return $this->getArraySQL($sql);
    }
    
    function t3Organizacionales(){
        $sql = "SELECT TOP 5 operacion,problema, SUM(duracion) as tm FROM Bitacora WHERE LINEA = 'L003' AND tema IN('Organizacionales') and mes = 10 AND problema <> '' GROUP BY operacion,problema order by tm desc;";
        return $this->getArraySQL($sql);
    }
    
    
}

?>