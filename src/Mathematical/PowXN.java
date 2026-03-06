package Mathematical;

public class PowXN {
    public double myPow(double x, int n) {
        long pow = n;
        double result = 1.0;

        if(n < 0) {
            x = 1/x;
            pow = -pow;
        }

        while (pow > 0) {
            if((pow&1)==1) {
                result *= x;
            }
                x *= x;
                pow >>=1;
        }
        return result;
    }
}
