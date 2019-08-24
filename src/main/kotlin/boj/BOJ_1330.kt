package boj

import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val a = reader.nextInt()
    val b = reader.nextInt()
    val opt = if (a > b) {
        ">"
    } else if (a == b) {
        "=="
    } else {
        "<"
    }
    print(opt)
}