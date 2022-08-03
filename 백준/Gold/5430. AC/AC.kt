import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder = StringBuilder()

    val T = br.readLine().toInt()

    for (i in 0 until T) {
        val command = br.readLine()
        val N = br.readLine().toInt()
        val deque: Deque<Int> = ArrayDeque()
        br.readLine().replace("\\[|\\]".toRegex(), "").split(",").filter {
            it.isNotEmpty()
        }.map {
            it.toInt()
        }.forEach {
            deque.add(it)
        }

        run {
            var r  = false
            command.forEach {
                when (it) {
                    'R' -> {
                        r = !r
                    }
                    'D' -> {
                        if (deque.isEmpty()) {
                            stringBuilder.appendLine("error")
                            return@run
                        }
                        else if (r)
                            deque.pollLast()
                        else
                            deque.pollFirst()
                    }
                    else -> {}
                }
            }

            stringBuilder.appendLine(
                if (r) {
                    "${deque.reversed()}".replace(" ", "")
                }
                else {
                    "$deque".replace(" ", "")
                }
            )
        }
    }

    println(stringBuilder)
}