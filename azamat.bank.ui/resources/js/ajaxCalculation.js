$(document).ready(function(){
		$("#amount").on('input', function(){
			var sendAmount = $("#amount").val();
			var sendDuration = $("#contractDuration").val();
			var sendRate = $("#rate").val();
					
			$.ajax({
				type: "POST",
				url: "../controller/CreditCalculationController.php", 
				data: "amount=" + sendAmount + "&contractDuration="+sendDuration + "&rate=" + sendRate,
				dataType: "json",
				success: function(msg, string, jqXHR){
					$("#monthlyAmount").val(msg.monthlyAmount);
					$("#totalAmountPayments").val(msg.totalAmountPayments);
					$("#overPayment").val(msg.overPayment);
				}
			})
				
		});
});