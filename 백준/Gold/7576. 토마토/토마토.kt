import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val M = it[0]
        val N = it[1]

        val arr = Array(N) {
            Array(M) {
                -1
            }
        }

        val queue: Queue<Pair<Int, Int>> = LinkedList()

        for (i in 0 until  N) {
            br.readLine().split(" ").map {
                it.toInt()
            }.forEachIndexed { index, value ->
                arr[i][index] = value
                if (value == 1)
                    queue.add(Pair(i, index))
            }
        }

        var result = -1
        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val pos = queue.poll()

                if (pos.first > 0 && arr[pos.first - 1][pos.second] == 0) {
                    arr[pos.first - 1][pos.second] = 1
                    queue.add(Pair(pos.first - 1, pos.second))
                }

                if (pos.first < N - 1 && arr[pos.first + 1][pos.second] == 0) {
                    arr[pos.first + 1][pos.second] = 1
                    queue.add(Pair(pos.first + 1, pos.second))
                }

                if (pos.second > 0 && arr[pos.first][pos.second - 1] == 0) {
                    arr[pos.first][pos.second - 1] = 1
                    queue.add(Pair(pos.first, pos.second - 1))
                }

                if (pos.second < M - 1 && arr[pos.first][pos.second + 1] == 0) {
                    arr[pos.first][pos.second + 1] = 1
                    queue.add(Pair(pos.first, pos.second + 1))
                }
            }
            result++
        }

        run {
            arr.forEach {
                it.forEach {
                    if (it == 0) {
                        result = -1
                        return@run
                    }
                }
            }
        }
        println(result)
    }
}