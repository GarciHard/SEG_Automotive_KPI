<HTML>
    <LINK REL=StyleSheet HREF="estilo.css" TYPE="text/css" MEDIA=screen>
<BODY>
<meta charset="utf-8">

<!--------CONSULTAS------------->
<?php
require_once("control.php");

$rand = new BaseKPI();
$datProdAnio = $rand->pzasProdAnual();

$prodLimiteAnio;
$prodAnio;

for($i = 0 ;$i<count($datProdAnio);$i++){
    $prodAnio[$i] = $datProdAnio[$i][0];
    $prodLimiteAnio[$i]= $datProdAnio[$i][1]; 
}
?>
    
<!--------------GRAFICA------------------>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/pareto.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
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
                    for($i = 0 ;$i<count($datProdAnio);$i++){
                ?>
                data.push([<?php echo $prodAnio[$i];?>]);
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
                    for($i = 0 ;$i<count($datProdAnio);$i++){
                ?>
                data.push([<?php echo $prodLimiteAnio[$i];?>]);
                <?php } ?>
                return data;
            })()
    }, { //BARRAS CHUNDAS
        name: 'Indicadores',
        type: 'column',
        zIndex: 1,
        //data: [5, 5, 5, 7, 5]
        data: (function() {
                var data = [];
                <?php
                    for($i = 0 ;$i<count($datProdAnio);$i++){
                ?>
                data.push([<?php echo $prodLimiteAnio[$i];?>]);
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