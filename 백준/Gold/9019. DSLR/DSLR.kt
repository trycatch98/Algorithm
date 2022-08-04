import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder = StringBuilder()
    val T = br.readLine().toInt()

    for (i in 0 until T) {
        br.readLine().split(" ").let {
            val A = it[0].toInt()
            val B = it[1].toInt()

            val queue: Queue<Pair<Int, String>> = LinkedList()
            val visit = mutableMapOf<Int, Boolean>()

            for (i in 0 until 4)
                queue.add(Pair(A, ""))

            run {
                while (true) {
                    for (i in 0 until queue.size) {
                        val value = queue.poll()
                        if (visit[value.first] == true)
                            continue

                        val (D, S, L, R) = calcDSLR(value.first)
                        visit[value.first] = true

                        if (D == B) {
                            stringBuilder.appendLine("${value.second}D")
                            return@run
                        } else {
                            queue.add(Pair(D, "${value.second}D"))
                        }

                        if (S == B) {
                            stringBuilder.appendLine("${value.second}S")
                            return@run
                        } else {
                            queue.add(Pair(S, "${value.second}S"))
                        }

                        if (L == B) {
                            stringBuilder.appendLine("${value.second}L")
                            return@run
                        } else {
                            queue.add(Pair(L, "${value.second}L"))
                        }

                        if (R == B) {
                            stringBuilder.appendLine("${value.second}R")
                            return@run
                        } else {
                            queue.add(Pair(R, "${value.second}R"))
                        }
                    }
                }
            }
        }
    }

    println(stringBuilder)
}

fun calcDSLR(num: Int): DSLR {
    val D = num * 2 % 10000
    val S = if (num == 0)
        9999
    else
        num - 1
    val L = run {
        num % 1000 * 10 + num / 1000
    }
    val R = run {
        num % 10 * 1000 + num / 10
    }

    return DSLR(D, S, L, R)
}

data class DSLR(
    val D: Int,
    val S: Int,
    val L: Int,
    val R: Int
)