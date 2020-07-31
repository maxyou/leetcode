package MonotoneIncreasingDigits

import java.lang.StringBuilder

class Solution {
    fun monotoneIncreasingDigits(N: Int): Int {

        val sb = StringBuilder(N.toString())

        var i = 0
        var j = sb.length-1
        while (true){
            if(i == j){
                break
            }
            if(sb[i] <= sb[i+1]){
                i++
                continue
            }
            //sb[i]>sb[i+1]
            for(ii in i+1..j){
                sb[ii] = '9'
            }
            sb[i] = (sb[i].toInt() - 1).toChar()
            j = i
            i--
            if(i < 0){
                break
            }
        }

        return sb.toString().toInt()
    }
}