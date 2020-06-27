
$('.btn_send').click(function(){
	
	/*$('#send_contact*').each(function () {
		alert('fdf');
	});*/
var prov=0;
	$('#send_contact').find('input, textarea').each(function() { /*$data[this.name] = $(this).val();*/ 
			var data=$(this).val();
			//var brdr=$(this).css("border");
			var brdr="2px solid green";
			if($(this).val()==""){

				$(this).css( "border", "1px solid red");
				$(this).focus(); alert('empty field!'); 
				prov=1;
				return false;
			}
			else{$(this).css("border",brdr); $(this).css("background","#adefbc");}

		;});

	if(prov==0){$('.inv').css("visibility","visible");}

});



