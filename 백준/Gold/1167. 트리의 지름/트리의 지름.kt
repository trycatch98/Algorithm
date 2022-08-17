import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var node = 1
var max = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val V = br.readLine().toInt()

    val tree = Array(V + 1) {
        LinkedList<Pair<Int, Int>>()
    }

    for (i in 0 until V) {
        br.readLine().split(" ").map {
            it.toInt()
        }.let {
            for (i in 1 until it.size - 1 step 2)
                tree[it[0]].add(Pair(it[i], it[i + 1]))
        }
    }

    dfs(node, 0, tree, BooleanArray(V + 1))
    dfs(node, 0, tree, BooleanArray(V + 1))

    println(max)
}

fun dfs(v: Int, distance: Int, tree: Array<LinkedList<Pair<Int, Int>>>, visit: BooleanArray) {
    if (max < distance) {
        max = distance
        node = v
    }

    visit[v] = true

    tree[v].forEach {
        if (!visit[it.first]) {
            dfs(it.first, distance + it.second, tree, visit)
        }
    }
}