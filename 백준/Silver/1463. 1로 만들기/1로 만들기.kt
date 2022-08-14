import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    val memo = IntArray(N + 1) {
        0
    }

    for (i in 2 .. N) {
        memo[i] = memo[i - 1] + 1

        if (i % 3 == 0) {
            memo[i] = min(memo[i / 3] + 1, memo[i])
        }

        if (i % 2 == 0) {
            memo[i] = min(memo[i / 2] + 1, memo[i])
        }
    }

    println(memo[N])
}