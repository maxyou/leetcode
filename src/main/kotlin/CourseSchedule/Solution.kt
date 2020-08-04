package CourseSchedule

import java.util.*

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        /**
         * 给定0~n-1，其中某些数字存在先决数字，判断这些先决数字是否构成环
         */
        class Adj(val `val`: Int) {
            var dependencies = mutableListOf<Int>()
            var ring: Int = -1 //-1表示未知，0表示不存在先决环，1表示存在先决环
        }

        val adjArray = Array(numCourses) { i -> Adj(i) }

        prerequisites.forEach {
            adjArray[it[0]].dependencies.add(it[1])
        }

        fun recurseAdj(a: Adj, path:Deque<Int>): Int {
//            println("recurseAdj(${a.`val`})")
            if (a.ring != -1) {
                return a.ring
            }
            if (a.dependencies.size == 0) {
                a.ring = 0
                return a.ring
            }
            val ifImInRing = path.indexOfFirst { it == a.`val` }
            if(ifImInRing >= 0){
                a.ring = 1
                return a.ring
            }
//            println("loop dependencies...")
            path.push(a.`val`)
            a.ring = if (a.dependencies.indexOfFirst {
//                    println(it)
                    recurseAdj(adjArray[it], path) == 1
                } >= 0) 1 else 0
            path.pop()
            return a.ring
        }

        return adjArray.indexOfFirst { recurseAdj(it, ArrayDeque<Int>()) == 1 } < 0
    }
}