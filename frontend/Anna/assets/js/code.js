
//---фильтрация картинок по категориям
var $=jQuery;

  AOS.init();

$(function() {
	var selectedClass = "";
	$(".filter").click(function(){
	selectedClass = $(this).attr("data-rel");
	$("#gallery").fadeTo(100, 0.1);
	$("#gallery div").not("."+selectedClass).fadeOut().removeClass('animation');
	setTimeout(function() {
		$("."+selectedClass).fadeIn().addClass('animation');
		$("#gallery").fadeTo(300, 1);
	}, 300);
});
});

$('.my_bars').css( "display",  "none");

//------работа с меню на мобильных---------
$('.fa-phone-square-alt').click(function (){opns();});

$('.my_bars').click(function()
{
	$('.my_bars').css( "display",  "none");
	$('.fa-phone-square-alt').css( "display",  "block");
	$('.fa-phone-square-alt').css( "visibility",  "visible");
	$('.fa-bars').css( "display",  "block");
	$('.fa-bars').css( "visibility",  "visible");
	$('.row_call').css( "display",  "none");
	$('.menu').css( "display",  "none");
});

$('.fa-bars').click(function(){opns();});


function opns()
{

	$('.fa-phone-square-alt').css( "display",  "none");
	$('.my_bars').css( "display",  "block");
	$('.my_bars').css( "visibility",  "visible");
	

	$('.row_call').css( "display",  "block");
	$('.row_call').css( "visibility",  "visible");
	$('.row_call').css("padding-top","10%");
	$('.fa-bars').css( "display",  "none");
	$('.menu').css( "display",  "block");
}

//----плавный скроллинг-----
$(function(){
	$('a[href^="#"]').on('click', function(event) {
	  // отменяем стандартное действие
	  event.preventDefault();
	  
	  var sc = $(this).attr("href"),
		  dn = $(sc).offset().top;
	  /*
	  * sc - в переменную заносим информацию о том, к какому блоку надо перейти
	  * dn - определяем положение блока на странице
	  */
	  
	  $('html, body').animate({scrollTop: dn}, 1000);
	  
	  /*
	  * 1000 скорость перехода в миллисекундах
	  */
	});
  });


//---модальное окно----
$(document).ready(function(){
		$('#exampleModal').on('show.bs.modal', function (event) {
			
			var button = $(event.relatedTarget) // Button that triggered the modal
			var recipient = button.data('whatever') // Extract info from data-* attributes
			// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			var modal = $(this)
			modal.find('.modal-title').text('Отправить сообщение для:\n' + recipient)
			modal.find('.modal-body input').val(recipient)
		});

		$('.btn-primary').click(function(){
			
			if ($('#message-text').val()!=''){$('#modal_suc').css("display","block"); $('#modal_suc').text('Ваше сообщение успешно отправлено'); $('#modal_suc').css("color","#007676");}
			else{$('#modal_suc').css("display","block"); $('#modal_suc').css("color","red"); $('#modal_suc').text('Пустые сообщения не оправляются!');}
		});


		$('.btn-secondary').click(function(){
		var nt='';
		$('#message-text').val('');
		$('#modal_suc').css("display","none");
		});

		$('.close').click(function(){
		var nt='';
		$('#message-text').val('');
		$('#modal_suc').css("display","none");
		});

});


$('#kart>p').click(function(){ //>img:nth-child(2)'
	 var click_name=this.id;
	 $('#kart>p').each(function()
 			{
 				
 				var obs_name=this.id; 					
				if(obs_name==click_name)
				{
						if(obs_name=='ad1'){$('iframe').attr('src','https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d40622.199609367126!2d30.4738408!3d50.4804385!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4cc22597b3bf5%3A0xfa4ccdb8e0446c1f!2z0YPQuy4g0JTQtdGB0L3Rj9C90YHQutCw0Y8sIDE5LCDQmtC40LXQsiwgMDIwMDA!5e0!3m2!1sru!2sua!4v1583312765292!5m2!1sru!2sua');}

						if(obs_name=='ad2'){$('iframe').attr('src','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2536.981109948796!2d30.60513061554945!3d50.515918290526784!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4d1040ae581c5%3A0x4ffcba6ab39c4c06!2z0YPQuy4g0KHQtdGA0LbQsCDQm9C40YTQsNGA0Y8sIDIwLCDQmtC40LXQsiwgMDIwMDA!5e0!3m2!1sru!2sua!4v1583315852883!5m2!1sru!2sua');}

						if(obs_name=='ad3'){$('iframe').attr('src','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2537.2916256252693!2d30.61433303089346!3d50.51014044942358!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4d0feefd4a30b%3A0x5241c7e0805749ec!2zM0EsINGD0LsuINCh0LXRgNC20LAg0JvQuNGE0LDRgNGPLCAz0JAsINCa0LjQtdCyLCAwMjAwMA!5e0!3m2!1sru!2sua!4v1583316093781!5m2!1sru!2sua');}
				}		

		
			});			

		});


