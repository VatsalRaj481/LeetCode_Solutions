class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=9;
        HashSet<Character>[] rows=new HashSet[n];
        HashSet<Character>[] cols=new HashSet[n];
        HashSet<Character>[] boxes=new HashSet[n];

        for(int r=0;r<n;r++){
            rows[r]=new HashSet<Character>();
            cols[r]=new HashSet<Character>();
            boxes[r]=new HashSet<Character>();
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++){
                char val =board[i][j];
                if(val=='.')
                {
                    continue;
                }
                if(rows[i].contains(val))
                {
                    return false;
                }
                rows[i].add(val);
                if(cols[j].contains(val))
                {
                    return false;
                }
                cols[j].add(val);

                int idx=(i/3)*3+(j/3);
                if(boxes[idx].contains(val)){
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}