import java.util.*

fun main() {
    val T = readLine()?.toInt() ?: 0

    for (i in 0 until T) {
        readLine()?.split(" ")?.let {
            val N = it[0].toInt()
            val M = it[1].toInt()

            val list = mutableListOf<Pair<Int, Int>>()
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            readLine()?.split(" ")?.map {
                it.toInt()
            }?.forEachIndexed { index, i ->
                queue.add(Pair(index, i))
                list.add(Pair(index, i))
            }


            list.sortByDescending {
                it.second
            }

            var result = 0
            run {
                list.forEach {
                    for (j in 0 until queue.size) {
                        val value = queue.poll()
                        if (value.second != it.second) {
                            queue.add(value)
                        } else {
                            result++
                            if (value.first == M)
                                return@run
                            break
                        }
                    }
                }
            }

            println(result)
        }
    }
}