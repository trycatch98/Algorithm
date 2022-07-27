import java.util.*

fun main() {
    while (true) {
        val str = readLine() ?: break
        if (str == ".")
            break
        val stack = Stack<Char>()
        var flag = true
        for (s in str) {
            if (s == '(' || s == '[') {
                stack.push(s)
            } else if (s == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    flag = false
                    break
                }
                stack.pop()
            } else if (s == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    flag = false
                    break
                }
                stack.pop()
            }
        }
        if (flag && stack.isEmpty())
            println("yes")
        else
            println("no")


    }
}