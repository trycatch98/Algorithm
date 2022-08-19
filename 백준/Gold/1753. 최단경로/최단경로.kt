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
        val X = br.readLine().toInt()

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

        val queue = PriorityQueue<Node>()
        queue.add(Node(X, 0))

        val visit = BooleanArray(N + 1)
        val distance = IntArray(N + 1) {
            Int.MAX_VALUE
        }

        distance[X] = 0

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

        for (i in 1 .. N) {
            if (distance[i] == Int.MAX_VALUE)
                println("INF")
            else
                println(distance[i])
        }
    }
}

data class Node(
    val index: Int,
    val distance: Int
) : Comparable<Node> {
    override fun compareTo(other: Node) = distance - other.distance
}