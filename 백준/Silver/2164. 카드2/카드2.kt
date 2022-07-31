import java.util.*

fun main() {
    val N = readLine()?.toInt() ?: 0
    val queue: Queue<Int> = LinkedList<Int>()

    for (i in 1..N)
        queue.add(i)

    for (i in 0 until queue.size - 1) {
        queue.poll()
        queue.add(queue.poll())
    }

    println(queue.poll())
}