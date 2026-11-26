class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] charMap = new int[26];

        for(char c: tasks){
            charMap[c - 'A']++;
        }


        Arrays.sort(charMap);

        int maxFreq = charMap[25];

        int idlePeriod = (maxFreq - 1) * n;

        for(int i = 24; i >= 0; i--){
            idlePeriod -= Math.min(charMap[i], maxFreq - 1);
        }


        return idlePeriod > 0 ? idlePeriod + tasks.length : tasks.length;
    }
}
