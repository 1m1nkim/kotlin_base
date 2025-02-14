package com.ll

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
fun main() {
    val number = 10 // 불변 변수 선언 (val)
    var message = "Hello, Kotlin!" // 문자열 변수 선언

    println("Number: $number")
    println("Message: $message")

    val result = (if(11 % 2 ==0) "Even" else "Odd") + ": String"
    println(result)

    val resultAdd = add(1, 2)
    println(resultAdd)

    val p = Person("Han");
    p.greet()

    val names = listOf("Alice", "Bob", "Charlie") // 불변 리스트

    for (name in names) {
        println(name)
    }

    val nullname: String? = null

    println(nullname?.length ?: "Name is null")
    sayHello("Kotlin", 4)
    sayHello("Kotlin")

    val numbers = listOf(1,2,3,4,5,6)
    val evennumbers = numbers.filter { it % 2 ==0 }
    println(evennumbers)

    val numbersMap = listOf("A", "B", "C")
    val mapTest = numbersMap.map { "Hello, $it" }
    println(mapTest)

    val obj: Any ="Hello"
    if(obj is String)   //스마트 캐스트 적용
        println(obj.length)

    val namenulls: String?= null
    val namenullsnum = namenulls?.let{1} ?: 2
    println(namenullsnum)

    val messages = "Hello".also{
        println("Before: $it")
    }.uppercase().also{
        println("After: $it")
    }

    val runresult = run{
        val x = 5
        x * 2 + 10
    }
    println("Result: $runresult")
}

fun add(a: Int, b: Int): Int{
    return a+b
}

class Person(val name: String){
    fun greet(){
        println("Hello My name is $name")
    }
}

fun sayHello(name: String, age: Int = 100){
    println("Hello, $name")
}