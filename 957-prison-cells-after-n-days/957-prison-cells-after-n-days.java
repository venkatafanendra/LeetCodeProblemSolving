class Solution {
    public int[] prisonAfterNDays(int[] cell, int n) {
        int len = cell.length;
        HashSet<String> set = new HashSet<>();
        int cycle=0;
        boolean hasCycle = false;
        for(int i=1;i<=n;i++){
            int next[] = nextDay(cell);
            String current = Arrays.toString(next);
            if(!set.contains(current)){
                cycle++;
                set.add(current);
            }
            else {
                hasCycle = true;
                break;
            }
            cell = next;
        }
        if(hasCycle){
            n=n%cycle;
            for(int i=0;i<n;i++)
                cell=nextDay(cell);
        }
        return cell;
    }
    private int[] nextDay(int[] cell) {
        int[] temp = new int[cell.length];
        for(int i=1;i<cell.length-1;i++){
            if((cell[i-1]==1 && cell[i+1]==1) || (cell[i-1]==0 && cell[i+1]==0) )
                temp[i]=1;
        }
        return temp;
    }
}