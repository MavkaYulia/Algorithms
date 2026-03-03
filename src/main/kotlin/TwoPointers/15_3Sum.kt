package TwoPointers

class `15_3Sum` {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()

        for (i in nums.indices) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var l = i + 1
            var r = nums.size - 1
            while (l < r) {
                val threeSum = nums[i] + nums[l] + nums[r]
                when {
                    threeSum > 0 -> r--
                    threeSum < 0 -> l++
                    else -> {
                        res.add(listOf(nums[i], nums[l], nums[r]))
                        l++
                        r--
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++
                        }
                    }
                }
            }
        }

        return res
    }
}