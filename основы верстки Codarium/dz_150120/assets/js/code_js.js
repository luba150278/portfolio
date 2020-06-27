var mas = new Array('Good Design Is Good Business','Bad Design Is Bad Business','Not Good Design Is Not Good Business','Not Bad Design Is not Bad Business','Very Bad Design Is Very Bad Business');//исходный массив	
var mas_img = new Array('assets/img/second_bg.png','assets/img/bg_2.jpg','assets/img/bg_3.jpg','assets/img/bg_4.jpg','assets/img/bg_5.jpg');

var slid = document.getElementById('slid');
//var nb = document.getElementById('nb');

slid.onclick = function (event) {  
    
	var name_a=event.target.id;
	
    var txt,im;
	if(name_a=='a1'){txt=mas[0];im=mas_img[0]; $('#top_main>.container>.promo>h1').css( "color",  "#cccecd");}
	if(name_a=='a2'){txt=mas[1];im=mas_img[1]; $('#top_main>.container>.promo>h1').css( "color",  "white");}
	if(name_a=='a3'){txt=mas[2];im=mas_img[2]; $('#top_main>.container>.promo>h1').css( "color",  "#218fc0");}
	if(name_a=='a4'){txt=mas[3];im=mas_img[3]; $('#top_main>.container>.promo>h1').css( "color",  "#cccecd");}
	if(name_a=='a5'){txt=mas[4];im=mas_img[4]; $('#top_main>.container>.promo>h1').css( "color",  "#cccecd");}
	 document.getElementById('slogan').innerHTML=txt;
	 var bgs='assets/img/slider_select.png';
 	var bgs1='assets/img/slider.png';
//document.event.target.id.style.background = 'url("'+bgs+'")';
	
  	document.getElementById('top_main').style.background ='url("'+im+'")';

  	for (var i = 0; i < this.children.length; i++) {  		
     if(this.children[i].id==name_a){this.children[i].style.background= 'url("'+bgs+'") no-repeat center top ';}
     else{this.children[i].style.background= 'url("'+bgs1+'") no-repeat center top '; }
      //$(this).children[i].css( "background-size",  "cover");
    }

}

$('.btn_more').click(function(){ location.href = "portfolio.html#portfolio_nav";});//переход по нажатию кнопки

//----portfolio смена картинки при наведении мыши----

 		$('.row2>div>img').hover(function() { 
 			$(this).attr("src","assets/img/details.png");						
 		}, 

  		function() {  			 		
			
			$(this).attr("src","assets/img/camera icon.png");

  		});
 	
 



