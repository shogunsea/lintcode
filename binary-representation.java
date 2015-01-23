public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public static String binaryRepresentation(String n) {
        // write your code here
        // split the function into two parts:
        // get the binary representation of decimal part
        // get the interger part.
        // first check if decimal part can be represented in
        // binary form, then do the integer part transformation.
        int len = n.length();
        if (len == 0) {
            return n;
        }

        String[] split = n.split("\\.");
        String decimalPart = decBinary(split[1]);
        if (decimalPart.equals("ERROR")) {
            return decimalPart;
        }

        String intPart = intBinary(split[0]);

        return decimalPart.equals("")? intPart : intPart + "." + decimalPart;
    }

    public static String decBinary(String num) {
        String n = "0." + num;
        double val = Double.parseDouble(n);
        StringBuilder sb = new StringBuilder();

        while (val != 0) {
            if (sb.length() > 32) {
                return "ERROR";
            }
            double r = val * 2;
            if (r >= 1) {
                sb.append(1);
                val = r - 1;
            } else {
                sb.append(0);
                val = r;
            }
        }

        return sb.toString();
    }

    public static String intBinary(String num) {
        // 5
        // 1 1  1
        // 101
        int i = Integer.parseInt(num);
        StringBuilder sb = new StringBuilder();
        int base = 1;
        int current = 0;
        while (current != i) {
            if ((i & base) != 0) {
                sb.append(1);
                current += base;
            } else {
                sb.append(0);
            }
            base = base << 1;
        }
        
        if (sb.length() == 0) {
            sb.append(0);
        }

        return sb.reverse().toString();

    }
}
