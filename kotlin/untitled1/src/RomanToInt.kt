class RomanToInt {

    private val Rm2Int = mapOf('I' to 1, 'V' to 5,
        'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

    fun romanToInt(s: String): Int {
        var res = 0
        var i = 0

        while (i < s.length) {
            if (i == s.length-1) {
                res += Rm2Int[s[i]]!!
                break
            }
            if (Rm2Int[s[i]]!! < Rm2Int[s[i+1]]!!) {
                res += Rm2Int[s[i+1]]!!-Rm2Int[s[i]]!!
                i += 2
            } else {
                res += Rm2Int[s[i]]!!
                i++
            }
        }

        return res

    }

}