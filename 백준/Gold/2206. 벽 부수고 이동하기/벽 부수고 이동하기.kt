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

        val arr = Array(N + 1) {
            IntArray(M + 1)
        }

        for (i in 1 .. N) {
            br.readLine().let {
                it.toCharArray().map {
                    it.digitToInt()
                }.forEachIndexed { index, value ->
                    arr[i][index + 1] = value
                }
            }
        }

        val queue: Queue<Sprite> = LinkedList()
        queue.add(Sprite(1, 1, false, 1))

        val visit = Array(2) {
            Array(N + 1) {
                BooleanArray(M + 1)
            }
        }

        var min = Int.MAX_VALUE

        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val sprite = queue.poll()
                val visitIndex = if (sprite.destroyed)
                    0
                else
                    1
                if (visit[visitIndex][sprite.row][sprite.col])
                    continue
                else if (sprite.row == N && sprite.col == M) {
                    if (min > sprite.count)
                        min = sprite.count
                }

                visit[visitIndex][sprite.row][sprite.col] = true

                if (sprite.row > 1 && !visit[visitIndex][sprite.row - 1][sprite.col]) {
                    if (arr[sprite.row - 1][sprite.col] == 1 && !sprite.destroyed)
                        queue.add(Sprite(sprite.row - 1, sprite.col, true, sprite.count + 1))
                    else if (arr[sprite.row - 1][sprite.col] == 0)
                        queue.add(Sprite(sprite.row - 1, sprite.col, sprite.destroyed, sprite.count + 1))
                }

                if (sprite.row < N && !visit[visitIndex][sprite.row + 1][sprite.col]) {
                    if (arr[sprite.row + 1][sprite.col] == 1 && !sprite.destroyed)
                        queue.add(Sprite(sprite.row + 1, sprite.col, true, sprite.count + 1))
                    else if (arr[sprite.row + 1][sprite.col] == 0)
                        queue.add(Sprite(sprite.row + 1, sprite.col, sprite.destroyed, sprite.count + 1))
                }

                if (sprite.col > 1 && !visit[visitIndex][sprite.row][sprite.col - 1]) {
                    if (arr[sprite.row][sprite.col - 1] == 1 && !sprite.destroyed)
                        queue.add(Sprite(sprite.row, sprite.col - 1, true, sprite.count + 1))
                    else if (arr[sprite.row][sprite.col - 1] == 0)
                        queue.add(Sprite(sprite.row, sprite.col - 1, sprite.destroyed, sprite.count + 1))
                }

                if (sprite.col < M && !visit[visitIndex][sprite.row][sprite.col + 1]) {
                    if (arr[sprite.row][sprite.col + 1] == 1 && !sprite.destroyed)
                        queue.add(Sprite(sprite.row, sprite.col + 1, true, sprite.count + 1))
                    else if (arr[sprite.row][sprite.col + 1] == 0)
                        queue.add(Sprite(sprite.row, sprite.col + 1, sprite.destroyed, sprite.count + 1))
                }
            }
        }

        println(
            if (min == Int.MAX_VALUE)
                -1
            else
                min
        )
    }
}

data class Sprite(
    val row: Int,
    val col: Int,
    var destroyed: Boolean,
    var count: Int
)