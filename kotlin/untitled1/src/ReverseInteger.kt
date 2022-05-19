/**
 * https://leetcode.com/problems/reverse-integer/submissions/
 */

class ReverseInteger {
        fun reverse(x: Int): Int {
            var res = 0
            var k = x
            while (k != 0) {
                if (Math.abs(res) > Int.MAX_VALUE/10) return 0

                res = res*10 + k % 10
                k /= 10
            }
            return res
        }

}