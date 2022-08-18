import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val A = it[0]
        val B = it[1]

        val visit = BooleanArray(B + 1)

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(B, 0))

        var min = Int.MAX_VALUE
        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val value = queue.poll()
                if (value.first == A && min > value.first) {
                    min = value.second
                    continue
                }
                else if (visit[value.first])
                    continue
                visit[value.first] = true

                if (value.first % 2 == 0)
                    queue.add(Pair(value.first / 2, value.second + 1))
                if (value.first % 10 == 1)
                    queue.add(Pair(value.first / 10, value.second + 1))
            }
        }

        if (min == Int.MAX_VALUE)
            min = -1
        else
            min++

        println(min)
    }
}