public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex+1;
        List<Integer> mylist = new ArrayList<Integer>();
        int[][] matrix = new int[numRows][numRows];
        if (0 == numRows) return  mylist;
        matrix[0][0] = 1;
        if(1 == numRows) {
            mylist.add(matrix[0][0]);
            return  mylist;
        }
        for(int i = 1; i <numRows; i++){
            for(int j = 0; j<i+1; j++)
            {
                if(0 == j) {
                    matrix[i][j] = 1;
                }else{
                    matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
                }
            }
        }
        for(int i=0; i<numRows; i++)
        {
            mylist.add(matrix[numRows-1][i]);
        }
        return  mylist;
    }
}
