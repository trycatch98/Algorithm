import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val N = it[0]
        val M = it[1]

        val queue: Queue<Int> = LinkedList()

        br.readLine().split(" ").map {
            it.toInt()
        }.let {
            for (i in 1 .. it[0]) {
                queue.add(it[i])
            }
        }

        val graph = Array(N + 1) {
            LinkedList<Int>()
        }

        val partyGraph = Array(M + 1) {
            LinkedList<Int>()
        }

        for (i in 1 .. M) {
            br.readLine().split(" ").map {
                it.toInt()
            }.let {
                for (j in 1 until it.size) {
                    graph[it[j]].add(i)
                    partyGraph[i].add(it[j])
                }
            }
        }

        val visit = BooleanArray(N + 1)
        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val value = queue.poll()
                if (visit[value])
                    continue

                visit[value] = true

                graph[value].forEach {
                    partyGraph[it].forEach {
                        queue.add(it)
                    }
                    partyGraph[it].clear()
                }
                graph[value].clear()
            }
        }

        var count = 0
        partyGraph.forEach {
            if (it.isNotEmpty())
                count++
        }

        println(count)
    }
}