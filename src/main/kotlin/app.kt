import SearchInsertPosition.Solution

fun main(){
    println("Hello world~")

    val a = Solution().searchInsert(intArrayOf(1,3,5,6), 7)
    println("=======searchInsert: ${a}==========")
    assert(a == 4){"Wrong insert position"}
}