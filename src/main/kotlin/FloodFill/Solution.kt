package FloodFill

class Solution {

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {

        var oldColor = image[sr][sc]

        fun fillPointRecursion(sr: Int, sc: Int){

            image[sr][sc] = -1

            if(sr>0 && image[sr-1][sc] == oldColor){
                fillPointRecursion(sr - 1, sc)
            }
            if(sc>0 && image[sr][sc-1] == oldColor){
                fillPointRecursion(sr, sc-1)
            }
            if(sr<image.size-1 && image[sr+1][sc] == oldColor){
                fillPointRecursion(sr + 1, sc)
            }
            if(sc<image[0].size-1 && image[sr][sc+1] == oldColor){
                fillPointRecursion(sr, sc+1)
            }
        }

        fillPointRecursion(sr, sc)

        for(i in image.indices){
            for(j in image[i].indices){
                if(image[i][j] == -1){
                    image[i][j] = newColor
                }
            }
        }

        return image
    }

}