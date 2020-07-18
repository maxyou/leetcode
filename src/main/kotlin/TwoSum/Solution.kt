package TwoSum

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray? {
        var i = 0
        while(i < nums.size){
            var j = i + 1
            while(j < nums.size && (nums[i] + nums[j]) != target){
                j++
            }
            if(j < nums.size && (nums[i] + nums[j]) == target){
                return intArrayOf(i, j)
            }
            i++
        }
        return null
    }
}