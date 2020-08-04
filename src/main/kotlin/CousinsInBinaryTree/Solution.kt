package CousinsInBinaryTree

import TreeNode
import java.util.*

class Solution {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {

        val queue: Queue<Triple<TreeNode, Int, Int>> = LinkedList()

        var parentOfX:Int = -1
        var levelOfX:Int = -1
        var parentOfY:Int = -2
        var levelOfY:Int = -2
        fun traversal(node:TreeNode, parent:Int, level: Int){

            if(node.`val` == x){
                parentOfX = parent
                levelOfX = level
            }else if(node.`val` == y){
                parentOfY = parent
                levelOfY = level
            }

            if(node.left != null){
                traversal(node.left!!, node.`val`, level+1)
            }
            if(node.right != null){
                traversal(node.right!!, node.`val`, level+1)
            }
        }

        if(root == null){
            return false
        }
        traversal(root, -1, 0)

        println(levelOfX)
        println(levelOfY)
        println(parentOfX)
        println(parentOfY)

        if((levelOfX == levelOfY) && (parentOfX != parentOfY)){
            return true
        }
        return false
    }
}