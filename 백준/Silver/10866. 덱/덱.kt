import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val dequeue: Deque<Int> = ArrayDeque()
    val stringBuilder = StringBuilder()

    val N = br.readLine().toInt()

    for (i in 0 until N) {
        br.readLine().split(" ").let {
            when (it[0]) {
                "push_front" -> {
                    dequeue.addFirst(it[1].toInt())
                }
                "push_back" -> {
                    dequeue.addLast(it[1].toInt())
                }
                "pop_front" -> {
                    stringBuilder.append(
                        if (dequeue.isEmpty()) "-1\n"
                        else "${dequeue.pollFirst()}\n"
                    )
                }
                "pop_back" -> {
                    stringBuilder.append(
                        if (dequeue.isEmpty()) "-1\n"
                        else "${dequeue.pollLast()}\n"
                    )
                }
                "size" -> {
                    stringBuilder.append("${dequeue.size}\n")
                }
                "empty" -> {
                    stringBuilder.append(
                        if (dequeue.isEmpty()) "1\n"
                        else "0\n"
                    )
                }
                "front" -> {
                    stringBuilder.append(
                        if (dequeue.isEmpty()) "-1\n"
                        else "${dequeue.peekFirst()}\n"
                    )
                }
                "back" -> {
                    stringBuilder.append(
                        if (dequeue.isEmpty()) "-1\n"
                        else "${dequeue.peekLast()}\n"
                    )
                }
                else -> {}
            }
        }
    }

    println(stringBuilder)
}