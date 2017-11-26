<HTML>
    <LINK REL=StyleSheet HREF="estilo.css" TYPE="text/css" MEDIA=screen>
<BODY>
<meta charset="utf-8">

<!--------CONSULTAS------------->
<?php
require_once("control.php");

//Creamos un objeto de la clase randomTable
$rand = new BaseKPI();
//obtenemos toda la información de la tabla random
$rawdata = $rand->getAllInfo();

$valoresArray;
$timeArray;
//en un bucle for obtenemos en cada iteración el valor númerico y 
//el TIMESTAMP del tiempo y lo almacenamos en los arrays 
for($i = 0 ;$i<count($rawdata);$i++){
    $time= $rawdata[$i][0];
    $date = new DateTime($time);
    //ALMACENAMOS EL TIMESTAMP EN EL ARRAY
    $timeArray[$i] = $date->getTimestamp()*1000;
    
    $valoresArray[$i]= $rawdata[$i][1]; //los puntos
    //OBTENEMOS EL TIMESTAMP 
}
?>
    
<!--------------GRAFICA------------------>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/pareto.js"></script>
<div id="anual"></div>
<script>
    chartCPU = new Highcharts.chart('anual', {
    title: {
        text: 'Amanos Raúl'
    },
    xAxis: {
        categories: (function() {
                var data = [];
                <?php
                    for($i = 0 ;$i<count($rawdata);$i++){
                ?>
                data.push([<?php echo $timeArray[$i];?>]);
                <?php } ?>
                return data;
            })()
    },
    yAxis: [{
    }],
    series: [{ //LINEA CHUNDA
        type: 'spline',
        name: 'Meta',
        yAxis: 0,
        zIndex: 0,
        data: (function() {
                var data = [];
                <?php
                    for($i = 0 ;$i<count($rawdata);$i++){
                ?>
                data.push([<?php echo $valoresArray[$i];?>]);
                <?php } ?>
                return data;
            })()
    }, { //BARRAS CHUNDAS
        name: 'Indicadores',
        type: 'column',
        zIndex: 1,
        data: [5, 5, 5, 7, 5]
    }]
});
</script>

</BODY>

</html>