package ArrayAndHashing

class ContainsDuplicate {
    fun hasDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()

        for (x in nums) {
            if (x in set) {
                return true

            }
            set.add(x)
        }
        return false
    }
}

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var temp = 0
        for (n in nums) {
            if (target == n) {
                temp = nums.indexOf(n)
            }
            if (target > n) {
                temp = nums.indexOf(n)
            }
        }
        return temp
    }
}