fun main() {
    var num = readLine()?.toInt() ?: 0

    while (num != 0) {
        val str = "$num"
        for (i in 0..str.length / 2) {
            if (str[i] != str[str.length - i - 1]) {
                println("no")
                break
            }
            else if (i == str.length / 2)
                println("yes")
        }
        num = readLine()?.toInt() ?: 0
    }
}