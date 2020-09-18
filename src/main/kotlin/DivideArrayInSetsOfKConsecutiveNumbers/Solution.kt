package DivideArrayInSetsOfKConsecutiveNumbers

import java.util.*

class Solution {
    fun isPossibleDivide(nums: IntArray, k: Int): Boolean {

        /**
         * 首先排序
         *
         * 找最小一个数字，并构成连续数字串
         * 循环
         *
         */
        if(nums.size < k) return false

        nums.sort()
        println(Arrays.toString(nums))
        val flag = nums[0] - 1

        var i = 0
        while (true){
            var next = -1 //next记录下一轮的开始
            println("new loop: i=$i, next=$next")

            var count = 0
            var firstVal = nums[i]
            while (count < k){

                if(i+count>=nums.size){
                    println("overflow: i=$i, count=$count")
                    return false
                }

                if(nums[i+count] == firstVal+count){
                    println("找到恰好的数")
                    println("swap: i=$i, count=$count, nums[i+count]=${nums[i+count]}")
                    nums[i+count] = flag
                    count++
                }else if(nums[i+count] > firstVal+count){//找到太大的数
                    println("找到太大的数")
                    println("too large overflow: i=$i, count=$count, nums[i+count]=${nums[i+count]}")
                    return false
                }else{//找到较小的数，只有两种可能：上一个数，或flag
                    println("找到较小的数")
                    if(nums[i+count] == firstVal+count-1){
                        if(next == -1){//说明从未调整过
                            next = i+count //调整下一轮的开始，且只调整一次
                            println("adjust loop start: next=$next")
                        }
                    }
                    if(nums[i+count] == flag){

                    }
                    i++
                    if(i>=nums.size){
                        println("overflow: i=$i")
                        return false
                    }
                }

            }
            if(next == -1){//说明从未调整过
                next = i+count
            }
            i = next //开始下一轮
            println("======开始下一轮，i=$i")
            println(Arrays.toString(nums))
            if(i>=nums.size){
                println("success overflow: i=$i")
                break
            }
        }

        return true
    }
}