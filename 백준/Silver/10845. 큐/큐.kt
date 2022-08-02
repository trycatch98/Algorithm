import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val queue: Queue<Int> = LinkedList()
    val stringBuilder = StringBuilder()

    val N = br.readLine().toInt()

    for (i in 0 until N) {
        br.readLine().split(" ").let {
            when (it[0]) {
                "push" -> {
                    queue.add(it[1].toInt())
                }
                "pop" -> {
                    stringBuilder.append(
                        if (queue.isEmpty()) "-1\n"
                        else "${queue.poll()}\n"
                    )
                }
                "size" -> {
                    stringBuilder.append("${queue.size}\n")
                }
                "empty" -> {
                    stringBuilder.append(
                        if (queue.isEmpty()) "1\n"
                        else "0\n"
                    )
                }
                "front" -> {
                    stringBuilder.append(
                        if (queue.isEmpty()) "-1\n"
                        else "${queue.peek()}\n"
                    )
                }
                "back" -> {
                    stringBuilder.append(
                        if (queue.isEmpty()) "-1\n"
                        else "${queue.last()}\n"
                    )
                }
                else -> {}
            }
        }
    }

    println(stringBuilder)
}