import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()?.split(" ")?.map {
        it.toInt()
    }?.let {
        val N = it[0]
        val M = it[1]

        br.readLine()?.split(" ")?.map {
            it.toInt()
        }?.let {
            var result = 0

            for (i in 0 until it.size - 2) {
                for (j in i + 1 until it.size - 1) {
                    for (k in j + 1 until it.size) {
                        val sum = it[i] + it[j] + it[k]
                        if (sum in (result + 1)..M) {
                            result = sum
                        }
                    }
                }
            }

            println(result)
        }
    }
}