package org.langrank.cheatsheet.kotlin

//интерфейсы
interface CanI {
  fun can(): String
}

fun main(args: Array<String>) {

  //ПЕРЕМЕННЫЕ (VARIABLES)
  println("\r\n----VARIABLES SECTION----\r\n")
  //В языке есть 2 типа переменных:

  //1 - изменяемые переменные
  var a = 10
  a = 3
  a = 1

  //2 - неизменяемые переменные
  val b = 2

  //ОШИБКА на этапе компиляции
  //b = 3

  //базовые операции над числовыми типами
  println(a + b)

  //Типы данных
  //Все значения переменных в Kotlin - это объекты
  //Все объекты наследуются от одного общего класса Any

  println(a is Any) //вернет true

  //Базовые типы данных

  //Для опреления типа переменной можно воспользоваться следующей формой
  println(Any::class)

  println(1::class)        //целое число
  println(1L::class)       //длинное целое
  println(1.0f::class)     //число с плавающей запятой, одинарной точности
  println(0x01::class)     //шестнадцатиричная форма представления числа
  println(0b1::class)      //двоичная форма представления числа
  println(0.1::class)      //число с плавающей точкой, двойной точности
  println('c'::class)      //символ
  println("string"::class) //строка
  println(true::class)     //булевое значение (true, false)

  //отдельной отметки заслуживают шаблонные строки

  val str = "a equal to $a, b equal to $b"
  println(str)

  //ФУНКЦИИ (FUNCTIONS)
  println("\r\n----FUNCTIONS SECTION----\r\n")

  //основная форма объявления функции
  fun sum(a: Int, b: Int): Int {
    return a + b
  }

  println("sum(1) of 1 and 2 = " + sum(1, 2)) //3

  //альтернативная форма записи
  fun sum_alt(a: Int, b: Int) = a + b

  println("sum(2) of 1 and 2 = " + sum_alt(1, 2)) //3

  //базовые знания о функциях расширениях
  //расширения типа Int с помощью функции возведения в степень

  fun Int.pow(n: Int) = Math.pow(this.toDouble(), n.toDouble())

  println("extension Int with pow function => " + 2.pow(2))

  //УСЛОВНЫЕ ВЫРАЖЕНИЯ (CONDITIONAL EXPRESSIONS)
  println("\r\n----CONDITIONAL EXPRESSION SECTION----\r\n")

  if (a > b) {
    println("a > b")
  }

  //выражение может возвращать значение
  val c = if (a > b) {
    a
  } else {
    b
  }
  println("c is equal to " + c)

  //на этой основе можно строить функции
  fun max(a: Int, b: Int) = if (a > b) a else b
  println(max(1, 2)) //2

  //выражение when - расширенный аналог конструкции switch в java (или других языках)
  when (a) {
    1 -> println("a is equal to " + a)
    2 -> println("a is not equal to" + a)
    else -> println("default branch")
  }

  //конструкция when является выражением и может возвращать значение

  val sqrtOfA = when(a * 4) {
    1 -> 1
    2 -> 1.41
    4 -> 2
    else -> throw Exception("not valid argument")
  }

  println("sqrt of a = " + sqrtOfA)

  //ЦИКЛЫ (cycle expression)

  //вывести на экран числа от 1 до 10
  for (a in 1..10) println(a)

  //в обратном порядке
  for (a in 10 downTo 1) println(a)

  //цикл for пригоден для итерирования по коллекциям
  var arr = Array<Int>(10, {i -> i + 1})
  for (item in arr) println("-> " + item)
  for ((index, item) in arr.withIndex()) println("" + index + " -> " + item)

  //ОБЪЕКТНО-ОРИЕНТИРОВАННОЕ ПРОГРАММИРОВАНИЕ (object oriented programming)
  println("\r\n----OBJECT ORIENTED PROGRAMMING SECTION----\r\n")

  //базовая форма определения класса
  class Item
  println(Item())

  //наследование (базовый вариант)
  class Item1: Any()
  println(Item1())

  //data классы
  //финальные классы, имеющие переопределенные методы toString, hashCode, equals, copy

  data class ItemWithName(val name: String)

  //использование в качестве ключа для hashMap
  val hashMap = mutableMapOf<ItemWithName, Int>()

  hashMap[ItemWithName("a")] = 1

  //ожидаем значение 1
  println(hashMap[ItemWithName("a")])
  //должны быть равны
  println(ItemWithName("a") == ItemWithName("a"))

  //реализация интерфейса
  class Person(val name: String): CanI {
    override fun can(): String {
      return "${this.name} can all"
    }
  }

  println(Person("John").can())

}
