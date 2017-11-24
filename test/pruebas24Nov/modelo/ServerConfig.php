<?php
/**
 * Description of ServerConfig
 *
 * @author GJA5TL
 */
class ServerConfig {
    
    private $serverName = "SGLERSQL01\sqlexpress, 1433";
    private $connectionInfo = array( "Database"=>"DB_SystemKPI_SQL", "UID"=>"USRKPI", "PWD"=>"nZQI5NZZN8smsSsc");      
    private $connection = null;
    
    function serverConnection() {
        $this->connection = sqlsrv_connect($this->serverName, $this->connectionInfo)
                or die("Error estableciendo conexion con el servidor");
        return $this->connection;
    }
    
    function serverDisconnect() {
        sqlsrv_close( $this->connection );
    }
}
