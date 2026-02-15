package Stack

class `20_ValidParentheses` {
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false
        val map = hashMapOf('(' to ')', '{' to '}', '[' to ']')
        val stack = ArrayDeque<Char>()

        for (ch in s) {
            if (ch in map.keys) {
                stack.addLast(ch)
            } else {
                if (stack.isEmpty()) return false
                if (ch == map[stack.last()]) {
                    stack.removeLast()
                } else {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}