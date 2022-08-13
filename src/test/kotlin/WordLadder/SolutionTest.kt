package WordLadder

import org.junit.Test

class SolutionTest {
        @Test
    fun solutionTest(){
        val result = Solution().ladderLength("", "", listOf<String>("",""))
        println(result)
        println("=======ladderLength==========")
    }
}