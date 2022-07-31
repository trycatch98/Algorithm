import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine()?.toInt() ?: 0
    val list = mutableListOf<Int>()

    for (i in 0 until N) {
        list.add(br.readLine()?.toInt() ?: 0)
    }

    val result = StringBuilder()
    list.sorted().forEach {
        result.append("$it\n")
    }

    println(result)
}