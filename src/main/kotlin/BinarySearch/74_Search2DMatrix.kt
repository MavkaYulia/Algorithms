package BinarySearch

class `74_Search2DMatrix` {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var low = 0
        var high = matrix.size
        var midM = low + (high - low) / 2
        while (low < high) {
            var l = 0
            var h = matrix[0].size
            var midN = l + (h - l) / 2

            while (l < h) {
                if (matrix[midM][midN] == target) return true
                else if (matrix[midM][midN] > target) {
                    high = midM
                    h = midN
                } else {
                    low = midM
                    l = midN
                }
            }
        }
        return false
    }
}
//
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false

    val rows = matrix.size
    val cols = matrix[0].size

    var low = 0
    var high = rows * cols - 1

    while (low <= high) {
        val mid = low + (high - low) / 2
        // Перетворюємо плоский індекс назад у координати матриці
        val midValue = matrix[mid / cols][mid % cols]

        when {
            midValue == target -> return true
            midValue < target -> low = mid + 1
            else -> high = mid - 1
        }
    }

    return false
}