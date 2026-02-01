package ArrayAndHashing

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val res = HashMap<Map<Char, Int>, MutableList<String>>()

        for (s in strs) {
            val count = HashMap<Char, Int>()

            for (c in s) {
                val currentCount = count[c]
                if (currentCount == null) {
                    count[c] = 1
                } else {
                    count[c] = currentCount + 1
                }
            }

            var group = res[count]
            if (group == null) {
                group = ArrayList<String>()
                res[count] = group
            }
            group.add(s)
        }

        return res.values.toList()
    }
}