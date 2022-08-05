import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val arr = Array(N) {
        Array(N){
            ""
        }
    }

    for (i in 0 until N) {
        br.readLine().forEachIndexed { index, c ->
            val value = c.toString()
            arr[i][index] = value
        }
    }

    var count = 0
    var visit = Array(N) {
        BooleanArray(N)
    }
    arr.forEachIndexed { row, strings ->
        strings.forEachIndexed { col, s ->
            if (find(arr, visit, s, row, col))
                count++
        }
    }

    var count2 = 0
    visit = Array(N) {
        BooleanArray(N)
    }
    arr.forEachIndexed { row, strings ->
        strings.forEachIndexed { col, s ->
            if (find(arr, visit, s, row, col))
                count2++
        }
    }

    println("$count $count2")
}

fun find(arr: Array<Array<String>>, visit: Array<BooleanArray>, base: String, row: Int, col: Int): Boolean {
    if (visit[row][col])
        return false

    visit[row][col] = true
    if (col < arr[row].size - 1 && base == arr[row][col + 1]) {
        find(arr, visit, base, row, col + 1)
    }

    if (col > 0 && base == arr[row][col - 1]) {
        find(arr, visit, base, row, col - 1)
    }

    if (row < arr.size - 1 && base == arr[row + 1][col]) {
        find(arr, visit, base, row + 1, col)
    }

    if (row > 0 && base == arr[row - 1][col]) {
        find(arr, visit, base, row - 1, col)
    }

    if (arr[row][col] == "G")
        arr[row][col] = "R"

    return true
}