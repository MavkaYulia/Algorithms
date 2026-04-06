package ArrayAndHashing

class ConcatenationOfArray {
    fun getConcatenation(nums: IntArray): IntArray {
        val result = IntArray(nums.size * 2) { i ->
            nums[i % nums.size]
        }
        return result
    }

}