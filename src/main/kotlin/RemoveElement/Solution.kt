package RemoveElement

import java.util.*

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {

        /**
         * 指针1从前往后找要移除的数字
         * 当指针1找到一个时，指针2从后往前找不要移除的数字
         * 交换这两个数字
         * 直到指针1和指针2重合
         */
        if(nums.size == 0){
            return 0
        }

        var i = 0
        var j = nums.size - 1

        while (true){
            println("1: i=$i,j=$j")
            while (i<j && nums[i] != `val`){
                i++
            }
            if(i == j){
                println("1.2: i=$i,j=$j")
                break
            }
            println("2: i=$i,j=$j")

            while (j>i && nums[j] == `val`){
                j--
            }
            if(i == j){
                println("2.2: i=$i,j=$j")
                break
            }
            println("3: i=$i,j=$j")
            var temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            i++
            println("4: i=$i,j=$j")
        }
        println("5: i=$i,j=$j")
        println(Arrays.toString(nums))


        if(nums[i] == `val`){
            return i
        }else{
            return i+1
        }
    }
}