import java.util.*

fun main() {
    val N = readLine()?.toInt() ?: 0
    val laser = readLine()?.split(" ")?.map {
        it.toInt()
    }

    val reason = arrayOfNulls<Int>(N)
    reason.fill(0)
    val stack = Stack<Pair<Int, Int>>()

    laser?.let {
        var i = 0
        while (i < N) {
            if (stack.isNotEmpty()) {
                if (stack.peek().second < it[i]) {
                    stack.pop()
                    continue
                } else {
                    reason[i] = stack.peek().first
                    if (i < N - 1 && it[i] < it[i + 1]) {
                        i++
                        continue
                    }
                }
            }
            stack.push(Pair(i + 1, it[i]))
            i++
        }
    }
    println(
        reason.joinToString(" ") {
            "$it"
        }
    )
}