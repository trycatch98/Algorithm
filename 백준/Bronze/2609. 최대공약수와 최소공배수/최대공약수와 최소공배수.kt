fun main() {
    readLine()?.split(" ")?.map {
        it.toInt()
    }?.let {
        var a = it[0]
        var b = it[1]
        var gcd = 0
        var lcm = 0

        while (b != 0) {
            var temp = a % b
            a = b
            b = temp
            gcd = a
        }
        lcm = it[0] * it[1] / gcd

        println(gcd)
        println(lcm)
    }
}