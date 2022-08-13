package RemoveDuplicatesFromSoredArray

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if(nums.size <= 1) return nums.size

        var lastIndex = 0
        var nextIndex = 1

        while(true){

            if(nextIndex + 1 > nums.size){
                break
            }

            if(nums[lastIndex] == nums[nextIndex]){
                nextIndex++
                continue
            }

            lastIndex++
            nums[lastIndex] = nums[nextIndex]
            nextIndex++

        }

        return lastIndex + 1

    }
}