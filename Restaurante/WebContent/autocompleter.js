$(document).ready(function() {
	$(function() {
		$("#productos").autocomplete({

			source : function(request, response) {
				$.ajax({
					url : "Productos",
					type : "POST",
					data : {
						term : request.term
					},
					dataType : "json",
					success : function(data) {
						response(data);
					}
				});
			}
		});
	});
});
