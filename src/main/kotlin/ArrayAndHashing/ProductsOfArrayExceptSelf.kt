package ArrayAndHashing

class ProductsOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        var pref = IntArray(n)
        var suf = IntArray(n)
        var res = IntArray(n)

        pref[0] = 1
        suf[n - 1] = 1

        for (i in 1 until n) {
            pref[i] = pref[i - 1] * (nums[i - 1])

        }
        for (j in n - 2 downTo 0) {
            suf[j] = suf[j + 1] * (nums[j + 1])
        }
        for (k in 0 until n) {
            res[k] = pref[k] * suf[k]
        }
        return res
    }

    fun productExceptSelfAlt(nums: IntArray): IntArray {
        val n = nums.size
        val res = IntArray(n) // створює [0, 0, 0, 0] — це швидше

        var prefix = 1
        for (i in 0 until n) {
            res[i] = prefix
            prefix *= nums[i]
        }

        var postfix = 1
        for (i in n - 1 downTo 0) {
            res[i] *= postfix
            postfix *= nums[i]
        }

        return res
    }

}