const $ = jQuery

//-----task#1 Задача
console.log('Hello' + '\n' + 'World!') //task1

//-----task#2 Задача
let a = 12892323 + 454665768
console.log(a) //task2
$('#t2').append(a)

//-----task#3 Задача. Поменяти міцями дві змінних------
$('#btn_t3').click(function() {
    let a = +$('#t3_1').val()
    let b = +$('#t3_2').val()

    a = a ^ b
    b = a ^ b
    a = a ^ b
    let str = `a = ${a} \nb = ${b}`
    console.log(`Задача 3: ${str}`)
    $('#t3_otv').append(str + '<br>')
})


//-----task#4 Задача. Дізнатися номер и додати 1------

$('#btn_t4').click(function() {
    let X = parseInt($('#t4_1').val())
    let str = `X = ${X} \n(X + 1) = ${X += 1}`
    console.log(`Задача 4: ${str}`)
    $('#t4_otv').append(str + '<br>')
})

//---------task#5----Сума двох чисел---------------       

$('#btn_t5').click(function() {
    let a = parseInt($('#t5_1').val())
    let b = parseInt($('#t5_2').val())
    let c = a + b
    console.log(`Задача 5: ${c}`)
    $('#t5_otv').append(c + '<br>')
})

//----------task#6----КМ день---
$('#btn_t6').click(function() {
    const kmLimit = 3
    let a = parseInt($('#t6_1').val())
    let c
    a <= kmLimit ? c = 'Маловато будет...' : c = 'Молодец!'
    console.log(`Задача 6: ${c}`)
    $('#t6_otv').append(c + '<br>')
})

//-------task#7----- Км на день2------       
$('#btn_t7').click(function() {
    const kmLimit1 = 3
    const kmLimit2 = 20
    let a = parseInt($('#t7_1').val())
    let c = "Молодец!"
    if (a <= kmLimit1) c = "Маловато будет..."
    if (a >= kmLimit2) c = "Марафонец!"

    console.log(`Задача 7: ${c}`)
    $('#t7_otv').append(c + '<br>')
})

//-------task#8----- Лифт------
$('#btn_t8').click(function() {

    let a = parseInt($('#t8_1').val())
    let c
    let parol
    if (a < 1 || a > 9) {
        console.log('Не верная цифра')
        alert('Не верная цифра')
        return false
    } else if (a <= 3 || a >= 7) {
        c = "Пароль не нужен"
        console.log(`Задача 8: ${c}`)
        $('#t8_otv').append(c + '<br>')
    } else {
        $('#t8_parol').css("visibility", "visible");

        $('#btn_t8_2').click(function() {
            parol = parseInt($('#t8_2').val())
            parol == 1337 ? c = "Верный пароль" : c = "Неверный пароль"

            console.log(`Задача 8: ${c}`)
            $('#t8_otv').append(c + '<br>')
        })
    }
})

//-------task#9----- Будильник------

$('#btn_t9').click(function() {
    let work = $('#t9_1').val().toLowerCase()
    let vac = $('#t9_2').val().toLowerCase()
    let c
    $('#t9_otv').append(setAlarm(work, vac))

    function setAlarm(work, vac) {
        (work == 'да' && vac == 'нет') ? c = 'Будильник включен': c = 'Будильник отключен'
        return c + '<br>'
    }
})

//-------task#10----- Скільки мені буде років в 2099 році?------
$('#btn_t10').click(function() {
    let yearBorn = parseInt($('#t10_1').val())
    let yearSearch = parseInt($('#t10_2').val())

    $('#t10_otv').append(getYears(yearBorn, yearSearch))


    function getYears(yearBorn, yearSearch) {

        let res = yearSearch - yearBorn
        let pastRes = Math.abs(res)
        let add_y
        //pastRes != 1 ? (pastRes > 4 ? add_y = ' лет' : add_y = ' года') : add_y = ' год'

        let pastRes1 = pastRes - parseInt(pastRes / 10) * 10

        if (pastRes1 == 1) {
            add_y = ' год'
        } else if (pastRes1 >= 5 || (res > 10 && res <= 20) || pastRes1 == 0) {
            add_y = ' лет'
        } else {
            add_y = ' года'
        }

        //----результат----
        let str = pastRes + add_y
        if (res < 0) {
            str = 'Вы родитесь через ' + str
        } //прошлое
        if (res > 0) {
            str = 'Вам ' + str
        } //будущие
        if (res == 0) {
            str = 'Это ваш год рождения!'
        } //текущий год  

        str = str + '<br>'
        return str
    }

})

//-------task#11----- Задача про Парне/Непарне------

$('#btn_t11').click(function() {
    $('#t11_otv').append(checkOdd(parseInt($('#t11').val())))

    function checkOdd(x) {
        let str
        x % 2 == 0 ? str = 'Четное' : str = 'Нечетное'
        return str + '<br>'
    }
})


