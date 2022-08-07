import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

   br.readLine().split(" ").map {
       it.toInt()
   }.let {
       val N = it[0]
       val K = it[1]

       println(factorial(N) / (factorial(N - K) * factorial(K)))
   }
}

fun factorial(num: Int): Int {
    if (num < 2)
        return 1
    return num * factorial(num - 1)
}