
$(document).ready(function(){


var s=location.href;
var name_page=s.substr(s.lastIndexOf("/")+1);

$('.navbar-nav>li').each(function(){
	var css_id='#'+this.id;
	$(css_id).css('background','#f4f4f4');
});

switch (name_page) {
	case 'index.html':
		$('#li_1').css('background','#12a3d6');
		break;
	case 'portfolio.html':
		$('#li_2').css('background','#12a3d6');
		break;
	case 'about.html':
		$('#li_3').css('background','#12a3d6');
		break;
	case 'contact.html':
		$('#li_4').css('background','#12a3d6');
		break;

	default:
		// statements_def
		break;
}
	
});



 	
