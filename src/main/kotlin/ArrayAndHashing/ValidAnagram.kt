package ArrayAndHashing

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        var map = HashMap<Char, Int>()

        s.forEach { i ->
            map[i] = (map[i] ?: 0) + 1
        }
        t.forEach { j ->
            if (map[j] == null) return false
            else if (map[j] == 1) map.remove(j)
            else map[j] = map[j]!! - 1
        }
        return map.isEmpty()

    }

}