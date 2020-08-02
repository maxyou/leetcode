package FindModeInBinarySearchTree

import TreeNode


class Solution {

//    class TreeNode(var `val`: Int) {
//        var left: TreeNode? = null
//        var right: TreeNode? = null
//    }

    fun findMode(root: TreeNode?): IntArray {

        if(root == null){
            return intArrayOf()
        }

        var resultMap:MutableMap<Int, Int> = mutableMapOf()

        fun searchSortTree(tn:TreeNode){

            resultMap.put(tn.`val`, if(resultMap[tn.`val`]==null) 1 else resultMap[tn.`val`]!!+1)

            if(tn.left != null){
                searchSortTree(tn.left!!)
            }
            if(tn.right != null){
                searchSortTree(tn.right!!)
            }
        }

        searchSortTree(root)

        println(resultMap)

        var max = resultMap.values.max()
        return resultMap.keys.filter { resultMap[it] == max }.toIntArray()
    }
}