fun main() {
    readLine()?.split(" ")?.map {
        it.toInt()
    }?.let {
        val M = it[0]
        val N = it[1]
        val arr = BooleanArray(N + 1) { true }
        arr[1] = false

        for (i in 2..N) {
            if (arr[i]) {
                if ((i == 2 || i == 3) || (i % 2 != 0 && i % 3 != 0)) {
                    for (j in i * 2..N step i)
                        arr[j] = false
                }
            }
        }

        for (i in M..N) {
            if (arr[i])
                println(i)
        }
    }
}