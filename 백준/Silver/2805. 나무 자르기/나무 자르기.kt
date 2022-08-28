import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val N = it[0]
        val M = it[1]

        val arr = IntArray(N)

        br.readLine().split(" ").map {
            it.toInt()
        }.forEachIndexed { index, i ->
            arr[index] = i
        }

        var start = 0
        var end = arr.maxOrNull()!!

        while (true) {
            val H = (start + end) / 2
            var sum = 0L

            arr.forEach {
                if (it > H)
                    sum += it - H
            }

            if(sum.toInt() == M || start + 1 >= end) {
                println(H)
                break
            }
            else if (sum > M) {
                start = H
            }
            else {
                end = H
            }
        }

    }
}