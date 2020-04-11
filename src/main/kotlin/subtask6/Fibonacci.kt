package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        var temp: Int
        var left = 0
        var right = 1
        while (left * right < n) {
            temp = right
            right += left
            left = temp
        }
        return if (left * right == n) intArrayOf(left, right, 1) else intArrayOf(left, right, 0)
    }
}
