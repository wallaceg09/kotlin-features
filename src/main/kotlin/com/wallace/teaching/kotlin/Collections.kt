package com.wallace.teaching.kotlin

/**
 * Collection documentation: https://kotlinlang.org/docs/reference/collections.html
 */
fun main(args: Array<String>) {

    // Arrays are declared differently than in Java/.NET
    // The arrayOf() method
    val array: Array<String> = arrayOf("Hasta", "los", "tacos", "!")

    // The initialization method
    val array2: Array<String> = Array(3){""}

    // Each of the Kotlin primitives have their own optimized array.
    val intArray: IntArray = intArrayOf(1, 2, 3)

    val shortArray: ShortArray = shortArrayOf(1, 2, 3)

    // List interface is immutable. There are no modification methods implemented, so you cannot change any values.
    val immutableFoo: List<String> = listOf("Hello", "World", "!")
    println(immutableFoo[2])

    val mutableFoo: MutableList<String> = mutableListOf("Hello", "Mutable", "World", "!")
    mutableFoo[3] = "?"
    println(mutableFoo[3])

    // No more need for Java's stream() API
    immutableFoo.filter { it.contains("e", false) }.distinct()

    // Maps also have mutable and immutable versions
    val immutableMap: Map<String, String> = mapOf("foo" to "bar", "foofoo" to "barbar")

    val mutableMap: MutableMap<String, String> = mutableMapOf("foo" to "bar", "foofoo" to "barbar")
    mutableMap["foofoo"] = "barbarbar"

    // The term "foofoo" is so inappropriate!
    mutableMap.remove("foofoo")
}