package SlidingWindow

class `76_MinimumWindowSubstring` {
    fun minWindow(s: String, t: String): String {
        if (t.isEmpty()) return ""

        val mapT = HashMap<Char, Int>()
        for (ch in t) {
            mapT[ch] = mapT.getOrDefault(ch, 0) + 1
        }

        var have = 0
        val need = mapT.size
        val res = IntArray(2) {-1}
        var resLen = Int.MAX_VALUE
        var wStart = 0
        val window = HashMap<Char, Int>()

        for (wEnd in s.indices) {
            val ch = s[wEnd]
            window[ch] = window.getOrDefault(ch, 0) + 1

            if (mapT.containsKey(ch) && window[ch] == mapT[ch]) {
                have++
            }

            while (have == need) {
                if ((wEnd - wStart + 1) < resLen) {
                    res[0] = wStart
                    res[1] = wEnd
                    resLen = wEnd - wStart + 1
                }

                window[s[wStart]] = window.getOrDefault(s[wStart], 0) - 1
                if (mapT.containsKey(s[wStart]) && (window[s[wStart]] ?: 0) < mapT[s[wStart]]!!) {
                    have--
                }
                wStart++
            }
        }

        return if (res[0] == -1) "" else s.substring(res[0], res[1] + 1)
    }
}