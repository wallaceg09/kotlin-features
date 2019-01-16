package com.wallace.teaching.kotlin.G

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    val start = System.currentTimeMillis()
    val primes = sieveOfEratosthenes(100_000)
    val stop = System.currentTimeMillis()

    println("Took ${(stop - start) / 1000.0} seconds")
    println(primes)
}

fun sieveOfEratosthenes(n: Int): List<Int> {
    val candidates = IntArray(n) { if (it == 1) 0 else it }

    try {
        sieve(candidates, 2)
    } catch (e: NoSuchElementException) {

    }

    return candidates.filter { it > 0 }
}

fun sieve(candidates: IntArray, p: Int) {
//    println("Sieving number $p")
    val jobs = filter(candidates, p)

    runBlocking {
        jobs.forEach { it.join() }
    }

    val next = candidates.first { it != 0 && it > p }
    sieve(candidates, next)

}

fun filter(candidates: IntArray, p: Int): List<Job> {
    val jobs = mutableListOf<Job>()

    for (i in p until candidates.size step p) {
        jobs.add(GlobalScope.launch {
            if (i != p) candidates[i] = 0
        })
    }

    return jobs
}