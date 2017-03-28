<?php
if(isset($_POST['iin'])){
	//clean your posts here
	$iin = $_POST['iin'];
	$lastName = $_POST['lastName'];
	$firstName = $_POST['firstName'];
	$middleName = $_POST['middleName'];
	$phoneNumber = $_POST['phoneNumber'];
	$birthDate = $_POST['birthDate'];
	$gender = $_POST['gender'];
	$docNumber = $_POST['docNumber'];
	$placeOfIssue = $_POST['placeOfIssue'];
	$dateOfIssue = $_POST['dateOfIssue'];
	$validDate = $_POST['validDate'];
	$salaryAmount = $_POST['salaryAmount'];
	$expenses = $_POST['expenses'];
	
	$data = array("iin" => $iin, "firstName" => $firstName, "lastName" => $lastName, "middleName" => $middleName, "phoneNumber" => $phoneNumber, "birthDate" => $birthDate, "gender" => $gender, "docNumber" => $docNumber, "placeOfIssue" => $placeOfIssue, "dateOfIssue" => $dateOfIssue, "validDate" => $validDate, "salaryAmount" => $salaryAmount, "expenses" => $expenses); 
	$post_string = json_encode($data);
	$url = "http://localhost:8181/person";
	echo $post_string;
	
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
	//echo $response;
	
	 if(isset($response)){
		 header ('location: credit.php');
	 }
}
?>