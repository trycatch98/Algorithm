import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val arr = IntArray(101) {
        it
    }

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val N = it[0]
        val M = it[1]

        for (i in 0 until N + M) {
            br.readLine().split(" ").map {
                it.toInt()
            }.let {
                arr[it[0]] = it[1]
            }
        }
    }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val visit = BooleanArray(101)
    queue.add(Pair(1, 0))

    var min = Int.MAX_VALUE
    while (queue.isNotEmpty()) {
        for (i in 0 until queue.size) {
            val player = queue.poll()

            if (player.first == 100) {
                if (min > player.second)
                    min = player.second
                break
            }

            if (visit[player.first])
                break
            visit[player.first] = true

            for (j in 1..6) {
                if (player.first + j < arr.size)
                    queue.add(Pair(arr[player.first + j], player.second + 1))
            }
        }
    }

    println(min)
}