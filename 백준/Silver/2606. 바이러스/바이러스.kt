import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val M = br.readLine().toInt()

    val graph = Array(N + 1) {
        LinkedList<Int>()
    }

    for (i in 0 until M) {
        br.readLine().split(" ").map {
            it.toInt()
        }.let {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }
    }

    val stack = Stack<Int>()
    val visit = BooleanArray(N + 1)
    stack.push(1)

    var result = 0

    while (stack.isNotEmpty()) {
        for (i in 0 until stack.size) {
            val node = stack.pop()
            if (visit[node])
                continue

            visit[node] = true

            graph[node].forEach {
                stack.push(it)
            }

            result++
        }
    }

    println(result - 1)
}