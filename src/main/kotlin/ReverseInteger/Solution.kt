package ReverseInteger

import java.lang.StringBuilder

class Solution {
    fun reverse(x: Int): Int {

        val xStr = x.toString()
        val sb = StringBuilder()

        if(xStr[0] == '-'){
            sb.append(xStr[0])
            for(i in xStr.length-1 downTo 1){
                sb.append(xStr[i])
            }
        }else{
            for(i in xStr.length-1 downTo 0){
                sb.append(xStr[i])
            }
        }

        val out = sb.toString()
        val outLong = out.toLong()
        if((outLong > Int.MAX_VALUE) || (outLong < Int.MIN_VALUE)){
            return 0
        }
        return out.toInt()
    }
}