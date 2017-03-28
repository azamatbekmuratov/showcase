<?php

if(isset($_POST['amount'])){
	//clean your posts here
	$iin = $_POST['iin'];
	$amount = $_POST['amount'];
	$contractDuration = $_POST['contractDuration'];
	$rate = $_POST['rate'];
	$monthlyAmount = $_POST['monthlyAmount'];
	$amountInUsd = $_POST['amountInUsd'];
	$totalAmountPayments = $_POST['totalAmountPayments'];
	$overPayment = $_POST['overPayment'];
	
	$data = array("iin" => $iin, "amount" => $amount, "contractDuration" => $contractDuration, "rate" => $rate, "monthlyAmount" => $monthlyAmount, "amountInUsd" => $amountInUsd, "totalAmountPayments" => $totalAmountPayments, "overPayment" => $overPayment); 
	$data_application = array("iin" => $iin, "amount" => $amount, "contractDuration" => $contractDuration, "contractStatus" => "approved"); 
	$post_string = json_encode($data);
	$post_string_application = json_encode($data_application);
	$url = "http://localhost:8181/credit";
	$url_application = "http://localhost:8181/application";
	
	echo $post_string_application;
	
	$ch = curl_init();
	curl_setopt($ch, CURLOPT_URL, $url);
	curl_setopt($ch, CURLOPT_POST, true);
	curl_setopt($ch, CURLOPT_POSTFIELDS, $post_string);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	curl_setopt($ch, CURLOPT_HTTPHEADER, array(                                                                          
    'Content-Type: application/json',                                                                                
    'Content-Length: ' . strlen($post_string)));  
	$response = curl_exec($ch);
	curl_close($ch);
	echo $response;
	
	$ch_application = curl_init();
	curl_setopt($ch_application, CURLOPT_URL, $url_application);
	curl_setopt($ch_application, CURLOPT_POST, true);
	curl_setopt($ch_application, CURLOPT_POSTFIELDS, $post_string_application);
	curl_setopt($ch_application, CURLOPT_RETURNTRANSFER, true);
	curl_setopt($ch_application, CURLOPT_HTTPHEADER, array(                                                                          
    'Content-Type: application/json',                                                                                
    'Content-Length: ' . strlen($post_string_application)));  
	$response_application = curl_exec($ch_application);
	curl_close($ch_application);
	echo $response_application;
	
	  if(isset($response)){
		header ('location: result.php');
	  }
}

?>