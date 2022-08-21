import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val M = br.readLine().toInt()

    val graph = Array(N + 1) {
        LinkedList<Node>()
    }

    var maxWeighted = 0

    for (i in 0 until M) {
        br.readLine().split(" ").map {
            it.toInt()
        }.let {
            if (maxWeighted < it[2])
                maxWeighted = it[2]
            graph[it[0]].add(Node(it[1], it[2]))
        }
    }

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val start = it[0]
        val end = it[1]

        val queue = PriorityQueue<Node>()
        queue.add(Node(start, 0))

        val visit = BooleanArray(N + 1)
        val weighted = IntArray(N + 1) {
            (N - 1) * maxWeighted + 1
        }

        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val node = queue.poll()

                if (visit[node.index])
                    continue

                visit[node.index] = true

                graph[node.index].forEach {
                    weighted[it.index] = min(weighted[it.index], it.weighted + node.weighted)
                    queue.add(Node(it.index, weighted[it.index]))
                }
            }
        }

        println(weighted[end])
    }
}

data class Node(
    val index: Int,
    val weighted: Int
) : Comparable<Node> {
    override fun compareTo(other: Node) = weighted - other.weighted
}