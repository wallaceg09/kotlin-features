package com.wallace.teaching.kotlin.A

/**
 * Bog standard class.
 *
 * Defaults to `closed` which means nothing can extend it. Equivalent to `final class Foo {}` in Java.
 */
class ClosedClass(val foo: String)

/**
 * Will not compile, because closed classes cannot be subclassed.
 */
//class ClosedClassDeriv: ClosedClass()

/**
 * All classes can have default values!
 */
class ClosedClassWithDefault(val foo: String = "Hello Defaults!")

/**
 * Can have multiple constructors.
 *
 * Not the best example, but demonstrates that it can be done.
 */
class ClosedWithSecondConstructor(val foo: String, val bar: Int) {
    constructor(foo: String): this(foo, randomIntBetween0and10())

    companion object {
        fun randomIntBetween0and10(): Int {
            return (0 .. 10).random()
        }
    }
}

/**
 * Open class.
 *
 * Can be subclassed. Equivalent to `class Foo {}` in Java
 */
open class OpenClass(val foo: Int)

class OpenClassDerivative(foo: Int): OpenClass(foo)

/**
 * Bog standard abstract class.
 *
 * Defaults to `open`. Works basically identically to Java.
 */
abstract class AbstractClass

/**
 * Bog standard interface class.
 */
interface InterfaceClass {
    fun canHaveMethods()

    // `val` means "value field", implicitly provides a get() method
    val canHaveImmutableFields: String

    // `var` means "variable field", implicitly provides a get() and set() method
    var canHaveMutableFields: String
}

/**
 * Can extend interfaces.
 */
class InterfaceClassImpl(override val canHaveImmutableFields: String, override var canHaveMutableFields: String) :
    InterfaceClass {
    // Override super methods/fields with the `override` keyword
    override fun canHaveMethods() {
        println("Sure, why not.")
    }
}

interface AnotherInterfaceClass {
    fun foo()
}

/**
 * We can delegate an interface's implementation to another implementation
 */
class DelegatingClass(impl: InterfaceClassImpl): InterfaceClass by impl,
    AnotherInterfaceClass {
    override fun foo() {
        println("Not-delegated foo.")
    }
}

/**
 * Singleton class, lazily initialize and only single instance per JVM.
 */
object ObjectClass {
    val foo: String = "Hello World!"
}

/**
 * Data classes are meant to store data.
 *
 * Basically a struct. Provides defaults for equals(), hashCode(), toString(), destructuring, and copy()
 *
 * https://kotlinlang.org/docs/reference/data-classes.html
 */
data class DataClass(val foo: Int, val bar: String)

/**
 * Class whose privacy is scoped to this Kotlin file
 */
private class PrivateClass

/**
 * Class whose privacy is scoped to this Kotlin module
 */
internal class InternalClass

/**
 * There's no "static" keyword in Kotlin, instead we embed companion objects inside of classes!
 */
class ClassWithStatics {
    companion object {
        val foo: Int = 37
    }
}

fun main(args: Array<String>) {
    val myDataClass = DataClass(1, "")

    // We can destructure data classes.
    val(foo, bar) = myDataClass
    println(foo)
    println(bar)
}
