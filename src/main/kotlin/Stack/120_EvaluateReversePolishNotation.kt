package Stack

class `120_EvaluateReversePolishNotation` {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        tokens.forEach { item ->
            when (item) {
                "+" -> {
                    val first = stack.last()
                    stack.removeLast()
                    val second = stack.last()
                    stack.removeLast()
                    stack.addLast(second + first)
                }

                "-" -> {
                    val first = stack.last()
                    stack.removeLast()
                    val second = stack.last()
                    stack.removeLast()
                    stack.addLast(second - first)
                }

                "*" -> {
                    val first = stack.last()
                    stack.removeLast()
                    val second = stack.last()
                    stack.removeLast()
                    stack.addLast(second * first)
                }

                "/" -> {
                    val first = stack.last()
                    stack.removeLast()
                    val second = stack.last()
                    stack.removeLast()
                    stack.addLast(second / first)
                }
                else -> {
                    stack.addLast(item.toInt())
                }
            }
        }
        return stack.last()
    }
}