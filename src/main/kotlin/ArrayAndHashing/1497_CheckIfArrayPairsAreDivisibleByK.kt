package ArrayAndHashing

class `1497_CheckIfArrayPairsAreDivisibleByK` {

    fun canArrange(arr: IntArray, k: Int): Boolean {
        val frequency = IntArray(k)

        for (num in arr) {
            var rem = num % k

            if (rem < 0) {
                rem += k
            }

            frequency[rem]++
        }

        if (frequency[0] % 2 != 0) return false

        for (i in 1..k / 2) {
            if (frequency[i] != frequency[k - i]) {
                return false
            }
        }

        return true
    }


    fun canArrange0(arr: IntArray, k: Int): Boolean {
        val set = HashSet<Int>()

        var newArr = arr

        for (i in 0 until arr.size) {
            while (newArr[i] < 0) {
                newArr[i] = newArr[i] + k
            }
        }

        for (i in 0 until arr.size) {

            val temp = newArr[i] % k

            if (temp != 0) {
                set.add(temp)
            }
        }

        for (j in arr.size - 1 downTo 0) {

            set.removeIf { i -> newArr[j] - k == i }

            if (set.isEmpty()) {
                return true
            }
        }

        return false
    }
}

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 10, 6, 7, 8, 9)
    val k = 5

    val myClass = `1497_CheckIfArrayPairsAreDivisibleByK`()
    val result = myClass.canArrange(
        arr,
        k
    )

    println("Arry: ${arr.joinToString(", ")}")
    println("k = $k")
    println("Result: $result")
}