package InterleavingString

class Solution{
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {

        var i1 = 0
        var i2 = 0
        var i3 = 0

        fun giveMeRightChar(i1:Int, i2:Int, i3:Int):Boolean{
            if(i3 == s3.length){
                return (i1 == s1.length && i2 == s2.length)
            }

            var result:Boolean = false
            if(s1.isNotEmpty() && i1 < s1.length && s1[i1] == s3[i3]){
                result = giveMeRightChar(i1+1, i2, i3+1)
            }
            if(result){
                return true
            }
            if(s2.isNotEmpty() && i2 < s2.length && s2[i2] == s3[i3]){
                result = giveMeRightChar(i1, i2+1, i3+1)
            }
            return result
        }

        return giveMeRightChar(0,0,0)
    }
}