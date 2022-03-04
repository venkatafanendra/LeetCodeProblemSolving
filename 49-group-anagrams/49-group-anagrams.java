class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String current : strs){
            String ele = sort(current);
            if(!map.containsKey(ele)){
                List<String> temp = new ArrayList<>();
                temp.add(current);
                map.put(ele,temp);
            } 
            else {
                List<String> temp = map.get(ele);
                temp.add(current);
                map.put(ele,temp);
            }       
        }
        for(String es : map.keySet()) {
            List<String> temp = map.get(es);
            result.add(temp);
        }
        return result;
    }
    private String sort(String temp){
        char[] x = temp.toCharArray();
        Arrays.sort(x);
        return new String(x);
    }
}