import java.util.*

fun main() {
    val N = readLine()?.toInt() ?: 0
    val result = mutableListOf<String>()
    val stack = Stack<Int>()
    val list = mutableListOf<Int>()
    for (i in 0 until N) {
        list.add(readLine()?.toInt() ?: 0)
    }

    var count = 0

    for (i in 1..N) {
        stack.push(i)
        result.add("+")
        var j = stack.size
        while (j >= stack.size - 1) {
            if (stack.isNotEmpty() && list[count] == stack.peek()) {
                count++
                stack.pop()
                result.add("-")
            }
            j--
        }
    }

    if (stack.isNotEmpty()) {
        println("NO")
    }
    else {
        result.forEach {
            println(it)
        }
    }
}