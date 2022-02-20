class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> s = new Stack<>();
        int max_area = 0;
        int i=0;
        int tp,top_area;
        while(i<n){
            if(s.isEmpty() || heights[s.peek()]<=heights[i])
                s.push(i++);
            else{
                tp=s.peek();
                s.pop();
                top_area = heights[tp] * (s.isEmpty()?i:(i-s.peek()-1));
                if(max_area<top_area)
                    max_area=top_area;
            }
        }
        while(!s.isEmpty()){
            tp=s.peek();
            s.pop();
            top_area = heights[tp] * (s.isEmpty()?i:(i-s.peek()-1));
                if(max_area<top_area)
                    max_area=top_area;
            
        }
        return max_area;
    }
}