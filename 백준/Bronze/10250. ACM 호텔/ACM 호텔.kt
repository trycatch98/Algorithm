import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val stringBuilder = StringBuilder()

    for (i in 0 until T) {
        br.readLine().split(" ").map {
            it.toInt()
        }.let {
            val H  = it[0]
            val W = it[1]
            val N = it[2]

            val floor = if (N % H == 0) {
                H
            } else {
                N % H
            }

            val room = if (N % H == 0) {
                N / H
            } else {
                N / H + 1
            }

            val result = floor * 100 + room


            stringBuilder.append("$result\n")
        }
    }

    println(stringBuilder)
}