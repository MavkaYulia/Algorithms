package TwoPointers

class `11_ContainerWithMostWater` {

    fun maxArea(heights: IntArray): Int {

        var tempMax = 0
        var l = 0
        var r = heights.size - 1

        while (l < r) {
            if (heights[l] > heights[r]) {
                tempMax = maxOf(tempMax, (heights[r] * (r - l)))
                l++
                r--
            } else {
                tempMax = maxOf(tempMax, (heights[l] * (r - l)))
                l++
                r--
            }
        }
        return tempMax
    }
}