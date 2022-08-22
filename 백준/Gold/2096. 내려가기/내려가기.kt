import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    val minArr = Array(N + 1) {
        IntArray(3)
    }

    val maxArr = Array(N + 1) {
        IntArray(3)
    }

    for (i in 1 .. N) {
        br.readLine().split(" ").map {
            it.toInt()
        }.let {
            minArr[i][0] = min(minArr[i - 1][0] + it[0], minArr[i - 1][1] + it[0])
            minArr[i][1] = min(minArr[i - 1][0] + it[1], minArr[i - 1][1] + it[1])
            minArr[i][1] = min(minArr[i][1], minArr[i - 1][2] + it[1])
            minArr[i][2] = min(minArr[i - 1][1] + it[2], minArr[i - 1][2] + it[2])

            maxArr[i][0] = max(maxArr[i - 1][0] + it[0], maxArr[i - 1][1] + it[0])
            maxArr[i][1] = max(maxArr[i - 1][0] + it[1], maxArr[i - 1][1] + it[1])
            maxArr[i][1] = max(maxArr[i][1], maxArr[i - 1][2] + it[1])
            maxArr[i][2] = max(maxArr[i - 1][1] + it[2], maxArr[i - 1][2] + it[2])
        }
    }

    var minScore = Int.MAX_VALUE
    var maxScore = 0

    for (i in 0 until 3) {
        if (minScore > minArr[N][i])
            minScore = minArr[N][i]
        if (maxScore < maxArr[N][i])
            maxScore = maxArr[N][i]
    }

    println("$maxScore $minScore")
}