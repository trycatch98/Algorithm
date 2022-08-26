import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val A = it[0]
        val B = it[1]
        val V = it[2]

        println((V - B - 1) / (A - B) + 1)
    }
}