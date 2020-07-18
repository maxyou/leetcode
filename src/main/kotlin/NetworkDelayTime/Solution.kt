package NetworkDelayTime

import java.util.LinkedHashMap

class Solution {
    fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {

        var marks = IntArray(N) { -1 }

        var adjacencyList:MutableMap<Int, MutableList<IntArray>> = LinkedHashMap()

        for(node in 1..N){
            times.filter { it[0] == node }.forEach {
                if(adjacencyList[node] == null){
                    adjacencyList[node] = mutableListOf<IntArray>()
                }
                adjacencyList[node]!!.add(intArrayOf(it[1],it[2]))
            }
        }

        fun updateSonTime(n: Int, time: Int) {

            if (n == K) {
                return
            }
            if (marks[n - 1] == -1) {
                marks[n - 1] = time
                //println(n)
                adjacencyList[n]?.forEach { updateSonTime(it[0], time + it[1]) }
            }
            if (marks[n - 1] != -1) {
                if (marks[n - 1] <= time) {
                    return
                } else {
                    marks[n - 1] = time
                    adjacencyList[n]?.forEach { updateSonTime(it[0], time + it[1]) }
                }
            }
        }

        marks[K - 1] = 0
        adjacencyList[K]?.forEach { updateSonTime(it[0], 0 + it[1]) }

        var longest = 0
        run loop@{
            marks.forEach {
                if (it == -1) {
                    longest = -1
                    return@loop
                }
                if (it > longest) {
                    longest = it
                }
            }
        }
        return longest
    }

}