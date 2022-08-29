import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    val stack = Stack<Int>()

    for (i in 0 until N) {
        val M = br.readLine().toInt()
        if (M == 0 && stack.isNotEmpty()) {
            stack.pop()
        }
        else {
            stack.push(M)
        }
    }

    var sum = 0
    stack.forEach {
        sum += it
    }
    println(sum)
}