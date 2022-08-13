import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    val arr = Array(N + 1) {
        IntArray(3)
    }

    for (i in 1 .. N) {
        br.readLine().split(" ").map {
            it.toInt()
        }.let {
            val R = it[0]
            val G = it[1]
            val B = it[2]

            arr[i][0] = min(arr[i - 1][1] + R, arr[i - 1][2] + R)
            arr[i][1] = min(arr[i - 1][0] + G, arr[i - 1][2] + G)
            arr[i][2] = min(arr[i - 1][0] + B, arr[i - 1][1] + B)
        }
    }

    var minPrice = Int.MAX_VALUE
    for (i in 0 until 3) {
        minPrice = min(minPrice, arr[N][i])
    }

    println(minPrice)
}