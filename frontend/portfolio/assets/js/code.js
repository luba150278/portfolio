let $=jQuery;
let id_ish=null
let id_poisk=null
let prt=[
  ['pf_1','assets/img/pr_1.jpg','assets/img/pr_1_2.jpg'],
  ['pf_2','assets/img/pr_2.jpg','assets/img/pr_2_2.jpg'],
  ['pf_3','assets/img/pr_3.jpg','assets/img/pr_3_2.jpg']
]

//---модальное окно----
$(document).ready(function(){
  AOS.init()//подключение внешней анимации блоков

  //модальное окно отправки почті
  $('#exampleModal').on('show.bs.modal', function (event) {
    
    let button = $(event.relatedTarget) // Button that triggered the modal
    let recipient = "info@lubamet.site" 
    let email="example@gmail.com"
    let name="Иван Иванов"
    let modal = $(this)
    modal.find('.modal-title').text('Отправить сообщение: ' + recipient)
    modal.find('#recipient-email').val(email)
    modal.find('#recipient-name').val(name)
  });

  $('.btn-primary').click(function(){
    
    if ($('#message-text').val()!=''){
      $('#modal_suc').css("display","block")
      $('#modal_suc').text('Ваше сообщение успешно отправлено')      
    }
    else{
      $('#modal_suc').css("display","block")
      $('#modal_suc').css("color","red"); $('#modal_suc').text('Пустые сообщения не оправляются!')
    }

  });

  $('.btn-secondary').click(function(){
    let nt=''
    $('#message-text').val('')
    $('#modal_suc').css("display","none")
  });

  $('.close').click(function(){
    let nt=''
    $('#message-text').val('')
    $('#modal_suc').css("display","none")
  });



// Отправка данных на сервер
$("#contact_form").submit(function(){
 
  console.log("Отправка запроса")
  event.preventDefault ? event.preventDefault() : event.returnValue = false;
  var req = new XMLHttpRequest();
  req.open('POST', 'send.php', true)
  req.onload = function() {
    if (req.status >= 200 && req.status < 400) 
    {
        json = JSON.parse(this.response);// internet explorer 11
        console.log(json)
          
        // ЗДЕСЬ УКАЗЫВАЕМ ДЕЙСТВИЯ В СЛУЧАЕ УСПЕХА ИЛИ НЕУДАЧИ
        if (json.result == "success") 
        {
          // Если сообщение отправлено
          //alert("Сообщение отправлено");
        } 
        else 
        {
          // Если произошла ошибка
          alert("Ошибка. Сообщение не отправлено")
        }
      // Если не удалось связаться с php файлом
    } 
    else 
    {
      alert("Ошибка сервера. Номер: "+req.status)
    }

  }; 
  
      // Если не удалось отправить запрос. Стоит блок на хостинге
      req.onerror = function() {
        alert("Ошибка отправки запроса")
      };
      req.send(new FormData(event.target))
  });


  //фиксированное меню на мобильных закрытие по нажатию пункта и сдвиг раздела
  $('.toAnchor').on('click', function () {
    
    $('.navbar-collapse').removeClass('show')
    $a = $($(this).attr('href'))
    $('html,body').animate({ scrollTop: $a.offset().top - 50}, 500)
  return false
  });

  //----плавный скроллинг-----
$(function(){
	$('a[href^="#"]').on('click', function(event) {
	  // отменяем стандартное действие
	  event.preventDefault();
	  
	  var sc = $(this).attr("href"),
		  dn = $(sc).offset().top-50;
	  /*
	  * sc - в переменную заносим информацию о том, к какому блоку надо перейти
	  * dn - определяем положение блока на странице
    * -50 - добавлено для фикисрованного меню
	  */
	  
	  $('html, body').animate({scrollTop: dn}, 1000)
	  
	  /*
	  * 1000 скорость перехода в миллисекундах
	  */
  });
});


//Работа с проектами - показываем текст-описание
  $('.pr_col>div').hover(function()      
  { 
          id_ish=this.id
          $('.pr_col>div').each(function()
          {
              id_poisk=this.id
              let s=parseInt(id_poisk.substr(3,id_poisk.length))-1
              
              if(id_ish==id_poisk){

                let img1=prt[s][2]        
                $('#'+id_poisk +'>div').css("visibility",  "visible")
                $('#'+id_poisk +'>a>img').attr("src", img1)
                // $('button').on('click', function(){     
                //   window.location.href = $(this).attr('url');
                // });

              }
              else{

                $('#'+id_poisk +'>div').css("visibility",  "hidden")                            
                let img1=prt[s][1]
                $('#'+id_poisk +'>a>img').attr("src", img1)
                
              }
          });
          
    },
      function(){
        $('.pr_col>div').each(function()
        {
         
          id_poisk=this.id
          let s=parseInt(id_poisk.substr(3,id_poisk.length))-1
          $('#'+id_poisk +'>div').css("visibility",  "hidden")                             
          let img1=prt[s][1]
          $('#'+id_poisk +'>a>img').attr("src", img1)

        });
    });


    $('.txt_h').on('click', function(event){
      window.open($(this).attr('url'), '_blank');
    })

  //Окрашивание выдленного пункта в меню
  $('.toAnchor').on('click', function(event)
  {
    let id_ich=this.id
    $('.toAnchor').each(function()
    {
      let id_prov=this.id
      if(id_ich==id_prov){
       
        $('#' + id_prov).removeClass('nav-link toAnchor');
        $('#' + id_prov).addClass('nav-link-active toAnchor');
      }
      else{     
   
              $('#' + id_prov).removeClass('nav-link-active toAnchor');              
              $('#' + id_prov).addClass('nav-link toAnchor');        
       
      }
    })

  })
  
});