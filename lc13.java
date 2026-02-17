import java.util.HashMap;

public class lc13 {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);map.put('V',5);map.put('X',10);map.put('L',50);map.put('C',100);map.put('D',500);map.put('M',1000);
        int prev = -1;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(prev==-1){
                res+= map.get(s.charAt(i));
            }
            else if(prev<(map.get(s.charAt(i)))){
                res += (map.get(s.charAt(i))-2*prev);
            }else{
                res+=map.get(s.charAt(i));
            }
            prev = map.get(s.charAt(i));
        }
        return res;
    }
}
