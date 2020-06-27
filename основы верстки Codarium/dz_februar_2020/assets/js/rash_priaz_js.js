	let mas = new Array();//исходный массив	
	let razm=1;
	let delt_x, delt_y,max_x,min_x,max_y,min_y;//макисмальные размеры по х и у
	let wd_o;//ширина образца
	let sts;//петли
	let hg_o; //высота образца
	let rws;//ряды
	let mo;//масса образца
	let wc;//ширина канваса
	let hc;//высота канваса
	function validateTextBoxes(prov)
 {
 	let form = document.forms.test; 
		$(prov).each(function(){

			while(this.value.match(/[^\d.,]+/))//удаляем нецифры кроме точки-запятой
			{
		        //if (this.value.match(/[^\d.,]+/)){this.value=this.value.replace(/[^\d.,]+/, '');}//удаляем нецифры кроме точки-запятой
		        this.value=this.value.replace(/[^\d.,]+/, '');
		    }    
		        if (this.value.match(/,/g)){this.value=this.value.replace(/,/g, '.');}//заменяем запятые точкой
		        //-----убираем лишние точки-----------
		        let pnt = ".";
		        
		        let firstIndex = this.value.indexOf(pnt); // Первое вхождение точки
		        if (firstIndex > -1) { // Есть хотя бы одна точка
		            // Часть строки с удаленными точками
		            let rest = this.value.slice(firstIndex + 1).split(pnt).join("");
		            // Соединить начало строки с первой точкой и остатком строки без точек
		            this.value = this.value.slice(0, firstIndex + 1) + rest;            
		        }
	    	

		});	

		return this.value;	
}
function a_value()
{
	

	validateTextBoxes('form input[type="text"]');

	wd_o = document.test.wd_o.value;
	sts = document.test.sts.value;
	hg_o= document.test.hg_o.value; 
	rws=document.test.rws.value;
	mo=document.test.mo.value;
	
	let prov=false;
	let prov_str="";

	if(wd_o<0) {
		prov_str=prov_str+"В поле <Ширина образца> введите значение больше нуля \n";
		prov=true;
	}
	if(sts<0) {
		prov_str=prov_str+"В поле <Количество петель> введите значение больше нуля \n";
		prov=true;
	}   
	if(hg_o<0) {
		prov_str=prov_str+"В поле <Высота образца> введите значение больше нуля \n";
		prov=true;
	}   
	if(rws<0) {
		prov_str=prov_str+"В поле <Количество рядов> введите значение больше нуля \n";
		prov=true;
	}   
	if(mo<0) {
		prov_str=prov_str+"В поле <Масса образца> введите значение больше нуля";
		prov=true;
	} 
	if(prov==true){alert(prov_str); return;}

   document.getElementById('ex1').innerHTML="<HR>"+"Пг: " + (sts/wd_o).toFixed(2)  +" пет/см"+"<HR>";
   document.getElementById('ex2').innerHTML="<HR>"+"Пв: " + (rws/hg_o).toFixed(2)  +" ряд/см"+"<HR>";

   let i,MC=mas.length-1,sum_squ=0,sum_o=mo/(wd_o*hg_o),mass_priaz;//sum_o - масса 1 см2
   for(i=0;i<=MC;i++)
   {
  
   				if (i < MC) { sum_squ = sum_squ + mas[i][0] * mas[i + 1][1] - mas[i][1] * mas[i + 1][0]; }
				if (i == MC) { sum_squ = sum_squ + mas[i][0] * mas[0][1] - mas[i][1] * mas[0][0]; }
   }
   	sum_squ=(Math.abs(sum_squ)/2).toFixed(2);//площадь детали
	mass_priaz=(sum_squ*sum_o).toFixed(1);
	let str="Площадь детали: "+ sum_squ+" cm2;\n"+"Масса пряжи для детали: "+ mass_priaz +" грамм.";
	document.getElementById('result').innerHTML="<HR>"+"<pre>"+str+"</pre>"+"<HR>";
 

 	delt_x=razm_detali(0);
  	delt_y=razm_detali(1);

wc=parseInt(document.getElementById('my-canvas').offsetWidth);
hc=parseInt(document.getElementById('my-canvas').offsetHeight);

	let k_x=wc/delt_x, k_y=hc/delt_y, k;

	k=(k_x<k_y)?k_x:k_y;
	
 	draw(k*0.8);
   return false;
};
//-----------------------------------------------------------------------

   function add_krd()//Ввод координат
   {
   		/*let m=new Array(,);*/
   		
   		validateTextBoxes('form input[name="koord_X"]');
   		let x=document.test.koord_X.value;
   		
		validateTextBoxes('form input[name="koord_Y"]');
		let y=document.test.koord_Y.value; 

   		let i,str="";
   		if(x=="" || y==""){alert("Пустое поле X или Y");return;}
		mas[razm-1] = new Array();
		mas[razm-1][0]=x;
		mas[razm-1][1]=y;			
	
		for(i=0;i<razm;i++){str=str+"Точка "+(i+1)+": X: " + mas[i][0]  +" Y: " + mas[i][1]+"\n";}
	
	/*alert(str);*/
	document.getElementById('arr_points').innerHTML="<HR>"+"<pre>"+str+"</pre>"+"<HR>";
   	
	razm=razm+1;
   };

