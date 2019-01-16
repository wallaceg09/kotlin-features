package com.wallace.teaching.kotlin.E

fun main(args: Array<String>) {
    // Cannot be null.
    val foo: Int = 0

    // All method calls on this are guaranteed to be null safe.
    foo.toByte().toString()

    // May be null
    val nullaFoo: Int? = listOf(0, 1, null).random()

    // Does not compile, because nullaFoo can be null...
//    val nullStr1 = nullaFoo.toByte().toString()

    // Compiles. ?. will return null if nullaFoo is null, otherwise continue along the chain
    val nullStr2: String? = nullaFoo?.toByte().toString()

    // Elvis operator ?: means if left is null, return right. So if nullaFoo is null, then nullstr4 will equal 0
    val bar = nullaFoo?:0.toByte().toString()

    // Smart casting for fun and profit
    if(nullaFoo != null) {
        // For this entire block, nullaFoo is known to not be null, so no elvises or null safety needed!
        val nullstr3 = nullaFoo.toByte().toString()
    }

    // Compiles. !! will throw a null pointer exception if nullaFoo is null
    val nullstr4 = nullaFoo!!.toByte().toString()

    nullaFoo.toByte()


}