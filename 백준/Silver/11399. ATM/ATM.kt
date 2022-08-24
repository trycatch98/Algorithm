import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val arr = IntArray(N)

    br.readLine().split(" ").map {
        it.toInt()
    }.forEachIndexed { index, i ->
        arr[index] = i
    }

    var result = 0
    var sum = 0
    arr.sorted().forEach {
        sum += it
        result += sum
    }

    println(result)
}