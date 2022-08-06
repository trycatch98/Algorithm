import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var arr: Array<IntArray>
lateinit var visit: Array<BooleanArray>
lateinit var tetromino: MutableList<MutableList<MutableList<Boolean>>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val N = it[0]
        val M = it[1]

        arr = Array(N) {
            IntArray(M) {
                -1
            }
        }

        visit = Array(N) {
            BooleanArray(M)
        }

        tetromino = mutableListOf<MutableList<MutableList<Boolean>>>()

        tetromino.apply {
            // -
            add(
                mutableListOf(
                    mutableListOf(
                        true, true, true, true
                    )
                )
            )

            // |
            add(
                mutableListOf(
                    mutableListOf(true),
                    mutableListOf(true),
                    mutableListOf(true),
                    mutableListOf(true)
                )
            )

            // ☐
            add(
                mutableListOf(
                    mutableListOf(true, true),
                    mutableListOf(true, true)
                )
            )

            // |_
            add(
                mutableListOf(
                    mutableListOf(true),
                    mutableListOf(true),
                    mutableListOf(true, true)
                )
            )

            // _|
            add(
                mutableListOf(
                    mutableListOf(false, true),
                    mutableListOf(false, true),
                    mutableListOf(true, true)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(false, false, true),
                    mutableListOf(true, true, true)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(true),
                    mutableListOf(true, true, true)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(true, true, true),
                    mutableListOf(true)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(true, true, true),
                    mutableListOf(false, false, true)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(true, true),
                    mutableListOf(false, true),
                    mutableListOf(false, true)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(true, true),
                    mutableListOf(true),
                    mutableListOf(true)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(true, false),
                    mutableListOf(true, true),
                    mutableListOf(false, true)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(false, true),
                    mutableListOf(true, true),
                    mutableListOf(true, false)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(false, true, true),
                    mutableListOf(true, true)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(true, true, false),
                    mutableListOf(false, true, true)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(true, true, true),
                    mutableListOf(false, true, false)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(false, true, false),
                    mutableListOf(true, true, true)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(false, true),
                    mutableListOf(true, true),
                    mutableListOf(false, true)
                )
            )

            add(
                mutableListOf(
                    mutableListOf(true, false),
                    mutableListOf(true, true),
                    mutableListOf(true, false)
                )
            )
        }

        for (i in 0 until N) {
            br.readLine().split(" ").map {
                it.toInt()
            }.forEachIndexed { index, value ->
                arr[i][index] = value
            }
        }

        var max = 0
        arr.forEachIndexed { row, ints ->
            ints.forEachIndexed { col, i ->
                val sum = find(row, col)
                if (max < sum)
                    max = sum
            }
        }

        println(max)
    }
}

fun find(row: Int, col: Int): Int {
    if (visit[row][col])
        return 0

    visit[row][col] = true

    var max = 0
    tetromino.forEach {
        var sum = 0
        it.forEachIndexed { tetroRow, booleans ->
            booleans.forEachIndexed { tetroCol, b ->
                if (b) {
                    try {
                        sum += arr[row + tetroRow][col + tetroCol]
                    } catch (_: Exception) {
                        return@forEach
                    }
                }
            }
        }

        if (max < sum)
            max = sum
    }

    return max
}