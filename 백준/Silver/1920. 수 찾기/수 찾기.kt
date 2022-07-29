fun main() {
    val N = readLine()?.toInt() ?: 0
    val arr = IntArray(N)

    readLine()?.split(" ")?.map {
        it.toInt()
    }?.forEachIndexed { index, i ->
        arr[index] = i
    }

    arr.sort()

    readLine()

    val findValue = readLine()?.split(" ")?.map {
        it.toInt()
    }

    findValue?.forEach {
        println(
            binary(arr, 0, arr.size - 1, it)
        )
    }
}

fun binary(arr: IntArray, start: Int, end: Int, target: Int): Int {
    if (start > end)
        return 0
    val mid = (end + start) / 2

    return when {
        arr[mid] == target -> {
            1
        }
        arr[mid] < target -> {
            binary(arr,mid + 1, end, target)
        }
        else -> {
            binary(arr, start, mid - 1, target)
        }
    }
}