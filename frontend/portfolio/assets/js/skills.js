
let arr=[
  {id: 'front', skill: 'HTML', lev: 4},
  {id: 'front', skill: 'CSS', lev: 4},
  {id: 'front', skill: 'SASS/LESS', lev: 4},
  {id: 'front', skill: 'Bootstrap4', lev: 4},
  {id: 'front', skill: 'JS/JQuery', lev: 4},
  {id: 'front', skill: 'WordPress', lev: 4},
  {id: 'front', skill: 'Tilda', lev: 3},
  {id: 'front', skill: 'Wix', lev: 4},
  {id: 'front', skill: 'Photoshop', lev: 4},
  {id: 'front', skill: 'Illustrator', lev: 3},
  {id: 'front', skill: 'Figma', lev: 4},
  {id: 'manag', skill: 'GIT/GITHUB', lev: 4},
  {id: 'manag', skill: 'Bitbuсket', lev: 3},
  {id: 'manag', skill: 'Webpack', lev: 3},
  {id: 'manag', skill: 'Npm', lev: 4} ,
  {id: 'prog', skill: 'C#', lev: 4},
  {id: 'prog', skill: 'VB.Net', lev: 4},
  {id: 'prog', skill: 'Java Script', lev: 4},
  {id: 'prog', skill: 'Java', lev: 3},
  {id: 'soft', skill: 'Self-management', lev: 5},
  {id: 'soft', skill: 'Работа в команде', lev: 4},
  {id: 'soft', skill: 'Ответсвенность', lev: 4},
  {id: 'soft', skill: 'Коммуникация', lev: 5},
  {id: 'soft', skill: 'Честность', lev: 5},
  {id: 'soft', skill: 'Обучаемость', lev: 5},
  {id: 'soft', skill: 'Гибкость', lev: 4},
  {id: 'lang', skill: 'English', lev: 3},
  {id: 'lang', skill: 'Словацкий', lev: 4},
  {id: 'lang', skill: 'Русский', lev: 5},
  {id: 'lang', skill: 'Украинский', lev: 5},
  {id: 'other', skill: 'Управление коллективом более 100 человек', lev: 5},
  {id: 'other', skill: 'Управление ТЭП предприятия', lev: 5}

]



$(document).ready(function(){  
  
  $('.skills_div').each(function () {
    let id=this.id
    let part_arr = arr.filter(item => item.id == id)
    $(this).after(Form_skills(part_arr))
  })
   
})

function Form_skills(part_arr){
  
  let newEl=''
  let dop_El

  for(let i=0; i<part_arr.length; i++){
    newEl = newEl+'<div class="row skills_row">'+'<div class="col-sm-6"><h4>'+ part_arr[i].skill+'</h4></div><div class="col-sm-6 i_ball">'
    
    let level_skill=part_arr[i].lev
    dop_El=''
    for(let j=1; j<=5; j++){
     
      if (j <= level_skill){
        dop_El=dop_El+' <i class="fas fa-circle"></i>'
      }
      else
      {
        dop_El=dop_El+' <i class="far fa-circle"></i>'
      }
    }

    newEl=newEl+dop_El+'</div></div>'
  }
return newEl

}

