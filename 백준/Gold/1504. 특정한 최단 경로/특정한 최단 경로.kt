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
        val E = it[1]

        val graph = Array(N + 1) {
            LinkedList<Node>()
        }

        for (i in 0 until E) {
            br.readLine().split(" ").map {
                it.toInt()
            }.let {
                graph[it[0]].add(Node(it[1], it[2]))
                graph[it[1]].add(Node(it[0], it[2]))
            }
        }

        br.readLine().split(" ").map {
            it.toInt()
        }.let {
            val V1 = it[0]
            val V2 = it[1]

            val list = listOf(1, V1, V2, N)

            val distance = Array(N + 1) {
                IntArray(N + 1) {
                    Int.MAX_VALUE
                }
            }

            list.forEach { index ->
                val queue = PriorityQueue<Node>()
                queue.add(Node(index, 0))

                val visit = BooleanArray(N + 1)

                distance[index][index] = 0

                while (queue.isNotEmpty()) {
                    for (i in 0 until queue.size) {
                        val node = queue.poll()

                        if (visit[node.index])
                            continue

                        visit[node.index] = true

                        graph[node.index].forEach {
                            distance[index][it.index] = min(distance[index][it.index], distance[index][node.index] + it.distance)
                            queue.add(Node(it.index, distance[index][it.index]))
                        }
                    }
                }
            }

            when {
                distance[1][V1] == Int.MAX_VALUE || distance[V1][V2] == Int.MAX_VALUE || distance[V2][N] == Int.MAX_VALUE ||
                distance[1][V2] == Int.MAX_VALUE || distance[V2][V1] == Int.MAX_VALUE || distance[V1][N] == Int.MAX_VALUE -> {
                    println(-1)
                }
                else -> {
                    println(min(distance[1][V1] + distance[V1][V2] + distance[V2][N], distance[1][V2] + distance[V2][V1] + distance[V1][N]))
                }
            }
        }
    }
}

data class Node(
    val index: Int,
    val distance: Int
): Comparable<Node> {
    override fun compareTo(other: Node) = distance - other.distance
}