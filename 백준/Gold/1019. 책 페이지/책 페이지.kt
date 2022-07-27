fun main() {
    val N = readLine()?.toInt() ?: 0
    val result = arrayOfNulls<Int>(10)
    result.fill(0)

    var value = N
    var step = 1
    while (value > 0) {
        for (i in 1..9)
            result[i] = result[i]?.plus(1 * step)
        for (i in 0..9)
            result[i] = result[i]?.plus(((value / 10) - 1) * step)
        for (i in 0 until value % 10)
            result[i] = result[i]?.plus(step)

        result[value % 10] = result[value % 10]?.plus(N % step + 1)
        value /= 10
        step *= 10
    }

    println(
        result.joinToString(" ") {
            "$it"
        }
    )
}