import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder = StringBuilder()

    val T = br.readLine().toInt()

    val memo = Array(41) {
        Pair(-1, -1)
    }
    for (i in 0 until T) {
        val num = br.readLine().toInt()
        for (j in 0 .. num) {
            memo[j] = fibonacci(j, memo)
        }
        stringBuilder.append("${memo[num].first} ${memo[num].second}\n")
    }

    println(stringBuilder)
}

fun fibonacci(n: Int, memo: Array<Pair<Int, Int>>): Pair<Int, Int> {
    if (memo[n].first != -1)
        return memo[n]
    return when (n) {
        0 -> {
            Pair(1, 0)
        }
        1 -> {
            Pair(0, 1)
        }
        else -> {
            fibonacci(n - 1, memo) + fibonacci(n - 2, memo)
        }
    }
}

operator fun Pair<Int, Int>.plus(b: Pair<Int, Int>): Pair<Int, Int> {
    return Pair(this.first + b.first, this.second + b.second)
}