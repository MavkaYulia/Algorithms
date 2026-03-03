package SlidingWindow

import kotlin.math.max

class `424_LongestRepeatingCharacterReplacement` {
    fun characterReplacement(s: String, k: Int): Int {
        var max = 0
        var wStart = 0
        var wEnd = 0
        var temp = 0
        var myK = k

        while (wEnd < s.length) {
            if (s[wStart] == s[wEnd]) {
                temp++
                wEnd++
                max = max(max, temp)
            } else if (s[wStart] != s[wEnd] && myK > 0) {
                myK--
                temp++
                wEnd++
                max = max(max, temp)
            } else if (s[wStart] != s[wEnd] && myK == 0) {
                temp--
                wStart++
                while (myK < k) {
                    myK++
                }
            }

        }
        return max
    }
}