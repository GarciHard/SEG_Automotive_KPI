<HTML>
    <HEAD>
        
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
        <meta charset="utf-8">
        <!--------CONSULTAS------------->
        
    </HEAD>
    <BODY>
    
    <div>
    <table class="pure-table pure-table-bordered">
    <thead>
        <tr>
            <th>D&iacute;a</th>
            <th>&Aacute;rea</th>
            <th>Operaci&oacute;n</th>
            <th>Problema</th>
            <th>Duraci&oacute;n</th>
        </tr>
    </thead>

    <tbody>
        
        <?php
            require_once("control.php");

            $rand = new BaseKPI();
            $datTecnicasTabla = $rand->pTecnicasTabla();    
            $dia;       
            
            for($i = 0; $i<count($datTecnicasTabla);$i++){
                echo "<tr>";
                for ($j = 0; $j<5; $j++){
                    $dia[$i][$j] = $datTecnicasTabla[$i][$j];
                    echo "<td>";
                        echo $dia[$i][$j];
                    echo "</td>";
                }
                echo "</tr>";
            }
        ?>        
    </tbody>
    
    </div>
</table>
    </BODY>
</HTML>
