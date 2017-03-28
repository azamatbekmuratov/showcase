<?php
	$amount = $_REQUEST['amount'];
	$contractDuration = $_REQUEST['contractDuration'];
	$rate = $_REQUEST['rate'];

	$getParameters = '?amount='.$amount.'&contractDuration='.$contractDuration.'&rate='.$rate;
	$url = 'http://localhost:8181/credit/calculate'.$getParameters;
	$curl = curl_init();
	
	curl_setopt($curl, CURLOPT_URL, $url);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER,true);
    $out = curl_exec($curl);
	//$json = json_decode($out, true);
	//print_r($json);
	//echo $json['authenticated'];
	//echo $json['userLogin'];
	echo $out;


	// $list = array('username'=>$username, 'password'=>$password);

	// $c = json_encode($list);

	// echo $c;
	

?>