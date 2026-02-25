package TwoPointers

class TwoIntegerSumII {

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            if (numbers[left] + numbers[right] > target) right--
            else if (numbers[left] + numbers[right] < target) left++
            else {
                return intArrayOf(left + 1, right + 1)
            }
        }
        return intArrayOf(left + 1, right + 1)
    }
}