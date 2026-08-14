class Solution {
    public int divide(int dividend, int divisor) {

        // Special overflow case
        if (dividend == Integer.MIN_VALUE &&
            divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Use long to safely handle Integer.MIN_VALUE
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long quotient = 0;

        while (a >= b) {

            long temp = b;
            long multiple = 1;

            // Double divisor using left shift
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            quotient += multiple;
        }

        if (negative) {
            quotient = -quotient;
        }

        return (int) quotient;
    }
}