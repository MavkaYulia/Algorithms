package SlidingWindow

import kotlin.math.max

class `424_LongestRepeatingCharacterReplacement` {

    fun characterReplacement(s: String, k: Int): Int {
        val map = mutableMapOf<Char, Int>()
        var res = 0
        var wStart = 0
        var maxFr = 0

        for (wEnd in s.indices) {
            map[s[wEnd]] = (map[s[wEnd]] ?: 0) + 1
            maxFr = maxOf(maxFr, map[s[wEnd]]!!)

            while (wEnd - wStart + 1 - maxFr > k) {
                map[s[wStart]] = map[s[wStart]]!! - 1
                wStart++
            }

            res = maxOf(res, wEnd - wStart + 1)
        }

        return res
    }
}

fun characterReplacement1(s: String, k: Int): Int {
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