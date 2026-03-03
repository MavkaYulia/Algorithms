package Stack

class `739_DailyTemperatures` {

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        var res = IntArray(temperatures.size)

        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
                res[stack.last()] = i - stack.last()
                stack.removeLast()
                if (stack.isEmpty()) break
            }
            stack.addLast(i)
        }
        return res
    }
}
