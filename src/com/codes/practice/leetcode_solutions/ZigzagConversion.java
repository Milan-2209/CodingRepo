package src.com.codes.practice.leetcode_solutions;

public class ZigzagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int rows = 3;
        System.out.println(convertToZigZag(s,rows));
    }

    private static String convertToZigZag(String s, int r) {
        if(r==1)
            return s;
        String res = "";
        for(int i=0; i<r ; i++){
            int increment = 2 * (r - 1);
            for(int j=i;j<s.length();j+=increment){
                res+=s.charAt(j);
                if(i > 0 && i < r-1 && j+increment-2*i < s.length())
                    res+=s.charAt(j+increment-2*i);
            }
        }
        return res;
    }
}
