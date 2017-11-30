<HTML>
    <head>
        <LINK REL=StyleSheet HREF="estilo.css" TYPE="text/css" MEDIA=screen>
        <meta charset="utf-8">
        <!--------CONSULTAS------------->
        <?php
            require_once("control.php");

            $rand = new BaseKPI();

            $datScrapDia = $rand->scrapDiaMes();
            $datScrapMes = $rand->scrapMes();
            $datScrapAnio = $rand->scrapAnual();    

            $dia;
            $mes;
            $anio;
            $prodDiaMes;
            $prodMes;
            $prodAnio;   

            for($i = 0 ;$i<count($datScrapAnio);$i++){
                $anio[$i] = $datScrapAnio[$i][0];
                $prodAnio[$i]= $datScrapAnio[$i][1]; 
            }

            for($i = 0 ;$i<count($datScrapDia);$i++){
                $dia[$i] = $datScrapDia[$i][0];
                $prodDiaMes[$i]= $datScrapDia[$i][1]; 
            }

            for($i = 0 ;$i<count($datScrapMes);$i++){
                $mes[$i] = $datScrapMes[$i][0];
                $prodMes[$i]= $datScrapMes[$i][1]; 
            }
        ?>
    </head>
    
<BODY>
    <h1 ALIGN=center id="titulo">Piezas Producidas</h1>
    
    <!--------------GRAFICA----dia-------------->
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/pareto.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
    <div id = "graficasSuperiores">
        <div aling = "center" id="anual" class="contenedor">
            <script>
                chartCPU = new Highcharts.chart('anual', {
                title: {
                    text: 'Piezas Producidas por Año'
                },
                xAxis: {
                    categories: (function() {
                            var data = [];
                            <?php
                                for($i = 0 ;$i<count($datScrapAnio);$i++){
                            ?>
                            data.push([<?php echo $anio[$i];?>]);
                            <?php } ?>
                            return data;
                        })()
                },
                yAxis: [{
                    //color: 'black'
                    lineColor: '#FF0000'
                    ,lineWidth: 1
                }],
                series: [{ //LINEA CHUNDA
                    type: 'spline',
                    name: 'Meta',
                    yAxis: 0,
                    zIndex: 0,
                    data: (function() {
                            var data = [];
                            <?php
                                for($i = 0 ;$i<count($datScrapAnio);$i++){
                            ?>
                            data.push([<?php echo $prodAnio[$i];?>]);
                            <?php } ?>
                            return data;
                        })()
                }, { //BARRAS CHUNDAS
                    name: 'Indicadores',
                    type: 'column',
                    zIndex: 1,
                    data: (function() {
                            var data = [];
                            <?php
                                for($i = 0 ;$i<count($datScrapAnio);$i++){
                            ?>
                            data.push([<?php echo $prodAnio[$i];?>]);
                            <?php } ?>
                            return data;
                        })()
                }],
                credits: {
                        enabled: false
                },
                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                layout: 'horizontal',
                                align: 'center',
                                verticalAlign: 'bottom'
                            }
                        }
                    }]
                }                
            });
            </script> 
        </div>
        
        <div aling = "center" id="mensual" class="contenedor">
            <script>
                chartCPU = new Highcharts.chart('mensual', {
                title: {
                    text: 'Piezas Producidas por Mes '
                },
                xAxis: {
                    categories: (function() {
                            var data = [];
                            <?php
                                for($i = 0 ;$i<count($datScrapMes);$i++){
                            ?>
                            data.push([<?php echo $mes[$i];?>]);
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
                                for($i = 0 ;$i<count($datScrapMes);$i++){
                            ?>
                            data.push([<?php echo $prodMes[$i];?>]);
                            <?php } ?>
                            return data;
                        })()
                }, { //BARRAS CHUNDAS
                    name: 'Indicadores',
                    type: 'column',
                   // type: 'spline',
                    zIndex: 1,
                    //data: [5, 5, 5, 7, 5]
                    data: (function() {
                            var data = [];
                            <?php
                                for($i = 0 ;$i<count($datScrapMes);$i++){
                            ?>
                            data.push([<?php echo $prodMes[$i];?>]);
                            <?php } ?>
                            return data;
                        })()
                }],
                credits: {
                        enabled: false
                },
                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                layout: 'horizontal',
                                align: 'center',
                                verticalAlign: 'bottom'
                            }
                        }
                    }]
                }                
            });
            </script> 
        </div>
    </div>
    
    <div id="graficaGrande">
        <div aling = "center" id="dia" class = "contenedor2">
            <script>
                chartCPU = new Highcharts.chart('dia', {
                chart: {
                  type: 'scatter'  
                },
                title: {
                    text: 'Día Mes'
                },
                xAxis: {
                    gridLineWidth: 1,
                    categories: (function() {
                            var data = [];
                            <?php
                                for($i = 0 ;$i<count($datScrapDia);$i++){
                            ?>
                            data.push([<?php echo $dia[$i];?>]);
                            <?php } ?>
                            return data;
                        })()
                },
                yAxis: [{
                    //stroke-width: 2px;
                    //stroke: #d8d8d8;
                }],
                series: [{ //LINEA CHUNDA
                    type: 'spline',
                    name: 'Meta',
                    yAxis: 0,
                    zIndex: 0,
                    data: (function() {
                            var data = [];
                            <?php
                                for($i = 0 ;$i<count($datScrapDia);$i++){
                            ?>
                            data.push([<?php echo $prodDiaMes[$i];?>]);
                            <?php } ?>
                            return data;
                        })()
                }, { //BARRAS CHUNDAS
                    name: 'Indicadores',
                    type: 'column',
                    zIndex: 1,
                    data: (function() {
                            var data = [];
                            <?php
                                for($i = 0 ;$i<count($datScrapDia);$i++){
                            ?>
                            data.push([<?php echo $prodDiaMes[$i];?>]);
                            
                            <?php } ?>
                            return data;
                            
                        })()
                     
                }],
                credits: {
                        enabled: false
                },
                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                layout: 'horizontal',
                                align: 'center',
                                verticalAlign: 'bottom'
                            }
                        }
                    }]
                }
            });

            </script> 
        </div>
    </div>
    
    <div id="tabla">
        
    </div>

</BODY>

</html>