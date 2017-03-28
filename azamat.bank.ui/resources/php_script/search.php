<?php
if(isset($_GET['iin'])){
	$iin = $_GET['iin'];
	$getParameters = '?iin='.$iin;
	$url = 'http://localhost:8181/application'.$getParameters;
    $curl = curl_init();
	
    curl_setopt($curl, CURLsOPT_URL, $url);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER,true);
    $out = curl_exec($curl);
	$json = json_decode($out, true);
	$return = 'no application found';
	//print_r($json);
	if(empty($json)){
		header ('location: person.php');
	}
	curl_close($curl);
	
	echo "<table border='1' style='width:70%; margin: auto; margin-top: 5em; margin-bottom: 5em;'>";
	echo '<tr><th>Номер заявки</th><th>ИИН</th><th>Сумма</th><th>Срок</th><th>Статус</th></tr>';
    $n = 0;
		foreach ($json as $key => $value) {
			echo '<tr>';
			echo '<td>'.$json[$n]['id'].'</td>';
			echo '<td>'.$json[$n]['iin'].'</td>';
			echo '<td>'.$json[$n]['amount'].'</td>';
			echo '<td>'.$json[$n]['contractDuration'].'</td>';
			echo '<td>'.$json[$n]['contractStatus'].'</td>';
			echo '</tr>';
			$n++;
		} 

	echo "</table>";

	echo '<a href="credit.php" >Новая заявка</a>';
}
?>