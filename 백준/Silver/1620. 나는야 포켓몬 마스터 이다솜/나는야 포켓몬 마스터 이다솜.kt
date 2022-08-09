import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val N = it[0]
        val M = it[1]

        val map = HashMap<String, String>()
        for (i in 1 .. N) {
            val value = br.readLine()
            map[value] = "$i"
            map["$i"] = value
        }

        val stringBuilder = StringBuilder()
        for (i in 0 until M) {
            stringBuilder.append("${map[br.readLine()]}\n")
        }

        println(stringBuilder)
    }
}