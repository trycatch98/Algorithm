import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val N = it[0]
        val M = it[1]

        val arr = Array(N + 2) {
            IntArray(M + 2)
        }

        val tempList = mutableListOf<Pair<Int, Int>>()

        for (i in 1 .. N) {
            br.readLine().split(" ").map {
                it.toInt()
            }.forEachIndexed { index, value ->
                arr[i][index + 1] = value
            }
        }

        val dr = listOf(1, 0, -1, 0)
        val dc = listOf(0, 1, 0, -1)

        var time = 0

        do {
            tempList.clear()

            val queue: Queue<Pair<Int, Int>> = LinkedList()
            val visit = Array(N + 2) {
                BooleanArray(M + 2)
            }
            val countArr = Array(N + 2) {
                IntArray(M + 2)
            }
            queue.add(Pair(0, 0))

            while (queue.isNotEmpty()) {
                for (i in 0 until queue.size) {
                    val pos = queue.poll()

                    if (arr[pos.first][pos.second] == 1) {
                        countArr[pos.first][pos.second]++
                        if (countArr[pos.first][pos.second] < 2)
                            continue
                        var count = 0
                        for (j in dr.indices) {
                            val row = pos.first + dr[j]
                            val col = pos.second + dc[j]
                            if (row in 0 .. N + 1 && col in 0 .. M + 1 && arr[row][col] == 0)
                                count++
                        }

                        if (count >= 2)
                            tempList.add(pos)
                        continue
                    }
                    else if (visit[pos.first][pos.second])
                        continue
                    visit[pos.first][pos.second] = true


                    for (j in dr.indices) {
                        val row = pos.first + dr[j]
                        val col = pos.second + dc[j]
                        if (row in 0 .. N + 1 && col in 0 .. M + 1)
                            queue.add(Pair(row, col))
                    }
                }
            }

            tempList.forEach { pos ->
                arr[pos.first][pos.second] = 0
            }
            if (tempList.isNotEmpty())
                time++
        } while (tempList.isNotEmpty())

        println(time)
    }
}