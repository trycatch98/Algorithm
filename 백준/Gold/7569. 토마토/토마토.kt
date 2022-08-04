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
        val H = it[2]

        val arr = Array(H) {
            Array(N) {
                Array(M) {
                    -1
                }
            }
        }

        val queue: Queue<Triple<Int, Int, Int>> = LinkedList()

        for (i in 0 until  H) {
            for (j in 0 until  N) {
                br.readLine().split(" ").map {
                    it.toInt()
                }.forEachIndexed { index, value ->
                    arr[i][j][index] = value
                    if (value == 1)
                        queue.add(Triple(i, j, index))
                }
            }
        }

        var result = -1
        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val pos = queue.poll()

                if (pos.first > 0 && arr[pos.first - 1][pos.second][pos.third] == 0) {
                    arr[pos.first - 1][pos.second][pos.third] = 1
                    queue.add(Triple(pos.first - 1, pos.second, pos.third))
                }

                if (pos.first < H - 1 && arr[pos.first + 1][pos.second][pos.third] == 0) {
                    arr[pos.first + 1][pos.second][pos.third] = 1
                    queue.add(Triple(pos.first + 1, pos.second, pos.third))
                }

                if (pos.second > 0 && arr[pos.first][pos.second - 1][pos.third] == 0) {
                    arr[pos.first][pos.second - 1][pos.third] = 1
                    queue.add(Triple(pos.first, pos.second - 1, pos.third))
                }

                if (pos.second < N - 1 && arr[pos.first][pos.second + 1][pos.third] == 0) {
                    arr[pos.first][pos.second + 1][pos.third] = 1
                    queue.add(Triple(pos.first, pos.second + 1, pos.third))
                }

                if (pos.third > 0 && arr[pos.first][pos.second][pos.third - 1] == 0) {
                    arr[pos.first][pos.second][pos.third - 1] = 1
                    queue.add(Triple(pos.first, pos.second, pos.third - 1))
                }

                if (pos.third < M - 1 && arr[pos.first][pos.second][pos.third + 1] == 0) {
                    arr[pos.first][pos.second][pos.third + 1] = 1
                    queue.add(Triple(pos.first, pos.second, pos.third + 1))
                }
            }
            result++
        }

        run {
            arr.forEach {
                it.forEach {
                    it.forEach {
                        if (it == 0) {
                            result = -1
                            return@run
                        }
                    }
                }
            }
        }
        println(result)
    }
}