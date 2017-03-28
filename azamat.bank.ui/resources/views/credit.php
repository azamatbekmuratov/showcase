<?php include('../php_script/credit.php') ?>
<!DOCTYPE html>
<html >
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Данные о кредите:</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../css/style_main.css"> 
	<script src="//code.jquery.com/jquery-1.7.2.min.js"></script>	
	<script src="../js/jquery.maskedinput.js"></script>
	<script src="../js/ajaxCalculation.js"></script>
	<script src="../js/ajaxCurrencyExchange.js"></script>
	
  </head>
  <body>  
<div class="container">
  <div class="row header">
    <h1>Данные о кредите &nbsp;</h1>
    <h3>Необходимо заполнить все поля </h3>
  </div>
  <div class="row body">
    <form name="form1" method="post" action="credit.php">
      <ul>
        
        <li>
          <p class="left">
            <label for="iin">ИНН <span class="req">*</span></label>
            <input type="text" name="iin" required="" id="iin" placeholder="ИНН" />
          </p>
        </li>
        
        <li>
          <p>
            <label for="amount">Сумма <span class="req">*</span></label>
            <input type="text" name="amount" required="" id="amount" placeholder="Сумма" />
          </p>
        </li> 
        <li>
          <p>
            <label for="contractDuration">Срок <span class="req">*</span></label>
			<select type="text" id="contractDuration" name="contractDuration">                      
					<option value="3">3 месяца</option>
					<option value="6">6 месяцев</option>
					<option value="9">9 месяцев</option>
					<option value="11">11 месяцев</option>
					<option value="13">13 месяцев</option>
					<option value="16">16 месяцев</option>
					<option value="19">19 месяцев</option>
					<option value="21">21 месяцев</option>
					<option value="23">23 месяцев</option>
					<option value="26">26 месяцев</option>
					</select>
          </p>
        </li>		
		<li>
          <p>
            <label for="firstName">Ставка <span class="req">*</span></label>
            		<select type="text" id="rate" name="rate">                      
					<option value="9">9%</option>
					<option value="10">10%</option>
					<option value="11">11%</option>
					</select>
          </p>
        </li>
		<li><div class="divider"></div></li> 
		<li>
          <p>
            <label for="monthlyAmount">Еж.платеж <span class="req">*</span></label>
            <input type="text" name="monthlyAmount" required="" id="monthlyAmount" placeholder="Еж.платеж" />
          </p>
        </li>
		<li>
          <p>
            <label for="amountInUsd">Сумма в $ <span class="req">*</span></label>
            <input type="text" name="amountInUsd" required="" id="amountInUsd" placeholder="Сумма в $" />
          </p>
        </li>
		<li>
          <p>
            <label for="totalAmountPayments">Общая сумма выплат <span class="req">*</span></label>
            <input type="text" name="totalAmountPayments" required="" id="totalAmountPayments" placeholder="Общая сумма выплат" />
          </p>
        </li>
		<li>
          <p>
            <label for="overPayment">Переплата <span class="req">*</span></label>
            <input type="text" name="overPayment" required="" id="overPayment" placeholder="Переплата" />
          </p>
        </li>       
        <li>
          <input class="btn btn-submit" name="submit" type="submit" value="ПОДТВЕРДИТЬ" />
        </li>
        
      </ul>
    </form>  
  </div>
</div>   
  </body>
</html>