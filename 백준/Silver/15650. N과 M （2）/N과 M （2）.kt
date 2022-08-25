import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    br.readLine().split(" ").map {
        it.toInt()
    }.let {
        val N = it[0]
        val M = it[1]

        println(NM(0, N, M, 0, BooleanArray(N + 1)))
    }
}

fun NM(index: Int, N: Int, M: Int, depth: Int, visit: BooleanArray): String {
    if (depth == M) {
        return run {
            var str = ""
            for (i in 1 .. N) {
                if (visit[i])
                    str += "$i "
            }
            "$str\n"
        }
    }

    var str = ""
    for (i in index + 1 .. N) {
        visit[i] = true
        str += NM(i, N, M, depth + 1, visit)
        visit[i] = false
    }
    return str
}