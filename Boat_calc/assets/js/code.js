let $=jQuery;

$('#calc_price').click(function(){
  let result = 0
  validateTextBoxes( $('.per'))

    if(Number($('#hull_max_l').value) == 0 && Number($('#hull_max_w').value) == 0 ) return
 
    let hull_leng = Number($('#hull_max_l').val())/12
    let hull_wid = Number($('#hull_max_w').val())/12

    if(hull_leng <= 30 && hull_wid <= 5){
        result = hull_leng * 5 * 2 * 7
    }

    let back_leng = Number($('#back_max_l').val())/12
    let back_wid = Number($('#back_max_w').val())/12
    if(back_leng>0 && back_wid>0){
      result = result + back_leng * back_wid * 2 * 7
    }
    let quant
    if($('#quant').val() == ""){
      quant =  document.querySelector('#quant').getAttribute("placeholder")
    }else{
      quant = Number($('#quant').val())
  }

    
    result = result*quant
    
    if(result>0){
      console.log(result)
      document.getElementById("price").textContent ="$" + result
    }
})

function validateTextBoxes(prov)
{
    $(prov).each(function(){

      while(this.value.match(/[^\d.,]+/))//remove non-number except .,
      {           
          this.value=this.value.replace(/[^\d.,]+/, '')
      } 

      if (this.value.match(/,/g)){this.value=this.value.replace(/,/g, '.')}//replace , .           
      
      //-----remove all points except first-----------
      let pnt = "."         
      let firstIndex = this.value.indexOf(pnt) // The first point
      if (firstIndex > -1) { // There is at least one point
        // Get part of a line with dots removed
        let rest = this.value.slice(firstIndex + 1).split(pnt).join("")
        // Concatenate
        this.value = this.value.slice(0, firstIndex + 1) + rest           
      }  
    
   })	

 
   return this.value	
}