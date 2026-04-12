package DynamicProgramming;

public class Tribonacci {
    public int tribonacciRecursion(int n) {
        if(n == 0) return 0;
        if(n <= 2) return 1;
        return  tribonacciRecursion(n-1)+ tribonacciRecursion(n-2)+tribonacciRecursion(n-3);
    }
    public int tribonacciExtraSpaceDp(int n) {
        if(n == 0) return 0;
        if(n >= 1 && n <=2) return 1;

        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2]+ dp[i-3] ;
        }
        return dp[n];
    }

    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n <= 2) return 1;

        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int sum = a+b+c;
            a = b;
            b = c;
            c = sum;
        }
        return c;
    }
}
