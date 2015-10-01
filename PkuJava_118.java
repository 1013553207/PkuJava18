public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> mylist = new ArrayList<List<Integer>>();
        if(0 == numRows) return mylist;
        int[][] matrix = new int[numRows][numRows];
        matrix[0][0] = 1;
        List<Integer> zero_list = new ArrayList<Integer>();
        zero_list.add(matrix[0][0]);
        mylist.add(zero_list);
        for(int i = 1; i <numRows; i++){
            List<Integer> tmp = new ArrayList<Integer>();
            for(int j = 0; j<i+1; j++)
            {
                if(0 == j) {
                    matrix[i][j] = 1;
                    tmp.add(matrix[i][j]);
                }else{
                    matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
                    tmp.add(matrix[i][j]);
                }
            }
            mylist.add(tmp);
        }
        return mylist;
        
    }
}
