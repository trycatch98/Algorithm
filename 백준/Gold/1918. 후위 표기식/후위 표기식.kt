import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val operator = Stack<Char>()

    br.readLine().forEach {
        when(it) {
            '+', '-' -> {
                loop@ while (operator.isNotEmpty()) {
                    when (operator.peek()) {
                        '+', '-', '*', '/' -> {
                            print("${operator.pop()}")
                        }
                        else -> {
                            break@loop
                        }
                    }
                }
                operator.add(it)
            }
            '*', '/' -> {
                loop@ while (operator.isNotEmpty()) {
                    when (operator.peek()) {
                        '*', '/' -> {
                            print("${operator.pop()}")
                        }
                        else -> {
                            break@loop
                        }
                    }
                }
                operator.add(it)
            }
            '(' -> {
                operator.add(it)
            }
            ')' -> {
                while (operator.isNotEmpty()) {
                    val op = operator.pop()
                    if (op == '(')
                        break
                    print("$op")
                }
            }
            else -> {
                print("$it")
            }
        }
    }

    while (operator.isNotEmpty()) {
        print("${operator.pop()}")
    }
}
