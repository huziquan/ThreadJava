package LeeCode;

public class Solution537 {
    public String complexNumberMultiply(String num1, String num2) {
        String[] numA=num1.split("\\+|i");
        String[] numB=num2.split("\\+|i");
        int numA1 = Integer.parseInt(numA[0]);
        int numA2 = Integer.parseInt(numA[1]);
        int numB1 = Integer.parseInt(numB[0]);
        int numB2 = Integer.parseInt(numB[1]);
        String comNum = String.format("%d+%di",numA1*numB1-numA2*numB2,numA1*numB2+numB1*numA2);
        return comNum;
    }
}
