$(document).ready(function(){
$("#iin").mask("999999999999");
	$("#iin").on("blur", function() {
		var last = $(this).val().substr( $(this).val().indexOf("-") + 1 );
		
		if( last.length == 3 ) {
			var move = $(this).val().substr( $(this).val().indexOf("-") - 1, 1 );
			var lastfour = move + last;
			
			var first = $(this).val().substr( 0, 9 );
			
			$(this).val( first + '-' + lastfour );
		}
	});
	$("#amount").mask("9999999.99");
	$("#amount").on("blur", function() {
		var last = $(this).val().substr( $(this).val().indexOf("-") + 1 );
		
		if( last.length == 3 ) {
			var move = $(this).val().substr( $(this).val().indexOf("-") - 1, 1 );
			var lastfour = move + last;
			
			var first = $(this).val().substr( 0, 9 );
			
			$(this).val( first + '-' + lastfour );
		}
	});
});