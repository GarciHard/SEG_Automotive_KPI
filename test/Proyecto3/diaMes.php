<HTML>
<BODY>

<meta charset="utf-8"> 

<?php
require_once("control.php");

$rand = new BaseKPI();
$rawdata = $rand->getAllInfo();

//nos creamos dos arrays para almacenar el tiempo y el valor numérico
$valoresArray;
$timeArray;

for($i = 0 ;$i<count($rawdata);$i++){
    $time= $rawdata[$i][0];
    $date = new DateTime($time);
    //ALMACENAMOS EL TIMESTAMP EN EL ARRAY
    $timeArray[$i] = $date->getTimestamp()*1000;
    
    $valoresArray[$i]= $rawdata[$i][1]; //los puntos
    //OBTENEMOS EL TIMESTAMP 
}
?>
<div id="contenedor"></div>

<script src="https://code.jquery.com/jquery.js"></script>
    <!-- Importo el archivo Javascript de Highcharts directamente desde su servidor -->
<script src="http://code.highcharts.com/stock/highstock.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>

chartCPU = new Highcharts.StockChart({
    chart: {
        renderTo: 'contenedor'
    },
    rangeSelector : {
        enabled: false
    },
    title: {
        text: 'Gráfica'
    },
    xAxis: {
        type: 'datetime'
        //tickPixelInterval: 150,
        //maxZoom: 20 * 1000
    },
    yAxis: {
        minPadding: 0.2,
        maxPadding: 0.2,
        title: {
            text: 'Valores',
            margin: 10
        }
    },
    series: [{
        name: 'valor',
        data: (function() {
                // generate an array of random data
                var data = [];
                <?php
                    for($i = 0 ;$i<count($rawdata);$i++){
                ?>
                data.push([<?php echo $timeArray[$i];?>,<?php echo $valoresArray[$i];?>]);
                <?php } ?>
                return data;
            })()
    }],
    credits: {
            enabled: false
    }
});

</script>   
</BODY>

</html>