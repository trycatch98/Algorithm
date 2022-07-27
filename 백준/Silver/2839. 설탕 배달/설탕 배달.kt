fun main() {
    val N = readLine()?.toInt() ?: 0
    var min = Int.MAX_VALUE

    for (i in 0 until N / 3) {
        if ((N - (3 * i)) % 5 == 0) {
            if (min > (N - (3 * i)) / 5 + i)
                min = (N - (3 * i)) / 5 + i
        }
    }

    if (N % 3 == 0 && N / 3 < min)
        min = N / 3
    else if (min == Int.MAX_VALUE)
        min = -1

    println(min)
}