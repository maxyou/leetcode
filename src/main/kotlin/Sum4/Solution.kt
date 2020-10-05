package Sum4

class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {

        nums.sort()
        if(nums.size < 4){
            return listOf()
        }
        val set = mutableSetOf<List<Int>>()

        for(h in 3 until nums.size){
            for(k in 2 until h){
                for(j in 1 until k){
                    for(i in 0 until j){
                        if(nums[i]+nums[j]+nums[k]+nums[h]==target){
                            set.add(listOf(nums[i],nums[j], nums[k], nums[h]))
                        }
                    }
                }
            }
        }

        return set.toList()
    }
}