import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val arr = Array(N) {
        IntArray(N)
    }

    val queue: Queue<Shark> = LinkedList()
    val fish = mutableListOf<Fish>()

    var shark = Shark(2, 0, 0, 0)

    for (i in 0 until N) {
        br.readLine().split(" ").map {
            it.toInt()
        }.forEachIndexed { index, value ->
            arr[i][index] = value
            if (value == 9) {
                shark = Shark(2, 0, i, index)
                arr[i][index] = 0
                queue.add(shark)
            }
            else if (value > 0) {
                fish.add(Fish(value, i, index))
            }
        }
    }

    var timeSum = 0
    while (true) {
        val miniFish = run {
            val tempFish = fish.filter {
                it.size < shark.size
            }.sortedWith(
                compareBy<Fish> {
                    abs(it.row - shark.row) + abs(it.col - shark.col)
                }.thenBy {
                    it.row
                }.thenBy {
                    it.col
                }
            )

            val oneDiff = tempFish.filter {
                abs(it.row - shark.row) + abs(it.col - shark.col) == 1
            }

            oneDiff.ifEmpty { tempFish }
        }

        if (miniFish.isEmpty())
            break

        var minTime = Int.MAX_VALUE
        var minFish: Fish? = null

        miniFish.forEach { fish ->
            val visit = Array(N) {
                BooleanArray(N)
            }

            while (queue.isNotEmpty()) {
                for (i in 0 until queue.size) {
                    val shark = queue.poll()
                    if (fish.row == shark.row && fish.col == shark.col) {
                        if (minTime > shark.time) {
                            minTime = shark.time
                            minFish = fish
                        }
                        break
                    } else if (visit[shark.row][shark.col])
                        break

                    visit[shark.row][shark.col] = true

                    if (shark.row > 0 && arr[shark.row - 1][shark.col] <= shark.size) {
                        queue.add(shark.copy(row = shark.row - 1, time = shark.time + 1))
                    }

                    if (shark.col > 0 && arr[shark.row][shark.col - 1] <= shark.size) {
                        queue.add(shark.copy(col = shark.col - 1, time = shark.time + 1))
                    }

                    if (shark.row < arr.size - 1 && arr[shark.row + 1][shark.col] <= shark.size) {
                        queue.add(shark.copy(row = shark.row + 1, time = shark.time + 1))
                    }

                    if (shark.col < arr[shark.row].size - 1 && arr[shark.row][shark.col + 1] <= shark.size) {
                        queue.add(shark.copy(col = shark.col + 1, time = shark.time + 1))
                    }
                }
            }
            queue.add(shark)
        }

        minFish?.let {
            shark.eat++
            if (shark.eat == shark.size) {
                shark.size++
                shark.eat = 0
            }
            shark.row = it.row
            shark.col = it.col
            timeSum += minTime
            fish.remove(it)
        } ?: break
    }
    println(timeSum)
}

data class Shark(
    var size: Int,
    var eat: Int,
    var row: Int,
    var col: Int,
    var time: Int = 0
)

data class Fish(
    val size: Int,
    val row: Int,
    val col: Int
)
