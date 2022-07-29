import kotlin.math.min

fun main() {
    readLine()?.split(" ")?.map {
        it.toInt()
    }?.let {
        val x = it[0]
        val y = it[1]
        val w = it[2]
        val h = it[3]

        println(min(min(w - x, x), min(h - y, y)))
    }
}