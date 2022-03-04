class Solution {
    public int countCharacters(String[] words, String chars) {
        int hash[] = new int[26];
        for(char x : chars.toCharArray())
            hash[x-'a']++;
        int ans = 0;
        for(String curr : words){
            int seen[] = Arrays.copyOf(hash,hash.length);
            int internal = 0;
            for(char y : curr.toCharArray()) {
                if(seen[y-'a']>0){
                    seen[y-'a']--;
                    internal++;
                }
                else{
                    break;
                }
            }
            if(internal==curr.length())
                ans = ans+curr.length();
        }
        return ans;
    }
}