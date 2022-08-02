import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stack = Stack<Int>()
    val stringBuilder = StringBuilder()

    val N = br.readLine().toInt()

    for (i in 0 until N) {
        br.readLine().split(" ").let {
            when (it[0]) {
                "push" -> {
                    stack.push(it[1].toInt())
                }
                "pop" -> {
                    stringBuilder.append(
                        if (stack.isEmpty()) "-1\n"
                        else "${stack.pop()}\n"
                    )
                }
                "size" -> {
                    stringBuilder.append("${stack.size}\n")
                }
                "empty" -> {
                    stringBuilder.append(
                        if (stack.isEmpty()) "1\n"
                        else "0\n"
                    )
                }
                "top" -> {
                    stringBuilder.append(
                        if (stack.isEmpty()) "-1\n"
                        else "${stack.peek()}\n"
                    )
                }
                else -> {}
            }
        }
    }

    println(stringBuilder)
}