//-------------------------------------------
function razm_detali(j)//размеры детали для canvas
{
	let i;
	let min_param=mas[0][j];
	let max_param=mas[0][j];

	for(i=1;i<mas.length;i++)
	{		
			if(Number(mas[i][j])<Number(min_param)){min_param=mas[i][j];}
			if(Number(mas[i][j])>Number(max_param)){max_param=mas[i][j];}
		
	}

	if(j==0){min_x=min_param; max_x=max_param;}
	else{min_y=min_param; max_y=max_param;}

	return Math.abs(max_param-min_param);
}


function draw(k) //рисуем контур
{
  let canvas = document.getElementById('my-canvas');
canvas.width =wc;
canvas.height = hc;

  if (canvas.getContext){
    let ctx = canvas.getContext('2d');
	/*ctx.translate(0,canvas.height);
	ctx.scale(1,-1);*/


	let i,j,y;
	ctx.beginPath();
	for(i=0;i<mas.length;i++)
	{	
		
		if(i==0){ctx.moveTo(canvas.width*0.1+mas[0][0]*k,canvas.height-mas[0][1]*k-canvas.height*0.1);}
		else{ctx.lineTo(canvas.width*0.1+mas[i][0]*k,canvas.height-mas[i][1]*k-canvas.height*0.1); }    	
    		//ctx.direction = 'rtl';

	}    
    ctx.closePath();
    ctx.stroke();
    ctx.globalAlpha = 0.2;
    ctx.fillStyle = "#b99db8";
    ctx.fill(); //заливка цветом
    ctx.globalAlpha=1;
	//-----точки вершин------------
			ctx.fillStyle = "#00F";  
    		ctx.font = "bold 14pt Arial";
    		for(i=0;i<mas.length;i++){ctx.fillText(i+1, canvas.width*0.06+mas[i][0]*k, canvas.height-mas[i][1]*k-canvas.height*0.06); }

    //----размерные линии
    //-----горизонтальная
    ctx.beginPath();
    ctx.moveTo(canvas.width*0.1+min_x*k,canvas.height*0.975);
    ctx.lineTo(canvas.width*0.1+max_x*k,canvas.height*0.975);
    ctx.strokeStyle="#800080"
    ctx.stroke();
    //----вертикальная
     ctx.beginPath();
    ctx.moveTo(0.025*canvas.width,canvas.height-min_y*k-canvas.height*0.1);
    ctx.lineTo(0.025*canvas.width,canvas.height-max_y*k-canvas.height*0.1);
    ctx.strokeStyle="#800080"
    ctx.stroke();
    //----надписи над размерными линиями

			ctx.fillStyle = "#800080";  
    		ctx.font = "bold 16pt Arial";
    		let text=delt_x+" cm= " +(sts/wd_o*delt_x).toFixed(0)+" пет.";
    		ctx.fillText(text, max_x/2*k-0.1*canvas.width, canvas.height*0.965); //горизонтальный размер
			
			ctx.save();
			
   			text=delt_y+" cm= " +(rws/hg_o*delt_y).toFixed(0)+" ряд.";
   			
   			ctx.rotate(Math.PI/2);
   			ctx.fillText(text, max_x*k/2, -0.033*canvas.height); //вертикальный размер
   			ctx.restore();
   			
   			
  }
}

function del_krd()//очищаем канвас, массив и убираем надписи
{
	//-------очищаем канвас--------------
	 let canvas = document.getElementById('my-canvas');	 
    let ctx = canvas.getContext('2d');
    ctx.save();
    ctx.setTransform(1,0,0,1,0,0);
    ctx.clearRect(0,0,canvas.width,canvas.height);
	ctx.restore();
	

	 mas=[];//---очищаем массив
	 razm=1;
	 document.test.koord_Y.value=0;
	 document.test.koord_X.value=0;
	 let str="";
	 //-------------------удаляем текстовые поля-----------------
	 document.getElementById('arr_points').innerHTML=str;
	 document.getElementById('result').innerHTML=str;
}

