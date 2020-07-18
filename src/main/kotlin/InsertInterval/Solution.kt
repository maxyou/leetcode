package InsertInterval

class Solution {

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        var committed = mutableListOf<IntArray>()
        var staged:IntArray = intArrayOf(-2, -1)
        var index = 0
        var used = false

        fun getNextInterval():IntArray?{
            if(used){
                if(index >= intervals.size){
                    return null
                }else{
                    return intervals[index++]
                }
            }else{
                if(index >= intervals.size){
                    used = true
                    return newInterval
                }else{
                    if(intervals[index][0] <= newInterval[0]){
                        return intervals[index++]
                    }else{
                        used = true
                        return newInterval
                    }
                }
            }
        }

        while(true){
            var next = getNextInterval()
            if(next == null){
                committed.add(staged)
                break
            }

            if(next[0] <= staged[1]){
                staged[1] = Math.max(staged[1], next[1])
            }else{
                committed.add(staged)
                staged = next
            }
        }

        committed.removeAt(0)

        return committed.toTypedArray()
    }
}