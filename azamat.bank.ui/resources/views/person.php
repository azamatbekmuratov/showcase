<?php include('../php_script/person.php') ?>
<!DOCTYPE html>
<html >
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Данные о клиенте</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="../css/normalize.css"/>
    <link rel="stylesheet" href="../css/style_main.css"/>   
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>
	<script src="//code.jquery.com/jquery-1.7.2.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script type="text/javascript" src="../js/validation.js"></script>
	<script src="../js/jquery.maskedinput.js"></script>
	<script>
	$(function() {
    $( ".datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  });
	</script>
  </head>
  <body>  
<div class="container">
  <div class="row header">
    <h1>Данные о клиенте &nbsp;</h1>
    <h3>Необходимо заполнить все поля </h3>
  </div>
  <div class="row body">
    <form name="form1" method="post" action="person.php">
      <ul>
        
        <li>
          <p class="left">
            <label for="iin">ИНН <span class="req">*</span></label>
            <input type="text" name="iin" required pattern="^[0-9]{12}$" id="iin" placeholder="ИНН" />
          </p>
        </li>
        <li>
          <p>
            <label for="lastName">Фамилия <span class="req">*</span></label>
            <input type="text" name="lastName" required pattern="^([^0-9]*)$" id="lastName" placeholder="Фамилия" />
          </p>
        </li> 
		<li>
          <p>
            <label for="firstName">Имя <span class="req">*</span></label>
            <input type="text" name="firstName" required="" id="firstName" placeholder="Имя" />
          </p>
        </li>
		<li>
          <p>
            <label for="middleName">Отчество <span class="req">*</span></label>
            <input type="text" name="middleName" required="" id="middleName" placeholder="Отчество" />
          </p>
        </li>
		<li>
          <p>
            <label for="phoneNumber">Мобильный телефон <span class="req">*</span></label>
            <input type="text" name="phoneNumber" required="" id="phoneNumber" placeholder="Мобильный телефон" />
          </p>
        </li>
		<li>
          <p>
            <label for="birthDate">Дата рождения <span class="req">*</span></label>
            <input type="text" class="datepicker" required="" name="birthDate" id="birthDate" placeholder="Дата рождения" />
          </p>
        </li>
		<li>
          <p>
            <label for="gender">Пол <span class="req">*</span></label>
				<select type="text" id="gender" name="gender">                      
					<option value="Мужской">Мужской</option>
					<option value="Женский">Женский</option>
					</select>
          </p>
        </li>
		<li><div class="divider"></div></li>
		<li>
          <p>
            <label for="docNumber">Номер документа <span class="req">*</span></label>
            <input type="text" name="docNumber" required="" id="docNumber" placeholder="Номер документа" />
          </p>
        </li>
		<li>
          <p>
            <label for="placeOfIssue">Кем выдан <span class="req">*</span></label>
            <input type="text" name="placeOfIssue" required="" id="placeOfIssue" placeholder="Кем выдан" />
          </p>
        </li>
		<li>
          <p>
            <label for="dateOfIssue">Дата выдачи <span class="req">*</span></label>
            <input type="text" class="datepicker" required="" name="dateOfIssue" id="dateOfIssue" placeholder="Дата выдачи" />
          </p>
        </li>
		<li>
          <p>
            <label for="validDate">Действителен до <span class="req">*</span></label>
            <input type="text" class="datepicker" required="" name="validDate" id="validDate" placeholder="Действителен до" />
          </p>
        </li>
		<li>
          <p>
            <label for="salaryAmount">Заработная плата <span class="req">*</span></label>
            <input type="text" name="salaryAmount" required="" id="salaryAmount" placeholder="Заработная плата" />
          </p>
        </li>
		<li>
          <p>
            <label for="expenses">Коммунальные платежи, аренда <span class="req">*</span></label>
            <input type="text" name="expenses" required="" id="expenses" placeholder="Коммунальные платежи, аренда" />
          </p>
        </li>	
        <li><div class="divider"></div></li>        
        <li>
          <input class="btn btn-submit" name="submit" type="submit" value="ПОДТВЕРДИТЬ" />
        </li>
        
      </ul>
    </form>  
  </div>
</div>
<script>
$("#phoneNumber").mask("+7 (999) 999-99-99");
$("#phoneNumber").on("blur", function() {
    var last = $(this).val().substr( $(this).val().indexOf("-") + 1 );
    
    if( last.length == 3 ) {
        var move = $(this).val().substr( $(this).val().indexOf("-") - 1, 1 );
        var lastfour = move + last;
        
        var first = $(this).val().substr( 0, 9 );
        
        $(this).val( first + '-' + lastfour );
    }
});
</script>    
  </body>
</html>