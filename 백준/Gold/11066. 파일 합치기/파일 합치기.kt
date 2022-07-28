import kotlin.math.min

var list = mutableListOf<Int>()
var memo: Array<Array<Pair<Int, Int>>>? = null

fun main() {
    val T = readLine()?.toInt() ?: 0
    for (i in 0 until T) {
        val K = readLine()?.toInt() ?: 0

        readLine()?.split(" ")?.map {
            it.toInt()
        }?.let {
            list = mutableListOf()
            list.addAll(it)
        }
        val size = run {
            var sum = 0
            for (i in list) {
                sum += i
            }
            sum
        }
        memo = Array(K) {
            Array(K) { Pair(0, 0) }
        }
        var amount = Int.MAX_VALUE
        for (i in 0 until K - 1) {
            amount = min(amount, dp(0, i).second + dp(i + 1, K - 1).second + size)
        }
        println(amount)
    }
}

fun dp(start: Int, end: Int): Pair<Int, Int> {
    if (start == end)
        return Pair(list[start], 0)
    else if (memo!![start][end].first != 0)
        return memo!![start][end]

    var value = Pair(Int.MAX_VALUE, Int.MAX_VALUE)
    for (i in start until end) {
        val left = dp(start, i)
        val right = dp(i + 1, end)
        val sum = Pair(left.first + right.first, left.first + right.first + left.second + right.second)
        if (sum.second < value.second){
            value = sum
        }
    }
    memo!![start][end] = value
    return memo!![start][end]
}