import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val T = br.readLine().toInt()

    for (i in 0 until T) {
        val N = br.readLine().toInt()
        val dp = IntArray( 12)
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4

        for (j in 4..N) {
            dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3]
        }
        println(dp[N])
    }
}