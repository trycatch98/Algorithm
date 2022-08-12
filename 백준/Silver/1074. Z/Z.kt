import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val N = it[0]
        val r = it[1]
        val c = it[2]

        val size = 2f.pow(N).toInt()

        divide(0, size, 0, size, r, c)
    }
}

var count = 0

fun divide(startRow: Int, endRow: Int, startCol: Int, endCol: Int, r: Int, c: Int) {
    if (count % 4 != 0) {
        return
    }
    else if (endRow - startRow == 2) {
        z(startRow, endRow, startCol, endCol, r, c)
    }
    else {
        if (r in startRow..endRow && c in startCol .. endCol) {
            divide(startRow, (startRow + endRow) / 2, startCol, (startCol + endCol) / 2, r, c)
            divide(startRow, (startRow + endRow) / 2, (startCol + endCol) / 2, endCol, r, c)
            divide((startRow + endRow) / 2, endRow, startCol, (startCol + endCol) / 2, r, c)
            divide((startRow + endRow) / 2, endRow, (startCol + endCol) / 2, endCol, r, c)
        }
        else {
            count += (endRow - startRow) * (endCol - startCol)
        }
    }
}

fun z(startRow: Int, endRow: Int, startCol: Int, endCol: Int, r: Int, c: Int) {
    for (i in startRow until endRow) {
        for (j in startCol until endCol) {
            if (i == r && j == c)
                println("$count")
            else
                count++
        }
    }
}