<HTML>
    <head>
        <LINK REL=StyleSheet HREF="estilo.css" TYPE="text/css" MEDIA=screen>
        <meta charset="utf-8">
        <!--------CONSULTAS------------->
        <?php
//            require_once("control.php");
//
//            $rand = new BaseKPI();
//
//            $datProdDiaMes = $rand->pzasProdDiaMes();
//            $datProdMes = $rand->pzasProdMes();
//            $datProdAnio = $rand->pzasProdAnual();    
//
//            $dia;
//            $mes;
//            $anio;
//            $prodDiaMes;
//            $prodMes;
//            $prodAnio;   
//
//            for($i = 0 ;$i<count($datProdAnio);$i++){
//                $anio[$i] = $datProdAnio[$i][0];
//                $prodAnio[$i]= $datProdAnio[$i][1]; 
//            }
//
//            for($i = 0 ;$i<count($datProdDiaMes);$i++){
//                $dia[$i] = $datProdDiaMes[$i][0];
//                $prodDiaMes[$i]= $datProdDiaMes[$i][1]; 
//            }
//
//            for($i = 0 ;$i<count($datProdMes);$i++){
//                $mes[$i] = $datProdMes[$i][0];
//                $prodMes[$i]= $datProdMes[$i][1]; 
//            }
        ?>
    </head>
    
<BODY>
    <h1 ALIGN=center id="titulo">Entregas</h1>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>

    <div id="container" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto">
        <script>
            chartCPU = new Highcharts.chart('container', {
                chart: {
                    zoomType: 'xy'
                },
                title: {
                    text: 'Entregas Diarias'
                },                
                xAxis: [{
                        gridLineWidth: 1,
                    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                        'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                    crosshair: true
                }],
                yAxis: [{ // Primary yAxis
                    labels: {
                        format: '{value} pzas',
                        style: {
                            color: Highcharts.getOptions().colors[1]
                        }
                    },
                    title: {
                        text: 'Cantidad Acumulada',
                        style: {
                            color: Highcharts.getOptions().colors[1]
                        }
                    },
                    opposite: true

                }, { // Secondary yAxis
                    gridLineWidth: 0,
                    title: {
                        text: 'Piezas',
                        style: {
                            color: Highcharts.getOptions().colors[1]
                        }
                    },
                    labels: {
                        format: '{value} pzas',
                        style: {
                            color: Highcharts.getOptions().colors[1]
                        }
                    }
                }, { visible: false}],
                tooltip: {
                    shared: true
                },
                legend: {
                    layout: 'vertical',
                    align: 'left',
                    x: 80,
                    verticalAlign: 'top',
                    y: 55,
                    floating: true,
                    backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
                },
                series: [{
                    name: 'Produccion Actual (Día)',
                    type: 'column',
                    yAxis: 1,
                    data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4],
                    tooltip: {
                        valueSuffix: ' pzas'
                    }

                }, {
                    name: 'Acumulado Planeado',
                    type: 'spline',
                    yAxis: 2,
                    data: [1016, 1016, 1015.9, 1015.5, 1012.3, 1009.5, 1009.6, 1010.2, 1013.1, 1016.9, 1018.2, 1016.7],
                    marker: {
                        enabled: false
                    },
                    dashStyle: 'shortdot',
                    tooltip: {
                        valueSuffix: ' mb'
                    }

                }, {
                    name: 'Acumulado Real',
                    type: 'spline',
                    data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6],
                    tooltip: {
                        valueSuffix: ' °C'
                    }
                   }]
            });

        </script>            
    </div>
</BODY>

</html>