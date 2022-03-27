class Solution {
    class KeyComparator implements Comparator<Key> {
        public int compare(Key k1,Key k2){
            if(k1.freq<k2.freq)
                return 1;
            else if(k1.freq>k2.freq)
                return -1;
            else
                return 0;
        }
    }
    class Key {
        int freq;
        char ch;
        Key(int val,char c){
            freq=val;
            ch=c;
        }
    }
    public String reorganizeString(String s) {
        int count[] = new int[26];
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']++;
        PriorityQueue<Key> pq=new PriorityQueue<>(new KeyComparator());
        for(char c='a';c<='z';c++){
            if(count[c-'a']>0)
                pq.add(new Key(count[c-'a'],c));
        }
        Key prev=new Key(-1,'#');
        String ans ="";
        while(pq.size()!=0){
            Key current = pq.poll();
            ans=ans+current.ch;
            if(prev.freq>0)
                pq.add(prev);
            current.freq--;
            prev=current;  
        }
        if(s.length()==ans.length()) 
            return ans;
        else
            return "";
    }
}