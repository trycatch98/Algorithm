fun main() {
    readLine()?.split(" ")?.map {
        it.toInt()
    }?.let {
        val N = it[0]
        val K = it[1]

        val list = mutableListOf<Pair<Int, Int>>()

        for (i in 0 until N) {
            readLine()?.split(" ")?.map {
                it.toInt()
            }?.let {
                list.add(Pair(it[0], it[1]))
            }
        }
        var memo = Array(101) {
            Array(100001) { 0 }
        }

        for (i in 1..N) {
            memo[i][list[i - 1].first] = Math.max(list[i - 1].second, memo[i][list[i - 1].first])
            for (j in 1..K) {
                if (memo[i - 1][j] != 0) {
                    memo[i][j] = Math.max(memo[i][j], memo[i - 1][j])
                    if (j + list[i - 1].first <= K)
                        memo[i][j + list[i - 1].first] = Math.max(memo[i][j + list[i - 1].first], memo[i - 1][j] + list[i - 1].second)
                }
            }
        }


        var max = 0
        for (i in 1..K) {
            if (memo[N][i] > max)
                max = memo[N][i]
        }
        println(max)
    }
}