//-------task#12----- Задача про переведення boolean значень в рядки yes або no------
$('#btn_t12').click(function() {
    $('#t12_otv').append(boolToWord($('#t12').val()))

    function boolToWord(bool) {
        let answ
        bool == "true" ? answ = 'Yes' : answ = 'No'
        return answ + '<br>'
    }
})


//-------task#13----- Задача. Зірочки.------
//true - выводим через while, false -> for
//если звездочек больше 100 выводим по 100 в ряду, для удобства

$('#t13_1').append(zir_on(10, true, true))
$('#t13_2').append(zir_on(100, true, true))
$('#t13_3').append(zir_on(1000, true, true))
$('#t13_4').append(zir_on(1000, false, true))

console.log(zir_on(10, true, false))
console.log(zir_on(100, true, false))
console.log('while\n' + zir_on(1000, true, false))
console.log('for\n' + zir_on(1000, false, false))


//console.log( zir_on(+prompt('Сколько зведочек вывести?'), true) )
$('#btn_t13').click(function() {
    let count_z = parseInt($('#t13').val())
    $('#t13_5').append('<br>' + zir_on(count_z, true, true))
    console.log('user\n' + zir_on(count_z, true, false))

})

function zir_on(count, spos, fin) {
    let s = '<br>'
    if (fin == false) {
        s = '\n'
    }
    let str = ''
    let i = 1
    if (spos == true) {
        while (i <= count) {
            str = str + '*'
            if (i % 100 == 0) str = str + s
            i++
        }
    } else {
        for (i = 1; i <= count; i++) {
            str = str + '*'
            if (i % 100 == 0) str = str + s
        }
    }
    return str + s
}


//-------task#14----- Задачі про числа------

$('#btn_t14').click(function() {
    listNumbs(parseInt($('#t14').val()))

    function listNumbs(N) {
        let str = ''
        //----for-----
        for (let i = 1; i <= N; i++) {
            str = str + i
            if (i < N) str = str + ', '
        }
        console.log('Вывод через for:\n' + str)
        $('#t14_1').append('Вывод через for:<br>' + str)
        //----while-----
        let i = 1
        str = ''
        while (i <= N) {
            str = str + i
            if (i < N) str = str + ', '
            i++
        }
        console.log('Вывод через while:\n' + str)
        $('#t14_2').append('Вывод через while:<br>' + str)


        //------DECS---
        str = ''
        for (let i = N; i >= 1; i--) {
            str = str + i
            if (i > 1) str = str + ', '
        }
        console.log('Вывод в обратном порядке:\n' + str)
        $('#t14_3').append('Вывод в обратном порядке:<br>' + str)

        //----Even only---
        str = ''
        for (let i = 2; i <= N; i += 2) {
            str = str + i
            if (i + 1 < N) str = str + ', '
        }
        console.log('Только четные:\n' + str)
        $('#t14_4').append('Только четные:<br>' + str)
    }
})


//-------task#15----- Квадратик із зірочок------

$('#btn_t15').click(function() {
    square(parseInt($('#t15').val()))

    function square(N) {
        let cnt = N * N
        let str_c = ''
        let str_v = ''
        for (let i = 1; i <= cnt; i++) {
            str_c = str_c + '*'
            str_v = str_v + '*'
            if (i % N == 0) {
                str_c = str_c + '\n'
                str_v = str_v + '<br>'
            }
        }
        console.log('Цикл for:\n' + str_c)
        $('#t15_1').append('Цикл for:<br>' + str_v)

        i = 1
        str_c = ''
        str_v = ''
        while (i <= cnt) {
            str_c = str_c + '*'
            str_v = str_v + '*'
            if (i % N == 0) {
                str_c = str_c + '\n'
                str_v = str_v + '<br>'
            }
            i++
        }
        console.log('Цикл while:\n' + str_c)
        $('#t15_2').append('Цикл while:<br>' + str_v)
    }
})

//-------task#16----- Трикутники із зірочок------ 
$('#btn_t16').click(function() {
    triA(parseInt($('#t16').val()))

    function triA(N) {
        let str = ''
        let prov = true
        let i
        let K = 1

        //--first
        while (prov) {
            for (i = 1; i <= K; i++) {
                str = str + '*'
            }
            str = str + '\n'
            if (K == N) {
                prov = false
            }
            K++
        }
        console.log(str)

        //--second----
        prov = true
        K = N
        str = ''
        while (prov) {
            for (i = 1; i <= K; i++) {
                str = str + '*'
            }
            str = str + '\n'
            K--
            if (K == 0) {
                prov = false
            }
        }
        console.log(str)

        //---third
        prov = true
        K = N
        str = ''
        while (prov) {
            for (i = 1; i <= N; i++) {
                if (K == N) {
                    str = str + '*'
                } else {
                    let res = N - K;
                    i <= res ? str = str + ' ' : str = str + '*'
                }
            }

            str = str + '\n'
            K--
            if (K == 0) {
                prov = false
            }
        }
        console.log(str)
    }

})


