class Solution {
    public int minOperations(String[] logs) {
        int level=0;
        for(String temp : logs){
            if(level>0 && temp.equals("../"))
                level--;
            else if(temp.charAt(0)!='.')
                level++;
        }
        return level;
    }
}