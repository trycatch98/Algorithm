import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val str = br.readLine()
    val bomb = br.readLine()

    val windowSize = bomb.length

    val stack = Stack<Char>()

    val arr = str.toCharArray()
    for (i in arr.indices) {
        if (arr[i] == bomb[windowSize - 1]) {
            val tempStack = Stack<Char>()
            tempStack.push(arr[i])
            for (j in windowSize - 2 downTo 0) {
                if (stack.isNotEmpty() && bomb[j] == stack.peek())
                    tempStack.push(stack.pop())
                else
                    for (k in 0 until tempStack.size)
                        stack.push(tempStack.pop())
            }
        }
        else {
            stack.push(arr[i])
        }
    }

    val result = StringBuilder()

    stack.forEach {
        result.append("$it")
    }

    if (result.isNotEmpty())
        println(result)
    else
        println("FRULA")
}