//-------task#17----- Вивести ялинку на екран------ 
$('#btn_t17').click(function() {
    tree(parseInt($('#t17').val()))

    function tree(N) {
        let str = ''
        let prov = true
        let k = 1 //количество звездочек ствола 1 - для нечетных 2 для четных, столько же оставим на вершине - для симметрии
        let nr = 0 //кол-во рядов между стволом и верхушкой
        let N_start = N //промежуточная                

        if (N % 2 == 0) {
            k = 2
        }
        if (N >= 5) {
            while (prov) {
                if (N_start > 2) {
                    nr++
                    N_start -= 2
                } else {
                    prov = false
                }
            }
        }

        //----первый и последний ряд см.сверху----
        let res = (N - k) / 2
        let str1 = ''
        let str2 = ' '

        for (let i = 1; i <= N; i++) {
            (i <= res || i > (res + k)) ? str1 = str1 + str2: str1 = str1 + '*'
        }
        str = str + str1 + '\n'

        //----следующие ряды до ствола----                
        let kk = k //кол-во 
        let str3
        for (let j = 1; j <= nr; j++) {
            kk += 2
            res = (N - kk) / 2
            for (let i = 1; i <= N; i++) {
                (i <= res || i > (res + kk)) ? str = str + str2: str = str + '*'
            }
            str = str + '\n'
        }

        str = str + str1 + '\n' //ствол

        console.log(str)
    }

})

//-------task#18----- Задача про найбільше число.------

$('#btn_t18').click(function() {
    let count_ch = parseInt($('#t18').val())

    for (let i = 1; i <= count_ch; i++) {
        $('#place_input').append('<input type="text" class="mas" value="0">')
    }

    $('#ins').append('<button id="btn_t18_2" onClick="rash();">Расчеты</button>')
})

function rash() {
    let arr = [];
    let a = 0;
    $('.mas').each(function(i, elem) {
        arr[a] = parseInt($(elem).val())
        a++;
    })

    let str = ''
    let prov = true
    let num = arr[0]
    let num_even = 0
    let x
    prov = false

    if (num == 0) {
        prov = true
    }

    if (num % 2 == 0) {
        num_even = num
    }

    for (let i = 1; i < arr.length; i++) {
        x = arr[i]
        if (x == 0) {
            prov = true
        }
        if (x > num) {
            num = x
        }
        if ((x > num_even && x % 2 == 0) || (num_even == undefined && x % 2 == 0)) {
            num_even = x
        }
    }

    str = 'Максимальное число в последовательности: ' + num + '\n'
    $('#ins_2').append('<p>' + `Максимальное число в последовательности: ${num}` + '</p>')
    if (!!num_even) {
        str = str + "Среди четных чисел наибольшее число: " + num_even
        $('#ins_2').append('<p>' + `Среди четных чисел наибольшее число:  ${num_even}` + '</p>')
    } else {
        if (prov == false) {
            str = str + 'Четных чисел не вводилось'
            $('#ins_2').append('<p>Четных чисел не вводилось</p>')
        } else {
            str = str + 'Среди четных чисел наибольшее число 0 '
            $('#ins_2').append('<p>Среди четных чисел наибольшее число 0</p>')
        }
    }

    console.log(str)
}

//-------task#19----- Сума послідовностей чисел------ 

$('#btn_t19').click(function() {
    let num1 = parseInt($('#t19_1').val())
    let num2 = parseInt($('#t19_2').val())
    $('#t19_otv').append(sum_num(num1, num2))

    function sum_num(num1, num2) {
        let sum = 0
        if (num1 < num2)
            for (let i = num1; i <= num2; i++) {
                sum = sum + i
            }
        if (num1 > num2)
            for (let i = num1; i >= num2; i--) {
                sum = sum + i
            }
        if (num1 == num2) sum = num1
        console.log(`Сумма последовательности чисел от ${num1} до ${num2} равна ${sum}`)
        return `Сумма последовательности чисел от ${num1} до ${num2} равна ${sum}`
    }
})

//-------task#20----- Задача про міста ------

$('#btn_t20').click(function() {
    let count_ch = parseInt($('#t20').val())

    for (let i = 1; i <= count_ch; i++) {
        $('#sity_input').append('<input type="text" class="sities">')
    }

    $('#ins20').append('<button id="btn_t19_2" onClick="city();">Проверить</button>')
})


