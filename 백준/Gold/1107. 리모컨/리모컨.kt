import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val M = br.readLine().toInt()

    var min = abs(N - 100)
    val arr = BooleanArray(10) { true }


    if (M > 0) {
        br.readLine().split(" ").map {
            it.toInt()
        }.forEach {
            arr[it] = false
        }
    }

    val list = arr.mapIndexed { index, b ->
        if (b)
            index
        else
            -1
    }.filter {
        it != -1
    }

    val length = "$N".length

    val start: Int = if (list.isNotEmpty()) {
        list[list.size - 1] * 10f.pow(length - 2).toInt()
    }
    else {
        0
    }
    val end = if (list.isNotEmpty()) {
        if (list[0] == 0) {
            if (list.size > 1) {
                list[1] * run {
                    var temp = "${list[1]}"
                    for (i in 0 until length)
                        temp += "${list[1]}"
                    temp.toInt()
                }
            }
            else {
                0
            }
        } else {
            list[0] * run {
                var temp = "${list[0]}"
                for (i in 0 until length)
                    temp += "${list[0]}"
                temp.toInt()
            }
        }
    } else {
        0
    }

    for (i in start..end) {
        run {
            if ("$i".length + abs(N - i) < min) {
                i.toString().map {
                    it.digitToInt()
                }.forEach {
                    if (!arr[it]) {
                        return@run
                    }
                }
                min = "$i".length + abs(N - i)
            }
        }
    }

    println(min)
}