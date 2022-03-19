class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sl = s.length()-1;
        int tl = t.length()-1;
        int skipS=0,skipT=0;
        while(sl>=0 || tl>=0){
            while(sl>=0){
                if(s.charAt(sl)=='#'){
                    skipS++;
                    sl--;
                }
                else if(skipS>0){
                    skipS--;
                    sl--;
                }
                else
                 break;
            }
            while(tl>=0){
                if(t.charAt(tl)=='#'){
                    skipT++;
                    tl--;
                }
                else if(skipT>0){
                    skipT--;
                    tl--;
                }
                else
                 break;
            }
            if(sl>=0 && tl>=0 && s.charAt(sl)!=t.charAt(tl))
                return false;
            if((sl>=0)!=(tl>=0) )
                return false;
            sl--;
            tl--;
        }
        return true;
    }
}