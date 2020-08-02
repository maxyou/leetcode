package SimilarTwoParts

import org.junit.Test
import java.util.*

class SolutionTest {
    @Test
    fun solutionTest() {

        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null
            override fun toString(): String {
                return "[${`val`.toString()} l:${left.toString()} r:${right.toString()}]"
            }
        }

        fun anyArray2TreeNode(nums:Array<Any?>):TreeNode?{

            println("nums are ${Arrays.toString(nums)}")

            var rootTreeNode:TreeNode? = null
            val queue: Queue<Pair<TreeNode, Int>> = LinkedList()

            nums.forEach {
                if(queue.size == 0){
                    if(it is Int){
                        rootTreeNode = TreeNode(it)
                        queue.offer(Pair(rootTreeNode!!, 0))
                        queue.offer(Pair(rootTreeNode!!, 1))
                    }else{
                        return null
                    }
                }else{
                    if(it is Int){
                        val node = TreeNode(it)
                        queue.offer(Pair(node, 0))
                        queue.offer(Pair(node, 1))
                        val upper = queue.poll()
                        if(upper.second == 0){
                            upper.first.left = node
                        }else{
                            upper.first.right = node
                        }
                    }else{
                        queue.poll()
                    }
                }

            }
            return rootTreeNode
        }

        var a = anyArray2TreeNode(arrayOf(1,3, 5, null, 7, 9))

        println(a)

//        val result = Solution().similarTwoParts( )
//        println(result.toString())
        println("=======similarTwoParts==========")
    }
}