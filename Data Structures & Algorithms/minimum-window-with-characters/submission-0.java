class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c: t.toCharArray()){
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int have = 0, size = count.size();
        int minSize = Integer.MAX_VALUE;
        int lIndex = -1, rIndex = -1;


        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            window.put(c, window.getOrDefault(c, 0) + 1);

            if(count.containsKey(c) && 
            count.get(c).equals(window.get(c))){
                have++;
            }

            while(have == size){
                if((right - left + 1) < minSize){
                    minSize = right - left + 1;
                    lIndex = left;
                    rIndex = right;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                if(count.containsKey(leftChar) && window.get(leftChar) < count.get(leftChar)){
                    have--;
                }
                left++;
            }
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(lIndex, rIndex + 1);

        
    }
}
