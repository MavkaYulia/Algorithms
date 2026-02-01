package ArrayAndHashing

import java.util.*

class TopKFrequentElements {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        var map = HashMap<Int, Int>()
        var res = PriorityQueue<Int> { a, b -> map[a]!! - map[b]!! }

        nums.forEach { x ->
            map[x] = (map[x] ?: 0) + 1
        }

        for (value in map.keys) {
            res.add(value)
            if (res.size > k) {
                res.poll()
            }
        }
        return res.toIntArray()

    }

}