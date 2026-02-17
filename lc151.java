public class lc151 {
    public String reverseWords(String s) {
        String[] array = s.trim().split("\\s+");
        List<String> list = Arrays.asList(array);
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for(String st:list){
            sb.append(st.strip()+" ");
        }
        return sb.toString().strip();
    }
}
