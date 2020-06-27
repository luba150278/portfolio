function a_value(){var Txt1 = "";
            var Txt2 = "";
            Txt1 = document.test.prob.value;
            Txt2 = document.test.prob2.value;
            document.getElementById('ex1').innerHTML="<HR>"+
                "Ваш ИМТ: " + (Txt1/Txt2).toFixed(2) + "<HR>";};