fun main() {
    val N = readLine()?.toInt() ?: 0
    val value = mutableListOf<String>()

    for (i in 0 until N) {
        readLine()?.let {
            value.add(it)
        }
    }

    val result = value.distinct().sortedWith(compareBy<String> { it.length }.thenBy { it })
    
    result.forEach {
        println(it)
    }
}