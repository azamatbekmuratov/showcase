window.onload=function(){
(function (exports) {
    function valOrFunction(val, ctx, args) {
        if (typeof val == "function") {
            return val.apply(ctx, args);
        } else {
            return val;
        }
    }

    function InvalidInputHelper(input, options) {
        input.setCustomValidity(valOrFunction(options.defaultText, window, [input]));

        function changeOrInput() {
            if (input.value == "") {
                input.setCustomValidity(valOrFunction(options.emptyText, window, [input]));
            } else {
                input.setCustomValidity("");
            }
        }

        function invalid() {
            if (input.value == "") {
                input.setCustomValidity(valOrFunction(options.emptyText, window, [input]));
            } else {
               input.setCustomValidity(valOrFunction(options.invalidText, window, [input]));
            }
        }

        input.addEventListener("change", changeOrInput);
        input.addEventListener("input", changeOrInput);
        input.addEventListener("invalid", invalid);
    }
    exports.InvalidInputHelper = InvalidInputHelper;
})(window);

	InvalidInputHelper(document.getElementById("iin"), {
		defaultText: "Поле ИНН может содержать только 12 нумерное значение",
		emptyText: "Поле ИНН может содержать только 12 нумерное значение",
		invalidText: function (input) {
			return 'Указанный номер ИНН "' + input.value + '" не соответствует формату ИНН. Поле ИНН может содержать только 12 нумерное значение';
		}
	});
}