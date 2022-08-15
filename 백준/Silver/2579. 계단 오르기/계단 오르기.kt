import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    val arr = IntArray(N + 1)
    val dp = Array(2) {
        IntArray(N + 1)
    }

    for (i in 1 .. N) {
        arr[i] = br.readLine().toInt()
    }

    dp[0][1] = arr[1]
    if (N > 1)
        dp[1][2] = arr[2]
    for (i in 1 until  N) {
        if (i + 2 <= N)
            dp[1][i + 2] =  max(dp[0][i] + arr[i + 2], dp[1][i] + arr[i + 2])
        if (dp[0][i - 1] == 0) {
            dp[0][i + 1] = dp[0][i] + arr[i + 1]
        }
        else {
            dp[0][i + 1] = dp[1][i] + arr[i + 1]
        }
    }

    println(max(dp[0][N], dp[1][N]))
}