package TwoPointers

class `42_TrappingRainWater` {
    fun trap2(height: IntArray): Int {
        var tempMax = 0
        var s = 0
        var f = 1
        var ins = 0

        while (s < height.size - 1) {
            if (height[f] >= height[s]) {
                tempMax += (height[s] * (f - s - 1)) - ins
                s = f
                ins = 0
            } else {
                ins += height[f]
            }

            if (f < height.size) {
                f++
            } else {
                ins = 0
                s++
                f = s
                f++
            }
        }
        return tempMax
    }
}

fun trapSt(height: IntArray): Int {

    var stack = ArrayDeque<Int>()
    var tempMax = 0
    var s = 0
    var f = 1
    var ins = 0

    for (i in height.indices) {
        if (height[i] > 0) {
            if (stack.isNotEmpty()) {
                if (height[i] >= height[stack.last()]) {
                    tempMax += (height[stack.last()] * (i - stack.last() - 1))
                    stack.removeLast()
                    stack.addLast(i)
                } else {
                    if (height[stack.last()] * (i - stack.last() - 1) == 0) {
                        ins++
                    } else {
                        tempMax += (height[stack.last()] * (i - stack.last() - 1))
                    }
                }

            } else stack.addLast(i)
        }
    }

    return tempMax
}