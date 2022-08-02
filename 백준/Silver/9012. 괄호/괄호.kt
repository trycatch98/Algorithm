import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val stringBuilder = StringBuilder()

    for (i in 0 until N) {
        val stack = Stack<Char>()
        run {
            br.readLine().forEach {
                if (stack.isEmpty()) {
                    stack.push(it)
                    return@forEach
                } else if (it == '(')
                    stack.push(it)
                else if (it == ')') {
                    if (stack.peek() == '(')
                        stack.pop()
                    else
                        return@run
                }
            }
        }

        stringBuilder.append(
            if (stack.isEmpty())
                "YES\n"
            else
                "NO\n"
        )
    }

    println(stringBuilder)
}