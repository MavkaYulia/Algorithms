package ArrayAndHashing

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val rows = Array(9) { HashSet<Char>() }
        val cols = Array(9) { HashSet<Char>() }
        val squares = Array(9) { HashSet<Char>() }

        for (i in 0..8) {
            for (j in 0..8) {
                val num = board[i][j]
                if (num == '.') continue

                val squareIndex = (i / 3) * 3 + (j / 3)

                if (!rows[i].add(num) || !cols[j].add(num) || !squares[squareIndex].add(num)) {
                    return false
                }
            }
        }

        return true
    }
}


