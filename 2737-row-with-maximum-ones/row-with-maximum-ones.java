class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxone=0;
        int rowindex=0;int count=0;
        for(int i=0;i<mat.length;i++){
            count = 0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1){
                    count++;
                }

            }
            if(maxone<count){
                maxone=count;
                rowindex=i;
                            }  
        }
        int[] arr= new int[2];
        arr[0] = rowindex; arr[1] = maxone;
        return arr;
    //    return new int[]{rowindex,maxone};
    }
}