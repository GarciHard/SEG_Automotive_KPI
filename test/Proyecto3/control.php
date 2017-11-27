<?php
class BaseKPI{

    public $IDr = 0 ;
    //Función que crea y devuelve un objeto de conexión a la base de datos y chequea el estado de la misma. 
    function conectarBD(){ 
            $server = "localhost";
            $usuario = "root";
            $pass = "";
            $BD = "kpi";
            $conexion = mysqli_connect($server, $usuario, $pass, $BD); 
            if(!$conexion){ 
               echo 'Ha sucedido un error inexperado en la conexion de la base de datos<br>'; 
            } 
            return $conexion; 
    }  
    /*Desconectar la conexion a la base de datos*/
    function desconectarBD($conexion){
            $close = mysqli_close($conexion); 
            if(!$close){  
               echo 'Ha sucedido un error inexperado en la desconexion de la base de datos<br>'; 
            }    
            return $close;         
    }

    //Devuelve un array multidimensional con el resultado de la consulta
    function getArraySQL($sql){
        $conexion = $this->conectarBD();
        if(!$result = mysqli_query($conexion, $sql)) die();

        $rawdata = array();
        $i=0;
        while($row = mysqli_fetch_array($result)){   
            $rawdata[$i] = $row;
            $i++;
        }
        $this->desconectarBD($conexion);
        return $rawdata;
    }
    
    function getAllInfo(){
        $sql = "SELECT timepo, SUM(valor) FROM dat GROUP BY timepo;";
        return $this->getArraySQL($sql);
    }
    
    function pzasProdAnual(){
        $sql = "SELECT anio, SUM(cantPzas) FROM bitacora GROUP BY anio;";
        return $this->getArraySQL($sql);
    }
    
    function pzasProdDiaMes (){
        $sql = "SELECT dia, SUM(cantPzas) FROM bitacora WHERE linea = 'L003' AND mes = 11 GROUP BY dia;";
        return $this->getArraySQL($sql);
    }
    
    function pzasProdMes (){
        $sql = "SELECT mes, SUM(cantPzas) FROM bitacora WHERE linea = 'L003' AND anio = 2017 GROUP BY mes;";
        return $this->getArraySQL($sql);
    }
    
    function pTecnicasMes(){
        $sql = "SELECT mes,SUM(duracion) FROM Bitacora WHERE tema = 'Tecnicas' GROUP BY mes ";
        return $this->getArraySQL($sql);
    }
    
    function pTecnicasDia(){
        $sql = "SELECT dia, SUM(duracion) FROM Bitacora WHERE tema = 'Tecnicas' AND mes = 11 GROUP BY dia;";
        return $this->getArraySQL($sql);
        
    }
    
    
}

?>