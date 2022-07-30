fun main() {
    val N = readLine()?.toInt() ?: 0
    val list = mutableListOf<Int>()

    readLine()?.split(" ")?.map {
        it.toInt()
    }?.let {
        list.addAll(it)
    }

    list.sortByDescending {
        it
    }

    val arr = BooleanArray(list[0] + 1) { true }
    arr[1] = false
    for (i in 2..list[0]) {
        if (arr[i]) {
            if ((i == 2 || i == 3) || (i % 2 != 0 && i % 3 != 0)) {
                for (j in i * 2..list[0] step i)
                    arr[j] = false
            }
        }
    }

    var result = 0
    list.forEach {
        if (arr[it])
            result++
    }
    println(result)
}