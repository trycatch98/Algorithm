import java.util.*

fun main() {
    readLine()?.split(" ")?.map {
        it.toInt()
    }?.let {
        val N = it[0]
        val M = it[1]
        var B = it[2]

        val arr = mutableListOf<Int>()
        for (i in 0 until N) {
            readLine()?.split(" ")?.map {
                it.toInt()
            }?.forEach {
                arr.add(it)
            }
        }


        var max = Collections.max(arr)!!
        val sum = arr.sum()

        var minTime = Int.MAX_VALUE
        var maxHeight = Int.MIN_VALUE

        for (i in 0..max) {
            if (i * N * M > sum + B)
                continue
            val tempTime = check(i, B, arr, minTime)
            if (minTime >= tempTime) {
                minTime = tempTime
                maxHeight = i
            }
        }

        println("$minTime $maxHeight")
    }
}

fun check(base: Int, inventory: Int, arr: List<Int>, currentMinTime: Int): Int {
    var inven = inventory
    var time = 0
    arr.forEach {
        if (currentMinTime < time)
            return time
        if (it < base) {
            val diff = base - it
            inven -= diff
            time += diff
        }
        else if (it > base) {
            val diff = it - base
            inven += diff
            time += 2 * diff
        }
    }

    return time
}