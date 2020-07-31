package DifferentWaysToAddParentheses

class Solution {

    fun diffWaysToCompute(input: String): List<Int> {

        fun combineList(a:List<Int>, b:List<Int>, op:Char):List<Int>{
            var combined = mutableListOf<Int>()
            for(aa in a){
                for(bb in b){
                    when(op){
                        '+' -> combined.add(aa + bb)
                        '-' -> combined.add(aa - bb)
                        '*' -> combined.add(aa * bb)
                    }
                }
            }
            return combined
        }

        fun subCompute(str: String):List<Int>{
            if(!(str.contains('+') || str.contains('-') || str.contains('*'))){
                return mutableListOf<Int>(str.toInt())
            }

            var levelList = mutableListOf<Int>()

            for(i in str.indices){
                if(str[i] == '+' || str[i] == '-' || str[i] == '*'){
                    levelList.addAll(combineList(subCompute(str.substring(0,i)), subCompute(str.substring(i+1, str.length )), str[i]))
                }
            }
            return levelList
        }

        return subCompute(input)
    }
}