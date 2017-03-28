<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Вход для пользователя</title>
    <link rel="stylesheet" href="../css/style.css">
  </head>

  <body>

    <body>
<div class="container">
	<section id="content">
		<form name="form1" method="get" action="login.php">
			<h1>Вход для пользователя</h1>
			<div>
				<input type="text" placeholder="ЛОГИН" required="" id="login" />
			</div>
			<div>
				<input type="password" placeholder="ПАРОЛЬ" required="" id="password" />
			</div>
			<div>
				<input type="submit" value="ВОЙТИ" />
			</div>
		</form><!-- form -->
	</section><!-- content -->
</div><!-- container -->
</body>
    
  </body>
</html>
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
	//print_r($json);
	//echo $json['authenticated'];
	//echo $json['userLogin'];
	//echo $out;
	
	if ($json['authenticated'] == 'true')
	{
		header ('location: resources/views/index.php');
		$_SESSION['user_login'] = $json['userLogin'];
		curl_close($curl);
	}
	else{
		echo "Имя пользователя или пароль не правильный. Пожалуйста, попробуйте еще раз.";
		curl_close($curl);
	}
  
}
?>