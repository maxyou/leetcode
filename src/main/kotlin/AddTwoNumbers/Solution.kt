package AddTwoNumbers

class Solution {

    class ListNode(val `val`:Int){
        var next:ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        var retRoot: ListNode = ListNode(-1)

        var m1:ListNode? = l1
        var m2:ListNode? = l2
        var m3:ListNode = retRoot
        var carry = 0

        while(true){
            if(m1 == null && m2 == null && carry == 0){ break }

            var v1 = if(m1 != null) m1.`val` else 0
            var v2 = if(m2 != null) m2.`val` else 0

            var v3 = v1 + v2 + carry
            if(v3 > 9){
                v3 = v3 - 10
                carry = 1
            }else{
                carry = 0
            }

            m3.next = ListNode(v3)
            m3 = m3.next as ListNode

            m1 = m1?.next
            m2 = m2?.next
        }
        return retRoot.next
    }

}