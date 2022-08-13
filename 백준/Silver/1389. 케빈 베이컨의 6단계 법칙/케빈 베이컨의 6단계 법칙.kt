import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val N = it[0]
        val M = it[1]

        val arr = Array(N + 1) {
            IntArray(N + 1) {
                M + 1
            }
        }

        for (i in 0 until M) {
            br.readLine().split(" ").map {
                it.toInt()
            }.let {
                arr[it[0]][it[0]] = 0
                arr[it[1]][it[1]] = 0
                arr[it[0]][it[1]] = 1
                arr[it[1]][it[0]] = 1
            }
        }

        for (i in 1 .. N) {
            for (j in 1 .. N) {
                for (k in 1 .. N) {
                    arr[j][k] = min(arr[j][k], arr[j][i] + arr[i][k])
                }
            }
        }

        var number = 0
        var minSum = Int.MAX_VALUE
        for (i in 1 .. N) {
            var sum = 0
            for (j in 1 .. N) {
                if (arr[i][j] < M + 1)
                    sum += arr[i][j]
            }

            if (minSum > sum) {
                minSum = sum
                number = i
            }
        }

        println(number)
    }
}