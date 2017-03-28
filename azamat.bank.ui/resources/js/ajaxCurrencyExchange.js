$(document).ready(function(){
		$("#amount").on('input', function(){
			var sendAmount = $("#amount").val();		
			$.ajax({
				type: "POST",
				url: "../controller/nationalBankCurrency.php", 
				data: "amount=" + sendAmount,
				dataType: "json",
				success: function(msg, string, jqXHR){
					$("#amountInUsd").val(sendAmount/msg.description);
				}
			})
				
		});
});