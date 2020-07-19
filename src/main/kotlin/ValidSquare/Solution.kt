package ValidSquare

import kotlin.math.pow

class Solution {
    fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {

        fun calcSquare(a: IntArray, b: IntArray): Int {
            return (a[0] - b[0]).toDouble().pow(2).toInt() + (a[1] - b[1]).toDouble().pow(2).toInt()
        }

        /**
         * 四边形端点依序为a，b，c，d，假定p1为a，首先找到对角点c
         */
        val a: IntArray = p1
        val b: IntArray
        val c: IntArray //对角点
        val d: IntArray
        val ab: Int
        val ac: Int
        val ad: Int
        val cb: Int
        val cd: Int

        val p12 = calcSquare(p1, p2)
        val p13 = calcSquare(p1, p3)
        val p14 = calcSquare(p1, p4)

        if (p12 == 0 || p13 == 0 || p14 == 0) {
            return false
        }

        if (p12 == p13) {
            b = p2
            ab = p12
            c = p4
            ac = p14
            d = p3
            ad = p13
        } else if (p12 == p14) {
            b = p2
            ab = p12
            c = p3
            ac = p13
            d = p4
            ad = p14
        } else if (p13 == p14) {
            b = p3
            ab = p13
            c = p2
            ac = p12
            d = p4
            ad = p14
        } else {
            return false
        }
        cb = calcSquare(c, b)
        cd = calcSquare(c, d)
        if (ac != ab * 2) {
            return false
        }
        if (ab != cb || ad != cd || ab!=ad) {
            return false
        }

        return true
    }
}