package KthLargestElementInAnArray

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {

        fun partition(low: Int, high: Int): Int {
            var l = low
            var h = high
            val midValue = nums[l]
            while(l < h){
                while (l < h && nums[h] >= midValue) { h-- }
                nums[l] = nums[h].also { nums[h] = nums[l] }
                while (l < h && nums[l] <= midValue){ l++ }
                nums[l] = nums[h].also { nums[h] = nums[l] }
            }
            return l
        }

        var low = 0
        var high = nums.size-1
        val point = nums.size - k
        while (true) {
            val divider = partition(low, high)
            if(divider < point){
                low = divider + 1
            }else if(divider>point){
                high = divider - 1
            }else{
                break
            }
        }

        var min = nums[point]
        for(i in point..nums.size-1){
            if(nums[i] < min){
                min = nums[i]
            }
        }
        return min
    }
}