fun main() {
    val N = readLine()?.toInt() ?: 0

    var result = 666
    var i = 1
    while (i != N) {
        result++
        if ("$result".contains("666"))
            i++
    }

    println(result)
}