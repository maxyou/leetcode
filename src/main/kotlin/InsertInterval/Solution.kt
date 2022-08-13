package InsertInterval

class Solution {

    /**
     * 本题当前解法是一次遍历，但费脑筋，不直观
     *
     * 直观，但两次遍历的解法：
     *  1，按新区间的开头，将其插入队列
     *  2，从新区间之前一个区间开始做相邻合并
     */

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        var committed = mutableListOf<IntArray>()
        var staged:IntArray = intArrayOf(-2, -1) //设定一个最初的staged，便于后面计算
        var index = 0 //索引旧区间
        var used = false //新区间是否使用了

        fun getNextInterval():IntArray?{
            /**
             *  返回一个区间，该区间开头相对较小
             *  不论是旧区间还是新区间
             *  不计较该区间的结尾
             */
            if(used){ //如果新区间已经比较过了，那么就只获取旧区间
                if(index >= intervals.size){
                    return null
                }else{
                    return intervals[index++]
                }
            }else{
                if(index >= intervals.size){ //如果已经检索过了所有给定的区间，那就轮到新区间了
                    used = true
                    return newInterval
                }else{
                    if(intervals[index][0] <= newInterval[0]){ //返回当前索引区间，如果其比新区间先开头
                        return intervals[index++]
                    }else{
                        used = true
                        return newInterval //返回新区间，如果新区间先开头
                    }
                }
            }
        }

        while(true){
            var next = getNextInterval()
            if(next == null){ //如果没有区间了，则添加stage暂存的区间
                committed.add(staged)
                break
            }

            /**
             * 将新得到的next区间跟staged的区间对比
             *  显然，next的开头比staged区间的开头要晚
             *      所以，如果跟staged交叉，则合并staged与next区间
             *      如果不交叉，那么staged就是完整的，升级到最终队列，同时next成为新的staged
             */
            if(next[0] <= staged[1]){ //staged覆盖了next开头，那么两者合并
                staged[1] = Math.max(staged[1], next[1]) //staged结尾扩大到最晚那个结尾
            }else{
                committed.add(staged) //next在staged结束之后才开始，那么staged升级进入队列
                staged = next //next成为新的staged
            }
        }

        committed.removeAt(0) //去掉最初的标志区间

        return committed.toTypedArray()
    }
}