package ArrayAndHashing

class `128_LongestConsecutiveSequence` {
    fun longestConsecutive(nums: IntArray): Int {
        var max = 0
        val set = nums.toSet()
        for (num in set) {
            var temp = 0
            var tempNum = num
            if (set.contains(num - 1)) {

            } else {
                while (set.contains(tempNum + 1)) {
                    tempNum++
                    temp++
                }
                if (temp > max) {
                    max = temp
                }
            }
        }
        return max
    }
}