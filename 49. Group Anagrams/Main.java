class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        
        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a'] += 1;
            }

            StringBuilder sb = new StringBuilder();
            for(int num:count){
                sb.append(num).append("#");
            }
            String key = sb.toString();
            System.out.println(key);
            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList<String>());
            }
            ans.get(key).add(str);
        }

        return new ArrayList<>(ans.values());
        
    }
}
