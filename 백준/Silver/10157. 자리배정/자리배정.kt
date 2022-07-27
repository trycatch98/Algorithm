fun main() {
    var C = 0
    var R = 0
    readLine().let {
        it?.split(" ")?.
            map {
                it.toInt()
            }?.let {
                C = it[0]
                R = it[1]
            }
    }
    val K = readLine()?.toInt() ?: 0

    if (K > C * R)
        println(0)
    else {
        var row = 1
        var col = 1
        var i = 1
        var rowStart = 1
        var colStart = 1
        var flag = true
        while (i < K) {
            if (flag) {
                if (row in rowStart until R) {
                    row++
                }
                else if (col in colStart until C) {
                    col++
                }
                else if (row == R && col == C) {
                    flag = false
                    R--
                    row--
                    colStart++
                }
            }
            else {
                if (row in rowStart + 1..R) {
                    row--
                }
                else if (col in colStart + 1 .. C) {
                    col--
                }
                else if (row == rowStart && col == colStart) {
                    flag = true
                    rowStart++
                    row++
                    C--
                }

            }
            i++
        }
        println("$col $row")
    }
}