import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val map = mutableMapOf<Int, Int>()
    val stringBuilder = StringBuilder()

    val N = br.readLine().toInt()

    br.readLine().split(" ").map {
        it.toInt()
    }.forEach {
        map[it] = (map[it] ?: 0) + 1
    }

    val M = br.readLine().toInt()
    br.readLine().split(" ").map {
        it.toInt()
    }.forEach {
        stringBuilder.append("${map[it] ?: 0} ")
    }

    println(stringBuilder)
}