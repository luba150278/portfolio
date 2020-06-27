var $=jQuery;
//----изменяем фото в галереи в зависимости от фокуса
let prov=0;
$('#portfolio_main > .container>.row_gal>.thumb1').hover(
function(){ 
         
 
 	$('#portfolio_main > .container>.row_gal>.thumb1>div').each(function () 
 	{  			
 		var cn=this.className; 

 		$("." + cn).hover(function() { 
 			$("." + cn+'>.im_ph').attr("src","assets/img/camera_icon_empty.png");			
			$("." + cn+'>.trumb2').css( "visibility",  "visible");			
 		}, 

  		function() {  			 		
			$("." + cn+'>.trumb2').css( "visibility",  "hidden");
			$("." + cn+'>.im_ph').attr("src","assets/img/photos.png");

  		});
 	});
      
},
function(){});



//--------------------------------------Добавляем классы в галерею--------

$(document).ready(function(){
  
  	
  	var n=1;

  	$('#portfolio_main > .container>.row_gal>.thumb1').each(function () { 
  		
  		var nc='<div class="'+'tc'+n+'"></div>';
  		
  			var newElems = $(nc)
  			.append("<img class='im_ph' src='assets/img/photos.png'/>")
  			.append("<div class='trumb2'><h3>Lorem Amet Dolor</h3><p> \
  				Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p> \
  				<button class='btn_f_img'><i class='fas fa-eye'></i>Details</button></div>");     
  			//newElems.css( "background",  "url('assets/img/photos.png') no-repeat center top");
  			//newElems.css( "background-size",  "cover");
  			//newElems.css("padding","13%");
  			//<i class='fas fa-eye'></i>
  			
  			$(this).append(newElems); 
  			n++;
		});
	$('.im_ph').css( "position",  "relative");	
	$('.im_ph').css( "width",  "100%");
 	$('.trumb2').css( "visibility",  "hidden");
 	$('.trumb2').css( "position",  "absolute");
 	$('.trumb2').css( "top",  "10%");
 	$('.trumb2').css( "left",  "5%");
 	//alert('text:'+$('.trumb2').css("height"));
 	//alert('pic:'+$('.thumb1').css("width"));
});

//-----------------------------------Переключение цвета иконок и вида галереи -------------------

//------таблица-------
$('.im_nav #tbl').click(function(){
	$(this).attr("src","assets/img/table_icon.png");
	$('.im_nav #lst').attr("src","assets/img/list_icon.png");

	$('#portfolio_main > .container>.row_gal').each(function () {
		$(this).children().removeClass();
		$(this).children().addClass('col-xl-4 col-lg-6 col-md-12 col-sm-12 col-xs-12 thumb1');
		$(this).removeClass('row_pad');
	});
prov=0;
});

//-----список
$('.im_nav #lst').click(function(){
	$(this).attr("src","assets/img/line_icon_blue.png");
	$('.im_nav #tbl').attr("src","assets/img/table_icon_gray.png");

	$('#portfolio_main > .container>.row_gal').each(function () {
		$(this).children().removeClass();
		$(this).children().addClass('col-md-12 col-12 thumb1');
		$(this).addClass('row_pad');
	});


prov=1;
});

//----смена цвета кружочка в выпадающем меню----------------
$('.dropdown-item').hover(function() { 
	var id_di=this.id;

	$('.dropdown-item').each(function () 
	{
			var id_tec=this.id;
			if(id_tec!="undefined" && id_tec!=null && id_tec!="" )
			{
				var mark='#'+id_tec+'>.sel_or_not';
				if(id_di==id_tec){ $(mark).attr("src","assets/img/select.png");}
				else{$(mark).attr("src","assets/img/select_or_not.png");}
			}

	});
 					
 		}, 

  		function() {  			 		
			//$('.sel_or_not').attr("src","assets/img/select_or_not.png");		

  		});
