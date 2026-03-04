package Simulation;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int l1 = num1.length();
        int l2 = num2.length();

        int[] products = new int[l1+l2];

        for (int i = l1-1; i >= 0 ; i--) {
            int a = num1.charAt(i)-'0';
            for (int j = l2-1; j >= 0 ; j--) {
                int b = num2.charAt(j) - '0';

                int product = a * b;

                int high = i+j;
                int low = i+j+1;

                int sum = products[low]+product;

                products[low] = sum % 10;
                products[high] += sum/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : products) {
            if (!(sb.isEmpty() && num == 0)) {
                sb.append(num);
            }
        }
        return sb.toString();
    }
}
