package MagicIndexLCCI

class Solution {
    fun findMagicIndex(nums: IntArray): Int {

        (0..nums.size-1).forEach {
            if(nums[it] == it){
                return it
            }
        }
        return -1
    }
}