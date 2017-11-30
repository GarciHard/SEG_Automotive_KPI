<HTML>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
        <LINK REL=StyleSheet HREF="estilo.css" TYPE="text/css" MEDIA=screen>
            <meta charset="utf-8">
            <!--------CONSULTAS------------->
            <?php
            require_once("control.php");

            $rand = new BaseKPI();

            $dattop5 = $rand->t5TecnicasYOrganizacionales();
            $dattop1 = $rand->t1pareto();
            $dattop3 = $rand->t3Calidad();
            
            $operacionTecOrg;
            $opTecOrg;
            $problemaTecOrg;
            $durTecOrg;
            
            $cambio;
            $cam;
            $durCambio;
            
            $problemaCalidad;
            $operacionCalidad;
            $opCalidad;
            $durCalidad;
            
            for($i = 0 ;$i<count($dattop5);$i++){
                $operacionTecOrg[$i] = $dattop5[$i][0];
                $op[$i] = (string) $operacionTecOrg[$i]; //cambio de valor para imprimir operacionTecOrg
                $durTecOrg[$i]= $dattop5[$i][2]; 
            }
            
            for($i = 0 ;$i<count($dattop1);$i++){
                $cambio[$i] = $dattop1[$i][0];
                $cam[$i] = (string) $cambio[$i]; //cambio de valor para imprimir operacionTecOrg
                $durCambio[$i]= $dattop1[$i][2]; 
            }
            
            for($i = 0 ;$i<count($dattop3);$i++){
                $operacionCalidad[$i] = $dattop3[$i][0];
                $opCalidad[$i] = (string) $operacionCalidad[$i]; //cambio de valor para imprimir operacionTecOrg
                $durCalidad[$i]= $dattop3[$i][2]; 
            }
            
        ?>
    </head>
    
    <body>
        
        <h1 ALIGN=center id="titulo">Pareto TOP</h1>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>

            <div aling = "center" id="ptto" style="height: 70vh; width: 85vh; float: left;  margin: 0% 3%;"> 
                <script>
                    chartCPU = new  Highcharts.chart('ptto', {
                    chart: {
                        type: 'bar'
                    },
                    title: {
                        text: 'TOP 5: Tecnicos y Organizacionales'
                    },
                    xAxis: {
                        gridLineWidth: 1,
                        categories: (function() {
                                var data = [];
                                <?php
                                    for($i = 0 ;$i<count($dattop5);$i++){
                                ?>
                                data.push([<?php echo $op[$i];?>]);
                                <?php } ?>
                                return data;
                            })()
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Duracion (minutos)'
                        }
                    },
                    legend: {
                        reversed: true
                    },
                    plotOptions: {
                        series: {
                            stacking: 'normal'
                        }
                    },
                    series: [{
                        name: 'Incidencia',
                        data: (function() {
                                var data = [];
                                <?php
                                    for($i = 0 ;$i<count($dattop5);$i++){
                                ?>
                                data.push([<?php echo $durTecOrg[$i];?>]);
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
        
        <div aling = "center" id="derecha" class="pderecha">
            <div aling = "center"  id="ptcm" style="height: 30vh; width: 85vh; float: left;  margin: 0% 3%;">  
                <script>
                    chartCPU = new  Highcharts.chart('ptcm', {
                    chart: {
                        type: 'bar'
                    },
                    title: {
                        text: 'Top 1: Cambio de Modelo'
                    },
                    xAxis: {
                        gridLineWidth: 1,
                        categories: ['A']
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Duracion (minutos)'
                        }
                    },
                    legend: {
                        reversed: true
                    },
                    plotOptions: {
                        series: {
                            stacking: 'normal'
                        }
                    },
                    series: [{
                        name: 'Incidencia',
                        data: (function() {
                                var data = [];
                                <?php
                                    for($i = 0 ;$i<count($dattop1);$i++){
                                ?>
                                data.push([<?php echo $durCambio[$i];?>]);
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

            <div aling = "center" id="ptc" style="height: 40vh; width: 85vh; float: left;  margin: 0% 3%;">
                <script>
                chartCPU = new  Highcharts.chart('ptc', {
                chart: {
                    type: 'bar'
                },
                title: {
                    text: 'Top 3: Calidad'
                },
                xAxis: {
                    gridLineWidth: 1,
                    categories: (function() {
                                var data = [];
                                <?php
                                    for($i = 0 ;$i<count($dattop3);$i++){
                                ?>
                                data.push([<?php echo $opCalidad[$i];?>]);
                                <?php } ?>
                                return data;
                            })()
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Duracion (minutos)'
                    }
                },
                legend: {
                    reversed: true
                },
                plotOptions: {
                    series: {
                        stacking: 'normal'
                    }
                },
                series: [{
                    name: 'Incidencia',
                    data: (function() {
                            var data = [];
                            <?php
                                for($i = 0 ;$i<count($dattop3);$i++){
                            ?>
                            data.push([<?php echo $durCalidad[$i];?>]);
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
        
        <div id = "table-wrapperP">
        <div id="table-scrollP">
            <table class="pure-table pure-table-borderedP" >
                <thead>     
                    <tr>
                        <th><span class="textP">Oper&iacute;acion</span></th>
                        <th><span class="textP">Pro&Aacute;lema</span></th>
                        <th><span class="textP">Duracio&oacute;n</span></th>
                        
                    </tr>
                </thead>

                <tbody>        
                    <?php
                        require_once("control.php");

                        $rand = new BaseKPI();
                        $datTop5pareto = $rand->t5TecnicasYOrganizacionales();    
                        $descripcion;       

                        for($i = 0; $i<count($datTop5pareto);$i++){
                            echo "<tr>";
                            for ($j = 0; $j<3; $j++){
                                $descripcion[$i][$j] = $datTop5pareto[$i][$j];
                                echo "<td>";
                                    echo $descripcion[$i][$j];
                                echo "</td>";
                            }
                            echo "</tr>";
                        }
                    ?>        
                </tbody> 
            </table>
        </div>
        
    </body>
</html>
