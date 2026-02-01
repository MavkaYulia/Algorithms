package ArrayAndHashing

class `2768_NumberOfBlackBlocks` {

    val blockCounts = HashMap<Long, Int>()

    fun countBlackBlocks(m: Int, n: Int, coordinates: Array<IntArray>): LongArray {

        for (point in coordinates) {
            val x = point[0]
            val y = point[1]

            addBlock(x, y, m, n)
            addBlock(x, y - 1, m, n)
            addBlock(x - 1, y, m, n)
            addBlock(x - 1, y - 1, m, n)
        }

        val result = LongArray(5)

        for (count in blockCounts.values) {
            result[count]++
        }

        val totalBlocks = (m - 1).toLong() * (n - 1).toLong()
        val nonZeroBlocks = blockCounts.size.toLong()
        result[0] = totalBlocks - nonZeroBlocks

        return result
    }

    private fun addBlock(x: Int, y: Int, m: Int, n: Int) {
        if (x >= 0 && x < m - 1 && y >= 0 && y < n - 1) {

            val key = (x.toLong() shl 32) or (y.toLong() and 0xFFFFFFFFL)

            blockCounts[key] = (blockCounts[key] ?: 0) + 1
        }
    }
}
