import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val N = it[0]
        val M = it[1]
        val X = it[2]

        val graph = Array(N + 1) {
            LinkedList<Pair<Int, Int>>()
        }

        for (i in 0 until M) {
            br.readLine().split(" ").map {
                it.toInt()
            }.let {
                graph[it[0]].add(Pair(it[1], it[2]))
            }
        }

        val goDistance = IntArray(N + 1)
        val comebackDistance = IntArray(N + 1)

        for (i in 1 .. N) {
            val queue = PriorityQueue<Node>()
            queue.add(Node(i, 0))

            val visit = BooleanArray(N + 1)
            val distance = IntArray(N + 1) {
                Int.MAX_VALUE
            }

            distance[i] = 0

            while (queue.isNotEmpty()) {
                for (j in 0 until queue.size) {
                    val node = queue.poll()

                    if (visit[node.index])
                        continue

                    visit[node.index] = true

                    graph[node.index].forEach {
                        distance[it.first] = min(distance[it.first], distance[node.index] + it.second)
                        queue.add(Node(it.first, distance[it.first]))
                    }
                }
            }

            goDistance[i] = distance[X]

            if (i == X) {
                for (j in 1 .. N) {
                    comebackDistance[j] = distance[j]
                }
            }
        }

        var maxDistance = 0
        for (i in 1 .. N) {
            if (maxDistance < goDistance[i] + comebackDistance[i])
                maxDistance = goDistance[i] + comebackDistance[i]
        }
        println(maxDistance)
    }
}

data class Node(
    val index: Int,
    val distance: Int
) : Comparable<Node> {
    override fun compareTo(other: Node) = distance - other.distance
}