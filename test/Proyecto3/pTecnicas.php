<HTML>
    <LINK REL=StyleSheet HREF="estilo.css" TYPE="text/css" MEDIA=screen>
    <meta charset="utf-8">
    <!--------CONSULTAS------------->
    <?php
        require_once("control.php");

        $rand = new BaseKPI();

        $datTecnicasDia = $rand->pTecnicasDia();
        $datTecnicasMes = $rand->pTecnicasMes();    

        $dia;
        $mes;
        $duracionDia;
        $duracionMes;          

        for($i = 0 ;$i<count($datTecnicasDia);$i++){
            $dia[$i] = $datTecnicasDia[$i][0];
            $duracionDia[$i]= $datTecnicasDia[$i][1]; 
        }
        
        for($i = 0 ;$i<count($datTecnicasMes);$i++){
            $mes[$i] = $datTecnicasMes[$i][0];
            $duracionMes[$i]= $datTecnicasMes[$i][1]; 
        }
    ?>
    
<BODY>
    <h1 ALIGN=center id="titulo">PAROS TECNICOS</h1>
    
    <!--------------GRAFICA----dia-------------->
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/pareto.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
    <div id = "graficasSuperiores">      
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
                                for($i = 0 ;$i<count($datTecnicasMes);$i++){
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
                                for($i = 0 ;$i<count($datTecnicasMes);$i++){
                            ?>
                            data.push([<?php echo $duracionMes[$i];?>]);
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
                                for($i = 0 ;$i<count($datTecnicasMes);$i++){
                            ?>
                            data.push([<?php echo $duracionMes[$i];?>]);
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
        
        <div aling = "center" id="dia" class = "contenedor">
            <script>
                chartCPU = new Highcharts.chart('dia', {
                title: {
                    text: 'Día Mes'
                },
                xAxis: {
                    categories: (function() {
                            var data = [];
                            <?php
                                for($i = 0 ;$i<count($datTecnicasDia);$i++){
                            ?>
                            data.push([<?php echo $dia[$i];?>]);
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
                                for($i = 0 ;$i<count($datTecnicasDia);$i++){
                            ?>
                            data.push([<?php echo $duracionDia[$i];?>]);
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
                                for($i = 0 ;$i<count($datTecnicasDia);$i++){
                            ?>
                            data.push([<?php echo $duracionDia[$i];?>]);
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
        
    </div>

</BODY>

</html>