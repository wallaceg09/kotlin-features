package com.wallace.teaching.kotlin.C

fun classlessFunction() {
    println("Hello World without Classes!")
}

fun functionWithParam(foo: Int) {
    println(foo)
}

fun functionWithDefaultParam(foo: Int, bar: String = "fetchez la vache!") {
    println(foo)
    println(bar)
}

/**
 * Extension methods.
 *
 * Similar to .NET.
 */
fun Int.isEven(): Boolean {
    return this % 2 == 0
}

/**
 * Functions are first-class citizens.
 */
fun functionTakesInFunction(foo: () -> Unit) {
    foo()
}

/**
 * They can even have parameters and outputs!
 */
fun functionTakesInFunctionWithParamAndOutput(foo: (Int) -> Boolean) {
    foo(3)
}

/**
 * Even more parameters!
 */
fun functionTakesInFunctionWithMultipleParamsAndOutput(foo: (first: Int, second: Int) -> Int) {
    foo(3, 4)
}

inline fun inlineingFunctionsForProfit(foo: ()-> Unit) {
    println("This has to be the most pointless inlined function in the history of inlined functions...")
    foo()
}

/**
 * We can even have infix methods!
 */
infix fun String.before(other: String) {
    println("$this is before $other")
}

/**
 * This totally won't be abused...
 *
 * Seriously, don't abuse this.
 */
fun funception() {
    println("Deep")
    fun funceptionion() {
        println("Deeper")
        fun funceptionionion() {
            println("Deepest!")
        }
        funceptionionion()
    }
    funceptionion()
}

/**
 * Entrypoint method.
 */
fun main(args: Array<String>) {
    classlessFunction()

    functionWithParam(3)
    functionWithDefaultParam(2)
    functionWithDefaultParam(2, "Eh??")
    functionWithDefaultParam(1, bar = "FECHEZ LA VACHE!")

    val twoIsEven = 2.isEven()

    // We have simple string templates.
    println("Is 2 even? $twoIsEven")

    // We also have complex string templates.
    println("Is 3 even? ${3.isEven()}")

    // Can pass a function to a function that takes functions.
    functionTakesInFunction(::classlessFunction)

    // Closures are pretty neat too!
    functionTakesInFunction { println("Closures are awesome!") }

    // `it` is the implicit value of the single parameter
    functionTakesInFunctionWithParamAndOutput { it.isEven() }

    // Can't use `it` because there are multiple parameters.
    functionTakesInFunctionWithMultipleParamsAndOutput { first, second -> first + second }

    funception()

    inlineingFunctionsForProfit(::funception)

    "This" before "that"
}