package SimilarTwoParts

import TreeNode

class Solution {
    fun similarTwoParts(root: TreeNode?): Int {

        val nodeSumList = mutableListOf<Pair<TreeNode, Int>>()

        fun getTreeSum(tn:TreeNode?):Int{
            if(tn == null){
                return 0
            }
            val sum = tn.`val` + getTreeSum(tn.left) + getTreeSum(tn.right)
            nodeSumList.add(Pair(tn, sum))
            return sum
        }

        val rootSum = getTreeSum(root)

        var v:Any? = null

        for(i in 0 until nodeSumList.size - 1){ //最后一个是头节点
            var vv = Math.abs(rootSum - nodeSumList[i].second * 2)
            if(v == null){
                v = vv
            }else{
                v = Math.min(v as Int, vv)
            }
            println(v)
        }
        return v as Int
    }
}