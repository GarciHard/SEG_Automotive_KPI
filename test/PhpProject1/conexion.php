<?php
    $serverName = "SGLERSQL01\sqlexpress, 1433";
    $connectionInfo = array("Database"=>"DB_SystemKPI_SQL", "UID"=>"USRKPI", "PWD"=>"nZQI5NZZN8smsSsc");
    $conn = sqlsrv_connect( $serverName, $connectionInfo );
    if( $conn === false ) {
        die( print_r( sqlsrv_errors(), true));
    } else {
        $sql = "SELECT valorX,valorY FROM prueba";
        $stmt = sqlsrv_query( $conn, $sql );
        $data_points = array();
        
        if( $stmt === false) {
            die( print_r( sqlsrv_errors(), true) );
        }

        while( $row = sqlsrv_fetch_array( $stmt, SQLSRV_FETCH_ASSOC) ) {
            echo $row['valorX'].", ".$row['valorY']."<br />";
        }

        //sqlsrv_free_stmt( $stmt);
    }        
?>