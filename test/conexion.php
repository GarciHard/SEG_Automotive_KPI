<?php
    /*header('Content-Type: application/json');
    $con = mysqli_connect("SGLERSQL01", "USRKPI", "nZQI5NZZN8smsSsc", "DB_SystemKPI_SQL");
    if (mysqli_connect_errno($con)) {
        echo "Failed to connect to DataBase: " . mysqli_connect_error();
    } else {
        echo "Bien";
        $data_points = array();
        $result = mysqli_query($con, "SELECT * FROM lineas"); 
        while ($row = mysqli_fetch_array($result)) {
            $point = array("valorx" => $row['x'], "valory" => $row['y']);
            array_push($data_points, $point);
        }
        echo json_encode($data_points);
    }
    mysqli_close($con);*/
    
    $serverName = "SGLERSQL01\sqlexpress, 1433"; //serverName\instanceName, portNumber (por defecto es 1433)
    $connectionInfo = array( "Database"=>"DB_SystemKPI_SQL", "UID"=>"USRKPI", "PWD"=>"nZQI5NZZN8smsSsc");
    $conn = sqlsrv_connect( $serverName, $connectionInfo);

    if( $conn ) {
        echo "Conexión exitosa WIN :) .<br />";
        $data_points = array();
        $result = mysqli_query($con, "SELECT * FROM lineas"); 
        while ($row = mysqli_fetch_array($result)) {
            $point = array("valorx" => $row['x'], "valory" => $row['y']);
            array_push($data_points, $point);
        }
        echo json_encode($data_points);
    }else{
        echo "Conexión no se pudo establecer.<br />";
        die( print_r( sqlsrv_errors(), true));
    }
    
?>