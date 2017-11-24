<?php
require_once 'ServerConfig.php';
/**
 * Description of ServerFunctions
 *
 * @author GJA5TL
 */

//Piezas producidas anuales
function piezasProducidasAnuales($line, $year) {
    $connectionObj = new ServerConfig();
    $connectionStr = $connectionObj -> serverConnection();
    
    $queryVar = sqlsrv_query($connectionStr, "SELECT Anio, SUM(cantPzas) FROM Bitacora WHERE linea = '$line' AND anio = $year GROUP BY anio");
    
    if ($queryVar) {
        $aux = sqlsrv_fetch_array( $queryVar );
        return $aux;
    }
    $connectionObj -> serverDisconnect();
}

//Piezas producidas mensualmente
function piezasProducidasMensuales($line, $year, $month) {
    $connectionObj = new ServerConfig();
    $connectionStr = $connectionObj -> serverConnection();
    
    $queryVar = sqlsrv_query($connectionStr, "SELECT mes, SUM (cantPzas) FROM Bitacora WHERE linea = '$line' AND anio = $year AND Mes <= $month GROUP BY mes");
    
    if ($queryVar) {
        $aux = sqlsrv_fetch_array( $queryVar );
        return $aux;
    }
    $connectionObj -> serverDisconnect();
}

//Piezas producidas dia/mes
function piezasProducidasDiaMes($line, $year, $month) {
    $connectionObj = new ServerConfig();
    $connectionStr = $connectionObj -> serverConnection();
    
    $queryVar = sqlsrv_query($connectionStr, "SELECT dia, SUM (cantPzas) FROM Bitacora WHERE linea = '$line' AND $year = 2017 AND mes = $month GROUP BY dia");
    
    if ($queryVar) {
        $aux = sqlsrv_fetch_array( $queryVar );
        return $aux;
    }
    $connectionObj -> serverDisconnect();
}

//Lista de desglose
function piezasProducidasDesglose($line, $year, $month) {
    $connectionObj = new ServerConfig();
    $connectionStr = $connectionObj -> serverConnection();
    
    $queryVar = sqlsrv_query($connectionStr, "SELECT dia, cliente, noParte, SUM (cantPzas) FROM Bitacora WHERE linea = '$line' AND anio = $year AND mes = $month GROUP BY dia, cliente, noParte");
    
    if ($queryVar) {
        $aux = sqlsrv_fetch_array( $queryVar );
        return $aux;
    }
    $connectionObj -> serverDisconnect();
}