package BinarySearch

class `704_BinarySearch` {
    fun search(nums: IntArray, target: Int): Int {
        return bs(nums, target, 0, nums.size - 1)
    }

    tailrec fun bs(nums: IntArray, target: Int, low: Int, high: Int): Int {

        if (low > high) return -1
        val mid = low + (high - low) / 2

        return when {
            nums[mid] == target -> mid
            nums[mid] > target -> bs(nums, target, low, mid - 1)
            else -> bs(nums, target, mid + 1, high)
        }
    }
}

