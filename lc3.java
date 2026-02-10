import java.util.HashMap;
import java.util.Map;

public class lc3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int r = 0; r < s.length(); r++) {
            if(map.containsKey(s.charAt(r))) {
                l = Math.max(l, map.get(s.charAt(r))+1);
            }
            map.put(s.charAt(r), r);                
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
