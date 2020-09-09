package LongestCommonPrefix

import java.lang.StringBuilder

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {

        if(strs.isEmpty()){
            return ""
        }

        val sb = StringBuilder()
        var index = 0
        while (true){
            var str0:Char = ' '
            for(i in strs.indices){

                if(index >= strs[i].length){
                    return sb.toString()
                }

                if(i == 0){
                    str0 = strs[i][index]
                }else{
                    if(strs[i][index] != str0){
                        return sb.toString()
                    }
                }
            }
            sb.append(str0)
            index++
        }

    }
}