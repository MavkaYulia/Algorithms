package ArrayAndHashing

import kotlin.math.absoluteValue

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {

        var res = IntArray(2)
        var map = HashMap<Int, Int>()

        for (i in 0..nums.size) {
            map[nums[i]] = i
        }

        for (j in 1 until nums.size) {

            var x = target - nums[j]

            if (x in map){
                res[0] = map[x]!!
                res[1] = j
            }
        }
        return res
    }
}