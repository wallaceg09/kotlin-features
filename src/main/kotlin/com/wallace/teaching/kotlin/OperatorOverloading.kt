package com.wallace.teaching.kotlin

/**
 * Small snippet from a class for Complex number computation. Utilizes operator overloading to make math with these
 * complex numbers simpler.
 *
 * https://kotlinlang.org/docs/reference/operator-overloading.html
 */
data class Complex(val real: Double, val imaginary: Double = 0.0) {

    operator fun plus(other: Complex): Complex {
        val newReal = real + other.real
        val newImag = imaginary + other.imaginary
        return Complex(real = newReal, imaginary = newImag)
    }

    operator fun plus(scalar: Double): Complex {
        return copy(real = real + scalar)
    }
}

fun main(args: Array<String>) {
    val complex1 = Complex(1.0, 3.0)
    val complex2 = Complex(2.3, 4.5)

    println(complex1 + complex2)
}