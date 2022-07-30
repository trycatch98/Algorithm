import kotlin.math.pow

fun main() {
    var triangle = readLine()
    while (triangle != "0 0 0") {
        val side = mutableListOf<Double>()
        triangle?.split(" ")?.map {
            side.add(it.toDouble())
        }

        side.sort()

        if (side[0].pow(2) + side[1].pow(2) == side[2].pow(2))
            println("right")
        else
            println("wrong")

        triangle = readLine()
    }
}