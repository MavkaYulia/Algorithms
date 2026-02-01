package ArrayAndHashing

class `1636_SortArrayByIncreasingFrequency` {

    // Наш клас "Дерево" (внутрішній клас, щоб все було в одному файлі)
    class NumberTree(val value: Int) : Comparable<NumberTree> {
        var size: Int = 1 // Початковий розмір (частота)

        // Метод Union (нарощуємо "ріст" дерева)
        fun union() {
            this.size++
        }

        // Логіка сортування згідно з умовами LeetCode 1636:
        // 1. Частота (size) -> від меншого до більшого
        // 2. Якщо частота однакова -> значення (value) від більшого до меншого
        override fun compareTo(other: NumberTree): Int {
            if (this.size != other.size) {
                return this.size - other.size // 1 -> 2 -> 3
            }
            return other.value - this.value // 3 -> 2 -> 1
        }
    }

    fun frequencySort(nums: IntArray): IntArray {
        // 1. "Саджаємо ліс"
        // Використовуємо масив як карту для швидкого доступу (offset +100 для від'ємних чисел)
        val forest = arrayOfNulls<NumberTree>(201)
        val activeTrees = ArrayList<NumberTree>()

        for (num in nums) {
            val index = num + 100 // нормалізація індексу (-100 стає 0)

            if (forest[index] == null) {
                // Нове дерево
                val newTree = NumberTree(num)
                forest[index] = newTree
                activeTrees.add(newTree)
            } else {
                // Дерево вже є -> об'єднуємо (збільшуємо розмір)
                forest[index]!!.union()
            }
        }

        // 2. Сортуємо дерева вручну (Bubble Sort, без "цукру")
        val n = activeTrees.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                // Використовуємо наш compareTo
                if (activeTrees[j].compareTo(activeTrees[j + 1]) > 0) {
                    val temp = activeTrees[j]
                    activeTrees[j] = activeTrees[j + 1]
                    activeTrees[j + 1] = temp
                }
            }
        }

        // 3. Формуємо результат
        val result = IntArray(nums.size)
        var cursor = 0

        for (tree in activeTrees) {
            // Записуємо число стільки разів, який розмір у дерева
            for (k in 0 until tree.size) {
                result[cursor++] = tree.value
            }
        }

        return result
    }
}
