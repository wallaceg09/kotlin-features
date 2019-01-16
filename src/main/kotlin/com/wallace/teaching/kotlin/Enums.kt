package com.wallace.teaching.kotlin

/**
 * We have enums!
 *
 * https://kotlinlang.org/docs/reference/enum-classes.html
 */
enum class PhillipCountingEnum {
    ONE, FIVE, THREE
}

/**
 * They can even have fields!
 */
enum class AlsoEnumsWithFields(val foo: Int) {
    ONE(1), FIVE(2), THREE(Int.MAX_VALUE)
}

/**
 * Sealed classes are like enums, but they can have individual states.
 *
 * https://kotlinlang.org/docs/reference/sealed-classes.html
 */
sealed class SealedClass(val name: String)

class Cow(name: String, val weight: Int): SealedClass(name)
class Dog(name: String, val temperment: String): SealedClass(name)
class Cat(name: String): SealedClass(name)

fun main(args: Array<String>) {
    val number = PhillipCountingEnum.FIVE

    // No switch statements, only when patterns!
    when(number) {
        PhillipCountingEnum.ONE -> println("One!")
        PhillipCountingEnum.FIVE -> println("Two!")
        PhillipCountingEnum.THREE -> println("Three!")
    }

    val otherNumber = AlsoEnumsWithFields.FIVE

    // When patterns are expressions!
    val foo = when(otherNumber) {
        AlsoEnumsWithFields.ONE -> "One!"
        AlsoEnumsWithFields.FIVE -> "Two!"
        AlsoEnumsWithFields.THREE -> "Three!!!"
    }

    val animals = listOf<SealedClass>(Cow("Dolly", 30), Dog("Fido", "Snappy"), Cat("Mr.s Purrrrfect"))

    for(animal in animals) {
        when(animal) {
            is Cow -> println("${animal.name} goes Mooo! And she weights ${animal.weight} kilograms.")
            is Dog -> println("${animal.name} goes Wooof! And her temperment is ${animal.temperment}.")
            is Cat -> print("${animal.name} is a cat, and is planning to murder you in your sleep...")
        }
    }

    val animal = animals.random()

    // Because this is an assignment expression, removing any of these causes a compile-time error
    val bar: Any = when(animal) {
        is Cow -> animal.weight
        is Dog -> animal.temperment
        is Cat -> animal.name
    }

    println(bar)
}