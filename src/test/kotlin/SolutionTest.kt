import FloodFill.Solution
import org.junit.Test

class SolutionTest {

    @Test
    fun solutionTest(){
        var image = arrayOf(intArrayOf(0,0,0), intArrayOf(0,1,1))
        var result = Solution().floodFill(image, 1,1,1)
        println(result.toString())
    }
}