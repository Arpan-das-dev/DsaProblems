package BitManipulation;

public class StepsToMakeOneBit {
    public int numSteps(String s) {
        if(s == null || s.isEmpty()) return 0;
        if(s.length() == 1 && (s.equals("0") || s.equals("1"))) return 0;

        int steps = 0;
        StringBuilder sb = new StringBuilder(s);
        while (!sb.toString().equals("1")){
            if(sb.charAt(sb.length()-1) == '0') {
                sb.deleteCharAt(sb.length()-1);
            }
            else {
                int len = sb.length()-1;
                while (len >= 0 && sb.charAt(len)== '1'){
                    sb.setCharAt(len,'0');
                    len--;
                }
                if(len >= 0) {
                    sb.setCharAt(len,'1');
                }
                else {
                    sb.insert(0,'1');
                }
            }
            steps++;
        }
        return steps;
    }
}
