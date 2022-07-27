fun main() {
    readLine()?.split(" ")?.map {
        it.toInt()
    }?.let {
        val K = it[0]
        val N = it[1]

        val list = mutableListOf<Int>()
        for (i in 0 until K) {
            list.add(readLine()?.toInt() ?: 0)
        }

        var start = 0L
        var end = Long.MAX_VALUE
        var mid = (start + end) / 2L
        var max = 0L

        while (start <= end) {
            var temp = 0L
            list.forEach {
                temp += it / mid
            }

            if (temp >= N) {
                start = mid + 1
                max = mid
            }
            else {
                end = mid - 1
            }
            mid = (start + end) / 2

        }

        println(max)
    }

}