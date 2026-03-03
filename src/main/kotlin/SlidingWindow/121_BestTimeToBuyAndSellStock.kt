package SlidingWindow

import kotlin.math.max

class `121_BestTimeToBuyAndSellStock` {

    fun maxProfit(prices: IntArray): Int {

        var max = 0
        var wStart = 0


        for (wEnd in 1..<prices.size) {

            if (prices[wStart] > prices[wEnd]) {
                wStart++
            }
            max = max(max, prices[wEnd] - prices[wStart])

        }
        return max
    }
}