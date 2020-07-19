package FloodFill

import org.junit.Test

class SolutionTest {

    @Test
    fun solutionTest(){
        val image = arrayOf(intArrayOf(0,0,0), intArrayOf(0,1,1))
        val result = Solution().floodFill(image, 1,1,1)
        println(result.toString())
        println("=======floodFill==========")
    }
}