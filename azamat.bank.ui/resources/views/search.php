<?php include('../php_script/search.php') ?>
<!DOCTYPE html>
<html >
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<style>
		table, th , td {
			border: 1px solid grey;
			border-collapse: collapse;
			padding: 5px;
		}
		table tr:nth-child(odd) {
			background-color: #f1f1f1;
		}
		table tr:nth-child(even) {
			background-color: #ffffff;
		}
	</style>
	</meta>
    <title>Поиск заявок</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="../css/normalize.css"/>
    <link rel="stylesheet" href="../css/style_main.css"/> 
	<script type="text/javascript" src="../js/validation.js"></script>	
  </head>
  <body>  
<div class="container">
  <div class="row header">
    <h1>Поиск заявок &nbsp;</h1>
    <h3>Укажите ИНН субъекта </h3>
  </div>
  <div class="row body">
    <form name="form1" method="get" action="search.php">
      <ul>
        
        <li>
          <p class="left">
            <input type="text" name="iin" id="iin" required pattern="^[0-9]{12}$" placeholder="ИНН" />
			<input class="btn btn-submit right" name="submit" type="submit" value="ПОИСК" />
          </p>
        </li>        
      </ul>
    </form>  
  </div>
</div>
  </body>
</html>