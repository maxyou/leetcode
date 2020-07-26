package BurstBalloons

import java.util.*

class Solution {
    fun maxCoins(nums: IntArray): Int {
        data class NumsMax(val nums: IntArray, val max: Int){ //戳完本数组的最大值
            override fun equals(other: Any?): Boolean {
                if (this === other) { return true }
                if (javaClass != other?.javaClass) { return false }
                other as NumsMax
                return this.nums contentEquals other.nums
            }
            override fun hashCode(): Int {
                return this.nums.hashCode()
//                return super.hashCode()
            }
        }
        fun calcNumsSum(nums: IntArray, i: Int): Int {
            val left = if (i == 0) 1 else nums[i - 1]
            val right = if (i == nums.size - 1) 1 else nums[i + 1]
//            println("calcNumsSum ${left} ${nums[i]} ${right}")
            return left * nums[i] * right
        }

        val matrix = Array(nums.size){ mutableListOf<NumsMax>() }

        fun loopLevel(levelNums: IntArray):Int { //输入数组，返回全部戳破后的值
            val size = levelNums.size
            if (size == 0) { return 0 }

            val index = matrix[size-1].indexOfFirst { it.nums contentEquals levelNums }  //.indexOf(NumsMax(levelNums, 0))

            if(index >= 0){
                println("find level:${size} max:${matrix[size-1][index].max}")
                println("matrix length:${matrix[size-1].size} index:${index}")
                return matrix[size-1][index].max
            }
            println(Arrays.toString(matrix))

            var thisLevelMax = 0
            (0..size - 1).forEach {
                val thisLevelAdd = calcNumsSum(levelNums, it)
                val next = IntArray(size-1) {
                    it2->
                        if(it2 < it){
                            levelNums[it2]
                        }else{
                            levelNums[it2+1]
                        }
                }
                val lowerLevelMax = loopLevel(next)
                if(lowerLevelMax + thisLevelAdd > thisLevelMax){
                    thisLevelMax = lowerLevelMax + thisLevelAdd
                }
            }
            matrix[size-1].add(NumsMax(levelNums, thisLevelMax))
            println(Arrays.toString(matrix))
            return thisLevelMax
        }

        var globalMax = loopLevel(nums)
//        println(Arrays.toString(matrix))
        return globalMax
    }
}