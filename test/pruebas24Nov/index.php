<?php     
require_once 'modelo/ServerFunctions.php';
?>

<html>
    <head>
        <title>
            PruebaPHP_SEG
        </title>
    </head>
    <body>
        <h1>PHPeando en SEG</h1>
        <?php       
        echo "<h2><i>PRODUCCION ANUAL</i></h2>";
        $yearArr = piezasProducidasAnuales('L003', 2017);
        list($yYear, $yQuantity) = $yearArr;
        echo "año: $yYear , cantidad: $yQuantity";
        
        echo "<br><h2><i>PRODUCCION MENSUAL</i></h2>";
        $monthArr = piezasProducidasMensuales('L003', 2017, 10);
        list($mMonth, $mQuantity) = $monthArr;
        echo "mes: $mMonth, cantidad: $mQuantity";
        
        echo "<br><h2><i>PRODUCCION DIA/MES</i></h2>";
        $dayArr = piezasProducidasDiaMes('L003', 2017, 10);
        list($dMonth, $dQuantity) = $dayArr;
        echo "dia: $dMonth, cantidad: $dQuantity";
        
        echo "<br><h2><i>LISTA DESGLOSE</i></h2>";
        $breakArr = piezasProducidasDesgloSe('L003', 2017, 10);
        list($bDay, $bClient, $bPartNum, $bQuantity) = $breakArr;
        echo "dia: $bDay, cliente: $bClient, noParte: $bPartNum, cantidad: $bQuantity";
        ?>
    </body>
</html>

