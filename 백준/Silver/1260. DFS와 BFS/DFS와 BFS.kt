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
        val V = it[2]

        val linkedList = Array(N + 1) {
            LinkedList<Int>()
        }

        for (i in 0 until M) {
            br.readLine().split(" ").map {
                it.toInt()
            }.let {
                linkedList[it[0]].add(it[1])
                linkedList[it[1]].add(it[0])
            }
        }

        dfs(linkedList, BooleanArray(N + 1), V)
        println()
        bfs(linkedList, BooleanArray(N + 1), V)
    }
}

fun dfs(arr: Array<LinkedList<Int>>, visit: BooleanArray, v: Int) {
    if (visit[v])
        return

    print("$v ")

    visit[v] = true

    arr[v].sorted().forEach {
        dfs(arr, visit, it)
    }
}

fun bfs(arr: Array<LinkedList<Int>>, visit: BooleanArray, v: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(v)

    while (queue.isNotEmpty()) {
        for (i in 0 until queue.size) {
            val v = queue.poll()
            if (visit[v])
                continue
            print("$v ")
            visit[v] = true
            arr[v].sorted().forEach {
                queue.add(it)
            }
        }
    }
}