<HTML>
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
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

        for ($i=1; $i<32; $i++){
            $dia[$i] = $i;
            $duracionDia[$i] = 0;
        }
        
        for($i = 0 ;$i<count($datTecnicasDia);$i++){
            $d = (int)$datTecnicasDia[$i][0];
            $dia[$i] = $datTecnicasDia[$i][0];
            $duracionDia[$d]= $datTecnicasDia[$i][1]; 
            /*
             * $d = (int) $datPlaneadoDia[$i][0];
            $dia[$i] = $datPlaneadoDia[$i][0];
            $duracionDia[$d]= $datPlaneadoDia[$i][1]; 
             */
        }
        
        for($i = 0 ;$i<count($datTecnicasMes);$i++){
            $mes[$i] = $datTecnicasMes[$i][0];
            $duracionMes[$i]= $datTecnicasMes[$i][1]; 
        }
    ?>
    
<BODY>
    <h1 ALIGN=center id="titulo">Paros Técnicos</h1>
    
    <!--------------GRAFICA----dia-------------->
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/pareto.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
    <div id = "graficasSuperiores">      
        <div aling = "center" id="mensual" class="arribaMes">
            <script>
                chartCPU = new Highcharts.chart('mensual', {
                title: {
                    text: 'Minutos con Falla por Mes'
                },
                xAxis: {
                    color: '#1A06AF',
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
                    color: '#2ECC71',
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
                    zIndex: 1,
                    //data: [5, 5, 5, 7, 5]
                    color: '#1A06AF',
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
        
        <div aling = "center" id="dia" class = "arribaDiaMes">
            <script>
                chartCPU = new Highcharts.chart('dia', {
                title: {
                    text: 'Minutos con Falla por Día'
                },
                xAxis: {
                    gridLineWidth: 1,
                    categories: (function() {
                            var data = [];
                            <?php
                                for($i = 1; $i < 32; $i++){
                            ?>
                            data.push([<?php echo $i;?>]);
                            <?php } ?>
                            return data;
                        })()
                },
                yAxis: [{
                }],
                series: [{ //LINEA CHUNDA
                    color: '#2ECC71', // color para la meta 
                }, { //BARRAS CHUNDAS
                    color: '#1A06AF',
                    name: 'Indicadores',
                    type: 'spline',
                   // type: 'spline',
                    zIndex: 1,
                    //data: [5, 5, 5, 7, 5]
                    data: (function() {
                            var data = [];
                            <?php
                                for($i = 1 ;$i < 32; $i++){
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
    
    <div id = "table-wrapper">
        <div id="table-scroll">
            <table class="pure-table pure-table-bordered" >
                <thead>     
                    <tr>
                        <th><span class="text">D&iacute;a</span></th>
                        <th><span class="text">&Aacute;rea</span></th>
                        <th><span class="text">Operaci&oacute;n</span></th>
                        <th><span class="text">Problema</span></th>
                        <th><span class="text">Duraci&oacute;n</span></th>
                    </tr>
                </thead>

                <tbody>        
                    <?php
                        require_once("control.php");

                        $rand = new BaseKPI();
                        $datTecnicasTabla = $rand->pTecnicasTabla();    
                        $diaT;       

                        for($i = 0; $i<count($datTecnicasTabla);$i++){
                            echo "<tr>";
                            for ($j = 0; $j<5; $j++){
                                $diaT[$i][$j] = $datTecnicasTabla[$i][$j];
                                echo "<td>";
                                    echo $diaT[$i][$j];
                                echo "</td>";
                            }
                            echo "</tr>";
                        }
                    ?>        
                </tbody> 
            </table>
        </div>
    </div>
    

</BODY>

</html>