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