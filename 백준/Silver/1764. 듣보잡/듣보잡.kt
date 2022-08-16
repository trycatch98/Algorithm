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

        for (i in 0 until N) {
            val value = br.readLine()
            map[value] = value
        }

        val result = mutableListOf<String>()
        for (i in 0 until M) {
            map[br.readLine()]?.let {
                result.add(it)
            }
        }

        val stringBuilder = StringBuilder()
        stringBuilder.append("${result.size}\n")
        result.sorted().forEach {
            stringBuilder.append("$it\n")
        }

        println(stringBuilder)
    }
}