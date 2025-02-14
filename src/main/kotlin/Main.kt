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

class Person(val name: String, age: Int){// 주생성자
    init {
        println("Person 객체 생성 : $name, $age")
        //주 생성자 생성 이후 init 즉, 메인에서 생성 후 후처리를 위함
        require(age >= 0) {"나이는 0 이상"}
        check(name.isNotEmpty()){"이름은 비어있지 않아야함"}
    }
    constructor(name: String) : this(name, 0)
    //부 생성자,
    fun greet(){
        println("Hello My name is $name")
    }
}

fun sayHello(name: String, age: Int = 100){
    println("Hello, $name")
}

class Child{
    companion object: SuperClass(){
    }
}

open class SuperClass{
    fun greet() = println("Hello")
}

class PersonPrivate{
    // private val name:String ="Unknown" // 외부에서 읽기나 변경할 수 없음
    // private String name:String ="Unknown" // 둘 다 똑같음

    // val name: String = "Unknown" // private 제거 시 Getter만 사용할 수 있음

    //private var _name: String = "Unknown" // 내부 변수, 변수처럼 작동하는 함수
    //var name: String
        //get() = throw IllegalAccessException("읽기 금지") //setter를 만드려면 getter를 무조건 만들어야 해서 예외처리함
        //set(value){_name = value} // 가상의 값으로 변수 대입


}

//만약 name이 널일경우 코틀린에선 ?

class PersonNameNull(
    private var _name:String    //내부 변수
){
    var name:String
        get(){
            if(_name.isEmpty()){
                throw IllegalStateException("이름이 설정되지 않았습니다.")
            }
            return _name
        }
        set(value){
            require(value.isNotEmpty()){ // << requried는 throw와 비슷
                "이름은 null일 수 없다."
            }
            _name = value
        }
}
