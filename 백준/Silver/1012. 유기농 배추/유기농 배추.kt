import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder = StringBuilder()

    val T = br.readLine().toInt()

    for (i in 0 until T) {
        br.readLine().split(" ").map {
            it.toInt()
        }.let {
            val M = it[0]
            val N = it[1]
            val K = it[2]

            val arr = Array(N) {
                IntArray(M)
            }
            val visit = Array(N) {
                BooleanArray(M)
            }

            for (j in 0 until K) {
                br.readLine().split(" ").map {
                    it.toInt()
                }.let {
                    arr[it[1]][it[0]] = 1
                }
            }

            var count = 0
            for (j in 0 until N) {
                for (k in 0 until M) {
                    if (arr[j][k] == 1 && find(arr, visit, j, k))
                        count++
                }
            }
            stringBuilder.append("${count}\n")
        }
    }

    println(stringBuilder)
}

fun find(arr: Array<IntArray>, visit: Array<BooleanArray>, row: Int, col: Int): Boolean {
    if (visit[row][col])
        return false

    visit[row][col] = true

    if (row > 0 && arr[row - 1][col] == 1)
        find(arr, visit, row - 1, col)

    if (row < arr.size - 1 && arr[row + 1][col] == 1)
        find(arr, visit, row + 1, col)

    if (col > 0 && arr[row][col - 1] == 1)
        find(arr, visit, row, col - 1)

    if (col < arr[0].size - 1 && arr[row][col + 1] == 1)
        find(arr, visit, row, col + 1)

    return true
}