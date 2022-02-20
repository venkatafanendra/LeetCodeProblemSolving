class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int temp[] = new int[n];
        int maxAreaSoFar = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
               if(matrix[i][j]=='0')
                   temp[j]=0;
                else
                    temp[j]=temp[j]+(matrix[i][j]-'0');
            }
            int area = maxArea(temp);
            if(area>maxAreaSoFar)
                maxAreaSoFar=area;
        }
        return maxAreaSoFar;
    }
    private int maxArea(int[] rows) {
        int n = rows.length;
        Stack<Integer> s = new Stack<>();
        int max_area = 0;
        int i = 0;
        int tp ;
        int areaCalc ;
        while(i<n) {
            if(s.isEmpty() || rows[s.peek()]<=rows[i])
                s.push(i++);
            else {
                tp = s.peek();
                s.pop();
                areaCalc = rows[tp] * (s.isEmpty() ? i : (i-s.peek()-1));
                if(areaCalc>max_area)
                    max_area=areaCalc;
            }
        }
        while(!s.isEmpty()){
            tp = s.peek();
            s.pop();
            areaCalc = rows[tp] * (s.isEmpty() ? i : (i-s.peek()-1));
            if(areaCalc>max_area)
                max_area=areaCalc;
        }
        return max_area;  
    }
}