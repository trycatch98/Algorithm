import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val arr = Array(N) {
        Pair(0, 0)
    }
    for (i in 0 until N) {
        br.readLine().split(" ").map {
            it.toInt()
        }.let {
            arr[i] = Pair(it[0], it[1])
        }
    }

    arr.sortWith(compareBy<Pair<Int, Int>> {
        it.first
    }.thenBy {
        it.second
    })

    arr.forEach {
        println("${it.first} ${it.second}")
    }
}
