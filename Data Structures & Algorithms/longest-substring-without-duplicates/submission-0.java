class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> charSet = new HashSet<>();
        int max = 0;

        int left = 0;
        int right = 0;

        while(right < s.length()){

            if(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left++));
                continue;
            }
            charSet.add(s.charAt(right++));
            max = Math.max(max, charSet.size());
        }
        
        return max;

        
    }
}