function city() {

    let str = ''
    let arr = []
    let num1
    prov = false

    let num2 = prompt('Введите ваш родной город')
    let a = 0;

    $('.sities').each(function(i, elem) {
        //alert(parseInt($(elem).val()))
        arr[a] = $(elem).val()
        a++;
    })

    let i = 0

    while (prov == false && i < arr.length) {
        if (arr[i] == num2) {
            str = "Я знаю твоє місто!"
            prov = true
        } else {
            str = "Я НЕ знаю твоє місто!"
        }
        i++
    }

    console.log(str)
    $('#ins20').append('<p>' + `${str}` + '</p>')
}


//-------task#21----- Задача про банкомат ------ 
$('#btn_t21').click(function() {

    let numKart = parseInt($('#t21').val())
    let putMoney = parseInt($('#t22').val())
    let prov = true
    let arr = []
    let str = ''
    let sum = 0

    for (let i = 0; i <= 9; i++) {
        arr[i] = 0
    }

    while (prov == true) {
        if (numKart >= 1 && numKart <= 10) {
            prov = false
        } else {
            alert('Номер карты должно быть от 1 до 10')
            return false
        }
    }

    prov = true

    while (prov == true) {

        if (putMoney >= -1000 && putMoney <= 1000) {
            prov = false
            arr[numKart - 1] = putMoney

        } else {
            alert('Вы должны ввести значение от -1000 до 1000')
            return false
        }
    }

    for (let i = 0; i <= 9; i++) {
        str = str + arr[i] + ' '
        sum = sum + arr[i]
    }

    console.log(str + '\n' + 'v summe na vseh kartah: ' + sum)
    $('#t21_otv').append('<p>' + `${str}` + '<br>' + `v summe na vseh kartah: ${sum}` + '</p>')
})


//-------task#22----- Задача про відцетровану штуку ------ 
$('#btn_t22').click(function() {
    let count_ch = parseInt($('#t22_').val())
    if (count_ch > 20) {
        alert('Значение слишком велико')
        return false
    }
    for (let i = 1; i <= count_ch; i++) {

        $('#numbs_input').append('<input type="text" class="numbs" value="1">')

    }

    $('#ins22').append('<button id="btn_t22_2" onClick="cntrShuk();">Нарисовать</button>')
})

function cntrShuk() {
    let arr = []
    let a = 0
    let str = ''
    let num
    let max
    let empt
    prov = true

    $('.numbs').each(function(i, elem) {
        //alert(parseInt($(elem).val()))
        let prov = parseInt($(elem).val())
        if (prov % 2 == 0) {
            prov++
        }
        arr[a] = prov
        a++;
    })


    max = getMaxOfArray(arr)

    for (let i = 0; i < arr.length; i++) {
        str = str + makeStr((max - arr[i]) / 2, arr[i]) + '\n'
    }

    console.log(str)
}

function getMaxOfArray(numArray) {

    return Math.max.apply(null, numArray)
}

function makeStr(empt, notEmpt) {
    let str = ''
    for (let i = 1; i <= empt + notEmpt; i++) {
        i <= empt ? str = str + ' ' : str = str + '*'
    }
    return str
}

//-------task#23----- Задача про обчислення найбільшого числа за допомогою функції
$('#btn_t23').click(function() {
    let a = parseInt($('#t23_1').val())
    let b = parseInt($('#t23_2').val())
    $('#t23_otv').append(max(a, b) + '<br>')
    console.log(max(a, b) + '\n')

    function max(x, y) {
        // тут треба щось дописати...
        let maxNum
        x > y ? maxNum = x : maxNum = y
        return `Максимальное значение из двух введенных: ${maxNum}`
    }

})

//-------task#24----- Масив у зворотньому порядку

$('#btn_t24').click(function() {
    let count_ch = parseInt($('#t24').val())

    for (let i = 1; i <= count_ch; i++) {
        $('#mas_numbs_input').append('<input type="text" class="numbs_task_24" value="0">')
    }

    $('#ins24').append('<button id="btn_t24_2" onClick="main();">Новый массив</button>')
})

function main() {
    let arr = []
    let a = 0
    $('.numbs_task_24').each(function(i, elem) {
        arr[a] = parseInt($(elem).val())
        a++;
    })

    let str = ''

    for (let i = 0; i < arr.length; i++) {
        i < (arr.length - 1) ? str = str + arr[i] + ', ' : str = str + arr[i]
    }
    console.log('ось первинний масив:\n' + str);
    $('#ins24_1').append(`ось первинний масив: ${str}` + '<br>')

    str = ''
    for (let i = arr.length - 1; i >= 0; i--) {
        i > 0 ? str = str + arr[i] + ', ' : str = str + arr[i]
    }
    console.log('ось реверснутий масив:\n' + str)
    $('#ins24_1').append(`ось реверснутий масив: ${str}`)
}