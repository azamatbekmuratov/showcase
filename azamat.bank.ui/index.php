<?php include('resources/php_script/index.php') ?>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Вход для пользователя</title>
    <link rel="stylesheet" href="resources/css/style.css">
  </head>
  <body>
	<div class="container">
		<section id="content">
			<form name="form1" method="get" action="index.php">
				<h1>Вход для пользователя</h1>
				<div>
					<input type="text" name="login" placeholder="ЛОГИН" required="" id="login" />
				</div>
				<div>
					<input type="password" name="password" placeholder="ПАРОЛЬ" required="" id="password" />
				</div>
				<div>
					<input type="submit" value="ВОЙТИ" />
				</div>
			</form>
		</section>
	</div>
  </body>
</html>