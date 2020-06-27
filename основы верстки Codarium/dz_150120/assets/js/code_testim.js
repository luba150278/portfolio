//----отзывы смена при клике----
 $('.people>div').click(function(){ //>img:nth-child(2)'
 	var click_name=this.className;
 	alert(click_name);
 	var arr=new Array(['assets/img/woman.png','assets/img/men_gray.png'],['assets/img/woman_orange.png','assets/img/man.png']);
var q1='Lorem ipsum dolor sitamet, consectetur adipiscing elit.';
var q2='Lorem ipsum dolor sitamet, consectetur adipiscing elit.<br>Ut ultricies sagittism agnaa commodo.';
var q3='Lorem ipsum dolor sit amet, consectetur adipiscing elit,<br>sed do eiusmod tempor.';
var h1='Helen Carter / Designer';
var h2='Jon Doe / CEO of loremspun';
var h3='Mirey Mattie / Developer';
 	var otz=new Array([q1,h1],[q2,h2],[q3,h3]);
 		$('.people>div').each(function()
 			{
 				
 					var obs_name=this.className;
 					var cn='.'+obs_name+'>img:nth-child(2)';
 					var cn2='.'+obs_name+'>img:nth-child(1)';
 					if(obs_name==click_name){
 						$(cn).attr("src","assets/img/orange_lbl.png"); $(cn).removeClass(); $(cn).addClass('or_lbl');
 						if(obs_name>'cntr'){$(cn2).attr("src",arr[1][0]);}
 						else{$(cn2).attr("src",arr[1][1]);}
 						switch(obs_name)
 						{	case 'rht': 
 						
		 						document.getElementById('quote').innerHTML=otz[0][0];
		 						document.getElementById('zag').innerHTML=otz[0][1]; 							
 							break;
 							case 'cntr': 
 								document.getElementById('quote').innerHTML=otz[1][0];
 								document.getElementById('zag').innerHTML=otz[1][1];
 							break;
 							case 'lft': 
 								document.getElementById('quote').innerHTML=otz[2][0];
 								document.getElementById('zag').innerHTML=otz[2][1];
 							break;
 						}
 					}
 					else{
 						$(cn).attr("src","assets/img/gray_lbl.png"); $(cn).removeClass(); $(cn).addClass('gr_lbl');
 						if(obs_name>'cntr'){$(cn2).attr("src",arr[0][0]);}
 						else{$(cn2).attr("src",arr[0][1]);}
 					}

 			}
 			);
 });