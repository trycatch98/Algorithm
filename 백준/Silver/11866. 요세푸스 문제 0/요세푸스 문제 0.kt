import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val N = it[0]
        val K = it[1]

        val queue: Queue<Int> = LinkedList()
        for (i in 1..N) {
            queue.add(i)
        }

        var count = 1
        val result = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            if (count == K) {
                result.add(queue.poll())
                count = 1
                continue
            }

            count++
            queue.add(queue.poll())
        }

        println("<${result.joinToString()}>")
    }
}
