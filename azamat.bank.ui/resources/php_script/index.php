<?php
if(isset($_GET['login'])){
	$login = $_GET['login'];
	$password = $_GET['password'];
	$getParameters = '?login='.$login.'&password='.$password;
	$url = 'http://localhost:8181/user/login'.$getParameters;
    $curl = curl_init();
	
    curl_setopt($curl, CURLOPT_URL, $url);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER,true);
    $out = curl_exec($curl);
	$json = json_decode($out, true);
	
	if ($json['authenticated'] == 'true')
	{
		header ('location: resources/views/search.php');
		$_SESSION['user_login'] = $json['userLogin'];
		curl_close($curl);
	}
	else{
		echo "Имя пользователя или пароль не правильный. Пожалуйста, попробуйте еще раз.";
		curl_close($curl);
	}
  
}
?>