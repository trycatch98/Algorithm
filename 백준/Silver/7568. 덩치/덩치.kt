fun main() {
    val N = readLine()?.toInt() ?: 0
    val list = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until N) {
        readLine()?.split(" ")?.map {
            it.toInt()
        }?.let {
            list.add(Pair(it[0], it[1]))
        }
    }

    for (i in 0 until list.size) {
        var count = 1
        for (j in 0 until list.size) {
            val base = list[i]
            val target = list[j]
            if (base.first < target.first && base.second < target.second)
                count++
        }
        print("$count ")
    }
}