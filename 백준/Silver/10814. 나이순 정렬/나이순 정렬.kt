import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val list = mutableListOf<Triple<Int, Int, String>>()

    for (i in 0 until N) {
        br.readLine().split(" ").let {
            list.add(Triple(i, it[0].toInt(), it[1]))
        }
    }

    list.sortWith(
        compareBy<Triple<Int, Int, String>> {
            it.second
        }.thenBy {
            it.first
        }
    )

    list.forEach {
        println("${it.second} ${it.third}")
    }
}